package com.awt.page.User.AdminConfiguration.User.CreateRole;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.awt.page.User.AdminConfiguration.AdminPage;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class AdminAddRolePage extends AdminPage {

	// ********New Button**********/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='New']") })
	public WebElement new_button;

	// ********Role Details Table Columns Name**********/
	@FindAll({ @FindBy(xpath = "//tr[@data-pc-section='headerrow']/th/div/span") })
	public List<WebElement> column_names;

	// ********Total Number of ROw In The Table**********/
	@FindAll({ @FindBy(xpath = "//tbody[@data-pc-section='tbody']/tr") })
	public List<WebElement> number_of_row;

	// ** First Pagination Button****/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Go to first page']") })
	public WebElement first_page;

	// ** Previous Pagination Button****/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Go to previous page']") })
	public WebElement previous_page;

	// ** Last Pagination Button****/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Go to last page']") })
	public WebElement last_page;

	// ** Last Pagination Button****/
	@FindAll({ @FindBy(xpath = "//button[@title='Go to next page']") })
	public WebElement next_page;

	// ** Enable Next Pagination Button ****/
	@FindAll({ @FindBy(xpath = "//button[@title='Go to next page'and @tabindex='0']") })
	public WebElement enable_next_page;

	// ** Delete Button****/
	@FindAll({ @FindBy(xpath = "//button[@title='Delete'][1]") })
	public WebElement delete_button;

	// ****Edit Button*****/
	@FindAll({ @FindBy(xpath = "//button[@title='Edit'][1]") })
	public WebElement edit_button;

	// ******Update Button*******/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Update']") })
	public WebElement update_button;

	// ******yes Button*******/
	@FindAll({ @FindBy(xpath = "//span[text()='Yes']") })
	public WebElement yes_button;

	// ******No Button*******/
	@FindAll({ @FindBy(xpath = "//span[text()='No']") })
	public WebElement No_button;

	// ******Rows per page Drop-Down button*******/
	@FindAll({ @FindBy(xpath = "//div[@role='combobox']") })
	public WebElement rows_per_page_drop_down_button;

	// **Constructor**/
	public AdminAddRolePage(WebDriver driver) {
		// call AdminPage Constructor
		super(driver);

	}

	/**
	 * By This Method We Can Click On New Button
	 */
	public AddNewRolePanel clickOnNewButtonAndNavigateToAddNewRolePanel() {
		action.clickOn(new_button);
		return new AddNewRolePanel(driver);
	}

	/***
	 * This Method Is Used To Check New Button Is Visible Or Not
	 */
	public boolean isNewButtonIsVisible() {
		action.waitForVisibility(new_button, action.implicit_wait);
		return action.isDisplay(new_button);
	}

	/**
	 * This Method Is Used To Check Edit Button Is Visible Or Not
	 * 
	 * @return
	 */
	public boolean isEditButtonIsVisible() {
		action.waitForVisibility(edit_button, action.implicit_wait);
		return action.isDisplay(edit_button);
	}

	/**
	 * This Method Is Used To Check Delete Button Is Visible Or Not
	 * 
	 * @return
	 */
	public boolean isDeleteButtonIsVisible() {
		action.waitForVisibility(delete_button, action.implicit_wait);
		return action.isDisplay(delete_button);
	}

	/**
	 * This Method Is Used To first pagination button Is Visible Or Not
	 * 
	 * @return
	 */
	public boolean isFirstPaginationButtonIsVisible() {
		action.waitForVisibility(first_page, action.implicit_wait);
		return action.isDisplay(first_page);
	}

	/**
	 * This Method Is Used To next pagination button Is Visible Or Not
	 * 
	 * @return
	 */
	public boolean isNextPaginationButtonIsVisible() {
		action.waitForVisibility(next_page, action.implicit_wait);
		return action.isDisplay(next_page);
	}

	/**
	 * This Method Is Used To previous pagination button Is Visible Or Not
	 * 
	 * @return
	 */
	public boolean isPreviousPaginationButtonIsVisible() {
		action.waitForVisibility(previous_page, action.implicit_wait);
		return action.isDisplay(previous_page);
	}

	/**
	 * This Method Is Used To last pagination button Is Visible Or Not
	 * 
	 * @return
	 */
	public boolean isLastPaginationButtonIsVisible() {
		action.waitForVisibility(last_page, action.implicit_wait);
		return action.isDisplay(last_page);
	}

	/**
	 * This Method Is Used To Rows Per Page Drop Down Button Is Visible Or Not
	 * 
	 * @return
	 */
	public boolean isRowsPerPageDropDownIsVisible() {
		action.waitForVisibility(rows_per_page_drop_down_button, action.implicit_wait);
		return action.isDisplay(rows_per_page_drop_down_button);
	}

	/**
	 * By This Method We Can Get Role Details Table Value as per given column name
	 * and project name
	 * 
	 * @param columnName
	 * @param projectName
	 * @return
	 */
	public String getRoleDetailTableValue(String columnName, String roleName) {
		String value = " ";
		try {
			switch (columnName) {
			case "Role Name":
				action.waitForVisibility(
						driver.findElement(
								By.xpath("//tr[@role='row' and @data-pc-section='row'][" + getRoleNameRowNumber(roleName)
										+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")),
						action.implicit_wait);
				value = action.getText(driver.findElement(
						By.xpath("//tr[@role='row' and @data-pc-section='row'][" + getRoleNameRowNumber(roleName)
								+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")));
				break;
			case "Role Description":
				action.waitForVisibility(
						driver.findElement(
								By.xpath("//tr[@role='row' and @data-pc-section='row'][" + getRoleNameRowNumber(roleName)
										+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")),
						action.implicit_wait);
				value = action.getText(driver.findElement(
						By.xpath("//tr[@role='row' and @data-pc-section='row'][" + getRoleNameRowNumber(roleName)
								+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")));
				break;
			case "SNO":
				System.out.println("NO VALUES FOR SERAIL COLUMN");
				break;
			case "Action":
				System.out.println("NO VALUES FOR Action COLUMN");
				;
				break;
			default:
				MyLogger.getCurrentLog().info("PLEASE PASS THE CORRECT COLUMN NAME :" + columnName);
				break;
			}
		} catch (Exception e) {
			value = "";
		}
		return value.trim();
	}

	/**
	 * This Method Is Used To Click On Delete button With Help Of Entered Project
	 * Name
	 * 
	 * @param projectName
	 */
	public void clickOnDeleteButton(String projectName) {
		action.waitForVisibility(
				driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
						+ getRoleNameRowNumber(projectName) + "]/td/div/button[@title='Delete']")),
				action.implicit_wait);
		action.clickOn(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
				+ getRoleNameRowNumber(projectName) + "]/td/div/button[@title='Delete']")));
		clickOnYesButton();
	}

	/**
	 * Click On yes Button
	 */
	public void clickOnYesButton() {
		action.waitForVisibility(yes_button, action.implicit_wait);
		action.clickOn(yes_button);
		AwtUtilities.waitFor(2000);
	}

	/**
	 * This Method Is Used To Click On Delete button With Help Of Entered Project
	 * Name
	 * 
	 * @param projectName
	 */
	public void clickOnEditButton(String projectName) {
		action.waitForVisibility(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
				+ getRoleNameRowNumber(projectName) + "]/td/div/button[@title='Edit']")), action.implicit_wait);
		action.clickOn(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
				+ getRoleNameRowNumber(projectName) + "]/td/div/button[@title='Edit']")));
	}

	/**
	 * By This Method We Can Get The Role Details Header Column Index Number
	 * 
	 * @param projectName
	 * @return
	 */
	public Integer getRoleDetailsColumnIndexNumber(String roleName) {
		LinkedHashMap<String, Integer> columnIndexNum = new LinkedHashMap<String, Integer>();
		columnIndexNum.put("SNO", 1);
		columnIndexNum.put("Role Name", 2);
		columnIndexNum.put("Role Description", 3);
		columnIndexNum.put("Action", 4);
		return columnIndexNum.get(roleName);
	}

	/**
	 * By This Method We Can Get The Row number of entered Project Name
	 * 
	 * @param project_name
	 * @return
	 */
	public int getRoleNameRowNumber(String roleName) {
		int rowIndexNum = 0;
		boolean flag = false;
		while (flag == false) {
			AwtUtilities.waitFor(2000);
			List<WebElement> projectNames = driver
					.findElements(By.xpath("//tr[@role='row' and @data-pc-section='row']/td[2]"));

			for (int i = 0; i < projectNames.size(); i++) {
				String projectName = projectNames.get(i).getText().trim();
				if (projectName.equalsIgnoreCase(roleName)) {
					flag = true;
					rowIndexNum = i + 1;
					break;
				}
			}
			if (flag == false) {
				// click on next page
				try {
					action.performMoveToElement(enable_next_page);
					enable_next_page.click();
					AwtUtilities.waitFor(1000);
				} catch (Exception e) {
					break;
				}
			}

		}
		return rowIndexNum;
	}

	/**
	 * By This Help We Can Get All The Column Names In Role Details Table
	 * 
	 * @return
	 */
	public List<String> listOfRoleDetailsTableColumns() {
		List<String> column_name = new ArrayList<String>();
		for (WebElement columName : column_names) {
			column_name.add(columName.getText().trim());
		}
		return column_name;
	}

	/**
	 * To Click On Update Button
	 */
	public void clickOnUpdateButton() {
		action.waitForVisibility(update_button, action.implicit_wait);
		action.clickOn(update_button);
	}

	/**
	 * By This Method We Can Select Rows Per Page Drop-Down Number
	 * 
	 */
	public void selectRowPerPage(String numOfPage) {
		// click on Rows Per Page Drop Down button
		action.clickOn(rows_per_page_drop_down_button);
		if (Integer.parseInt(numOfPage) <= 40 && (Integer.parseInt(numOfPage) % 5) == 0) {
			action.waitForVisibility(
					driver.findElement(By.xpath("//ul[@role='listbox']/li[@data-value='" + numOfPage + "']")),
					action.implicit_wait);
			action.clickOn(driver.findElement(By.xpath("//ul[@role='listbox']/li[@data-value='" + numOfPage + "']")));
		}
	}

	/**
	 * 
	 * @param numOfPage
	 */
	public boolean isUpdateTheTable(String numOfPage) {
		AwtUtilities.waitFor(1000);
		// Take The Number Of Row In The Table
		int before_TotalRowInTable = number_of_row.size();
		// select The Number Of Page
		selectRowPerPage(numOfPage);
		// After Row In The Table
		AwtUtilities.waitFor(1000);
		int after_TotalRowInTable = number_of_row.size();
		boolean flag = (after_TotalRowInTable > before_TotalRowInTable) ? true : false;
		return flag;
	}

}
