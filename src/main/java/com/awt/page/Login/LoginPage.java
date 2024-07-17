package com.awt.page.Login;

import org.bouncycastle.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.awt.utills.reusablecomponents.ActionEngine;
import com.awt.utills.reusablecomponents.AwtUtilities;
import com.awt.utills.reusablecomponents.PropertiesOperations;

public class LoginPage {

	/* xpath for enter project name text field */
	@FindAll({ @FindBy(xpath = "//div[text()='Enter Project Name']") })
	private WebElement txt_entr_project_name;

	/* xpath for get started button */
	@FindAll({ @FindBy(xpath = "//div[text()='Enter Project Name']") })
	private WebElement btn_get_started;

	/* xpath of username text field */
	@FindAll({ @FindBy(xpath = "//input[@name='email']"), @FindBy(xpath = "//input[@id='email']") })
	private WebElement txt_email;

	/* xpath of password text field */
	@FindAll({ @FindBy(xpath = "//input[@name='password']"), @FindBy(xpath = "//input[@placeholder='Password']") })
	private WebElement txt_password;

	/* xpath for log in button */
	@FindAll({ @FindBy(xpath = "//button[@type='submit']") })
	private WebElement btn_login;

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
	 * log in to the Scada application
	 * @author Ankit
	 */
	public void logInToTheApplication(String username, String password) {
		// Enter the Project Name
		enterProjectName(Properties.getPropertyValue("Project_Name"));
		// enter username
		action.type(txt_email, "username", username);
		// enter password
		action.type(txt_password, "password", password);
		// click on login button
		action.clickOn(btn_login, "login");
	}

	/**
	 * With help of this message we can enter the project name and By clicking on
	 * get button we can Navigate to the login page
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
		return AwtUtilities.getTextUsingJavaScriptExecutor(driver, error_message);
	}

	/**
	 * this methods helps we can directly navigate to the login Page with outs
	 *
	 * @return
	 */
	public void navigateToAdminPage() {
		logInToTheApplication(PropertiesOperations.getPropertyValueByKey("SUPERADMIN_USERNAME"),
				PropertiesOperations.getPropertyValueByKey("SUPERADMIN_PASSWORD"));
	}

}
