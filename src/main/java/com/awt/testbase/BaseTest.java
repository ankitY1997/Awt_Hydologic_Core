package com.awt.testbase;

import java.lang.reflect.Method;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.awt.utills.reusablecomponents.AwtUtilities;
import com.awt.utills.reusablecomponents.ExcelOperations;
import com.awt.utills.reusablecomponents.PropertiesOperations;
import com.awt.utills.reusablecomponents.Retry;

public class BaseTest {

	@Parameters({ "MaxRetry" })
	@BeforeMethod
	public void launchBrowser(@Optional(value = "0") String MaxRetry) {
		try {
			int retryCount = Integer.parseInt(MaxRetry);
			Retry.setRetryCount(retryCount);
			DriverFactory.iuiDriver().setDriver(
					new BrowserFactory().createBrowserInstance(PropertiesOperations.getPropertyValueByKey("Browser")));
			System.out.println("*********************Sucessfully launch To The Browser*********************");
			DriverFactory.iuiDriver().getDriver().manage().window().maximize();
			DriverFactory.iuiDriver().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			DriverFactory.iuiDriver().getDriver().get(PropertiesOperations.getPropertyValueByKey("URL"));
			System.out.println("*********************Sucessfully Navigate To The Url*********************");
			AwtUtilities.waitForPageLoading(DriverFactory.iuiDriver().getDriver());
		} catch (Exception e) {
			System.out.println("*****************Unable To Navigate To The Url**********");
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void tearUp() {
		// iui_driver.close();
		if (DriverFactory.iuiDriver().getDriver() != null) {
			DriverFactory.iuiDriver().getDriver().quit();
			DriverFactory.iuiDriver().closeBrowser();
			System.out.println("***********************Closed The Browser**********************");
		} else {
			DriverFactory.iuiDriver().getDriver().quit();
			DriverFactory.iuiDriver().closeBrowser();
			System.out.println("**************Driver Is Null************************");

		}
	}

	@DataProvider(name = "LogInCrendenital")
	public synchronized String[][] getLogInCredentials(Method method) {
		return ExcelOperations.getAllRecords("LoginCredentialDetails",method.getName().trim());

	}

}
