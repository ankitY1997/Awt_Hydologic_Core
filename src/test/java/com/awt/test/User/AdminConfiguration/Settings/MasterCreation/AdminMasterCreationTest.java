package com.awt.test.User.AdminConfiguration.Settings.MasterCreation;

import org.testng.annotations.Test;

import com.awt.page.Login.LoginPage;
import com.awt.page.User.ParentLandingPage;
import com.awt.page.User.AdminConfiguration.AdminPage;
import com.awt.page.User.AdminConfiguration.Settings.MasterCreation.AdminMasterCreationPage;
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

	// Instance Variable ///
	public static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
	public static final String admin_project = "Admin";
	SoftAssertTest asert = null;
	LoginPage lp = null;
	ParentLandingPage parent_landing_page = null;
	AdminPage admin_page = null;
	AdminMasterCreationPage admin_master_creation_page = null;

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
	 * Description: Perform the verification of AdminMasterCreation Page <br>
	 * TestMethodName: verifyAdminMasterCreation <br>
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
	@Story(story = "Master Creation")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestCaseId(id = { "APMS-T159", "APMS-T160", "APMS-T161", "APMS-T162", "APMS-T163", "APMS-T164", "APMS-T165",
			"APMS-T166", "APMS-T167", "APMS-T168", "APMS-T169", "APMS-T170", "APMS-T171", "APMS-172", "APMS-T173",
			"APMS-T174", "APMS-T175", "APMS-T176", "APMS-T177", "APMS-T178", "APMS-T226", "APMS-T227", "APMS-T179",
			"APMS-T180", "APMS-T182", "APMS-T184", "APMS-T185", "APMS-T186", "APMS-T187", "APMS-T188", "APMS-T189",
			"APMS-T190" })
	public void verifyAdminMasterCreation() {
		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// Navigate To New
		navigateToParentLandingPage();
		// click Admin button and Navigate To Admin Page
		admin_page = (AdminPage) parent_landing_page.goToProjectPage(admin_project);

		// SU-T1-->To verify that "Master Creation" button should be visible under the
		// "Settings" menu

		// Go To Settings Menus And Select "Master Creation" and navigate to Admin
		// Master Creation Page
		admin_master_creation_page = admin_page.navigateToAdminMasterCrationPage();
		// Check Master Creation Menus Is visible
		boolean isMasterCreationMenusVisible = admin_master_creation_page.isMasterCreationOptionVisible();
		asert.assertTrue(isMasterCreationMenusVisible,
				"To verify that Master Creation button should be visible under the Settings menu", " SU-T1");

		// SU-T2-->To verify that after clicking on the "Master Creation" button user
		// should redirect to the "admin-Master Creation" page.
		// Check "admin-Master Creation" page is visible
		String url = DriverFactory.iuiDriver().getDriver().getCurrentUrl();
		asert.assertTrue(url.trim().contains("MasterCreation"),
				"To verify that Master Creation button should be visible under the Settings menu", admin_project);

		verifySystemMaster();
	}

	public void verifySystemMaster() {
		// SU-T3-->To verify that "System Master" radio button should be visible in the
		// "Master Creation" panel.
		// Check the "System Master" radio button is visible
		boolean isSystemMasterRadioButtonVisible = admin_master_creation_page.isRadioButtonIsVisible("System Master");
		asert.assertTrue(isSystemMasterRadioButtonVisible,
				"To verify that System Master radio button should be visible in the Master Creation panel.", "SU-T3");

		// SU-T4-->To verify that "User Defined" radio button should be visible in the
		// "Master Creation" panel.
		// Check the "User Defined" radio button is visible
		boolean isUserDefinedRadioButtonVisible = admin_master_creation_page.isRadioButtonIsVisible("User Defined");
		asert.assertTrue(isUserDefinedRadioButtonVisible,
				"To verify that User Defined radio button should be visible in the  Master Creation panel.", "SU-T4");

		// SU-T5-->To verify that "External" radio button should be visible in the
		// "Master Creation" panel.
		// Check the "External" radio button is visible
		boolean isExternalRadioButtonVisible = admin_master_creation_page.isRadioButtonIsVisible("External");
		asert.assertTrue(isExternalRadioButtonVisible,
				"To verify that External radio button should be visible in the  Master Creation panel.", "SU-T5");

		// SU-T6-->To verify that by default any one radio button should be selected,
		// between "System Master," "User Defined," and "External" in "Master Creation"
		// panel.

		// Check One Radio Button Is By Default Selected Or Not
		boolean isByDefaultAnyRadioButtonSelected = admin_master_creation_page.isByDefaultAnyRadioButtonIsChecked();
		asert.assertTrue(isByDefaultAnyRadioButtonSelected,
				"To verify that by default any one radio button should be selected,  between System Master,User Defined,and External in Master Creation panel.",
				"SU-T6");

		// SU-T7-->To verify that "Select Mode" drop down should be visible in the
		// "Master Creation" panel.
		// Check "Select Mode" drop-dwon is visible
		boolean isSelectModeDropDownVisible = admin_master_creation_page.isSelectModeDropDownVisible();
		asert.assertTrue(isSelectModeDropDownVisible,
				"To verify that Select Mode drop down should be visible in the Master Creation panel.", "SU-T7");

		// SU-T8-->To verify that the "Select Mode" drop-down displays the list of
		// options based on the selected radio button
		// -> First Select "System Master"
		admin_master_creation_page.clickOnRadioButton("System Master");
		// -> Click on "Select Mode" drop-down
		admin_master_creation_page.clickOnAnyMasterCreationDropDown("Select Mode");
		// Check "Notification Type" mode is visible
		boolean isNotificationTypeModeVisible = admin_master_creation_page.isModePresent("Notification Type");
		asert.assertTrue(isNotificationTypeModeVisible,
				"To verify that the Select Mode drop-down displays the  list of options based on the selected radio button",
				"SU-T8");

		// SU-T9-->To verify that "Select Mode" ellipsis button should be visible in the
		// "Master Creation" panel.
		boolean isSelectModeEllipsisButtonVisible = admin_master_creation_page.isSelectEllipsisButtonVisible();
		asert.assertTrue(isSelectModeEllipsisButtonVisible,
				"To verify that Select Mode ellipsis button should be visible in the Master Creation panel.", "SU-T9");

		// SU-T10-->To verify that by default user should able to see the "Master Name"
		// auto suggestive drop down.
		boolean isMasterNameDropDownVisible = admin_master_creation_page.isMasterNameAutoSuggestiveDropDownVisible();
		asert.assertTrue(isMasterNameDropDownVisible,
				"To verify that  by default  user should able to see the Master Name auto suggestive drop down.",
				"SU-T10");

		// SU-T11-->To verify that "Master Name" auto suggestive drop down should accept
		// only the alphanumeric
		// Enter alpha numeric
		String validValue = AwtUtilities.genrateRandomAlphaNeumric(6) + "-";
		admin_master_creation_page.enterMasteName(validValue);
		// ->Check the alpha numeric it's accepting
		String actual_value_of_master_name_text = admin_master_creation_page.getValueOfMasterNameAutoSuggestiveField();
		asert.assertEquals(validValue, actual_value_of_master_name_text,
				"To verify that Master Name auto suggestive drop down should accept only the alphanumeric", "SU-T11");

		// SU-T12-->To verify that "Master Name" auto suggestive drop down should not
		// accept any special characters except "hyphen" and "Space"
		// -> Enter Special Character And Hyphen
		String inValidValue = AwtUtilities.genrateRandomAlphaNeumric(5) + " " + "-" + "&&";
		admin_master_creation_page.enterMasteName(inValidValue);
		// -> Take The Actual Value From Master Name Text Auto Sugg Text Field
		actual_value_of_master_name_text = admin_master_creation_page.getValueOfMasterNameAutoSuggestiveField();
		// -->InvalidValue and Actual Value Should Not be Equal
		asert.assertNotEquals(actual_value_of_master_name_text, inValidValue,
				"To verify that Master Name auto suggestive drop down should  not accept any special characters  except  hyphen and Space",
				"SU-T12");

		// SU-T13-->To verify that "Master Name" text field should not exceed more than
		// 30 characters.
		// -> Enter More than "30" character
		inValidValue = AwtUtilities.genrateRandomAlphaNeumric(35);
		admin_master_creation_page.enterMasteName(inValidValue);
		// It should not accept more than 30 character
		actual_value_of_master_name_text = admin_master_creation_page.getValueOfMasterNameAutoSuggestiveField();
		asert.assertEquals(actual_value_of_master_name_text, inValidValue,
				"To verify that Master Name text field should  not exceed more than 30 characters.", "SU-T13");

		// SU-T14-->To verify that "Description" text field should be visible in the
		// "Master Creation" panel.
		// Check "Description" text field visible
		boolean isDescriptionTextFieldVisible = admin_master_creation_page.isDescriptionTextFieldVisible();
		asert.assertTrue(isDescriptionTextFieldVisible,
				"To verify that Description text field  should be visible in the Master Creation panel.", "SU-T15");

		// SU-T15-->To verify that "Description" text field should not exceed more than
		// 100 characters.
		// ->Enter More Than "100" character in Description text field
		inValidValue = AwtUtilities.genrateRandomAlphaNeumric(105);
		admin_master_creation_page.enterDescription(inValidValue);
		// ->Take Actual Value From "Description Text Field
		String actValueOfDescriptionTextField = admin_master_creation_page.getValueOfDescriptionTextField();
		// It Should Not Be Accept more than 100 character
		asert.assertEquals(actValueOfDescriptionTextField, inValidValue,
				"To verify that Description text field  should not exceed more than 100 characters.", "SU-T15");

		// SU-T16-->To verify that "Save" button should be visible in the "Master
		// Creation" panel.
		// Check 'save' button is visible
		boolean isSaveButtonVisible = admin_master_creation_page.isSaveButtonVisible();
		asert.assertTrue(isSaveButtonVisible,
				"To verify that Save button should be visible in the Master Creation panel.", "SU-T16");
		
		

	}

}
