package com.awt.test.User.AdminConfiguration.User.CreateRole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.awt.page.Login.LoginPage;
import com.awt.page.User.ParentLandingPage;
import com.awt.page.User.AdminConfiguration.AdminPage;
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

public class AdminAddRoleTest extends BaseTest {

	// Instance Variable ///
	public static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
	public static final String admin_project = "Admin";
	SoftAssertTest asert = null;
	LoginPage lp = null;
	ParentLandingPage parent_landing_page = null;
	AdminPage admin_page = null;
	AdminAddRolePage admin_add_role_page = null;
	AddNewRolePanel admin_role_panel = null;
	String[] add_new_role_panel_fields = { "Role Name:", "Role Description:" };

	/**
	 * 
	 * Navigate To Add New Role Panel Details Panel
	 * 
	 */
	public void navigateToParentLandingPage() {
		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// SoftAssert instance
		asert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// log in Page instance
		lp = new LoginPage(DriverFactory.iuiDriver().getDriver());
		parent_landing_page = lp.loginAndNavigateToTheParentLandingPage(url, "NKMP1",
				PropertiesOperations.getPropertyValueByKey("SUPERADMIN_USERNAME"),
				PropertiesOperations.getPropertyValueByKey("SUPERADMIN_PASSWORD"));
	}

	/**
	 * Description: Perform the verification on new Project Details Panels
	 * Fields<br>
	 * TestMethodName: verify_NewProjectDetailsPanel <br>
	 * ManualTestCases: "APMS-T1", "APMS-T2", "APMS-T4", "APMS-T6", "APMS-T7",
	 * "APMS-T8", "APMS-T9", "APMS-T10", "APMS-T13", "APMS-T14", "APMS-T19",
	 * "APMS-T28",
	 * "APMS-T29","APMS-30","APMS-31","APMS-T32","APMS-T33","APMS-T34","APMS-T35","APMS-T37","APMS-T38","APMS-T39","APMS-T45","APMS-46","APMS-T47",APMS-T48",
	 * "APMS-T50"<br>
	 * 
	 * @author ankit
	 */

	@Version(number = "V-0.1")
	@Test(groups = { "Admin", "Functional" })
	@Description(description = "Perform the verfication on  New Project Details Panel")
	@Story(story = "Create Project Details Panel")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestCaseId(id = { "APMS-T87", "APMS-T2", "APMS-T4", "APMS-T6", "APMS-T7", "APMS-T8", "APMS-T9", "APMS-T10",
			"APMS-T13", "APMS-T14", "APMS-T19", "APMS-T28", "APMS-T29", "APMS-30", "APMS-31", "APMS-T32", "APMS-T33",
			"APMS-T34", "APMS-T35", "APMS-T37", "APMS-T38", "APMS-T39", "APMS-T45", "APMS-46", "APMS-T47", "APMS-T48",
			"APMS-T50" })
	public void verifyAdminAddRolePage() {
		// Navigate To New 
		navigateToParentLandingPage();
		// click Admin project and Navigate To Admin Page
		admin_page = (AdminPage) parent_landing_page.goToProjectPage(admin_project);
		// Then -->Click On User Drop-Down And Select The Create Role
		admin_add_role_page = admin_page.navigateToAdminAddRolePage();
		// APMS-T87-->To verify that "New" button should present in the "admin-addrole"
		// page.
		// verify new button should be visible
		asert.assertTrue(admin_add_role_page.isNewButtonIsVisible(),
				"To verify that New button should present in the admin-addrole page.", "APMS-T87");
		// Verify Add New Role Panel Text Fields And Functionality
		verifyAddNewRolePanel();
		asert.assertAll();
	}

	public void verifyAddNewRolePanel() {
		// APMS-T88--> To verify that clicking on the "New" button redirects to the "Add
		// New Role" Panel
		// click and navigate to Add New Role Panel
		admin_role_panel = admin_add_role_page.clickOnNewButtonAndNavigateToAddNewRolePanel();
		// validate Admin Role Panel Should be Visible
		asert.assertEquals(admin_role_panel.getNameOfThePanel(), "ADD NEW ROLE",
				"To verify that clicking on the New button redirects to the Add New Role Panel", "APMS-T88");

		// APMS-T89-->To verify that fields in the "Add New Role" Panel
		// Expected Add New Role Panel Text Fields Panel Name
		List<String> expected_fields_name = new ArrayList<String>(Arrays.asList(add_new_role_panel_fields));
		// actual new role panel fields name
		List<String> actual_fields_name = admin_role_panel.getPanelTextFieldsName();
		asert.assertEquals(actual_fields_name, expected_fields_name, "To verify that fields in the  Add New Role Panel",
				"APMS-T89");

		// APMS-T90-->To verify that "Role name" text field should accepts only the
		// alphabets
		// Enter the Alphabets In Role Name Text field
		String entered_alphabetes = AwtUtilities.genrateRandomAlphaBets(6);
		admin_role_panel.enterRoleName(entered_alphabetes);
		// Verify is it Accepting Alphabetes
		String actual_Role_Name_value = admin_role_panel.getAddNewRolePanelFieldsValue("Role Name");
		// validate Expected and Actual RoleName Value Should be match
		asert.assertEquals(actual_Role_Name_value, entered_alphabetes,
				"To verify that Role name text field should accepts only the alphabets", "APMS-T90");
		// Enter combination of numeric and alphabetes
		String alpha_numeric = AwtUtilities.genrateRandomAlphaNeumric(6);
		admin_role_panel.enterRoleName(alpha_numeric);
		// take actual role name text field value
		actual_Role_Name_value = admin_role_panel.getAddNewRolePanelFieldsValue("Role Name");
		// validate Expected and Actual RoleName Value Should not be match
		asert.assertNotEquals(actual_Role_Name_value, alpha_numeric,
				"To verify that Role name text field should accepts only the alphabets", "APMS-T90");

		// APMS-91-->To verify that "Role name" text field should accepts minimum 4
		// characters
		// Enter less then 4 Character
		String invaild_role_name = AwtUtilities.genrateRandomAlphaBets(3);
		admin_role_panel.enterRoleName(invaild_role_name);
		// click on create button
		admin_role_panel.clickOnCreateButton();
		// Expected Error Message
		String expected_error_message = "Role Name must be 4-16 alphabetic characters.";
		// Actual Error Message
		String actual_error_message = admin_role_panel.getAddNewRolePanelErrorMessage("Role Name");
		// Error Message Should Be Visible
		asert.assertEquals(actual_error_message, expected_error_message,
				"To verify that Role name text field should accepts minimum 4", "APMS-T91");
		// Now Enter Valid Role More Then 4 Character
		String vaild_role_name = AwtUtilities.genrateRandomAlphaBets(4);
		admin_role_panel.enterRoleName(vaild_role_name);
		// click on create button
		admin_role_panel.clickOnCreateButton();
		// Actual Error Message
		actual_error_message = admin_role_panel.getAddNewRolePanelErrorMessage("Role Name");
		// Error Message Should Not Be Visible
		asert.assertNotEquals(actual_error_message, expected_error_message,
				"To verify that Role name text field should accepts minimum 4", "APMS-T91");

		// APMS-92-->To verify that "Role name" text field should not exceeds more than
		// 16 characters
		// Enter More Than 16 Character
		invaild_role_name = AwtUtilities.genrateRandomAlphaBets(17);
		admin_role_panel.enterRoleName(invaild_role_name);
		// Verify is it Accepting more then 16 Alphabets
		actual_Role_Name_value = admin_role_panel.getAddNewRolePanelFieldsValue("Role Name");
		// Role Name Expected Value Should Not Be Equal To Role Name Actual Value
		asert.assertNotEquals(actual_Role_Name_value, invaild_role_name,
				"To verify that Role name text field should not exceeds more than 16 characters", "APMS-T92");

		// Enter  16 Character
		vaild_role_name = AwtUtilities.genrateRandomAlphaBets(16);
		admin_role_panel.enterRoleName(vaild_role_name);
		// Verify it should be accept less then or equal 16 Alphabets
		actual_Role_Name_value = admin_role_panel.getAddNewRolePanelFieldsValue("Role Name");
		// Actual Role Name Should be Equal To Valid Role Name
		asert.assertEquals(actual_Role_Name_value, vaild_role_name,
				"To verify that Role name text field should not exceeds more than 16 characters", "APMS-T92");

	}
}
