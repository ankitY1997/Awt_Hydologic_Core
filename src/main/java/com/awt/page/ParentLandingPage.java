package com.awt.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.awt.page.Irrigation.Login.LoginPage;
import com.awt.utills.reusablecomponents.ActionEngine;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class ParentLandingPage {
	
	/** Action Engine instance variable **/
	ActionEngine action = null;

	/** driver instance Variable ***/
	WebDriver driver = null;

	// **Custom Constructor**/
	public ParentLandingPage(WebDriver driver) {

		this.driver = driver;
		action = new ActionEngine(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to select the project name
	 * 
	 * @param project_name {we need to passs the project )
	 * @return LoginPage instance
	 * @author Ankit Yadav
	 */
	public  LoginPage selectProject(String project_name, String url) {

		try {
			driver.get(url);
			AwtUtilities.waitForPageLoading(driver);
			action.waitForVisibility(
					driver.findElement(By.xpath("//h2[text()='" + project_name + "']/../preceding-sibling::a")),
					action.implicit_wait);
			action.clickOn(driver.findElement(By.xpath("//h2[text()='" + project_name + "']/../preceding-sibling::a")),
					project_name);
			System.out.println(
					"*********************Sucessfully Navigate To The Irrigation Project Url*********************");
			return new LoginPage(driver);
		} catch (Exception e) {
			System.out.println(
					"*********************Failed To Navigate To The Irrigation Project The Url*********************");
			return null;
		}

	}

}
