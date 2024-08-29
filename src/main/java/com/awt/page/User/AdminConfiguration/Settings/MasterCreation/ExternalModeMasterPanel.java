package com.awt.page.User.AdminConfiguration.Settings.MasterCreation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ExternalModeMasterPanel extends SystemModeMasterPanel {

	// ******External Table Drop Down ********/
	@FindAll({ @FindBy(xpath = "//div[@id='externalTableDropdown']//*[local-name()='svg']") })
	public WebElement external_table_drop_down;

	// ****Constructor****/
	public ExternalModeMasterPanel(WebDriver driver) {
		super(driver);
	}

	/**
	 * By this method we can get panel name
	 * 
	 * @return
	 */
	public String getUserDefinedMasterPanelName() {
		action.isDisplay(panel_name);
		return action.getText(panel_name);
	}

	/**
	 * By this method we can check the visibility of "External Table" drop down
	 * 
	 * @return {if it's visible then it will return true otherwise it will return
	 *         false}
	 */
	public boolean isExternalTableDropDownVisible() {
		action.waitForVisibility(external_table_drop_down, action.implicit_wait);
		return action.isDisplay(external_table_drop_down);
	}

	/**
	 * By this method we can click on "External Table" drop down
	 */
	public void clickOnExternalTableDropDown() {
		if (isExternalTableDropDownVisible()) {
			action.clickOn(external_table_drop_down);
		}
	}

	/**
	 * By this method we can select any table which present under the External Table
	 * drop down
	 * 
	 * @param table_name
	 */
	public void selectExtrnalTable(String table_name) {
		clickOnExternalTableDropDown();
		action.waitForVisibility(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + table_name + "']")),
				action.implicit_wait);
		action.clickOn(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + table_name + "']")));
	}

	
	
}
