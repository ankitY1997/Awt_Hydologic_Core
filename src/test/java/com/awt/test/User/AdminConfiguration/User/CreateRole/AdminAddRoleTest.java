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
	String[] add_new_role_panel_fields = { "Role Name*", "Role Description" };
	String vaild_role_name = null;

	/**
	 * 
	 * Navigate To Add New Role Panel Details Panel
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
	 * Description: Perform the verification of AdminAddRole Page <br>
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
	@Description(description = "Perform the verfication on  New Project Details Panel")
	@Story(story = "Create Role ")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestCaseId(id = { "APMS-T87", "APMS-T88", "APMS-T89", "APMS-T90", "APMS-T91", "APMS-T92", "APMS-T93", "APMS-T94",
			"APMS-T95", "APMS-T96", "APMS-T97", "APMS-T98", "APMS-T99", "APMS-T100", "APMS-T101", "APMS-T102",
			"APMS-T103", "APMS-T104" })
	public void verifyAdminAddRolePage() {
		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
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
		// Verify Role Details Table
		verifyRoleDetailsTable();

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
		String alpha_numeric = AwtUtilities.genrateRandomAlphaNeumric(6) + 21;
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
				"To verify that Role name text field should not accepts less than 4 character", "APMS-T91");
		// Now Enter Valid Role More Then 4 Character
		vaild_role_name = AwtUtilities.genrateRandomAlphaBets(4);
		admin_role_panel.enterRoleName(vaild_role_name);
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

		// Enter 16 Character
		vaild_role_name = AwtUtilities.genrateRandomAlphaBets(16);
		admin_role_panel.enterRoleName(vaild_role_name);
		// Verify it should be accept less then or equal 16 Alphabets
		actual_Role_Name_value = admin_role_panel.getAddNewRolePanelFieldsValue("Role Name");
		// Actual Role Name Should be Equal To Valid Role Name
		asert.assertEquals(actual_Role_Name_value, vaild_role_name,
				"To verify that Role name text field should exceeds  16 characters", "APMS-T92");

		// APMS-93-->To verify that "Role Description" text field should accepts
		// characters.
		// Enter the character
		String role_Desc_Text = AwtUtilities.genrateRandomAlphaNeumric(4);
		admin_role_panel.enterRoleDescription(role_Desc_Text);
		// Get Actual Value Form "Role Description Text Field
		String actual_role_desc_text_value = admin_role_panel.getAddNewRolePanelFieldsValue("Role Descriptions");
		// verify it should accept character
		asert.assertEquals(actual_role_desc_text_value, role_Desc_Text,
				"To verify that Role Description text field should accepts characters.", "APMS-T93");

		// APMS-T94-->To verify that "Create" button should be visible in the "Add New
		// Role" panel.
		// Check Create Button Should Be Visible Or Not
		boolean isCreateButtonVisible = admin_role_panel.isCreateButtonIsVisible();
		asert.assertTrue(isCreateButtonVisible,
				"To verify that Create button should be visible in the Add New Role panel.", "APMS-T94");

		// APMS-T95-->To verify that created "Role" should be visible in the "Role
		// Details" table
		// enter valid Role Name
		admin_role_panel.enterRoleName(vaild_role_name);
		// enter role description
		admin_role_panel.enterRoleDescription(role_Desc_Text);
		// click on create button
		admin_role_panel.clickOnCreateButton();
		// click on cancel the panel
		admin_role_panel.cancelAddNewRolePanel();
		// check The Table and Find Out This Value
		String actual_role_name = admin_add_role_page.getRoleDetailTableValue("Role Name", vaild_role_name);
		// Actual Role Name and Created Role Name Should be equal
		asert.assertEquals(vaild_role_name, actual_role_name,
				"To verify that created Role should be visible in the Role Details table", "APMS-T95");

		// APMS-T96-->To verify that User should not able to create a duplicate "role".
		// Again CLick On "New Button"
		admin_add_role_page.clickOnNewButtonAndNavigateToAddNewRolePanel();
		// Enter Created Role Name
		admin_role_panel.enterRoleName(vaild_role_name);
		// Click On Create Button
		admin_role_panel.clickOnCreateButton();
		// Error message "Role name already exists " should be thrown
		asert.assertEquals(admin_role_panel.getDuplicateErrorMessage(), "Role name already exists",
				"To verify that User should not able to create a duplicate role.", "APMS-T96");

		// APMS-T97--> To verify that "cancel" button should be present in the "Add New
		// Role" panel.
		// Check Cancel Button Is Visible
		boolean isCancelButtonVisible = admin_role_panel.isCancelButtonIsVisible();
		asert.assertTrue(isCancelButtonVisible,
				" To verify that cancel button should be present in the Add New Role Panel.", "APMS-T97");
		// click on cancel button
		admin_role_panel.cancelAddNewRolePanel();

	}

	public void verifyRoleDetailsTable() {
		// APMS-T98-->To verify that "Role Details" table contains the "SNo, Role Name,
		// Role Description and Action" column
		// Expected Role Details Table Columns
		String[] expected_columns = { "SNO", "Role Name", "Role Description", "Action" };
		// Take The Actual Role Details Table Columns
		List<String> actual_columns = admin_add_role_page.listOfRoleDetailsTableColumns();
		asert.assertEquals(actual_columns, new ArrayList(Arrays.asList(expected_columns)),
				"To verify that Role Details table contains the SNo, Role Name, Role Description and Action column",
				"APMS-T98");

		// APMS-T99-->To verify that "edit" and "delete" button should be present under
		// the Action" column .
		// Check Edit Button Is Visible
		boolean isEditButtonPresent = admin_add_role_page.isEditButtonIsVisible();
		asert.assertTrue(isEditButtonPresent, "To Verify Edit Button should be present under the Action Column",
				"APMS-T99");
		// check delete button is visible
		boolean isDeleteButtonPresent = admin_add_role_page.isEditButtonIsVisible();
		asert.assertTrue(isDeleteButtonPresent, "To Verify Delete Button should be present under the Action Column",
				"APMS-T99");

		// APMS-T100-->To verify that functionality of the "edit" button .
		// Click On Edit Button
		admin_add_role_page.clickOnEditButton(vaild_role_name);
		// Edit Role Description
		String role_desc = AwtUtilities.genrateRandomAlphaBets(6);
		admin_role_panel.enterRoleDescription(role_desc);
		// Click On Update Button
		admin_add_role_page.clickOnUpdateButton();
		// click on cancel panel button
		admin_role_panel.cancelAddNewRolePanel();
		// Then Check Its Update
		String actual_role_desc_value = admin_add_role_page.getRoleDetailTableValue("Role Description",
				vaild_role_name);
		asert.assertEquals(actual_role_desc_value, role_desc, "To verify that functionality of the edit button .",
				"APMS-T100");

		// APMS-T101-->To verify that functionality of the "delete" button .
		// delete create project
		admin_add_role_page.clickOnDeleteButton(vaild_role_name);
		// Check Deleted Role Name Should Not Be Visible Role Details Table
		asert.assertNotEquals(vaild_role_name,
				admin_add_role_page.getRoleDetailTableValue("Role Name", vaild_role_name),
				"To verify that functionality of the  delete button .", "APMS-T101");

		// APMS-T102-->To verify that "Rows per page" drop down button should be visible
		// under the "Role Details" table.
		// -->Check "Rows Per Page Drop Down" button is visible
		boolean isRowsPerPageButton = admin_add_role_page.isRowsPerPageDropDownIsVisible();
		asert.assertTrue(isRowsPerPageButton,
				"To verify that Rows per page drop down button should be visible under the  Role Details table.",
				"APMS-T102");

		// APMS-T103-->To verify that changing the numbers of "rows per page" drop down
		// , updates the table accordingly
		// Enter Number Of Rows Per Page and Check is Table Is Update
		boolean isTableUpdated = admin_add_role_page.isUpdateTheTable("10");
		asert.assertTrue(isTableUpdated,
				"To verify that changing the numbers of rows per page drop down , updates the table accordingly",
				"APMS-T103");

		// APMS-T104-->To verify that "first, next, previous and last" pagination button
		// should be visible under the "Role Details" table.
		// Check Fist pagination button is visible
		boolean isFirsPaginationButtonVisible = admin_add_role_page.isFirstPaginationButtonIsVisible();
		asert.assertTrue(isFirsPaginationButtonVisible, "To veify First Pagination Button Should Be Visible",
				"APMS-T104");
		// check next pagination button is visible
		boolean isNextPaginationButtonVisible = admin_add_role_page.isNextPaginationButtonIsVisible();
		asert.assertTrue(isNextPaginationButtonVisible, "To veify Next Pagination Button Should Be Visible",
				"APMS-T104");
		// check previous pagination button is visible
		boolean isPreviousPaginationButtonVisible = admin_add_role_page.isPreviousPaginationButtonIsVisible();
		asert.assertTrue(isPreviousPaginationButtonVisible, "To veify Previous Pagination Button Should Be Visible",
				"APMS-T104");
		// check last pagination button is visible
		boolean isLastPaginationButtonVisible = admin_add_role_page.isLastPaginationButtonIsVisible();
		asert.assertTrue(isLastPaginationButtonVisible, "To veify Last Pagination Button Should Be Visible",
				"APMS-T104");

	}

	public void systemTestCase() {

		// APMS-T126--> To Ensure that a user can successfully create a role and view
		// the
		// details of the created role.
		// --> click on new button
		admin_add_role_page.clickOnNewButtonAndNavigateToAddNewRolePanel();
		// --> Enter Role Name
		String roleName = AwtUtilities.genrateRandomAlphaBets(5);
		admin_role_panel.enterRoleName(vaild_role_name);
		// -->click on create button
		admin_role_panel.clickOnCreateButton();
		// --> click on cross button to cancel the panel
		admin_role_panel.cancelAddNewRolePanel();
		// -->Validate Created Role Name Should be visible
		String value = admin_add_role_page.getRoleDetailTableValue("Role Name", roleName);
		asert.assertEquals(value, roleName, "Verify Created Role Name Should Be visible In The Role Details Table",
				"APMS-T126");
		// Then Click On User Drop -Down button And Navigate TO Admin User Page
		admin_add_role_page.navigateToAdminAddUserPage();

	}
}
