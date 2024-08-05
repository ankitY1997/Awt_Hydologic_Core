package com.awt.page.User.AdminConfiguration.User.CreateUser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.awt.page.User.AdminConfiguration.AdminPage;
import com.awt.page.User.AdminConfiguration.User.CreateRole.AddNewRolePanel;

public class AdminAddUserPage extends AdminPage {

	// ********New Button**********/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='New']") })
	public WebElement new_button;

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
	public AddUsersPanel clickOnNewButtonAndNavigateToAddNewRolePanel() {
		action.clickOn(new_button);
		return new AddUsersPanel(driver);
	}

	/***
	 * This Method Is Used To Check New Button Is Visible Or Not
	 */
	public boolean isNewButtonIsVisible() {
		action.waitForVisibility(new_button, action.implicit_wait);
		return action.isDisplay(new_button);
	}
}
