package com.awt.test.Home;

import org.testng.annotations.Test;

import com.awt.constants.Genral.HomePageConstants;
import com.awt.constants.Genral.OmsDashboardPageConstants;
import com.awt.page.Home.HomePage;
import com.awt.page.Login.LoginPage;
import com.awt.page.oms_dashboard.DashboardPage;
import com.awt.testbase.BaseTest;
import com.awt.testbase.DriverFactory;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.Description;
import com.awt.utills.reusablecomponents.ExcelOperations;
import com.awt.utills.reusablecomponents.Owner;
import com.awt.utills.reusablecomponents.SoftAssertTest;
import com.awt.utills.reusablecomponents.TestId;

public class VerifyPanelsQuantityTest extends BaseTest {

	@Test
	@Description(description = "verify Panles Quantity available in home page")
	@TestId(id = { 231 })
	@Owner(name = "Ankit ")
	public void verfiyPanelsQuantityTest() {
		// Initializing My Logger
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// soft assert instance
		SoftAssertTest Assert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// log in page object
		LoginPage lp = new LoginPage(DriverFactory.iuiDriver().getDriver());
		// -->enter the username and password -> log in to the application
		lp.logInToTheApplication(ExcelOperations.getCellData("LoginCredentialDetails", "Username", "231"),
				ExcelOperations.getCellData("LoginCredentialDetails", "Password", "231"));
		// --> navigate to the home page
		HomePage hp = lp.navigateToTheHomePage();
		// --> take the count of total oms in oms panel
		int total_oms = hp.getCountOfSpecifiedPanels(HomePageConstants.oms);
		// --> then move to dashboards page
		DashboardPage dp = hp.moveToDashboardsPage();
		// then move to oms details panel and check the total oms quantity
		int totalOms = dp.getTheCountOfOmsDetailsPanel(OmsDashboardPageConstants.total_Oms);
		// both the quantity should be equal
		Assert.assertEquals(total_oms, totalOms, "HomePage Total Oms Qaunatiy Is Equal To The The Oms Details Panel Total Oms Quantity", 231);
		// call assert
		Assert.assertAll();

	}

}
