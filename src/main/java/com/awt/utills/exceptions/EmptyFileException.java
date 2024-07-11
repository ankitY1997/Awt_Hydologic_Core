package com.awt.utills.exceptions;
/**
 * this is custom exception
 *
 * @author Ankit Yadav
 */
public class EmptyFileException extends RuntimeException {

	public EmptyFileException(String message) {
		invalidKeyExcpetion(message);
	}

	// properties file exception
	public synchronized void invalidKeyExcpetion(String description) {
		System.out.println(description);
	}

}
