package com.awt.page.User.AdminConfiguration.Settings.NotificationSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.awt.page.User.AdminConfiguration.AdminPage;

public class AdminNotificationSettingsPage extends AdminPage {

	/* xpath for new button */
	@FindAll({ @FindBy(xpath = "//button[@aria-label='New']") })
	private WebElement btn_new;



	// **Constructor**//
	public AdminNotificationSettingsPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * By this method we can check notification setting button is visible
	 * 
	 * @return {if it's visible it returns true otherwise it returns false}
	 */
	public boolean isNotificationSettingButtonVisible() {
		return flag;
	}

	/**
	 * By This Method We Can Check "New" button is visible
	 * 
	 * @return if it's visible it return true otherwise it returns false
	 */
	public boolean isNewButtonVisible() {
		action.waitForVisibility(btn_new, action.implicit_wait);
		return action.isDisplay(btn_new);
	}

	/**
	 * With help of this method we can click on "New" button
	 */
	public void clickOnNewButton() {
		action.waitForVisibility(btn_new, action.implicit_wait);
		action.clickOn(btn_new);
	}

	/**
	 * With help of this method we can click on "New" button and redirecting to the
	 * Notification details panel
	 */
	public NotificationDetailsPanel clickOnNewButtonAndNavigateToNotificationDetailsPanel() {
		clickOnNewButton();
		return new NotificationDetailsPanel(driver);
	}

}
