package com.awt.page.User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.awt.page.User.AdminConfiguration.AdminPage;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.ActionEngine;
import com.awt.utills.reusablecomponents.AwtUtilities;

import io.reactivex.rxjava3.functions.Action;

public class ParentLandingPage {

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
	 * By help Of this method we can navigate to Entered Project Page
	 * @param project_name
	 * @return
	 */
	public ParentLandingPage goToProjectPage(String project_name) {
		//wait For page Load
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
		case "irrigation":
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
