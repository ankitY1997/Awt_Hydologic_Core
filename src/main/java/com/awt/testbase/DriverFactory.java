package com.awt.testbase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	private static DriverFactory instance = new DriverFactory();

	// instance of thread local
	ThreadLocal<WebDriver> th_driver = new ThreadLocal<>();

	// can not create instance
	private DriverFactory() {

	}

	// Encapsulation
	public static DriverFactory iuiDriver() {
		return instance;
	}

	// set driver methods
	public void setDriver(WebDriver driver) {
		th_driver.set(driver);
	}

	// get driver method
	public WebDriver getDriver() {
		return th_driver.get();

	}

	// close methods
	public void closeBrowser() {
		th_driver.remove();
	}

}
