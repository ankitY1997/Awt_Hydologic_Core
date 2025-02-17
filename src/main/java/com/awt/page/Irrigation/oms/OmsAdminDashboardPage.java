package com.awt.page.Irrigation.oms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.awt.page.Irrigation.Home.HomePage;
import com.awt.page.Irrigation.oms.Master.Add_View_Village.VillageDetailsPage;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class OmsAdminDashboardPage extends HomePage {

	// ********Constants**********/

	public final String master = "Master";
	public final String add_view_village = "Add/View Village";

	// ** Custom Constructor**//
	public OmsAdminDashboardPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * help Of This Method We Can Chose Any Options Under Drop-Down
	 * 
	 * @param dropDownName    { We need To Pass The Drop-Down Name}
	 * @param dropDownOptions {We Need To Pass Options Which Are present under the
	 *                        drop-down
	 */
	public void selectOMSDropDownOptions(String dropDownName, String dropDownOptions) {

		// Wait For Page Load
		AwtUtilities.waitForPageLoading(driver);
		// wait for Element
		action.waitForVisibility(
				driver.findElement(
						By.xpath("(//ul[@role='menu'])[1]/li//span[text()='" + dropDownName + "']/./parent::a")),
				action.implicit_wait);
		// click on admin main menu
		action.clickOn(
				driver.findElement(
						By.xpath("(//ul[@role='menu'])[1]/li//span[text()='" + dropDownName + "']/./parent::a")),
				dropDownName);
		// Wait For Load To Drop-Down Menus
		action.waitForVisibility(
				driver.findElement(By
						.xpath("(//ul[@role='menu'])[1]/li//ul/li//span[text()='" + dropDownOptions + "']/parent::a")),
				action.implicit_wait);
		// select a options
		action.clickOn(driver.findElement(
				By.xpath("(//ul[@role='menu'])[1]/li//ul/li//span[text()='" + dropDownOptions + "']/parent::a")));

	}

	/**
	 * help Of This Method We Can Check Any Option Visibility Under The OMS Admin
	 * Dashboard Page
	 * 
	 * @param dropDownName
	 * @param dropDownOptions
	 * @return
	 */
	public boolean isOptionIsVisible(String dropDownName, String dropDownOptions) {
		// Wait For Page Load
		AwtUtilities.waitForPageLoading(driver);
		// wait for Element
		action.waitForVisibility(
				driver.findElement(
						By.xpath("(//ul[@role='menu'])[1]/li//span[text()='" + dropDownName + "']/./parent::a")),
				action.implicit_wait);
		// click on admin main menu
		action.clickOn(
				driver.findElement(
						By.xpath("(//ul[@role='menu'])[1]/li//span[text()='" + dropDownName + "']/./parent::a")),
				dropDownName);
		// Wait For Load To Drop-Down Menus
		action.waitForVisibility(
				driver.findElement(By
						.xpath("(//ul[@role='menu'])[1]/li//ul/li//span[text()='" + dropDownOptions + "']/parent::a")),
				action.implicit_wait);

		return action.isDisplay(driver.findElement(
				By.xpath("(//ul[@role='menu'])[1]/li//ul/li//span[text()='" + dropDownOptions + "']/parent::a")));
	}

	/**
	 * With help of this method we can navigate to the village details page
	 * 
	 * @return instance of VillageDetailsPage
	 */
	public VillageDetailsPage navigateToVillageDetailsPage() {

		// Selecting a "Add/View village" options from Master drop down
		selectMastersOptions( add_view_village);
		return new VillageDetailsPage(driver);
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
	
	/**
	 * By this method we can select only master options only
	 * @param dropDownOptions
	 */
	public void selectMastersOptions(String dropDownOptions) {
		// Wait For Load To Drop-Down Menus
				action.waitForVisibility(
						driver.findElement(By
								.xpath("(//ul[@role='menu'])[1]/li//ul/li//span[text()='" + dropDownOptions + "']/parent::a")),
						action.implicit_wait);
				// select a options
				action.clickOn(driver.findElement(
						By.xpath("(//ul[@role='menu'])[1]/li//ul/li//span[text()='" + dropDownOptions + "']/parent::a")));
	}
}
