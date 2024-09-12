package com.awt.page.User.Irrigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.awt.page.User.ParentLandingPage;
import com.awt.page.User.Irrigation.OMS.OMSAdminDashboardPage;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class MainDashboardPage extends ParentLandingPage {

	// *******Menu Name**************/
	public static final String oms = "OMS";

	public MainDashboardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	/**
	 * help Of This Method We Can Chose Any Menu
	 * 
	 * @param menu_name { We need To Pass The Correct Menu Name}
	 */
	public void selectMainMenu(String menu_name) {

		// Wait For Page Load
		AwtUtilities.waitForPageLoading(driver);
		// wait for Element
		action.waitForVisibility(
				driver.findElement(
						By.xpath("(//ul[@role='menu'])[1]/li//span[text()='" + menu_name + "']/./parent::a")),
				action.implicit_wait);
		// click on admin main menu
		action.clickOn(
				driver.findElement(
						By.xpath("(//ul[@role='menu'])[1]/li//span[text()='" + menu_name + "']/./parent::a")),
				menu_name);

	}

	/**
	 * By this method we can navigate to Oms Admin Dashboard Page
	 * 
	 * @return instance of OmsAdminDashboardPage
	 */

	public OMSAdminDashboardPage navigateToOmsAdminDashboardPage() {
		// Select The Menu
		selectMainMenu(oms);
		return new OMSAdminDashboardPage(driver);

	}

}
