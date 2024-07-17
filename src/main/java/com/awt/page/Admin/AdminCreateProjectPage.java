package com.awt.page.Admin;

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
	 * By help of this method we can enter the project details while creating a
	 * project details
	 * 
	 * @param project_name
	 * @param client_name
	 * @param consultant_name
	 * @param license_key
	 * @param username
	 * @param password
	 * @param module_name
	 * @param mob_num
	 * @param email_add
	 * @param start_date
	 * @param expected_date
	 * @param actual_completion_date
	 * @author Ankit Yadav
	 * 
	 */
	public void fillProjectDetails(String project_name, String client_name, String consultant_name, String license_key,
			String username, String password, String[] module_name, String mob_num, String email_add, String start_date,
			String expected_date, String actual_completion_date) {

		try {
			// enter the project name
			action.type(project_name_txt, "Project Name", project_name);
			// enter the client name
			action.type(client_name_txt, "Client Name", client_name);
			// enter the consultant name
			action.type(consultant_name_txt, "Consultant Name", consultant_name);
			// enter the Licenses Key
			action.type(license_key_txt, "License Key", license_key);
			// enter the User Name
			action.type(username_txt, "Username", username);
			// enter the Password
			action.type(password_txt, "Password", password);

		} catch (Exception e) {

		}

	}

	/**
	 * This Method Is Specially Design to Select Date From Any Calendar
	 * 
	 * @param exp_date {Syntax : "dd-Mmm-YYYY"}
	 * @exception Date_Format_Exception { Providing a Wrong Syntax }
	 * @author Ankit yadav
	 */
	public void datePicker(String exp_date) {
		try {
			if (exp_date.contains("-")) {
				String[] date = exp_date.split("-");
				// *************Expected Date ************/
				String exp_day = date[0];
				String exp_month = date[1];
				String exp_year = date[2];

				// *************Acutal Date In Calendar***********//
				String act_month = action.getText(month_title).trim();
				String act_year = action.getText(year_title).trim();

				boolean isSameYear = false;
				boolean isSameMonth = false;

				// if expected year greater than actual year
				if (Integer.parseInt(exp_year) > Integer.parseInt(act_year)) {
					// click on forward for reach a correct year
					while (true) {
						action.implicitWait(next_button, 5);
						next_button.click();
						if (Integer.parseInt(exp_year) == Integer.parseInt(act_year)) {
							isSameYear = true;
							break;
						}
					}
					// after getting a same year we have to select month
					if (isSameYear) {
						// if the expected month is same as by default visible month then we can
						// directly select the date
						if (exp_month.equalsIgnoreCase(act_month)) {

							action.clickOn(driver.findElement(By.xpath("//td[@data-pc-section='day']/span[text()='"
									+ exp_day + "' and not(@class='p-disabled')]")));
						}
						// if the expected month is not same as by default visible month then we have to
						// select expected month
						// then we have to select the date
						else if (!exp_month.equalsIgnoreCase(act_month)) {
							action.clickOn(month_title);
							action.clickOn(driver.findElement(By
									.xpath("//div[@data-pc-section='monthpicker']/span[text()='" + exp_month + "']")));
							action.clickOn(driver.findElement(By.xpath("//td[@data-pc-section='day']/span[text()='"
									+ exp_day + "' and not(@class='p-disabled')]")));
						}
					}

					// if expected year less than actual year
				} else if (Integer.parseInt(exp_year) < Integer.parseInt(act_year)) {
					// click on backward button untill you will reach In correct year
					while (true) {
						action.implicitWait(previous_button, 5);
						previous_button.click();
						if (Integer.parseInt(exp_year) == Integer.parseInt(act_year)) {
							isSameYear = true;
							break;
						}
					}
					// after getting a same year we have to select month
					if (isSameYear) {
						// if the expected month is same in calendar by defult visible month then we can
						// directly select the date
						if (exp_month.equalsIgnoreCase(act_month)) {
							action.clickOn(driver.findElement(By.xpath("//td[@data-pc-section='day']/span[text()='"
									+ exp_day + "' and not(@class='p-disabled')]")));
						}
						// if the expected month is not same in calendar by default month then we have
						// to select expected month
						// then we have to select the date
						else if (!exp_month.equalsIgnoreCase(act_month)) {
							action.clickOn(month_title);
							action.clickOn(driver.findElement(By
									.xpath("//div[@data-pc-section='monthpicker']/span[text()='" + exp_month + "']")));
							action.clickOn(driver.findElement(By.xpath("//td[@data-pc-section='day']/span[text()='"
									+ exp_day + "' and not(@class='p-disabled')]")));
						}
					}
					// if the expected year is equal to by default visible year in the calendar then
					// we can directly select a month
				} else if (Integer.parseInt(exp_year) == Integer.parseInt(act_year)) {
					// if the expected month is equal to by default visible month so we can directly
					// chose the date
					if (exp_month.equalsIgnoreCase(act_month)) {
						action.clickOn(driver.findElement(By.xpath("//td[@data-pc-section='day']/span[text()='"
								+ exp_day + "' and not(@class='p-disabled')]")));
					}
					// it it expected month is not equal to the by default month in calendar so
					// first we have to click on the correct month then after we have to select date
					else if (!exp_month.equalsIgnoreCase(act_month)) {
						action.clickOn(month_title);
						action.clickOn(driver.findElement(
								By.xpath("//div[@data-pc-section='monthpicker']/span[text()='" + exp_month + "']")));
						action.clickOn(driver.findElement(By.xpath("//td[@data-pc-section='day']/span[text()='"
								+ exp_day + "' and not(@class='p-disabled')]")));
					}
				}
			} else {
				throw new Date_Format_Exception("Please Pass The Correct Date Format Correct Syntax Is : DD-Mmm-YYYY ");
			}
		} catch (Exception e) {
			action.logFail("Failed To Select The Date", e);
		}

	}

	public void selectModuleName(String[] module_name) {
		// wait for some time
		action.implictWait(action.implicit_wait);
		try {
			for (String Module_name : module_name) {
				if (!Module_name.equalsIgnoreCase("All")) {
					// click on Module Name Drop-Down
					action.clickOn(
							driver.findElement(By.xpath("//input[@role='textbox' and @data-pc-name='inputtext']")));
					// clear the Module Name Search Box
					driver.findElement(By.xpath("//input[@role='textbox' and @data-pc-name='inputtext']")).clear();
					// Enter the Module Name
					driver.findElement(By.xpath("//input[@role='textbox' and @data-pc-name='inputtext']"))
							.sendKeys(Module_name);
					// select the Module Name
					action.clickOn(driver.findElement(
							By.xpath("//input[@type='checkbox']/../following-sibling::div[@data-pc-section='input']")));
				} else if (Module_name.equalsIgnoreCase("All")) {
					// clear the Module Name Search Box
					driver.findElement(By.xpath("//input[@role='textbox' and @data-pc-name='inputtext']")).clear();
					// Select All Module Name
					action.clickOn(driver.findElement(
							By.xpath("//input[@type='checkbox']/../following-sibling::div[@data-pc-section='input']")));
				}
			}
		} catch (Exception e) {
			action.logFail("Unable To Select Module Due To This Exception ", e);
		}
	}

}
