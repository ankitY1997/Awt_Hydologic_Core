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
	 * With help of this method we can check "Add/View Village Option is Visible
	 * 
	 * @return boolean
	 * 
	 */
	public boolean isAddViewVillageOptionVisible() {
		return isOptionIsVisible(master, add_view_village);
	}

}
