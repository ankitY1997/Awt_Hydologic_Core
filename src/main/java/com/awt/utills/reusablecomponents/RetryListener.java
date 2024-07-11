package com.awt.utills.reusablecomponents;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * @author Ankit Yadav
 */
public class RetryListener implements IAnnotationTransformer {
	/**
	 * listener implementation for Testng file
	 */
	@Override
	public void transform(ITestAnnotation annotation, @SuppressWarnings("rawtypes") Class testClass, @SuppressWarnings("rawtypes") Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(Retry.class);
	}
}
