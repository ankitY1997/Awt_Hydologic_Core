package com.awt.page.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awt.page.User.ParentLandingPage;
import com.awt.utills.reusablecomponents.ActionEngine;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class ForgotPasswordPanel {

	// ***Forgot Password Panel Name**/
	@FindAll({ @FindBy(xpath = "//div[@data-pc-section='headertitle']") })
	public WebElement panel_heading;

	// *** Email Text Field***/
	@FindAll({ @FindBy(xpath = "//label[text()='Enter Your Email']/following-sibling::input") })
	public WebElement email_text_field;

	// ***Submit button***/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Submit']") })
	public WebElement button_submit;

	// ***OTP Text Field***/
	@FindAll({ @FindBy(xpath = "//input[@id='otp']") })
	public WebElement otp_text_field;

	// ***NEW Password Text Field***/
	@FindAll({ @FindBy(xpath = "//input[@id='newPassword']") })
	public WebElement new_password_text_field;

	// ***Close Reset Password Panel**/
	@FindAll({ @FindBy(xpath = "//*[local-name()='svg' and @data-pc-section='closebuttonicon']") })
	public WebElement close_reset_password_panel;

	// ** Email Error Message**/
	@FindAll({ @FindBy(xpath = "//input[@id='email' and @data-pc-name='inputtext']/following-sibling::small") })
	public WebElement email_error_message;

	// **New Password Error Message**/
	@FindAll({ @FindBy(xpath = "// input[@id='newPassword']/following-sibling::small") })
	public WebElement new_password_error_message;
	/** driver ****/
	WebDriver driver = null;

	/** Action Engine instance variable **/
	ActionEngine action;

	public ForgotPasswordPanel(WebDriver driver) {
		this.driver = driver;
		action = new ActionEngine(driver);
		// Initializing the WebDriver Elements
		PageFactory.initElements(driver, this);
	}

	/**
	 * By This Method You can get Forgot Password panel name
	 * 
	 * @return name of the panel
	 */
	public String getForgotPasswordPanelName() {
		return action.getText(panel_heading).trim();

	}

	/**
	 * By This Method You can get Forgot Password panel name
	 * 
	 * @return name of the panel
	 */
	public String getResetPasswordPanelName() {
		action.waitForVisibility(panel_heading, action.implicit_wait);
		return action.getText(panel_heading).trim();

	}

	/**
	 * Help of this method we can find email text field is visible
	 * 
	 * @return boolean
	 */
	public boolean isEmailTextFieldVisible() {
		action.waitForVisibility(email_text_field, action.implicit_wait);
		return action.isDisplay(email_text_field);
	}

	/**
	 * With help of this method we can enter email
	 * 
	 * @param email
	 */
	public void enterEmail(String email) {
		action.waitForVisibility(email_text_field, action.implicit_wait);
		action.type(email_text_field, "Email", email);
	}

	/**
	 * We Can Get to know about Submit Button Is present
	 * 
	 * @return boolean
	 */
	public boolean isSubmitButtonPresent() {
		action.waitForVisibility(button_submit, action.implicit_wait);
		return action.isDisplay(button_submit);
	}

	/**
	 * With Help Of This Method We Can Click On Submit button
	 */
	public void clickOnSubmitButton() {
		action.waitForVisibility(button_submit, action.implicit_wait);
		action.clickOn(button_submit);
		AwtUtilities.waitFor(10000);
	}

	/**
	 * Get Error Message from forgot password panel
	 */
	public String getInvalidEmailErrorMessage() {
		action.waitForVisibility(email_error_message, action.implicit_wait);
		return action.getText(email_error_message).trim();
	}

	// *************************Reset Password Panel*******************************/

	/**
	 * Help of this method we can check OTP text field is visible
	 * 
	 * @return boolean
	 */
	public boolean isOTPTextFieldVisible() {
		action.waitForVisibility(otp_text_field, action.implicit_wait);
		return action.isDisplay(otp_text_field);
	}

	/**
	 * Help of this method we can check New Password text field is visible
	 * 
	 * @return boolean
	 */
	public boolean isNewPasswordTextFieldVisible() {
		action.waitForVisibility(new_password_text_field, action.implicit_wait);
		return action.isDisplay(new_password_text_field);
	}

	/**
	 * Help Of This Method We Can Enter OTP
	 * 
	 * @param otp
	 */
	public void enterOtp(String otp) {
		if (isOTPTextFieldVisible()) {
			action.type(otp_text_field, "OTP", otp);
		}
	}

	/**
	 * Get OTP Text Field Value
	 * 
	 * @return OTP
	 */
	public String getOtpTextFieldValue() {
		return action.getAttributeValue(otp_text_field, "value").trim();
	}

	/**
	 * Help Of This Method We Can Enter new Password
	 * 
	 * @param password
	 */
	public void enterNewPassword(String password) {
		if (isNewPasswordTextFieldVisible()) {
			action.type(new_password_text_field, "New Password", password);
		}
	}

	/**
	 * Get New Password Text Field Value
	 * 
	 * @return New Password Text Field Value
	 */
	public String getNewPasswordTextFieldValue() {
		return action.getAttributeValue(new_password_text_field, "value").trim();
	}

	/**
	 * By This Method We Can Click On Close Button
	 */
	public void closeResetPasswordPanel() {
		action.waitForVisibility(close_reset_password_panel, action.implicit_wait);
		action.clickOn(close_reset_password_panel);
	}

	/**
	 * Get Error Message from new password text field
	 */
	public String getNewPasswordTextFieldErrorMessage() {
		String error_message = null;
		try {
			action.waitForVisibility(new_password_error_message,5);
			error_message = new_password_error_message.getText().trim();
		} catch (Exception e) {
			error_message = " ";
		}
		return error_message;
	}
}
