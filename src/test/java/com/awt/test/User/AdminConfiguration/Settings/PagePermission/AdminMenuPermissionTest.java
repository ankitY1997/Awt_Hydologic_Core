package com.awt.test.User.AdminConfiguration.Settings.PagePermission;

import org.testng.annotations.Test;

import com.awt.page.Login.LoginPage;
import com.awt.page.User.ParentLandingPage;
import com.awt.page.User.AdminConfiguration.AdminPage;
import com.awt.page.User.AdminConfiguration.Settings.Page_Permission.AdminMenuPermissionPage;
import com.awt.page.User.AdminConfiguration.User.CreateRole.AddNewRolePanel;
import com.awt.page.User.AdminConfiguration.User.CreateRole.AdminAddRolePage;
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
	public static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
	public static final String admin_project = "Admin";
	SoftAssertTest asert = null;
	LoginPage lp = null;
	ParentLandingPage parent_landing_page = null;
	AdminAddRolePage admin_add_role_page = null;
	AdminPage admin_page = null;
	AddNewRolePanel add_new_role_panel = null;
	AdminMenuPermissionPage admin_menu_permission_page = null;
	String projectName = null;
	String username = null;
	String password = null;
	String[] module_name = { "OMS", "Pump House" };

	/**
	 * 
	 * Create A New project and log in with new project name along with it's created
	 * credentials and navigate to parent landing page
	 * 
	 */
	public void navigateToParentLandingPage() {
		// SoftAssert instance
		asert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// log in Page instance
		lp = new LoginPage(DriverFactory.iuiDriver().getDriver());
		// log in with user url and enter created project name
		parent_landing_page = lp.loginAndNavigateToTheParentLandingPage(url, projectName, username, password);
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
	@Description(description = " Perform the verification of Admin Menu Permission Page ")
	@Story(story = "Report Template")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestCaseId(id = { "APMS-T159", "APMS-T160", "APMS-T161", "APMS-T162", "APMS-T163", "APMS-T164", "APMS-T165",
			"APMS-T166", "APMS-T167", "APMS-T168", "APMS-T169", "APMS-T170", "APMS-T171", "APMS-172", "APMS-T173",
			"APMS-T174", "APMS-T175", "APMS-T176", "APMS-T177", "APMS-T178", "APMS-T226", "APMS-T227", "APMS-T179",
			"APMS-T180", "APMS-T182", "APMS-T184", "APMS-T185", "APMS-T186", "APMS-T187", "APMS-T188", "APMS-T189",
			"APMS-T190" })
	public void verifyAdminMenuPermission() {
		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// Create New Project
		createProject();
		// -> Enter the new created project name and login with newly project
		// credentials
		navigateToParentLandingPage();
		// -> click Admin button and Navigate To Admin Page
		admin_page = (AdminPage) parent_landing_page.goToProjectPage(admin_project);
		// -> Create A New Role
		String role_name = "Tester" + AwtUtilities.genrateRandomAlphaBets(3);
		createNewRole(role_name);

		// APMS-T108-->To verify that "Page Permission" button should be visible under
		// the "settings" menu

		// -> Go To Settings Menus And Select "Page Permission" and navigate to Admin
		// Menu Permission Page
		admin_menu_permission_page = admin_page.navigateToAdminMenuPermissionPage();
		// Verify "Page Permission" button is visible
		boolean isPagePermissionPageVisible = admin_menu_permission_page.isPagePermissionButtonVisible();
		asert.assertTrue(isPagePermissionPageVisible,
				"To verify that Page Permission button should be visible under the settings menu", " APMS-T108");

		// SU-T109-->To verify that after clicking on the "Page Permission" button user
		// should redirect to the "admin-MenuPermission" Page.
		// Check "admin-MenuPermission" page is visible
		String url = DriverFactory.iuiDriver().getDriver().getCurrentUrl();
		asert.assertTrue(url.trim().contains("admin-MenuPermission"),
				"To verify that after clicking on the Page Permission button user should redirect to the admin-MenuPermission Page.",
				"SU-T109");

	}

	/**
	 * Help Of This Method We Can Create Role Name
	 * 
	 * @param roleName
	 */
	public void createNewRole(String roleName) {
		// -> Select "User" menu and click on Create Role Option
		admin_add_role_page = admin_page.navigateToAdminAddRolePage();
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
