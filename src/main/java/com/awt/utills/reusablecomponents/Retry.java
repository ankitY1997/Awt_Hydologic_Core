package com.awt.utills.reusablecomponents;

/**
 * @author Ankit Yadav
 */
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	private static int retryCount = 0;
	private static int retryMaxCount =0;

	/**
	 * Below method returns 'true' if the test method has to be retried else 'false'
	 * and it takes the 'Result' as parameter of the test method that just ran
	 */

	@Override
	public boolean retry(ITestResult result) {

		if (retryCount < retryMaxCount) {
			System.out.println("Retrying test " + result.getName() + " with status "
					+ getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
			retryCount++;
			return true;
		}

		return false;
	}

	public String getResultStatusName(int status) {
		String resultName = null;
		if (status == 1) {
			resultName = "SUCCESS";
		}
		if (status == 2) {
			resultName = "FAILURE";
		}
		if (status == 3) {
			resultName = "SKIP";
		}
		return resultName;
	}

	/**
	 * By this method we can set retry Max count
	 *
	 * @param time
	 */
	public static void setRetryCount(int time) {
		if (time > 0) {
			retryMaxCount = time;
		}
	}
}
