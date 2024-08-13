package com.awt.page.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awt.page.User.ParentLandingPage;
import com.awt.utills.reusablecomponents.ActionEngine;

public class ForgotPasswordPanel {

	// ***Forgot Password Panel Name**/
	@FindAll({ @FindBy(xpath = "//div[@data-pc-section='headertitle']") })
	public WebElement forgot_password_panel;

	// *** Email Text Field***/
	@FindAll({ @FindBy(xpath = "//label[text()='Enter Your Email']/following-sibling::input") })
	public WebElement email_text_field;

	// ***Submit button***/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Submit']") })
	public WebElement button_sumit;

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
		return action.getText(forgot_password_panel).trim();

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
		action.waitForVisibility(button_sumit, action.implicit_wait);
		return action.isDisplay(button_sumit);
	}

	/**
	 * With Help Of This Method We Can Click On Submit button
	 */
	public void clickOnSubmitButton() {
		action.waitForVisibility(button_sumit, action.implicit_wait);
		action.clickOn(button_sumit);
	}

}
