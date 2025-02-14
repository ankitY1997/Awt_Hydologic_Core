package com.awt.test.Irrigation.oms.Master.Add_View_Village;

import org.testng.annotations.Test;

import com.awt.page.ParentLandingPage;
import com.awt.page.Irrigation.Home.HomePage;
import com.awt.page.Irrigation.Login.LoginPage;
import com.awt.page.Irrigation.oms.OmsAdminDashboardPage;
import com.awt.page.Irrigation.oms.Master.Add_View_Village.NewVillageDetailsPanel;
import com.awt.page.Irrigation.oms.Master.Add_View_Village.VillageDetailsPage;
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

public class VillageDetailsPageTest extends BaseTest {

	private static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
	private static final String project_name = PropertiesOperations.getPropertyValueByKey("Project_Name");
	private static final String main_porject_name = PropertiesOperations.getPropertyValueByKey("Main_Project_Name");
	private SoftAssertTest asert = null;
	private LoginPage login_page = null;
	private ParentLandingPage parent_landing_page = null;
	private HomePage home_page = null;
	private OmsAdminDashboardPage oms_admin_dashboard_page = null;
	private VillageDetailsPage village_details_page = null;
	private NewVillageDetailsPanel new_village_details_panel = null;

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

	@Version(number = "V-0.1")
	@Test(groups = { "Log In", "Functional" })
	@Description(description = "Perform the verfication on  Log In Page")
	@Story(story = "Log In ")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Log in")
	@TestCaseId(id = { "SU-T36", "SU-T37", "SU-T38", "SU-T718", "SU-T719", "SU-T719", "SU-T721", "APMS-T135", "SU-T723",
			"SU-T724", "SU-T725", "SU-T727", "SU-T728", "SU-T729", "SU-T730", "SU-T731", "SU-T732", "SU-T733",
			"SU-T734", "SU-T735", "SU-T736", "SU-T737", "SU-T738", "SU-T742", "SU-T742", "SU-T742", "SU-T743",
			"SU-T743" })
	public void verifyVillageDetailsPage() {
		// Logger Instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// ->Login To The Application and Navigate To The HomePage
		home_page = login_page.loginAndNavigateToHomePage(PropertiesOperations.getPropertyValueByKey("Project_Name"),
				PropertiesOperations.getPropertyValueByKey("Create_Project_USERNAME"),
				PropertiesOperations.getPropertyValueByKey("Create_Project_PASSWORD"));

		// ->Click on "OMS" module and Navigate To OmsAdminDashboardPage
		oms_admin_dashboard_page = home_page.navigateToOmsAdminDashboardPage();

		// SU-T36 -->To verify that "Add/View Village" option should be visible in the
		// "Master" menu

		// -> Validate the "Add/View Village Options Under The Master Menus
		boolean isAdd_View_VillageOptionVIsible = oms_admin_dashboard_page.isAddViewVillageOptionVisible();
		asert.assertTrue(isAdd_View_VillageOptionVIsible,
				"To verify that 'Add/View Village' option should be visible in the 'Master' menu", "SU-T36");

		// SU-T37-->To verify that after clicking on the "Add/View Village" button user
		// should redirected to the "OMS-getVillageArea" page.

		// Click "Add/View Village" options and redirect to the "OMS-getVillageArea"
		// page
		village_details_page = oms_admin_dashboard_page.navigateToVillageDetailsPage();
		// ->take the current page name
		String current_url = DriverFactory.iuiDriver().getDriver().getCurrentUrl();
		// Validate "OMS-getVillageArea"
		asert.assertTrue(current_url.contains("OMS-getVillageArea"),
				"To verify that after clicking on the 'Add/View Village' button user should redirected to the 'OMS-getVillageArea' page.",
				"SU-T37");

		// SU-T38-->To verify that "New" button should be present in the
		// "OMS-getVillageArea" Page

		// ->Check the "new" button is visible or not
		boolean isNewButtonVisible = village_details_page.isNewButtonIsVisible();
		asert.assertTrue(isNewButtonVisible,
				"To verify that New button should be present in the OMS-getVillageArea Page", "SU-T38");

	}

	public void verifyNewVillageDetailsPanel() {

		// SU-T39-->To verify that after clicking on the "New" button user should
		// redirect to the "New Villages Details" panel

		// ->Click on "New" button
		new_village_details_panel = village_details_page.clickOnNewButtonAndNavigateToNewVillageDetaisPanel();
		// Validate "New Village Details" Panel is visible or not
		String actual_panel_name = new_village_details_panel.getPanelName();
		String exp_panel_name = "New Village Details";
		asert.assertEquals(actual_panel_name, exp_panel_name,
				"To verify that after clicking on the 'New' button user should redirect to the  'New Villages Details'  panel",
				"SU-T39");

		// SU-T40-->To verify that "Command Area" drop down should be visible in the
		// "New Villages Details" panel.

		// ->Validate "Command DropDown" visiblity
		boolean isCommandAreaDropDownPresent = new_village_details_panel.isCommandAreaDropDownIsVisible();
		asert.assertTrue(isCommandAreaDropDownPresent,
				"To verify that 'Command Area' drop down should be visible in the 'New Villages Details' panel.",
				"SU-T40");

		// SU-T42-->To verify that user can select the option under the "Command Area"
		// drop down.

		// -->Click on the "command area" drop down and select one command area
		String exp_option_name = "Ujjain";
		new_village_details_panel.clickandSelectOptionFromCommnadAreaDropDown(exp_option_name);
		// get the command area selected options
		String acutal_selected_option = new_village_details_panel.getSelctedOptionFromCommandAreaDropDown();
		// validate the selcted command area is visble
		asert.assertEquals(acutal_selected_option, exp_option_name,
				"To verify that user can select  the option under the 'Command Area' drop down.", "SU-T42");

		// SU-T1080-->To verify that "District" drop down should be visible in the "New
		// Villages Details" panel.

		// -> Check "District" drop down is visible
		boolean isDistrictDropDownVisible = new_village_details_panel.isDistrictDropDownIsVisible();
		asert.assertTrue(isDistrictDropDownVisible,
				"To verify that 'District' dropdown should be visible under the 'New Villages Details'  panel. ",
				"SU-T1080");

		// SU-T45-->To verify that "village name" text field should be visible in the
		// "New Villages Details" panel.

		// Validate "Village Name" text field should be visible
		boolean isVillageNameTextFieldVisible = new_village_details_panel.isVillageAreaTextFieldIsVisible();
		asert.assertTrue(isVillageNameTextFieldVisible,
				"To verify that 'village name' text field should be visible in the 'New Villages Details'  panel.",
				"SU-T45");

		// SU-T46-->To ensure that the "village name" text field accepts only alphabetic
		// characters and no other characters.

		// ->Enter a valid village name like only alphabetes
		String validVillageName = AwtUtilities.genrateRandomAlphaBets(0, 5);
		// ->Enter a valid village name in village name text field
		new_village_details_panel.enterVillageName(validVillageName);
		// -> Take the actual entered value from "village" name text field
		String actualVillageTextFieldlValue = new_village_details_panel.getVillageNameTextFieldValue();
		// Ensure that it's should accept valid values
		asert.assertEquals(actualVillageTextFieldlValue, validVillageName,
				"To ensure that the 'village name' text field accepts only alphabetic characters and no other characters.",
				"SU-T46");
		// -> Enter a Invalid Village name
		String inValidVillageName = AwtUtilities.genrateRandomAlphaBets(0, 5) + AwtUtilities.genrateRandomNumber(3);
		new_village_details_panel.enterVillageArea(inValidVillageName);
		// -> Take the acutal value from village name text field
		actualVillageTextFieldlValue = new_village_details_panel.getVillageNameTextFieldValue();
		// Ensure That It's should not accept the "invalid" values
		asert.assertEquals(actualVillageTextFieldlValue, inValidVillageName,
				"To ensure that the 'village name' text field accepts only alphabetic characters and no other characters.",
				"SU-T46");

		// SU-T47-->To verify that "village name" text field should not exceed more than
		// 30 characters

		// Enter a more than 30 character village name
		inValidVillageName = AwtUtilities.genrateRandomAlphaBets(30);
		new_village_details_panel.enterVillageArea(inValidVillageName);
		// Get the actual value from village are text field\
		actualVillageTextFieldlValue = new_village_details_panel.getVillageNameTextFieldValue();
		// It's should not accept more than 30 character
		asert.assertEquals(actualVillageTextFieldlValue, inValidVillageName,
				"To verify that 'village name' text field should not exceed more than 30 characters", "SU-T47");

	}

}
