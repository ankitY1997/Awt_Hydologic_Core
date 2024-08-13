package com.awt.page.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awt.page.Admin.ProjectDashboardPage;
import com.awt.page.User.ParentLandingPage;
import com.awt.testbase.DriverFactory;
import com.awt.utills.reusablecomponents.ActionEngine;
import com.awt.utills.reusablecomponents.AwtUtilities;
import com.awt.utills.reusablecomponents.PropertiesOperations;

public class LoginPage {

	/* xpath for enter project name text field */
	@FindAll({ @FindBy(xpath = "//input[@role='combobox']") })
	private WebElement txt_entr_project_name;

	/* xpath for get started button */
	@FindAll({ @FindBy(xpath = "//button[text()='Get Started']") })
	private WebElement btn_get_started;

	/* xpath of username text field */
	@FindAll({ @FindBy(xpath = "//input[@name='email']"), @FindBy(xpath = "//input[@id='email']"),
			@FindBy(xpath = "//input[@placeholder='User name']") })
	private WebElement txt_username;

	/* xpath of password text field */
	@FindAll({ @FindBy(xpath = "//input[@name='password']"), @FindBy(xpath = "//input[@placeholder='Password']") })
	private WebElement txt_password;

	/* xpath for log in button */
	@FindAll({ @FindBy(xpath = "//button[@type='submit']") })
	private WebElement btn_login;

	/* error message xpath */
	@FindAll({
			@FindBy(xpath = "//*[local-name()='svg' and @data-testid='ErrorOutlineIcon']/parent::div/following-sibling::div"),
			@FindBy(xpath = "//div[@role='alert']/div[2]") })
	private WebElement error_message;

	/* Forgot Password button */
	@FindBy(xpath = "//button[text()='Forgot Password']")
	private WebElement btn_forgot_password;

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
	 * With Help Of This Method We Can Check The Visibility of user name text field
	 * 
	 * @return boolean
	 */
	public boolean isUserNameTextFieldVisible() {
		action.implicitWait(txt_username, action.implicit_wait);
		return action.isDisplay(txt_username);
	}

	/**
	 * With Help Of This Method We Can Check The Visibility of password text field
	 * 
	 * @return boolean
	 */
	public boolean isPasswordTextFieldVisible() {
		action.implicitWait(txt_password, action.implicit_wait);
		return action.isDisplay(txt_password);
	}

	/**
	 * With Help Of This Method We Can Check The Visibility of forgot password
	 * button
	 * 
	 * @return boolean
	 */
	public boolean isForgotPasswordButtonVisible() {
		action.implicitWait(btn_forgot_password, action.implicit_wait);
		return action.isDisplay(btn_forgot_password);
	}

	/**
	 * With Help Of This Method We Can Check The Visibility of login button
	 * 
	 * @return boolean
	 */
	public boolean isLoginButtonVisible() {
		action.implicitWait(btn_login, action.implicit_wait);
		return action.isDisplay(btn_login);
	}

	/**
	 * Get user name text field value
	 * 
	 * @return value of user name text field value
	 */
	public String getUserNameTextFieldValue() {
		action.waitForVisibility(txt_username, action.implicit_wait);
		return action.getAttributeValue(txt_username, "value").trim();
	}

	/**
	 * Get password text field value
	 * 
	 * @return value of password text field value
	 */
	public String getPasswordTextFieldValue() {
		action.waitForVisibility(txt_password, action.implicit_wait);
		return action.getAttributeValue(txt_password, "value").trim();
	}

	/**
	 * With help of this we can enter the user name
	 * 
	 * 
	 * @param projectName
	 * @author Ankit
	 */
	public void enterUsername(String username) {
		// check the visibility of user name
		if (isUserNameTextFieldVisible()) {
			// enter the project name
			action.type(txt_username, "Username", username);
		}

	}

	/**
	 * With help of this we can enter the password
	 * 
	 * 
	 * @param password
	 * @author Ankit
	 */
	public void enterPassword(String password) {
		// check the visibility of user name
		if (isPasswordTextFieldVisible()) {
			// enter the project name
			action.type(txt_password, "Password", password);
		}

	}

	/**
	 * With this method we can clean username text field
	 */
	public void clearUsernameTextField() {
		action.clearText(txt_username);

	}

	/**
	 * With this method we can clear password text field
	 */
	public void clearPasswordTextField() {
		action.clearText(txt_password);
	}

	/**
	 * By this method we can click on login button
	 */
	public void clicOnLoginButton() {
		// wait for visibility
		if (isLoginButtonVisible()) {
			// click on login button
			action.clickOn(btn_login);
		}
	}

	/**
	 * log in to the Scada application
	 * 
	 * @author Ankit
	 */
	public ParentLandingPage logInToTheApplication(String username, String password) {
//		// Enter the Project Name
//		enterProjectName(Properties.getPropertyValue("Project_Name"));
		// enter username
		action.type(txt_username, "username", username);
		// enter password
		action.type(txt_password, "password", password);
		// click on login button
		action.clickOn(btn_login, "login");
		return new ParentLandingPage(driver);
	}

	/**
	 * With help of this we can enter the project name and By clicking on get button
	 * we can Navigate to the login page
	 * 
	 * @param projectName
	 * @author Ankit
	 */
	public void enterProjectName(String projectName) {
		// enter the project name
		action.type(txt_entr_project_name, "Project Name", projectName);
		// select the project name
		action.performClick(driver.findElement(By.xpath("//div[@role='listbox']/div[text()='" + projectName + "']")));
		// click on get start button
		action.clickOn(btn_get_started, "Get Started");

	}

	/**
	 * verify the error message on the login page**
	 *
	 * @return
	 */
	public String getErrorMessage() {
		AwtUtilities.waitFor(200);
		action.waitForVisibility(error_message, action.implicit_wait);
		return AwtUtilities.getTextUsingJavaScriptExecutor(driver, error_message);
	}

	/**
	 * this methods helps we can directly navigate to the login Page -->
	 * DashboardsPage
	 *
	 * @return
	 */
	public ProjectDashboardPage loginAndProjectDashboardPage(String url, String projectName) {
		// enterProjectName(projectName);
		try {
			driver.get(url);
			AwtUtilities.waitForPageLoading(driver);
			logInToTheApplication(PropertiesOperations.getPropertyValueByKey("SUPERADMIN_USERNAME"),
					PropertiesOperations.getPropertyValueByKey("SUPERADMIN_PASSWORD"));
			System.out.println("*********************Sucessfully Navigate To The Url*********************");
			return new ProjectDashboardPage(driver);
		} catch (Exception e) {
			System.out.println("*********************Unable To Navigate  The Url*********************");
			return null;
		}
	}

	/**
	 * this methods helps we can directly navigate to the login Page-->Parent
	 * Landing Page
	 *
	 * @return
	 */
	public ParentLandingPage loginAndNavigateToTheParentLandingPage(String url, String projectName, String username,
			String password) {
		try {
			driver.get(url);
			AwtUtilities.waitForPageLoading(driver);
			enterProjectName(projectName);
			logInToTheApplication(username, password);
			System.out.println("*********************Sucessfully Navigate To The Url*********************");
			return new ParentLandingPage(driver);
		}

		catch (Exception e) {
			System.out.println("*********************Unable To Navigate  The Url*********************");
			return null;
		}
	}

	/**
	 * Navigate To Login Page
	 * 
	 * @param url
	 * @return
	 */
	public void navigateToLoginPage(String url, String projectName) {
		try {
			driver.get(url);
			AwtUtilities.waitForPageLoading(driver);
			enterProjectName(projectName);
			System.out.println("*********************Sucessfully Navigate To The Url*********************");
		} catch (Exception e) {
			System.out.println("*********************Unable To Navigate  The Url*********************");
		}
	}
}
