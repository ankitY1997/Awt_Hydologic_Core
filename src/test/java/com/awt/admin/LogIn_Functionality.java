package com.awt.admin;

import org.testng.annotations.Test;

import com.awt.page.Home.HomePage;
import com.awt.page.Login.LoginPage;
import com.awt.testbase.BaseTest;
import com.awt.testbase.DriverFactory;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.Description;
import com.awt.utills.reusablecomponents.ExcelOperations;
import com.awt.utills.reusablecomponents.Owner;
import com.awt.utills.reusablecomponents.SoftAssertTest;
import com.awt.utills.reusablecomponents.TestId;

public class LogIn_Functionality extends BaseTest {

	@Description(description = "check the login functionality")
	@Owner(name = "ankit")
	@TestId(id = { 1 })
	@Test
	public void verifyLoginFunctionalityTest() {
		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// SoftAssert instance
		SoftAssertTest asert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// log in to the application
		LoginPage lp = new LoginPage(DriverFactory.iuiDriver().getDriver());
		// -->enter the username and password -> log in to the application
		lp.logInToTheApplication(ExcelOperations.getCellData("LoginCredentialDetails", "Username", "231"),
				ExcelOperations.getCellData("LoginCredentialDetails", "Password", "231"));
		asert.assertEquals(lp.getModuleName(),"OUTLET MANAGEMENT SYSTEM (OMS)'",
				"After log in OUTLET MANAGEMENT SYSTEM (OMS) Module Name Should be Visible" , 01);
		asert.assertAll();

	}

}
