package com.awt.test.User.AdminConfiguration.Settings.ReportTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class AdminReportTemplateTest extends BaseTest {

	// Instance Variable ///
	public static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
	public static final String admin_project = "Admin";
	SoftAssertTest asert = null;
	LoginPage lp = null;
	ParentLandingPage parent_landing_page = null;
	AdminPage admin_page = null;
	AdminReportTemplatePage admin_report_temp_page = null;
	AddNewReportPanel add_new_report_panel = null;
	String templateName = null;

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
	 * TestMethodName: verifyAdminReportTemplate <br>
	 * ManualTestCases: "APMS-T159", "APMS-T160", "APMS-T161", "APMS-T162",
	 * "APMS-T163", "APMS-T164", "APMS-T165", "APMS-T166", "APMS-T167", "APMS-T168",
	 * "APMS-T169", "APMS-T170", "APMS-T171", "APMS-172", "APMS-T173", "APMS-T174",
	 * "APMS-T175", "APMS-T176", "APMS-T177", "APMS-T178", "APMS-T226", "APMS-T227",
	 * "APMS-T179", "APMS-T180", "APMS-T182", "APMS-T184", "APMS-T185", "APMS-T186",
	 * "APMS-T187", "APMS-T188", "APMS-T189", "APMS-T190"
	 * 
	 * @author ankit
	 */

	@Version(number = "V-0.1")
	@Test(groups = { "Admin", "Functional" })
	@Description(description = "Perform the verfication on  Admin Report Template")
	@Story(story = "Report Template")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestCaseId(id = { "APMS-T159", "APMS-T160", "APMS-T161", "APMS-T162", "APMS-T163", "APMS-T164", "APMS-T165",
			"APMS-T166", "APMS-T167", "APMS-T168", "APMS-T169", "APMS-T170", "APMS-T171", "APMS-172", "APMS-T173",
			"APMS-T174", "APMS-T175", "APMS-T176", "APMS-T177", "APMS-T178", "APMS-T226", "APMS-T227", "APMS-T179",
			"APMS-T180", "APMS-T182", "APMS-T184", "APMS-T185", "APMS-T186", "APMS-T187", "APMS-T188", "APMS-T189",
			"APMS-T190" })
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
		// Validating Report Template Details Table
		verifyReportTemplateTable();

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
		String act_template_name = add_new_report_panel.getDefaultValueFromTemplateNameTextField().trim();
		asert.assertEquals(act_template_name, device_profile_selected_option + " - " + device_parameter_selected_option,
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
		templateName = AwtUtilities.genrateRandomAlphaBets(6);
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

		// APMS-T190-->To verify that Duplicate "Template Name" should not accept in the
		// "Add New Report" Panel.
		// -> Click on "New" button.
		admin_report_temp_page.clickOnNewButtonAndNavigateToAddNewReportPanel();
		// Enter All Mandatory details
		// ->Select Device profile
		add_new_report_panel.selectDropDown("Device Profile*", "OMS");
		// ->Select Device Parameter
		add_new_report_panel.selectDropDown("Device Parameter*", "Door");
		// ->Enter Template Name
		add_new_report_panel.enterTemplateName(templateName);
		// -> Select Menu Level
		add_new_report_panel.selectDropDown("Menu Level*", "Report");
		// -> Select Parameter Status
		add_new_report_panel.selectParameterStatusCheckBox("Door close");
		// ->Select Report Field
		add_new_report_panel.selectReportFieldCheckBox("device_id");
		// Click On Submit Button
		add_new_report_panel.clickOnSubmitButton();
		// Check Duplicate Error Message
		String act_error_message = add_new_report_panel.getTemplateNameTextErrorMessage().trim();
		asert.assertEquals(act_error_message, "Template Name should not be Duplicate",
				"To verify that Duplicate Template Name should not accept in the  Add New Report Panel.", "APMS-T190");
		add_new_report_panel.closePanel();
	}

	/**
	 * In this method we are validating report template table test cases
	 */
	public void verifyReportTemplateTable() {

		// APMS-T179-->To verify that "Report Template" table contains the "SNo,
		// Template
		// Name, Device type, Report Type, Show Serial Number , Show Set Value, Action"
		// Columns.
		String[] report_temp_table_columns = { "SNO", "Template Name", "Device Type", "Report Type",
				"Show Serial Number", "Show Set Value", "Action" };
		// Check All Columns Should be Visible
		List<String> list_of_actual_column = admin_report_temp_page.listOfReportTemplateTableColumns();
		asert.assertEquals(list_of_actual_column, new ArrayList(Arrays.asList(report_temp_table_columns)),
				"To verify that Report Template table contains the SNo, Template Name, Device type, Report Type, Show Serial Number , Show Set Value, Action  Columns.",
				"APMS-T179");

		// APMS-T180-->To verify that "delete" button should be present under the
		// "Action" column
		// Verify "Delete" button is present
		boolean isDeleteButtonVisible = admin_report_temp_page.isDeleteButtonIsVisible();
		asert.assertTrue(isDeleteButtonVisible,
				"To verify that  delete button should be present under the Action column", "APMS-T180");

		// APMS-T183-->To verify that Search text field should be visible in the
		// "admin-ReportTemplate" page.
		// Verify "Search Text Field" is visible
		boolean isSearchTextFieldVisible = admin_report_temp_page.isSearchTextFieldVisible();
		asert.assertTrue(isSearchTextFieldVisible,
				"To verify that Search  text field should be visible in the admin-ReportTemplate page.", "APMS-T183");

		// APMS-T183 -->To Verify the "search text field" Functionality
		// ->Enter a Template Name
		admin_report_temp_page.search(templateName);
		// Check Template Name value visible in first row
		boolean isSearchValueInFirstRow = admin_report_temp_page.isSearchValueInFirstRow(templateName);
		asert.assertTrue(isSearchValueInFirstRow, "To Verify the search text field Functionality", "APMS-T183");
		// ->clear search text field
		admin_report_temp_page.clearSearchTextField();

		// APMS-T182-->To verify the functionality of the "delete" button.
		// -> Delete The Created Template Name
		admin_report_temp_page.clickOnDeleteButton(templateName);
		// Template Name Should Not Be Present in the table
		asert.assertNotEquals(templateName,
				admin_report_temp_page.getDataFromReportTemplateTable("Template Name", templateName),
				"To verify the functionality of the delete button.", "APMS-T182");
		// APMS-T184-->To verify that Rows Per Page should be visible in the
		// "admin-Report Template" page
		// Verify "Rows Per Page" drop-down is visible
		boolean isRowsPerPageDropDownVisible = admin_report_temp_page.isRowsPerPageDropDownIsVisible();
		asert.assertTrue(isRowsPerPageDropDownVisible,
				"To verify that Rows Per Page should be visible in the admin-Report Template page", "APMS-T184");

		// APMS-T185-->To verify that "Rows Per Page" should be visible in the
		// "admin-Report Template" page
		// Enter Number Of Rows Per Page and Check is Table Is Update
		boolean isTableUpdated = admin_report_temp_page.isUpdateTheTable("10");
		asert.assertTrue(isTableUpdated,
				"To verify that changing the numbers of rows per page drop down , updates the table accordingly",
				"APMS-T185");

		// APMS-T186-->To verify that "first" pagination button should be visible in the
		// "Report Template" table
		// Check Fist pagination button is visible
		boolean isFirsPaginationButtonVisible = admin_report_temp_page.isFirstPaginationButtonIsVisible();
		asert.assertTrue(isFirsPaginationButtonVisible, "To veify First Pagination Button Should Be Visible",
				"APMS-T186");
		// APMS-T187-->To verify that "Next" pagination button should be visible in the
		// "Report Template" table
		// check next pagination button is visible
		boolean isNextPaginationButtonVisible = admin_report_temp_page.isNextPaginationButtonIsVisible();
		asert.assertTrue(isNextPaginationButtonVisible, "To veify Next Pagination Button Should Be Visible",
				"APMS-T187");
		// APMS-T188-->To verify that "Previous" pagination button should be visible in
		// the "Report Template" table
		// check previous pagination button is visible
		boolean isPreviousPaginationButtonVisible = admin_report_temp_page.isPreviousPaginationButtonIsVisible();
		asert.assertTrue(isPreviousPaginationButtonVisible, "To veify Previous Pagination Button Should Be Visible",
				"APMS-T188");
		// APMS-T189-->To verify that "Last" pagination button should be visible in the
		// "Report Template" table
		// check last pagination button is visible
		boolean isLastPaginationButtonVisible = admin_report_temp_page.isLastPaginationButtonIsVisible();
		asert.assertTrue(isLastPaginationButtonVisible, "To veify Last Pagination Button Should Be Visible",
				"APMS-T189");

	}

}
