package com.awt.page.Irrigation.Admin.User.CreateUser;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.awt.page.Irrigation.Admin.AdminDashboardPage;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class AdminAddUserPage extends AdminDashboardPage{
	// ********New Button**********/
		@FindAll({ @FindBy(xpath = "//button[@aria-label='New']") })
		public WebElement new_button;

		// ** Enable Next Pagination Button ****/
		@FindAll({ @FindBy(xpath = "//button[@title='Go to next page'and @tabindex='0']") })
		public WebElement enable_next_page;

		// ** USER DETAILS TABLES COLUMN NAMES ****/
		@FindAll({ @FindBy(xpath = "//th[@role='columnheader']/div/span[not(@data-pc-section='sort')]") })
		public List<WebElement> userDetailsColumnNames;

		// ******Update Button*******/
		@FindAll({ @FindBy(xpath = "//button[@aria-label='Update']") })
		public WebElement update_button;

		// ******yes Button*******/
		@FindAll({ @FindBy(xpath = "//button[@aria-label='Confirm']") })
		public WebElement yes_button;

		// ** Delete Button****/
		@FindAll({ @FindBy(xpath = "//button[@aria-label='Delete'][1]") })
		public WebElement delete_button;

		// ****Edit Button*****/
		@FindAll({ @FindBy(xpath = "//button[@aria-label='Edit'][1]") })
		public WebElement edit_button;

		/**
		 * Constructor
		 * 
		 * @param driver
		 */
		public AdminAddUserPage(WebDriver driver) {
			super(driver);
		}

		/**
		 * By This Method We Can Click On New Button
		 */
		public AddUserPanel clickOnNewButtonAndNavigateToAddUserPanel() {
			action.clickOn(new_button);
			return new AddUserPanel(driver);
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


		/***
		 * This Method Is Used To click on update button
		 */
		public void clickOnUpdateButton() {
			action.waitForVisibility(update_button, action.implicit_wait);
			action.clickOn(update_button);
		}

		/**
		 * Get All User Details Table COlumn Names
		 * 
		 * @return list of column name
		 */
		public List<String> getUserDetailsTableColumnNames() {

			action.waitForVisibility(userDetailsColumnNames.get(0), action.implicit_wait);
			List<String> columnNames = new ArrayList<String>();
			for (WebElement name : userDetailsColumnNames) {
				columnNames.add(name.getText().trim());
			}
			return columnNames;

		}

		/**
		 * By This Method We Can Get Role Details Table Value as per given column name
		 * and project name
		 * 
		 * @param columnName
		 * @param projectName
		 * @return
		 */
		public String getUserDetailTableValue(String columnName, String userName) {
			AwtUtilities.waitFor(500);
			String value = " ";
			try {
				switch (columnName) {
				case "Name":
					action.waitForVisibility(
							driver.findElement(By
									.xpath("//tr[@role='row' and @data-pc-section='row'][" + getUserNameRowNumber(userName)
											+ "]/td[" + getUserDetailsColumnIndexNumber(columnName) + "]")),
							action.implicit_wait);
					value = action.getText(driver.findElement(
							By.xpath("//tr[@role='row' and @data-pc-section='row'][" + getUserNameRowNumber(userName)
									+ "]/td[" + getUserDetailsColumnIndexNumber(columnName) + "]")));
					break;
				case "Username":
					action.waitForVisibility(
							driver.findElement(By
									.xpath("//tr[@role='row' and @data-pc-section='row'][" + getUserNameRowNumber(userName)
											+ "]/td[" + getUserDetailsColumnIndexNumber(columnName) + "]")),
							action.implicit_wait);
					value = action.getText(driver.findElement(
							By.xpath("//tr[@role='row' and @data-pc-section='row'][" + getUserNameRowNumber(userName)
									+ "]/td[" + getUserDetailsColumnIndexNumber(columnName) + "]")));
					break;
				case "Email":
					action.waitForVisibility(
							driver.findElement(By
									.xpath("//tr[@role='row' and @data-pc-section='row'][" + getUserNameRowNumber(userName)
											+ "]/td[" + getUserDetailsColumnIndexNumber(columnName) + "]")),
							action.implicit_wait);
					value = action.getText(driver.findElement(
							By.xpath("//tr[@role='row' and @data-pc-section='row'][" + getUserNameRowNumber(userName)
									+ "]/td[" + getUserDetailsColumnIndexNumber(columnName) + "]")));
					break;

				case "Role Name":
					action.waitForVisibility(
							driver.findElement(By
									.xpath("//tr[@role='row' and @data-pc-section='row'][" + getUserNameRowNumber(userName)
											+ "]/td[" + getUserDetailsColumnIndexNumber(columnName) + "]")),
							action.implicit_wait);
					value = action.getText(driver.findElement(
							By.xpath("//tr[@role='row' and @data-pc-section='row'][" + getUserNameRowNumber(userName)
									+ "]/td[" + getUserDetailsColumnIndexNumber(columnName) + "]")));
					break;
				case "SNO":
					System.out.println("NO VALUES FOR SERAIL COLUMN");
					break;
				case "Action":
					System.out.println("NO VALUES FOR Action COLUMN");
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
		 * By This Method We Can Get The Role Details Header Column Index Number
		 * 
		 * @param projectName
		 * @return
		 */
		public Integer getUserDetailsColumnIndexNumber(String columnName) {
			LinkedHashMap<String, Integer> columnIndexNum = new LinkedHashMap<String, Integer>();
			columnIndexNum.put("SNO", 1);
			columnIndexNum.put("Name", 2);
			columnIndexNum.put("Username", 3);
			columnIndexNum.put("Email", 4);
			columnIndexNum.put("Role Name", 5);
			columnIndexNum.put("Action", 6);

			return columnIndexNum.get(columnName);
		}

		/**
		 * By This Method We Can Get The Row number of entered Project Name
		 * 
		 * @param project_name
		 * @return
		 */
		public int getUserNameRowNumber(String userName) {
			int rowIndexNum = 0;
			boolean flag = false;
			while (flag == false) {
				AwtUtilities.waitFor(2000);
				List<WebElement> projectNames = driver
						.findElements(By.xpath("//tr[@role='row' and @data-pc-section='row']/td[3]"));

				for (int i = 0; i < projectNames.size(); i++) {
					String projectName = projectNames.get(i).getText().trim();
					if (projectName.equalsIgnoreCase(userName)) {
						flag = true;
						rowIndexNum = i + 1;
						break;
					}
				}
				if (flag == false) {
					// click on next page
					try {
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
		 * This Method Is Used To Click On Delete button With Help Of Entered User Name
		 * 
		 * @param projectName
		 */
		public void clickOnDeleteButton(String userName) {
			action.waitForVisibility(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
					+ getUserNameRowNumber(userName) + "]/td/div/button[@aria-label='Delete']")), action.implicit_wait);
			action.clickOn(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
					+ getUserNameRowNumber(userName) + "]/td/div/button[@aria-label='Delete']")));
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
		public void clickOnEditButton(String userName) {
			action.waitForVisibility(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
					+ getUserNameRowNumber(userName) + "]/td/div/button[@aria-label='Edit']")), action.implicit_wait);
			action.clickOn(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
					+ getUserNameRowNumber(userName) + "]/td/div/button[@aria-label='Edit']")));
		}

}
