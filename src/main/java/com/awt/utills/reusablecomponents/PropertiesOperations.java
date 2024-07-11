package com.awt.utills.reusablecomponents;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.awt.utills.exceptions.EmptyFileException;
/**
 * this class is specially designing for doing an operation of properties file
 * @author Ankit Yadav
 */

public class PropertiesOperations {



	// Properties class instances
	private static Properties pro = new Properties();

	// path of our properties file
	private static File path = new File("./src/test/resources/Configuration/AppData/config.properties");

	public static String getPropertyValueByKey(String key) {
		String value = null;
		try {
			// load properties file
			FileInputStream fis = new FileInputStream(path);
			pro.load(fis);
			// read properties file
			value = pro.get(key).toString();

		} catch (Exception e) {
			throw new EmptyFileException("Value Is Not Specified For Key :" + key + " In Propetie File");
		}
		return value;

	}

}
