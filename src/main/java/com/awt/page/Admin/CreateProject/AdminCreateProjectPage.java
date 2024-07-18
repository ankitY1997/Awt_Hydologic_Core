package com.awt.page.Admin.CreateProject;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.awt.testbase.ExtentFactory;
import com.awt.utills.exceptions.Date_Format_Exception;
import com.awt.utills.reusablecomponents.ActionEngine;

public class AdminCreateProjectPage {

	// ** Create Project button xpath **/
	@FindAll({ @FindBy(xpath = "//span[text()='Create Project']") })
	private WebElement crate_project_btn;

	// **Project Name text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='project_name']") })
	private WebElement project_name_txt;

	// **client Name text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='client_name']") })
	private WebElement client_name_txt;

	// **consultant Name text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='consultant_name']") })
	private WebElement consultant_name_txt;

	// **license key text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='license_key']") })
	private WebElement license_key_txt;

	// **username text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='user_name']") })
	private WebElement username_txt;

	// **password text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='password']") })
	private WebElement password_txt;

	// **mobile number text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='mobile_number']") })
	private WebElement mobile_number_txt;

	// **email address text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='email_address']") })
	private WebElement email_add_txt;

	// **Module Name Button xpath**/
	@FindAll({ @FindBy(xpath = "//div[text()='Select Modules']") })
	private WebElement module_name;

	// **In calendar month title xpath**/
	@FindAll({ @FindBy(xpath = "//button[@data-pc-section='monthtitle']") })
	private WebElement month_title;

	// **In calendar year title xpath**/
	@FindAll({ @FindBy(xpath = "//button[@data-pc-section='yeartitle']") })
	private WebElement year_title;

	// **In calendar next button xpath**/
	@FindAll({ @FindBy(xpath = "//button[@data-pc-section='nextbutton']") })
	private WebElement next_button;

	// **In calendar previous button xpath**/
	@FindAll({ @FindBy(xpath = "//button[@data-pc-section='previousbutton']") })
	private WebElement previous_button;

	// ** Action Engine instance variable **//
	private ActionEngine action;

	// **WebDriver instance variable **//
	private WebDriver driver;

	/**
	 * constructor for initializing page objects
	 * 
	 * @author Ankit Yadav
	 */
	public AdminCreateProjectPage(WebDriver driver) {
		this.driver = driver;
		// ActionEngine class objects
		action = new ActionEngine(driver);
		// PageFactory Methods to initialize the Admin Page Web Element
		PageFactory.initElements(driver, this);
	}

	/***
	 * By this method we can click on the "Create Project" button
	 * 
	 * @author ankit
	 * 
	 */
	public void clickOnCreateProject() {
		// click on the "Create Project button
		action.clickOn(crate_project_btn, "Create Project");
	}

	/**
	 * Navigate to new project details panel
	 * 
	 * 
	 * @return
	 */
	public NewProjectDetailsPanel clickCreateProjectButtonAndNavigateToNewProjectDetailPanel() {
		action.implictWait(action.implicit_wait);
		// click on create project button
		clickOnCreateProject();
		return new NewProjectDetailsPanel(driver);
	}

	/**
	 * To check the visiblity of create project button
	 */
	public boolean isCreateProjectButtonDispaly() {
		action.implicitWait(crate_project_btn, action.implicit_wait);
		return action.isDisplay(crate_project_btn);
	}

}
