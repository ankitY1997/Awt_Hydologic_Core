package com.awt.test.Irrigation.Login;

import org.testng.annotations.Test;
import com.awt.page.ParentLandingPage;
import com.awt.page.Irrigation.Home.HomePage;
import com.awt.page.Irrigation.Login.ForgotPasswordPanel;
import com.awt.page.Irrigation.Login.LoginPage;
import com.awt.testbase.BaseTest;
import com.awt.testbase.DriverFactory;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.AwtUtilities;
import com.awt.utills.reusablecomponents.Description;
import com.awt.utills.reusablecomponents.ExcelOperations;
import com.awt.utills.reusablecomponents.GMailApi;
import com.awt.utills.reusablecomponents.Owner;
import com.awt.utills.reusablecomponents.PropertiesOperations;
import com.awt.utills.reusablecomponents.SoftAssertTest;
import com.awt.utills.reusablecomponents.Story;
import com.awt.utills.reusablecomponents.TestCaseId;
import com.awt.utills.reusablecomponents.Version;
import com.awt.utills.reusablecomponents.WorkArea;

public class LoginPageTest extends BaseTest {

	private static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
	private static final String project_name = PropertiesOperations.getPropertyValueByKey("Project_Name");
	private static final String main_porject_name = PropertiesOperations.getPropertyValueByKey("Main_Project_Name");
	private SoftAssertTest asert = null;
	private LoginPage login_page = null;
	private ParentLandingPage parent_landing_page = null;
	private ForgotPasswordPanel forgot_password_panel = null;
	private HomePage home_page = null;
	private String valid_email = null;
	private String valid_username = null;

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
	 * Description: Perform the verification of Login Page,Forgot Password <br>
	 * TestMethodName: verifyLoginPage <br>
	 * ManualTestCases: "SU-T715", "SU-T716", "SU-T717", "SU-T718", "SU-T719",
	 * "SU-T719", "SU-T721", "APMS-T135", "SU-T723", "SU-T724", "SU-T725",
	 * "SU-T727", "SU-T728", "SU-T729", "SU-T730", "SU-T731", "SU-T732", "SU-T733",
	 * "SU-T734", "SU-T735", "SU-T736", "SU-T737", "SU-T738", "SU-T742", "SU-T742",
	 * "SU-T742", "SU-T743", "SU-T743"<br>
	 * 
	 * @author ankit
	 */

	@Version(number = "V-0.1")
	@Test(groups = { "Log In", "Functional" })
	@Description(description = "Perform the verfication on  Log In Page")
	@Story(story = "Log In ")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Log in")
	@TestCaseId(id = { "SU-T715", "SU-T716", "SU-T717", "SU-T718", "SU-T719", "SU-T719", "SU-T721", "APMS-T135",
			"SU-T723", "SU-T724", "SU-T725", "SU-T727", "SU-T728", "SU-T729", "SU-T730", "SU-T731", "SU-T732",
			"SU-T733", "SU-T734", "SU-T735", "SU-T736", "SU-T737", "SU-T738", "SU-T742", "SU-T742", "SU-T742",
			"SU-T743", "SU-T743" })
	public void verifyLoginPage() {
		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());

		// SU-T715-->To verify that "User Name" text field should be present in the
		// "login" page
		// Open the url and navigate to login page
		navigateToLoginPage();
		// Enter the Project Name
		login_page.enterProjectName(project_name);
		// Check user name text field visiblity
		boolean isUserNameTextFieldVisible = login_page.isUserNameTextFieldVisible();
		asert.assertTrue(isUserNameTextFieldVisible,
				"To verify that User Name text field should be present in the login page", "SU-T715");

		// SU-T716-->To verify that "Password" text field should be present in the
		// "login" page .
		// Check The VIsiblity Of Password text field
		boolean isPasswordTextFieldVisible = login_page.isPasswordTextFieldVisible();
		asert.assertTrue(isPasswordTextFieldVisible,
				"To verify that Password text field should be present in the login page .", "SU-T716");

		// SU-T717-->To verify that "Forgot Password" button should be present in the
		// "login" page.
		// Check The Visibility of Forgot Password button
		boolean isForgotPasswordButtonVisible = login_page.isForgotPasswordButtonVisible();
		asert.assertTrue(isForgotPasswordButtonVisible,
				"To verify that Forgot Password button should be present in the login page.", "SU-T717");

		// SU-T718-->To verify that "Login" button should be present in the "login"
		// page.
		// Check the presence of "Login" button
		boolean isLoginPresent = login_page.isLoginButtonVisible();
		asert.assertTrue(isLoginPresent, "To verify that Login button should be present in the login page.", "SU-T718");

		// SU-T719-->To verify that the user is able to enter text in the "Username"
		// text field.
		// Enter the Username text field
		String username = ExcelOperations.getCellData("LoginCredentialDetails", "Username", "SU-T719");
		login_page.enterUsername(username);
		// actual user name text field value
		String actual_user_name_value = login_page.getUserNameTextFieldValue();
		asert.assertEquals(actual_user_name_value, username,
				"To verify that the user is able to enter text in the Username text field.", "SU-T719");

		// SU-T719-->To verify that user is able to enter text in the "Password" text
		// field.
		// Enter the Password text field value
		String password = ExcelOperations.getCellData("LoginCredentialDetails", "Password", "SU-T720");
		login_page.enterPassword(password);
		// actual password text field value
		String actual_password = login_page.getPasswordTextFieldValue();
		asert.assertEquals(actual_password, password,
				"To verify that user is able to enter text in the Password text field.", "SU-T720");

		// SU-T721-->To verify that a valid user can log in with correct "username"
		// and "password".
		// Enter Valid User name and Valid password--> then click on login button
		valid_username = ExcelOperations.getCellData("LoginCredentialDetails", "Username", "SU-T721");
		String valid_password = ExcelOperations.getCellData("LoginCredentialDetails", "Password", "SU-T721");

		home_page = login_page.logInToTheApplication(valid_username, valid_password);
		// verify "ParentLandingpage" is visible
		String home_page_url = home_page.getHomePageUrl();
		asert.assertTrue(home_page_url.contains("MainDashboard"),
				"To verify that  a valid user can log in with correct username and password.", "SU-T721");
		// -> Click on Log out button
		home_page.clickOnLogoutButton();
		// Again navigate to login page
		navigateToLoginPage();

		// SU-T722-->To verify that an error message is displayed when an invalid
		// username is entered.
		// Enter Project Name
		login_page.enterProjectName(project_name);
		// Enter invalid username
		String invalid_username = ExcelOperations.getCellData("LoginCredentialDetails", "Username", "SU-T722");
		login_page.enterUsername(invalid_username);
		// then Enter valid password
		login_page.enterPassword(valid_password);
		// then click on log in button
		login_page.clicOnLoginButton();
		// validate the error message
		String actual_error_message = login_page.getErrorMessage().trim();
		asert.assertEquals(actual_error_message, "User not registered",
				"To verify that  an error message is displayed when an invalid username is entered.", "SU-T722");

		// SU-T723-->To verify that an error message is displayed when a valid
		// "username" is entered with an incorrect "password".
		// Enter valid username
		login_page.enterUsername(valid_username);
		// then Enter invalid password
		String invalid_password = ExcelOperations.getCellData("LoginCredentialDetails", "Password", "SU-T723");
		login_page.enterPassword(invalid_password);
		// then click on log in button
		login_page.clicOnLoginButton();
		// validate the error message
		actual_error_message = login_page.getErrorMessage().trim();
		asert.assertEquals(actual_error_message, "Incorrect password",
				"To verify that an error message is displayed when a valid username is entered with an incorrect password.",
				"SU-T723");

		// SU-T724-->To verify that an error message is displayed when the "username"
		// text field is left empty
		// Enter a Password only and keep username field empty
		login_page.clearUsernameTextField();
		login_page.enterPassword(valid_password);
		// then click on log in button
		login_page.clicOnLoginButton();
		// validate error message
		actual_error_message = login_page.getErrorMessage().trim();
		asert.assertEquals(actual_error_message, "Please fill in all fields",
				"To verify that an error message is displayed when the username text field is left empty", "SU-T724");

		// SU-T725-->To verify that an error message is displayed when the "password"
		// text field is left empty.
		// Enter username only and keep password text field blank
		login_page.clearPasswordTextField();
		login_page.enterUsername(valid_username);
		// then click on log in button
		login_page.clicOnLoginButton();
		// validate error message
		actual_error_message = login_page.getErrorMessage().trim();
		asert.assertEquals(actual_error_message, "Please fill in all fields",
				"To verify that an error message is displayed when the password text field is left empty.", "SU-T725");

		// Verify Forgot Password Panel
		verifyForgotPasswordPanel();
		// verify reset password panel
		verifyResetPasswordPanel();
		asert.assertAll();

	}

	/**
	 * To Verify Forgot Password Panel
	 */
	public void verifyForgotPasswordPanel() {

		// SU-T727-->To verify that clicking on the "Forgot Password" button
		// ,redirects to the "Forgot Password" Panel.
		// click on forgot password button and navigate to "Forgot Password" panel
		forgot_password_panel = login_page.clickOnForgotPasswordButtonAndNavigateToForgotPasswordPanel();
		// Check the Forgot password panel visibility
		String actual_panel_name = forgot_password_panel.getForgotPasswordPanelName();
		asert.assertEquals(actual_panel_name, "Forgot Password",
				"To verify that clicking on the Forgot Password button ,redirects to the Forgot Password Panel.",
				"SU-T727");

		// SU-T728-->To verify that "Enter Your Email" text field should be present in
		// the "Forgot Password" panel.
		// check the "Email" text field is visible
		boolean isEmailTextFieldVisible = forgot_password_panel.isEmailTextFieldVisible();
		asert.assertTrue(isEmailTextFieldVisible,
				"To verify that Enter Your Email text field should be present in the Forgot Password panel.",
				"SU-T728");

		// SU-T729-->To verify that "Submit" button should be present in the "Forgot
		// Password" panel.
		// Check The Submit Button Presence
		boolean isSubmitButtonVisible = forgot_password_panel.isSubmitButtonPresent();
		asert.assertTrue(isSubmitButtonVisible,
				"To verify that Submit button should be present in the Forgot Password panel.", "SU-T729");

		// SU-T730-->To verify that should accepts only the registered email id in the
		// "Enter Your Email" text field , when you have given at the time of "User
		// Creation".
		// Enter Valid Email Id
		valid_email = ExcelOperations.getCellData("LoginCredentialDetails", "Email", "SU-T730");
		// enter valid email
		forgot_password_panel.enterEmail(valid_email);
		// click on submit button
		forgot_password_panel.clickOnSubmitButton();
		// Check "Reset Password Panel" is visible

		actual_panel_name = forgot_password_panel.getResetPasswordPanelName();
		asert.assertEquals(actual_panel_name, "Reset Password",
				"To verify that should accepts only the registered email id in the Enter Your Email text field , at the time of User Creation.",
				"SU-T730");
		// Then Close The "Reset Password" panel
		forgot_password_panel.closeResetPasswordPanel();

		// SU-T731-->To verify that should not accepts the unregistered email id in
		// the "Enter Your Email" text field
		// Click On Forgot Password button
		login_page.clickOnForgotPasswordButtonAndNavigateToForgotPasswordPanel();
		// Enter not registered E-mail
		String notRegisterEmail = ExcelOperations.getCellData("LoginCredentialDetails", "Email", "SU-T731");
		forgot_password_panel.enterEmail(notRegisterEmail);
		// Click On Submit Button
		forgot_password_panel.clickOnSubmitButton();
		// Get Error Message
		String actual_error_message = forgot_password_panel.getInvalidEmailErrorMessage();
		asert.assertEquals(actual_error_message, "Email not found",
				"To verify that should not accepts the unregistered email id in the Enter Your Email text field .",
				"SU-T731");

	}

	/**
	 * In This Method We Are Validating Reset Password Panel
	 */
	public void verifyResetPasswordPanel() {

		// SU-T732-->To verify that "OTP" text field should be present in the "Reset
		// Password" Panel
		// Enter valid email
		forgot_password_panel.enterEmail(valid_email);
		// click on Submit button
		forgot_password_panel.clickOnSubmitButton();
		// Check "OTP" text field is visible
		boolean isOtpTextFieldVisible = forgot_password_panel.isOTPTextFieldVisible();
		asert.assertTrue(isOtpTextFieldVisible,
				"To verify that OTP text field should be present in the Reset Password Panel", "SU-T732");

		// SU-T733-->To verify that "New Password" text field should be present in the
		// "Reset Password" Panel
		// Check the "New Password" Text Field is Visible
		boolean isNewPasswordTextFieldVisible = forgot_password_panel.isNewPasswordTextFieldVisible();
		asert.assertTrue(isNewPasswordTextFieldVisible,
				"To verify that New Password text field should be present in the Reset Password Panel", "SU-T733");

		// SU-T734-->To verify that "Submit" button should be present in the "Reset
		// Password" Panel
		// Check The presence of submit button
		boolean isSubmitButtonPresent = forgot_password_panel.isSubmitButtonPresent();
		asert.assertTrue(isSubmitButtonPresent,
				"To verify that Submit button should be present in the Reset Password Panel", "SU-T734");

		// SU-T735-->To verify that "OTP" text field should accepts only the numeric
		// values
		// Enter Only Numeric Value in OTP Text Field
		String numeric_value = AwtUtilities.genrateRandomNumber(4);
		forgot_password_panel.enterOtp(numeric_value);
		String acutal_otp_text_field_value = forgot_password_panel.getOtpTextFieldValue();
		// it should accept
		asert.assertEquals(acutal_otp_text_field_value, numeric_value,
				"To verify that OTP text field should accepts only the numeric values", "SU-T735");

		// SU-T736-->To verify that "OTP" text field should not accept the alphabets
		// and special characters
		String invalid_value = AwtUtilities.genrateRandomAlphaBets(1, 3) + "&";
		forgot_password_panel.enterOtp(invalid_value);
		acutal_otp_text_field_value = forgot_password_panel.getOtpTextFieldValue();
		// it should not accept
		asert.assertNotEquals(acutal_otp_text_field_value, invalid_value,
				"To verify that OTP text field should not accept the alphabets and special characters", "SU-T736");

		// SU-T737-->To verify that "OTP" text field should accept only up to "six
		// (6)" number of digits.
		// Enter Only 6 number of digit
		String valid_number = AwtUtilities.genrateRandomNumber(6);
		forgot_password_panel.enterOtp(valid_number);
		// Get Actual Otp Text Field Value
		acutal_otp_text_field_value = forgot_password_panel.getOtpTextFieldValue();
		asert.assertEquals(valid_number, acutal_otp_text_field_value,
				"To verify that OTP text field should accept only up to six(6) number of digits.", "SU-T737");

		// SU-T738-->To verify that "OTP" text field should not accept more than "six"
		// number of digits.
		// Enter Only 6 number of digit
		String invalid_number = AwtUtilities.genrateRandomNumber(8);
		forgot_password_panel.enterOtp(invalid_number);
		// Get Actual Otp Text Field Value
		acutal_otp_text_field_value = forgot_password_panel.getOtpTextFieldValue();
		asert.assertNotEquals(invalid_number, acutal_otp_text_field_value,
				"To verify that OTP text field should not accept more than  six(6) number of digits.", "SU-T738");

		// SU-T742-->To Verify that the "New Password" field only accepts passwords
		// with at least 8 characters, including one uppercase letter, one lowercase
		// letter, one special character, and one number.
		String valid_Password = ExcelOperations.getCellData("LoginCredentialDetails", "Password", "SU-T742");
		// Enter Valid New Password
		forgot_password_panel.enterNewPassword(valid_Password);
		// click on submit button
		forgot_password_panel.clickOnResetPanelSubmitButton();
		// Check Error Message is visible
		String new_password_error_message = forgot_password_panel.getNewPasswordTextFieldErrorMessage();
		asert.assertNotEquals(new_password_error_message,
				"Password must be at least 8 characters long, include one uppercase letter, one digit, and one special character",
				"To Verify that the New Password field only accepts passwords with at least 8 characters, including one uppercase letter, one lowercase letter, one special character, and one number.",
				"SU-T742");

		// SU-T742-->To verify that New Password text field should accepts only
		// passwords with a maximum of 15 characters.
		// Enter Only 15 Character Password
		valid_Password = ExcelOperations.getCellData("LoginCredentialDetails", "Password", "SU-T742");
		forgot_password_panel.enterNewPassword(valid_Password);
		// It should accept
		String act_new_pass_text_value = forgot_password_panel.getNewPasswordTextFieldValue();
		// actutal password value should be equal to valid password
		asert.assertEquals(act_new_pass_text_value, valid_Password,
				"To verify that New Password text field should accepts only passwords with a maximum of 15 characters.",
				"SU-T742");

		// SU-T742-->To verify that the "New Password" text field should not exceeds
		// more than 15
		// characters.
		// Enter 17 character password
		String inValidPassword = ExcelOperations.getCellData("LoginCredentialDetails", "Password", "SU-T742");
		forgot_password_panel.enterNewPassword(inValidPassword);
		// It should not accept
		act_new_pass_text_value = forgot_password_panel.getNewPasswordTextFieldValue();
		// actual value should not be equal to enter invalid password
		asert.assertNotEquals(act_new_pass_text_value, inValidPassword,
				"To verify that the New Password text field  should not exceeds more than 15 characters.", "SU-T742");

		// SU-T743-->To verify the functionality of the Submit button with valid "OTP"
		// and "New Password".

		// Enter Valid OTP
		String valid_otp = GMailApi.getGmailOtp();
		forgot_password_panel.enterOtp(valid_otp);
		// Enter valid password
		forgot_password_panel.enterNewPassword(valid_Password);
		// click on submit button
		forgot_password_panel.clickOnResetPanelSubmitButton();

		// Log in With Changed Password
		login_page.enterUsername(valid_username);
		login_page.enterPassword(valid_Password);
		// click on login button
		login_page.clicOnLoginButton();
		// verify "ParentLandingpage" is visible
		String home_page_url = home_page.getHomePageUrl();
		asert.assertTrue(home_page_url.contains("parentLandingpage"),
				"To verify the functionality of the Submit button with valid OTP and New Password.", "SU-T743"); // click
																													// on
																													// logout
																													// button
		home_page.clickOnLogoutButton();
		// Again Update Old Password
		updateOldPassword();
	}

	/**
	 * Update Old Password
	 */
	public void updateOldPassword() {
		// SU-T743-->To verify the error message when an invalid "OTP" is entered and
		// the "Submit" button is clicked
		// Navigate to login page
		navigateToLoginPage();
		// Enter the Project Name
		login_page.enterProjectName(project_name);
		// Click On Forgot Password Button
		login_page.clickOnForgotPasswordButtonAndNavigateToForgotPasswordPanel();
		// Enter Email
		forgot_password_panel.enterEmail(valid_email);
		// Click On Submit button
		forgot_password_panel.clickOnSubmitButton();
		// Enter in correct otp and Valid Password
		String inValidOtp = AwtUtilities.genrateRandomNumber(6);
		forgot_password_panel.enterOtp(inValidOtp);
		// Enter Old Password Password
		String old_password = ExcelOperations.getCellData("LoginCredentialDetails", "Password", "SU-T721");
		forgot_password_panel.enterNewPassword(old_password);
		// click on submit button
		forgot_password_panel.clickOnResetPanelSubmitButton();
		// In valid otp message should be visible
		String actual_otp_error_message = forgot_password_panel.getOtpErrorMessage();
		asert.assertEquals(actual_otp_error_message, "Invalid OTP",
				"To verify the error message when an invalid OTP is entered and the Submit button is clicked",
				"SU-T743");
		// Then Again Enter the correct otp
		String otp = GMailApi.getGmailOtp();
		forgot_password_panel.enterOtp(otp);
		// click on submit button
		forgot_password_panel.clickOnResetPanelSubmitButton();

	}

}
