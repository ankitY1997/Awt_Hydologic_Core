package com.awt.page.Admin.CreateProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
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
import com.awt.testbase.MyLogger;
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

	// ** For Finding A Rows In The Table **/
	@FindAll({ @FindBy(xpath = "//tr[@role='row' and @data-pc-section='row']") })
	private List<WebElement> numRowInTable;

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

	/**
	 * 
	 * To get the newly added project data as per specify column name
	 * 
	 * @param columnName
	 * @return String
	 */

	public String getColumnDataFromProjectDetailsTable(String columnName) {

		switch (columnName) {
		case "Project Name":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action
					.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
							+ numRowInTable.size() + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Client Name":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action
					.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
							+ numRowInTable.size() + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Consultant Name":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action
					.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
							+ numRowInTable.size() + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Start Date":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action
					.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
							+ numRowInTable.size() + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Actual End Date":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action
					.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
							+ numRowInTable.size() + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Due Days":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action
					.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
							+ numRowInTable.size() + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Module Name":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action
					.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
							+ numRowInTable.size() + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Mobile Number":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action
					.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
							+ numRowInTable.size() + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Email ID":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action
					.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
							+ numRowInTable.size() + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Username":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action
					.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
							+ numRowInTable.size() + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Passowrd":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action
					.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
							+ numRowInTable.size() + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		default:
			MyLogger.error(" You Have Passed Wrong Column " + columnName + " Please Enter The Correct Column Name");
			return null;
		}

	}
	/**
	 * To get the newly added projects data
	 */
	/*
	 * public String getColumnDataFromProjectDetailsTable(String columnName, String
	 * project_name) {
	 * 
	 * switch (columnName) { case "Project Name":
	 * action.waitForVisibility(numRowInTable.get(0), action.explicit_wait); return
	 * action.getText(driver.findElement(By.
	 * xpath("//tr[@role='row' and @data-pc-section='row'][" +
	 * getRowNumber(project_name) + "]/td[" +
	 * getColumnIndexNumber(columnName.trim()) + "]/span"))) .trim(); case
	 * "Client Name": action.waitForVisibility(numRowInTable.get(0),
	 * action.explicit_wait); return action.getText(driver.findElement(By.
	 * xpath("//tr[@role='row' and @data-pc-section='row'][" +
	 * getRowNumber(project_name) + "]/td[" +
	 * getColumnIndexNumber(columnName.trim()) + "]/span"))) .trim(); case
	 * "Consultant Name": action.waitForVisibility(numRowInTable.get(0),
	 * action.explicit_wait); return action.getText(driver.findElement(By.
	 * xpath("//tr[@role='row' and @data-pc-section='row'][" +
	 * getRowNumber(project_name) + "]/td[" +
	 * getColumnIndexNumber(columnName.trim()) + "]/span"))) .trim(); case
	 * "Start Date": action.waitForVisibility(numRowInTable.get(0),
	 * action.explicit_wait); return action.getText(driver.findElement(By.
	 * xpath("//tr[@role='row' and @data-pc-section='row'][" +
	 * getRowNumber(project_name) + "]/td[" +
	 * getColumnIndexNumber(columnName.trim()) + "]/span"))) .trim(); case
	 * "Actual End Date": action.waitForVisibility(numRowInTable.get(0),
	 * action.explicit_wait); return action.getText(driver.findElement(By.
	 * xpath("//tr[@role='row' and @data-pc-section='row'][" +
	 * getRowNumber(project_name) + "]/td[" +
	 * getColumnIndexNumber(columnName.trim()) + "]/span"))) .trim(); case
	 * "Due Days": action.waitForVisibility(numRowInTable.get(0),
	 * action.explicit_wait); return action.getText(driver.findElement(By.
	 * xpath("//tr[@role='row' and @data-pc-section='row'][" +
	 * getRowNumber(project_name) + "]/td[" +
	 * getColumnIndexNumber(columnName.trim()) + "]/span"))) .trim(); case
	 * "Module Name": action.waitForVisibility(numRowInTable.get(0),
	 * action.explicit_wait); return action.getText(driver.findElement(By.
	 * xpath("//tr[@role='row' and @data-pc-section='row'][" +
	 * getRowNumber(project_name) + "]/td[" +
	 * getColumnIndexNumber(columnName.trim()) + "]/span"))) .trim(); case
	 * "Mobile Number": action.waitForVisibility(numRowInTable.get(0),
	 * action.explicit_wait); return action.getText(driver.findElement(By.
	 * xpath("//tr[@role='row' and @data-pc-section='row'][" +
	 * getRowNumber(project_name) + "]/td[" +
	 * getColumnIndexNumber(columnName.trim()) + "]/span"))) .trim(); case
	 * "Email ID": action.waitForVisibility(numRowInTable.get(0),
	 * action.explicit_wait); return action.getText(driver.findElement(By.
	 * xpath("//tr[@role='row' and @data-pc-section='row'][" +
	 * getRowNumber(project_name) + "]/td[" +
	 * getColumnIndexNumber(columnName.trim()) + "]/span"))) .trim(); default:
	 * MyLogger.error(" You Have Passed Wrong Column " + columnName +
	 * " Please Enter The Correct Column Name"); return null; }
	 * 
	 * }
	 */

	/**
	 * To get the column index number by entering the column name
	 * 
	 * @param columnName
	 * @return
	 */
	public Integer getColumnIndexNumber(String columnName) {
		LinkedHashMap<String, Integer> columnIndexlist = new LinkedHashMap<String, Integer>();
		columnIndexlist.put("Project Name", 1);
		columnIndexlist.put("Client Name", 2);
		columnIndexlist.put("Client Logo", 3);
		columnIndexlist.put("Consultant Name", 4);
		columnIndexlist.put("Consultant Logo", 5);
		columnIndexlist.put("Start Date", 6);
		columnIndexlist.put("Actual End Date", 7);
		columnIndexlist.put("Due Days", 8);
		columnIndexlist.put("Module Name", 9);
		columnIndexlist.put("Mobile Number", 10);
		columnIndexlist.put("Email ID", 11);
		return columnIndexlist.get(columnName);

	}

	/**
	 * Get the Created Project Row Number From Awt Project Details Table
	 * 
	 * @param projectName
	 * @return
	 */
	public Integer getRowNumber(String projectName) {

		int rowNum = 0;
		for (int i = 0; i < numRowInTable.size(); i++) {

			String actual_column_row = action.getText(driver
					.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row'][" + (i + 1) + "]/td[1]")));
			if (projectName.contains(actual_column_row.trim())) {
				rowNum = i + 1;
			}

		}
		return rowNum;
	}

	/**
	 * By help of this method we can delete the project details
	 * 
	 * @param projectName { We Need To Enter The Project Name Which Project You Want
	 *                    To Delete
	 */
	public void deleteProjectDetails(String projectName) {
		WebElement delete_button = driver.findElement(By.xpath(
				"//tr[@data-pc-section='row'][" + getRowNumber(projectName) + "]//*[@data-pr-tooltip='Delete']"));
		action.performMoveToElement(delete_button);
		action.clickOn(delete_button);
	}

}
