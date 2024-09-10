package com.awt.page.User.AdminConfiguration.Settings.Page_Permission;

import org.openqa.selenium.WebDriver;

import com.awt.page.User.AdminConfiguration.AdminPage;

public class AdminMenuPermissionPage extends AdminPage {

	// ** Constructor**/
	public AdminMenuPermissionPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * By This Method We Can Check Page Permission button is visible or not
	 * 
	 * @return if it's visible then its return true and if its not visible then it's
	 *         return false
	 */
	public boolean isPagePermissionButtonVisible() {
		return flag;
	}
}
