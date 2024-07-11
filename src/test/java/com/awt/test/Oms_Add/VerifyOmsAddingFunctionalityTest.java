package com.awt.test.Oms_Add;

import org.testng.annotations.Test;

import com.awt.constants.Genral.HomePageConstants;
import com.awt.constants.Genral.OmsDetailsGetPageConstants;
import com.awt.constants.Menu.MainMenuConstants;
import com.awt.page.Home.HomePage;
import com.awt.page.Login.LoginPage;
import com.awt.page.oms_Add.OmsDetailsPage;
import com.awt.page.oms_view.OmsDetailsGetPage;
import com.awt.testbase.BaseTest;
import com.awt.testbase.DriverFactory;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.Description;
import com.awt.utills.reusablecomponents.ExcelOperations;
import com.awt.utills.reusablecomponents.Owner;
import com.awt.utills.reusablecomponents.SoftAssertTest;
import com.awt.utills.reusablecomponents.TestId;

public class VerifyOmsAddingFunctionalityTest extends BaseTest {

	@Test
	@Description(description = " To chek user is able to add oms ")
	@TestId(id = {290 })
	@Owner(name = "Ankit")
	public void verfiyOmsAddingFunctionalityTest() {
		// Initializing My Logger
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		SoftAssertTest Assert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// login to the application-->
		LoginPage lp = new LoginPage(DriverFactory.iuiDriver().getDriver());
		lp.logInToTheApplication(ExcelOperations.getCellData("LoginCredentialDetails", "Username", ""),
				ExcelOperations.getCellData("LoginCredentialDetails", "Password", "101"));
		// navigate to home page-->
		HomePage hp = lp.navigateToTheHomePage();
		// click on the hamburger menu icon button ->
		// then click on Oms drop down button-->
		// then click on Oms Add/View button-->
		// then click on Oms Add button-->
		hp.moveToAnyModuleToAnySubModule(HomePageConstants.oms, MainMenuConstants.oms_Add_view,
				MainMenuConstants.oms_Add);
		// -> navigate to oms add page-->
		OmsDetailsPage oms_add = hp.navigateToOmsDetailsPage(DriverFactory.iuiDriver().getDriver());
		// fill all oms details-->
		oms_add.fillOmsDetails(ExcelOperations.getCellData("Oms_Details", "Village", "290"),
				ExcelOperations.getCellData("Oms_Details", "Oms_Id", "290"),
				ExcelOperations.getCellData("Oms_Details", "Device_Id", "290"),
				ExcelOperations.getCellData("Oms_Details", "Oms_Area", "290"),
				ExcelOperations.getCellData("Oms_Details", "Chak_Leader", "290"),
				ExcelOperations.getCellData("Oms_Details", "Chak_leader_Contact", "290"),
				ExcelOperations.getCellData("Oms_Details", "Technical_Person", "290"),
				ExcelOperations.getCellData("Oms_Details", "Technical_Person_Contact", "290"),
				ExcelOperations.getCellData("Oms_Details", "Latitude", "290"),
				ExcelOperations.getCellData("Oms_Details", "Longitude", "290"),
				ExcelOperations.getCellData("Oms_Details", "Maximum_Inlet_Pressure", "290"));
		// then click on oms view button-->
		hp.moveToAnyModuleToAnySubModule(HomePageConstants.oms, MainMenuConstants.oms_Add_view,
				MainMenuConstants.oms_View);
		// navigate to the oms view page -->
		OmsDetailsGetPage oms_view = hp.navigateToOmsViewPage(DriverFactory.iuiDriver().getDriver());
		// the search the oms id in search text field
		oms_view.SearchValue(ExcelOperations.getCellData("Oms_Details", "Oms_Id", "290"));
		// then check created oms id present in teh oms view table
		Assert.assertTrue(oms_view.isOmsDetailPresent(OmsDetailsGetPageConstants.oms_id,ExcelOperations.getCellData("Oms_Details", "Oms_Id", "290")),
				"Oms Id Is Present In OMS View Table", 290);
		// then delete a created oms id
		oms_view.deletOmsId();
		Assert.assertAll();

	}

}
