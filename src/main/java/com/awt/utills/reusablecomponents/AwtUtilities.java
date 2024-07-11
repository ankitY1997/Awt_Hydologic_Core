package com.awt.utills.reusablecomponents;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Ankit Yadav
 */
public class AwtUtilities {

	/** Random String Object **/
	protected static RandomStringUtils random = new RandomStringUtils();

	/**
	 * this method is used to generate random string according to the length
	 *
	 * @param length
	 * @return String
	 */
	public static String genrateRandomString(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	/**
	 * this method is used to generate random number according to the given length
	 *
	 * @param length
	 * @return
	 */
	public static String genrateRandomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	/**
	 * this method is used to remove all the alphabets from the string
	 *
	 * @param value
	 * @return
	 */
	public static int removeAllAlphabets(String value) {
		String tempString = "";
		for (int i = 0; i < value.trim().length(); i++) {
			char c = value.charAt(i);
			if (c >= 48 && c <= 57) {
				tempString = tempString + String.valueOf(c);
			}
		}
		return Integer.parseInt(tempString);
	}

	/**
	 * By this methods helps we can stop the thread at certain period of time
	 *
	 * @param time
	 */
	public static void waitFor(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// *******JAVA SCRIPS METHODS******//

	/**
	 * click by Java Script Executor
	 *
	 * @param element
	 */
	public static void javascriptClick(WebDriver driver, WebElement element) {
		try {
			ActionEngine action = new ActionEngine(driver);
			action.waitForVisibility(element, ActionEngine.implicit_wait);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			System.out.println("Unable To Click On The " + e.getMessage().toString());
		}
	}

	/**
	 * Send keys to the given WebElement using JavaScript Executor.
	 *
	 * @param driver  The WebDriver instance.
	 * @param element The WebElement to send keys to.
	 * @param keys    The keys to send (e.g., "Hello").
	 */
	public static void SendKeysWithJavaScript(WebDriver driver, WebElement element, String keys) {
		try {
			ActionEngine action = new ActionEngine(driver);
			action.waitForVisibility(element, ActionEngine.implicit_wait);
			clearTextUsingJs(driver, element);
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].value = arguments[1];", element, keys);
		} catch (Exception e) {
			System.out.println("Failed to send keys using JavaScript Executor." + e);
		}
	}

	/**
	 * Clear the text of a WebElement using JavaScript Executor.
	 *
	 * @param driver  The WebDriver instance.
	 * @param element The WebElement to clear the text.
	 */
	public static void clearTextUsingJs(WebDriver driver, WebElement element) {
		try {
			element.click();
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].value='';", element);
		} catch (Exception e) {
			System.out.println("Failed to clear text using JavaScript." + e);
		}
	}

	/**
	 * This method retrieves the text of a WebElement using JavaScript Executor.
	 *
	 * @param driver  The WebDriver instance.
	 * @param element The WebElement from which to retrieve the text.
	 * @return The text present in the WebElement.
	 */
	public static String getTextUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
		String text = "";
		try {
			ActionEngine action = new ActionEngine(driver);
			action.waitForVisibility(element, ActionEngine.implicit_wait);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			// WebElement element1 = uiDriver().getDriver().findElement(By.xpath(element));
			text = (String) jse.executeScript("return arguments[0].innerText", element);
		} catch (Exception ex) {
			System.out.println("Failed to get the text of the respective WebElement." + ex);
		}
		return text;
	}

	/**
	 * Wait for page loading to complete.
	 *
	 * @param driver The WebDriver instance.
	 */
	public static void waitForPageLoading(WebDriver driver) {
		boolean flag = false;
		Exception exception = null;
		int i = 0;
		while (i <= 120) {
			try {
				boolean isDomReady = (boolean) ((JavascriptExecutor) driver)
						.executeScript("return document.readyState === 'complete'");
				if (isDomReady) {
					flag = true;
					break;
				}
			} catch (Exception e) {
				exception = e;
				// waitFor(5000);
			}
			i++;
		}
		if (!flag) {
			System.out.println("Failed to wait for page loading." + exception);
		}
	}

	/**
	 * Scroll to the specified element using JavaScript Executor.
	 *
	 * @param driver  The WebDriver instance.
	 * @param element The WebElement to scroll to.
	 */
	public static void scrollToElement(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			System.out.println("Failed to scroll to the element." + e);
		}
	}

	/**
	 * Perform a hover action on the given WebElement using JavaScript.
	 *
	 * @param webElement The WebElement to hover over.
	 * @author AWT Tester
	 */
	public static void performHoverWithJavaScript(WebDriver driver, WebElement webElement) {
		try {
			String script = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initEvent('mouseover', true, false);" + "arguments[0].dispatchEvent(evObj);";
			((JavascriptExecutor) driver).executeScript(script, webElement);
		} catch (Exception e) {
			System.out.println("Failed to perform hover action using JavaScript." + e);
		}
	}

	/**
	 * This method is created to wait for the given time.
	 *
	 *
	 * @param driver Variable driver of type Webdriver
	 *
	 * @param time   Variable time of type Integer
	 *
	 *
	 * @throws InterruptedException If the thread is interrupted during the waiting
	 *                              activity.
	 *
	 * @since version 1.0
	 * @author AWT Tester
	 */

	public void justwait(WebDriver driver, int time) throws InterruptedException {
		synchronized (driver) {
			driver.wait(time);
		}
	}

	/**
	 * By this method we are able to find every table data according to column
	 *
	 * @param driver->      passes driver instance
	 * @param columnName--> name of the column in the table
	 * @return data present inside the column
	 */
	public static ArrayList<String> getTableData(WebDriver driver, String columnName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		ArrayList<String> data = new ArrayList<>();
		for (int i = 0; i <= 10; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				List<WebElement> elements = driver.findElements(By.xpath(
						"//table[@aria-label='sticky table']/tbody/tr/td[count(//table[@aria-label='sticky table']/thead/tr/th[text()='"
								+ columnName + "']/preceding-sibling::th)+1]"));
				wait.until(ExpectedConditions.visibilityOf(elements.get(elements.size() - 1)));
				for (WebElement ele : elements) {
					data.add(ele.getText().trim());
				}
				break;
			} catch (Exception e) {
				waitFor(2000);
				if (i == 10) {
					System.out.println("Unable To Get Table Data :" + e.getMessage());
				}
			}
		}
		return data;
	}

	/**
	 * By this method we can do edit and delete operation inside the action column
	 *
	 * @param driver-> instance of driver
	 * @param operation-> {Edit,Delete,Operational}
	 */
	public static void actionColumnOperaion(WebDriver driver, String operation) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		for (int i = 0; i <= 10; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				List<WebElement> elements = driver.findElements(By.xpath(
						"//table[@aria-label='sticky table']/tbody/tr/td[count(//table[@aria-label='sticky table']/thead/tr/th[contains(text(),'Action')]/preceding-sibling::th)+1]/button[@title='"+operation+"']"));
				wait.until(ExpectedConditions.visibilityOf(elements.get(0)));
				elements.get(0).click();

			} catch (Exception e) {
				waitFor(2000);
				if (i == 10) {
					System.out.println("Unable To Get Table Data :" + e.getMessage());
				}
			}
		}
	}

}
