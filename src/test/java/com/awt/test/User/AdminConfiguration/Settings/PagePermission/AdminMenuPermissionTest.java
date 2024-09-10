package com.awt.test.User.AdminConfiguration.Settings.PagePermission;

import com.awt.page.Login.LoginPage;
import com.awt.page.User.ParentLandingPage;
import com.awt.page.User.AdminConfiguration.AdminPage;
import com.awt.testbase.BaseTest;
import com.awt.testbase.DriverFactory;
import com.awt.utills.reusablecomponents.PropertiesOperations;
import com.awt.utills.reusablecomponents.SoftAssertTest;

public class AdminMenuPermissionTest extends BaseTest{

	
	// **Instance Variable**//
		public static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
		public static final String admin_project = "Admin";
		SoftAssertTest asert = null;
		LoginPage lp = null;
		ParentLandingPage parent_landing_page = null;
		AdminPage admin_page = null;
		
		
		
	/**
	 * 
	 * Navigate To ParentLandingPage
	 * 
	 */
	public void navigateToParentLandingPage() {
		// SoftAssert instance
		asert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// log in Page instance
		lp = new LoginPage(DriverFactory.iuiDriver().getDriver());
		parent_landing_page = lp.loginAndNavigateToTheParentLandingPage(url, "NKMP1",
				PropertiesOperations.getPropertyValueByKey("SUPERADMIN_USERNAME"),
				PropertiesOperations.getPropertyValueByKey("SUPERADMIN_PASSWORD"));
	}
}
