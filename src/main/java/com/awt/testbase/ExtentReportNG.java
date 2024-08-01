package com.awt.testbase;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.awt.utills.reusablecomponents.PropertiesOperations;

/**
 * By THis Class We Are Doing The Configuration Of Extent Report
 *
 * @author Ankit yadav
 */

public class ExtentReportNG {

	static ExtentReports extent;

	public static ExtentReports setupExtentReport() {
		// provide a format of date
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		// date object
		Date date = new Date();
		String actual_date = format.format(date);
		// path of report
		// String path = "./TestResult/Report/ExecutionReport_" + actual_date + ".html";
		String path = "./TestResult/Report/ExecutionReport" + ".html";
		// object of extent spark report
		ExtentSparkReporter spark_report = new ExtentSparkReporter(path);
		// object of extent report
		extent = new ExtentReports();
		// attaching the spark report along with path
		extent.attachReporter(spark_report);
		// configuration of spark report
		spark_report.config().setDocumentTitle("DoucmentTitle");
		spark_report.config().setTheme(Theme.STANDARD);
		spark_report.config().setReportName("Report");
		// configuration of extent report
		try {
		extent.setSystemInfo("Executed  on Enviorment :", PropertiesOperations.getPropertyValueByKey("ADMINURL"));
		}catch(Exception e) {
			extent.setSystemInfo("Executed  on Enviorment :", PropertiesOperations.getPropertyValueByKey("USERURL"));
		}
		extent.setSystemInfo("Executed  on Browser :", PropertiesOperations.getPropertyValueByKey("Browser"));
		extent.setSystemInfo("Executed  on OS :", System.getProperty("os.name"));
		extent.setSystemInfo("Executed  By USER :", System.getProperty("user.name"));
		return extent;
	}

}
