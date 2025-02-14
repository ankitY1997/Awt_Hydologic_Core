package com.awt.page.Irrigation.oms.Master.Add_View_Village;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.awt.page.Irrigation.oms.OmsAdminDashboardPage;

public class VillageDetailsPage extends OmsAdminDashboardPage {

	// *************xpath*************/

	/** Xpath for new button */
	@FindBy(xpath = "//button[@aria-label='New']")
	public WebElement new_button;

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
	 * @return {if it's visible it's return true otherwise it's return false
	 */
	public boolean isNewButtonIsVisible() {
		return action.isDisplay(new_button);
		
	}
}
