package com.awt.test.User.AdminConfiguration.Settings.ReportTemplate;

import org.testng.annotations.Test;

import com.awt.page.Login.LoginPage;
import com.awt.page.User.ParentLandingPage;
import com.awt.page.User.AdminConfiguration.AdminPage;
import com.awt.page.User.AdminConfiguration.Settings.Report_Template.AddNewReportPanel;
import com.awt.page.User.AdminConfiguration.Settings.Report_Template.AdminReportTemplatePage;
import com.awt.testbase.BaseTest;
import com.awt.testbase.DriverFactory;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.AwtUtilities;
import com.awt.utills.reusablecomponents.Description;
import com.awt.utills.reusablecomponents.Owner;
import com.awt.utills.reusablecomponents.PropertiesOperations;
import com.awt.utills.reusablecomponents.SoftAssertTest;
import com.awt.utills.reusablecomponents.Story;
import com.awt.utills.reusablecomponents.TestCaseId;
import com.awt.utills.reusablecomponents.Version;
import com.awt.utills.reusablecomponents.WorkArea;

public class AdminReportTemplate extends BaseTest {

	// Instance Variable ///
	public static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
	public static final String admin_project = "Admin";
	SoftAssertTest asert = null;
	LoginPage lp = null;
	ParentLandingPage parent_landing_page = null;
	AdminPage admin_page = null;
	AdminReportTemplatePage admin_report_temp_page = null;
	AddNewReportPanel add_new_report_panel = null;

	/**
	 * 
	 * Navigate To ParentLandingPage
	 * 
	 */
	public void navigateToParentLandingPage() {
		// SoftAssert instance
		asert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// log in Page instance
		lp = new LoginPage(DriverFactory.iuiDriver().getDriver());
		parent_landing_page = lp.loginAndNavigateToTheParentLandingPage(url, "NKMP1",
				PropertiesOperations.getPropertyValueByKey("SUPERADMIN_USERNAME"),
				PropertiesOperations.getPropertyValueByKey("SUPERADMIN_PASSWORD"));
	}

	/**
	 * Description: Perform the verification of Admin Report Template Page <br>
	 * TestMethodName: verifyAdminAddRolePage <br>
	 * ManualTestCases: "APMS-T87", "APMS-T88", "APMS-T89", "APMS-T90", "APMS-T91",
	 * "APMS-T92", "APMS-T93", "APMS-T94", "APMS-T95", "APMS-T96", "APMS-T97",
	 * "APMS-T98", "APMS-T99", "APMS-T100",
	 * "APMS-T101","APMS-T102","APMS-T103","APMS-T104"<br>
	 * 
	 * @author ankit
	 */

	@Version(number = "V-0.1")
	@Test(groups = { "Admin", "Functional" })
	@Description(description = "Perform the verfication on  Admin Report Template")
	@Story(story = "Create Role ")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestCaseId(id = { "APMS-T87", "APMS-T88", "APMS-T89", "APMS-T90", "APMS-T91", "APMS-T92", "APMS-T93", "APMS-T94",
			"APMS-T95", "APMS-T96", "APMS-T97", "APMS-T98", "APMS-T99", "APMS-T100", "APMS-T101", "APMS-T102",
			"APMS-T103", "APMS-T104" })
	public void verifyAdminReportTemplate() {

		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// Navigate To New
		navigateToParentLandingPage();
		// click Admin button and Navigate To Admin Page
		admin_page = (AdminPage) parent_landing_page.goToProjectPage(admin_project);
		// Go To Settings Menus And Click On Report Template
		admin_report_temp_page = admin_page.navigateToAdminReportTemplatePage();

		// APMS-T159-->To verify that "New" button should be present in the
		// "admin-ReportTemplate" Page.
		// Validate "New" button is present or not
		boolean isNewButtonVisible = admin_report_temp_page.isNewButtonVisible();
		asert.assertTrue(isNewButtonVisible,
				"To verify that New button should be present in the admin-ReportTemplate Page.", "APMS-T159");

		// validate add new role panel
		verifyAddNewReportPanel();

		asert.assertAll();
	}

	/**
	 * Validating Add New Report Panel
	 */
	public void verifyAddNewReportPanel() {
		// APMS-T160-->To verify that clicking on the "New" button user should redirect
		// to the "Add New Report" Panel
		// --> Click On New Button and navigate to Add New Report Panel
		add_new_report_panel = admin_report_temp_page.clickOnNewButtonAndNavigateToAddNewReportPanel();
		// Then verify "Add New Report Panel" should be visible
		String act_panel_name = add_new_report_panel.getPanelName();
		asert.assertEquals(act_panel_name, "Add New Report",
				"To verify that  clicking on the New button user should redirect to the Add New Report Panel",
				"APMS-T160");

		// APMS-T161-->To verify that "Device Profile" drop down should be visible in
		// the "Add New Report" Panel
		// Check "Device Profile*" drop-down visible
		boolean isDeviceProfileDropDownVisible = add_new_report_panel.isDeviceProfileDropDownIsVisible();
		asert.assertTrue(isDeviceProfileDropDownVisible,
				"To verify that Device Profile drop down should be visible in the Add New Report Panel", "APMS-T161");

		// APMS-T162-->To verify that user can select a device profile from the drop
		// down list
		// -> Click On "Device Profile" Drop Down and Select "OMS" option
		add_new_report_panel.selectDropDown("Device Profile*", "OMS");
		// Then check "OMS" Option Should be Selected
		String device_profile_selected_option = add_new_report_panel.getSelectedOptionName("Device Profile*").trim();
		asert.assertEquals(device_profile_selected_option, "OMS",
				"To verify that user can select a device profile from the drop down list", "APMS-T162");

		// APMS-T163-->To verify that "Device Parameter" drop down should be visible in
		// the "Add New Report" Panel
		// Check Device Parameter drop-dwon is visible
		boolean isDeviceParameterDropDownVisible = add_new_report_panel.isDeviceParameterDropDownIsVisible();
		asert.assertTrue(isDeviceParameterDropDownVisible,
				"To verify that Device Parameter drop down should be visible in the Add New Report Panel", "APMS-T163");

		// APMS-T164-->verify that the user can select a "Device parameter" only after
		// selecting a "Device profile".
		// -> click on "Device parameter" drop down and select "Door" option
		add_new_report_panel.selectDropDown("Device Parameter*", "Door");
		// Then Check "Door" option should be visible
		String device_parameter_selected_option = add_new_report_panel.getSelectedOptionName("Device Parameter*")
				.trim();
		asert.assertEquals(device_parameter_selected_option, "Door",
				"verify that the user can select a Device parameter only after selecting a Device profile.",
				"APMS-T164");

		// APMS-T165-->To verify that "Template Name" text field should be visible in
		// the "Add New Report" Panel
		// Verify Template Name Text Field Should Visible
		boolean isTemplateNameTextFieldVisible = add_new_report_panel.isTemplateNameTextFieldVisible();
		asert.assertTrue(isTemplateNameTextFieldVisible,
				"To verify that Template Name text field should be visible in the Add New ReportPanel", "APMS-T165");

		// APMS-T166-->Ensure that the "Template Name" is automatically displayed based
		// on the selected "Device profile" and "Device parameter".
		String act_template_name = add_new_report_panel.getDefaultValueFromTemplateNameTextField();
		asert.assertEquals(act_template_name, device_profile_selected_option + "-" + device_parameter_selected_option,
				"Ensure that the Template Name is automatically displayed based on the selected Device profile and Device parameter.",
				"APMS-T166");

		// APMS-T167-->To verify that "Menu Level" drop down should be visible in the
		// "Add New Report" Panel.
		// verify "Menu Level" drop down is visible
		boolean isMenuLevelDropDownVisible = add_new_report_panel.isMenuLevelDropDownIsVisible();
		asert.assertTrue(isMenuLevelDropDownVisible,
				"To verify that Menu Level drop down should be visible in the Add New Report Panel.", "APMS-T167");

		// APMS-T168-->To verify that the user can select a "Menu level" only after
		// selecting a "Device profile" and "Device parameter" from the drop down.
		// -> Click on Menu Level drop-dwon and select Report option
		add_new_report_panel.selectDropDown("Menu Level*", "Report");
		// verify "report" option should be visible under the menu level drop down
		String menu_level_selected_option_name = add_new_report_panel.getSelectedOptionName("Menu Level*");
		asert.assertEquals(menu_level_selected_option_name, "Report",
				"To verify that the user can select a Menu level only after selecting a Device profile and Device parameter from the drop down.",
				"APMS-T168");

		// APMS-T169-->To verify that "Parameter Status" check boxes should be visible
		// according selected "Device Parameter".

		// Validate "Door Open" check box should be visible
		boolean isDoorOpenCheckBoxVisible = add_new_report_panel.isCheckboxPresentUnderParameterStatus("Door Open");
		asert.assertTrue(isDoorOpenCheckBoxVisible,
				"To verify that Parameter Status check boxes should be visible according selected Device Parameter",
				"APMS-T169");

		// APMS-T170-->To verify that the user can select multiple check boxes in the
		// "parameter status".

		// -> select the "Door Open" check box
		add_new_report_panel.selectParameterStatusCheckBox("Door Open");
		// Check "Door Open" check box is selected
		boolean isDoorOpenCheckBoxSelected = add_new_report_panel.isParameterStatusCheckBoxSelected("Door Open");
		asert.assertTrue(isDoorOpenCheckBoxSelected,
				"To verify that the user can select multiple checkboxes in the parameter status.", "APMS-T170");

		// APMS-T171-->To verify that "Show serial Number" check boxes should be visible
		// in the "Add New Report" panel.
		// "Show Serial Number" Check Box is Visible
		boolean isShowSerialNumberCheckBoxVisible = add_new_report_panel.isShowSerialNumberCheckBoxVisible();
		asert.assertTrue(isShowSerialNumberCheckBoxVisible,
				"To verify that Show serial Number check boxes should be visible in the Add New Report panel.",
				"APMS-T171");

		// APMS-T172-->To verify that user can checked/unchecked the "Show serial
		// number" check boxes in the "Add New Report" panel.
		// -> Select "Show Serial Number" Check box
		add_new_report_panel.selectShowSerialNumberCheckBox();
		// "Show Serial Number" check box should be checked
		boolean isShowSerialNumberCheckBoxSelected = add_new_report_panel.isShowSerialNumberCheckBoxSelected();
		asert.assertTrue(isShowSerialNumberCheckBoxSelected,
				"To verify that user can checked the Show serial number checkboxes in the Add New Report panel.",
				"APMS-172");

		// Then Again Click On "Show Serial Number" check box for unchecked
		add_new_report_panel.selectShowSerialNumberCheckBox();
		// "Show Serial Number" check box should be unchecked
		isShowSerialNumberCheckBoxSelected = add_new_report_panel.isShowSerialNumberCheckBoxSelected();
		asert.assertFalse(isShowSerialNumberCheckBoxSelected,
				"To verify that user can unchecked the Show serial number checkboxes in the Add New Report panel.",
				"APMS-172");

		// APMS-T173-->To verify that "Show Set Value" check box should be visible in
		// the "Add New Report" Panel.
		// "Show Set Value" check box should be visible
		boolean isShowSetValueCheckBoxVisible = add_new_report_panel.isShowSetValueCheckBoxVisible();
		asert.assertTrue(isShowSetValueCheckBoxVisible,
				"To verify that Show Set Value check box should be visible in the Add New Report Panel.", "APMS-T173");

		// APMS-T174-->To verify that user can checked/unchecked the "Show Set Value"
		// check box in the "Add New Report" Panel.
		// -> Select "Show Set Value" check box
		add_new_report_panel.selectShowSetValueCheckBox();
		// "Show Set Value" check box should be checked
		boolean isShowSetValueCheckBoxSelected = add_new_report_panel.isShowSetValueCheckBoxSelected();
		asert.assertTrue(isShowSetValueCheckBoxSelected,
				"To verify that  user can checked the Show Set Value check box  in the Add New Report Panel.",
				"APMS-T174");
		// Then Again Unchecked "Show Set Value " check box
		add_new_report_panel.selectShowSetValueCheckBox();
		// "Show Set Value" check box should be un-cheked
		isShowSetValueCheckBoxSelected = add_new_report_panel.isShowSetValueCheckBoxSelected();
		asert.assertFalse(isShowSetValueCheckBoxSelected,
				"To verify that  user can un-checked the Show Set Value check box  in the Add New Report Panel.",
				"APMS-T174");

		// APMS-T175-->To verify that "Filter Data" drop down should be visible in the
		// "Add New Report" Panel.
		// "Filter Data" Drop Down should be visible
		boolean isFilterDataDropDownVisible = add_new_report_panel.isFilterDataDropDownPresent();
		asert.assertTrue(isFilterDataDropDownVisible,
				"To verify that Filter Data drop down should be visible in the Add New Report Panel.", "APMS-T175");

		// APMS-T176-->To verify that user can select the data from the "Filter Data"
		// drop down.
		// --> Select "Zone" in "Filter Data List box
		add_new_report_panel.selectFilterDataCheckBox("Zone");
		// "Zone" check box should be selected
		boolean isZoneCheckBoxSelected = add_new_report_panel.isFilterDataCheckBoxSelected("Zone");
		asert.assertTrue(isZoneCheckBoxSelected,
				"To verify that user can select the data from the Filter Data drop down.", "APMS-T176");

		// APMS-T177-->To verify that "submit" button should be visible in the "Add New
		// Report" Panel.
		// -->Check "Submit" button is visible
		boolean isSubmitButtonVisible = add_new_report_panel.isSubmitButtonVisible();
		asert.assertTrue(isSubmitButtonVisible,
				"To verify that submit button should be visible in the Add New Report Panel.", "APMS-T177");

		// APMS-T226-->To verify that "Report field " panel should be visible in "Add
		// New Report " panel
		// Check "Report Field" drop-dwon visible
		boolean isReportFieldDropDownVisible = add_new_report_panel.isReportFieldDropDownIsVisible();
		asert.assertTrue(isReportFieldDropDownVisible,
				"To verify that Report field  panel should be visible in Add New Report  panel", "APMS-T226");

		// APMS-T227-->To verify that the user can select check boxes in the "Report
		// Field".
		// select the "Device ID" check box
		add_new_report_panel.selectReportFieldCheckBox("Device ID");
		// check "Device ID" check box is selected
		boolean isDeviceIdCheckBoxSelected = add_new_report_panel.isReportFieldCheckBoxSelected("Device ID");
		asert.assertTrue(isDeviceIdCheckBoxSelected,
				"To verify that the user can select  checkboxes in the Report Field ", "APMS-T227");

		// APMS-T178-->To verify that "created report" should be visible in the "Report
		// Template" table.
		// -> Enter Template Name
		String templateName = AwtUtilities.genrateRandomAlphaBets(1, 10);
		add_new_report_panel.enterTemplateName(templateName);
		// -> click on submit button
		add_new_report_panel.clickOnSubmitButton();
		// -> then close "Add New Report Panel"
		add_new_report_panel.closePanel();
		// Check Created Template Name Is Visible Under The Report Template Table
		String actual_template_name = admin_report_temp_page.getDataFromReportTemplateTable("Template Name",
				templateName);
		asert.assertEquals(actual_template_name, templateName,
				"To verify that created report should be visible in the Report Template table.", "APMS-T178");

	}
}
