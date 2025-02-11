package com.awt.test.Irrigation.Admin.Settings.PagePermission;

import org.testng.annotations.Test;

import com.awt.page.ParentLandingPage;
import com.awt.page.Irrigation.Admin.AdminDashboardPage;
import com.awt.page.Irrigation.Admin.Settings.PagePermission.AdminMenuPermissionPage;
import com.awt.page.Irrigation.Admin.User.CreateRole.AddNewRolePanel;
import com.awt.page.Irrigation.Admin.User.CreateRole.AdminAddRolePage;
import com.awt.page.Irrigation.Admin.User.CreateUser.AddUserPanel;
import com.awt.page.Irrigation.Admin.User.CreateUser.AdminAddUserPage;
import com.awt.page.Irrigation.Home.HomePage;
import com.awt.page.Irrigation.Login.LoginPage;
import com.awt.page.Irrigation.Oms.OmsAdminDashboardPage;
import com.awt.page.User.Irrigation.MainDashboardPage;
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

public class AdminMenuPermissionTest extends BaseTest {

	// **Instance Variable**//
	private static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
	private static final String project_name = PropertiesOperations.getPropertyValueByKey("Project_Name");
	private static final String main_porject_name = PropertiesOperations.getPropertyValueByKey("Main_Project_Name");
	SoftAssertTest asert = null;
	LoginPage login_page = null;
	ParentLandingPage parent_landing_page = null;
	AdminAddRolePage admin_add_role_page = null;
	HomePage home_page = null;
	AdminDashboardPage adminDashboard_page = null;
	AddNewRolePanel add_new_role_panel = null;
	AdminMenuPermissionPage admin_menu_permission_page = null;
	String projectName = null;
	String username = null;
	String password = null;
	String[] module_name = { "OMS", "CORE ADMIN" };
	AdminAddUserPage admin_add_user_page = null;
	AddUserPanel add_user_panel = null;
	MainDashboardPage main_dashboard_page = null;
	OmsAdminDashboardPage oms_admin_dashboards_page = null;

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
	 * By This Method We Are Creating New Project
	 */
	public void createProject() {
		// First Create a New Project
		projectName = "Testing Pilot Project " + AwtUtilities.genrateRandomAlphaBets(2);
		username = "Test" + AwtUtilities.genrateRandomAlphaBets(3);
		password = "Testing@123";
		AwtUtilities.createNewProject(DriverFactory.iuiDriver().getDriver(), projectName, username, password,
				module_name);
	}

	/**
	 * Description: Perform the verification of Admin Menu Permission Page <br>
	 * TestMethodName: verifyAdminMenuPermission <br>
	 * ManualTestCases: "SU-T659", "SU-T660", "SU-T661", "SU-T662", "SU-T663",
	 * "SU-T664", "SU-T665", "SU-T666", "SU-T667", "SU-T669", "SU-T670", "SU-T671",
	 * "SU-T672", "SU-T674"
	 * 
	 * @author ankit
	 */

	@Version(number = "V-0.1")
	@Test(groups = { "Admin", "Functional" })
	@Description(description = " Perform the verification of Admin Menu Permission Page ")
	@Story(story = "Report Template")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestCaseId(id = { "SU-T659", "SU-T660", "SU-T661", "SU-T662", "SU-T663", "SU-T664", "SU-T665", "SU-T666",
			"SU-T667", "SU-T669", "SU-T670", "SU-T671", "SU-T672", "SU-T674" })
	public void verifyAdminMenuPermission() {
		try {
			// logger instance
			MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
			// Create New Project
			createProject();
			// -> Enter the new created project name and login with newly project
			// credentials
			navigateToLoginPage();
			// Login to the application and navigate to the home page
			home_page = login_page.loginAndNavigateToHomePage(projectName, username, password);

			// -> click Admin button and Navigate To Admin Page
			adminDashboard_page = home_page.navigateToAdminDashboardPage();
			// -> Create A New Role
			String role_name = "Tester" + AwtUtilities.genrateRandomAlphaBets(3);
			createNewRole(role_name);

			// SU-T659-->To verify that "Page Permission" button should be visible under
			// the "settings" menu
			// -> Go To Settings Menus And Select "Page Permission" and navigate to Admin
			// Menu Permission Page
			admin_menu_permission_page = adminDashboard_page.navigateToAdminMenuPermissionPage();
			// Verify "Page Permission" button is visible
			boolean isPagePermissionPageVisible = admin_menu_permission_page.isPagePermissionButtonVisible();
			asert.assertTrue(isPagePermissionPageVisible,
					"To verify that Page Permission button should be visible under the settings menu", " SU-T659");

			// SU-T660-->To verify that after clicking on the "Page Permission" button
			// user should redirect to the "admin-MenuPermission" Page.
			// Check "admin-MenuPermission" page is visible
			String url = DriverFactory.iuiDriver().getDriver().getCurrentUrl();
			asert.assertTrue(url.trim().contains("admin-MenuPermission"),
					"To verify that after clicking on the Page Permission button user should redirect to the admin-MenuPermission Page.",
					"SU-T660");

			// SU-T661-->To verify that fields in the "admin-MenuPermission" page
			// Check "Select Role " drop down is visible
			boolean isSelectRoleDropDownVisible = admin_menu_permission_page.isSelectRoleDropDownVisible();
			asert.assertTrue(isSelectRoleDropDownVisible,
					"To verify that Select Role drop down in the admin-MenuPermission page", "SU-T661");
			// Check "Select Module" drop down is visible
			boolean isSelectModuleDropDownVisible = admin_menu_permission_page.isSelectModuleDropDownVisible();
			asert.assertTrue(isSelectModuleDropDownVisible,
					"To verify that Select Module drop down in the admin-MenuPermission page", "SU-T661");

			// SU-T662-->To verify that Created "Role" should be visible in the "Role"
			// dropdown
			// -> click on role drop down
			admin_menu_permission_page.clickAnyMenuPermissionPageDropDown("role");
			// Check Created Role is visible
			boolean isCreatedRoleVisible = admin_menu_permission_page.isRolePresent(role_name);
			asert.assertTrue(isCreatedRoleVisible,
					"To verify that Created Role should be visible in the Role drop down", "SU-T662");

			// SU-T663-->To Ensure a user can select a "role" from the "Role" drop down.
			// -> Select "Role"
			admin_menu_permission_page.selectRole(role_name);
			// Check "Role" is Selected
			String actual_SelctedRoleName = admin_menu_permission_page.getSelectedRole().trim();
			asert.assertEquals(actual_SelctedRoleName, role_name,
					"To Ensure a user can select a role from the Role drop down.", "SU-T663");

			// SU-T664-->To verify that "Module" drop down contains a list of modules
			// name, according to the selected "project".
			// -> Click On "Module" drop down
			admin_menu_permission_page.clickAnyMenuPermissionPageDropDown("module");
			// Check module names is present or nor
			boolean isModuleNamesPresent = admin_menu_permission_page.isModuleNamePresent(module_name);
			asert.assertTrue(isModuleNamesPresent,
					"To verify that Module drop down contains a list of modules name, according to the selected project.",
					"SU-T664");

			// SU-T665-->Ensure that user can select a module from the Module drop-down.
			// -> Select the "Module Name"
			admin_menu_permission_page.selectModule("OMS");
			// Check "OMS" module is selected
			String actual_SelectedModuleName = admin_menu_permission_page.getSelectedModule().trim();
			asert.assertEquals(actual_SelectedModuleName, "OMS",
					"Ensure that user can select a module from the Module drop-down.", "SU-T665");

			// SU-T666-->To verify the functionality of the "Find" button.
			// -> click on "Find" button
			admin_menu_permission_page.clickOnFindButton();
			// Check the "OMS Dashboard" Main Menus is present
			boolean isMenuIsVisible = admin_menu_permission_page.isMainMenuPresent("OMS Dashboard");
			asert.assertTrue(isMenuIsVisible, "To verify the functionality of the Find button.", "SU-T666");

			// SU-T667-->To verify that according to selected module "Menu items" should
			// be displayed in the "Menu Permission" Panel.
			// Check the "OMS Dashboard" Main Menus is present
			boolean isOMSDashboardMenuIsVisible = admin_menu_permission_page.isMainMenuPresent("OMS Dashboard");
			asert.assertTrue(isOMSDashboardMenuIsVisible,
					"To verify that according to selected module Menu items should be displayed in the Menu Permission Panel.",
					"SU-T667");

			// SU-T669-->To verify that "Save" button present under the "Menu Items".
			// Check "Save" button is visible
			boolean isSaveButtonVisible = admin_menu_permission_page.isSaveButtonVisible();
			asert.assertTrue(isSaveButtonVisible, "To verify that Save button present under the Menu Items.",
					"SU-T669");

			// SU-T670-->To verify that "View Data" column checkboxes are
			// checked/unchecked based on the saved data for the selected role.

			// ->Select "OMS Details Dashboard" "View Data" check box under the OMS
			// Dashboards Main
			// Menu
			admin_menu_permission_page.selectAnyCheckBox("OMS Dashboard", "OMS Details Dashboard", "View Data");
			// ->Click on Save Button
			admin_menu_permission_page.clickOnSaveButton();
			// ->Click on "Role" drop down and select same role
			admin_menu_permission_page.clickAnyMenuPermissionPageDropDown("role");
			admin_menu_permission_page.selectRole(role_name);
			// ->Click on "Module" drop down and select same module
			admin_menu_permission_page.clickAnyMenuPermissionPageDropDown("module");
			admin_menu_permission_page.selectModule("OMS");
			// -> Click on "Find" button
			admin_menu_permission_page.clickOnFindButton();
			// -> Verify "OMS Details Dashboard" "view data" check box is selcted
			boolean isOmsDetailsViewDataCheckBoxSelected = admin_menu_permission_page
					.isSubMenuCheckBoxSelected("OMS Dashboard", "OMS Details Dashboard", "View Data");
			asert.assertTrue(isOmsDetailsViewDataCheckBoxSelected,
					"To verify that View Data column checkboxes are checked/unchecked based on the saved data for the selected role.",
					"SU-T670");

			// SU-T671-->To verify that "Alter Data" column checkboxes are
			// checked/unchecked based on the saved data for the selected role.

			// ->Select "OMS Details Dashboard" "Alter Data" check box under the OMS
			// Dashboards Main
			// Menu
			admin_menu_permission_page.selectAnyCheckBox("OMS Dashboard", "OMS Details Dashboard", "Alter Data");
			// ->Click on Save Button
			admin_menu_permission_page.clickOnSaveButton();
			// ->Click on "Role" drop down and select same role
			admin_menu_permission_page.clickAnyMenuPermissionPageDropDown("role");
			admin_menu_permission_page.selectRole(role_name);
			// ->Click on "Module" drop down and select same module
			admin_menu_permission_page.clickAnyMenuPermissionPageDropDown("module");
			admin_menu_permission_page.selectModule("OMS");
			// -> Click on "Find" button
			admin_menu_permission_page.clickOnFindButton();
			// -> Verify "OMS Details Dashboard" "Alter Data" check box is selcted
			boolean isOmsDetailsAlterDataCheckBoxSelected = admin_menu_permission_page
					.isSubMenuCheckBoxSelected("OMS Dashboard", "OMS Details Dashboard", "Alter Data");
			asert.assertTrue(isOmsDetailsAlterDataCheckBoxSelected,
					"To verify that Alter Data column checkboxes are checked/unchecked based on the saved data for the selected role.",
					"SU-T671");
			// -> Unchecked "OMS Details Dashboard" "Alter Data" check box
			admin_menu_permission_page.deSelectAnyCheckBox("OMS Dashboard", "OMS Details Dashboard", "Alter Data");

			// SU-T672-->To verify that "Delete Data" column check box are
			// checked/unchecked based on the saved data for the selected role.

			// ->Select "OMS Details Dash board" "Delete Data" check box under the OMS
			// Dash boards Main Menu
			admin_menu_permission_page.selectAnyCheckBox("OMS Dashboard", "OMS Details Dashboard", "Delete Data");
			// -> De Select "OMS Details Dash board" "Delete Data" check box under the OMS
			// Dashboard menu
			admin_menu_permission_page.deSelectAnyCheckBox("OMS Dashboard", "OMS Details Dashboard", "Delete Data");
			// ->Click on Save Button
			admin_menu_permission_page.clickOnSaveButton();
			// ->Click on "Role" drop down and select same role
			admin_menu_permission_page.clickAnyMenuPermissionPageDropDown("role");
			admin_menu_permission_page.selectRole(role_name);
			// ->Click on "Module" drop down and select same module
			admin_menu_permission_page.clickAnyMenuPermissionPageDropDown("module");
			admin_menu_permission_page.selectModule("OMS");
			// -> Click on "Find" button
			admin_menu_permission_page.clickOnFindButton();
			// -> Verify "OMS Details Dashboard" "Delete Data" check box is selcted
			boolean isOmsDetailsDelteDataCheckBoxSelected = admin_menu_permission_page
					.isSubMenuCheckBoxSelected("OMS Dashboard", "OMS Details Dashboard", "Delete Data");
			asert.assertFalse(isOmsDetailsDelteDataCheckBoxSelected,
					"To verify that Delete Data column checkboxes are checked/unchecked based on the saved data for the selected role.",
					"SU-T672");

			// SU-T674-->To verify the "RoleBased" Menu Access Control

			// -> Click on "User" menu and click on "Create User" Button
			admin_add_user_page = adminDashboard_page.navigateToAdminAddUserPage();
			add_user_panel = admin_add_user_page.clickOnNewButtonAndNavigateToAddUserPanel();
			// -> Enter User Name
			String username = "Tester" + AwtUtilities.genrateRandomAlphaBets(5);
			add_user_panel.enterUserName(username);
			// -> Enter Email
			String email = "Testing" + AwtUtilities.genrateRandomAlphaBets(2) + "@gmail.com";
			add_user_panel.enterEmail(email);
			// -> Enter Password
			String password = AwtUtilities.genrateRandomAlphaBets(3).toUpperCase()
					+ AwtUtilities.genrateRandomAlphaBets(2).toLowerCase() + "@"
					+ AwtUtilities.genrateRandomAlphaNeumric(1) + AwtUtilities.genrateRandomNumber(3);
			add_user_panel.enterPassword(password);
			// -> Select Role
			add_user_panel.selectRole(role_name);
			// -> Enter First Name
			String first_name = "AutomationTester " + AwtUtilities.genrateRandomAlphaBets(4);
			add_user_panel.enterFirstName(first_name);
			// -> Click on "Create" button
			add_user_panel.clickOnCreateButton();
			// -> Close "Add User" Panel
			add_user_panel.clickOnCancelButton();
			// -> Click On Profile Icon and Log Out From application
			adminDashboard_page.clickOnLogoutButton();
			// Select the main project name
			parent_landing_page.selectProject(main_porject_name);
			// -> Again Enter Same Project Name
			login_page.enterProjectName(projectName);
			// -> Enter Created user name
			login_page.enterUsername(username);
			// -> Enter Password
			login_page.enterPassword(password);
			// -> Click On Login Button
			login_page.clicOnLoginButton();
			// ->Select "OMS" Menu
			OmsAdminDashboardPage oms_admin_dashboards_page = home_page.navigateToOmsAdminDashboardPage();
			// Check under the OMS Dashborad Menu ,OMS Details Dasboard option is Present Or
			// Not
			boolean isOMSDetailsDashbordIsVisible = oms_admin_dashboards_page.isOptionIsVisible("OMS Dashboard",
					"OMS Details Dashboard");
			asert.assertTrue(isOMSDetailsDashbordIsVisible, "To verify the RoleBased Menu Access Control", "SU-T674");
		} finally {
			// Delete the created project
			AwtUtilities.deleteTheProject(DriverFactory.iuiDriver().getDriver(), projectName);
		}
		// Asset all
		asert.assertAll();

	}

	/**
	 * Help Of This Method We Can Create a Role
	 * 
	 * @param roleName
	 */
	public void createNewRole(String roleName) {
		// -> Select "User" menu and click on Create Role Option
		admin_add_role_page = adminDashboard_page.navigateToAdminAddRolePage();
		// -> Click On "New" Button and navigate to Add New Role Panel
		add_new_role_panel = admin_add_role_page.clickOnNewButtonAndNavigateToAddNewRolePanel();
		add_new_role_panel.enterRoleName(roleName);
		// -> Enter Role Description
		String role_Description = "For Testing Purpose Only";
		add_new_role_panel.enterRoleDescription(role_Description);
		// -> click on create button
		add_new_role_panel.clickOnCreateButton();
		// Close The Panel
		add_new_role_panel.cancelAddNewRolePanel();

	}
}
