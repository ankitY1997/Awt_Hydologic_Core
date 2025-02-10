package com.awt.page.Irrigation.Admin.Settings.ReportTemplate;

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
/**
 * @author Ankit Yadav
 */
public class AdminReportTemplatePage extends AdminDashboardPage{
	
	// ********New Button**********/
		@FindAll({ @FindBy(xpath = "//button[@aria-label='New']") })
		public WebElement new_button;

		// ********Report Template Table Columns Name**********/
		@FindAll({ @FindBy(xpath = "//tr[@data-pc-section='headerrow']/th/div/span[not(@data-pc-section='sort')]") })
		public List<WebElement> column_names;

		// ** Delete Button****/
		@FindAll({ @FindBy(xpath = "//button[@title='Delete'][1]") })
		public WebElement delete_button;

		// ******yes Button*******/
		@FindAll({ @FindBy(xpath = "//span[text()='Yes']") })
		public WebElement yes_button;

		// ******Rows per page Drop-Down button*******/
		@FindAll({ @FindBy(xpath = "//div[@role='combobox']") })
		public WebElement rows_per_page_drop_down_button;

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

		// ********Total Number of ROw In The Table**********/
		@FindAll({ @FindBy(xpath = "//tbody[@data-pc-section='tbody']/tr") })
		public List<WebElement> number_of_row;

		// ** Enable Next Pagination Button ****/
		@FindAll({ @FindBy(xpath = "//button[@title='Go to next page'and @tabindex='0']") })
		public WebElement enable_next_page;

		// ** Search Text Field ****/
		@FindAll({ @FindBy(xpath = "//input[@type='search']") })
		public WebElement search_text_field;

		/* Constructor */
		public AdminReportTemplatePage(WebDriver driver) {
			super(driver);
		}

		/**
		 * Check New Button Is presence in "admin report template"
		 * 
		 * @return boolean
		 */
		public boolean isNewButtonVisible() {
			action.waitForVisibility(new_button, action.implicit_wait);
			return action.isDisplay(new_button);
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
		 * This method helps we can check visibility of search text field
		 * 
		 * @return
		 */
		public boolean isSearchTextFieldVisible() {
			action.waitForVisibility(search_text_field, action.implicit_wait);
			return action.isDisplay(search_text_field);
		}

		/**
		 * This Method Is Used To Clear A Text
		 */
		public void clearSearchTextField() {
			driver.navigate().refresh();
			action.waitForVisibility(search_text_field, action.implicit_wait);
			AwtUtilities.clearTextUsingJs(driver, search_text_field);
		}

		/**
		 * By This Method We Can Click On New Button and reach to the Add New Report
		 * Panel
		 */
		public AddNewReportPanel clickOnNewButtonAndNavigateToAddNewReportPanel() {
			action.clickOn(new_button);
			return new AddNewReportPanel(driver);
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
		 * This Method is used to enter a text inside the search text field
		 * 
		 * @param search
		 */
		public void search(String search) {
			if (isSearchTextFieldVisible()) {
				action.type(search_text_field, "SEARCH", search);
			}
		}

		/**
		 * This method determines if a search value is present in the first row; it
		 * returns true if the value is found and false otherwise.
		 * 
		 * @return boolean
		 */
		public boolean isSearchValueInFirstRow(String searchText) {
			action.waitForVisibility(driver.findElements(By.xpath("//tr[@role='row'][1]/td")).get(0), action.implicit_wait);
			List<WebElement> search_values = driver.findElements(By.xpath("//tr[@role='row'][1]/td"));
			boolean flag = false;
			for (WebElement element : search_values) {
				action.waitForVisibility(element, action.implicit_wait);
				if (element.getText().trim().equals(searchText)) {
					flag = true;
				}
			}
			return flag;

		}

		/**
		 * By This Method We Can take any column data by giving column name and template
		 * name which you have given while adding new report
		 * 
		 * @param columnName
		 * @param templateName
		 * @return
		 */
		public String getDataFromReportTemplateTable(String columnName, String templateName) {
			AwtUtilities.waitFor(500);
			String value = " ";
			try {
				switch (columnName) {
				case "Template Name":
					action.waitForVisibility(
							driver.findElement(By.xpath(
									"//tr[@role='row' and @data-pc-section='row'][" + getTemplateNameRowNumber(templateName)
											+ "]/td[" + getReportTemplateTableColumnIndexNumber(columnName) + "]")),
							action.implicit_wait);
					value = action.getText(driver.findElement(By
							.xpath("//tr[@role='row' and @data-pc-section='row'][" + getTemplateNameRowNumber(templateName)
									+ "]/td[" + getReportTemplateTableColumnIndexNumber(columnName) + "]")));
					break;
				case "Device Type":
					action.waitForVisibility(
							driver.findElement(By.xpath(
									"//tr[@role='row' and @data-pc-section='row'][" + getTemplateNameRowNumber(templateName)
											+ "]/td[" + getReportTemplateTableColumnIndexNumber(columnName) + "]")),
							action.implicit_wait);
					value = action.getText(driver.findElement(By
							.xpath("//tr[@role='row' and @data-pc-section='row'][" + getTemplateNameRowNumber(templateName)
									+ "]/td[" + getReportTemplateTableColumnIndexNumber(columnName) + "]")));
					break;
				case "Report Type":
					action.waitForVisibility(
							driver.findElement(By.xpath(
									"//tr[@role='row' and @data-pc-section='row'][" + getTemplateNameRowNumber(templateName)
											+ "]/td[" + getReportTemplateTableColumnIndexNumber(columnName) + "]")),
							action.implicit_wait);
					value = action.getText(driver.findElement(By
							.xpath("//tr[@role='row' and @data-pc-section='row'][" + getTemplateNameRowNumber(templateName)
									+ "]/td[" + getReportTemplateTableColumnIndexNumber(columnName) + "]")));
					break;

				case "Show Serial Number":
					action.waitForVisibility(
							driver.findElement(By.xpath(
									"//tr[@role='row' and @data-pc-section='row'][" + getTemplateNameRowNumber(templateName)
											+ "]/td[" + getReportTemplateTableColumnIndexNumber(columnName) + "]")),
							action.implicit_wait);
					value = action.getText(driver.findElement(By
							.xpath("//tr[@role='row' and @data-pc-section='row'][" + getTemplateNameRowNumber(templateName)
									+ "]/td[" + getReportTemplateTableColumnIndexNumber(columnName) + "]")));
					break;

				case "Show Set Value":
					action.waitForVisibility(
							driver.findElement(By.xpath(
									"//tr[@role='row' and @data-pc-section='row'][" + getTemplateNameRowNumber(templateName)
											+ "]/td[" + getReportTemplateTableColumnIndexNumber(columnName) + "]")),
							action.implicit_wait);
					value = action.getText(driver.findElement(By
							.xpath("//tr[@role='row' and @data-pc-section='row'][" + getTemplateNameRowNumber(templateName)
									+ "]/td[" + getReportTemplateTableColumnIndexNumber(columnName) + "]")));
					break;
				case "SNO":
					System.out.println("NO VALUES FOR SERIAL COLUMN");
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
		public Integer getReportTemplateTableColumnIndexNumber(String columnName) {
			LinkedHashMap<String, Integer> columnIndexNum = new LinkedHashMap<String, Integer>();
			columnIndexNum.put("SNO", 1);
			columnIndexNum.put("Template Name", 2);
			columnIndexNum.put("Device Type", 3);
			columnIndexNum.put("Report Type", 4);
			columnIndexNum.put("Show Serial Number", 5);
			columnIndexNum.put("Show Set Value", 6);

			return columnIndexNum.get(columnName);
		}

		/**
		 * By This Method We Can Get The Row number of entered Project Name
		 * 
		 * @param project_name
		 * @return
		 */
		public int getTemplateNameRowNumber(String template_name) {
			int rowIndexNum = 0;
			boolean flag = false;
			while (flag == false) {
				AwtUtilities.waitFor(2000);
				List<WebElement> projectNames = driver
						.findElements(By.xpath("//tr[@role='row' and @data-pc-section='row']/td[2]"));

				for (int i = 0; i < projectNames.size(); i++) {
					String projectName = projectNames.get(i).getText().trim();
					if (projectName.equalsIgnoreCase(template_name)) {
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
		 * By This Help We Can Get All The Column Names of Report Template Table
		 * 
		 * @return
		 */
		public List<String> listOfReportTemplateTableColumns() {
			List<String> column_name = new ArrayList<String>();
			for (WebElement columName : column_names) {
				column_name.add(columName.getText().trim());
			}
			return column_name;
		}

		/**
		 * This Method Is Used To Click On Delete button With Help Of Entered Project
		 * Name
		 * 
		 * @param projectName
		 */
		public void clickOnDeleteButton(String templateName) {
			action.waitForVisibility(
					driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
							+ getTemplateNameRowNumber(templateName) + "]/td/div/button[@title='Delete']")),
					action.implicit_wait);
			action.clickOn(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
					+ getTemplateNameRowNumber(templateName) + "]/td/div/button[@title='Delete']")));
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
