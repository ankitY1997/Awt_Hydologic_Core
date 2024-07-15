package com.awt.page.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
}


