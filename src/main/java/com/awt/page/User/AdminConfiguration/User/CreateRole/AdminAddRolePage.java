package com.awt.page.User.AdminConfiguration.User.CreateRole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.awt.page.User.AdminConfiguration.AdminPage;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class AdminAddRolePage extends AdminPage {

	// ********New Button**********/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='New']") })
	public WebElement new_button;

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
	 * 
	 */
	public boolean isNewButtonIsVisible() {
		action.waitForVisibility(new_button, action.implicit_wait);
		return action.isDisplay(new_button);
	}

}
