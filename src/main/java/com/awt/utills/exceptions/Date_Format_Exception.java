package com.awt.utills.exceptions;

/**
 * this is custom exception
 *
 * @author Ankit Yadav
 */
public class Date_Format_Exception extends RuntimeException{

	public Date_Format_Exception(String message) {
		invalidFormatException(message);
	}

	// 
	public synchronized void invalidFormatException(String description) {
		System.out.println(description);
	}
}
