package com.awt.utills.reusablecomponents;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.awt.testbase.DriverFactory;
import com.awt.testbase.ExtentFactory;
import com.awt.testbase.ExtentReportNG;
import com.awt.testbase.MyLogger;

/**
 * @author Ankit Yadav
 */
public class ITestListeners implements ITestListener {
	static ExtentReports report;
	ExtentTest test;
//	public static String method_name = null;
//	public static String class_name = null;
//	public static String test_name = null;
	static ExtentFactory extent_factory = ExtentFactory.extentObject();

	@Override
	public void onTestStart(ITestResult result) {

		test = report.createTest(result.getMethod().getMethodName().toString());
		extent_factory.setExtent(test);
//		method_name = extent_factory.getExtent().toString();
//		class_name = result.getTestClass().toString();
//		test_name = result.getTestName();

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			extent_factory.getExtent().log(Status.PASS,
					"Test Case :" + result.getMethod().getMethodName() + " Is Pass");
			MyLogger.info("Test Case :" + result.getMethod().getMethodName() + " Is Pass");
		} finally {
			extent_factory.removeExtentTestObject();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			extent_factory.getExtent().log(Status.FAIL,
					"Test Case :" + result.getMethod().getMethodName() + " Is Fail");
			extent_factory.getExtent().log(Status.FAIL, result.getThrowable());
			// taking Screen shot
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH:mm:ss");
			Date date = new Date();
			String actual_date = format.format(date);
			String screenshot_path = "./TestResult/Screenshot/" + result.getMethod().getMethodName().toString()
					+".jpeg";
			File dest = new File(screenshot_path);
			File src = ((TakesScreenshot) DriverFactory.iuiDriver().getDriver()).getScreenshotAs(OutputType.FILE);
			String screen_shot = ((TakesScreenshot) DriverFactory.iuiDriver().getDriver())
					.getScreenshotAs(OutputType.BASE64);
			FileUtils.copyFile(src, dest);
			extent_factory.getExtent().addScreenCaptureFromPath(screenshot_path,
					"" + result.getMethod().getMethodName() + "Test Case Failure ScreenShot");
			extent_factory.getExtent().addScreenCaptureFromBase64String(screen_shot);

		} catch (Exception e) {

			// TODO Auto-generated catch block
			MyLogger.info("Test Case :" + result.getMethod().getMethodName() + " Is Failed Due To This Exception :", e);

		} finally {
			extent_factory.removeExtentTestObject();
			MyLogger.info("CAPTURED FAILURE SCREEN SHOT FOR :" + result.getMethod().getMethodName() + " Method");
		}

	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		try {
			extent_factory.getExtent().log(Status.SKIP,
					"Test Case :" + result.getMethod().getMethodName() + " Is Skipped");
		} catch (Exception e) {
			MyLogger.info("Test Case :" + result.getMethod().getMethodName() + " Is Skip Due To This Exception :", e);
		} finally {
			// MyLogger.info("Test Case :" + result.getMethod().getMethodName() + " Is Skip
			// Due To This Exception :", th);
			extent_factory.removeExtentTestObject();
		}

	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		try {
			MyLogger.info("Test Case :" + result.getMethod().getMethodName() + " Is Failed Due To Time Out");
		} finally {
			extent_factory.removeExtentTestObject();
		}
	}

	@Override
	public void onStart(ITestContext context) {
		report = ExtentReportNG.setupExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		// to flush the report
		report.flush();

	}

}
