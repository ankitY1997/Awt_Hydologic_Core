package com.awt.page.Irrigation.oms.Master.Add_View_Village;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.awt.page.Irrigation.oms.OmsAdminDashboardPage;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class VillageDetailsPage extends OmsAdminDashboardPage {

	// *************xpath*************/

	/** Xpath for new button */
	@FindBy(xpath = "//button[@aria-label='New']")
	public WebElement new_button;

	// ** Enable Next Pagination Button ****/
	@FindAll({ @FindBy(xpath = "//button[@title='Go to next page'and @tabindex='0']") })
	public WebElement enable_next_page;

	// **Custom Contructor**/

	public VillageDetailsPage(WebDriver driver) {
		super(driver);

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

	/**
	 * With help of this method we can get to know "new" button is visble
	 * 
	 * @return {if it's visible it's return true otherwise it's return false
	 */
	public boolean isNewButtonIsVisible() {
		return action.isDisplay(new_button);

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
			List<WebElement> projectNames = driver
					.findElements(By.xpath("//tr[@role='row' and @data-pc-section='row']/td[4]"));

			for (int i = 0; i < projectNames.size(); i++) {
				String projectName = projectNames.get(i).getText().trim();
				if (projectName.equalsIgnoreCase(villageName)) {
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

}
