package com.awt.testbase;

import com.aventstack.extentreports.ExtentTest;

/**
 * In THis Class We Are Creating Thread Safe Enviroment for Extent Report
 *
 * @author Ankit Yadav
 */
public class ExtentFactory {

	// current class object
		private static ExtentFactory instance = new ExtentFactory();
		// THread local Objet
		ThreadLocal<ExtentTest> extent_test = new ThreadLocal<>();

		// contructor
		private ExtentFactory() {

		}

		public static ExtentFactory extentObject() {
			return instance;
		}

		public void setExtent(ExtentTest extent_object) {
			extent_test.set(extent_object);
		}

		public ExtentTest getExtent() {
			return extent_test.get();
		}

		public void removeExtentTestObject() {
			extent_test.remove();
		}


}
