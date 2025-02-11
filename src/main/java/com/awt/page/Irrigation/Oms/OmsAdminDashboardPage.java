package com.awt.page.Irrigation.Oms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.awt.page.Irrigation.Home.HomePage;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class OmsAdminDashboardPage extends HomePage {

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

}
