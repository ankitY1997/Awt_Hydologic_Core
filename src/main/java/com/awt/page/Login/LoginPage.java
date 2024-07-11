package com.awt.page.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awt.page.Home.HomePage;
import com.awt.utills.reusablecomponents.ActionEngine;
import com.awt.utills.reusablecomponents.AwtUtilities;
import com.awt.utills.reusablecomponents.PropertiesOperations;

public class LoginPage {

	/* xpath of username text field */
	@FindAll({ @FindBy(xpath = "//input[@name='email']"), @FindBy(xpath = "//input[@id='email']") })
	private WebElement txt_email;

	/* xpath of password text field */
	@FindAll({ @FindBy(xpath = "//input[@name='password']"), @FindBy(xpath = "//input[@type='password']") })
	private WebElement txt_password;

	/* xpath for log in button */
	@FindAll({ @FindBy(xpath = "//button[@type='submit']") })
	private WebElement btn_login;

	/* project name title xpath */
	@FindBy(xpath = "//h4[text()='WELCOME TO NARMADA KSHIPRA MULTIPURPOSE PROJECT']")
	private WebElement project_name;

	/* Module Name */
	@FindBy(xpath = "//b[text()='OUTLET MANAGEMENT SYSTEM (OMS)']")
	private WebElement oms_name;

	/* error message xpath */
	@FindBy(xpath = "//div[@role='alert']/div//*[local-name()='svg']/following::div")
	private WebElement error_message;

	/** driver ****/
	WebDriver driver = null;

	/** Action Engine instance variable **/
	ActionEngine action;

	// constructor for intailizing page objects
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		action = new ActionEngine(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * log in to the orangehrm application
	 */
	public void logInToTheApplication(String username, String password) {
		// enter username
		action.type(txt_email, "username", username);
		// enter password
		action.type(txt_password, "password", password);
		// click on login button
		action.clickOn(btn_login, "login");
	}

	/**
	 * this method is used to get the Project name
	 *
	 * @return String
	 * @author AWT Tester
	 */
	public String getProjectName() {
		return action.getText(project_name);
	}

	/**
	 * verify the error message on the login page**
	 *
	 * @return
	 */
	public String getErrorMessage() {
		return AwtUtilities.getTextUsingJavaScriptExecutor(driver, error_message);
	}

	/**
	 * this is methods helps we can navigate to the homePage
	 *
	 * @return instance of homepage
	 */
	public HomePage navigateToTheHomePage() {
		return new HomePage(driver);
	}

	/**
	 * this methods helps we can directly navigate to the login Page with outs
	 *
	 * @return
	 */
	public HomePage navigateToHomePage() {
		logInToTheApplication(PropertiesOperations.getPropertyValueByKey("SUPERADMIN_USERNAME"),
				PropertiesOperations.getPropertyValueByKey("SUPERADMIN_PASSWORD"));
		return new HomePage(driver);
	}

	/**
	 * To verify the module name after log in to the application
	 * 
	 * @param expected_name
	 * @return
	 */
	public String getModuleName() {
		boolean flag = false;
		String actual_name = action.getText(oms_name).trim();
		return actual_name;
	}

}
