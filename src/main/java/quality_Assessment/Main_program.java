package quality_Assessment;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONObject;

public class Main_program extends JFrame implements ActionListener {

	private JComboBox<String> cmbUseCase;
	private JPanel cardPanel; // Panel with CardLayout
	private CardLayout cardLayout;
	private JTextArea log;
	private Rules videoRules;
	private Rules arvrRules;
	private Rules mobileRules;
	private Rules educationalRules;
	private JButton btnCheckSuitabilityVideo;
	private JButton btnCheckSuitabilityARVR;
	private JButton btnCheckSuitabilityMobile;
	private JButton btnCheckSuitabilityEducational;
	private JButton btnExportVideo;
	private JButton btnExportARVR;
	private JButton btnExportMobile;
	private JButton btnExportEducational;
	private JButton btnExportWithScoreVideo;
	private JButton btnExportWithScoreARVR;
	private JButton btnExportWithScoreMobile;
	private JButton btnExportWithScoreEducational;
	private JButton btnImportVideo;
	private JButton btnImportARVR;
	private JButton btnImportMobile;
	private JButton btnImportEducational;
	private String currentPanel; // track the currently active Panel
	private HashMap<String, JTextField[]> panelFieldGroups = new HashMap<>();
	StringBuilder selectedBrowsers = new StringBuilder();
	private HashMap<String, JTextField> videoFieldMap = new HashMap<>();
	private HashMap<String, JTextField> arvrFieldMap = new HashMap<>();
	private HashMap<String, JTextField> mobileFieldMap = new HashMap<>();
	private HashMap<String, JTextField> educationalFieldMap = new HashMap<>();
	private HashMap<String, JComboBox<String>> videoComboBoxMap = new HashMap<>();
	private HashMap<String, JComboBox<String>> arvrComboBoxMap = new HashMap<>();
	private HashMap<String, JComboBox<String>> mobileComboBoxMap = new HashMap<>();
	private HashMap<String, JComboBox<String>> educationalComboBoxMap = new HashMap<>();
	private JCheckBox[] cbSupportedBrowsers;
	private boolean tiamatApproved = true;

	private JTextField tfObjectNameVideo;
	private JTextField tfObjectNameARVR;
	private JTextField tfObjectNameMobile;
	private JTextField tfObjectNameEducational;
	private JTextField tfSurveyObjectVideo;
	private JTextField tfSurveyObjectARVR;
	private JTextField tfSurveyObjectMobile;
	private JTextField tfSurveyObjectEducational;
	private JTextField tfSurveyLinkVideo;
	private JTextField tfSurveyLinkARVR;
	private JTextField tfSurveyLinkMobile;
	private JTextField tfSurveyLinkEducational;
	private JTextField tfAcquisitionLocationVideo;
	private JTextField tfAcquisitionLocationARVR;
	private JTextField tfAcquisitionLocationMobile;
	private JTextField tfAcquisitionLocationEducational;
	private JTextField tfProcessingSoftwareVideo;
	private JTextField tfProcessingSoftwareARVR;
	private JTextField tfProcessingSoftwareMobile;
	private JTextField tfProcessingSoftwareEducational;
	private JTextField tfProcessedTexturedMeshTextureSetVideo;
	private JTextField tfProcessedTexturedMeshTextureSetARVR;
	private JTextField tfProcessedTexturedMeshTextureSetMobile;
	private JTextField tfProcessedTexturedMeshTextureSetEducational;
	private JTextField tfModelling_ModifyingDescriptionVideo;
	private JTextField tfModelling_ModifyingDescriptionMobile;
	private JTextField tfModelling_ModifyingDescriptionEducational;
	private JTextField tfTridimensionalDigitalTwinVideo;
	private JTextField tfTridimensionalDigitalTwinARVR;
	private JTextField tfTridimensionalDigitalTwinMobile;
	private JTextField tfTridimensionalDigitalTwinEducational;
	private JTextField tfTridimensionalDigitalTwinDigitalScaleVideo;
	private JTextField tfTridimensionalDigitalTwinDigitalScaleARVR;
	private JTextField tfTridimensionalDigitalTwinDigitalScaleMobile;
	private JTextField tfTridimensionalDigitalTwinDigitalScaleEducational;
	private JTextField tfFinalPurpose;
	private JTextField tfExported3DModelVideoRendering;
	private JTextField tfExporting_EditingRenderingVideo;
	private JTextField tfExporting_EditingRenderingVideoSoftware;
	private JTextField tfExportedVideo3DRendering;
	private JTextField tfVideoResolution;
	private JTextField tfVideoDuration;
	private JTextField tfExportedAR3DModelARVR;
	private JTextField tfExportedAR3DModelMobile;
	private JTextField tfExportedAR3DModelEducational;
	private JTextField tfExporting_ARMRProjectImplementation;
	private JTextField tfARMRImplementationSoftware;
	private JTextField tfARVRDescription;
	private JTextField tfARVRTitle;
	private JTextField tfARVRPlatform;
	private JTextField tfARVRCoordinates;
	private JTextField tfAcquisitionDateMobile;
	private JTextField tfAcquisitionDateEducational;
	private JTextField tfProcessedDensifiedPointCloud;
	private JTextField tfEducationalPlatformServerWeb;
	private JTextField tfEducationalPlatformURL;
	private JTextField tfSelectedBrowsers;
	private JTextField tfGeorefVideo;
	private JTextField tfGeorefARVR;
	private JTextField tfMeshNumberVideo;
	private JTextField tfMeshNumberARVR;

	private JComboBox<String> cmbMatchingAlgorithmVideo;
	private JComboBox<String> cmbMeshingAlgorithmVideo;
	private JComboBox<String> cmbMatchingAlgorithmARVR;
	private JComboBox<String> cmbMeshingAlgorithmARVR;
	private JComboBox<String> cmbMatchingAlgorithmMobile;
	private JComboBox<String> cmbMeshingAlgorithmMobile;
	private JComboBox<String> cmbMatchingAlgorithmEducational;
	private JComboBox<String> cmbMeshingAlgorithmEducational;
	private JComboBox<String> cmbARVRCategory;
	private JComboBox<String> cmbMobileApplicationOperationalSystem;
	private JComboBox<String> cmbVideoFormat;
	private JComboBox<String> cmbAcquistionScaleObjectTypeMobile;
	private JComboBox<String> cmbAcquistionScaleObjectTypeEducational;
	private JComboBox<String> cmbProgrammingLanguage;
	private JComboBox<String> cmbOrientationVideo;
	private JComboBox<String> cmbOrientationARVR;

	private HashMap<String, String> definitions;

	public Main_program(String s) {
		super(s);
		initializeDefinitions();
		initializeFields();
		initializeFieldMaps();
		initializeFieldGroups();
		makeGUI();
		initializeRules();

	}

	private void initializeFields() {
		tfObjectNameVideo = new JTextField();
		tfObjectNameARVR = new JTextField();
		tfObjectNameMobile = new JTextField();
		tfObjectNameEducational = new JTextField();
		tfSurveyObjectVideo = new JTextField();
		tfSurveyObjectVideo.setToolTipText("Please provide a complete URL");
		tfSurveyObjectARVR = new JTextField();
		tfSurveyObjectARVR.setToolTipText("Please provide a complete URL");
		tfSurveyObjectMobile = new JTextField();
		tfSurveyObjectMobile.setToolTipText("Please provide a complete URL");
		tfSurveyObjectEducational = new JTextField();
		tfSurveyObjectEducational.setToolTipText("Please provide a complete URL");
		tfSurveyLinkVideo = new JTextField();
		tfSurveyLinkVideo.setToolTipText("Please provide a complete URL");
		tfSurveyLinkARVR = new JTextField();
		tfSurveyLinkARVR.setToolTipText("Please provide a complete URL");
		tfSurveyLinkMobile = new JTextField();
		tfSurveyLinkMobile.setToolTipText("Please provide a complete URL");
		tfSurveyLinkEducational = new JTextField();
		tfSurveyLinkEducational.setToolTipText("Please provide a complete URL");
		tfAcquisitionLocationVideo = new JTextField();
		tfAcquisitionLocationVideo.setToolTipText("https://www.openstreetmap.org/... ");
		tfAcquisitionLocationARVR = new JTextField();
		tfAcquisitionLocationARVR.setToolTipText("https://www.openstreetmap.org/... ");
		tfAcquisitionLocationMobile = new JTextField();
		tfAcquisitionLocationMobile.setToolTipText("https://www.openstreetmap.org/... ");
		tfAcquisitionLocationEducational = new JTextField();
		tfAcquisitionLocationEducational.setToolTipText("https://www.openstreetmap.org/... ");
		tfProcessingSoftwareVideo = new JTextField();
		tfProcessingSoftwareVideo.setToolTipText("e.g.: Zephyr Open Flow 1.3");
		tfProcessingSoftwareARVR = new JTextField();
		tfProcessingSoftwareARVR.setToolTipText("e.g.: Zephyr Open Flow 1.3");
		tfProcessingSoftwareMobile = new JTextField();
		tfProcessingSoftwareMobile.setToolTipText("e.g.: Zephyr Open Flow 1.3");
		tfProcessingSoftwareEducational = new JTextField();
		tfProcessingSoftwareEducational.setToolTipText("e.g.: Zephyr Open Flow 1.3");
		tfProcessedTexturedMeshTextureSetVideo = new JTextField();
		tfProcessedTexturedMeshTextureSetVideo.setToolTipText("Please provide a complete URL");
		tfProcessedTexturedMeshTextureSetARVR = new JTextField();
		tfProcessedTexturedMeshTextureSetARVR.setToolTipText("Please provide a complete URL");
		tfProcessedTexturedMeshTextureSetMobile = new JTextField();
		tfProcessedTexturedMeshTextureSetMobile.setToolTipText("Please provide a complete URL");
		tfProcessedTexturedMeshTextureSetEducational = new JTextField();
		tfProcessedTexturedMeshTextureSetEducational.setToolTipText("Please provide a complete URL");
		tfModelling_ModifyingDescriptionVideo = new JTextField();
		tfModelling_ModifyingDescriptionMobile = new JTextField();
		tfModelling_ModifyingDescriptionEducational = new JTextField();
		tfTridimensionalDigitalTwinVideo = new JTextField();
		tfTridimensionalDigitalTwinVideo.setToolTipText("Please provide a complete URL");
		tfTridimensionalDigitalTwinARVR = new JTextField();
		tfTridimensionalDigitalTwinARVR.setToolTipText("Please provide a complete URL");
		tfTridimensionalDigitalTwinMobile = new JTextField();
		tfTridimensionalDigitalTwinMobile.setToolTipText("Please provide a complete URL");
		tfTridimensionalDigitalTwinEducational = new JTextField();
		tfTridimensionalDigitalTwinEducational.setToolTipText("Please provide a complete URL");
		tfTridimensionalDigitalTwinDigitalScaleVideo = new JTextField();
		tfTridimensionalDigitalTwinDigitalScaleVideo.setToolTipText("e.g: 22mm x 18mm x 37mm");
		tfTridimensionalDigitalTwinDigitalScaleARVR = new JTextField();
		tfTridimensionalDigitalTwinDigitalScaleARVR.setToolTipText("e.g: 22mm x 18mm x 37mm");
		tfTridimensionalDigitalTwinDigitalScaleMobile = new JTextField();
		tfTridimensionalDigitalTwinDigitalScaleMobile.setToolTipText("e.g: 22mm x 18mm x 37mm");
		tfTridimensionalDigitalTwinDigitalScaleEducational = new JTextField();
		tfTridimensionalDigitalTwinDigitalScaleEducational.setToolTipText("e.g: 22mm x 18mm x 37mm");
		tfFinalPurpose = new JTextField();
		tfExported3DModelVideoRendering = new JTextField();
		tfExported3DModelVideoRendering.setToolTipText("Please provide a complete URL");
		tfExporting_EditingRenderingVideo = new JTextField();
		tfExporting_EditingRenderingVideo.setToolTipText(
				"e.g.: Cutting segments of the 3D rendering video to create a more concise presentation for a seminar. Adding background music and transitions to the video of a 3D model for promotional purposes.");
		tfExporting_EditingRenderingVideoSoftware = new JTextField();
		tfExporting_EditingRenderingVideoSoftware.setToolTipText("e.g.: VideoPad Video Editor 1.4.2");
		tfExportedVideo3DRendering = new JTextField();
		tfExportedVideo3DRendering
				.setToolTipText("e.g.: https://drive.google.com/drive/folders/1We6XaelsfiAVpV2p7SYps-hb_bK7p31g");
		tfVideoResolution = new JTextField();
		tfVideoResolution.setToolTipText("e.g: 1920 x 1080");
		tfVideoDuration = new JTextField();
		tfVideoDuration.setToolTipText(
				"e.g: PT1H30M45S (for a video of 1 hour, 30 minutes and 45 seconds  for more info: https://www.w3schools.com/xml/schema_dtypes_date.asp");
		tfExportedAR3DModelARVR = new JTextField();
		tfExportedAR3DModelARVR.setToolTipText(
				"e.g.: https://sketchfab.com/3d-models/yaioi-boar-jaw-3136f87dde21439c953f62d2e19293d4");
		tfExportedAR3DModelMobile = new JTextField();
		tfExportedAR3DModelMobile.setToolTipText(
				"e.g.: https://umorf.ummp.lsa.umich.edu/wp/wp-content/3d/viewer.html?name=1484&extension=ctm ");
		tfExportedAR3DModelEducational = new JTextField();
		tfExportedAR3DModelEducational.setToolTipText(
				"e.g.: https://sketchfab.com/3d-models/yaioi-boar-jaw-3136f87dde21439c953f62d2e19293d4");
		tfExporting_ARMRProjectImplementation = new JTextField();
		tfExporting_ARMRProjectImplementation
				.setToolTipText("e.g.: model exported as FBX and uploaded in Unity project");
		tfARMRImplementationSoftware = new JTextField();
		tfARMRImplementationSoftware.setToolTipText("e.g.: Unity 2019.4.28f1 (64-bit)");
		tfARVRDescription = new JTextField();
		tfARVRDescription.setToolTipText(
				"e.g.: Project BeaVir for Izumo Exhibition at the Archaeological museum of Izumo from 7/10/2022 to 4/12/2022");
		tfARVRTitle = new JTextField();
		tfARVRTitle.setToolTipText("e.g. : 10.1007/978-3-031-44751-8_ ");
		tfARVRPlatform = new JTextField();
		tfARVRPlatform.setToolTipText("e.g.: Meta Quest 2 ");
		tfARVRCoordinates = new JTextField();
		tfARVRCoordinates.setToolTipText("wgs84:lat  + wgs84:long + geo:asWKT");
		tfAcquisitionDateMobile = new JTextField();
		tfAcquisitionDateMobile.setToolTipText("YYYYMMDD");
		tfAcquisitionDateEducational = new JTextField();
		tfAcquisitionDateEducational.setToolTipText("YYYYMMDD");
		tfProcessedDensifiedPointCloud = new JTextField();
		tfEducationalPlatformServerWeb = new JTextField();
		tfEducationalPlatformURL = new JTextField();
		tfEducationalPlatformURL.setToolTipText("e.g.: https://vr.bearchaeo.unito.it/ ");
		tfSelectedBrowsers = new JTextField();
		tfGeorefVideo = new JTextField();
		tfGeorefVideo.setToolTipText("Please express in geosparql spatial coordinates");
		tfGeorefARVR = new JTextField();
		tfGeorefARVR.setToolTipText("Please express in geosparql spatial coordinates");
		tfMeshNumberVideo = new JTextField();
		tfMeshNumberARVR = new JTextField();

		cmbMatchingAlgorithmVideo = new JComboBox<>(
				new String[] { "Select a Matching Algorithm", "Structure from Motion (SfM) (or type of)",
						"Multi-View Stereo (MVS) (or type of)", "Depth Map Fusion (or type of)",
						"Epipolar Geometry-based Matching (or type of)", "Semi-Global Matching (SGM) (or type of)",
						"Voxel-based Reconstruction (or type of)", "Deep Learning-based Depth Estimation (or type of)",
						"Graph-cut and Graph-based Matching (or type of)", "Other", "Unknown" });
		cmbMatchingAlgorithmARVR = new JComboBox<>(
				new String[] { "Select a Matching Algorithm", "Structure from Motion (SfM) (or type of)",
						"Multi-View Stereo (MVS) (or type of)", "Depth Map Fusion (or type of)",
						"Epipolar Geometry-based Matching (or type of)", "Semi-Global Matching (SGM) (or type of)",
						"Voxel-based Reconstruction (or type of)", "Deep Learning-based Depth Estimation (or type of)",
						"Graph-cut and Graph-based Matching (or type of)", "Other", "Unknown" });
		cmbMatchingAlgorithmMobile = new JComboBox<>(
				new String[] { "Select a Matching Algorithm", "Structure from Motion (SfM) (or type of)",
						"Multi-View Stereo (MVS) (or type of)", "Depth Map Fusion (or type of)",
						"Epipolar Geometry-based Matching (or type of)", "Semi-Global Matching (SGM) (or type of)",
						"Voxel-based Reconstruction (or type of)", "Deep Learning-based Depth Estimation (or type of)",
						"Graph-cut and Graph-based Matching (or type of)", "Other", "Unknown" });
		cmbMatchingAlgorithmEducational = new JComboBox<>(
				new String[] { "Select a Matching Algorithm", "Structure from Motion (SfM) (or type of)",
						"Multi-View Stereo (MVS) (or type of)", "Depth Map Fusion (or type of)",
						"Epipolar Geometry-based Matching (or type of)", "Semi-Global Matching (SGM) (or type of)",
						"Voxel-based Reconstruction (or type of)", "Deep Learning-based Depth Estimation (or type of)",
						"Graph-cut and Graph-based Matching (or type of)", "Other", "Unknown" });
		cmbMeshingAlgorithmVideo = new JComboBox<>(new String[] { "Select a Meshing Algorithm",
				"Delaunay Triangulation (or type of)", "Poisson Surface Reconstruction (or type of)",
				"Marching Cubes (or type of)", "Ball-Pivoting Algorithm (BPA) (or type of)",
				"Alpha Shapes (or type of)", "Voronoi-based Surface Reconstruction (or type of)",
				"Power Crust (or type of)", "Surface Nets (or type of)", "Advancing Front (or type of)",
				"Implicit Surface Reconstruction (or type of)",
				"RBF (Radial Basis Function) Interpolation (or type of)",
				"Screened Poisson Surface Reconstruction (or type of)", "Graph-cut Surface Reconstruction (or type of)",
				"Convolutional Occupancy Networks (Deep Learning) (or type of)",
				"Wavelet-based Surface Reconstruction (or type of)", "Other", "Unknown" });
		cmbMeshingAlgorithmARVR = new JComboBox<>(new String[] { "Select a Meshing Algorithm",
				"Delaunay Triangulation (or type of)", "Poisson Surface Reconstruction (or type of)",
				"Marching Cubes (or type of)", "Ball-Pivoting Algorithm (BPA) (or type of)",
				"Alpha Shapes (or type of)", "Voronoi-based Surface Reconstruction (or type of)",
				"Power Crust (or type of)", "Surface Nets (or type of)", "Advancing Front (or type of)",
				"Implicit Surface Reconstruction (or type of)",
				"RBF (Radial Basis Function) Interpolation (or type of)",
				"Screened Poisson Surface Reconstruction (or type of)", "Graph-cut Surface Reconstruction (or type of)",
				"Convolutional Occupancy Networks (Deep Learning) (or type of)",
				"Wavelet-based Surface Reconstruction (or type of)", "Other", "Unknown" });
		cmbMeshingAlgorithmMobile = new JComboBox<>(new String[] { "Select a Meshing Algorithm",
				"Delaunay Triangulation (or type of)", "Poisson Surface Reconstruction (or type of)",
				"Marching Cubes (or type of)", "Ball-Pivoting Algorithm (BPA) (or type of)",
				"Alpha Shapes (or type of)", "Voronoi-based Surface Reconstruction (or type of)",
				"Power Crust (or type of)", "Surface Nets (or type of)", "Advancing Front (or type of)",
				"Implicit Surface Reconstruction (or type of)",
				"RBF (Radial Basis Function) Interpolation (or type of)",
				"Screened Poisson Surface Reconstruction (or type of)", "Graph-cut Surface Reconstruction (or type of)",
				"Convolutional Occupancy Networks (Deep Learning) (or type of)",
				"Wavelet-based Surface Reconstruction (or type of)", "Other", "Unknown" });
		cmbMeshingAlgorithmEducational = new JComboBox<>(new String[] { "Select a Meshing Algorithm",
				"Delaunay Triangulation (or type of)", "Poisson Surface Reconstruction (or type of)",
				"Marching Cubes (or type of)", "Ball-Pivoting Algorithm (BPA) (or type of)",
				"Alpha Shapes (or type of)", "Voronoi-based Surface Reconstruction (or type of)",
				"Power Crust (or type of)", "Surface Nets (or type of)", "Advancing Front (or type of)",
				"Implicit Surface Reconstruction (or type of)",
				"RBF (Radial Basis Function) Interpolation (or type of)",
				"Screened Poisson Surface Reconstruction (or type of)", "Graph-cut Surface Reconstruction (or type of)",
				"Convolutional Occupancy Networks (Deep Learning) (or type of)",
				"Wavelet-based Surface Reconstruction (or type of)", "Other", "Unknown" });
		cmbARVRCategory = new JComboBox<>(new String[] { "Select a Category", "Education and Training",
				"Healthcare and Therapy", "Cultural Heritage and Preservation", "Entertainment and Gaming",
				"Real Estate and Architecture", "Retail and E-commerce", "Tourism and Virtual Travel",
				"Military and Defense", "Marketing and Advertising", "Industrial Design and Prototyping",
				"Data Visualisation", "Environmental Studies and Simulation", "Art and Creative Expression",
				"Social Interaction and Virtual Communities", "Sports and Fitness", "Event and Conference Management",
				"Agriculture and Farming Technologies", "Transportation and Navigation",
				"Public Safety and Emergency Response", "Accessibility and Assistive Technologies",
				"Museum and Gallery Experiences", "Fashion and Virtual Try-Ons", "Urban Planning and Smart Cities",
				"Performing Arts and Interactive Storytelling", "Astronomy and Space Exploration" });
		cmbMobileApplicationOperationalSystem = new JComboBox<>(new String[] { "Select an Operational System",
				"Android", "iOS", "HarmonyOS", "KaiOS", "Sailfish OS", "Windows Phone / Windows Mobile",
				"BlackBerry OS", "Symbian OS", "Palm OS", "Bada OS", "Tizen OS", "Ubuntu Touch", "PostmarketOS",
				"Replicant", "LineageOS", "Firefox OS", "Plasma Mobile", "e/OS" });
		cmbVideoFormat = new JComboBox<>(new String[] { "Select a Video Format", "AVI", "MP4", "MKV", "MOV", "FLV",
				"WMV", "WebM", "MPG / MPEG", "3GP", "OGV", "M4V", "MXF", "ASF", "VOB", "TS", "F4V", "RM / RMVB",
				"AVCHD", "HLS", "DV", "DivX" });
		cmbAcquistionScaleObjectTypeMobile = new JComboBox<>(new String[] { "Select Scale",
				"A - Small object (equal to or smaller than 1 cm)", "B - Medium Object - 1 cm to 30 cm)",
				"C - Large Object (from 30cm upwards)", "D - Open architectural structure",
				"E - Architectural element (part of an architectural structure)", "F - Cave or underground structure",
				"G - Landscape element" });
		cmbAcquistionScaleObjectTypeEducational = new JComboBox<>(new String[] { "Select Scale",
				"A - Small object (equal to or smaller than 1 cm)", "B - Medium Object - 1 cm to 30 cm)",
				"C - Large Object (from 30cm upwards)", "D - Open architectural structure",
				"E - Architectural element (part of an architectural structure)", "F - Cave or underground structure",
				"G - Landscape element" });
		cmbProgrammingLanguage = new JComboBox<>(new String[] { "Select Programming Language", "C++ (Unreal Engine)",
				"C# (Unity)", "GDScript ", "Go", "Lua", "Ruby", "Python", "C++", "CSS", "HTML5", "C#", "TypeScript",
				"JavaScript", "Dart", "Objective-C", "Swift", "Kotlin", "Java" });
		cmbOrientationVideo = new JComboBox<>(new String[] { "Select Orientation",
				"AX X-Axis Oriented: The model is oriented along the X-axis",
				"AY Y-Axis Oriented: The model is oriented along the Y-axis",
				"AZ Z-Axis Oriented: The model is oriented along the Z-axis",
				"NR No Rotation: No rotation applied (model aligned to the global system)",
				"RZ Yaw Rotation: Rotation around the Z-axis (horizontal angle)",
				"RY Pitch Rotation: Rotation around the Y-axis (vertical angle)",
				"RX Roll Rotation: Rotation around the X-axis (longitudinal angle)",
				"NF North-Facing: The model is oriented towards the true North",
				"SF South-Facing: The model is oriented towards the true South",
				"EF East-Facing: The model is oriented towards the East",
				"WF West-Facing: The model is oriented towards the West",
				"OGP Relative to Ground Plane: The model is aligned with the ground plane (for example, with a flat surface that coincides with the XY plane)",
				"OOF Relative to Object Features: Orientation based on specific features of the object, such as a leading edge or prominent detail",
				"OAM Aligned with Another Model: The model is oriented with respect to another model (for example, a point cloud or reference model)",
				"SO Symmetrical Orientation: The model is oriented so that the intrinsic symmetry of the object is respected",
				"AO Asymmetrical Orientation: The orientation does not respect the symmetry of the object. Perspective or View Specifications",
				"VT Top-Down View: The model is oriented for a top view",
				"VF Front View: The model is oriented for a front view",
				"VS Side View: The model is oriented for a side view (left or right)",
				"VI Isometric View: The model is oriented for an isometric view (associated with 3D graphics and CAD)",
				"Unknown" });
		cmbOrientationARVR = new JComboBox<>(new String[] { "Select Orientation",
				"AX X-Axis Oriented: The model is oriented along the X-axis",
				"AY Y-Axis Oriented: The model is oriented along the Y-axis",
				"AZ Z-Axis Oriented: The model is oriented along the Z-axis",
				"NR No Rotation: No rotation applied (model aligned to the global system)",
				"RZ Yaw Rotation: Rotation around the Z-axis (horizontal angle)",
				"RY Pitch Rotation: Rotation around the Y-axis (vertical angle)",
				"RX Roll Rotation: Rotation around the X-axis (longitudinal angle)",
				"NF North-Facing: The model is oriented towards the true North",
				"SF South-Facing: The model is oriented towards the true South",
				"EF East-Facing: The model is oriented towards the East",
				"WF West-Facing: The model is oriented towards the West",
				"OGP Relative to Ground Plane: The model is aligned with the ground plane (for example, with a flat surface that coincides with the XY plane)",
				"OOF Relative to Object Features: Orientation based on specific features of the object, such as a leading edge or prominent detail",
				"OAM Aligned with Another Model: The model is oriented with respect to another model (for example, a point cloud or reference model)",
				"SO Symmetrical Orientation: The model is oriented so that the intrinsic symmetry of the object is respected",
				"AO Asymmetrical Orientation: The orientation does not respect the symmetry of the object. Perspective or View Specifications",
				"VT Top-Down View: The model is oriented for a top view",
				"VF Front View: The model is oriented for a front view",
				"VS Side View: The model is oriented for a side view (left or right)",
				"VI Isometric View: The model is oriented for an isometric view (associated with 3D graphics and CAD)",
				"Unknown" });

	}

	private void initializeFieldGroups() {
		panelFieldGroups.put("Video Rendering", new JTextField[] { tfSurveyObjectVideo, tfSurveyLinkVideo,
				tfAcquisitionLocationVideo, tfProcessingSoftwareVideo, tfProcessedTexturedMeshTextureSetVideo,
				tfModelling_ModifyingDescriptionVideo, tfTridimensionalDigitalTwinVideo,
				tfTridimensionalDigitalTwinDigitalScaleVideo, tfFinalPurpose, tfExported3DModelVideoRendering,
				tfExporting_EditingRenderingVideo, tfExporting_EditingRenderingVideoSoftware,
				tfExportedVideo3DRendering, tfVideoResolution, tfVideoDuration, tfGeorefVideo, tfMeshNumberVideo });

		panelFieldGroups.put("AR/VR", new JTextField[] { tfSurveyObjectARVR, tfSurveyLinkARVR,
				tfAcquisitionLocationARVR, tfProcessingSoftwareARVR, tfProcessedTexturedMeshTextureSetARVR,
				tfTridimensionalDigitalTwinARVR, tfTridimensionalDigitalTwinDigitalScaleARVR, tfExportedAR3DModelARVR,
				tfExporting_ARMRProjectImplementation, tfARMRImplementationSoftware, tfARVRDescription, tfARVRTitle,
				tfARVRPlatform, tfARVRCoordinates, tfGeorefARVR, tfMeshNumberARVR });

		panelFieldGroups.put("Mobile",
				new JTextField[] { tfSurveyObjectMobile, tfSurveyLinkMobile, tfAcquisitionLocationMobile,
						tfAcquisitionDateMobile, tfProcessingSoftwareMobile, tfProcessedTexturedMeshTextureSetMobile,
						tfModelling_ModifyingDescriptionMobile, tfTridimensionalDigitalTwinMobile,
						tfTridimensionalDigitalTwinDigitalScaleMobile, tfExportedAR3DModelMobile });

		panelFieldGroups.put("Educational",
				new JTextField[] { tfSurveyObjectEducational, tfSurveyLinkEducational, tfAcquisitionLocationEducational,
						tfAcquisitionDateEducational, tfProcessedDensifiedPointCloud, tfProcessingSoftwareEducational,
						tfProcessedTexturedMeshTextureSetEducational, tfModelling_ModifyingDescriptionEducational,
						tfTridimensionalDigitalTwinEducational, tfTridimensionalDigitalTwinDigitalScaleEducational,
						tfExportedAR3DModelEducational, tfEducationalPlatformURL, tfEducationalPlatformServerWeb,
						tfSelectedBrowsers });
	}

	private void initializeFieldMaps() {

		videoFieldMap.put("Name of the Object", tfObjectNameVideo);
		videoFieldMap.put("F1 SurveyObject", tfSurveyObjectVideo);
		videoFieldMap.put("SurveyLink", tfSurveyLinkVideo);
		videoFieldMap.put("F42 AcquisitionLocation", tfAcquisitionLocationVideo);
		videoFieldMap.put("F31 ProcessingSoftware", tfProcessingSoftwareVideo);
		videoFieldMap.put("F62 ProcessedTexturedMeshTextureSet", tfProcessedTexturedMeshTextureSetVideo);
		videoFieldMap.put("F64 Modelling_ModifyingDescription", tfModelling_ModifyingDescriptionVideo);
		videoFieldMap.put("F100 TridimensionalDigitalTwin", tfTridimensionalDigitalTwinVideo);
		videoFieldMap.put("F59 TridimensionalDigitalTwinDigitalScale", tfTridimensionalDigitalTwinDigitalScaleVideo);
		videoFieldMap.put("F71 FinalPurpose", tfFinalPurpose);
		videoFieldMap.put("F72 Exported3DModelVideoRendering", tfExported3DModelVideoRendering);
		videoFieldMap.put("F73 Exporting_EditingRenderingVideo", tfExporting_EditingRenderingVideo);
		videoFieldMap.put("F74 Exporting_EditingRenderingVideoSoftware", tfExporting_EditingRenderingVideoSoftware);
		videoFieldMap.put("F75 ExportedVideo3DRendering", tfExportedVideo3DRendering);
		videoFieldMap.put("F112 VideoResolution", tfVideoResolution);
		videoFieldMap.put("F113 VideoDuration", tfVideoDuration);
		videoFieldMap.put("F154 Georeferencing_3DModel", tfGeorefVideo);
		videoFieldMap.put("F156 ModelComposition_MultipleParts", tfMeshNumberVideo);

		arvrFieldMap.put("Name of the Object", tfObjectNameARVR);
		arvrFieldMap.put("F1 SurveyObject", tfSurveyObjectARVR);
		arvrFieldMap.put("SurveyLink", tfSurveyLinkARVR);
		arvrFieldMap.put("F42 AcquisitionLocation", tfAcquisitionLocationARVR);
		arvrFieldMap.put("F31 ProcessingSoftware", tfProcessingSoftwareARVR);
		arvrFieldMap.put("F62 ProcessedTexturedMeshTextureSet", tfProcessedTexturedMeshTextureSetARVR);
		arvrFieldMap.put("F100 TridimensionalDigitalTwin", tfTridimensionalDigitalTwinARVR);
		arvrFieldMap.put("F59 TridimensionalDigitalTwinDigitalScale", tfTridimensionalDigitalTwinDigitalScaleARVR);
		arvrFieldMap.put("F97 Exported AR 3D Model", tfExportedAR3DModelARVR);
		arvrFieldMap.put("F98 AR/MR Project Implementation", tfExporting_ARMRProjectImplementation);
		arvrFieldMap.put("F99 AR Software Modelling", tfARMRImplementationSoftware);
		arvrFieldMap.put("F114 AR/VR Description", tfARVRDescription);
		arvrFieldMap.put("F115 Title or DOI of the AR/VR project", tfARVRTitle);
		arvrFieldMap.put("F117 Created for AR/VR Platform", tfARVRPlatform);
		arvrFieldMap.put("F119 Georeferenced Coordinates", tfARVRCoordinates);
		arvrFieldMap.put("F154 Georeferencing_3DModel", tfGeorefARVR);
		arvrFieldMap.put("F156 ModelComposition_MultipleParts", tfMeshNumberARVR);

		mobileFieldMap.put("Name of the Object", tfObjectNameMobile);
		mobileFieldMap.put("F1 SurveyObject", tfSurveyObjectMobile);
		mobileFieldMap.put("SurveyLink", tfSurveyLinkMobile);
		mobileFieldMap.put("F42 AcquisitionLocation", tfAcquisitionLocationMobile);
		mobileFieldMap.put("F43 AcquisitionDate", tfAcquisitionDateMobile);
		mobileFieldMap.put("F31 ProcessingSoftware", tfProcessingSoftwareMobile);
		mobileFieldMap.put("F62 ProcessedTexturedMeshTextureSet", tfProcessedTexturedMeshTextureSetMobile);
		mobileFieldMap.put("F64 Modelling_ModifyingDescription", tfModelling_ModifyingDescriptionMobile);
		mobileFieldMap.put("F100 TridimensionalDigitalTwin", tfTridimensionalDigitalTwinMobile);
		mobileFieldMap.put("F100 TridimensionalDigitalTwin", tfTridimensionalDigitalTwinDigitalScaleMobile);
		mobileFieldMap.put("F97 Exported AR 3D Model", tfExportedAR3DModelMobile);

		educationalFieldMap.put("Name of the Object", tfObjectNameEducational);
		educationalFieldMap.put("F1 SurveyObject", tfSurveyObjectEducational);
		educationalFieldMap.put("SurveyLink", tfSurveyLinkEducational);
		educationalFieldMap.put("F42 AcquisitionLocation", tfAcquisitionLocationEducational);
		educationalFieldMap.put("F43 AcquisitionDate", tfAcquisitionDateEducational);
		educationalFieldMap.put("F27 ProcessedDensifiedPointCloud", tfProcessedDensifiedPointCloud);
		educationalFieldMap.put("F31 ProcessingSoftware", tfProcessingSoftwareEducational);
		educationalFieldMap.put("F62 ProcessedTexturedMeshTextureSet", tfProcessedTexturedMeshTextureSetEducational);
		educationalFieldMap.put("F64 Modelling_ModifyingDescription", tfModelling_ModifyingDescriptionEducational);
		educationalFieldMap.put("F100 TridimensionalDigitalTwin", tfTridimensionalDigitalTwinEducational);
		educationalFieldMap.put("F59 TridimensionalDigitalTwinDigitalScale",
				tfTridimensionalDigitalTwinDigitalScaleEducational);
		educationalFieldMap.put("F97 Exported AR 3D Model", tfExportedAR3DModelEducational);
		educationalFieldMap.put("F121 Educational Platform URL", tfEducationalPlatformURL);
		educationalFieldMap.put("F123 Educational Platform Server Web", tfEducationalPlatformServerWeb);
		educationalFieldMap.put("Selected Browsers", tfSelectedBrowsers);

		videoComboBoxMap.put("F21 Matching Algorithm", cmbMatchingAlgorithmVideo);
		arvrComboBoxMap.put("F21 Matching Algorithm", cmbMatchingAlgorithmARVR);
		mobileComboBoxMap.put("F21 Matching Algorithm", cmbMatchingAlgorithmMobile);
		educationalComboBoxMap.put("F21 Matching Algorithm", cmbMatchingAlgorithmEducational);
		videoComboBoxMap.put("F23 Meshing Algorithm", cmbMeshingAlgorithmVideo);
		arvrComboBoxMap.put("F23 Meshing Algorithm", cmbMeshingAlgorithmARVR);
		mobileComboBoxMap.put("F23 Meshing Algorithm", cmbMeshingAlgorithmMobile);
		educationalComboBoxMap.put("F23 Meshing Algorithm", cmbMeshingAlgorithmEducational);
		arvrComboBoxMap.put("F116 ARVR Category", cmbARVRCategory);
		mobileComboBoxMap.put("F119 Mobile Application Operational System", cmbMobileApplicationOperationalSystem);
		videoComboBoxMap.put("F111 VideoFormat", cmbVideoFormat);
		mobileComboBoxMap.put("F19 AcquisitionScaleObjectType", cmbAcquistionScaleObjectTypeMobile);
		educationalComboBoxMap.put("F19 AcquisitionScaleObjectType", cmbAcquistionScaleObjectTypeEducational);
		mobileComboBoxMap.put("F120 Programming Language", cmbProgrammingLanguage);
		videoComboBoxMap.put("F155 Orientation_3DModel", cmbOrientationVideo);
		arvrComboBoxMap.put("F155 Orientation_3DModel", cmbOrientationARVR);

	}

	private void initializeDefinitions() {
		definitions = new HashMap<>();

		definitions.put("SurveyObject",
				"F1 Survey Object\nAlso called Survey object or Acquisition Object\nWhich finding or structure is the object of your survey? \nIRI: https://photogrammetry.altervista.org/items/show/87");
		definitions.put("SurveyLink",
				"Can you provide a link to an official resource of the object of your survey? \nIRI: https://photogrammetry.altervista.org/items/show/87");
		definitions.put("AcquisitionLocation",
				"F42 Place of Acquisition\nAlso called 'Place of Acquisition'\nWhere did the survey take place? In which specific location?\nIRI: https://photogrammetry.altervista.org/items/show/128#F42_Place_Of_Acquisition \n");
		definitions.put("AcquistionScaleObjectType",
				"F19 Scale Type\nWhat is the scale of the object of your survey? \nIRI: https://photogrammetry.altervista.org/items/show/105#F19_Scale_Type");
		definitions.put("AcquisitionDate",
				"F43 Survey Date\nOn what date did your survey take place? \nIRI: https://photogrammetry.altervista.org/items/show/129#F43_Survey_Date");
		definitions.put("ProcessedDensifiedPointCloud",
				"F27 Densified Cloud Points\nCan you provide a link to the densified cloud resulting from your survey?\nIRI: https://photogrammetry.altervista.org/items/show/113#F27_Densified_Point_Cloud");
		definitions.put("ProcessingSoftware",
				"F31 Processing Software\nWith which software did you process the point cloud starting from the raw data?\nIRI: https://photogrammetry.altervista.org/items/show/117#F31_Processing_Software");
		definitions.put("ProcessedTexturedMeshTextureSet",
				"F62 Texture Set of 3D Mesh\nCan you provide a link to the repository where the textures of the 3D model are stored? \nIRI: https://photogrammetry.altervista.org/items/show/149#F62_Texture_Set_of_3D_Mesh");
		definitions.put("Modelling_ModifyingDescription",
				"F64 Modelling Description\nCan you describe in detail the modification operations performed on the 3D model before its final export?\nIRI: https://photogrammetry.altervista.org/items/show/151#F64_Modelling_Description");
		definitions.put("TridimensionalDigitalTwin",
				"F100 3D Digital Twin\nCan you provide a link to download and/or view the final 3D model? \nIRI: https://photogrammetry.altervista.org/items/show/145#F100_3D_Digital_Twin");
		definitions.put("TridimensionalDigitalTwinDigitalScale",
				"F59 Digital Scale\nWhat is the digital scale of the object? \nIRI: https://photogrammetry.altervista.org/items/show/146#F59_Digital_Scale");
		definitions.put("Exported3DModelVideoRendering",
				"F72 3D Model Video Rendering\nWhat is the video rendering output of the 3D model? \nIRI: https://photogrammetry.altervista.org/items/show/159#F72_3D_Model_Video_Rendering");
		definitions.put("Exporting_EditingRenderingVideo",
				"F73 Editing Video\nWhat editing was done on the rendered 3D model video? \nIRI: https://photogrammetry.altervista.org/items/show/160#F73_Editing_Video");
		definitions.put("Exporting_EditingRenderingVideoSoftware",
				"F74 Video Editing Software\nWhat software was used for editing the video? \nIRI: https://photogrammetry.altervista.org/items/show/161#F74_Video_Editing_Software");
		definitions.put("ExportedVideo3DRendering",
				"F75 Project Video\nWhat is the final rendered video of the 3D model? \nIRI: https://photogrammetry.altervista.org/items/show/162#F75_Project_Video");
		definitions.put("ExportedAR3DModel",
				"F97 AR 3D Model\nDescribe the exported 3D model prepared for AR/MR projects. \nIRI: https://photogrammetry.altervista.org/items/show/184#F97_AR_3D_Model");
		definitions.put("Exporting_AR-MRProjectImplementation",
				"F98 AR/MR Project Implementation\nDescribe the AR/MR project implementation steps. \nIRI: https://photogrammetry.altervista.org/items/show/185#F98_AR/MR_Project_Implementation");
		definitions.put("AR-MRImplementationSoftware",
				"F99 AR Software Modelling\nWhat software was used in the AR/MR implementation? \nIRI: https://photogrammetry.altervista.org/items/show/186#F99_AR_Software_Modelling");
		definitions.put("FinalPurpose",
				"F71 What are the final purposes of the 3D model? \nIRI: https://photogrammetry.altervista.org/items/show/158#F71_Final_Use_of_Digital_Twin");
		definitions.put("VideoFormat",
				"F111 What is the format of video rendering? \nIRI: https://photogrammetry.altervista.org/items/show/290 \r\n");
		definitions.put("VideoResolution",
				"F112 What is the resolution of video rendering? \nIRI: https://photogrammetry.altervista.org/items/show/291");
		definitions.put("VideoDuration",
				"F113 What is the duration of video rendering? \nIRI: https://photogrammetry.altervista.org/items/show/292");
		definitions.put("AR/VR Description",
				"F114 Can you provide a description of the AR/VR project? \nIRI: https://photogrammetry.altervista.org/items/show/293");
		definitions.put("AR/VR Project Title/ DOI",
				"F115 Can you provide an identifying title or DOI of the AR/VR project? \nIRI: https://photogrammetry.altervista.org/items/show/294");
		definitions.put("AR/VR Category",
				"F116 In which category does the AR/VR project fall? \nIRI: https://photogrammetry.altervista.org/items/show/295");
		definitions.put("AR/VR Platform",
				"F117 For which type of platform was the AR/VR project created? \nIRI: https://photogrammetry.altervista.org/items/show/296");
		definitions.put("AR/VR Coordinates",
				"F118 The AR/VR project is georeferenced to real coordinates and if so, which ones? \nIRI: https://photogrammetry.altervista.org/items/show/297");
		definitions.put("Programming Language",
				"F120 What is the programming language of the mobile application? \nIRI: https://photogrammetry.altervista.org/items/show/299");
		definitions.put("Mobile Application Operational System",
				"F119 Which operating system was the mobile application created for? \r\nIRI: https://photogrammetry.altervista.org/items/show/298");
		definitions.put("Educational Platform URL",
				"F121 What is the URL of the platform where you can see the 3D model? \nIRI: https://photogrammetry.altervista.org/items/show/300");
		definitions.put("Educational Platform supported browser",
				"F122 Which browsers support the online application? \nIRI: https://photogrammetry.altervista.org/items/show/301");
		definitions.put("Educational Platform Server Web",
				"F123 What is the web server where the online application is loaded? \nIRI: https://photogrammetry.altervista.org/items/show/302");
		definitions.put("Orientation_3DModel",
				"F154 Georeferencing_3DModel \nIRI: https://photogrammetry.altervista.org/items/show/333#F154_Georeferencing_of_the_3D_Model");
		definitions.put("ModelComposition_MultipleParts",
				"F156 ModelComposition_MultipleParts \nIRI: https://photogrammetry.altervista.org/items/show/335#F156_Model_Composition_from_Multiple_Parts");
		definitions.put("Georeferencing_3DModel",
				"F155 Orientation_3DModel \nIRI: https://photogrammetry.altervista.org/items/show/334#F155_Orientation_of_the_3D_ModelS");
		definitions.put("MatchingAlgorithm",
				"F21 Matching Algorithm \nIRI: https://photogrammetry.altervista.org/items/show/107");
		definitions.put("MeshingAlgorithm",
				"F23 Reconstruction Algorithm Type \nIRI: https://photogrammetry.altervista.org/items/show/109");
	}

	private String getIRIFromDefinition(String definition) {
		if (definition == null)
			return null;
		int iriIndex = definition.indexOf("IRI: ");
		if (iriIndex != -1) {
			String iriPart = definition.substring(iriIndex + 4).trim();
			int spaceIndex = iriPart.indexOf(' ');
			if (spaceIndex != -1) {
				iriPart = iriPart.substring(0, spaceIndex);
			}
			return iriPart;
		}
		return null;
	}

	private void openInBrowser(String url) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URL(url).toURI());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void configureButton(JButton button, String actionCommand) {
		button.setActionCommand(actionCommand);

		// Add the shared ActionListener for left-click behavior
		button.addActionListener(this);

		// Add a shared MouseAdapter for right-click behavior
		button.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				if (javax.swing.SwingUtilities.isRightMouseButton(e)) {
					// Handle right-click: open the IRI in the browser
					String definition = definitions.get(actionCommand);
					if (definition != null) {
						String iri = getIRIFromDefinition(definition);
						if (iri != null) {
							openInBrowser(iri);
						} else {
							log.setText("No IRI found for " + actionCommand);
						}
					}
				}
			}
		});
	}

	private void makeGUI() {
		JPanel jpTop = new JPanel();
		jpTop.setLayout(new GridLayout(4, 1));
		JPanel jpBottom = new JPanel();
		jpBottom.setLayout(new BorderLayout());

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(jpTop, BorderLayout.NORTH);
		getContentPane().add(jpBottom, BorderLayout.SOUTH);

		// Title
		JLabel lblTitle = new JLabel("T.i.A.M.A.T", JLabel.CENTER);
		lblTitle.setFont(new Font(lblTitle.getFont().getName(), Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		jpTop.add(lblTitle);

		// Subtitle

		JLabel lblSubtitle = new JLabel();
		lblSubtitle.setFont(lblSubtitle.getFont().deriveFont(Font.PLAIN));
		lblSubtitle.setText(
				"<html><span style='font-size:20pt;'><b><u>T</u></b>ool for the Qual<b><u>i</u></b>ty <b><u>A</u></b>ssessment of 3D <b><u>M</u></b>odels used in <b><u>A</u></b>rchaeological <b><u>T</u></b>asks</span></html>");
		lblSubtitle.setHorizontalAlignment(JLabel.CENTER);
		jpTop.add(lblSubtitle);

		// Use Case Selection
		JLabel lblUseCaseSelect = new JLabel("Select Use Case:", JLabel.CENTER);
		jpTop.add(lblUseCaseSelect);

		String[] choices = { "Please Select a Use Case", "Video Rendering of the 3D Model",
				"3D Model for AR/VR Projects", "3D Model for Mobile Applications",
				"3D Model for Online Educational Platforms" };
		cmbUseCase = new JComboBox<>(choices);
		cmbUseCase.addActionListener(this);
		jpTop.add(cmbUseCase);

		// CardLayout panel
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);

		// Add cards for each use case
		cardPanel.add(selectionPanel(), "Selection");
		cardPanel.add(createVideoRenderingPanel(), "Video Rendering");
		cardPanel.add(createARVRPanel(), "AR/VR");
		cardPanel.add(createMobilePanel(), "Mobile");
		cardPanel.add(createEducationalPanel(), "Educational");
		cardPanel.add(createAboutPanel(), "About");

		getContentPane().add(cardPanel, BorderLayout.CENTER);

		// Log area
		log = new JTextArea(5, 20);
		log.setEditable(false);
		jpBottom.add(new JScrollPane(log), BorderLayout.CENTER);
	}

	private JPanel selectionPanel() {
		JPanel panel = new JPanel((new BorderLayout(10, 10)));

		JPanel descriptionPanel = new JPanel(new FlowLayout());
		JTextArea taDescription = new JTextArea("\r\n"
				+ "T.i.A.M.A.T is an apprication designed for archeologists to help them assess the quality of a 3D model."
				+ " It can be used to determine whether a chosen model is suitable for different tasks and use cases.\n"
				+ "In its current version T.i.A.M.A.T is designed to give an indication about the suitability regarding Usability in the area regarding Teaching and Dissemination use cases."
				+ " Please select an option in the dropdown menu above to procede.\n" + "\n" + "Specific Use Cases\n"
				+ "- Video Rendering of the 3D Model: Creation of video renderings to visualize and explain the 3D model in educational or outreach contexts.\n"
				+ "- 3D Model for AR/VR Projects: Integration of 3D models into Augmented Reality (AR) or Virtual Reality (VR) environments for immersive educational experiences.\n"
				+ "- 3D Model for Mobile Applications: Optimized models suitable for mobile apps, enabling users to interact with or explore 3D heritage assets on handheld devices.\n"
				+ "- 3D Model for Online Educational Platforms: Web-optimized models designed for embedding in online learning environments, enhancing distance learning and e-learning resources.\n"
				+ "\n" + "Using T.i.A.M.A.T: \n"
				+ "Following the Use Case selection you will have the option to answer questions to provide information about the 3D model in question. Depending on the answers T.i.A.M.A.T will give its assessment of whether or not this model "
				+ "seems suitable for the selected use case.\n"
				+ "T.i.A.M.A.T relies on the ontology 'Protocol of Ontological Digital Survey (PODS)' which is based on Vittorio Lauro's 'FOPPA' Ontology and has been merged with the 'Mainzed 3D Metadata Ontology' created by Timo Homburg, Mara Hubert and Anja Cramer.\n"
				+ "By left-clicking on the different questions, a short explanation will be displayed, in order to assist with uncertainties. A right-click will lead directly to the entry in the ontology.\n"
				+ "\n"
				+ "You will have the option to export your answers as a JSON file - potentially creating missing metadata for the 3D model. "
				+ "In addition you can export the score used by T.i.A.M.A.T to rate the suitability of the 3D model with the metadata and also import JSON files created by T.i.A.M.A.T into the application if you would like to add to the already created metadata or re-evaluate the suitability."
				+ "");
		taDescription.setEditable(false);
		taDescription.setLineWrap(true);
		taDescription.setLineWrap(true);
		taDescription.setWrapStyleWord(true); // Wrap at word boundaries
		taDescription.setBackground(descriptionPanel.getBackground());
		taDescription.setColumns(70); // Set width of the text area
		taDescription.setRows(10); // Set height of the text area
		
		descriptionPanel.add(taDescription);

		JPanel buttonPanel = new JPanel(new FlowLayout());
		JButton podsThesaurus = new JButton("To the PODS Thesaurus");
		podsThesaurus.addActionListener(e -> {
			try {
				Desktop.getDesktop()
						.browse(new URL("https://photogrammetry.altervista.org/collections/show/4").toURI());
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		});
		JButton mainzedOntology = new JButton("To the Mainzed Ontology");
		mainzedOntology.addActionListener(e -> {
			try {
				Desktop.getDesktop().browse(
						new URL("https://mainzed.pages.gitlab.rlp.net/homepages/mainzedmetadata/index.html").toURI());
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		});
		JButton podsGitHub = new JButton("To PODS on GitHub");
		podsGitHub.addActionListener(e -> {
			try {
				Desktop.getDesktop().browse(new URL("https://github.com/Vlauro/PODS").toURI());
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		});
		
		JButton btnAbout = new JButton("About T.i.A.M.A.T");
		btnAbout.addActionListener(e -> {
			currentPanel = "About";
			cardLayout.show(cardPanel, "About");
		});

		buttonPanel.add(podsThesaurus);
		buttonPanel.add(mainzedOntology);
		buttonPanel.add(podsGitHub);
		buttonPanel.add(btnAbout);

		panel.add(descriptionPanel, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);

		return panel;
	}

	private JPanel createAboutPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JPanel textPanel = new JPanel(new GridLayout(0, 1, 5, 5));
		JPanel logoPanel = new JPanel(new GridLayout(0, 1, 5, 5));
		JPanel headerPanel = new JPanel(new GridLayout(0, 1, 5, 5));

		JLabel buffer = new JLabel("");
		headerPanel.add(buffer);
		JLabel header = new JLabel();
		header.setFont(header.getFont().deriveFont(Font.PLAIN));
		header.setText("<html><span style='font-size:20pt;'><b>About T.i.A.M.A.T</b></span></html>");
		header.setHorizontalAlignment(JLabel.CENTER);
		headerPanel.add(header);

		JTextArea aboutTiamat = new JTextArea("\n" + "\n\n" + "Author: Ann-Kathrin Weber\n"
				+ "ORCiD: https://orcid.org/0009-0006-5850-4617\n\n" + "Version: 2.0\n" + "\n"
				+ "Libraries used in T.i.A.M.A.T: \nJSON in Java (https://github.com/stleary/JSON-java)\n" + "\n" + "License: GNU GPLv3 \n" + "\n" + "GitLab Repository: https://gitlab.rlp.net/weannkat/t.i.a.m.a.t\n" + "\n"
				+ "Context for the Application: \nT.i.A.M.A.T was created as part of an internship with the i3Mainz and the Hochschule Mainz \n as part of the Master of Arts 'Digitale Methodik in den Geistes und Kulturwissenschaften'.\n " 
				+ "\n" + "Context for the Logo: \n" + "The name 'Tiamat' derives from the Mesopotamian goddess, who embodies the primordial sea and is seen as the mother of monsters and gods. \nShe is sometimes depicted as a sea serpent or dragon, which is why the imagery of a horned sea serpent was chosen for this application. \nMetadata can be vast and unchartered - much like the ocean 'Tiamat' embodies. The logo depicts Tiamat as a spirit living in the mesh and similarly to metadata almost invisible yet important.");
		aboutTiamat.setEditable(false);
		aboutTiamat.setLineWrap(true);
		aboutTiamat.setLineWrap(true);
		aboutTiamat.setWrapStyleWord(true); // Wrap at word boundaries
		aboutTiamat.setBackground(panel.getBackground());
		aboutTiamat.setColumns(70); // Set width of the text area
		aboutTiamat.setRows(10); // Set height of the text area
		textPanel.add(aboutTiamat);

		logoPanel.setBackground(Color.DARK_GRAY);
		JLabel tiamatLogo = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/Logo_Tiamat_transparent.png")).getImage();
		int labelWidth = 400;
		int labelHeight = 400;
		Image scaledLogo = logo.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		tiamatLogo.setIcon(new ImageIcon(scaledLogo));
		logoPanel.add(tiamatLogo);

		
		panel.add(headerPanel, BorderLayout.NORTH);
		panel.add(textPanel, BorderLayout.WEST);
		panel.add(logoPanel, BorderLayout.EAST);
		return panel;
	}

	private JPanel createVideoRenderingPanel() {
		JPanel panel = new JPanel(new BorderLayout(10, 10));

		JPanel leftPanel = new JPanel(new GridLayout(0, 1, 5, 5));

		JLabel lblObjectNameVideo = new JLabel("Name of the Object:", JLabel.CENTER);
		leftPanel.add(lblObjectNameVideo);

		JButton btnSurveyObject = new JButton("SurveyObject:");
		configureButton(btnSurveyObject, "SurveyObject");
		btnSurveyObject.setBackground(Color.WHITE);
		leftPanel.add(btnSurveyObject);

		JButton btnSurveyLink = new JButton("SurveyLink:");
		configureButton(btnSurveyLink, "SurveyLink");
		btnSurveyLink.setBackground(Color.WHITE);
		leftPanel.add(btnSurveyLink);

		JButton btnAcquisitionLocation = new JButton("AcquisitionLocation:");
		configureButton(btnAcquisitionLocation, "AcquisitionLocation");
		btnAcquisitionLocation.setBackground(Color.WHITE);
		leftPanel.add(btnAcquisitionLocation);

		JButton btnProcessingSoftware = new JButton("ProcessingSoftware:");
		configureButton(btnProcessingSoftware, "ProcessingSoftware");
		btnProcessingSoftware.setBackground(Color.WHITE);
		leftPanel.add(btnProcessingSoftware);

		JButton btnProcessedTexturedMeshTextureSet = new JButton("ProcessedTexturedMeshTextureSet:");
		configureButton(btnProcessedTexturedMeshTextureSet, "ProcessedTexturedMeshTextureSet");
		btnProcessedTexturedMeshTextureSet.setBackground(Color.WHITE);
		leftPanel.add(btnProcessedTexturedMeshTextureSet);

		JButton btnModelling_ModifyingDescription = new JButton("Modelling_ModifyingDescription:");
		configureButton(btnModelling_ModifyingDescription, "Modelling_ModifyingDescription");
		btnModelling_ModifyingDescription.setBackground(Color.WHITE);
		leftPanel.add(btnModelling_ModifyingDescription);

		JButton btnTridimensionalDigitalTwin = new JButton("TridimensionalDigitalTwin:");
		configureButton(btnTridimensionalDigitalTwin, "TridimensionalDigitalTwin");
		btnTridimensionalDigitalTwin.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(btnTridimensionalDigitalTwin);

		JButton btnTridimensionalDigitalTwinDigitalScale = new JButton("TridimensionalDigitalTwinDigitalScale:");
		configureButton(btnTridimensionalDigitalTwinDigitalScale, "TridimensionalDigitalTwinDigitalScale");
		btnTridimensionalDigitalTwinDigitalScale.setBackground(Color.WHITE);
		leftPanel.add(btnTridimensionalDigitalTwinDigitalScale);

		JButton btnFinalPurpose = new JButton("FinalPurpose");
		configureButton(btnFinalPurpose, "FinalPurpose");
		btnFinalPurpose.setBackground(Color.WHITE);
		leftPanel.add(btnFinalPurpose);

		JButton btnGeorefVideo = new JButton("Georeferencing_3DModel");
		configureButton(btnGeorefVideo, "Georeferencing_3DModel");
		btnGeorefVideo.setBackground(Color.WHITE);
		leftPanel.add(btnGeorefVideo);

		JButton btnMeshNumberVideo = new JButton("ModelComposition_MultipleParts");
		;
		configureButton(btnMeshNumberVideo, "ModelComposition_MultipleParts");
		btnMeshNumberVideo.setBackground(Color.WHITE);
		leftPanel.add(btnMeshNumberVideo);

		JButton btnOrientationVideo = new JButton("Orientation_3DModel");
		configureButton(btnOrientationVideo, "Orientation_3DModel");
		btnOrientationVideo.setBackground(Color.WHITE);
		leftPanel.add(btnOrientationVideo);

		JButton btnExported3DModelVideoRendering = new JButton("Exported3DModelVideoRendering:");
		configureButton(btnExported3DModelVideoRendering, "Exported3DModelVideoRendering");
		btnExported3DModelVideoRendering.setBackground(Color.WHITE);
		leftPanel.add(btnExported3DModelVideoRendering);

		JButton btnExporting_EditingRenderingVideo = new JButton("Exporting_EditingRenderingVideo:");
		configureButton(btnExporting_EditingRenderingVideo, "Exporting_EditingRenderingVideo");
		btnExporting_EditingRenderingVideo.setBackground(Color.WHITE);
		leftPanel.add(btnExporting_EditingRenderingVideo);

		JButton btnExporting_EditingRenderingVideoSoftware = new JButton("Exporting_EditingRenderingVideoSoftware:");
		configureButton(btnExporting_EditingRenderingVideoSoftware, "Exporting_EditingRenderingVideoSoftware");
		btnExporting_EditingRenderingVideoSoftware.setBackground(Color.WHITE);
		leftPanel.add(btnExporting_EditingRenderingVideoSoftware);

		JButton btnExportedVideo3DRendering = new JButton("ExportedVideo3DRendering:");
		configureButton(btnExportedVideo3DRendering, "ExportedVideo3DRendering");
		btnExportedVideo3DRendering.setBackground(Color.WHITE);
		leftPanel.add(btnExportedVideo3DRendering);

		JButton btnVideoFormat = new JButton("VideoFormat:");
		configureButton(btnVideoFormat, "VideoFormat");
		btnVideoFormat.setBackground(Color.WHITE);
		leftPanel.add(btnVideoFormat);

		JButton btnVideoResolution = new JButton("VideoResolution:");
		configureButton(btnVideoResolution, "VideoResolution");
		btnVideoResolution.setBackground(Color.WHITE);
		leftPanel.add(btnVideoResolution);

		JButton btnVideoDuration = new JButton("VideoDuration:");
		;
		configureButton(btnVideoDuration, "VideoDuration");
		btnVideoDuration.setBackground(Color.WHITE);
		leftPanel.add(btnVideoDuration);

		JButton btnMatchingAlgorithm = new JButton("Matching Algorithm:");
		configureButton(btnMatchingAlgorithm, "MatchingAlgorithm");
		btnMatchingAlgorithm.setBackground(Color.WHITE);
		leftPanel.add(btnMatchingAlgorithm);

		JButton btnMeshingAlgorithm = new JButton("Meshing Algorithm:");
		configureButton(btnMeshingAlgorithm, "MeshingAlgorithm");
		btnMeshingAlgorithm.setBackground(Color.WHITE);
		leftPanel.add(btnMeshingAlgorithm);

		JPanel centerPanel = new JPanel(new GridLayout(0, 1, 5, 5));

		centerPanel.add(tfObjectNameVideo);

		centerPanel.add(tfSurveyObjectVideo);

		centerPanel.add(tfSurveyLinkVideo);

		centerPanel.add(tfAcquisitionLocationVideo);

		centerPanel.add(tfProcessingSoftwareVideo);

		centerPanel.add(tfProcessedTexturedMeshTextureSetVideo);

		centerPanel.add(tfModelling_ModifyingDescriptionVideo);

		centerPanel.add(tfTridimensionalDigitalTwinVideo);
		tfTridimensionalDigitalTwinVideo.setBackground(Color.LIGHT_GRAY);

		centerPanel.add(tfTridimensionalDigitalTwinDigitalScaleVideo);

		centerPanel.add(tfFinalPurpose);

		centerPanel.add(tfGeorefVideo);

		centerPanel.add(tfMeshNumberVideo);

		centerPanel.add(cmbOrientationVideo);

		centerPanel.add(tfExported3DModelVideoRendering);

		centerPanel.add(tfExporting_EditingRenderingVideo);

		centerPanel.add(tfExporting_EditingRenderingVideoSoftware);

		centerPanel.add(tfExportedVideo3DRendering);

		cmbVideoFormat.addActionListener(this);
		centerPanel.add(cmbVideoFormat);

		centerPanel.add(tfVideoResolution);

		centerPanel.add(tfVideoDuration);

		cmbMatchingAlgorithmVideo.addActionListener(this);
		centerPanel.add(cmbMatchingAlgorithmVideo);

		cmbMeshingAlgorithmVideo.addActionListener(this);
		centerPanel.add(cmbMeshingAlgorithmVideo);

		JPanel rightPanel = new JPanel(new GridLayout(0, 1, 5, 5));
		rightPanel.setVisible(false);

		rightPanel.add(new JLabel(" - "));
		rightPanel.add(new JLabel(" URL: 3 | Name: 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 2 "));
		rightPanel.add(new JLabel(" 2 "));
		rightPanel.add(new JLabel(" Mandatory "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));

		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		btnCheckSuitabilityVideo = new JButton("Check for Suitability");
		btnCheckSuitabilityVideo.addActionListener(this);
		bottomPanel.add(btnCheckSuitabilityVideo);

		btnExportVideo = new JButton("Export Metadata");
		btnExportVideo.addActionListener(this);
		bottomPanel.add(btnExportVideo);

		btnExportWithScoreVideo = new JButton("Export Metadata & Score");
		btnExportWithScoreVideo.addActionListener(this);
		bottomPanel.add(btnExportWithScoreVideo);

		btnImportVideo = new JButton("Import Metadata");
		btnImportVideo.addActionListener(this);
		bottomPanel.add(btnImportVideo);

		JCheckBox cbToggleScore = new JCheckBox("Toggle Score Visibility");
		cbToggleScore.addActionListener(e -> {
			rightPanel.setVisible(cbToggleScore.isSelected());
			panel.revalidate(); // Refresh layout when visibility changes
			panel.repaint(); // Repaint to reflect the change
		});
		bottomPanel.add(cbToggleScore);

		panel.add(leftPanel, BorderLayout.WEST);
		panel.add(centerPanel, BorderLayout.CENTER);
		panel.add(rightPanel, BorderLayout.EAST);
		panel.add(bottomPanel, BorderLayout.SOUTH);

		return panel;
	}

	private JPanel createARVRPanel() {

		JPanel panel = new JPanel(new BorderLayout(10, 10));

		JPanel leftPanel = new JPanel(new GridLayout(0, 1, 5, 5));

		JLabel lblObjectNameARVR = new JLabel("Name of the Object:", JLabel.CENTER);
		leftPanel.add(lblObjectNameARVR);

		JButton btnSurveyObject = new JButton("SurveyObject:");
		configureButton(btnSurveyObject, "SurveyObject");
		btnSurveyObject.setBackground(Color.WHITE);
		leftPanel.add(btnSurveyObject);

		JButton btnSurveyLink = new JButton("SurveyLink:");
		configureButton(btnSurveyLink, "SurveyLink");
		btnSurveyLink.setBackground(Color.WHITE);
		leftPanel.add(btnSurveyLink);

		JButton btnAcquisitionLocation = new JButton("AcquisitionLocation:");
		configureButton(btnAcquisitionLocation, "AcquisitionLocation");
		btnAcquisitionLocation.setBackground(Color.WHITE);
		leftPanel.add(btnAcquisitionLocation);

		JButton btnProcessingSoftware = new JButton("ProcessingSoftware:");
		configureButton(btnProcessingSoftware, "ProcessingSoftware");
		btnProcessingSoftware.setBackground(Color.WHITE);
		leftPanel.add(btnProcessingSoftware);

		JButton btnProcessedTexturedMeshTextureSet = new JButton("ProcessedTexturedMeshTextureSet:");
		configureButton(btnProcessedTexturedMeshTextureSet, "ProcessedTexturedMeshTextureSet");
		btnProcessedTexturedMeshTextureSet.setBackground(Color.WHITE);
		leftPanel.add(btnProcessedTexturedMeshTextureSet);

		JButton btnTridimensionalDigitalTwin = new JButton("TridimensionalDigitalTwin:");
		configureButton(btnTridimensionalDigitalTwin, "TridimensionalDigitalTwin");
		btnTridimensionalDigitalTwin.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(btnTridimensionalDigitalTwin);

		JButton btnTridimensionalDigitalTwinDigitalScale = new JButton("TridimensionalDigitalTwinDigitalScale:");
		configureButton(btnTridimensionalDigitalTwinDigitalScale, "TridimensionalDigitalTwinDigitalScale");
		btnTridimensionalDigitalTwinDigitalScale.setBackground(Color.WHITE);
		leftPanel.add(btnTridimensionalDigitalTwinDigitalScale);

		JButton btnGeorefARVR = new JButton("Georeferencing_3DModel");
		configureButton(btnGeorefARVR, "Georeferencing_3DModel");
		btnGeorefARVR.setBackground(Color.WHITE);
		leftPanel.add(btnGeorefARVR);

		JButton btnMeshNumberARVR = new JButton("ModelComposition_MultipleParts");
		configureButton(btnMeshNumberARVR, "ModelComposition_MultipleParts");
		btnMeshNumberARVR.setBackground(Color.WHITE);
		leftPanel.add(btnMeshNumberARVR);

		JButton btnOrientationARVR = new JButton("Orientation_3DModel");
		configureButton(btnOrientationARVR, "Orientation_3DModel");
		btnOrientationARVR.setBackground(Color.WHITE);
		leftPanel.add(btnOrientationARVR);

		JButton btnExportedAR3DModel = new JButton("ExportedAR3DModel:");
		configureButton(btnExportedAR3DModel, "ExportedAR3DModel");
		btnExportedAR3DModel.setBackground(Color.WHITE);
		leftPanel.add(btnExportedAR3DModel);

		JButton btnExporting_ARMRProjectImplementation = new JButton("Exporting_AR-MRProjectImplementation:");
		configureButton(btnExporting_ARMRProjectImplementation, "Exporting_AR-MRProjectImplementation");
		btnExporting_ARMRProjectImplementation.setBackground(Color.WHITE);
		leftPanel.add(btnExporting_ARMRProjectImplementation);

		JButton btnARMRImplementationSoftware = new JButton("AR-MRImplementationSoftware:");
		configureButton(btnARMRImplementationSoftware, "AR-MRImplementationSoftware");
		btnARMRImplementationSoftware.setBackground(Color.WHITE);
		leftPanel.add(btnARMRImplementationSoftware);

		JButton btnARVRDescription = new JButton("AR/VR Project Description:");
		configureButton(btnARVRDescription, "AR/VR Description");
		btnARVRDescription.setBackground(Color.WHITE);
		leftPanel.add(btnARVRDescription);

		JButton btnARVRTitle = new JButton("AR/VR Project Title/ DOI:");
		;
		configureButton(btnARVRTitle, "AR/VR Project Title/ DOI");
		btnARVRTitle.setBackground(Color.WHITE);
		leftPanel.add(btnARVRTitle);

		JButton btnARVRCategory = new JButton("AR/VR Project Category:");
		configureButton(btnARVRCategory, "AR/VR Category");
		btnARVRCategory.setBackground(Color.WHITE);
		leftPanel.add(btnARVRCategory);

		JButton btnARVRPlatform = new JButton("AR/VR Project Platform:");
		configureButton(btnARVRPlatform, "AR/VR Platform");
		btnARVRPlatform.setBackground(Color.WHITE);
		leftPanel.add(btnARVRPlatform);

		JButton btnARVRCoordinates = new JButton("AR/VR Project Coordinates:");
		configureButton(btnARVRCoordinates, "AR/VR Coordinates");
		btnARVRCoordinates.setBackground(Color.WHITE);
		leftPanel.add(btnARVRCoordinates);

		JButton btnMatchingAlgorithm = new JButton("Matching Algorithm:");
		configureButton(btnMatchingAlgorithm, "MatchingAlgorithm");
		btnMatchingAlgorithm.setBackground(Color.WHITE);
		leftPanel.add(btnMatchingAlgorithm);

		JButton btnMeshingAlgorithm = new JButton("Meshing Algorithm:");
		configureButton(btnMeshingAlgorithm, "MeshingAlgorithm");
		btnMeshingAlgorithm.setBackground(Color.WHITE);
		leftPanel.add(btnMeshingAlgorithm);

		JPanel centerPanel = new JPanel(new GridLayout(0, 1, 5, 5));

		centerPanel.add(tfObjectNameARVR);

		centerPanel.add(tfSurveyObjectARVR);

		centerPanel.add(tfSurveyLinkARVR);

		centerPanel.add(tfAcquisitionLocationARVR);

		centerPanel.add(tfProcessingSoftwareARVR);

		centerPanel.add(tfProcessedTexturedMeshTextureSetARVR);

		centerPanel.add(tfTridimensionalDigitalTwinARVR);
		tfTridimensionalDigitalTwinARVR.setBackground(Color.LIGHT_GRAY);

		centerPanel.add(tfTridimensionalDigitalTwinDigitalScaleARVR);

		centerPanel.add(tfGeorefARVR);

		centerPanel.add(tfMeshNumberARVR);

		centerPanel.add(cmbOrientationARVR);

		centerPanel.add(tfExportedAR3DModelARVR);

		centerPanel.add(tfExporting_ARMRProjectImplementation);

		centerPanel.add(tfARMRImplementationSoftware);

		centerPanel.add(tfARVRDescription);

		centerPanel.add(tfARVRTitle);

		cmbARVRCategory.addActionListener(this);
		centerPanel.add(cmbARVRCategory);

		centerPanel.add(tfARVRPlatform);

		centerPanel.add(tfARVRCoordinates);

		cmbMatchingAlgorithmARVR.addActionListener(this);
		centerPanel.add(cmbMatchingAlgorithmARVR);

		cmbMeshingAlgorithmARVR.addActionListener(this);
		centerPanel.add(cmbMeshingAlgorithmARVR);

		JPanel rightPanel = new JPanel(new GridLayout(0, 1, 5, 5));
		rightPanel.setVisible(false);

		rightPanel.add(new JLabel(" - "));
		rightPanel.add(new JLabel(" URL: 3 | Name: 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 2 "));
		rightPanel.add(new JLabel(" Mandatory "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));

		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		btnCheckSuitabilityARVR = new JButton("Check for Suitability");
		btnCheckSuitabilityARVR.addActionListener(this);
		bottomPanel.add(btnCheckSuitabilityARVR);

		btnExportARVR = new JButton("Export Metadata");
		btnExportARVR.addActionListener(this);
		bottomPanel.add(btnExportARVR);

		btnExportWithScoreARVR = new JButton("Export Metadata & Score");
		btnExportWithScoreARVR.addActionListener(this);
		bottomPanel.add(btnExportWithScoreARVR);

		btnImportARVR = new JButton("Import Metadata");
		btnImportARVR.addActionListener(this);
		bottomPanel.add(btnImportARVR);

		JCheckBox cbToggleScore = new JCheckBox("Toggle Score Visibility");
		cbToggleScore.addActionListener(e -> {
			rightPanel.setVisible(cbToggleScore.isSelected());
			panel.revalidate(); // Refresh layout when visibility changes
			panel.repaint(); // Repaint to reflect the change
		});
		bottomPanel.add(cbToggleScore);

		panel.add(leftPanel, BorderLayout.WEST);
		panel.add(centerPanel, BorderLayout.CENTER);
		panel.add(rightPanel, BorderLayout.EAST);
		panel.add(bottomPanel, BorderLayout.SOUTH);

		return panel;
	}

	private JPanel createMobilePanel() {

		JPanel panel = new JPanel(new BorderLayout(10, 10));

		JPanel leftPanel = new JPanel(new GridLayout(0, 1, 5, 5));

		JLabel lblObjectNameMobile = new JLabel("Name of the Object:", JLabel.CENTER);
		leftPanel.add(lblObjectNameMobile);

		JButton btnSurveyObject = new JButton("SurveyObject:");
		configureButton(btnSurveyObject, "SurveyObject");
		btnSurveyObject.setBackground(Color.WHITE);
		leftPanel.add(btnSurveyObject);

		JButton btnSurveyLink = new JButton("SurveyLink:");
		configureButton(btnSurveyLink, "SurveyLink");
		btnSurveyLink.setBackground(Color.WHITE);
		leftPanel.add(btnSurveyLink);

		JButton btnAcquisitionLocation = new JButton("AcquisitionLocation:");
		configureButton(btnAcquisitionLocation, "AcquisitionLocation");
		btnAcquisitionLocation.setBackground(Color.WHITE);
		leftPanel.add(btnAcquisitionLocation);

		JButton btnAcquistionScaleObjectType = new JButton("AcquistionScaleObjectType:");
		configureButton(btnAcquistionScaleObjectType, "AcquistionScaleObjectType");
		btnAcquistionScaleObjectType.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(btnAcquistionScaleObjectType);

		JButton btnAcquisitionDate = new JButton("AcquisitionDate:");
		configureButton(btnAcquisitionDate, "AcquisitionDate");
		btnAcquisitionDate.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(btnAcquisitionDate);

		JButton btnProcessingSoftware = new JButton("ProcessingSoftware:");
		configureButton(btnProcessingSoftware, "ProcessingSoftware");
		btnProcessingSoftware.setBackground(Color.WHITE);
		leftPanel.add(btnProcessingSoftware);

		JButton btnProcessedTexturedMeshTextureSet = new JButton("ProcessedTexturedMeshTextureSet:");
		configureButton(btnProcessedTexturedMeshTextureSet, "ProcessedTexturedMeshTextureSet");
		btnProcessedTexturedMeshTextureSet.setBackground(Color.WHITE);
		leftPanel.add(btnProcessedTexturedMeshTextureSet);

		JButton btnModelling_ModifyingDescription = new JButton("Modelling_ModifyingDescription:");
		configureButton(btnModelling_ModifyingDescription, "Modelling_ModifyingDescription");
		btnModelling_ModifyingDescription.setBackground(Color.WHITE);
		leftPanel.add(btnModelling_ModifyingDescription);

		JButton btnTridimensionalDigitalTwin = new JButton("TridimensionalDigitalTwin:");
		configureButton(btnTridimensionalDigitalTwin, "TridimensionalDigitalTwin");
		btnTridimensionalDigitalTwin.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(btnTridimensionalDigitalTwin);

		JButton btnTridimensionalDigitalTwinDigitalScale = new JButton("TridimensionalDigitalTwinDigitalScale:");
		configureButton(btnTridimensionalDigitalTwinDigitalScale, "TridimensionalDigitalTwinDigitalScale");
		btnTridimensionalDigitalTwinDigitalScale.setBackground(Color.WHITE);
		leftPanel.add(btnTridimensionalDigitalTwinDigitalScale);

		JButton btnExportedAR3DModel = new JButton("ExportedAR3DModel:");
		configureButton(btnExportedAR3DModel, "ExportedAR3DModel");
		btnExportedAR3DModel.setBackground(Color.WHITE);
		leftPanel.add(btnExportedAR3DModel);

		JButton btnMobileApplicationOperationalSystem = new JButton("Mobile Application Operational System:");
		configureButton(btnMobileApplicationOperationalSystem, "Mobile Application Operational System");
		btnMobileApplicationOperationalSystem.setBackground(Color.WHITE);
		leftPanel.add(btnMobileApplicationOperationalSystem);

		JButton btnProgrammingLanguage = new JButton("Programming Language:");
		configureButton(btnProgrammingLanguage, "Programming Language");
		btnProgrammingLanguage.setBackground(Color.WHITE);
		leftPanel.add(btnProgrammingLanguage);

		JButton btnMatchingAlgorithm = new JButton("Matching Algorithm:");
		configureButton(btnMatchingAlgorithm, "MatchingAlgorithm");
		btnMatchingAlgorithm.setBackground(Color.WHITE);
		leftPanel.add(btnMatchingAlgorithm);

		JButton btnMeshingAlgorithm = new JButton("Meshing Algorithm:");
		configureButton(btnMeshingAlgorithm, "MeshingAlgorithm");
		btnMeshingAlgorithm.setBackground(Color.WHITE);
		leftPanel.add(btnMeshingAlgorithm);

		JPanel centerPanel = new JPanel(new GridLayout(0, 1, 5, 5));

		centerPanel.add(tfObjectNameMobile);

		centerPanel.add(tfSurveyObjectMobile);

		centerPanel.add(tfSurveyLinkMobile);

		centerPanel.add(tfAcquisitionLocationMobile);

		cmbAcquistionScaleObjectTypeMobile.addActionListener(this);
		centerPanel.add(cmbAcquistionScaleObjectTypeMobile);
		cmbAcquistionScaleObjectTypeMobile.setBackground(Color.LIGHT_GRAY);

		centerPanel.add(tfAcquisitionDateMobile);
		tfAcquisitionDateMobile.setBackground(Color.LIGHT_GRAY);

		centerPanel.add(tfProcessingSoftwareMobile);

		centerPanel.add(tfProcessedTexturedMeshTextureSetMobile);

		centerPanel.add(tfModelling_ModifyingDescriptionMobile);

		centerPanel.add(tfTridimensionalDigitalTwinMobile);
		tfTridimensionalDigitalTwinMobile.setBackground(Color.LIGHT_GRAY);

		centerPanel.add(tfTridimensionalDigitalTwinDigitalScaleMobile);

		centerPanel.add(tfExportedAR3DModelMobile);

		cmbMobileApplicationOperationalSystem.addActionListener(this);
		centerPanel.add(cmbMobileApplicationOperationalSystem);

		centerPanel.add(cmbProgrammingLanguage);

		cmbMatchingAlgorithmMobile.addActionListener(this);
		centerPanel.add(cmbMatchingAlgorithmMobile);

		cmbMeshingAlgorithmMobile.addActionListener(this);
		centerPanel.add(cmbMeshingAlgorithmMobile);

		JPanel rightPanel = new JPanel(new GridLayout(0, 1, 5, 5));
		rightPanel.setVisible(false);

		rightPanel.add(new JLabel(" - "));
		rightPanel.add(new JLabel(" URL: 3 | Name: 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" Mandatory "));
		rightPanel.add(new JLabel(" Mandatory "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 2 "));
		rightPanel.add(new JLabel(" 2 "));
		rightPanel.add(new JLabel(" Mandatory "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));

		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		btnCheckSuitabilityMobile = new JButton("Check for Suitability");
		btnCheckSuitabilityMobile.addActionListener(this);
		bottomPanel.add(btnCheckSuitabilityMobile);

		btnExportMobile = new JButton("Export Metadata");
		btnExportMobile.addActionListener(this);
		bottomPanel.add(btnExportMobile);

		btnExportWithScoreMobile = new JButton("Export Metadata & Score");
		btnExportWithScoreMobile.addActionListener(this);
		bottomPanel.add(btnExportWithScoreMobile);

		btnImportMobile = new JButton("Import Metadata");
		btnImportMobile.addActionListener(this);
		bottomPanel.add(btnImportMobile);

		JCheckBox cbToggleScore = new JCheckBox("Toggle Score Visibility");
		cbToggleScore.addActionListener(e -> {
			rightPanel.setVisible(cbToggleScore.isSelected());
			panel.revalidate(); // Refresh layout when visibility changes
			panel.repaint(); // Repaint to reflect the change
		});
		bottomPanel.add(cbToggleScore);

		panel.add(leftPanel, BorderLayout.WEST);
		panel.add(centerPanel, BorderLayout.CENTER);
		panel.add(rightPanel, BorderLayout.EAST);
		panel.add(bottomPanel, BorderLayout.SOUTH);

		return panel;
	}

	private JPanel createEducationalPanel() {
		JPanel panel = new JPanel(new BorderLayout(10, 10));

		JPanel leftPanel = new JPanel(new GridLayout(0, 1, 5, 5));

		JLabel lblObjectNameEducational = new JLabel("Name of the Object:", JLabel.CENTER);
		leftPanel.add(lblObjectNameEducational);

		JButton btnSurveyObject = new JButton("SurveyObject:");
		configureButton(btnSurveyObject, "SurveyObject");
		btnSurveyObject.setBackground(Color.WHITE);
		leftPanel.add(btnSurveyObject);

		JButton btnSurveyLink = new JButton("SurveyLink:");
		configureButton(btnSurveyLink, "SurveyLink");
		btnSurveyLink.setBackground(Color.WHITE);
		leftPanel.add(btnSurveyLink);

		JButton btnAcquisitionLocation = new JButton("AcquisitionLocation:");
		configureButton(btnAcquisitionLocation, "AcquisitionLocation");
		btnAcquisitionLocation.setBackground(Color.WHITE);
		leftPanel.add(btnAcquisitionLocation);

		JButton btnAcquistionScaleObjectType = new JButton("AcquistionScaleObjectType:");
		configureButton(btnAcquistionScaleObjectType, "AcquistionScaleObjectType");
		btnAcquistionScaleObjectType.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(btnAcquistionScaleObjectType);

		JButton btnAcquisitionDate = new JButton("AcquisitionDate:");
		configureButton(btnAcquisitionDate, "AcquisitionDate");
		btnAcquisitionDate.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(btnAcquisitionDate);

		JButton btnProcessedDensifiedPointCloud = new JButton("ProcessedDensifiedPointCloud:");
		configureButton(btnProcessedDensifiedPointCloud, "ProcessedDensifiedPointCloud");
		btnProcessedDensifiedPointCloud.setBackground(Color.WHITE);
		leftPanel.add(btnProcessedDensifiedPointCloud);

		JButton btnProcessingSoftware = new JButton("ProcessingSoftware:");
		configureButton(btnProcessingSoftware, "ProcessingSoftware");
		btnProcessingSoftware.setBackground(Color.WHITE);
		leftPanel.add(btnProcessingSoftware);

		JButton btnProcessedTexturedMeshTextureSet = new JButton("ProcessedTexturedMeshTextureSet:");
		configureButton(btnProcessedTexturedMeshTextureSet, "ProcessedTexturedMeshTextureSet");
		btnProcessedTexturedMeshTextureSet.setBackground(Color.WHITE);
		leftPanel.add(btnProcessedTexturedMeshTextureSet);

		JButton btnModelling_ModifyingDescription = new JButton("Modelling_ModifyingDescription:");
		configureButton(btnModelling_ModifyingDescription, "Modelling_ModifyingDescription");
		btnModelling_ModifyingDescription.setBackground(Color.WHITE);
		leftPanel.add(btnModelling_ModifyingDescription);

		JButton btnTridimensionalDigitalTwin = new JButton("TridimensionalDigitalTwin:");
		configureButton(btnTridimensionalDigitalTwin, "TridimensionalDigitalTwin");
		btnTridimensionalDigitalTwin.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(btnTridimensionalDigitalTwin);

		JButton btnTridimensionalDigitalTwinDigitalScale = new JButton("TridimensionalDigitalTwinDigitalScale:");
		configureButton(btnTridimensionalDigitalTwinDigitalScale, "TridimensionalDigitalTwinDigitalScale");
		btnTridimensionalDigitalTwinDigitalScale.setBackground(Color.WHITE);
		leftPanel.add(btnTridimensionalDigitalTwinDigitalScale);

		JButton btnExportedAR3DModel = new JButton("ExportedAR3DModel:");
		configureButton(btnExportedAR3DModel, "ExportedAR3DModel");
		btnExportedAR3DModel.setBackground(Color.WHITE);
		leftPanel.add(btnExportedAR3DModel);

		JButton btnEducationalPlatformURL = new JButton("Educational Platform URL:");
		configureButton(btnEducationalPlatformURL, "Educational Platform URL");
		btnEducationalPlatformURL.setBackground(Color.WHITE);
		leftPanel.add(btnEducationalPlatformURL);

		JButton btnEducationalPlatformSupportedBrowser = new JButton("Educational Platform supported browser:");
		configureButton(btnEducationalPlatformSupportedBrowser, "Educational Platform supported browser");
		btnEducationalPlatformSupportedBrowser.setBackground(Color.WHITE);
		leftPanel.add(btnEducationalPlatformSupportedBrowser);

		JLabel lblSelectedBrowsers = new JLabel("Selected Browsers:", JLabel.CENTER);
		leftPanel.add(lblSelectedBrowsers);

		JButton btnEducationalPlatformServerWeb = new JButton("Educational Platform Server Web:");
		configureButton(btnEducationalPlatformServerWeb, "Educational Platform Server Web");
		btnEducationalPlatformServerWeb.setBackground(Color.WHITE);
		leftPanel.add(btnEducationalPlatformServerWeb);

		JButton btnMatchingAlgorithm = new JButton("Matching Algorithm:");
		configureButton(btnMatchingAlgorithm, "MatchingAlgorithm");
		btnMatchingAlgorithm.setBackground(Color.WHITE);
		leftPanel.add(btnMatchingAlgorithm);

		JButton btnMeshingAlgorithm = new JButton("Meshing Algorithm:");
		configureButton(btnMeshingAlgorithm, "MeshingAlgorithm");
		btnMeshingAlgorithm.setBackground(Color.WHITE);
		leftPanel.add(btnMeshingAlgorithm);

		JPanel centerPanel = new JPanel(new GridLayout(0, 1, 5, 5));

		centerPanel.add(tfObjectNameEducational);

		centerPanel.add(tfSurveyObjectEducational);

		centerPanel.add(tfSurveyLinkEducational);

		centerPanel.add(tfAcquisitionLocationEducational);

		cmbAcquistionScaleObjectTypeEducational.addActionListener(this);
		centerPanel.add(cmbAcquistionScaleObjectTypeEducational);
		cmbAcquistionScaleObjectTypeEducational.setBackground(Color.LIGHT_GRAY);

		centerPanel.add(tfAcquisitionDateEducational);
		tfAcquisitionDateEducational.setBackground(Color.LIGHT_GRAY);

		centerPanel.add(tfProcessedDensifiedPointCloud);

		centerPanel.add(tfProcessingSoftwareEducational);

		centerPanel.add(tfProcessedTexturedMeshTextureSetEducational);

		centerPanel.add(tfModelling_ModifyingDescriptionEducational);

		centerPanel.add(tfTridimensionalDigitalTwinEducational);
		tfTridimensionalDigitalTwinEducational.setBackground(Color.LIGHT_GRAY);

		centerPanel.add(tfTridimensionalDigitalTwinDigitalScaleEducational);

		centerPanel.add(tfExportedAR3DModelEducational);

		centerPanel.add(tfEducationalPlatformURL);

		JButton btnSelectBrowser = new JButton("Select all Browsers");
		btnSelectBrowser.setBackground(Color.WHITE);
		centerPanel.add(btnSelectBrowser);

		String[] browserOptions = { "Google Chrome", "Mozilla Firefox", "Safari", "Microsoft Edge", "Opera", "Brave",
				"Vivaldi", "Chromium", "UC Browser", "Tor Browser", "Epiphany", "Maxthon", "Pale Moon", "Waterfox",
				"Midori", "Lynx", "QuteBrowser" };

		JPopupMenu popupMenu = new JPopupMenu();
		cbSupportedBrowsers = new JCheckBox[browserOptions.length];
		for (int i = 0; i < browserOptions.length; i++) {
			cbSupportedBrowsers[i] = new JCheckBox(browserOptions[i]);
			popupMenu.add(cbSupportedBrowsers[i]);
		}
		btnSelectBrowser.addActionListener(e -> {
			popupMenu.show(btnSelectBrowser, 0, btnSelectBrowser.getHeight());
		});
		JButton btnConfirmSelection = new JButton("Confirm Selection");
		btnConfirmSelection.addActionListener(e -> {
			for (JCheckBox checkBox : cbSupportedBrowsers) {
				if (checkBox.isSelected()) {
					if (selectedBrowsers.length() > 0)
						selectedBrowsers.append(", ");
					selectedBrowsers.append(checkBox.getText());
				}
			}
			tfSelectedBrowsers.setText(selectedBrowsers.toString());
			popupMenu.setVisible(false);
		});
		popupMenu.addSeparator();
		popupMenu.add(btnConfirmSelection);

		centerPanel.add(tfSelectedBrowsers);
		tfSelectedBrowsers.setEditable(true);

		centerPanel.add(tfEducationalPlatformServerWeb);

		cmbMatchingAlgorithmEducational.addActionListener(this);
		centerPanel.add(cmbMatchingAlgorithmEducational);

		cmbMeshingAlgorithmEducational.addActionListener(this);
		centerPanel.add(cmbMeshingAlgorithmEducational);

		JPanel rightPanel = new JPanel(new GridLayout(0, 1, 5, 5));
		rightPanel.setVisible(false);

		rightPanel.add(new JLabel(" - "));
		rightPanel.add(new JLabel(" URL: 3 | Name: 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" Mandatory "));
		rightPanel.add(new JLabel(" Mandatory "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 2 "));
		rightPanel.add(new JLabel(" 2 "));
		rightPanel.add(new JLabel(" Mandatory "));
		rightPanel.add(new JLabel(" 3 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" - "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));
		rightPanel.add(new JLabel(" 1 "));

		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		btnCheckSuitabilityEducational = new JButton("Check for Suitability");
		btnCheckSuitabilityEducational.addActionListener(this);
		bottomPanel.add(btnCheckSuitabilityEducational);

		btnExportEducational = new JButton("Export Metadata");
		btnExportEducational.addActionListener(this);
		bottomPanel.add(btnExportEducational);

		btnExportWithScoreEducational = new JButton("Export Metadata & Score");
		btnExportWithScoreEducational.addActionListener(this);
		bottomPanel.add(btnExportWithScoreEducational);

		btnImportEducational = new JButton("Import Metadata");
		btnImportEducational.addActionListener(this);
		bottomPanel.add(btnImportEducational);

		JCheckBox cbToggleScore = new JCheckBox("Toggle Score Visibility");
		cbToggleScore.addActionListener(e -> {
			rightPanel.setVisible(cbToggleScore.isSelected());
			panel.revalidate(); // Refresh layout when visibility changes
			panel.repaint(); // Repaint to reflect the change
		});
		bottomPanel.add(cbToggleScore);

		panel.add(leftPanel, BorderLayout.WEST);
		panel.add(centerPanel, BorderLayout.CENTER);
		panel.add(rightPanel, BorderLayout.EAST);
		panel.add(bottomPanel, BorderLayout.SOUTH);

		return panel;
	}

	private void initializeRules() {
		videoRules = new Rules(21); // set threshold for score
		arvrRules = new Rules(21);
		mobileRules = new Rules(21);
		educationalRules = new Rules(21);
		String urlCheckVideo;
		String urlCheckARVR;
		String urlCheckMobile;
		String urlCheckEducational;

		urlCheckVideo = tfSurveyObjectVideo.getText();
		if (urlCheckVideo.contains("http")) {
			videoRules.addFieldWeight(tfSurveyObjectVideo, 3);
		} else
			videoRules.addFieldWeight(tfSurveyObjectVideo, 1);

		urlCheckARVR = tfSurveyObjectARVR.getText();
		if (urlCheckARVR.contains("http")) {
			arvrRules.addFieldWeight(tfSurveyObjectARVR, 3);
		} else
			arvrRules.addFieldWeight(tfSurveyObjectARVR, 1);

		urlCheckMobile = tfSurveyObjectMobile.getText();
		if (urlCheckMobile.contains("http")) {
			mobileRules.addFieldWeight(tfSurveyObjectMobile, 3);
		} else
			mobileRules.addFieldWeight(tfSurveyObjectMobile, 1);

		urlCheckEducational = tfSurveyObjectEducational.getText();
		if (urlCheckEducational.contains("http")) {
			educationalRules.addFieldWeight(tfSurveyObjectEducational, 3);
		} else
			educationalRules.addFieldWeight(tfSurveyObjectEducational, 1);

		videoRules.addFieldWeight(tfSurveyLinkVideo, 1);
		arvrRules.addFieldWeight(tfSurveyLinkARVR, 1);
		mobileRules.addFieldWeight(tfSurveyLinkMobile, 1);
		educationalRules.addFieldWeight(tfSurveyLinkEducational, 1);
		videoRules.addFieldWeight(tfAcquisitionLocationVideo, 3);
		arvrRules.addFieldWeight(tfAcquisitionLocationARVR, 3);
		mobileRules.addFieldWeight(tfAcquisitionLocationMobile, 3);
		educationalRules.addFieldWeight(tfAcquisitionLocationEducational, 3);
		videoRules.addFieldWeight(tfProcessingSoftwareVideo, 3);
		arvrRules.addFieldWeight(tfProcessingSoftwareARVR, 3);
		mobileRules.addFieldWeight(tfProcessingSoftwareMobile, 3);
		educationalRules.addFieldWeight(tfProcessingSoftwareEducational, 3);
		videoRules.addFieldWeight(tfProcessedTexturedMeshTextureSetVideo, 2);
		arvrRules.addFieldWeight(tfProcessedTexturedMeshTextureSetARVR, 2);
		mobileRules.addFieldWeight(tfProcessedTexturedMeshTextureSetMobile, 2);
		educationalRules.addFieldWeight(tfProcessedTexturedMeshTextureSetEducational, 2);
		videoRules.addFieldWeight(tfModelling_ModifyingDescriptionVideo, 2);
		mobileRules.addFieldWeight(tfModelling_ModifyingDescriptionMobile, 2);
		educationalRules.addFieldWeight(tfModelling_ModifyingDescriptionEducational, 2);
		videoRules.addFieldWeight(tfTridimensionalDigitalTwinVideo, 3);
		arvrRules.addFieldWeight(tfTridimensionalDigitalTwinARVR, 3);
		mobileRules.addFieldWeight(tfTridimensionalDigitalTwinMobile, 3);
		educationalRules.addFieldWeight(tfTridimensionalDigitalTwinEducational, 3);
		videoRules.addFieldWeight(tfTridimensionalDigitalTwinDigitalScaleVideo, 3);
		arvrRules.addFieldWeight(tfTridimensionalDigitalTwinDigitalScaleARVR, 3);
		mobileRules.addFieldWeight(tfTridimensionalDigitalTwinDigitalScaleMobile, 3);
		educationalRules.addFieldWeight(tfTridimensionalDigitalTwinDigitalScaleEducational, 3);
		videoRules.addFieldWeight(tfFinalPurpose, 3);
		videoRules.addFieldWeight(tfExported3DModelVideoRendering, 1);
		videoRules.addFieldWeight(tfExporting_EditingRenderingVideo, 1);
		videoRules.addFieldWeight(tfExporting_EditingRenderingVideoSoftware, 1);
		videoRules.addFieldWeight(tfExportedVideo3DRendering, 1);
		videoRules.addFieldWeight(tfVideoResolution, 1);
		videoRules.addFieldWeight(tfVideoDuration, 1);
		arvrRules.addFieldWeight(tfExportedAR3DModelARVR, 1);
		mobileRules.addFieldWeight(tfExportedAR3DModelMobile, 1);
		educationalRules.addFieldWeight(tfExportedAR3DModelEducational, 1);
		arvrRules.addFieldWeight(tfExporting_ARMRProjectImplementation, 1);
		arvrRules.addFieldWeight(tfARMRImplementationSoftware, 1);
		arvrRules.addFieldWeight(tfARVRDescription, 1);
		arvrRules.addFieldWeight(tfARVRTitle, 1);
		arvrRules.addFieldWeight(tfARVRPlatform, 1);
		arvrRules.addFieldWeight(tfARVRCoordinates, 1);
		mobileRules.addFieldWeight(tfAcquisitionDateMobile, 3);
		educationalRules.addFieldWeight(tfAcquisitionDateEducational, 3);
		educationalRules.addFieldWeight(tfProcessedDensifiedPointCloud, 3);
		educationalRules.addFieldWeight(tfEducationalPlatformServerWeb, 1);
		educationalRules.addFieldWeight(tfEducationalPlatformURL, 1);
		educationalRules.addFieldWeight(tfSelectedBrowsers, 1);
		videoRules.addFieldWeight(tfGeorefVideo, 3);
		videoRules.addFieldWeight(tfMeshNumberVideo, 3);
		arvrRules.addFieldWeight(tfGeorefARVR, 3);
		arvrRules.addFieldWeight(tfMeshNumberARVR, 3);

		videoRules.addDropdownWeight(cmbMatchingAlgorithmVideo, 1);
		videoRules.addDropdownWeight(cmbMeshingAlgorithmVideo, 1);
		arvrRules.addDropdownWeight(cmbMatchingAlgorithmARVR, 1);
		arvrRules.addDropdownWeight(cmbMeshingAlgorithmARVR, 1);
		mobileRules.addDropdownWeight(cmbMatchingAlgorithmMobile, 1);
		mobileRules.addDropdownWeight(cmbMeshingAlgorithmMobile, 1);
		educationalRules.addDropdownWeight(cmbMatchingAlgorithmEducational, 1);
		educationalRules.addDropdownWeight(cmbMeshingAlgorithmEducational, 1);
		arvrRules.addDropdownWeight(cmbARVRCategory, 1);
		mobileRules.addDropdownWeight(cmbMobileApplicationOperationalSystem, 1);
		videoRules.addDropdownWeight(cmbVideoFormat, 1);
		mobileRules.addDropdownWeight(cmbAcquistionScaleObjectTypeMobile, 3);
		educationalRules.addDropdownWeight(cmbAcquistionScaleObjectTypeEducational, 3);
		mobileRules.addDropdownWeight(cmbProgrammingLanguage, 1);
		videoRules.addDropdownWeight(cmbOrientationVideo, 3);
		arvrRules.addDropdownWeight(cmbOrientationARVR, 3);

		educationalRules.addMandatoryField(tfTridimensionalDigitalTwinEducational);
		educationalRules.addMandatoryField(tfAcquisitionDateEducational);
		educationalRules.addMandatoryComboBox(cmbAcquistionScaleObjectTypeEducational, "Select Scale");
		mobileRules.addMandatoryField(tfTridimensionalDigitalTwinMobile);
		mobileRules.addMandatoryField(tfAcquisitionDateMobile);
		mobileRules.addMandatoryComboBox(cmbAcquistionScaleObjectTypeMobile, "Select Scale");
		arvrRules.addMandatoryField(tfTridimensionalDigitalTwinARVR);
		videoRules.addMandatoryField(tfTridimensionalDigitalTwinVideo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (e.getSource() == cmbUseCase) {
			String selectedUseCase = (String) cmbUseCase.getSelectedItem();
			System.out.println("Use case selected: " + selectedUseCase);

			switch (selectedUseCase) {
			case "Please Select a Use Case":
				currentPanel = "Selection";
				cardLayout.show(cardPanel, "Selection");
				break;
			case "Video Rendering of the 3D Model":
				currentPanel = "Video Rendering";
				cardLayout.show(cardPanel, "Video Rendering");
				break;
			case "3D Model for AR/VR Projects":
				currentPanel = "AR/VR";
				cardLayout.show(cardPanel, "AR/VR");
				break;
			case "3D Model for Mobile Applications":
				currentPanel = "Mobile";
				cardLayout.show(cardPanel, "Mobile");
				break;
			case "3D Model for Online Educational Platforms":
				currentPanel = "Educational";
				cardLayout.show(cardPanel, "Educational");
				break;
			default:
				System.out.println("Unknown use case: " + selectedUseCase);
				currentPanel = "Selection";
				cardLayout.show(cardPanel, "Selection");
				break;
			}
			System.out.println("Current panel set to: " + currentPanel);
		} else {
			log.setText("");
			String message = definitions.getOrDefault(command, "");
			log.setText(message);
		}
		if (e.getSource() == btnImportVideo || e.getSource() == btnImportARVR || e.getSource() == btnImportMobile
				|| e.getSource() == btnImportEducational) {
			log.append("");
			log.append("Please select a JSON-File created with T.i.A.M.A.T");
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				log.setText(" ");
				log.append("Opening: " + file.getName() + "." + '\n');
				try (Scanner scanner = new Scanner(file)) {
					StringBuilder jsonContent = new StringBuilder();
					while (scanner.hasNextLine()) {
						jsonContent.append(scanner.nextLine());
					}

					JSONObject jsonObject = new JSONObject(jsonContent.toString());
					HashMap<String, JTextField> fieldMap;
					HashMap<String, JComboBox<String>> comboBoxMap = null;

					if (jsonObject.has("Created in T.i.A.M.A.T")) {

						switch (currentPanel) {
						case "Video Rendering":
							fieldMap = videoFieldMap;
							comboBoxMap = videoComboBoxMap;
							break;
						case "AR/VR":
							fieldMap = arvrFieldMap;
							comboBoxMap = arvrComboBoxMap;
							break;
						case "Mobile":
							fieldMap = mobileFieldMap;
							comboBoxMap = mobileComboBoxMap;
							break;
						case "Educational":
							fieldMap = educationalFieldMap;
							comboBoxMap = educationalComboBoxMap;
							break;
						default:
							log.append("Unrecognized panel: " + currentPanel + "\n");
							return;
						}

						for (String key : jsonObject.keySet()) {
							JSONObject innerObject = jsonObject.getJSONObject(key);
							if (innerObject.has("value")) {
								String value = innerObject.getString("value");

								// Update text fields
								if (fieldMap.containsKey(key)) {
									JTextField field = fieldMap.get(key);
									if (field != null) {
										field.setText(value);
									}
								}
								// Update combo boxes
								if (comboBoxMap != null && comboBoxMap.containsKey(key)) {
									JComboBox<String> comboBoxSelection = comboBoxMap.get(key);
									if (comboBoxSelection != null) {
										comboBoxSelection.setSelectedItem(value);
									}
								}
							}
						}
						log.append("File successfully imported and fields updated.\n");

					} else {
						log.append(
								"Please import a File that was created in T.i.A.M.A.T to automatically have the metadata fields updated.");
					}
				} catch (FileNotFoundException ex) {
					log.append("Error reading file: " + ex.getMessage() + "\n");
				} catch (Exception ex) {
					log.append("Error processing JSON: " + ex.getMessage() + "\n");
				}
			}
		}
		if (e.getSource() == btnCheckSuitabilityVideo || e.getSource() == btnCheckSuitabilityARVR
				|| e.getSource() == btnCheckSuitabilityMobile || e.getSource() == btnCheckSuitabilityEducational)

		{
			log.setText("");
			if ("Video Rendering".equals(currentPanel)) {
				String feedback = videoRules.getFeedbackMessage();
				log.setText(feedback);
			} else if ("AR/VR".equals(currentPanel)) {
				String feedback = arvrRules.getFeedbackMessage();
				log.setText(feedback);
			} else if ("Mobile".equals(currentPanel)) {
				String feedback = mobileRules.getFeedbackMessage();
				log.setText(feedback);

			} else if ("Educational".equals(currentPanel)) {
				String feedback = educationalRules.getFeedbackMessage();
				log.setText(feedback);
			}

		} else if (e.getSource() == btnExportVideo || e.getSource() == btnExportARVR || e.getSource() == btnExportMobile
				|| e.getSource() == btnExportEducational) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Choose where to save the File");

			String defaultFileName = "metadata_";
			if ("Video Rendering".equals(currentPanel)) {
				defaultFileName += tfTridimensionalDigitalTwinDigitalScaleVideo.getText() + tfObjectNameVideo.getText();
			} else if ("AR/VR".equals(currentPanel)) {
				defaultFileName += tfTridimensionalDigitalTwinDigitalScaleARVR.getText() + tfObjectNameARVR.getText();
			} else if ("Mobile".equals(currentPanel)) {
				defaultFileName += tfAcquisitionDateMobile.getText()
						+ tfTridimensionalDigitalTwinDigitalScaleMobile.getText() + tfObjectNameMobile.getText();
			} else if ("Educational".equals(currentPanel)) {
				defaultFileName += tfAcquisitionDateEducational.getText()
						+ tfTridimensionalDigitalTwinDigitalScaleEducational.getText()
						+ tfObjectNameEducational.getText();
			}
			// Normalize Invalid Characters and White Space
			defaultFileName = defaultFileName.replaceAll("[/\\\\*?<>|:]", "_").replaceAll("\\s+", "_");

			// set Default Name for file
			fileChooser.setSelectedFile(new java.io.File(defaultFileName));

			int userSelection = fileChooser.showSaveDialog(this);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				try {
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();
					if (!filePath.endsWith(".json")) {
						filePath += ".json";
					}
					JSONObject metadata = new JSONObject();
					if (currentPanel.equals("Video Rendering")) {
						JSONObject objectNameVideo = new JSONObject();
						objectNameVideo.put("value", tfObjectNameVideo.getText());

						JSONObject surveyObjectVideo = new JSONObject();
						surveyObjectVideo.put("value", tfSurveyObjectVideo.getText());
						surveyObjectVideo.put("Scope Note",
								"Survey Object denotes any object subjected to photogrammetric surveying or any kind of digital surveying. It represents the target of data acquisition processes, crucial for generating detailed digital records, analyses, and reconstructions within the FOPPA model for archaeological documentation. It must be a solid and visible object. The expression visible means that it interacts with light");

						JSONObject SurveyLinkVideo = new JSONObject();
						SurveyLinkVideo.put("value", tfSurveyLinkVideo.getText());

						JSONObject AcquisitionLocationVideo = new JSONObject();
						AcquisitionLocationVideo.put("value", tfAcquisitionLocationVideo.getText());
						AcquisitionLocationVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/128#F42_Place_Of_Acquisition");

						JSONObject ProcessingSoftwareVideo = new JSONObject();
						ProcessingSoftwareVideo.put("value", tfProcessingSoftwareVideo.getText());
						ProcessingSoftwareVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/117#F31_Processing_Software");

						JSONObject ProcessedTexturedMeshTextureSetVideo = new JSONObject();
						ProcessedTexturedMeshTextureSetVideo.put("value",
								tfProcessedTexturedMeshTextureSetVideo.getText());
						ProcessedTexturedMeshTextureSetVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/149#F62_Texture_Set_of_3D_Mesh");

						JSONObject Modelling_ModifyingDescriptionVideo = new JSONObject();
						Modelling_ModifyingDescriptionVideo.put("value",
								tfModelling_ModifyingDescriptionVideo.getText());
						Modelling_ModifyingDescriptionVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/151#F64_Modelling_Description");

						JSONObject TridimensionalDigitalTwinVideo = new JSONObject();
						TridimensionalDigitalTwinVideo.put("value", tfTridimensionalDigitalTwinVideo.getText());
						TridimensionalDigitalTwinVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/145#F100_3D_Digital_Twin");

						JSONObject TridimensionalDigitalTwinDigitalScaleVideo = new JSONObject();
						TridimensionalDigitalTwinDigitalScaleVideo.put("value",
								tfTridimensionalDigitalTwinDigitalScaleVideo.getText());
						TridimensionalDigitalTwinDigitalScaleVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/146#F59_Digital_Scale");

						JSONObject FinalPurpose = new JSONObject();
						FinalPurpose.put("value", tfFinalPurpose.getText());
						FinalPurpose.put("IRI",
								"https://photogrammetry.altervista.org/items/show/158#F71_Final_Use_of_Digital_Twin");

						JSONObject GeorefVideo = new JSONObject();
						GeorefVideo.put("value", tfGeorefVideo.getText());
						GeorefVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/333#F154_Georeferencing_of_the_3D_Model");

						JSONObject MeshNumberVideo = new JSONObject();
						MeshNumberVideo.put("value", tfMeshNumberVideo.getText());
						MeshNumberVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/335#F156_Model_Composition_from_Multiple_Parts");

						JSONObject orientationVideo = new JSONObject();
						orientationVideo.put("value", cmbOrientationVideo.getSelectedItem());
						orientationVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/334#F155_Orientation_of_the_3D_ModelS");

						JSONObject Exported3DModelVideoRendering = new JSONObject();
						Exported3DModelVideoRendering.put("value", tfExported3DModelVideoRendering.getText());
						Exported3DModelVideoRendering.put("IRI",
								"https://photogrammetry.altervista.org/items/show/159#F72_3D_Model_Video_Rendering");

						JSONObject Exporting_EditingRenderingVideo = new JSONObject();
						Exporting_EditingRenderingVideo.put("value", tfExporting_EditingRenderingVideo.getText());
						Exporting_EditingRenderingVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/160#F73_Editing_Video");

						JSONObject Exporting_EditingRenderingVideoSoftware = new JSONObject();
						Exporting_EditingRenderingVideoSoftware.put("value",
								tfExporting_EditingRenderingVideoSoftware.getText());
						Exporting_EditingRenderingVideoSoftware.put("IRI",
								"https://photogrammetry.altervista.org/items/show/161#F74_Video_Editing_Software");

						JSONObject ExportedVideo3DRendering = new JSONObject();
						ExportedVideo3DRendering.put("value", tfExportedVideo3DRendering.getText());
						ExportedVideo3DRendering.put("IRI",
								"https://photogrammetry.altervista.org/items/show/162#F75_Project_Video");

						JSONObject VideoFormat = new JSONObject();
						VideoFormat.put("value", cmbVideoFormat.getSelectedItem());
						VideoFormat.put("IRI", "https://photogrammetry.altervista.org/items/show/290");

						JSONObject VideoResolution = new JSONObject();
						VideoResolution.put("value", tfVideoResolution.getText());
						VideoResolution.put("IRI",
								"https://photogrammetry.altervista.org/items/show/291#F112_Video_Resolution");

						JSONObject VideoDuration = new JSONObject();
						VideoDuration.put("value", tfVideoDuration.getText());
						VideoDuration.put("IRI",
								"https://photogrammetry.altervista.org/items/show/292#F113_Video_Duration");

						JSONObject MatchingAlgorithmVideo = new JSONObject();
						MatchingAlgorithmVideo.put("value", cmbMatchingAlgorithmVideo.getSelectedItem());

						JSONObject MeshingAlgorithmVideo = new JSONObject();
						MeshingAlgorithmVideo.put("value", cmbMeshingAlgorithmVideo.getSelectedItem());

						JSONObject tiamatApproved = new JSONObject();
						tiamatApproved.put("value", "true");

						metadata.put("Created in T.i.A.M.A.T", tiamatApproved);
						metadata.put("Name of the Object", objectNameVideo);
						metadata.put("F1 SurveyObject", surveyObjectVideo);
						metadata.put("SurveyLink", SurveyLinkVideo);
						metadata.put("F42 AcquisitionLocation", AcquisitionLocationVideo);
						metadata.put("F31 ProcessingSoftware", ProcessingSoftwareVideo);
						metadata.put("F62 ProcessedTexturedMeshTextureSet", ProcessedTexturedMeshTextureSetVideo);
						metadata.put("F64 Modelling_ModifyingDescription", Modelling_ModifyingDescriptionVideo);
						metadata.put("F100 TridimensionalDigitalTwin", TridimensionalDigitalTwinVideo);
						metadata.put("F59 TridimensionalDigitalTwinDigitalScale",
								TridimensionalDigitalTwinDigitalScaleVideo);
						metadata.put("F71 FinalPurpose", FinalPurpose);
						metadata.put("F154 Georeferencing_3DModel", GeorefVideo);
						metadata.put("F156 ModelComposition_MultipleParts", MeshNumberVideo);
						metadata.put("F155 Orientation_3DModel", orientationVideo);
						metadata.put("F72 Exported3DModelVideoRendering", Exported3DModelVideoRendering);
						metadata.put("F73 Exporting_EditingRenderingVideo", Exporting_EditingRenderingVideo);
						metadata.put("F74 Exporting_EditingRenderingVideoSoftware",
								Exporting_EditingRenderingVideoSoftware);
						metadata.put("F75 ExportedVideo3DRendering", ExportedVideo3DRendering);
						metadata.put("F111 VideoFormat", VideoFormat);
						metadata.put("F112 VideoResolution", VideoResolution);
						metadata.put("F113 VideoDuration", VideoDuration);
						metadata.put("F21 Matching Algorithm", MatchingAlgorithmVideo);
						metadata.put("F23 Meshing Algorithm", MeshingAlgorithmVideo);
						log.setText("Metadata successfully saved to: " + filePath);

					} else if (currentPanel.equals("AR/VR")) {
						JSONObject ObjectNameARVR = new JSONObject();
						ObjectNameARVR.put("value", tfObjectNameARVR.getText());

						JSONObject SurveyObjectARVR = new JSONObject();
						SurveyObjectARVR.put("value", tfSurveyObjectARVR.getText());
						SurveyObjectARVR.put("Scope Note",
								"Survey Object denotes any object subjected to photogrammetric surveying or any kind of digital surveying. It represents the target of data acquisition processes, crucial for generating detailed digital records, analyses, and reconstructions within the FOPPA model for archaeological documentation. It must be a solid and visible object. The expression visible means that it interacts with light");

						JSONObject SurveyLinkARVR = new JSONObject();
						SurveyLinkARVR.put("value", tfSurveyLinkARVR.getText());

						JSONObject AcquisitionLocationARVR = new JSONObject();
						AcquisitionLocationARVR.put("value", tfAcquisitionLocationARVR.getText());
						AcquisitionLocationARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/128#F42_Place_Of_Acquisition");

						JSONObject ProcessingSoftwareARVR = new JSONObject();
						ProcessingSoftwareARVR.put("value", tfProcessingSoftwareARVR.getText());
						ProcessingSoftwareARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/117#F31_Processing_Software");

						JSONObject ProcessedTexturedMeshTextureSetARVR = new JSONObject();
						ProcessedTexturedMeshTextureSetARVR.put("value",
								tfProcessedTexturedMeshTextureSetARVR.getText());
						ProcessedTexturedMeshTextureSetARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/149#F62_Texture_Set_of_3D_Mesh");

						JSONObject TridimensionalDigitalTwinARVR = new JSONObject();
						TridimensionalDigitalTwinARVR.put("value", tfTridimensionalDigitalTwinARVR.getText());
						TridimensionalDigitalTwinARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/145#F100_3D_Digital_Twin");

						JSONObject TridimensionalDigitalTwinDigitalScaleARVR = new JSONObject();
						TridimensionalDigitalTwinDigitalScaleARVR.put("value",
								tfTridimensionalDigitalTwinDigitalScaleARVR.getText());
						TridimensionalDigitalTwinDigitalScaleARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/146#F59_Digital_Scale");

						JSONObject GeorefARVR = new JSONObject();
						GeorefARVR.put("value", tfGeorefARVR.getText());
						GeorefARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/333#F154_Georeferencing_of_the_3D_Model");

						JSONObject MeshNumberARVR = new JSONObject();
						MeshNumberARVR.put("value", tfMeshNumberARVR.getText());
						MeshNumberARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/335#F156_Model_Composition_from_Multiple_Parts");

						JSONObject orientationARVR = new JSONObject();
						orientationARVR.put("value", cmbOrientationARVR.getSelectedItem());
						orientationARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/334#F155_Orientation_of_the_3D_ModelS");

						JSONObject ExportedAR3DModelARVR = new JSONObject();
						ExportedAR3DModelARVR.put("value", tfExportedAR3DModelARVR.getText());
						ExportedAR3DModelARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/184#F97_AR_3D_Model");

						JSONObject Exporting_ARMRProjectImplementation = new JSONObject();
						Exporting_ARMRProjectImplementation.put("value",
								tfExporting_ARMRProjectImplementation.getText());
						Exporting_ARMRProjectImplementation.put("IRI",
								"https://photogrammetry.altervista.org/items/show/185#F98_AR/MR_Project_Implementation");

						JSONObject ARMRImplementationSoftware = new JSONObject();
						ARMRImplementationSoftware.put("value", tfARMRImplementationSoftware.getText());
						ARMRImplementationSoftware.put("IRI",
								"https://photogrammetry.altervista.org/items/show/186#F99_AR_Software_Modelling");

						JSONObject ARVRDescription = new JSONObject();
						ARVRDescription.put("value", tfARVRDescription.getText());
						ARVRDescription.put("IRI",
								"https://photogrammetry.altervista.org/items/show/293#F114_AR/VR_Project_Description");

						JSONObject ARVRTitle = new JSONObject();
						ARVRTitle.put("value", tfARVRTitle.getText());
						ARVRTitle.put("IRI",
								"https://photogrammetry.altervista.org/items/show/294#F115_AR/VR_Project_Title/DOI");

						JSONObject ARVRCategory = new JSONObject();
						ARVRCategory.put("value", cmbARVRCategory.getSelectedItem());
						ARVRCategory.put("IRI", "https://photogrammetry.altervista.org/items/show/295");

						JSONObject ARVRPlatform = new JSONObject();
						ARVRPlatform.put("value", tfARVRPlatform.getText());
						ARVRPlatform.put("IRI",
								"https://photogrammetry.altervista.org/items/show/296#F117_AR/VR_Project_Platform");

						JSONObject ARVRCoordinates = new JSONObject();
						ARVRCoordinates.put("value", tfARVRCoordinates.getText());
						ARVRCoordinates.put("IRI",
								"https://photogrammetry.altervista.org/items/show/297#F118_AR/VR_Project_Real_Coordinates");

						JSONObject MatchingAlgorithmARVR = new JSONObject();
						MatchingAlgorithmARVR.put("value", cmbMatchingAlgorithmARVR.getSelectedItem());

						JSONObject MeshingAlgorithmARVR = new JSONObject();
						MeshingAlgorithmARVR.put("value", cmbMeshingAlgorithmARVR.getSelectedItem());

						JSONObject tiamatApproved = new JSONObject();
						tiamatApproved.put("value", "true");

						metadata.put("Created in T.i.A.M.A.T", tiamatApproved);
						metadata.put("Name of the Object", ObjectNameARVR);
						metadata.put("F1 SurveyObject", SurveyObjectARVR);
						metadata.put("SurveyLink", SurveyLinkARVR);
						metadata.put("F42 AcquisitionLocation", AcquisitionLocationARVR);
						metadata.put("F31 ProcessingSoftware", ProcessingSoftwareARVR);
						metadata.put("F62 ProcessedTexturedMeshTextureSet", ProcessedTexturedMeshTextureSetARVR);
						metadata.put("F100 TridimensionalDigitalTwin", TridimensionalDigitalTwinARVR);
						metadata.put("F59 TridimensionalDigitalTwinDigitalScale",
								TridimensionalDigitalTwinDigitalScaleARVR);
						metadata.put("F154 Georeferencing_3DModel", GeorefARVR);
						metadata.put("F156 ModelComposition_MultipleParts", MeshNumberARVR);
						metadata.put("F155 Orientation_3DModel", orientationARVR);
						metadata.put("F97 Exported AR 3D Model", ExportedAR3DModelARVR);
						metadata.put("F98 AR/MR Project Implementation", Exporting_ARMRProjectImplementation);
						metadata.put("F99 AR Software Modelling", ARMRImplementationSoftware);
						metadata.put("F114 AR/VR Description", ARVRDescription);
						metadata.put("F115 Title or DOI of the AR/VR project", ARVRTitle);
						metadata.put("F116 ARVR Category", ARVRCategory);
						metadata.put("F117 Created for AR/VR Platform", ARVRPlatform);
						metadata.put("F118 Georeferenced Coordinates", ARVRCoordinates);
						metadata.put("F21 Matching Algorithm", MatchingAlgorithmARVR);
						metadata.put("F23 Meshing Algorithm", MeshingAlgorithmARVR);
						log.setText("Metadata successfully saved to: " + filePath);

					} else if (currentPanel.equals("Mobile")) {
						JSONObject ObjectNameMobile = new JSONObject();
						ObjectNameMobile.put("value", tfObjectNameMobile.getText());

						JSONObject SurveyObjectMobile = new JSONObject();
						SurveyObjectMobile.put("value", tfSurveyObjectMobile.getText());
						SurveyObjectMobile.put("Scope Note",
								"Survey Object denotes any object subjected to photogrammetric surveying or any kind of digital surveying. It represents the target of data acquisition processes, crucial for generating detailed digital records, analyses, and reconstructions within the FOPPA model for archaeological documentation. It must be a solid and visible object. The expression visible means that it interacts with light");

						JSONObject SurveyLinkMobile = new JSONObject();
						SurveyLinkMobile.put("value", tfSurveyLinkMobile.getText());

						JSONObject AcquisitionLocationMobile = new JSONObject();
						AcquisitionLocationMobile.put("value", tfAcquisitionLocationMobile.getText());
						AcquisitionLocationMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/128#F42_Place_Of_Acquisition");

						JSONObject AcquistionScaleObjectTypeMobile = new JSONObject();
						AcquistionScaleObjectTypeMobile.put("value",
								cmbAcquistionScaleObjectTypeMobile.getSelectedItem());
						AcquistionScaleObjectTypeMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/105#F19_Scale_Type");

						JSONObject AcquisitionDateMobile = new JSONObject();
						AcquisitionDateMobile.put("value", tfAcquisitionDateMobile.getText());
						AcquisitionDateMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/129#F43_Survey_Date");

						JSONObject ProcessingSoftwareMobile = new JSONObject();
						ProcessingSoftwareMobile.put("value", tfProcessingSoftwareMobile.getText());
						ProcessingSoftwareMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/117#F31_Processing_Software");

						JSONObject ProcessedTexturedMeshTextureSetMobile = new JSONObject();
						ProcessedTexturedMeshTextureSetMobile.put("value",
								tfProcessedTexturedMeshTextureSetMobile.getText());
						ProcessedTexturedMeshTextureSetMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/149#F62_Texture_Set_of_3D_Mesh");

						JSONObject Modelling_ModifyingDescriptionMobile = new JSONObject();
						Modelling_ModifyingDescriptionMobile.put("value",
								tfModelling_ModifyingDescriptionMobile.getText());
						Modelling_ModifyingDescriptionMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/151#F64_Modelling_Description");

						JSONObject TridimensionalDigitalTwinMobile = new JSONObject();
						TridimensionalDigitalTwinMobile.put("value", tfTridimensionalDigitalTwinMobile.getText());
						TridimensionalDigitalTwinMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/145#F100_3D_Digital_Twin");

						JSONObject TridimensionalDigitalTwinDigitalScaleMobile = new JSONObject();
						TridimensionalDigitalTwinDigitalScaleMobile.put("value",
								tfTridimensionalDigitalTwinDigitalScaleMobile.getText());
						TridimensionalDigitalTwinDigitalScaleMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/146#F59_Digital_Scale");

						JSONObject ExportedAR3DModelMobile = new JSONObject();
						ExportedAR3DModelMobile.put("value", tfExportedAR3DModelMobile.getText());
						ExportedAR3DModelMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/184#F97_AR_3D_Model");

						JSONObject MobileApplicationOperationalSystem = new JSONObject();
						MobileApplicationOperationalSystem.put("value",
								cmbMobileApplicationOperationalSystem.getSelectedItem());
						MobileApplicationOperationalSystem.put("IRI", "");

						JSONObject ProgrammingLanguage = new JSONObject();
						ProgrammingLanguage.put("value", cmbProgrammingLanguage.getSelectedItem());
						ProgrammingLanguage.put("IRI", "https://photogrammetry.altervista.org/items/show/298");

						JSONObject MatchingAlgorithmMobile = new JSONObject();
						MatchingAlgorithmMobile.put("value", cmbMatchingAlgorithmMobile.getSelectedItem());

						JSONObject MeshingAlgorithmMobile = new JSONObject();
						MeshingAlgorithmMobile.put("value", cmbMeshingAlgorithmMobile.getSelectedItem());

						JSONObject tiamatApproved = new JSONObject();
						tiamatApproved.put("value", "true");

						metadata.put("Created in T.i.A.M.A.T", tiamatApproved);
						metadata.put("Name of the Object", ObjectNameMobile);
						metadata.put("F1 SurveyObject", SurveyObjectMobile);
						metadata.put("SurveyLink", SurveyLinkMobile);
						metadata.put("F42 AcquisitionLocation", AcquisitionLocationMobile);
						metadata.put("F19 AcquisitionScaleObjectType", AcquistionScaleObjectTypeMobile);
						metadata.put("F43 AcquisitionDate", AcquisitionDateMobile);
						metadata.put("F31 ProcessingSoftware", ProcessingSoftwareMobile);
						metadata.put("F62 ProcessedTexturedMeshTextureSet", ProcessedTexturedMeshTextureSetMobile);
						metadata.put("F64 Modelling_ModifyingDescription", Modelling_ModifyingDescriptionMobile);
						metadata.put("F100 TridimensionalDigitalTwin", TridimensionalDigitalTwinMobile);
						metadata.put("F59 TridimensionalDigitalTwinDigitalScale",
								TridimensionalDigitalTwinDigitalScaleMobile);
						metadata.put("F97 Exported AR 3D Model", ExportedAR3DModelMobile);
						metadata.put("F119 Mobile Application Operational System", MobileApplicationOperationalSystem);
						metadata.put("F120 Programming Language", ProgrammingLanguage);
						metadata.put("F21 Matching Algorithm", MatchingAlgorithmMobile);
						metadata.put("F23 Meshing Algorithm", MeshingAlgorithmMobile);
						log.setText("Metadata successfully saved to: " + filePath);

					} else if (currentPanel.equals("Educational")) {

						JSONObject ObjectNameEducational = new JSONObject();
						ObjectNameEducational.put("value", tfObjectNameEducational.getText());

						JSONObject SurveyObjectEducational = new JSONObject();
						SurveyObjectEducational.put("value", tfSurveyObjectEducational.getText());
						SurveyObjectEducational.put("Scope Note",
								"Survey Object denotes any object subjected to photogrammetric surveying or any kind of digital surveying. It represents the target of data acquisition processes, crucial for generating detailed digital records, analyses, and reconstructions within the FOPPA model for archaeological documentation. It must be a solid and visible object. The expression visible means that it interacts with light");

						JSONObject SurveyLinkEducational = new JSONObject();
						SurveyLinkEducational.put("value", tfSurveyLinkEducational.getText());

						JSONObject AcquisitionLocationEducational = new JSONObject();
						AcquisitionLocationEducational.put("value", tfAcquisitionLocationEducational.getText());
						AcquisitionLocationEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/128#F42_Place_Of_Acquisition");

						JSONObject AcquistionScaleObjectTypeEducational = new JSONObject();
						AcquistionScaleObjectTypeEducational.put("value",
								cmbAcquistionScaleObjectTypeEducational.getSelectedItem());
						AcquistionScaleObjectTypeEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/105#F19_Scale_Type");

						JSONObject AcquisitionDateEducational = new JSONObject();
						AcquisitionDateEducational.put("value", tfAcquisitionDateEducational.getText());
						AcquisitionDateEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/129#F43_Survey_Date");

						JSONObject ProcessedDensifiedPointCloud = new JSONObject();
						ProcessedDensifiedPointCloud.put("value", tfProcessedDensifiedPointCloud.getText());
						ProcessedDensifiedPointCloud.put("IRI",
								"https://photogrammetry.altervista.org/items/show/113#F27_Densified_Point_Cloud");

						JSONObject ProcessingSoftwareEducational = new JSONObject();
						ProcessingSoftwareEducational.put("value", tfProcessingSoftwareEducational.getText());
						ProcessingSoftwareEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/117#F31_Processing_Software");

						JSONObject ProcessedTexturedMeshTextureSetEducational = new JSONObject();
						ProcessedTexturedMeshTextureSetEducational.put("value",
								tfProcessedTexturedMeshTextureSetEducational.getText());
						ProcessedTexturedMeshTextureSetEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/149#F62_Texture_Set_of_3D_Mesh");

						JSONObject Modelling_ModifyingDescriptionEducational = new JSONObject();
						Modelling_ModifyingDescriptionEducational.put("value",
								tfModelling_ModifyingDescriptionEducational.getText());
						Modelling_ModifyingDescriptionEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/151#F64_Modelling_Description");

						JSONObject TridimensionalDigitalTwinEducational = new JSONObject();
						TridimensionalDigitalTwinEducational.put("value",
								tfTridimensionalDigitalTwinEducational.getText());
						TridimensionalDigitalTwinEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/145#F100_3D_Digital_Twin");

						JSONObject TridimensionalDigitalTwinDigitalScaleEducational = new JSONObject();
						TridimensionalDigitalTwinDigitalScaleEducational.put("value",
								tfTridimensionalDigitalTwinDigitalScaleEducational.getText());
						TridimensionalDigitalTwinDigitalScaleEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/146#F59_Digital_Scale");

						JSONObject ExportedAR3DModelEducational = new JSONObject();
						ExportedAR3DModelEducational.put("value", tfExportedAR3DModelEducational.getText());
						ExportedAR3DModelEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/184#F97_AR_3D_Model");

						JSONObject EducationalPlatformURL = new JSONObject();
						EducationalPlatformURL.put("value", tfEducationalPlatformURL.getText());
						EducationalPlatformURL.put("IRI",
								"https://photogrammetry.altervista.org/items/show/300#F121_Educational_Platform_URL");

						JSONObject SelectedBrowsers = new JSONObject();
						SelectedBrowsers.put("value", tfSelectedBrowsers.getText());
						SelectedBrowsers.put("IRI",
								"https://photogrammetry.altervista.org/items/show/301#F122_Educational_Platform_Supported_Browser");

						JSONObject EducationalPlatformServerWeb = new JSONObject();
						EducationalPlatformServerWeb.put("value", tfEducationalPlatformServerWeb.getText());
						EducationalPlatformServerWeb.put("IRI",
								"https://photogrammetry.altervista.org/items/show/302#F123_Educational_Platform_Server_Web");

						JSONObject MatchingAlgorithmEducational = new JSONObject();
						MatchingAlgorithmEducational.put("value", cmbMatchingAlgorithmEducational.getSelectedItem());

						JSONObject MeshingAlgorithmEducational = new JSONObject();
						MeshingAlgorithmEducational.put("value", cmbMeshingAlgorithmEducational.getSelectedItem());

						JSONObject tiamatApproved = new JSONObject();
						tiamatApproved.put("value", "true");

						metadata.put("Created in T.i.A.M.A.T", tiamatApproved);
						metadata.put("Name of the Object", ObjectNameEducational);
						metadata.put("F1 SurveyObject", SurveyObjectEducational);
						metadata.put("SurveyLink", SurveyLinkEducational);
						metadata.put("F42 AcquisitionLocation", AcquisitionLocationEducational);
						metadata.put("F19 AcquisitionScaleObjectType", AcquistionScaleObjectTypeEducational);
						metadata.put("F43 AcquisitionDate", AcquisitionDateEducational);
						metadata.put("F27 ProcessedDensifiedPointCloud", ProcessedDensifiedPointCloud);
						metadata.put("F31 ProcessingSoftware", ProcessingSoftwareEducational);
						metadata.put("F62 ProcessedTexturedMeshTextureSet", ProcessedTexturedMeshTextureSetEducational);
						metadata.put("F64 Modelling_ModifyingDescription", Modelling_ModifyingDescriptionEducational);
						metadata.put("F100 TridimensionalDigitalTwin", TridimensionalDigitalTwinEducational);
						metadata.put("F59 TridimensionalDigitalTwinDigitalScale",
								TridimensionalDigitalTwinDigitalScaleEducational);
						metadata.put("F97 Exported AR 3D Model", ExportedAR3DModelEducational);
						metadata.put("F121 Educational Platform URL", EducationalPlatformURL);
						metadata.put("F122 Educational Platform Supported Browser(s)", SelectedBrowsers);
						metadata.put("F123 Educational Platform Server Web", EducationalPlatformServerWeb);
						metadata.put("F21 Matching Algorithm", MatchingAlgorithmEducational);
						metadata.put("F23 Meshing Algorithm", MeshingAlgorithmEducational);
						log.setText("Metadata successfully saved to: " + filePath);
					}
					try (FileWriter fileWriter = new FileWriter(filePath)) {
						fileWriter.write(metadata.toString(4)); // JSON with an indent of 4 spaces
					}
					log.setText("Metadata successfully saved to: " + filePath);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		} else if (e.getSource() == btnExportWithScoreEducational || e.getSource() == btnExportWithScoreVideo
				|| e.getSource() == btnExportWithScoreARVR || e.getSource() == btnExportWithScoreMobile) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Choose where to save the File");

			String defaultFileName = "metadata_";
			if ("Video Rendering".equals(currentPanel)) {
				defaultFileName += tfTridimensionalDigitalTwinDigitalScaleVideo.getText() + tfObjectNameVideo.getText();
			} else if ("AR/VR".equals(currentPanel)) {
				defaultFileName += tfTridimensionalDigitalTwinDigitalScaleARVR.getText() + tfObjectNameARVR.getText();
			} else if ("Mobile".equals(currentPanel)) {
				defaultFileName += tfAcquisitionDateMobile.getText()
						+ tfTridimensionalDigitalTwinDigitalScaleMobile.getText() + tfObjectNameMobile.getText();
			} else if ("Educational".equals(currentPanel)) {
				defaultFileName += tfAcquisitionDateEducational.getText()
						+ tfTridimensionalDigitalTwinDigitalScaleEducational.getText()
						+ tfObjectNameEducational.getText();
			}
			// Normalize Invalid Characters and White Space
			defaultFileName = defaultFileName.replaceAll("[/\\\\*?<>|:]", "_").replaceAll("\\s+", "_");

			// set Default Name for file
			fileChooser.setSelectedFile(new java.io.File(defaultFileName));

			int userSelection = fileChooser.showSaveDialog(this);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				try {
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();
					if (!filePath.endsWith(".json")) {
						filePath += ".json";
					}
					LinkedHashMap<String, Object> metadataMap = new LinkedHashMap<>();
					if (currentPanel.equals("Video Rendering")) {
						JSONObject objectNameVideo = new JSONObject();
						objectNameVideo.put("value", tfObjectNameVideo.getText());
						objectNameVideo.put("score", "-");

						JSONObject surveyObjectVideo = new JSONObject();
						surveyObjectVideo.put("value", tfSurveyObjectVideo.getText());
						surveyObjectVideo.put("Scope Note",
								"Survey Object denotes any object subjected to photogrammetric surveying or any kind of digital surveying. It represents the target of data acquisition processes, crucial for generating detailed digital records, analyses, and reconstructions within the FOPPA model for archaeological documentation. It must be a solid and visible object. The expression visible means that it interacts with light");
						surveyObjectVideo.put("score", "URL: 3 | Name: 1");

						JSONObject SurveyLinkVideo = new JSONObject();
						SurveyLinkVideo.put("value", tfSurveyLinkVideo.getText());
						SurveyLinkVideo.put("score", "1");

						JSONObject AcquisitionLocationVideo = new JSONObject();
						AcquisitionLocationVideo.put("value", tfAcquisitionLocationVideo.getText());
						AcquisitionLocationVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/128#F42_Place_Of_Acquisition");
						AcquisitionLocationVideo.put("score", "3");

						JSONObject ProcessingSoftwareVideo = new JSONObject();
						ProcessingSoftwareVideo.put("value", tfProcessingSoftwareVideo.getText());
						ProcessingSoftwareVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/117#F31_Processing_Software");
						ProcessingSoftwareVideo.put("score", "3");

						JSONObject ProcessedTexturedMeshTextureSetVideo = new JSONObject();
						ProcessedTexturedMeshTextureSetVideo.put("value",
								tfProcessedTexturedMeshTextureSetVideo.getText());
						ProcessedTexturedMeshTextureSetVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/149#F62_Texture_Set_of_3D_Mesh");
						ProcessedTexturedMeshTextureSetVideo.put("score", "2");

						JSONObject Modelling_ModifyingDescriptionVideo = new JSONObject();
						Modelling_ModifyingDescriptionVideo.put("value",
								tfModelling_ModifyingDescriptionVideo.getText());
						Modelling_ModifyingDescriptionVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/151#F64_Modelling_Description");
						Modelling_ModifyingDescriptionVideo.put("score", "2");

						JSONObject TridimensionalDigitalTwinVideo = new JSONObject();
						TridimensionalDigitalTwinVideo.put("value", tfTridimensionalDigitalTwinVideo.getText());
						TridimensionalDigitalTwinVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/145#F100_3D_Digital_Twin");
						TridimensionalDigitalTwinVideo.put("score", "3");

						JSONObject TridimensionalDigitalTwinDigitalScaleVideo = new JSONObject();
						TridimensionalDigitalTwinDigitalScaleVideo.put("value",
								tfTridimensionalDigitalTwinDigitalScaleVideo.getText());
						TridimensionalDigitalTwinDigitalScaleVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/146#F59_Digital_Scale");
						TridimensionalDigitalTwinDigitalScaleVideo.put("score", "3");

						JSONObject FinalPurpose = new JSONObject();
						FinalPurpose.put("value", tfFinalPurpose.getText());
						FinalPurpose.put("IRI",
								"https://photogrammetry.altervista.org/items/show/158#F71_Final_Use_of_Digital_Twin");
						FinalPurpose.put("score", "3");

						JSONObject GeorefVideo = new JSONObject();
						GeorefVideo.put("value", tfGeorefVideo.getText());
						GeorefVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/333#F154_Georeferencing_of_the_3D_Model");
						GeorefVideo.put("score", "3");

						JSONObject MeshNumberVideo = new JSONObject();
						MeshNumberVideo.put("value", tfMeshNumberVideo.getText());
						MeshNumberVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/335#F156_Model_Composition_from_Multiple_Parts");
						MeshNumberVideo.put("score", "3");

						JSONObject orientationVideo = new JSONObject();
						orientationVideo.put("value", cmbOrientationVideo.getSelectedItem());
						orientationVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/334#F155_Orientation_of_the_3D_ModelS");
						orientationVideo.put("score", "3");

						JSONObject Exported3DModelVideoRendering = new JSONObject();
						Exported3DModelVideoRendering.put("value", tfExported3DModelVideoRendering.getText());
						Exported3DModelVideoRendering.put("IRI",
								"https://photogrammetry.altervista.org/items/show/159#F72_3D_Model_Video_Rendering");
						Exported3DModelVideoRendering.put("score", "1");

						JSONObject Exporting_EditingRenderingVideo = new JSONObject();
						Exporting_EditingRenderingVideo.put("value", tfExporting_EditingRenderingVideo.getText());
						Exporting_EditingRenderingVideo.put("IRI",
								"https://photogrammetry.altervista.org/items/show/160#F73_Editing_Video");
						Exporting_EditingRenderingVideo.put("score", "1");

						JSONObject Exporting_EditingRenderingVideoSoftware = new JSONObject();
						Exporting_EditingRenderingVideoSoftware.put("value",
								tfExporting_EditingRenderingVideoSoftware.getText());
						Exporting_EditingRenderingVideoSoftware.put("IRI",
								"https://photogrammetry.altervista.org/items/show/161#F74_Video_Editing_Software");
						Exporting_EditingRenderingVideoSoftware.put("score", "1");

						JSONObject ExportedVideo3DRendering = new JSONObject();
						ExportedVideo3DRendering.put("value", tfExportedVideo3DRendering.getText());
						ExportedVideo3DRendering.put("IRI",
								"https://photogrammetry.altervista.org/items/show/162#F75_Project_Video");
						ExportedVideo3DRendering.put("score", "1");

						JSONObject VideoFormat = new JSONObject();
						VideoFormat.put("value", cmbVideoFormat.getSelectedItem());
						VideoFormat.put("IRI", "https://photogrammetry.altervista.org/items/show/290");
						VideoFormat.put("score", "1");

						JSONObject VideoResolution = new JSONObject();
						VideoResolution.put("value", tfVideoResolution.getText());
						VideoResolution.put("IRI",
								"https://photogrammetry.altervista.org/items/show/291#F112_Video_Resolution");
						VideoResolution.put("score", "1");

						JSONObject VideoDuration = new JSONObject();
						VideoDuration.put("value", tfVideoDuration.getText());
						VideoDuration.put("IRI",
								"https://photogrammetry.altervista.org/items/show/292#F113_Video_Duration");
						VideoDuration.put("score", "1");

						JSONObject MatchingAlgorithmVideo = new JSONObject();
						MatchingAlgorithmVideo.put("value", cmbMatchingAlgorithmVideo.getSelectedItem());
						MatchingAlgorithmVideo.put("score", "1");

						JSONObject MeshingAlgorithmVideo = new JSONObject();
						MeshingAlgorithmVideo.put("value", cmbMeshingAlgorithmVideo.getSelectedItem());
						MeshingAlgorithmVideo.put("score", "1");

						JSONObject tiamatApproved = new JSONObject();
						tiamatApproved.put("value", "true");

						metadataMap.put("Created in T.i.A.M.A.T", tiamatApproved);
						metadataMap.put("Name of the Object", objectNameVideo);
						metadataMap.put("F1 SurveyObject", surveyObjectVideo);
						metadataMap.put("SurveyLink", SurveyLinkVideo);
						metadataMap.put("F42 AcquisitionLocation", AcquisitionLocationVideo);
						metadataMap.put("F31 ProcessingSoftware", ProcessingSoftwareVideo);
						metadataMap.put("F62 ProcessedTexturedMeshTextureSet", ProcessedTexturedMeshTextureSetVideo);
						metadataMap.put("F64 Modelling_ModifyingDescription", Modelling_ModifyingDescriptionVideo);
						metadataMap.put("F100 TridimensionalDigitalTwin", TridimensionalDigitalTwinVideo);
						metadataMap.put("F59 TridimensionalDigitalTwinDigitalScale",
								TridimensionalDigitalTwinDigitalScaleVideo);
						metadataMap.put("F71 FinalPurpose", FinalPurpose);
						metadataMap.put("F154 Georeferencing_3DModel", GeorefVideo);
						metadataMap.put("F156 ModelComposition_MultipleParts", MeshNumberVideo);
						metadataMap.put("F155 Orientation_3DModel", orientationVideo);
						metadataMap.put("F72 Exported3DModelVideoRendering", Exported3DModelVideoRendering);
						metadataMap.put("F73 Exporting_EditingRenderingVideo", Exporting_EditingRenderingVideo);
						metadataMap.put("F74 Exporting_EditingRenderingVideoSoftware",
								Exporting_EditingRenderingVideoSoftware);
						metadataMap.put("F75 ExportedVideo3DRendering", ExportedVideo3DRendering);
						metadataMap.put("F111 VideoFormat", VideoFormat);
						metadataMap.put("F112 VideoResolution", VideoResolution);
						metadataMap.put("F113 VideoDuration", VideoDuration);
						metadataMap.put("F21 Matching Algorithm", MatchingAlgorithmVideo);
						metadataMap.put("F23 Meshing Algorithm", MeshingAlgorithmVideo);
						metadataMap.put("Suitability Message: ", videoRules.getFeedbackMessage());
						metadataMap.put("Score: ", videoRules.calculateScore());
						log.setText("Metadata successfully saved to: " + filePath);

					} else if (currentPanel.equals("AR/VR")) {
						JSONObject ObjectNameARVR = new JSONObject();
						ObjectNameARVR.put("value", tfObjectNameARVR.getText());
						ObjectNameARVR.put("score", "-");

						JSONObject SurveyObjectARVR = new JSONObject();
						SurveyObjectARVR.put("value", tfSurveyObjectARVR.getText());
						SurveyObjectARVR.put("Scope Note",
								"Survey Object denotes any object subjected to photogrammetric surveying or any kind of digital surveying. It represents the target of data acquisition processes, crucial for generating detailed digital records, analyses, and reconstructions within the FOPPA model for archaeological documentation. It must be a solid and visible object. The expression visible means that it interacts with light");
						SurveyObjectARVR.put("score", "URL: 3 | Name: 1");

						JSONObject SurveyLinkARVR = new JSONObject();
						SurveyLinkARVR.put("value", tfSurveyLinkARVR.getText());
						SurveyLinkARVR.put("score", "1");

						JSONObject AcquisitionLocationARVR = new JSONObject();
						AcquisitionLocationARVR.put("value", tfAcquisitionLocationARVR.getText());
						AcquisitionLocationARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/128#F42_Place_Of_Acquisition");
						AcquisitionLocationARVR.put("score", "3");

						JSONObject ProcessingSoftwareARVR = new JSONObject();
						ProcessingSoftwareARVR.put("value", tfProcessingSoftwareARVR.getText());
						ProcessingSoftwareARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/117#F31_Processing_Software");
						ProcessingSoftwareARVR.put("score", "3");

						JSONObject ProcessedTexturedMeshTextureSetARVR = new JSONObject();
						ProcessedTexturedMeshTextureSetARVR.put("value",
								tfProcessedTexturedMeshTextureSetARVR.getText());
						ProcessedTexturedMeshTextureSetARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/149#F62_Texture_Set_of_3D_Mesh");
						ProcessedTexturedMeshTextureSetARVR.put("score", "2");

						JSONObject TridimensionalDigitalTwinARVR = new JSONObject();
						TridimensionalDigitalTwinARVR.put("value", tfTridimensionalDigitalTwinARVR.getText());
						TridimensionalDigitalTwinARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/145#F100_3D_Digital_Twin");
						TridimensionalDigitalTwinARVR.put("score", "3");

						JSONObject TridimensionalDigitalTwinDigitalScaleARVR = new JSONObject();
						TridimensionalDigitalTwinDigitalScaleARVR.put("value",
								tfTridimensionalDigitalTwinDigitalScaleARVR.getText());
						TridimensionalDigitalTwinDigitalScaleARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/146#F59_Digital_Scale");
						TridimensionalDigitalTwinDigitalScaleARVR.put("score", "3");

						JSONObject GeorefARVR = new JSONObject();
						GeorefARVR.put("value", tfGeorefARVR.getText());
						GeorefARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/333#F154_Georeferencing_of_the_3D_Model");
						GeorefARVR.put("score", "3");

						JSONObject MeshNumberARVR = new JSONObject();
						MeshNumberARVR.put("value", tfMeshNumberARVR.getText());
						MeshNumberARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/335#F156_Model_Composition_from_Multiple_Parts");
						MeshNumberARVR.put("score", "3");

						JSONObject orientationARVR = new JSONObject();
						orientationARVR.put("value", cmbOrientationARVR.getSelectedItem());
						orientationARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/334#F155_Orientation_of_the_3D_ModelS");
						orientationARVR.put("score", "3");

						JSONObject ExportedAR3DModelARVR = new JSONObject();
						ExportedAR3DModelARVR.put("value", tfExportedAR3DModelARVR.getText());
						ExportedAR3DModelARVR.put("IRI",
								"https://photogrammetry.altervista.org/items/show/184#F97_AR_3D_Model");
						ExportedAR3DModelARVR.put("score", "1");

						JSONObject Exporting_ARMRProjectImplementation = new JSONObject();
						Exporting_ARMRProjectImplementation.put("value",
								tfExporting_ARMRProjectImplementation.getText());
						Exporting_ARMRProjectImplementation.put("IRI",
								"https://photogrammetry.altervista.org/items/show/185#F98_AR/MR_Project_Implementation");
						Exporting_ARMRProjectImplementation.put("score", "1");

						JSONObject ARMRImplementationSoftware = new JSONObject();
						ARMRImplementationSoftware.put("value", tfARMRImplementationSoftware.getText());
						ARMRImplementationSoftware.put("IRI",
								"https://photogrammetry.altervista.org/items/show/186#F99_AR_Software_Modelling");
						ARMRImplementationSoftware.put("score", "1");

						JSONObject ARVRDescription = new JSONObject();
						ARVRDescription.put("value", tfARVRDescription.getText());
						ARVRDescription.put("IRI",
								"https://photogrammetry.altervista.org/items/show/293#F114_AR/VR_Project_Description");
						ARVRDescription.put("score", "1");

						JSONObject ARVRTitle = new JSONObject();
						ARVRTitle.put("value", tfARVRTitle.getText());
						ARVRTitle.put("IRI",
								"https://photogrammetry.altervista.org/items/show/294#F115_AR/VR_Project_Title/DOI");
						ARVRTitle.put("score", "1");

						JSONObject ARVRCategory = new JSONObject();
						ARVRCategory.put("value", cmbARVRCategory.getSelectedItem());
						ARVRCategory.put("IRI", "https://photogrammetry.altervista.org/items/show/295");
						ARVRCategory.put("score", "1");

						JSONObject ARVRPlatform = new JSONObject();
						ARVRPlatform.put("value", tfARVRPlatform.getText());
						ARVRPlatform.put("IRI",
								"https://photogrammetry.altervista.org/items/show/296#F117_AR/VR_Project_Platform");
						ARVRPlatform.put("score", "1");

						JSONObject ARVRCoordinates = new JSONObject();
						ARVRCoordinates.put("value", tfARVRCoordinates.getText());
						ARVRCoordinates.put("IRI",
								"https://photogrammetry.altervista.org/items/show/297#F118_AR/VR_Project_Real_Coordinates");
						ARVRCoordinates.put("score", "1");

						JSONObject MatchingAlgorithmARVR = new JSONObject();
						MatchingAlgorithmARVR.put("value", cmbMatchingAlgorithmARVR.getSelectedItem());
						MatchingAlgorithmARVR.put("score", "1");

						JSONObject MeshingAlgorithmARVR = new JSONObject();
						MeshingAlgorithmARVR.put("value", cmbMeshingAlgorithmARVR.getSelectedItem());
						MeshingAlgorithmARVR.put("score", "1");

						JSONObject tiamatApproved = new JSONObject();
						tiamatApproved.put("value", "true");

						metadataMap.put("Created in T.i.A.M.A.T", tiamatApproved);
						metadataMap.put("Name of the Object", ObjectNameARVR);
						metadataMap.put("F1 SurveyObject", SurveyObjectARVR);
						metadataMap.put("SurveyLink", SurveyLinkARVR);
						metadataMap.put("F42 AcquisitionLocation", AcquisitionLocationARVR);
						metadataMap.put("F31 ProcessingSoftware", ProcessingSoftwareARVR);
						metadataMap.put("F62 ProcessedTexturedMeshTextureSet", ProcessedTexturedMeshTextureSetARVR);
						metadataMap.put("F100 TridimensionalDigitalTwin", TridimensionalDigitalTwinARVR);
						metadataMap.put("F59 TridimensionalDigitalTwinDigitalScale",
								TridimensionalDigitalTwinDigitalScaleARVR);
						metadataMap.put("F154 Georeferencing_3DModel", GeorefARVR);
						metadataMap.put("F156 ModelComposition_MultipleParts", MeshNumberARVR);
						metadataMap.put("F155 Orientation_3DModel", orientationARVR);
						metadataMap.put("F97 Exported AR 3D Model", ExportedAR3DModelARVR);
						metadataMap.put("F98 AR/MR Project Implementation", Exporting_ARMRProjectImplementation);
						metadataMap.put("F99 AR Software Modelling", ARMRImplementationSoftware);
						metadataMap.put("F114 AR/VR Description", ARVRDescription);
						metadataMap.put("F115 Title or DOI of the AR/VR project", ARVRTitle);
						metadataMap.put("F116 ARVR Category", ARVRCategory);
						metadataMap.put("F117 Created for AR/VR Platform", ARVRPlatform);
						metadataMap.put("F118 Georeferenced Coordinates", ARVRCoordinates);
						metadataMap.put("F21 Matching Algorithm", MatchingAlgorithmARVR);
						metadataMap.put("F23 Meshing Algorithm", MeshingAlgorithmARVR);
						metadataMap.put("Suitability Message: ", arvrRules.getFeedbackMessage());
						metadataMap.put("Score: ", arvrRules.calculateScore());
						log.setText("Metadata successfully saved to: " + filePath);

					} else if (currentPanel.equals("Mobile")) {
						JSONObject ObjectNameMobile = new JSONObject();
						ObjectNameMobile.put("value", tfObjectNameMobile.getText());
						ObjectNameMobile.put("score", "-");

						JSONObject SurveyObjectMobile = new JSONObject();
						SurveyObjectMobile.put("value", tfSurveyObjectMobile.getText());
						SurveyObjectMobile.put("Scope Note",
								"Survey Object denotes any object subjected to photogrammetric surveying or any kind of digital surveying. It represents the target of data acquisition processes, crucial for generating detailed digital records, analyses, and reconstructions within the FOPPA model for archaeological documentation. It must be a solid and visible object. The expression visible means that it interacts with light");
						SurveyObjectMobile.put("score", "URL: 3 | Name: 1");

						JSONObject SurveyLinkMobile = new JSONObject();
						SurveyLinkMobile.put("value", tfSurveyLinkMobile.getText());
						SurveyLinkMobile.put("score", "1");

						JSONObject AcquisitionLocationMobile = new JSONObject();
						AcquisitionLocationMobile.put("value", tfAcquisitionLocationMobile.getText());
						AcquisitionLocationMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/128#F42_Place_Of_Acquisition");
						AcquisitionLocationMobile.put("score", "3");

						JSONObject AcquistionScaleObjectTypeMobile = new JSONObject();
						AcquistionScaleObjectTypeMobile.put("value",
								cmbAcquistionScaleObjectTypeMobile.getSelectedItem());
						AcquistionScaleObjectTypeMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/105#F19_Scale_Type");
						AcquistionScaleObjectTypeMobile.put("score", "3");

						JSONObject AcquisitionDateMobile = new JSONObject();
						AcquisitionDateMobile.put("value", tfAcquisitionDateMobile.getText());
						AcquisitionDateMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/129#F43_Survey_Date");
						AcquisitionDateMobile.put("score", "3");

						JSONObject ProcessingSoftwareMobile = new JSONObject();
						ProcessingSoftwareMobile.put("value", tfProcessingSoftwareMobile.getText());
						ProcessingSoftwareMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/117#F31_Processing_Software");
						ProcessingSoftwareMobile.put("score", "3");

						JSONObject ProcessedTexturedMeshTextureSetMobile = new JSONObject();
						ProcessedTexturedMeshTextureSetMobile.put("value",
								tfProcessedTexturedMeshTextureSetMobile.getText());
						ProcessedTexturedMeshTextureSetMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/149#F62_Texture_Set_of_3D_Mesh");
						ProcessedTexturedMeshTextureSetMobile.put("score", "2");

						JSONObject Modelling_ModifyingDescriptionMobile = new JSONObject();
						Modelling_ModifyingDescriptionMobile.put("value",
								tfModelling_ModifyingDescriptionMobile.getText());
						Modelling_ModifyingDescriptionMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/151#F64_Modelling_Description");
						Modelling_ModifyingDescriptionMobile.put("score", "2");

						JSONObject TridimensionalDigitalTwinMobile = new JSONObject();
						TridimensionalDigitalTwinMobile.put("value", tfTridimensionalDigitalTwinMobile.getText());
						TridimensionalDigitalTwinMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/145#F100_3D_Digital_Twin");
						TridimensionalDigitalTwinMobile.put("score", "3");

						JSONObject TridimensionalDigitalTwinDigitalScaleMobile = new JSONObject();
						TridimensionalDigitalTwinDigitalScaleMobile.put("value",
								tfTridimensionalDigitalTwinDigitalScaleMobile.getText());
						TridimensionalDigitalTwinDigitalScaleMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/146#F59_Digital_Scale");
						TridimensionalDigitalTwinDigitalScaleMobile.put("score", "3");

						JSONObject ExportedAR3DModelMobile = new JSONObject();
						ExportedAR3DModelMobile.put("value", tfExportedAR3DModelMobile.getText());
						ExportedAR3DModelMobile.put("IRI",
								"https://photogrammetry.altervista.org/items/show/184#F97_AR_3D_Model");
						ExportedAR3DModelMobile.put("score", "1");

						JSONObject MobileApplicationOperationalSystem = new JSONObject();
						MobileApplicationOperationalSystem.put("value",
								cmbMobileApplicationOperationalSystem.getSelectedItem());
						MobileApplicationOperationalSystem.put("IRI", "");
						MobileApplicationOperationalSystem.put("score", "1");

						JSONObject ProgrammingLanguage = new JSONObject();
						ProgrammingLanguage.put("value", cmbProgrammingLanguage.getSelectedItem());
						ProgrammingLanguage.put("IRI", "https://photogrammetry.altervista.org/items/show/298");
						ProgrammingLanguage.put("score", "1");

						JSONObject MatchingAlgorithmMobile = new JSONObject();
						MatchingAlgorithmMobile.put("value", cmbMatchingAlgorithmMobile.getSelectedItem());
						MatchingAlgorithmMobile.put("score", "1");

						JSONObject MeshingAlgorithmMobile = new JSONObject();
						MeshingAlgorithmMobile.put("value", cmbMeshingAlgorithmMobile.getSelectedItem());
						MeshingAlgorithmMobile.put("score", "1");

						JSONObject tiamatApproved = new JSONObject();
						tiamatApproved.put("value", "true");

						metadataMap.put("Created in T.i.A.M.A.T", tiamatApproved);
						metadataMap.put("Name of the Object", ObjectNameMobile);
						metadataMap.put("F1 SurveyObject", SurveyObjectMobile);
						metadataMap.put("SurveyLink", SurveyLinkMobile);
						metadataMap.put("F42 AcquisitionLocation", AcquisitionLocationMobile);
						metadataMap.put("F19 AcquisitionScaleObjectType", AcquistionScaleObjectTypeMobile);
						metadataMap.put("F43 AcquisitionDate", AcquisitionDateMobile);
						metadataMap.put("F31 ProcessingSoftware", ProcessingSoftwareMobile);
						metadataMap.put("F62 ProcessedTexturedMeshTextureSet", ProcessedTexturedMeshTextureSetMobile);
						metadataMap.put("F64 Modelling_ModifyingDescription", Modelling_ModifyingDescriptionMobile);
						metadataMap.put("F100 TridimensionalDigitalTwin", TridimensionalDigitalTwinMobile);
						metadataMap.put("F59 TridimensionalDigitalTwinDigitalScale",
								TridimensionalDigitalTwinDigitalScaleMobile);
						metadataMap.put("F97 Exported AR 3D Model", ExportedAR3DModelMobile);
						metadataMap.put("F119 Mobile Application Operational System",
								MobileApplicationOperationalSystem);
						metadataMap.put("F120 Programming Language", ProgrammingLanguage);
						metadataMap.put("F21 Matching Algorithm", MatchingAlgorithmMobile);
						metadataMap.put("F23 Meshing Algorithm", MeshingAlgorithmMobile);
						metadataMap.put("Suitability Message: ", mobileRules.getFeedbackMessage());
						metadataMap.put("Score: ", mobileRules.calculateScore());

						log.setText("Metadata successfully saved to: " + filePath);

					} else if (currentPanel.equals("Educational")) {
						JSONObject ObjectNameEducational = new JSONObject();
						ObjectNameEducational.put("value", tfObjectNameEducational.getText());
						ObjectNameEducational.put("score", "-");

						JSONObject SurveyObjectEducational = new JSONObject();
						SurveyObjectEducational.put("value", tfSurveyObjectEducational.getText());
						SurveyObjectEducational.put("Scope Note",
								"Survey Object denotes any object subjected to photogrammetric surveying or any kind of digital surveying. It represents the target of data acquisition processes, crucial for generating detailed digital records, analyses, and reconstructions within the FOPPA model for archaeological documentation. It must be a solid and visible object. The expression visible means that it interacts with light");
						SurveyObjectEducational.put("score", "URL: 3 | Name: 1");

						JSONObject SurveyLinkEducational = new JSONObject();
						SurveyLinkEducational.put("value", tfSurveyLinkEducational.getText());
						SurveyLinkEducational.put("score", "1");

						JSONObject AcquisitionLocationEducational = new JSONObject();
						AcquisitionLocationEducational.put("value", tfAcquisitionLocationEducational.getText());
						AcquisitionLocationEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/128#F42_Place_Of_Acquisition");
						AcquisitionLocationEducational.put("score", "3");

						JSONObject AcquistionScaleObjectTypeEducational = new JSONObject();
						AcquistionScaleObjectTypeEducational.put("value",
								cmbAcquistionScaleObjectTypeEducational.getSelectedItem());
						AcquistionScaleObjectTypeEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/105#F19_Scale_Type");
						AcquistionScaleObjectTypeEducational.put("score", "3");

						JSONObject AcquisitionDateEducational = new JSONObject();
						AcquisitionDateEducational.put("value", tfAcquisitionDateEducational.getText());
						AcquisitionDateEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/129#F43_Survey_Date");
						AcquisitionDateEducational.put("score", "3");

						JSONObject ProcessedDensifiedPointCloud = new JSONObject();
						ProcessedDensifiedPointCloud.put("value", tfProcessedDensifiedPointCloud.getText());
						ProcessedDensifiedPointCloud.put("IRI",
								"https://photogrammetry.altervista.org/items/show/113#F27_Densified_Point_Cloud");
						ProcessedDensifiedPointCloud.put("score", "3");

						JSONObject ProcessingSoftwareEducational = new JSONObject();
						ProcessingSoftwareEducational.put("value", tfProcessingSoftwareEducational.getText());
						ProcessingSoftwareEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/117#F31_Processing_Software");
						ProcessingSoftwareEducational.put("score", "3");

						JSONObject ProcessedTexturedMeshTextureSetEducational = new JSONObject();
						ProcessedTexturedMeshTextureSetEducational.put("value",
								tfProcessedTexturedMeshTextureSetEducational.getText());
						ProcessedTexturedMeshTextureSetEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/149#F62_Texture_Set_of_3D_Mesh");
						ProcessedTexturedMeshTextureSetEducational.put("score", "2");

						JSONObject Modelling_ModifyingDescriptionEducational = new JSONObject();
						Modelling_ModifyingDescriptionEducational.put("value",
								tfModelling_ModifyingDescriptionEducational.getText());
						Modelling_ModifyingDescriptionEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/151#F64_Modelling_Description");
						Modelling_ModifyingDescriptionEducational.put("score", "2");

						JSONObject TridimensionalDigitalTwinEducational = new JSONObject();
						TridimensionalDigitalTwinEducational.put("value",
								tfTridimensionalDigitalTwinEducational.getText());
						TridimensionalDigitalTwinEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/145#F100_3D_Digital_Twin");
						TridimensionalDigitalTwinEducational.put("score", "3");

						JSONObject TridimensionalDigitalTwinDigitalScaleEducational = new JSONObject();
						TridimensionalDigitalTwinDigitalScaleEducational.put("value",
								tfTridimensionalDigitalTwinDigitalScaleEducational.getText());
						TridimensionalDigitalTwinDigitalScaleEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/146#F59_Digital_Scale");
						TridimensionalDigitalTwinDigitalScaleEducational.put("score", "3");

						JSONObject ExportedAR3DModelEducational = new JSONObject();
						ExportedAR3DModelEducational.put("value", tfExportedAR3DModelEducational.getText());
						ExportedAR3DModelEducational.put("IRI",
								"https://photogrammetry.altervista.org/items/show/184#F97_AR_3D_Model");
						ExportedAR3DModelEducational.put("score", "1");

						JSONObject EducationalPlatformURL = new JSONObject();
						EducationalPlatformURL.put("value", tfEducationalPlatformURL.getText());
						EducationalPlatformURL.put("IRI",
								"https://photogrammetry.altervista.org/items/show/300#F121_Educational_Platform_URL");
						EducationalPlatformURL.put("score", "1");

						JSONObject SelectedBrowsers = new JSONObject();
						SelectedBrowsers.put("value", tfSelectedBrowsers.getText());
						SelectedBrowsers.put("IRI",
								"https://photogrammetry.altervista.org/items/show/301#F122_Educational_Platform_Supported_Browser");
						SelectedBrowsers.put("score", "1");

						JSONObject EducationalPlatformServerWeb = new JSONObject();
						EducationalPlatformServerWeb.put("value", tfEducationalPlatformServerWeb.getText());
						EducationalPlatformServerWeb.put("IRI",
								"https://photogrammetry.altervista.org/items/show/302#F123_Educational_Platform_Server_Web");
						EducationalPlatformServerWeb.put("score", "1");

						JSONObject MatchingAlgorithmEducational = new JSONObject();
						MatchingAlgorithmEducational.put("value", cmbMatchingAlgorithmEducational.getSelectedItem());
						MatchingAlgorithmEducational.put("score", "1");

						JSONObject MeshingAlgorithmEducational = new JSONObject();
						MeshingAlgorithmEducational.put("value", cmbMeshingAlgorithmEducational.getSelectedItem());
						MeshingAlgorithmEducational.put("score", "1");

						JSONObject tiamatApproved = new JSONObject();
						tiamatApproved.put("value", "true");

						metadataMap.put("Created in T.i.A.M.A.T", tiamatApproved);
						metadataMap.put("Name of the Object", ObjectNameEducational);
						metadataMap.put("F1 SurveyObject", SurveyObjectEducational);
						metadataMap.put("SurveyLink", SurveyLinkEducational);
						metadataMap.put("F42 AcquisitionLocation", AcquisitionLocationEducational);
						metadataMap.put("F19 AcquisitionScaleObjectType", AcquistionScaleObjectTypeEducational);
						metadataMap.put("F43 AcquisitionDate", AcquisitionDateEducational);
						metadataMap.put("F27 ProcessedDensifiedPointCloud", ProcessedDensifiedPointCloud);
						metadataMap.put("F31 ProcessingSoftware", ProcessingSoftwareEducational);
						metadataMap.put("F62 ProcessedTexturedMeshTextureSet",
								ProcessedTexturedMeshTextureSetEducational);
						metadataMap.put("F64 Modelling_ModifyingDescription",
								Modelling_ModifyingDescriptionEducational);
						metadataMap.put("F100 TridimensionalDigitalTwin", TridimensionalDigitalTwinEducational);
						metadataMap.put("F59 TridimensionalDigitalTwinDigitalScale",
								TridimensionalDigitalTwinDigitalScaleEducational);
						metadataMap.put("F97 Exported AR 3D Model", ExportedAR3DModelEducational);
						metadataMap.put("F121 Educational Platform URL", EducationalPlatformURL);
						metadataMap.put("F122 Educational Platform Supported Browser(s)", SelectedBrowsers);
						metadataMap.put("F123 Educational Platform Server Web", EducationalPlatformServerWeb);
						metadataMap.put("F21 Matching Algorithm", MatchingAlgorithmEducational);
						metadataMap.put("F23 Meshing Algorithm", MeshingAlgorithmEducational);
						metadataMap.put("Suitability Message: ", educationalRules.getFeedbackMessage());
						metadataMap.put("Score: ", educationalRules.calculateScore());

						log.setText("Metadata successfully saved to: " + filePath);
					}
					JSONObject metadata = new JSONObject(metadataMap);

					try (FileWriter fileWriter = new FileWriter(filePath)) {
						fileWriter.write(metadata.toString(4)); // JSON with an indent of 4 spaces
					}
					log.setText("Metadata successfully saved to: " + filePath);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}

	}

	public static void main(String[] args) {
		Main_program window = new Main_program("T.i.A.M.A.T");
		ImageIcon icon = new ImageIcon(Main_program.class.getResource("/Logo_Tiamat.png"));
		window.setIconImage(icon.getImage());
		window.setSize(1200, 900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
