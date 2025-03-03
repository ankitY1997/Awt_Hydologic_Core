package com.awt.test.Irrigation.Admin.Settings.AddViewEquipments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.awt.page.ParentLandingPage;
import com.awt.page.Irrigation.Admin.AdminDashboardPage;
import com.awt.page.Irrigation.Admin.Settings.AddViewEquipments.EquipmentDetailsPage;
import com.awt.page.Irrigation.Admin.Settings.AddViewEquipments.NewEquipmentsDetailsPanel;
import com.awt.page.Irrigation.Home.HomePage;
import com.awt.page.Irrigation.Login.LoginPage;
import com.awt.testbase.BaseTest;
import com.awt.testbase.DriverFactory;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.Description;
import com.awt.utills.reusablecomponents.Owner;
import com.awt.utills.reusablecomponents.PropertiesOperations;
import com.awt.utills.reusablecomponents.SoftAssertTest;
import com.awt.utills.reusablecomponents.Story;
import com.awt.utills.reusablecomponents.TestCaseId;
import com.awt.utills.reusablecomponents.Version;
import com.awt.utills.reusablecomponents.WorkArea;

public class EquipmentsDetailsTest extends BaseTest {

	private static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
	private static final String project_name = PropertiesOperations.getPropertyValueByKey("Project_Name");
	private static final String main_porject_name = PropertiesOperations.getPropertyValueByKey("Main_Project_Name");
	private SoftAssertTest asert = null;
	private LoginPage login_page = null;
	private ParentLandingPage parent_landing_page = null;
	private AdminDashboardPage admin_dashboard_page = null;
	private HomePage home_page = null;
	private EquipmentDetailsPage equipment_details_page = null;
	private NewEquipmentsDetailsPanel equipments_details_panel = null;

	/**
	 * Navigate To Login Page
	 */
	public void navigateToLoginPage() {

		// SoftAssert instance
		asert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// navigate to login page
		parent_landing_page = new ParentLandingPage(DriverFactory.iuiDriver().getDriver());
		// Select the module
		login_page = parent_landing_page.selectProject(main_porject_name, url);

	}

	/**
	 * Description: Perform the verification of equipmentsdetailsPage <br>
	 * TestMethodName: verifyVillageDetailsPage <br>
	 * ManualTestCases: "SU-T36", "SU-T37", "SU-T38", "SU-T39", "SU-T40", "SU-T42",
	 * "SU-T45", "SU-T46", "SU-T47", "SU-T49", "SU-T50", "SU-T51", "SU-T52",
	 * "SU-T53", "SU-T54", "SU-T55", "SU-T56", "SU-T58", "SU-T59", "SU-T60",
	 * "SU-T61", "SU-T62", "SU-T63", "SU-T64", "SU-T68", "SU-T69", "SU-T70",
	 * "SU-T71", "SU-T72", "SU-T73", "SU-T74", "SU-T76", "SU-T77", "SU-T78",
	 * "SU-T79", "SU-T80", "SU-T81", "SU-T311", "SU-T312", "SU-T1080", "SU-T1081",
	 * "SU-T1083", "SU-T1084", "SU-T329"<br>
	 * 
	 * @author ankit
	 */

	@Version(number = "V-0.1")
	@Test(groups = { "Admin", "Functional" })
	@Description(description = "Perform the verfication on eqipmentsdetais page")
	@Story(story = "Add Equipment Details and properties")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Add/View Equipments")
	@TestCaseId(id = { "SU-T36", "SU-T37", "SU-T38", "SU-T39", "SU-T40", "SU-T42", "SU-T45", "SU-T46", "SU-T47",
			"SU-T49", "SU-T50", "SU-T51", "SU-T52", "SU-T53", "SU-T54", "SU-T55", "SU-T56", "SU-T58", "SU-T59",
			"SU-T60", "SU-T61", "SU-T62", "SU-T63", "SU-T64", "SU-T68", "SU-T69", "SU-T70", "SU-T71", "SU-T72",
			"SU-T73", "SU-T74", "SU-T76", "SU-T77", "SU-T78", "SU-T79", "SU-T80", "SU-T81", "SU-T311", "SU-T312",
			"SU-T1080", "SU-T1081", "SU-T1083", "SU-T1084", "SU-T329" })
	public void verfiyEquipmentsDetailsPage() {
		// Logger Instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// -> Navigate To Login page
		navigateToLoginPage();
		// ->Login To The Application and Navigate To The HomePage
		home_page = login_page.loginAndNavigateToHomePage(PropertiesOperations.getPropertyValueByKey("Project_Name"),
				PropertiesOperations.getPropertyValueByKey("User_USERNAME"),
				PropertiesOperations.getPropertyValueByKey("User_PASSWORD"));
		// -> navigate to the admin dahsboard page
		admin_dashboard_page = home_page.navigateToAdminDashboardPage();
		// -> click on setting menu
		// -> click on add/view equipements
		// -> navigate to the equipmentDetailsPage
		equipment_details_page = admin_dashboard_page.navigateToEquipmentDetailsPage();

		// SU-T1359-->To verify that Add/View Equipments button Should be visible
		// under the 'Settings' menu.

		// -> Check "Add/View Equipments" option is visible or not
		boolean isAdd_ViewEquipmentsButtonVisible = equipment_details_page.isAddViewEquipmentOptionVisible();
		asert.assertTrue(isAdd_ViewEquipmentsButtonVisible,
				"To verify that Add/View Equipments button Should be visible under the 'Settings' menu.", "SU-T1359");

		// SU-T1360-->To verify that after clicking on the Add/View Equipments button
		// user Should redirect to the "equipmentsdetails" Page.

		// -> check 'equipmentdetails' page is visible or not
		asert.assertTrue(equipment_details_page.getEquipementDetailsPageName().contains("equipmentsdetails"),
				"To verify that  after clicking on the Add/View Equipments button user Should redirect to the 'equipmentsdetails' Page.",
				"SU-T1359");

		// SU-T1361-->To verify that "New" button Should be visible in the
		// "equipmentsdetails" Page.

		// -> Check "new" button is present or not
		boolean isNewButtonPresent = equipment_details_page.isNewButtonVisible();
		asert.assertTrue(isNewButtonPresent,
				"To verify that 'New' button Should be visible in the 'equipmentsdetails' Page. ", "SU-T1361");

		// SU-T1362-->To verify that Clicking on the "New" button user Should redirect
		// to the "New Equipments Details" Panel.

		// -> Click on new button
		equipments_details_panel = equipment_details_page.clickOnNewButtonAndNavigateToNewEquipmentDetailsPanel();
		// -> Check user is navigate to the "New Equipment Details" panel or not
		// -> Expected panel name
		String expected_panel_name = "New Equipments Details";
		// ->get the acutual panel name
		String actual_panel_name = equipments_details_panel.getEquipmentDetailPanelName();
		// Compare Expected panel name and actual panel name
		asert.assertEquals(actual_panel_name, expected_panel_name,
				"To verify that Clicking on the 'New' button user Should redirect to the 'New Equipments Details'  Panel.",
				"SU-T1362");

		// verify New Equipments Details Panel
		verifyNewEquipmentsDetailsPanel();

	}

	public void verifyNewEquipmentsDetailsPanel() {
		// verifyDetailsTab
		verifyDetailsTab();

	}

	public void verifyDetailsTab() {

		// SU-T1363-->To verify that "Details" tab Should visible in the "New Equipments
		// Details" Panel.

		// -> check the visibility of "Details" tab
		boolean isDetailsTabVisible = equipments_details_panel.isDetailsTabIsVisible();
		asert.assertTrue(isDetailsTabVisible,
				"To verify that 'Details' tab Should visible in the 'New Equipments Details'  Panel. ", "SU-T1363");

		// SU-T1364-->To verify that "Equipments Type" drop down Should visible in the
		// "Details" tab.

		// -> check "Eqipments Type" drop down is visible or not
		boolean isEquipmentTypeDropDownPresent = equipments_details_panel.isEquipmentTypeDropDownIsVisible();
		asert.assertTrue(isEquipmentTypeDropDownPresent,
				"To verify that 'Equipments Type' drop down Should visible in the 'Details' tab.  ", "SU-T1364");

		// SU-T1365-->To verify that user can select the equipment type from the
		// "Equipments Type" drop down .

		// -> Select a gateway from equipment type drop down
		equipments_details_panel.selectDropdownOptionFromDetailsTab("Equipments Type", "Gateway");
		String expected_option = "Gateway";
		// -> check "Gateway" option is selected or not
		String actual_selected_option = equipments_details_panel.getSelectedOptionFromDropDown("Equipments Type");
		asert.assertEquals(actual_selected_option, expected_option,
				"To verify that  user can select the  equipment type from the 'Equipments Type' drop down .",
				"SU-T1365");

		// SU-T1366-->To verify that "Device Profile" drop down Should visible in the
		// "Details" tab.

		// -> check the visibility of "device profile" drop down
		boolean isDevicProfileDropDownVisible = equipments_details_panel.isDeviceProfileDropDownIsVisible();
		asert.assertTrue(isDevicProfileDropDownVisible,
				"To verify that 'Device Profile' drop down Should visible in the 'Details' tab.  ", "SU-T1366");

		// SU-T1367-->To verify that user can select the 'Device Profile' from the
		// 'Device Profile' drop down

		// -> Select option "gateway" option from "Device profile" drop down
		equipments_details_panel.selectDropdownOptionFromDetailsTab("Device Profile", "Gateway");
		String exp_option = "Gateway";
		// -> get the acutal selected option and check "gateway" is selected or not
		actual_selected_option = equipments_details_panel.getSelectedOptionFromDropDown("Device Profile");
		asert.assertEquals(actual_selected_option, exp_option,
				"To verify that user can select the 'Device Profile' from the 'Device Profile' drop down", "SU-T1367");

		// SU-T1368-->To verify that 'Name' text field Should be visible in the 'New
		// Equipments Details' Panel.

		// -> Check the "Name" text field is visible or not
		boolean isNameTextFieldVisible = equipments_details_panel.isNameTextFieldIsVisible();
		asert.assertTrue(isNameTextFieldVisible,
				"To verify that 'Name'  text field Should be visible in the 'New Equipments Details' Panel.",
				"SU-T1368");

		// SU-T1369-->Ensure that the 'Name' text field label is visible based on the
		// selected
		// 'Equipment Type.'

		// -> select the "Gateway" from "Equipment Type" drop down
		String option_name = "Gateway";
		equipments_details_panel.selectDropdownOptionFromDetailsTab("Equipments Type", option_name);
		String exp_text_field_name = option_name + " Name *";
		// ->Check "Name" text field should be a "Gateway Name" text field
		// -> Get the current name of "Name" text field name
		String current_name_of_text_field_name = equipments_details_panel.getCurrentNameOfNameTextField().trim();
		asert.assertEquals(current_name_of_text_field_name, exp_text_field_name,
				"Ensure that the 'Name' text field label is visible based on the selected 'Equipment Type.'",
				"SU-T1369");

		// SU-T1370-->Ensure that the 'ID' text field label is visible based on the
		// selected 'Equipment Type.'

		// -> Check the "ID*" text field name should be "Gateway ID" text field
		String exp_id_text_field_name = option_name + " ID *";
		// -> get the current name of "ID" text field
		String current_name_of_id_text_field = equipments_details_panel.getCurrentNameOfIdTextField();
		// -> comapre the exp_id and curren_name of id text field
		asert.assertEquals(current_name_of_id_text_field, exp_id_text_field_name,
				"Ensure that the 'ID' text field label is visible based on the selected 'Equipment Type.' ",
				"SU-T1370");

		// SU-T1371-->Ensure that the data displayed in the 'Device Profile' dropdown
		// corresponds to the selected 'Equipment Type.'

		// ->Select the "OMS Controller" from EquipmentType Dropdown
		equipments_details_panel.selectDropdownOptionFromDetailsTab("Equipments Type", "OMS Controller");
		String[] expected_device_profile_option = { "Battery OMS" };
		// -> get the list of option under the "Device profile" drop down
		List<String> actual_options = equipments_details_panel.getTheListOfOptionsFromDeviceProfileDropDown();
		// -> "Battery OMS" options should be present under the "device
		// profile" drop down
		asert.assertTrue(actual_options.contains(new ArrayList<String>(Arrays.asList(expected_device_profile_option))),
				"Ensure that the data displayed in the 'Device Profile' dropdown corresponds to the selected 'Equipment Type.'",
				"SU-T1371");

		// SU-T1372-->To verify that "Map Coordinates" text field Should visible in the
		// "New Equipments Details" Panel.

		// -> check the visibility of "Map Coordinated" text field
		boolean isMapCoordinatesTextFieldVisible = equipments_details_panel.isMapCoordinatedTextFieldIsVisible();
		asert.assertTrue(isMapCoordinatesTextFieldVisible,
				"To verify that 'Map Coordinates' text field Should visible in the 'New Equipments Details'  Panel.  ",
				"SU-T1372");

		// SU-T1373-->To verify the mandatory fields in the 'Details' tab

		// -> Check the mandatory fields from "Details" tab
		String[] exp_mandatory_field_name = { "Equipments Type *", "Device Profile *", "OMS Controller Name *",
				"OMS Controller ID *", "Map Coordinates *" };
		// get the actual mandatory field name
		List<String> actual_mandatory_field_name = equipments_details_panel.getMandatoryFieldNameFromDetailsTab();
		// Expecte Mandatory field and actual Mandatory filed name should be equal
		asert.assertEquals(actual_mandatory_field_name, new ArrayList<String>(Arrays.asList(exp_mandatory_field_name)),
				"To verify the mandatory fields in the 'Details' tab", "SU-T1373");

	}

}
