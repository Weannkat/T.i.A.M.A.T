package quality_Assessment;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Rules {
	private final Map<JTextField, Integer> fieldWeights; // To store weights for each JTextField
	private final Map<JComboBox<String>, Integer> dropdownWeights; // To store weights for each JComboBox
	private final Map<JCheckBox, Integer> browserWeights; // To store weights for each JCheckBox
	private final Map<JTextField, Boolean> mandatoryFields; // To track mandatory JTextFields
	private final Map<JComboBox, String> mandatoryComboBoxes;
	private final int threshold; // Minimum score to pass

	public Rules(int threshold) {
		this.fieldWeights = new HashMap<>();
		this.dropdownWeights = new HashMap<>();
		this.browserWeights = new HashMap<>();
		this.mandatoryFields = new HashMap<>();
		this.mandatoryComboBoxes = new HashMap<>();
		this.threshold = threshold;
	}

	// Add weights for JTextFields
	public void addFieldWeight(JTextField field, int weight) {
		fieldWeights.put(field, weight);
	}

	// Mark a JTextField as mandatory
	public void addMandatoryField(JTextField field) {
		mandatoryFields.put(field, true);
	}

	// Mark a JComboBox as mandatory
	public void addMandatoryComboBox(JComboBox<String> comboBox, String defaultOption) {
		mandatoryComboBoxes.put(comboBox, defaultOption);
	}

	// Add weights for JComboBoxes
	public void addDropdownWeight(JComboBox<String> dropdown, int weight) {
		dropdownWeights.put(dropdown, weight);
	}

	// Add JCheckBoxes for browsers
	public void addBrowserWeight(JCheckBox browser, int weight) {
		browserWeights.put(browser, weight);
	}

	// Calculate total score
	public int calculateScore() {
		int totalScore = 0;

		// Check JTextFields
		for (Map.Entry<JTextField, Integer> entry : fieldWeights.entrySet()) {
			JTextField field = entry.getKey();
			int weight = entry.getValue();
			String value = field.getText().trim();

			if (!value.isEmpty() && !value.equalsIgnoreCase("unknown") && !value.contains("Please provide")
					&& !value.contains("e.g") && !value.contains("...") && !value.contains("YYYYMMDD")
					&& !value.equalsIgnoreCase("not known") && !value.contains("wgs84:lat  + wgs84:long + geo:asWKT")
					&& !value.contains("Please express in geosparql spatial coordinates")) {
				totalScore += weight;
			}
		}

		// Check JComboBoxes
		for (Map.Entry<JComboBox<String>, Integer> entry : dropdownWeights.entrySet()) {
			JComboBox<String> dropdown = entry.getKey();
			int weight = entry.getValue();

			if (dropdown.getSelectedIndex() > 0) { // Ensure something other than the default is selected
				totalScore += weight;
			}
		}

		// Check JCheckBoxes for browsers
		boolean browserSelected = false;
		for (JCheckBox checkBox : browserWeights.keySet()) {
			if (checkBox.isSelected()) {
				browserSelected = true;
				break; // Only one point regardless of how many are selected
			}
		}
		if (browserSelected) {
			totalScore += 1; // Add one point if at least one browser is selected
		}

		return totalScore;
	}

	// Check if mandatory fields are filled
	private boolean areMandatoryFieldsFilled() {
		for (Map.Entry<JTextField, Boolean> entry : mandatoryFields.entrySet()) {
			JTextField field = entry.getKey();
			if (entry.getValue() && field.getText().trim().isEmpty()
					|| entry.getValue() && field.getText().trim().contains("Please provide")
					|| entry.getValue() && field.getText().trim().contains("YYYYMMDD")
					|| entry.getValue() && field.getText().trim().equalsIgnoreCase("unknown")
					|| entry.getValue() && field.getText().trim().equalsIgnoreCase("not known")
					|| entry.getValue() && field.getText().trim().equalsIgnoreCase("e.g.")) {
				return false; // Mandatory field is empty
			}
		}
		for (Map.Entry<JComboBox, String> entry : mandatoryComboBoxes.entrySet()) {
			JComboBox comboBox = entry.getKey();
			String defaultOption = entry.getValue();
			if (comboBox.getSelectedItem() == null
					|| comboBox.getSelectedItem().toString().trim().equals(defaultOption)) {
				return false; // Mandatory combo box is not properly filled
			}
		}

		return true;
	}

	// Check if the threshold is met
	public boolean isThresholdMet() {
		return areMandatoryFieldsFilled() && calculateScore() >= threshold;
	}

	// clear
	public void clear() {
		fieldWeights.clear();
		dropdownWeights.clear();
		browserWeights.clear();
		mandatoryFields.clear();
	}

	// Generate feedback message
	public String getFeedbackMessage() {
		if (!areMandatoryFieldsFilled()) {
			return "One or more mandatory fields are missing (grey). Please fill out all required fields. Toggle Score to gain more information regarding the mandatory fields.";
		}
		if (calculateScore() < threshold) {
			return "The model is not suitable. Minimum threshold not met.";
		}
		return "The model is suitable for the selected use case.-";
	}

}