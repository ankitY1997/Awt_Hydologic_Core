package com.awt.page.Irrigation.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.awt.page.Irrigation.Admin.AdminDashboardPage;
import com.awt.page.Irrigation.oms.OmsAdminDashboardPage;
import com.awt.utills.reusablecomponents.ActionEngine;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class HomePage {

	/* xpath for log out button */
	@FindAll({ @FindBy(xpath = "//span[text()='Logout']/parent::button") })
	public WebElement btn_logout;

	/* xpath for profile icon button */
	@FindAll({ @FindBy(xpath = "//li[@id='profile']/button") })
	public WebElement btn_profile_icon;

	/** ActionEngine instance **/
	public ActionEngine action = null;

	// *******Menu Name**************/
	public static final String oms = "OMS";

	/** WebDriver instance **/
	public WebDriver driver = null;

	// ***** Constanst********/

	// **Logout constants**/
	private static final String log_out = "Logout";

	// **Admin constanst**/
	private static final String admin = "Admin";

	// **Reset Password**/
	private static final String reset_password = "Reset Password";

	/* Custom Contructor **/

	public HomePage(WebDriver driver) {
		this.driver = driver;
		action = new ActionEngine(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Get Home Page Url
	 * 
	 * @return
	 */
	public String getHomePageUrl() {
		action.waitForVisibility(btn_profile_icon, action.implicit_wait);
		return action.getUrl(driver).trim();
	}

	/**
	 * With help of This Method We Can Click On Profile Icon
	 */
	public void clickOnProfileIcon() {
		action.waitForVisibility(btn_profile_icon, action.implicit_wait);
		// Click on profile icon
		action.clickOn(btn_profile_icon, "Profile Icon");
	}

	/**
	 * With Help Of This Method We Can Click On Log Out button
	 */
	public void clickOnLogoutButton() {
		selectOptionFromProfile(log_out);
	}

	/**
	 * With help of This Method We Can Click on Admin present under the profile Icon
	 */
	public void clickOnAdminButton() {
		selectOptionFromProfile(admin);
	}

	/**
	 * With help of This Method We Can Click on Admin present under the profile Icon
	 */
	public void clickOnResetPasswordButton() {
		selectOptionFromProfile(reset_password);
	}

	/**
	 * With Help of This Method We Can Select Any Option By passing option name
	 * Which Are Present Under The Profile
	 * 
	 * @param otpion_name ( Here We Need To Pass The Option Name)
	 * @author Ankit yadav
	 */
	public void selectOptionFromProfile(String option_name) {
		// Click on Profile Icon
		clickOnProfileIcon();
		action.waitForVisibility(
				driver.findElement(By.xpath("//li[@id='profile']/ul/li//*[text()='" + option_name + "']")),
				action.implicit_wait);
		action.clickOn(driver.findElement(By.xpath("//li[@id='profile']/ul/li//*[text()='" + option_name + "']")),
				option_name);

	}

	/**
	 * By using this method we can go to admin Dasboard page
	 * 
	 * @return instance of AdminDashboardPage
	 */
	public AdminDashboardPage navigateToAdminDashboardPage() {
		selectOptionFromProfile(admin);
		return new AdminDashboardPage(driver);

	}
	
	/**
	 * By this method we can navigate to Oms Admin Dashboard Page
	 * 
	 * @return instance of OmsAdminDashboardPage
	 */

	public OmsAdminDashboardPage navigateToOmsAdminDashboardPage() {
		// Select The Menu
		selectMainMenu(oms);
		return new OmsAdminDashboardPage(driver);

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

	

}
