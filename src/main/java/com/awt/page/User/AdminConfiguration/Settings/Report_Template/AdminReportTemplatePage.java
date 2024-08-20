package com.awt.page.User.AdminConfiguration.Settings.Report_Template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.awt.page.User.ParentLandingPage;
import com.awt.page.User.AdminConfiguration.User.CreateUser.AddUsersPanel;

public class AdminReportTemplatePage extends ParentLandingPage {

	// ********New Button**********/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='New']") })
	public WebElement new_button;

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

}
