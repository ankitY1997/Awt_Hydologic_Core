package com.awt.page.Admin.Project.ProjectSettings;

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
import com.awt.utills.reusablecomponents.AwtUtilities;

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

	// **In calendar previous button xpath**/
	@FindAll({ @FindBy(xpath = "//h5[text()='AWT - Projects']") })
	private WebElement table_name;

	/** All Columns Name Under Awt Project Table ********/
	@FindAll({ @FindBy(xpath = "//tr[@role='row']/th/div/span") })
	private List<WebElement> columnNames;

	// ** For Finding A Rows In The Table **/
	@FindAll({ @FindBy(xpath = "//tr[@role='row' and @data-pc-section='row']") })
	private List<WebElement> numRowInTable;

	// ** Get All Projects Name From The Table****/
	@FindAll({ @FindBy(xpath = "//tr[@role='row' and @data-pc-section='row']/td[1]/span") })
	private List<WebElement> projectsName;

	// *** Edit Button****/
	@FindAll({ @FindBy(xpath = "//button[@data-pr-tooltip='Edit']") })
	private WebElement edit_button;

	// *****Delete Button****/
	@FindAll({ @FindBy(xpath = "//button[@data-pr-tooltip='Delete']") })
	private WebElement delete_button;

	/** xpath of Project Created Sucessfully pop-up *****/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Yes']") })
	private WebElement accept_popup;

	// *****upload Button****/
	@FindAll({ @FindBy(xpath = "//button[@data-pr-tooltip='Attach Document']") })
	private WebElement upload_button;

	// *****upload Button****/
	@FindAll({ @FindBy(xpath = "//button[@data-pr-tooltip='Device Configuration']") })
	private WebElement device_config_button;

	// *****upload Button****/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Update Project']") })
	private WebElement update_button;

	// *****first page Button****/
	@FindAll({ @FindBy(xpath = "//button[@data-pc-section='firstpagebutton']//*[local-name()='svg']") })
	private WebElement first_page_button;

	// *****previous page Button****/
	@FindAll({ @FindBy(xpath = "//button[@data-pc-section='prevpagebutton']//*[local-name()='svg']") })
	private WebElement previous_page_button;

	// *****next page Button****/
	@FindAll({ @FindBy(xpath = "//button[@data-pc-section='nextpagebutton']//*[local-name()='svg']") })
	private WebElement next_page_button;

	// *****Last page Button****/
	@FindAll({ @FindBy(xpath = "//button[@data-pc-section='lastpagebutton']//*[local-name()='svg']") })
	private WebElement last_page_button;

	// ** Next Pagination Button*****/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Next Page' and not(@disabled)]") })
	private WebElement enable_next_page_button;

	// ** Rows Per Page Drop Down Button*****/
	@FindAll({
			@FindBy(xpath = "//div[@aria-haspopup='listbox']//*[local-name()='svg' and @data-pc-section='dropdownicon']") })
	private WebElement rows_per_page_drop_down;

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

	// constructor
	public AdminCreateProjectPage() {
		// nothing
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
	 * To check the visibility of awt projects table
	 * 
	 * @return
	 */
	public boolean isTableNameDisplay() {
		action.waitForVisibility(table_name, action.implicit_wait);
		return table_name.isDisplayed();
	}

	/**
	 * To check the visibility of rows per page drop-down button
	 * 
	 * @return
	 */
	public boolean isRowsPerPageDropdownDisplay() {
		action.waitForVisibility(rows_per_page_drop_down, action.implicit_wait);
		return rows_per_page_drop_down.isDisplayed();
	}

	/**
	 * To check the visibility of first pagination button
	 * 
	 * @return
	 */
	public boolean isFirstPaginationButtonVisible() {
		action.waitForVisibility(first_page_button, action.implicit_wait);
		return first_page_button.isDisplayed();
	}

	/**
	 * To check the visibility of previous pagination button
	 * 
	 * @return
	 */
	public boolean isPreviousPaginationButtonVisible() {
		action.waitForVisibility(previous_page_button, action.implicit_wait);
		return previous_page_button.isDisplayed();
	}

	/**
	 * To check the visibility of next pagination button
	 * 
	 * @return
	 */
	public boolean isNextPaginationButtonVisible() {
		action.waitForVisibility(last_page_button, action.implicit_wait);
		return next_page_button.isDisplayed();
	}

	/**
	 * To check the visibility of last pagination button
	 * 
	 * @return
	 */
	public boolean isLastPaginationButtonVisible() {
		action.waitForVisibility(last_page_button, action.implicit_wait);
		return last_page_button.isDisplayed();
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
			action.performMoveToElement(numRowInTable.get(numRowInTable.size() - 1));
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
//		case "Expected Date":
//			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
//			return action
//					.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
//							+ numRowInTable.size() + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
//					.trim();
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
//		case "Username":
//			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
//			return action
//					.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
//							+ numRowInTable.size() + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
//					.trim();
//		case "Passowrd":
//			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
//			return action
//					.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
//							+ numRowInTable.size() + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
//					.trim();
		default:
			MyLogger.error(
					" You Have Passed Wrong Column Name : " + columnName + " Please Enter The Correct Column Name");
			return null;
		}

	}

	/**
	 * By THis Method We Can Fetch The Column Data Accroding to column wise
	 */

	public String getColumnDataFromProjectDetailsTable(String project_name, String columnName) {
		switch (columnName) {
		case "Project Name":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
					+ getRowNumber(project_name) + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Client Name":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
					+ getRowNumber(project_name) + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Consultant Name":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
					+ getRowNumber(project_name) + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Start Date":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
					+ getRowNumber(project_name) + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Actual End Date":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
					+ getRowNumber(project_name) + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Due Days":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
					+ getRowNumber(project_name) + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Module Name":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
					+ getRowNumber(project_name) + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Mobile Number":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
					+ getRowNumber(project_name) + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		case "Email ID":
			action.waitForVisibility(numRowInTable.get(0), action.explicit_wait);
			return action.getText(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
					+ getRowNumber(project_name) + "]/td[" + getColumnIndexNumber(columnName.trim()) + "]/span")))
					.trim();
		default:
			MyLogger.error(" You Have Passed Wrong Column " + columnName + " Please Enter The Correct Column Name");
			return null;
		}

	}

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

//	/**
//	 * Get the Created Project Row Number From Awt Project Details Table
//	 * 
//	 * @param projectName
//	 * @return
//	 * @deprecated
//	 */
//	public Integer getRowNumber(String projectName) {
//
//		int rowNum = 0;
//		for (int i = 0; i < numRowInTable.size(); i++) {
//
//			String actual_column_row = action.getText(driver
//					.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row'][" + (i + 1) + "]/td[1]")));
//			if (projectName.contains(actual_column_row.trim())) {
//				rowNum = i + 1;
//			}
//
//		}
//		return rowNum;
//	}

	/**
	 * By This Method We Can Get The Row number of entered Project Name
	 * 
	 * @param project_name
	 * @return
	 */
	public int getRowNumber(String projectName) {
		int rowIndexNum = 0;
		boolean flag = false;
		while (flag == false) {
			AwtUtilities.waitFor(2000);
			List<WebElement> projectNames = driver
					.findElements(By.xpath("//tr[@role='row' and @data-pc-section='row']/td[1]"));

			for (int i = 0; i < projectNames.size(); i++) {
				String project_name = projectNames.get(i).getText().trim();
				if (project_name.equalsIgnoreCase(projectName)) {
					flag = true;
					rowIndexNum = i + 1;
					break;
				}
			}
			if (flag == false) {
				// click on next page
				try {
					enable_next_page_button.click();
					AwtUtilities.waitFor(1000);
				} catch (Exception e) {
					break;
				}
			}

		}
		return rowIndexNum;
	}

	/**
	 * By help of this method we can delete the project details
	 * 
	 * @param projectName { We Need To Enter The Project Name Which Project You Want
	 *                    To Delete
	 */
	public void deleteProjectDetails(String projectName) {
		try {
			WebElement delete_button = driver.findElement(By.xpath(
					"//tr[@data-pc-section='row'][" + getRowNumber(projectName) + "]//*[@data-pr-tooltip='Delete']"));
			action.performMoveToElement(delete_button);
			action.clickOn(delete_button);
		} catch (Exception e) {
			// do nothing
		}
	}

	/**
	 * By help of this method we can edit the project details
	 * 
	 * @param projectName { We Need To Enter The Project Name Which Project You Want
	 *                    To edit
	 */
	public void editProjectDetails(String projectName) {
		try {
			WebElement edit_button = driver.findElement(By.xpath(
					"//tr[@data-pc-section='row'][" + getRowNumber(projectName) + "]//*[@data-pr-tooltip='Edit']"));
			action.performMoveToElement(edit_button);
			action.clickOn(edit_button);
		} catch (Exception e) {
			// do nothing
		}
	}

	/**
	 * To get the column names of AWT Projects Table
	 * 
	 * @return list of column name
	 */
	public List<String> getAllAwtProjectColumsName() {
		action.waitForVisibility(columnNames.get(0), action.implicit_wait);
		List<String> column_list = new ArrayList<String>();
		for (WebElement element : columnNames) {
			column_list.add(element.getText().trim());
		}
		return column_list;
	}

	/**
	 * To Check The Project Name is Visible
	 * 
	 * @param project_name {pass the project name}
	 * @return {if project name is visible in the table so it return true
	 */
	public boolean isProjectNameVIsibleInTable(String project_name) {

		boolean flag = false;
		for (WebElement projectName : projectsName) {
			System.out.println();
			action.waitForVisibility(projectName, action.implicit_wait);
			if (projectName.getText().trim().contains(project_name)) {
				flag = true;
			}
		}
		return flag;

	}

	/**
	 * By Help Of THis Method we Can check Edit Button Should be visible
	 * 
	 * @return
	 */
	public boolean isEditButtonVisible() {
		try {
			return action.isDisplay(edit_button);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * By Help Of THis Method we Can check Delete Button Should be visible
	 * 
	 * @return
	 */
	public boolean isDeleteButtonVisible() {
		try {
			return action.isDisplay(delete_button);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * By Help Of THis Method we Can check upload Button Should be visible
	 * 
	 * @return
	 */
	public boolean isUploadButtonVisible() {
		try {
			return action.isDisplay(upload_button);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * By Help Of THis Method we Can check device_config Button Should be visible
	 * 
	 * @return
	 */
	public boolean isDeviceConfigdButtonVisible() {
		try {
			return action.isDisplay(device_config_button);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * By Help Of This Method We Can Click On Update Button
	 */
	public void clickOnUpdateProjectButton() {
		action.clickOn(update_button);
	}

	/**
	 * To accept pop up
	 */
	public void acceptPopup() {
		action.waitForVisibility(accept_popup, action.implicit_wait);
		action.clickOn(accept_popup);
	}
}
