package com.awt.page.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awt.utills.reusablecomponents.ActionEngine;

public class AdminPage {


	// ***********constant variable *********************//
	
	public static final String create_project = "Create Project";
	
	//************Xpaths ***************************//
	
	// ** xpath for project management drop down button **/
	@FindAll({ @FindBy(xpath = "//span[text()='Project Management']") })
	private WebElement project_mang_drop_down;

	// ** Action Engine instance variable **//
	private ActionEngine action;
	

	// **WebDriver instance variable **//
	private WebDriver driver;

	/**
	 * constructor for initializing page objects
	 * 
	 * @author Ankit Yadav
	 */
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		// ActionEngine class objects
		action = new ActionEngine(driver);
		// PageFactory Methods to initialize the Admin Page Web Element
		PageFactory.initElements(driver, this);
	}

	/**
	 * By this method we can select any menu which is present under the Project
	 * Management drop-down.
	 * 
	 * @param menu_item {Create Project, Report}
	 * @author Ankit Yadav
	 */
	public void selectProjectManagementMenuItem(String menu_item) {
		// click on project management menu
		action.clickOn(project_mang_drop_down, "Project Management");
		// select menus items
		action.clickOn(
				driver.findElement(By.xpath(
						"//span[text()='Project Management']/../following-sibling::ul//*[text()='" + menu_item + "']")),
				menu_item);
	}

	/**
	 * By this method we can navigate to the "Admin_Create_Project_Page".
	 * 
	 * @author Ankit yadav
	 * @return
	 */

	public AdminCreateProjectPage navigateToAdminCreateProjectPage() {
		// select the create project menu
		selectProjectManagementMenuItem(create_project);
		return new AdminCreateProjectPage(driver);
	}
}
