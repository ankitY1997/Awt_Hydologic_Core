package com.awt.page.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awt.page.oms_Add.OmsDetailsPage;
import com.awt.page.oms_dashboard.DashboardPage;
import com.awt.page.oms_view.OmsDetailsGetPage;
import com.awt.utills.reusablecomponents.ActionEngine;
import com.awt.utills.reusablecomponents.AwtUtilities;



public class HomePage {
	/** account _button **/
	@FindBy(xpath = "//*[local-name()='svg' and @data-testid='AccountCircleIcon']")
	public WebElement btn_account_icon;

	/** logout button **/
	@FindBy(xpath = "//*[local-name()='svg' and @data-testid='LogoutIcon']")
	public WebElement btn_logout;

	/** side menu icon button **/
	@FindAll({ @FindBy(xpath = "//div[@id='images']/div/a//*[local-name()='svg' and @stroke='currentColor']"),
			@FindBy(xpath = "//a//*[local-name()='svg' and @stroke='currentColor']") })
	public WebElement side_menu_button;

	/** home page oms button **/
	@FindBy(xpath = "//b[text()='OUTLET MANAGEMENT SYSTEM (OMS)']")
	public WebElement button_oms;

	/** pop up message **/
	@FindAll({ @FindBy(xpath = "//div[text()='OMS Added successfully']") })
	private WebElement message_popup;

	/** web driver instance */
	WebDriver driver;
	/** action Engine Instance variable **/
	ActionEngine action;

	/** constructor */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		action = new ActionEngine(driver);
		PageFactory.initElements(driver, this);

	}

	/**
	 * this method is use to get the count of Culturable Command Area ,Brake
	 * Pressure Tank (BPT), Pump House, Distribution Chamber (DC), OMS, AMS
	 *
	 * @param panel_name
	 * @return
	 */
	public int getCountOfSpecifiedPanels(String panel_name) {
		String text = action.getText(driver.findElement(By.xpath("//div[contains(text(),'" + panel_name + "')]")));
		return AwtUtilities.removeAllAlphabets(text);
	}

	/**
	 * click on side menu button
	 */
	public void clickOnSideBarMenu() {
		AwtUtilities.scrollToElement(driver,side_menu_button);
		action.clickOn(side_menu_button,"side menu bar");
	}

	/**
	 * this method is used to log out from the application
	 *
	 * @author AWT Tester
	 */
	public void clickOnLogOutButton() {
		// click on the account icon
		action.clickOn(btn_account_icon," acoount icon");
		// click on the log out button
		action.clickOn(btn_logout,"logout");
	}
	/**
	 * this method helps we can navigate to any module to any sub module page
	 *
	 * @param mainModuleName {"OMS","AMS"}
	 * @param moduleName     { OMS Dashboard ,OMS Details View,Command Area OMS,
	 *                       Bulk Upload,Village Area Add/View,Farmer Details
	 *                       Add/View,OMS Report,OMS Site Assign }
	 * @param subModuleName  {Village Add,Village View,OMS Add,OMS View,Farmer
	 *                       Details Add,Farmer Details View,OMS Main Report,OMS
	 *                       Event Report,Add OMS Site Assign ,View OMS Site Assign}
	 * @author Ankit Yadav
	 */
	public HomePage moveToAnyModuleToAnySubModule(String mainModuleName, String moduleName, String subModuleName) {
		// main module name
		if (mainModuleName.contains("OMS")) {
			// click on side bar menu
			clickOnSideBarMenu();
			// click on the oms sub-module
			if (moduleName.contains("OMS Dashboard") || moduleName.contains("OMS Details")
					|| moduleName.contains("View Command Area") || moduleName.contains("OMS Bulk Upload")) {
				action.clickOn(driver.findElement(By.xpath("//span[text()='OMS']/../following-sibling::i")),mainModuleName+" drop-down");
				action.clickOn(driver.findElement(
						By.xpath("//span[text()='OMS']/../parent::div/following-sibling::div/a[contains(text(),'"
								+ moduleName.trim() + "')]")),moduleName);

			} else if (moduleName.contains("Village Area Add/View") || moduleName.contains("OMS Add/View")
					|| moduleName.contains("Farmer Details Add/View") || moduleName.contains("OMS Report")
					|| moduleName.contains("OMS Site Assign")) {
				action.clickOn(driver.findElement(By.xpath("//span[text()='OMS']/../following-sibling::i")),mainModuleName+" drop-down");
				// click on sub module name
				action.clickOn(driver
						.findElement(By.xpath("//span[contains(text(),'" + moduleName.trim() + "')]/../parent::div")),moduleName+" drop-down");
				action.clickOn(driver.findElement(By.xpath("//span[contains(text(),'" + moduleName.trim()
						+ "')]/../parent::div/following-sibling::div/a[contains(text(),'" + subModuleName + "')]")),subModuleName);

			}

		} else if (mainModuleName.contains("AMS")) {
			// not for today
		}
		return new HomePage(driver);
	}

	/**
	 * this method is used to navigate to OmsAddPage
	 *
	 * @param driver
	 * @return
	 */
	public OmsDetailsPage navigateToOmsDetailsPage(WebDriver driver) {
		return new OmsDetailsPage(driver);
		
		// ankit
	}

	/**
	 * this method is used to navigate to oms view page
	 *
	 * @param driver
	 * @return
	 */
	public OmsDetailsGetPage navigateToOmsViewPage(WebDriver driver) {
		return new OmsDetailsGetPage(driver);
	}

	/**
	 * By this methods we can directly move to the dashboards page
	 */
	public DashboardPage moveToDashboardsPage() {
		action.clickOn(button_oms," oms panel");
		return new DashboardPage(driver);
	}
}
