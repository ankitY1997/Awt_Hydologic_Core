package com.awt.page.User.AdminConfiguration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.awt.page.User.ParentLandingPage;
import com.awt.page.User.AdminConfiguration.User.CreateRole.AdminAddRolePage;
import com.awt.page.User.AdminConfiguration.User.CreateUser.AdminAddUserPage;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class AdminPage extends ParentLandingPage {

	// *******Drop_down Name************/
	public static final String user = "User";
	public static final String settings = "Settings";
	// ********** Options Name**************/
	public static final String create_role = "Create Role";
	public static final String create_user = "Create User";
	public static final String user_restriction = "User Restriction";
	public static final String master_creation = "Master Creation";
	public static final String notification_settings = "Notification Settings";
	public static final String page_permission = "Page Permission";
	public static final String report_template = "Report Template";

	/**
	 * 
	 * @param driver
	 */
	public AdminPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * help Of This Method We Can Chose Any Options Under Drop-Down
	 * 
	 * @param dropDownName    { We need To Pass The Drop-Down Name}
	 * @param dropDownOptions {We Need To Pass Options Which Are present under the
	 *                        drop-down
	 */
	public void selectDropDownOptions(String dropDownName, String dropDownOptions) {
		// Wait For Page Load
		AwtUtilities.waitForPageLoading(driver);
		// wait for Element
		action.waitForVisibility(
				driver.findElement(
						By.xpath("(//ul[@role='menu'])[1]/li//span[text()='" + dropDownName + "']/./parent::a")),
				action.implicit_wait);
		// click on drop down menu
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
	 * By Help Of This Method We Can navigate To Admin Role Page
	 * 
	 * @return Admin Add Role Page Object
	 */
	public AdminAddRolePage navigateToAdminAddRolePage() {
		// select the User module and click on Create Role options
		selectDropDownOptions(user, create_role);
		return new AdminAddRolePage(driver);
	}

	/**
	 * By Help Of This Method We Can navigate To Admin Add User Page
	 * 
	 * @return instance of AdminAddUserPage
	 */
	public AdminAddUserPage navigateToAdminAddUserPage() {
		// select the User module and click on Create Role options
		selectDropDownOptions(user, create_user);
		return new AdminAddUserPage(driver);
	}

}
