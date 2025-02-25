package com.awt.page.Irrigation.oms.Master.Add_View_Village;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.awt.page.Irrigation.oms.OmsAdminDashboardPage;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class VillageDetailsPage extends OmsAdminDashboardPage {

	// *************xpath*************/

	/** Xpath for new button */
	@FindBy(xpath = "//button[@aria-label='New']")
	public WebElement new_button;

	/** Xpath for Village Details Table Column Name */
	@FindBy(xpath = "//tr[@role='row']/th/div/span[@data-pc-section='headertitle']")
	public List<WebElement> columnName;

	/** Edit button name **/
	@FindBy(xpath = "//span[contains(@class,'pi-pencil') and @data-pc-section='icon']/.")
	public WebElement edit_button;

	/** delete button name **/
	@FindBy(xpath = "//span[contains(@class,'pi-trash') and @data-pc-section='icon']/.")
	public WebElement delete_button;

	// ******yes Button*******/
	@FindAll({ @FindBy(xpath = "//span[text()='Yes']") })
	public WebElement yes_button;

	// ** First Pagination Button****/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='First Page']") })
	public WebElement first_page;

	// ** Previous Pagination Button****/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Previous Page']") })
	public WebElement previous_page;

	// ** Last Pagination Button****/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Last Page']") })
	public WebElement last_page;

	// ** Last Pagination Button****/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Next Page']") })
	public WebElement next_page;

	// ******Rows per page Drop-Down button*******/
	@FindAll({ @FindBy(xpath = "//div[@aria-haspopup='listbox' and @aria-haspopup='listbox']//*[local-name()='svg']") })
	public WebElement rows_per_page_drop_down_button;

	// ** Enable Next Pagination Button ****/
	@FindAll({
			@FindBy(xpath = "//button[not((@class='p-paginator-next p-paginator-element p-link p-disabled')) and @aria-label='Next Page']") })
	public WebElement enable_next_page;

	// ********Total Number of ROw In The Table**********/
	@FindAll({ @FindBy(xpath = "//tbody[@data-pc-section='tbody']/tr") })
	public List<WebElement> number_of_row;

	// *********Export button**************/
	@FindBy(xpath = "//button[@aria-label='Export']/following-sibling::button//*[local-name()='svg']")
	public WebElement export_button;

	// *******PDF Button***************/
	@FindBy(xpath = "//span[text()='PDF']/..")
	public WebElement pdf_button;

	// ************Excel Button***********/
	@FindBy(xpath = "//span[text()='Excel']/..")
	public WebElement excel_button;

	// **Custom Contructor**/

	public VillageDetailsPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * With help of this method we can get to know "new" button is visble
	 * 
	 * @return {if it's visible it's return true otherwise it's return false
	 */
	public boolean isNewButtonIsVisible() {
		return action.isDisplay(new_button);

	}

	/**
	 * With help of this method we can get to know "Export" button is visble
	 * 
	 * @return {if it's visible it's return true otherwise it's return false
	 */
	public boolean isExportButtonIsVisible() {
		return action.isDisplay(export_button);

	}

	/**
	 * This method is helps we can get "Edit" button is visible or not
	 * 
	 * @return
	 */
	public boolean isEditButtonIsVisible() {
		action.waitForVisibility(edit_button, action.implicit_wait);
		return action.isDisplay(edit_button);

	}

	/**
	 * This method is used to get "Delete" button is visible or not
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
	 * This Method Is used To click on "export" button
	 */
	public void clickOnExportButton() {
		action.waitForVisibility(export_button, action.implicit_wait);
		action.clickOn(export_button);
	}

	/**
	 * This Method Is Used To pdf button Is Visible Or Not
	 * 
	 * @return
	 */
	public boolean isPdfButtonVisible() {
		action.waitForVisibility(pdf_button, action.implicit_wait);
		return action.isDisplay(pdf_button);

	}

	/**
	 * This Method Is Used To pdf button Is Visible Or Not
	 * 
	 * @return
	 */
	public boolean isExcelButtonVisible() {
		action.waitForVisibility(excel_button, action.implicit_wait);
		return action.isDisplay(excel_button);
	}

	/**
	 * Please Pass the Correct Options
	 * 
	 * @param option_name
	 */
	public void selectExportOptions(String option_name) {
		switch (option_name.toLowerCase()) {
		case "pdf":
			action.waitForVisibility(driver.findElement(By.xpath("//span[text()='PDF']/..")), action.implicit_wait);
			action.clickOn(driver.findElement(By.xpath("//span[text()='PDF']/..")), option_name);
			AwtUtilities.handleDownloadPopup();
			break;

		case "excel":
			action.waitForVisibility(driver.findElement(By.xpath("//span[text()='Excel']/..")), action.implicit_wait);
			action.clickOn(driver.findElement(By.xpath("//span[text()='Excel']/..")), option_name);
			AwtUtilities.handleDownloadPopup();
			break;

		default:
			MyLogger.info("Please Pass The Correct Export Options :" + option_name);
			break;

		}
	}

	/**
	 * This Method Is Used To Click On Delete button With Help Of village name Name
	 * 
	 * @param villageName
	 */
	public void clickOnDeleteButton(String villageName) {
		action.waitForVisibility(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
				+ getVillageNameRowNumber(villageName) + "]/td/div/button[2]")), action.implicit_wait);
		action.clickOn(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
				+ getVillageNameRowNumber(villageName) + "]/td/div/button[2]")));
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
				+ getVillageNameRowNumber(projectName) + "]/td/div/button[1]")), action.implicit_wait);
		action.clickOn(driver.findElement(By.xpath("//tr[@role='row' and @data-pc-section='row']["
				+ getVillageNameRowNumber(projectName) + "]/td/div/button[1]")));
	}

	/**
	 * With help of this method we can get the actual column name of "village
	 * details table"
	 * 
	 * @return {Column Name of All The Village Details Table}
	 */
	public List<String> getVillageDetailsTableColumnName() {
		action.waitForVisibility(columnName.get(0), action.implicit_wait);
		List<String> act_column_name = new ArrayList<String>();
		for (WebElement ele : columnName) {
			act_column_name.add(ele.getText().trim());
		}

		return act_column_name;
	}

	/**
	 * By This Method We Can Get Role Details Table Value as per given column name
	 * and project name
	 * 
	 * @param columnName
	 * @param projectName
	 * @return
	 */
	public String getVillageDetailTableValue(String columnName, String villageName) {
		String value = " ";
		try {
			switch (columnName) {
			case "District Name":
				action.waitForVisibility(
						driver.findElement(By.xpath(
								"//tr[@role='row' and @data-pc-section='row'][" + getVillageNameRowNumber(villageName)
										+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")),
						action.implicit_wait);
				value = action.getText(driver.findElement(
						By.xpath("//tr[@role='row' and @data-pc-section='row'][" + getVillageNameRowNumber(villageName)
								+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")));
				break;
			case "Command Area":
				action.waitForVisibility(
						driver.findElement(By.xpath(
								"//tr[@role='row' and @data-pc-section='row'][" + getVillageNameRowNumber(villageName)
										+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")),
						action.implicit_wait);
				value = action.getText(driver.findElement(
						By.xpath("//tr[@role='row' and @data-pc-section='row'][" + getVillageNameRowNumber(villageName)
								+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")));
				break;
			case "Village Name":
				action.waitForVisibility(
						driver.findElement(By.xpath(
								"//tr[@role='row' and @data-pc-section='row'][" + getVillageNameRowNumber(villageName)
										+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")),
						action.implicit_wait);
				value = action.getText(driver.findElement(
						By.xpath("//tr[@role='row' and @data-pc-section='row'][" + getVillageNameRowNumber(villageName)
								+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")));
				break;
			case "Village Area (Ha)":
				action.waitForVisibility(
						driver.findElement(By.xpath(
								"//tr[@role='row' and @data-pc-section='row'][" + getVillageNameRowNumber(villageName)
										+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")),
						action.implicit_wait);
				value = action.getText(driver.findElement(
						By.xpath("//tr[@role='row' and @data-pc-section='row'][" + getVillageNameRowNumber(villageName)
								+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")));
				break;

			case "Contact Person":
				action.waitForVisibility(
						driver.findElement(By.xpath(
								"//tr[@role='row' and @data-pc-section='row'][" + getVillageNameRowNumber(villageName)
										+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")),
						action.implicit_wait);
				value = action.getText(driver.findElement(
						By.xpath("//tr[@role='row' and @data-pc-section='row'][" + getVillageNameRowNumber(villageName)
								+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")));
				break;

			case "Contact Number":
				action.waitForVisibility(
						driver.findElement(By.xpath(
								"//tr[@role='row' and @data-pc-section='row'][" + getVillageNameRowNumber(villageName)
										+ "]/td[" + getRoleDetailsColumnIndexNumber(columnName) + "]")),
						action.implicit_wait);
				value = action.getText(driver.findElement(
						By.xpath("//tr[@role='row' and @data-pc-section='row'][" + getVillageNameRowNumber(villageName)
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
	 * By This Method We Can Get The Role Details Header Column Index Number
	 * 
	 * @param projectName
	 * @return
	 */
	public Integer getRoleDetailsColumnIndexNumber(String roleName) {
		LinkedHashMap<String, Integer> columnIndexNum = new LinkedHashMap<String, Integer>();
		columnIndexNum.put("SNO", 1);
		columnIndexNum.put("District Name", 2);
		columnIndexNum.put("Command Area", 3);
		columnIndexNum.put("Village Name", 4);
		columnIndexNum.put("Village Area (Ha)", 5);
		columnIndexNum.put("Contact Person", 6);
		columnIndexNum.put("Contact Number", 7);
		columnIndexNum.put("Actions", 8);

		return columnIndexNum.get(roleName);
	}

	/**
	 * By This Method We Can Get The Row number of entered Project Name
	 * 
	 * @param project_name
	 * @return
	 */
	public int getVillageNameRowNumber(String villageName) {
		int rowIndexNum = 0;
		boolean flag = false;
		while (flag == false) {
			AwtUtilities.waitFor(2000);
			List<WebElement> villageNames = driver
					.findElements(By.xpath("//tr[@role='row' and @data-pc-section='row']/td[4]"));

			for (int i = 0; i < villageNames.size(); i++) {
				String village_name = villageNames.get(i).getText().trim();
				if (village_name.equalsIgnoreCase(villageName)) {
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

	/**
	 * By This Method We Can Select Rows Per Page Drop-Down Number
	 * 
	 */
	public void selectRowPerPage(String numOfPage) {
		// click on Rows Per Page Drop Down button
		action.clickOn(rows_per_page_drop_down_button);
		if (Integer.parseInt(numOfPage) <= 40 && (Integer.parseInt(numOfPage) % 5) == 0) {
			action.waitForVisibility(
					driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + numOfPage + "']")),
					action.implicit_wait);
			action.clickOn(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + numOfPage + "']")));
		}
	}

	/**
	 * By help of this method we can navigate to the "New Village Details Panel"
	 * 
	 */
	public NewVillageDetailsPanel clickOnNewButtonAndNavigateToNewVillageDetaisPanel() {

		action.waitForVisibility(new_button, action.implicit_wait);
		action.clickOn(new_button, "New");

		return new NewVillageDetailsPanel(driver);
	}
}
