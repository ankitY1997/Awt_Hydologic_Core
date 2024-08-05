package com.awt.test.User.AdminConfiguration.User.CreateUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.awt.page.Login.LoginPage;
import com.awt.page.User.ParentLandingPage;
import com.awt.page.User.AdminConfiguration.AdminPage;
import com.awt.page.User.AdminConfiguration.User.CreateUser.AddUsersPanel;
import com.awt.page.User.AdminConfiguration.User.CreateUser.AdminAddUserPage;
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

public class AdminAddUserTest {

	// Instance Variable ///
	public static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
	public static final String admin_project = "Admin";
	SoftAssertTest asert = null;
	ParentLandingPage parent_landing_page = null;
	LoginPage lp = null;
	AdminPage admin_page = null;
	AdminAddUserPage admin_add_user_page = null;
	AddUsersPanel add_user_panel = null;

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
	@Description(description = "Perform the verfication on amin_add_user_page")
	@Story(story = "Create User and View User")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestCaseId(id = { "APMS-T65", "APMS-T66", "APMS-T67", "APMS-T90", "APMS-T91", "APMS-T92", "APMS-T93", "APMS-T94",
			"APMS-T95", "APMS-T96", "APMS-T97", "APMS-T98", "APMS-T99", "APMS-T100", "APMS-T101", "APMS-T102",
			"APMS-T103", "APMS-T104" })
	public void verifyAdminAddRolePage() {

		// Navigate To New
		navigateToParentLandingPage();
		// click Admin project and Navigate To Admin Page
		admin_page = (AdminPage) parent_landing_page.goToProjectPage(admin_project);
		// Then -->Click On User Drop-Down And Select The Create Role
		admin_add_user_page = admin_page.navigateToAdminAddUserPage();
		// APMS-65-->To verify that "New" button should be present in the
		// "admin-adduser" page.
		boolean isVisible = admin_add_user_page.isNewButtonIsVisible();
		asert.assertTrue(isVisible, "To verify that New button should be present in the admin-adduser page.",
				"APMS-T65");

	}

	public void verifyAddUserPanel() {

		// APMS-T66-->To verify that clicking on the "New" button redirects to the "Add
		// Users" Panel.
		// click on "New" button and navigate to add user panel
		add_user_panel = admin_add_user_page.clickOnNewButtonAndNavigateToAddNewRolePanel();
		// Check the "Add User Panel Is Visible or not
		asert.assertEquals(add_user_panel.getPanelName(), "ADD USERS",
				"To verify that clicking on the New button redirects to the Add Users Panel", "APMS-T66");

		// APMS-T67-->To verify that fields in the "Add Users" panel
		// Expected Fields
		String[] add_user_fields = { "Username*", "Email *", "Password *", "Role *", "First Name *", "Last Name" };
		// actual fields name
		List<String> actual_fields = add_user_panel.listOfAddUserPanelFields();
		// Expected fields name should be equal to actual fields name
		asert.assertEquals(actual_fields, new ArrayList<String>(Arrays.asList(add_user_fields)),
				"To verify that fields in the Add Users panel", "APMS-T67");

		// APMS-T68-->To verify that "username" text field should accept only alphabets
		// Enter the Alphabets
		String valid_username = AwtUtilities.genrateRandomAlphaBets(5);
		add_user_panel.enterUserName(valid_username);
		// get the user name
		String actual_value = add_user_panel.getUserNameFieldValue().trim();
		// Both Value SHould be Equal
		asert.assertEquals(actual_fields, valid_username,
				"To verify that username text field should accept only alphabets", "APMS-T68");

		// Then Enter In Valid User Name
		String invalid_username = AwtUtilities.genrateRandomAlphaBets(5) + 12;
		add_user_panel.enterUserName(invalid_username);
		// get the acutal user name text value
		actual_value = add_user_panel.getUserNameFieldValue().trim();
		// both value should not be equal
		asert.assertNotEquals(actual_fields, valid_username,
				"To verify that username text field should Not accept only alpha Neumeric Value", "APMS-T68");

		// APMS-T69-->To verify that "username" text field should not exceed more than
		// 16 alphabets character
		invalid_username = AwtUtilities.genrateRandomAlphaBets(17);
		add_user_panel.enterUserName(invalid_username);
		// get the acutal user name text value
		actual_value = add_user_panel.getUserNameFieldValue().trim();
		// both value should not be equal
		asert.assertNotEquals(actual_fields, valid_username,
				"To verify that username text field should not exceed more than 16 alphabets character", "APMS-T69");

		// APMS-70-->To verify that "username" text field should not accept any special
		// characters and numbers.
		invalid_username = AwtUtilities.genrateRandomAlphaBets(7) + "$@";
		add_user_panel.enterUserName(invalid_username);
		// get the acutal user name text value
		actual_value = add_user_panel.getUserNameFieldValue().trim();
		// both value should not be equal
		asert.assertNotEquals(actual_fields, valid_username,
				"To verify that username text field should not accept any special characters and numbers.", "APMS-T70");

		// APMS-T71-->To verify that password with 8 to 15 characters is accepted in the
		// "password" text field
		String valid_password = AwtUtilities.genrateRandomAlphaBets(1, 3).toUpperCase()
				+ AwtUtilities.genrateRandomAlphaBets(1, 3).toLowerCase() + "@" + "12";
		String valid_email = AwtUtilities.genrateRandomAlphaBets(5) + "@gmail.com";
		String role = "Super Admin";
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
				"To verify that password with 8 to 15 characters is accepted in the password text field", "APMS-T71");

		// APMS-T72-->To verify that less than 8 characters should not be accepted in
		// the "password" text field
		String invalid_Password = AwtUtilities.genrateRandomAlphaBets(5) + "@1";
		// Enter Mandatory fields
		// enter all details
		add_user_panel.enterMandatoryFields(valid_username, invalid_Password, valid_email, role);
		// click on create button
		add_user_panel.clickOnCreateButton();
		// Error Message Should be Visible
		actual_error_message = add_user_panel.getErroMessage("Password *");
		asert.assertEquals(actual_error_message,
				"Password must be at least 8 characters long, include one uppercase letter, and one special character.",
				"To verify that less than 8 characters should not be accepted in the password text field", "APMS-T72");

		// APMS-T74-->To verify that "password" should contains at least one upper
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
				"APMS-T74");

		// APMS-T75-->To verify that email id's text field with valid format are
		// accepted
		// Enter Valid Email Format and fill all details
		add_user_panel.enterMandatoryFields(valid_username, valid_password, valid_email, role);
		// click on create button
		add_user_panel.clickOnCreateButton();
		// Error Message Should Not be Visible
		actual_error_message = add_user_panel.getErroMessage("Email *");
		asert.assertNotEquals(actual_error_message, "Please enter a valid email address with both @ and . characters.",
				"To verify that email id's text field with valid format are Accepted", "APMS-T75");

		// APMS-T76-->To verify that email id's text field with invalid format are not
		// accepted
		// Enter Invalid Email Format
		String invalid_email_format = AwtUtilities.genrateRandomAlphaBets(5);
		// Enter invalid Email Format and fill all details
		add_user_panel.enterMandatoryFields(valid_username, invalid_email_format, valid_email, role);
		// click on create button
		add_user_panel.clickOnCreateButton();
		// Error Message Should be Visible
		actual_error_message = add_user_panel.getErroMessage("Email *");
		asert.assertEquals(actual_error_message, "Please enter a valid email address with both @ and . characters.",
				"To verify that email id's text field should not accept invalid email format", "APMS-T76");

		// APMS-T77-->To verify that user can not be add a user with out selecting a
		// role .
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
				"To verify that user can not be add a user with out selecting a role .", "APMS-T77");

		// APMS-T78-->To verify that user should be able role in the "Role" drop down.
		// select role name
		String expected_selected_role = "Super Admin";
		add_user_panel.selectRole(expected_selected_role);
		// to get actual role name
		String actual_role_name = add_user_panel.getSelectedRoleName();
		// selected role name should be equal to actual selected role name
		asert.assertEquals(actual_role_name, expected_selected_role,
				"To verify that user should be able role in the Role drop down.", "APMS-T78");

		// APMS-79-->To verify that "First Name" text field should only the alphabets
		// Enter Alphabets only
		add_user_panel.enterFirstName(valid_first_name);
		// Get Actual First Name Value
		String acutal_first_name_txt_value = add_user_panel.getFirstTextFieldValue().trim();
		// both value should be equal
		asert.assertEquals(acutal_first_name_txt_value, valid_first_name,
				"To verify that First Name text field should only the alphabets", "APMS-T79");

		// APMS-T80-->To verify that "First Name" text field should not accept the
		// special characters and numbers
		// Enter Special Character And Numerical value
		String invalid_firstname = AwtUtilities.genrateRandomAlphaBets(1, 3) + "@94";
		add_user_panel.enterFirstName(invalid_firstname);
		// Get Actual First Name Value
		acutal_first_name_txt_value = add_user_panel.getFirstTextFieldValue().trim();
		// both value should Not be equal
		asert.assertNotEquals(acutal_first_name_txt_value, invalid_firstname,
				"To verify that First Name text field should not accept the special characters and numbers",
				"APMS-T80");

		// APMS-T81-->To verify that "Last Name" text field should only the alphabets
		// Enter Valid Last Name
		add_user_panel.enterLastName(valid_last_name);
		// Get The Acutal Last Name text field Value
		String actual_last_name_text_field_value = add_user_panel.getLastNameTextFieldValue();
		// Entered and actual text field value should be match
		asert.assertEquals(actual_last_name_text_field_value, valid_last_name,
				"To verify that Last Name text field should only the alphabets", "APMS-T81");

		// APMS-T82-->To verify that "Last Name" text field should not accept the
		// special characters and numbers
		// Enter invalid Last Name
		String invalid_lastname = AwtUtilities.genrateRandomAlphaBets(5) + "@587";
		add_user_panel.enterLastName(invalid_lastname);
		// Get The Acutal Last Name text field Value
		actual_last_name_text_field_value = add_user_panel.getLastNameTextFieldValue();
		// Entered and actual text field value should not be match
		asert.assertNotEquals(actual_last_name_text_field_value, valid_last_name,
				"To verify that Last Name text field should not accept the special characters and numbers", "APMS-T82");

		// APMS-T83-->To verify that "Create" button should be visible in the "Add
		// Users" Panel
		// Check the visiblity of create button
		boolean isCreateButtonVisible = add_user_panel.isCreateButtonVisible();
		asert.assertTrue(isCreateButtonVisible, "To verify that Create button should be visible in the Add Users Panel",
				"APMS-T83");

	}

}
