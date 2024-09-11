package com.awt.page.User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awt.page.User.AdminConfiguration.AdminPage;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.ActionEngine;
import com.awt.utills.reusablecomponents.AwtUtilities;

import io.reactivex.rxjava3.functions.Action;

public class ParentLandingPage {

	/* xpath for log out button */
	@FindAll({ @FindBy(xpath = "//span[text()='Logout']/parent::button") })
	private WebElement btn_logout;

	// ** ActionEngine Class Insatnce Variable **/
	public ActionEngine action = null;

	// *****webDriver Instance Variable*******/
	public WebDriver driver = null;

	/**
	 * Custom Constructor
	 */
	public ParentLandingPage(WebDriver driver) {
		this.driver = driver;
		action = new ActionEngine(driver);
		// Initializing the WebDriver Elements
		PageFactory.initElements(driver, this);

	}

	/**
	 * With Help Of This Method We Can Click On Log Out button
	 */
	public void clickOnLogoutButton() {
		action.waitForVisibility(btn_logout, action.implicit_wait);
		action.clickOn(btn_logout, "Log Out");
	}

	/**
	 * Get Home Page Url
	 * 
	 * @return
	 */
	public String getHomePageUrl() {
		action.waitForVisibility(btn_logout, action.implicit_wait);
		return action.getUrl(driver).trim();
	}

	/**
	 * By help Of this method we can navigate to Entered Project Page
	 * 
	 * @param project_name
	 * @return
	 */
	public ParentLandingPage goToProjectPage(String project_name) {
		// wait For page Load
		AwtUtilities.waitForPageLoading(driver);

		switch (project_name.toLowerCase()) {
		case "admin":
			action.waitForVisibility(
					driver.findElement(By.xpath("//div[@id='mainbox']/div//*[text()='Admin']/../preceding-sibling::a")),
					action.implicit_wait);
			action.clickOn(
					driver.findElement(By.xpath("//div[@id='mainbox']/div//*[text()='Admin']/../preceding-sibling::a")),
					project_name);
			return new AdminPage(driver);
		case "Irrigation":
			action.waitForVisibility(
					driver.findElement(
							By.xpath("//div[@id='mainbox']/div//*[text()='Irrigation']/../preceding-sibling::a")),
					action.implicit_wait);
			action.clickOn(
					driver.findElement(
							By.xpath("//div[@id='mainbox']/div//*[text()='Irrigation']/../preceding-sibling::a")),
					project_name);
			return new AdminPage(driver);

		case "water supply":
			action.waitForVisibility(
					driver.findElement(
							By.xpath("//div[@id='mainbox']/div//*[text()='Water Supply']/../preceding-sibling::a")),
					action.implicit_wait);
			action.clickOn(
					driver.findElement(
							By.xpath("//div[@id='mainbox']/div//*[text()='Water Supply']/../preceding-sibling::a")),
					project_name);
			return new AdminPage(driver);

		default:
			MyLogger.info("Please Pass The Correct Project Name You Have Passed Wrong project Name :" + project_name);
			return null;
		}
	}

	
}
