package com.awt.page.User.AdminConfiguration.Settings.NotificationSettings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class NotificationDetailsPanel extends AdminNotificationSettingsPage {

	/* xpath for new button */
	@FindAll({ @FindBy(xpath = "//div[@data-pc-section='headertitle']") })
	private WebElement panel_name;

	/* device profile drop down */
	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Device Profile')]/..//*[local-name()='svg']") })
	private WebElement device_profile_drop_down;

	// **Constructor**/
	public NotificationDetailsPanel(WebDriver driver) {
		super(driver);
	}

	/**
	 * Help of this method we can check the visibility of Device Profile Drop down
	 * button
	 * 
	 * @return {if it's visible then it returns true otherwise it returns false}
	 */
	public boolean isDeviceProfileDropDownIsVisible() {
		action.waitForVisibility(device_profile_drop_down, action.implicit_wait);
		return action.isDisplay(device_profile_drop_down);
	}

	/**
	 * This method helps we can get to know the panel name
	 * 
	 * @return {Panel Name}
	 */
	public String getPanelName() {
		action.waitForVisibility(panel_name, action.implicit_wait);
		return action.getText(panel_name);
	}

	/**
	 * By this method we can click on any drop down under "Notification Details "
	 * panel
	 * 
	 * @param drop_down_name
	 * @implNote Please Pass drop down name as same as web page name
	 */
	public void clickAnyNotificationSettingDropDownButton(String drop_down_name) {
		action.waitForVisibility(
				driver.findElement(
						By.xpath("//label[contains(text(),'" + drop_down_name + "')]/..//*[local-name()='svg']")),
				action.implicit_wait);
		action.clickOn(
				driver.findElement(
						By.xpath("//label[contains(text(),'" + drop_down_name + "')]/..//*[local-name()='svg']")),
				drop_down_name);

	}

	/**
	 * With help of this method we can select any option in any drop down which is
	 * present under notification details panel
	 * 
	 * @param option_name
	 * @implNote Please Pass Option Name as same as web page name
	 */
	public void selectDropDownOption(String option_name) {
		action.waitForVisibility(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + option_name + "']")),
				action.implicit_wait);
		action.clickOn(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + option_name + "']")),
				option_name);
	}

}
