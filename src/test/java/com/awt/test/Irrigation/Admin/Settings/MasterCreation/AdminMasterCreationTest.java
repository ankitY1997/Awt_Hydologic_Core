package com.awt.test.Irrigation.Admin.Settings.MasterCreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.awt.page.ParentLandingPage;
import com.awt.page.Irrigation.Admin.AdminDashboardPage;
import com.awt.page.Irrigation.Admin.Settings.MasterCreation.AdminMasterCreationPage;
import com.awt.page.Irrigation.Home.HomePage;
import com.awt.page.Irrigation.Login.LoginPage;
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

public class AdminMasterCreationTest extends BaseTest {

	// **Instance Variable**//
	// **Instance Variable**//
	private static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
	private static final String project_name = PropertiesOperations.getPropertyValueByKey("Project_Name");
	private static final String main_porject_name = PropertiesOperations.getPropertyValueByKey("Main_Project_Name");
	SoftAssertTest asert = null;
	LoginPage login_page = null;
	ParentLandingPage parent_landing_page = null;
	AdminDashboardPage adminDashboard_page = null;
	HomePage home_page = null;
	AdminMasterCreationPage admin_master_creation_page = null;

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
	 * Description: Perform the verification of AdminMasterCreation Page <br>
	 * TestMethodName: verifyAdminMasterCreation <br>
	 * ManualTestCases: "SU-T1", "SU-T2", "SU-T3", "SU-T4", "SU-T5", "SU-T6",
	 * "SU-T7", "SU-T8", "SU-T9", "SU-T10", "SU-T11", "SU-T12", "SU-T13", "SU-T14",
	 * "SU-T15", "SU-T16", "SU-T17", "SU-T21", "SU-T22", "SU-T23", "SU-T24",
	 * "SU-T25", "SU-T26", "SU-T177", "SU-T178", "SU-T18", "SU-T179", "SU-T193",
	 * "SU-T200", "SU-T201", "SU-T202", "SU-T210", "SU-T211", "SU-T212", "SU-T213",
	 * "SU-T214", "SU-T215", "SU-T216", "SU-T218", "SU-T219", "SU-T220", "SU-T221",
	 * "SU-T222", "SU-T228", "SU-T229", "SU-T230", "SU-T231", "SU-T232", "SU-T233",
	 * "SU-T234", "SU-T235", "SU-T236", "SU-T237", "SU-T238", "SU-T241", "SU-T242",
	 * "SU-T243"
	 * 
	 * @author ankit
	 */

	@Version(number = "V-0.1")
	@Test(groups = { "Admin", "Functional" })
	@Description(description = "Perform the verfication on  AdminMasterCreation Page")
	@Story(story = "Master Creation")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestCaseId(id = { "SU-T1", "SU-T2", "SU-T3", "SU-T4", "SU-T5", "SU-T6", "SU-T7", "SU-T8", "SU-T9", "SU-T10",
			"SU-T11", "SU-T12", "SU-T13", "SU-T14", "SU-T15", "SU-T16", "SU-T17", "SU-T21", "SU-T22", "SU-T23",
			"SU-T24", "SU-T25", "SU-T26", "SU-T177", "SU-T178", "SU-T18", "SU-T179", "SU-T193", "SU-T200", "SU-T201",
			"SU-T202", "SU-T210", "SU-T211", "SU-T212", "SU-T213", "SU-T214", "SU-T215", "SU-T216", "SU-T218",
			"SU-T219", "SU-T220", "SU-T221", "SU-T222", "SU-T228", "SU-T229", "SU-T230", "SU-T231", "SU-T232",
			"SU-T233", "SU-T234", "SU-T235", "SU-T236", "SU-T237", "SU-T238", "SU-T241", "SU-T242", "SU-T243" })
	public void verifyAdminMasterCreation() {
		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// Navigate To Irrigation Log In Page
		navigateToLoginPage();
		// Login to the application and Navigate To The Home Page
		home_page = login_page.loginAndNavigateToHomePage(project_name,
				PropertiesOperations.getPropertyValueByKey("User_USERNAME"),
				PropertiesOperations.getPropertyValueByKey("User_PASSWORD"));
		// click Admin button and Navigate To Admin Page
		adminDashboard_page = home_page.navigateToAdminDashboardPage();
		// SU-T1-->To verify that "Master Creation" button should be visible under the
		// "Settings" menu
		// Go To Settings Menus And Select "Master Creation" and navigate to Admin
		// Master Creation Page
		admin_master_creation_page = adminDashboard_page.navigateToAdminMasterCrationPage();
		// Check Master Creation Menus Is visible
		boolean isMasterCreationMenusVisible = admin_master_creation_page.isMasterCreationOptionVisible();
		asert.assertTrue(isMasterCreationMenusVisible,
				"To verify that Master Creation button should be visible under the Settings menu", " SU-T1");

		// SU-T2-->To verify that after clicking on the "Master Creation" button user
		// should redirect to the "admin-Master Creation" page.
		// Check "admin-Master Creation" page is visible
		String url = DriverFactory.iuiDriver().getDriver().getCurrentUrl();
		asert.assertTrue(url.trim().contains("MasterCreation"),
				"To verify that Master Creation button should be visible under the Settings menu", "SU-T2");

		// **Verify User Defined Panel Functionality**/
		verifyUserDefined();

		// *assert All**/
		asert.assertAll();
	}

	/**
	 * By this method we are validating User Defined radio button and it's
	 * functionality
	 */
	public void verifyUserDefined() {
		DriverFactory.iuiDriver().getDriver().navigate().refresh();
		// SU-T18->To verify the fields in "Master Creation" panel when we select the
		// "User Defined" radio button
		// Expected Fields Under The User Defined Panel
		String[] exp_UserDefinedFields = { "Select Mode*", "Master Name*", "Description" };
		// Actual Fields Under The User Defined Panel
		List<String> user_defined_fields_name = admin_master_creation_page.getAllUserDefinedFieldName();
		asert.assertEquals(user_defined_fields_name, new ArrayList<String>(Arrays.asList(exp_UserDefinedFields)),
				"To verify the fields in 'Master Creation' panel when we select The User Defined radio button",
				"SU-T18");

		// SU-T179-->To verify that the "Select Mode" drop-down displays the list of
		// options based on the selected "User defined Radio" button
		// -> click on "Select Mode" drop down button
		admin_master_creation_page.clickOnAnyMasterCreationDropDown("Select Mode");
		// Check "Zone" is visible under the "Select Mode" drop down
		boolean isZoneOptionIsPresent = admin_master_creation_page.isModePresent("Zone");
		asert.assertTrue(isZoneOptionIsPresent,
				"To verify that the Select Mode drop-down displays the  list of options based on the selected User defined Radio button",
				"SU-T179");
		/**
		 * This Test Case Is Deprecated because now we dont have any ellipsis button
		 * 
		 * // SU-T193-->To verify that after selecting "User defined" radio button,
		 * "Select // Mode" ellipsis button should be visible in the "Master Creation"
		 * panel. // Check ellipsis button is visible boolean isEllipsisButtonVisible =
		 * admin_master_creation_page.isSelectModeEllipsisButtonVisible();
		 * asert.assertTrue(isEllipsisButtonVisible, "To verify that after selecting
		 * User defined radio button, Select Mode ellipsis button should be visible in
		 * the Master Creation panel.", "SU-T193");
		 * 
		 * 
		 **/

		// SU-T200-->To verify that after selecting "user defined", by default user
		// should able to see the "Master Name" auto suggestive drop down.
		// Check "Master Name" auto suggestive drop down is visible
		boolean isMasterNameAutoSuggestiveDropDownVisibe = admin_master_creation_page
				.isMasterNameAutoSuggestiveDropDownVisible();
		asert.assertTrue(isMasterNameAutoSuggestiveDropDownVisibe,
				"To verify that after selecting user defined , by default user should able to see the Master Name auto suggestive drop down.",
				"SU-T200");

		// SU-T201-->To verify that "Master Name" auto suggestive drop down should
		// accept
		// only the alphanumeric
		// Enter alpha numeric
		String validValue = AwtUtilities.genrateRandomAlphaNeumric(6) + "-";
		admin_master_creation_page.enterMasteName(validValue);
		// ->Check the alpha numeric it's accepting
		String actual_value_of_master_name_text = admin_master_creation_page.getValueOfMasterNameAutoSuggestiveField();
		asert.assertEquals(actual_value_of_master_name_text, validValue,
				"To verify that Master Name auto suggestive drop down should accept only the alphanumeric", "SU-T201");

		// SU-T202-->To verify that "Master Name" auto suggestive drop down should not
		// accept any special characters except "hyphen" and "Space"
		// -> Enter Special Character And Hyphen
		String inValidValue = AwtUtilities.genrateRandomAlphaNeumric(5) + " " + "-" + "&&";
		admin_master_creation_page.enterMasteName(inValidValue);
		// -> Take The Actual Value From Master Name Text Auto Sugg Text Field
		actual_value_of_master_name_text = admin_master_creation_page.getValueOfMasterNameAutoSuggestiveField();
		// -->InvalidValue and Actual Value Should Not be Equal
		asert.assertNotEquals(actual_value_of_master_name_text, inValidValue,
				"To verify that Master Name auto suggestive drop down should  not accept any special characters  except  hyphen and Space",
				"SU-T202");

		// SU-T203-->To verify that "Master Name" text field should not exceed more than
		// 30 characters.
		// -> Enter More than "30" character
		inValidValue = AwtUtilities.genrateRandomAlphaNeumric(35);
		admin_master_creation_page.enterMasteName(inValidValue);
		// It should not accept more than 30 character
		actual_value_of_master_name_text = admin_master_creation_page.getValueOfMasterNameAutoSuggestiveField();
		asert.assertNotEquals(actual_value_of_master_name_text, inValidValue,
				"To verify that Master Name text field should  not exceed more than 30 characters.", "SU-T203");

		// SU-T204-->To verify that "Description" text field should be visible in the
		// "Master Creation" panel.
		// Check "Description" text field visible
		boolean isDescriptionTextFieldVisible = admin_master_creation_page.isDescriptionTextFieldVisible();
		asert.assertTrue(isDescriptionTextFieldVisible,
				"To verify that Description text field  should be visible in the Master Creation panel.", "SU-T204");

		// SU-T205-->To verify that "Description" text field should not exceed more than
		// 100 characters.
		// ->Enter More Than "100" character in Description text field
		inValidValue = AwtUtilities.genrateRandomAlphaNeumric(105);
		admin_master_creation_page.enterDescription(inValidValue);
		// ->Take Actual Value From "Description Text Field
		String actValueOfDescriptionTextField = admin_master_creation_page.getValueOfDescriptionTextField();
		// It Should Not Be Accept more than 100 character
		asert.assertNotEquals(actValueOfDescriptionTextField, inValidValue,
				"To verify that Description text field  should not exceed more than 100 characters.", "SU-T205");

		// SU-T206-->To verify that after selecting "user defined" radio button, "Save"
		// button should be visible in the "Master Creation" panel.
		// Check 'save' button is visible
		boolean isSaveButtonVisible = admin_master_creation_page.isSaveButtonVisible();
		asert.assertTrue(isSaveButtonVisible,
				"To verify that after selecting user defined radio button, Save button should be visible in the Master Creation panel.",
				"SU-T206");
		/**
		 * This Test Cases deprecated because now we done have " Mode Master panel}
		 * 
		 * @deprecated
		 * 
		 *             // SU-T207-->To verify that after clicking on the "Ellipsis"
		 *             button ,user should // redirect to the Mode Master Panel. // ->
		 *             click on ellipsis button and navigate to mode maste panel
		 *             user_defined_mode_master_panel = admin_master_creation_page
		 *             .clickOnElipsisButtonNavigateToUserDefinedMasterPanel(); // Check
		 *             "Mode Master" panel is visible String actual_panel_name =
		 *             user_defined_mode_master_panel.getUserDefinedMasterPanelName();
		 *             asert.assertEquals(actual_panel_name, "Mode Master", "To verify
		 *             that after clicking on the Ellipsis button ,user shouldredirect
		 *             to the Mode Master Panel.", "SU-T207");
		 * 
		 *             // SU-T208-->To verify that after clicking on the "Ellipsis"
		 *             button ,user should // be able to see "System Master", "User
		 *             Defined", "External Radio" buttons String[] exp_radio_butons = {
		 *             "System Master", "User Defined", "External" }; List<String>
		 *             act_radio_buttons =
		 *             user_defined_mode_master_panel.getModeMasterRadioButtonNames();
		 *             asert.assertEquals(act_radio_buttons, new
		 *             ArrayList<String>(Arrays.asList(exp_radio_butons)), "To verify
		 *             that after clicking on the Ellipsis button ,user should be able
		 *             to see System Master, User Defined, External Radio buttons",
		 *             "SU-T208");
		 * 
		 * 
		 * 
		 *             // SU-T209-->To verify that while selecting "User defined " radio
		 *             button, "Mode // name " text field should be visible in the "Mode
		 *             Master" panel. // Click On "User Defined" Radio button boolean
		 *             isModeNameTextFieldIsVisible =
		 *             user_defined_mode_master_panel.isModeNameTextFieldVisible();
		 *             asert.assertTrue(isModeNameTextFieldIsVisible, "To verify that
		 *             while selecting User defined radio button, Mode name text field
		 *             should be visible in the Mode Master panel.", "SU-T209");
		 * 
		 *             // SU-T210-->To verify that "Mode name " text field should not
		 *             accept more than // 30 characters // ->Enter More than "30"
		 *             character String inValidChar =
		 *             AwtUtilities.genrateRandomAlphaBets(35);
		 *             user_defined_mode_master_panel.enterModeName(inValidChar); // ->
		 *             Get Actual "Mode Name" text field value String
		 *             actual_mode_name_field_value =
		 *             user_defined_mode_master_panel.getModeNameTextFieldValue().trim();
		 *             asert.assertNotEquals(actual_mode_name_field_value, inValidChar,
		 *             "To verify that Mode name text field should not accept more than
		 *             30 characters", "SU-T210");
		 * 
		 *             // SU-T211-->To verify that while selecting "user defined" radio
		 *             button, "Parent // Mode " drop down should be visible in the
		 *             "Mode Master" panel // Check ParentMode Drop Down Button is
		 *             visible boolean isParentModeDropDownVisible =
		 *             user_defined_mode_master_panel.isParentModeDropDownVisible();
		 *             asert.assertTrue(isParentModeDropDownVisible, "To verify that
		 *             while selecting user defined radio button, Parent Mode drop down
		 *             should be visible in the Mode Master panel", "SU-T211");
		 * 
		 *             // SU-T212-->To verify that "Save" button should be visible in
		 *             the "Mode Master" // panel . // Check "Save" button is visible
		 *             boolean isSaveButtonIsVisible =
		 *             user_defined_mode_master_panel.isModeMasterSaveButtonVisible();
		 *             asert.assertTrue(isSaveButtonIsVisible, "To verify that Save
		 *             button should be visible in the Mode Master panel .", "SU-T212");
		 * 
		 *             // SU-T213-->To verify that "Close" svg button should be visible
		 *             in the the // "Mode Master" Panel. // Check Close button is
		 *             visible boolean isCloseSvgButtonIsVisible =
		 *             user_defined_mode_master_panel.isCloseButtonIsVisible();
		 *             asert.assertTrue(isCloseSvgButtonIsVisible, "To verify that Close
		 *             svg button should be visible in the the Mode Master Panel.",
		 *             "SU-T213");
		 * 
		 * 
		 * 
		 *             // SU-T214-->To verify that After selecting the "user defined"
		 *             radio button, // Created mode should be visible under the "Select
		 *             Mode" drop down in the // "Master Creation" panel // -> Enter
		 *             Mode Name String mode_name = "Testing Zone" +
		 *             AwtUtilities.genrateRandomNumber(2);
		 *             user_defined_mode_master_panel.enterModeName(mode_name); // ->
		 *             Click On Save Button
		 *             user_defined_mode_master_panel.clickOnModeMasterSaveButton(); //
		 *             -> Then Select System Master Radio Button under Master Creation
		 *             Panel
		 *             user_defined_mode_master_panel.clickOnModeMasterRadioButton("User
		 *             Defined"); // --> Then Click on Select Mode Drop-dwon and Check
		 *             Create Mode Is Visible
		 *             admin_master_creation_page.clickOnAnyMasterCreationDropDown("Select
		 *             Mode"); boolean isCreatedModeIsPresent =
		 *             admin_master_creation_page.isModePresent(mode_name);
		 *             asert.assertTrue(isCreatedModeIsPresent, "To verify that After
		 *             selecting the System Master radio button, Created Mode Name
		 *             should be visible under the Select Mode drop down in the Master
		 *             Creation panel", "SU-T214");
		 * 
		 **/

		/**
		 * This test cases is deprecated because now we dont have any "System Mode
		 * Master Panel"
		 * 
		 * @deprectaed // SU-T215-->To verify that after clicking on "close" button,
		 *             user should be // able to redirect "admin-MasterCreation" page //
		 *             -> Click On Ellipsis button
		 *             admin_master_creation_page.clickOnElipsisButtonNavigateToSystemModeMasterPanel();
		 *             // -> Then click on "Close" svg button
		 *             user_defined_mode_master_panel.clickOnCloseButton(); // -> and
		 *             validate user is reached master creation panel or not boolean
		 *             isSelectModeDropDownVisible =
		 *             admin_master_creation_page.isSelectModeDropDownVisible();
		 *             asert.assertTrue(isSelectModeDropDownVisible, "To verify that
		 *             after clicking on close button, user should be able to redirect
		 *             to Master Creation panel", "SU-T215");
		 * 
		 * 
		 *             // SU-T216-->To verify that after selecting "User Defined" radio
		 *             button, // "Cancel" button should be visible in the "Master
		 *             Creation" panel. // Check "Cancel button is visible boolean
		 *             isCancelButtonVisible =
		 *             user_defined_mode_master_panel.isCancelButtonVisible();
		 *             asert.assertTrue(isCancelButtonVisible, "To verify that after
		 *             selecting User Defined radio button, Cancel button should be
		 *             visible in the Master Creation panel.", "SU-T216");
		 * 
		 **/

		// SU-T218-->To verify "save" button functionality under the "user defined"
		// radio button
		// -> Click on "Select Mode" drop down
		admin_master_creation_page.clickOnAnyMasterCreationDropDown("Select Mode");
		// -> Then Select Mode
		admin_master_creation_page.selectMode("Zone");
		// ->Then Enter Master Name
		String Master_Name = "Testing Zone" + AwtUtilities.genrateRandomAlphaBets(1);
		admin_master_creation_page.enterMasteName(Master_Name);
		// -> Then Enter Description
		String description = "For Testing Purpose Only";
		admin_master_creation_page.enterDescription(description);
		// ->Then click On "Save" button
		admin_master_creation_page.clickOnSaveButton();
		// -> Then again select the same mode name
		admin_master_creation_page.clickOnAnyMasterCreationDropDown("Select Mode");
		admin_master_creation_page.selectMode("Zone");
		// ->Then click on master name drop-down
		admin_master_creation_page.clickOnAnyMasterCreationDropDown("Master Name");
		// Check Created Master Name is Present in Master Name list
		boolean isCreatedMasterNameIsPresent = admin_master_creation_page.isMasterNamePresent(Master_Name);
		asert.assertTrue(isCreatedMasterNameIsPresent,
				"To verify save button functionality under the System Master radio button", "SU-T218");

		// SU-T219-->To verify that "Cancel" button functionality while selecting
		// "System Master" radio button
		// ->Select Master Name
		admin_master_creation_page.selectMasterName(Master_Name);
		// ->Get Description before clicking on cancel button
		String desc_before_cancel = admin_master_creation_page.getValueOfDescriptionTextField();
		// ->Click on "Cancel" button
		admin_master_creation_page.clickOnCancelButton();
		// -> Then Check Description field Empty
		String desc_after_cancel_button = admin_master_creation_page.getValueOfDescriptionTextField();
		asert.assertNotEquals(desc_after_cancel_button, desc_before_cancel,
				"To verify that Cancel button functionality while selecting System Master radio button", "SU-T219");
	}

}
