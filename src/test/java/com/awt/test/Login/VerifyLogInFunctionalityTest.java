package com.awt.test.Login;

import org.testng.annotations.Test;

import com.awt.constants.Genral.LoginPageConstants;
import com.awt.page.Login.LoginPage;
import com.awt.testbase.BaseTest;
import com.awt.testbase.DriverFactory;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.Description;
import com.awt.utills.reusablecomponents.ExcelOperations;
import com.awt.utills.reusablecomponents.Owner;
import com.awt.utills.reusablecomponents.SoftAssertTest;
import com.awt.utills.reusablecomponents.TestId;
/**
 * @author Ankit Yadav
 */
public class VerifyLogInFunctionalityTest extends BaseTest {

	@Test
	@Description(description = "verify login functionality")
	@TestId(id = { 290, 220 })
	@Owner(name = "Ankit ")
	public void verifyLogInFunctionalityTest() throws InterruptedException {
		// Initializing My Logger
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// soft assert instance
		// System.out.println(data);
		SoftAssertTest Assert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// log in page object
		LoginPage lp = new LoginPage(DriverFactory.iuiDriver().getDriver());
		// AwtJsonReaderUtills
		// AwtJsonReaderUtills jsonReader = new AwtJsonReaderUtills(data);
		// -->enter the username and password -> log in to the application
		lp.logInToTheApplication(ExcelOperations.getCellData("LoginCredentialDetails", "Username", "290"),
				ExcelOperations.getCellData("LoginCredentialDetails", "Password", "290"));
		// --> naviagate to the home page and verfiy the project name of the homepage
		Assert.assertEquals(lp.getProjectName(), LoginPageConstants.project_name, "project name is visible ", 290);
		// --> then log out fromt the application and try to login the application
		lp.navigateToTheHomePage().clickOnLogOutButton();
		// then again enter the invalid username and valid password
		lp.logInToTheApplication(ExcelOperations.getCellData("LoginCredentialDetails", "Username", "220"),
				ExcelOperations.getCellData("LoginCredentialDetails", "Username", "220"));
		// verfiy error message should be visible
		Assert.assertEquals(lp.getErrorMessage(),LoginPageConstants.error_message, "verfiy error message ", 220);
		Assert.assertAll();

	}

	@Test(dataProvider = "LogInCrendenital")
	@Description(description = "verify login credentiald")
	@TestId(id = { 290, 220 })
	@Owner(name = "Ankit ")
	public void verifyLogInCredentialsTest(String TestCaseId, String Username, String Password) {
		// Initializing My Logger
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// soft assert instance
		// System.out.println(data);
		SoftAssertTest Assert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// log in page object
		LoginPage lp = new LoginPage(DriverFactory.iuiDriver().getDriver());
		// -->enter the username and password -> log in to the application
		lp.logInToTheApplication(Username, Password);
		// --> naviagate to the home page and verfiy the project name of the homepage
		Assert.assertEquals(lp.getProjectName(), LoginPageConstants.project_name, "project name is visible ", 290);
		System.out.println();
        Assert.assertAll();
	}

}
