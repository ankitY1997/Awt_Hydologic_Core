package com.awt.page.Admin.CreateProject;

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
	public static final String report = "Report";

	// ************Xpaths ***************************//

	// ** xpath for project management drop down button **/
	@FindAll({ @FindBy(xpath = "//span[text()='Project Management']") })
	private WebElement project_mang_drop_down;

	// ** Number Of Project **/

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
		action.clickOn(driver.findElement(By.xpath(
				"//span[text()='Project Management']/../following-sibling::ul//*[text()='" + menu_item.trim() + "']")),
				menu_item);
	}

	// over loaded method
	public void selectProjectManagementMenuItem(String menu, String sub_menu) {
		// select menu
		action.clickOn(driver.findElement(
				By.xpath("//ul[@role='menu'][1]/li/a/i/following-sibling::span[text()='" + menu + "'][1]")));
		// select sub menu
		action.clickOn(driver.findElement(
				By.xpath("//ul[@role='menu'][1]/li/a/i/following-sibling::span[text()='" + sub_menu + "'][1]")));

	}

	/**
	 * By this method we can navigate to the "Admin_Create_Project_Page".
	 * 
	 * @author Ankit yadav
	 * @return
	 */

	public AdminCreateProjectPage clickCreateProjectButtonAndNavigateToAdminCreateProjectPage() {
		// select the create project menu
		selectProjectManagementMenuItem(create_project);
		return new AdminCreateProjectPage(driver);
	}

	// over loaded method
	public AdminCreateProjectPage clickCreateProjectButtonAndNavigateToAdminCreateProjectPage(String menu,
			String sub_menu) {
		// select the create project menu
		selectProjectManagementMenuItem(menu, sub_menu);
		return new AdminCreateProjectPage(driver);
	}

	/**
	 * To Check The Project Management Button Is VIsible
	 * 
	 * @return
	 */
	public boolean isProjectManagmentButtonPresent() {
		action.implicitWait(project_mang_drop_down, action.implicit_wait);
		return action.isDisplay(project_mang_drop_down);
	}

	/**
	 * To get home Page Title
	 * @return
	 */
	public String getHomePageTitle() {
		return driver.getTitle().trim();
	}

}
