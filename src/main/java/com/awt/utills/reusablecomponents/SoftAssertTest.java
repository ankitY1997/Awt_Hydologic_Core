package com.awt.utills.reusablecomponents;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.awt.testbase.ExtentFactory;
import com.awt.testbase.MyLogger;

/**
 * Soft Assert Test that asserts the validation and also populate the test
 * Result for each mapped test cases with the test method
 *
 * @author Ankit Yadav
 */
public class SoftAssertTest {

	/** PASS */
	public static final String PASS = "PASS";

	/** FAIL */
	public static final String FAIL = "FAIL";

	/** SKIP */
	public static final String SKIP = "SKIP";

	/** TestNG Soft Assert */
	SoftAssert softAssert = null;

	/** Custom Logger */
	private ExtentTest logger;

	/** IUIDriver */
	private WebDriver iUIDriver;

	/** Initialize custom SoftAssertTest */
	public SoftAssertTest(WebDriver driver) {
		softAssert = new SoftAssert();
		logger = ExtentFactory.extentObject().getExtent();
		iUIDriver = driver;
	}

	/**
	 * Assert True
	 *
	 * @param testId
	 * @param condition
	 * @param message
	 */
	public void assertTrue(boolean condition, String message, int testIds) {
		boolean isPass = false;
		try {
			softAssert.assertTrue(condition, message);
			org.testng.Assert.assertTrue(condition);
			isPass = true;
		} catch (AssertionError error) {
		} finally {
			String reportMessage = "Soft Assert " + ((isPass) ? "Passed" : "Failed") + " for method: 'assertTrue' - "
					+ message + " [Expected: 'true'] [Actual: '" + condition + "']";
			logToReport(isPass, reportMessage, testIds);
			logToConsole(isPass, reportMessage, testIds);
		}
	}

	/**
	 * Assert False
	 *
	 * @param testId
	 * @param condition
	 * @param message
	 */
	public void assertFalse(boolean condition, String message, int testIds) {
		boolean isPass = false;
		try {
			softAssert.assertFalse(condition, message);
			org.testng.Assert.assertFalse(condition);
			isPass = true;
		} catch (AssertionError error) {
		} finally {
			String reportMessage = "Soft Assert " + ((isPass) ? "Passed" : "Failed") + " for method: 'assertFalse' - "
					+ message + " [Expected: 'false'] [Actual: '" + condition + "']";
			logToReport(isPass, reportMessage, testIds);
			logToConsole(isPass, reportMessage, testIds);
		}
	}

	/**
	 * Assert Equals
	 *
	 * @param testId
	 * @param actual
	 * @param expected
	 * @param message
	 */
	public void assertEquals(Object actual, Object expected, String message, int testIds) {
		boolean isPass = false;
		try {
			softAssert.assertEquals(actual, expected);
			org.testng.Assert.assertEquals(actual, expected);
			isPass = true;
		} catch (AssertionError error) {
		} finally {
			String reportMessage = "Soft Assert " + ((isPass) ? "Passed" : "Failed") + " for method: 'assertEquals' - "
					+ message + " [Expected: '" + expected + "'] [Actual: '" + actual + "']";
			logToReport(isPass, reportMessage, testIds);
			logToConsole(isPass, reportMessage, testIds);
		}
	}

	/**
	 * Assert Not Equals
	 *
	 * @param actual
	 * @param expected
	 * @param message
	 * @param testIds
	 */
	public void assertNotEquals(Object actual, Object expected, String message, int testIds) {
		boolean isPass = false;
		try {
			softAssert.assertNotEquals(actual, expected);
			org.testng.Assert.assertNotEquals(actual, expected);
			isPass = true;
		} catch (AssertionError error) {

		} finally {
			String reportMessage = "Soft Assert " + ((isPass) ? "Passed" : "Failed")
					+ " for method: 'assertNotEquals' - " + message + " [Expected: '" + expected + "'] [Actual: '"
					+ actual + "']";
			// System.out.println(reportMessage);
			logToReport(isPass, reportMessage, testIds);
			logToConsole(isPass, reportMessage, testIds);
		}
	}

	public void logToReport(boolean flag, String message, int testIds) {
		if (flag) {
			logger.log(Status.PASS, message + " [ TestId :" + (testIds) + "]");
		} else {
			logger.log(Status.FAIL, message + " [ TestId :" + (testIds) + "]");
		}
	}

	public void logToConsole(boolean flag, String message, int testIds) {
		MyLogger.info(message + "[TestId :" + (testIds) + "]");

	}

	/**
	 * Assert All
	 */
	public void assertAll() {
		softAssert.assertAll();
	}

}
