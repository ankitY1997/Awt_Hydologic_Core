package com.awt.page.User.AdminConfiguration.Settings.Report_Template;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.awt.page.User.ParentLandingPage;
import com.awt.page.User.AdminConfiguration.User.CreateUser.AddUsersPanel;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class AdminReportTemplatePage extends ParentLandingPage {

	// ********New Button**********/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='New']") })
	public WebElement new_button;

	// ** Enable Next Pagination Button ****/
	@FindAll({ @FindBy(xpath = "//button[@title='Go to next page'and @tabindex='0']") })
	public WebElement enable_next_page;

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
	 * By This Method We Can Click On New Button and reach to the Add New Report
	 * Panel
	 */
	public AddNewReportPanel clickOnNewButtonAndNavigateToAddNewReportPanel() {
		action.clickOn(new_button);
		return new AddNewReportPanel(driver);
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
