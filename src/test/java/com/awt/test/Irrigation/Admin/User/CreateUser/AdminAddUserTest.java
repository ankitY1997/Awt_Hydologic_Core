package com.awt.test.Irrigation.Admin.User.CreateUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.awt.page.ParentLandingPage;
import com.awt.page.Irrigation.Admin.AdminDashboardPage;
import com.awt.page.Irrigation.Admin.User.CreateUser.AddUserPanel;
import com.awt.page.Irrigation.Admin.User.CreateUser.AdminAddUserPage;
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

public class AdminAddUserTest extends BaseTest {

	// Instance Variable ///
	private static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
	private static final String project_name = PropertiesOperations.getPropertyValueByKey("Project_Name");
	private static final String main_porject_name = PropertiesOperations.getPropertyValueByKey("Main_Project_Name");
	public static final String admin_project = "Admin";
	SoftAssertTest asert = null;
	ParentLandingPage parent_landing_page = null;
	LoginPage login_page = null;
	HomePage home_page = null;
	AdminDashboardPage admin_dashboard_page = null;
	AdminAddUserPage admin_add_user_page = null;
	AddUserPanel add_user_panel = null;
	String expected_user_name = null;

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
	 * Description: Perform the verification of AdminAddRole Page <br>
	 * TestMethodName: verifyAdminAddRolePage <br>
	 * ManualTestCases: "SU-T577", "SU-T578", "SU-T579", "SU-T580", "SU-T581",
	 * "SU-T582", "SU-T583", "SU-T584", "SU-T586", "SU-T587", "SU-T588", "SU-T589",
	 * "SU-T590", "APMS-T79", "SU-T593", "SU-T594", "SU-T595"<br>
	 * 
	 * @author ankit
	 */

	@Version(number = "V-0.1")
	@Test(groups = { "Admin", "Functional" })
	@Description(description = "Perform the verfication on amin_add_user_page")
	@Story(story = "Create User")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestCaseId(id = { "SU-T577", "SU-T578", "SU-T579", "SU-T580", "SU-T581", "SU-T582", "SU-T583", "SU-T584",
			"SU-T586", "SU-T587", "SU-T588", "SU-T589", "SU-T590", "APMS-T79", "SU-T593", "SU-T594", "SU-T595" })
	public void verifyAdminAddUserPage() {

		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// Navigate To Login Page
		navigateToLoginPage();
		// ->Log in to the application and navigate to home page
		home_page = login_page.loginAndNavigateToHomePage(project_name,
				PropertiesOperations.getPropertyValueByKey("User_USERNAME"),
				PropertiesOperations.getPropertyValueByKey("User_PASSWORD"));
		// -> Click on profile icon and select the Admin Button
		// -> Navigate to the admin dashboard page
		admin_dashboard_page = home_page.navigateToAdminDashboardPage();
		// Then -->Click On User Drop-Down And Select The Create Role
		admin_add_user_page = admin_dashboard_page.navigateToAdminAddUserPage();
		// SU-T577-->To verify that "New" button should be present in the
		// "admin-adduser" page.
		boolean isVisible = admin_add_user_page.isNewButtonIsVisible();
		asert.assertTrue(isVisible, "To verify that New button should be present in the admin-adduser page.",
				"SU-T577");
		// To Verify Add User Panel
		verifyAddUserPanel();
		// To verify User Details Table
		verifyUserDetailsTable();

		asert.assertAll();

	}

	/**
	 * In this method we are validating the add user panel
	 * 
	 */
	public void verifyAddUserPanel() {

		// SU-T578-->To verify that clicking on the "New" button redirects to the "Add
		// Users" Panel.
		// click on "New" button and navigate to add user panel
		add_user_panel = admin_add_user_page.clickOnNewButtonAndNavigateToAddUserPanel();
		// Check the "Add User Panel Is Visible or not
		asert.assertEquals(add_user_panel.getPanelName(), "ADD USERS",
				"To verify that clicking on the New button redirects to the Add Users Panel", "SU-T578");

		// SU-T579-->To verify that fields in the "Add Users" panel
		// Expected Fields
		String[] add_user_fields = { "Username*", "Email *", "Password *", "Role *", "First Name *", "Last Name" };
		// actual fields name
		List<String> actual_fields = add_user_panel.listOfAddUserPanelFields();
		// Expected fields name should be equal to actual fields name
		asert.assertEquals(actual_fields, new ArrayList<String>(Arrays.asList(add_user_fields)),
				"To verify that fields in the Add Users panel", "SU-T579");

		// SU-T580-->To verify that "username" text field should accept only alphabets
		// Enter the Alphabets
		String valid_username = AwtUtilities.genrateRandomAlphaBets(5);
		add_user_panel.enterUserName(valid_username);
		// get the user name
		String actual_value = add_user_panel.getUserNameFieldValue().trim();
		// Both Value SHould be Equal
		asert.assertEquals(actual_value, valid_username,
				"To verify that username text field should accept only alphabets", "SU-T580");

		// Then Enter In Valid User Name
		String invalid_username = AwtUtilities.genrateRandomAlphaBets(5) + 12;
		add_user_panel.enterUserName(invalid_username);
		// get the acutal user name text value
		actual_value = add_user_panel.getUserNameFieldValue().trim();
		// both value should not be equal
		asert.assertNotEquals(actual_value, valid_username,
				"To verify that username text field should Not accept only alpha Neumeric Value", "SU-T580");

		// SU-T581-->To verify that "username" text field should not exceed more than
		// 16 alphabets character
		invalid_username = AwtUtilities.genrateRandomAlphaBets(17);
		add_user_panel.enterUserName(invalid_username);
		// get the acutal user name text value
		actual_value = add_user_panel.getUserNameFieldValue().trim();
		// both value should not be equal
		asert.assertNotEquals(actual_fields, valid_username,
				"To verify that username text field should not exceed more than 16 alphabets character", "SU-T581");

		// SU-T582-->To verify that "username" text field should not accept any special
		// characters and numbers.
		invalid_username = AwtUtilities.genrateRandomAlphaBets(7) + "$@";
		add_user_panel.enterUserName(invalid_username);
		// get the acutal user name text value
		actual_value = add_user_panel.getUserNameFieldValue().trim();
		// both value should not be equal
		asert.assertNotEquals(actual_value, valid_username,
				"To verify that username text field should not accept any special characters and numbers.", "SU-T582");

		// SU-T583-->To verify that password with 8 to 15 characters is accepted in the
		// "password" text field
		String valid_password = AwtUtilities.genrateRandomAlphaBets(3).toUpperCase()
				+ AwtUtilities.genrateRandomAlphaBets(3).toLowerCase() + "@" + "12";
		String valid_email = AwtUtilities.genrateRandomAlphaBets(5) + "@gmail.com";
		String role = "SuperAdmin";
		String valid_first_name = AwtUtilities.genrateRandomAlphaBets(6);
		String valid_last_name = AwtUtilities.genrateRandomAlphaBets(7);
		// enter all details
		add_user_panel.enterMandatoryFields(valid_username, valid_password, valid_email, role);
		// click on create button
		add_user_panel.clickOnCreateButton();
		// Error Message Should Not be Visible
		String actual_error_message = add_user_panel.getErroMessage("Password *");
		asert.assertNotEquals(actual_error_message,
				"Password must be at least 8 characters long, include one uppercase letter, and one special character.",
				"To verify that password with 8 to 15 characters is accepted in the password text field", "SU-T583");

		// SU-T584-->To verify that less than 8 characters should not be accepted in
		// the "password" text field
		String invalid_Password = AwtUtilities.genrateRandomAlphaBets(5) + "@1";
		// Enter Mandatory fields
		// enter all details
		add_user_panel.enterMandatoryFields(valid_username, invalid_Password, valid_email, role, valid_first_name);
		// click on create button
		add_user_panel.clickOnCreateButton();
		// Error Message Should be Visible
		actual_error_message = add_user_panel.getErroMessage("Password *");
		asert.assertEquals(actual_error_message,
				"Password must be at least 8 characters long, include one uppercase letter, and one special character.",
				"To verify that less than 8 characters should not be accepted in the password text field", "SU-T584");

		// SU-T586-->To verify that "password" should contains at least one upper
		// case, lower case, alphanumeric of the length of 8 characters
		// enter all details
		add_user_panel.enterMandatoryFields(valid_username, valid_password, valid_email, role);
		// click on create button
		add_user_panel.clickOnCreateButton();
		// Error Message Should Not be Visible
		actual_error_message = add_user_panel.getErroMessage("Password *");
		asert.assertNotEquals(actual_error_message,
				"Password must be at least 8 characters long, include one uppercase letter, and one special character.",
				"To verify that password should contains at least one upper case, lower case, alphanumeric of the length of 8 characters",
				"SU-T586");

		// SU-T587-->To verify that email id's text field with valid format are
		// accepted
		// Enter Valid Email Format and fill all details
		add_user_panel.enterMandatoryFields(valid_username, valid_password, valid_email, role);
		// click on create button
		add_user_panel.clickOnCreateButton();
		// Error Message Should Not be Visible
		actual_error_message = add_user_panel.getErroMessage("Email *");
		asert.assertNotEquals(actual_error_message, "Please enter a valid email address.",
				"To verify that email id's text field with valid format are Accepted", "SU-T587");

		// SU-T588-->To verify that email id's text field with invalid format are not
		// accepted
		// Enter Invalid Email Format
		String invalid_email_format = AwtUtilities.genrateRandomAlphaBets(5);
		// Enter invalid Email Format and fill all details
		add_user_panel.enterMandatoryFields(valid_username, valid_password, invalid_email_format, role,
				valid_first_name);
		// click on create button
		add_user_panel.clickOnCreateButton();
		// Error Message Should be Visible
		actual_error_message = add_user_panel.getErroMessage("Email *");
		asert.assertEquals(actual_error_message, "Please enter a valid email address.",
				"To verify that email id's text field should not accept invalid email format", "SU-T588");

		// SU-T589-->To verify that user can not be add a user with out selecting a
		// role .
		// click on cancel panel
		add_user_panel.clickOnCancelButton();
		// Click On New button
		admin_add_user_page.clickOnNewButtonAndNavigateToAddUserPanel();
		// Enter All Details
		add_user_panel.enterUserName(valid_username);
		add_user_panel.enterPassword(valid_password);
		add_user_panel.enterEmail(valid_email);
		add_user_panel.enterFirstName(valid_first_name);
		add_user_panel.enterLastName(valid_last_name);
		// click on create button
		add_user_panel.clickOnCreateButton();
		// Error Message Should be Visible
		actual_error_message = add_user_panel.getErroMessage("Role *");
		asert.assertEquals(actual_error_message, "Role must be selected.",
				"To verify that user can not be add a user with out selecting a role .", "SU-T589");

		// SU-T590-->To verify that user should be able to select the role in the "Role"
		// drop down.
		// select role name
		String expected_selected_role = "SuperAdmin";
		add_user_panel.selectRole(expected_selected_role);
		// to get actual role name
		String actual_role_name = add_user_panel.getSelectedRoleName();
		// selected role name should be equal to actual selected role name
		asert.assertEquals(actual_role_name, expected_selected_role,
				"To verify that user should be able to select the role in the Role drop down.", "SU-T590");

		// SU-T591-->To verify that "First Name" text field should only the alphabets
		// Enter Alphabets only
		add_user_panel.enterFirstName(valid_first_name);
		// Get Actual First Name Value
		String acutal_first_name_txt_value = add_user_panel.getFirstTextFieldValue().trim();
		// both value should be equal
		asert.assertEquals(acutal_first_name_txt_value, valid_first_name,
				"To verify that First Name text field should only the alphabets", "APMS-T79");

		// SU-T592-->To verify that "First Name" text field should not accept the
		// special characters and numbers
		// Enter Special Character And Numerical value
		String invalid_firstname = AwtUtilities.genrateRandomAlphaBets(1, 3) + "@94";
		add_user_panel.enterFirstName(invalid_firstname);
		// Get Actual First Name Value
		acutal_first_name_txt_value = add_user_panel.getFirstTextFieldValue().trim();
		// both value should Not be equal
		asert.assertNotEquals(acutal_first_name_txt_value, invalid_firstname,
				"To verify that First Name text field should not accept the special characters and numbers", "SU-T592");

		// SU-T593-->To verify that "Last Name" text field should only the alphabets
		// Enter Valid Last Name
		add_user_panel.enterLastName(valid_last_name);
		// Get The Acutal Last Name text field Value
		String actual_last_name_text_field_value = add_user_panel.getLastNameTextFieldValue();
		// Entered and actual text field value should be match
		asert.assertEquals(actual_last_name_text_field_value, valid_last_name,
				"To verify that Last Name text field should only the alphabets", "SU-T593");

		// SU-T594-->To verify that "Last Name" text field should not accept the
		// special characters and numbers
		// Enter invalid Last Name
		String invalid_lastname = AwtUtilities.genrateRandomAlphaBets(5) + "@587";
		add_user_panel.enterLastName(invalid_lastname);
		// Get The Acutal Last Name text field Value
		actual_last_name_text_field_value = add_user_panel.getLastNameTextFieldValue();
		// Entered and actual text field value should not be match
		asert.assertNotEquals(actual_last_name_text_field_value, invalid_lastname,
				"To verify that Last Name text field should not accept the special characters and numbers", "SU-T594");

		// SU-T595-->To verify that "Create" button should be visible in the "Add
		// Users" Panel
		// Check the visiblity of create button
		boolean isCreateButtonVisible = add_user_panel.isCreateButtonVisible();
		asert.assertTrue(isCreateButtonVisible, "To verify that Create button should be visible in the Add Users Panel",
				"SU-T595");

		// SU-T596-->To verify that created "user" should be visible in the "Users
		// details" table
		// Enter all mandatory Fields
		expected_user_name = AwtUtilities.genrateRandomAlphaBets(6);
		String expected_email = AwtUtilities.genrateRandomAlphaBets(5) + "@gmail.com";
		String expected_last_name = AwtUtilities.genrateRandomAlphaBets(5);
		add_user_panel.enterMandatoryFields(expected_user_name, valid_password, expected_email, role, valid_first_name);
		// Enter Last Name
		add_user_panel.enterLastName(expected_last_name);
		// click on create button
		add_user_panel.clickOnCreateButton();
		// click on cancel button
		add_user_panel.clickOnCancelButton();
		// Verify The Created First Name Should be VIsible In "Users details" Table
		String actual_name = admin_add_user_page.getUserDetailTableValue("Name", expected_user_name);
		asert.assertEquals(actual_name, valid_first_name + " " + expected_last_name,
				"To verify that created first name should be visible in the Users Details Table", "SU-T596");

		// Verify The Created User Name Should be VIsible In "Users details" Table
		String actual_username = admin_add_user_page.getUserDetailTableValue("Username", expected_user_name);
		asert.assertEquals(actual_username, expected_user_name,
				"To verify that created username should be visible in the Users Details Table", "SU-T596");

		// Verify The Created Email Should be VIsible In "Users details" Table
		String actual_email = admin_add_user_page.getUserDetailTableValue("Email", expected_user_name);
		asert.assertEquals(actual_email, expected_email,
				"To verify that created Email should be visible in the Users Details Table", "SU-T596");

		// Verify The Created Role Name Should be VIsible In "Users details" Table
		String role_name = admin_add_user_page.getUserDetailTableValue("Role Name", expected_user_name);
		asert.assertEquals(role_name, role, "To verify that created role should be visible in the Users Details Table",
				"SU-T596");
		// SU-T1442-->To verify that "username" text field should not accept the
		// duplicate name.
		// click on new button
		admin_add_user_page.clickOnNewButtonAndNavigateToAddUserPanel();
		// Then Enter Same User Name
		add_user_panel.enterMandatoryFields(expected_user_name, valid_password, expected_email, role, valid_first_name);
		// Click On Create Button
		add_user_panel.clickOnCreateButton();
		// Validate Error Message
		String actual_error_msg = add_user_panel.getDuplicateErrorMessage();
		asert.assertEquals(actual_error_msg, "A user with this username already exists under the given project.",
				"To verify that username text field should not accept the duplicate name.", "SU-T1442");
		// click on cancel button
		add_user_panel.clickOnCancelButton();

	}

	public void verifyUserDetailsTable() {
		// SU-T597-->To verify that "User Details" table contains "SNo , Name,
		// Username, Email, Role name and Action" Columns should be present.
		String[] expected_columnName = { "SNO", "Name", "Username", "Email", "Role Name", "Action" };
		List<String> actual_ColumName = admin_add_user_page.getUserDetailsTableColumnNames();
		asert.assertEquals(actual_ColumName, new ArrayList<String>(Arrays.asList(expected_columnName)),
				"To verify that User Details table contains SNo , Name, Username, Email, Role name and Action Columns should be present.",
				"SU-T597");

		// SU-T598-->To verify that "edit" functionality
		// --> click on edit button
		admin_add_user_page.clickOnEditButton(expected_user_name);
		// Edit The Role
		String role = "Admin";
		add_user_panel.selectRole(role);
		// --> Click On Update Button
		admin_add_user_page.clickOnUpdateButton();
		// -->Click On Cancel Panel
		add_user_panel.clickOnCancelButton();
		// refresh
		DriverFactory.iuiDriver().getDriver().navigate().refresh();
		// Validate Edited First Name Is Visible Or Not
		String actual_role_name = admin_add_user_page.getUserDetailTableValue("Role Name", expected_user_name);
		// validate actual name
		asert.assertEquals(actual_role_name, role, "To verify that edit functionality", "SU-T598");

		// SU-T599-->To verify that "edit" and "delete" button should be present under
		// the Action" column .
		// Check Edit Button Is Visible
		boolean isEditButtonPresent = admin_add_user_page.isEditButtonIsVisible();
		asert.assertTrue(isEditButtonPresent, "To Verify Edit Button should be present under the Action Column",
				"SU-T599");
		// check delete button is visible
		boolean isDeleteButtonPresent = admin_add_user_page.isEditButtonIsVisible();
		asert.assertTrue(isDeleteButtonPresent, "To Verify Delete Button should be present under the Action Column",
				"SU-T599");

		// SU-T600-->To verify that functionality of the "delete" button .
		// delete create project
		admin_add_user_page.clickOnDeleteButton(expected_user_name);
		// Check Deleted Role Name Should Not Be Visible Role Details Table
		asert.assertNotEquals(admin_add_user_page.getUserDetailTableValue("Username", expected_user_name),
				expected_user_name, "To verify that functionality of the  delete button .", "SU-T600");

	}
}
