package com.awt.test.Login;

import org.testng.annotations.Test;
import com.awt.page.Login.LoginPage;
import com.awt.page.User.ParentLandingPage;
import com.awt.testbase.BaseTest;
import com.awt.testbase.DriverFactory;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.AwtUtilities;
import com.awt.utills.reusablecomponents.Description;
import com.awt.utills.reusablecomponents.ExcelOperations;
import com.awt.utills.reusablecomponents.Owner;
import com.awt.utills.reusablecomponents.PropertiesOperations;
import com.awt.utills.reusablecomponents.SoftAssertTest;
import com.awt.utills.reusablecomponents.Story;
import com.awt.utills.reusablecomponents.TestCaseId;
import com.awt.utills.reusablecomponents.Version;
import com.awt.utills.reusablecomponents.WorkArea;

public class LoginPageTest extends BaseTest {

	// *********Instance Variables*****/
	public static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
	public static final String project_name = "NKMP1";
	public SoftAssertTest asert = null;
	public LoginPage login_page = null;
	public ParentLandingPage home_page = null;

	/**
	 * Navigate To Login Page
	 */
	public void navigateToLoginPage() {

		// SoftAssert instance
		asert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// navigate to login page
		login_page = new LoginPage(DriverFactory.iuiDriver().getDriver());
		login_page.navigateToLoginPage(url, project_name);

	}

	/**
	 * Description: Perform the verification of Login Page <br>
	 * TestMethodName: verifyLoginPage <br>
	 * ManualTestCases: "APMS-T87", "APMS-T88", "APMS-T89", "APMS-T90", "APMS-T91",
	 * "APMS-T92", "APMS-T93", "APMS-T94", "APMS-T95", "APMS-T96", "APMS-T97",
	 * "APMS-T98", "APMS-T99", "APMS-T100",
	 * "APMS-T101","APMS-T102","APMS-T103","APMS-T104"<br>
	 * 
	 * @author ankit
	 */

	@Version(number = "V-0.1")
	@Test(groups = { "Log In", "Functional" })
	@Description(description = "Perform the verfication on  Log In Page")
	@Story(story = "Log In ")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Log in")
	@TestCaseId(id = { "APMS-T128", "APMS-T129", "APMS-T130", "APMS-T131", "APMS-T132", "APMS-T133", "APMS-T134", "APMS-T135",
			"APMS-T136", "APMS-T137", "APMS-T138" })
	public void verifyLoginPage() {
		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());

		// APMS-T128-->To verify that "User Name" text field should be present in the
		// "login" page
		// Open the url and navigate to login page
		navigateToLoginPage();
		// Check user name text field visiblity
		boolean isUserNameTextFieldVisible = login_page.isUserNameTextFieldVisible();
		asert.assertTrue(isUserNameTextFieldVisible,
				"To verify that User Name text field should be present in the login page", "APMS-T128");

		// APMS-T129-->To verify that "Password" text field should be present in the
		// "login" page .
		// Check The VIsiblity Of Password text field
		boolean isPasswordTextFieldVisible = login_page.isPasswordTextFieldVisible();
		asert.assertTrue(isPasswordTextFieldVisible,
				"To verify that Password text field should be present in the login page .", "APMS-T129");

		// APMS-T130-->To verify that "Forgot Password" button should be present in the
		// "login" page.
		// Check The Visibility of Forgot Password button
		boolean isForgotPasswordButtonVisible = login_page.isForgotPasswordButtonVisible();
		asert.assertTrue(isForgotPasswordButtonVisible,
				"To verify that Forgot Password button should be present in the login page.", "APMS-T130");

		// APMS-T131-->To verify that "Login" button should be present in the "login"
		// page.
		// Check the presence of "Login" button
		boolean isLoginPresent = login_page.isLoginButtonVisible();
		asert.assertTrue(isLoginPresent, "To verify that Login button should be present in the login page.",
				"APMS-T131");

		// APMS-T132-->To verify that the user is able to enter text in the "Username"
		// text field.
		// Enter the Username text field
		String username = ExcelOperations.getCellData("LoginCredentialDetails", "Username", "APMS-T132");
		login_page.enterUsername(username);
		// actual user name text field value
		String actual_user_name_value = login_page.getUserNameTextFieldValue();
		asert.assertEquals(actual_user_name_value, username,
				"To verify that the user is able to enter text in the Username text field.", "APMS-T132");

		// APMS-T133-->To verify that user is able to enter text in the "Password" text
		// field.
		// Enter the Password text field value
		String password = ExcelOperations.getCellData("LoginCredentialDetails", "Password", "APMS-T133");
		login_page.enterPassword(password);
		// actual password text field value
		String actual_password = login_page.getPasswordTextFieldValue();
		asert.assertEquals(actual_password, password,
				"To verify that user is able to enter text in the Password text field.", "APMS-T133");

		// APMS-T134-->To verify that a valid user can log in with correct "username"
		// and "password".
		// Enter Valid User name and Valid password--> then click on login button
		String valid_username = ExcelOperations.getCellData("LoginCredentialDetails", "Username", "APMS-T134");
		String valid_password = ExcelOperations.getCellData("LoginCredentialDetails", "Password", "APMS-T134");
		home_page = login_page.logInToTheApplication(valid_username, valid_password);
		// verify "ParentLandingpage" is visible
		String home_page_url = home_page.getHomePageUrl();
		asert.assertTrue(home_page_url.contains("parentLandingpage"),
				"To verify that  a valid user can log in with correct username and password.", "APMS-T134");
		// click on logout button
		home_page.clickOnLogoutButton();
		// again navigate to login page
		navigateToLoginPage();

		// APMS-T135-->To verify that an error message is displayed when an invalid
		// username is entered.

		// Enter invalid username
		String invalid_username = ExcelOperations.getCellData("LoginCredentialDetails", "Username", "APMS-T135");
		login_page.enterUsername(invalid_username);
		// then Enter valid password
		login_page.enterPassword(valid_password);
		// then click on log in button
		login_page.clicOnLoginButton();
		// validate the error message
		String actual_error_message = login_page.getErrorMessage().trim();
		asert.assertEquals(actual_error_message, "User not registered",
				"To verify that  an error message is displayed when an invalid username is entered.", "APMS-T135");

		// APMS-T136-->To verify that an error message is displayed when a valid
		// "username" is entered with an incorrect "password".

		// Enter valid username
		login_page.enterUsername(valid_username);
		// then Enter invalid password
		String invalid_password = ExcelOperations.getCellData("LoginCredentialDetails", "Password", "APMS-T136");
		login_page.enterPassword(invalid_password);
		// then click on log in button
		login_page.clicOnLoginButton();
		// validate the error message
		actual_error_message = login_page.getErrorMessage().trim();
		asert.assertEquals(actual_error_message, "Incorrect password",
				"To verify that an error message is displayed when a valid username is entered with an incorrect password.",
				"APMS-T136");

		// APMS-T137-->To verify that an error message is displayed when the "username"
		// text field is left empty

		// Enter a Password only and keep username field empty
		login_page.clearUsernameTextField();
		login_page.enterPassword(valid_password);
		// then click on log in button
		login_page.clicOnLoginButton();
		// validate error message
		actual_error_message = login_page.getErrorMessage().trim();
		asert.assertEquals(actual_error_message, "Please fill in all fields",
				"To verify that an error message is displayed when the username text field is left empty", "APMS-T137");

		// APMS-T138-->To verify that an error message is displayed when the "password"
		// text field is left empty.

		// Enter username only and keep password text field blank
		login_page.clearPasswordTextField();
		login_page.enterUsername(valid_username);
		// then click on log in button
		login_page.clicOnLoginButton();
		// validate error message
		actual_error_message = login_page.getErrorMessage().trim();
		asert.assertEquals(actual_error_message, "Please fill in all fields",
				"To verify that an error message is displayed when the password text field is left empty.",
				"APMS-T138");

		asert.assertAll();

	}

	/**
	 * To Verify Forgot Password Panel
	 */
	public void verifyForgotPasswordPanel() {
		

	}

}
