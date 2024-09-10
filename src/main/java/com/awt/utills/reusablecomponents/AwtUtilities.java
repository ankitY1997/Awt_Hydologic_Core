package com.awt.utills.reusablecomponents;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.bouncycastle.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.awt.page.Admin.ProjectDashboardPage;
import com.awt.page.Admin.Project.ProjectSettings.AdminCreateProjectPage;
import com.awt.page.Admin.Project.ProjectSettings.NewProjectDetailsPanel;
import com.awt.page.Login.LoginPage;
import com.awt.testbase.DriverFactory;

/**
 * Utilities Only For This Project
 * 
 * @author Ankit Yadav
 */
public class AwtUtilities {

	/** Random String Object **/
	protected static RandomStringUtils random = new RandomStringUtils();

	/** boolean flag **/
	private static boolean flag = true;

	/**
	 * this method is used to generate random string according to the length
	 *
	 * @param length
	 * @return String
	 */
	public static String genrateRandomString(int length) {
		return random.randomAlphabetic(length);
	}

	/**
	 * this method is used to generate random number according to the given length
	 *
	 * @param length
	 * @return
	 */
	public static String genrateRandomNumber(int length) {
		return random.randomNumeric(length);
	}

	/**
	 * To generate alphanumeric value
	 * 
	 * @param length
	 * @return
	 */
	public static String genrateRandomAlphaNeumric(int length) {
		return random.randomAlphanumeric(length);
	}

	public static String genrateRandomAlphaNeumric(int min_length, int max_length) {
		return random.randomAlphanumeric(min_length, max_length);
	}

	/**
	 * To generate alphabets
	 * 
	 * @param length
	 * @return
	 */
	public static String genrateRandomAlphaBets(int length) {
		return random.randomAlphabetic(length);

	}

	public static String genrateRandomAlphaBets(int min_length, int max_length) {
		return random.randomAlphabetic(min_length, max_length);

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
	 * @param driver->    instance of driver
	 * @param operation-> {Edit,Delete,Operational}
	 */
	public static void actionColumnOperaion(WebDriver driver, String operation) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		for (int i = 0; i <= 10; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				List<WebElement> elements = driver.findElements(By.xpath(
						"//table[@aria-label='sticky table']/tbody/tr/td[count(//table[@aria-label='sticky table']/thead/tr/th[contains(text(),'Action')]/preceding-sibling::th)+1]/button[@title='"
								+ operation + "']"));
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

	/**
	 * By this method we can create new project
	 * 
	 * @param driver
	 * @param projectName
	 * @param userName
	 * @param password
	 * @param module_name
	 */
	public static void createNewProject(WebDriver driver, String projectName, String userName, String password,
			String[]... module_name) {
		LoginPage lp = new LoginPage(driver);
		// Enter the Project Name and login and navigate to the home page
		ProjectDashboardPage admin_page = lp.loginAndProjectDashboardPage(Properties.getPropertyValue("ADMINURL"));
		// click on project menu and Select "Project Setting" menu
		AdminCreateProjectPage admin_create_page = admin_page
				.clickCreateProjectButtonAndNavigateToAdminCreateProjectPage("Project", "Project Settings");
		// * Click on Create Project Button --> Navigate to "New Project Details Panel
		NewProjectDetailsPanel newProject_DetailsPanel = admin_create_page
				.clickCreateProjectButtonAndNavigateToNewProjectDetailPanel();

		// Take The Details From "New Project Details.
		String clientName = ExcelOperations.getCellData("New_Poject_Details", "Client Name", "APMS-T48");
		String clientImagePath = ExcelOperations.getCellData("New_Poject_Details", "Client Image Path", "APMS-T48");
		String consultantName = ExcelOperations.getCellData("New_Poject_Details", "Consultant Name", "APMS-T48");
		String consultantImagePath = ExcelOperations.getCellData("New_Poject_Details", "Consultant Image Path",
				"APMS-T48");
		String licensesKey = ExcelOperations.getCellData("New_Poject_Details", "Licenses Key", "APMS-T48");
		String mobNumber = AwtUtilities.genrateRandomNumber(10);
		String emailAddress = AwtUtilities.genrateRandomAlphaNeumric(1, 5) + "@gmail.com";
		String startDate = ExcelOperations.getCellData("New_Poject_Details", "Start Date", "APMS-T48");
		String expectedDate = ExcelOperations.getCellData("New_Poject_Details", "Expected Date", "APMS-T48");
		// Actual Completion Date
		LocalDate current_Date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String actualCompletionDate = current_Date.format(formatter);

		// Enter All Mandatory Details
		newProject_DetailsPanel.enterProjectDetails(projectName, clientName, clientImagePath, consultantName,
				consultantImagePath, licensesKey, userName, password, mobNumber, emailAddress, startDate, expectedDate,
				actualCompletionDate, module_name);
		// click on Add Project Button
		newProject_DetailsPanel.clickAddProject();
		// close the browser
		driver.close();

	}

	/**
	 * With Help Of This Method We Can Delete the project Name
	 * @param driver
	 * @param projectName
	 */
	public static void deleteTheProject(WebDriver driver, String projectName) {
		LoginPage lp = new LoginPage(driver);
		// Enter the Project Name and login and navigate to the home page
		ProjectDashboardPage admin_page = lp.loginAndProjectDashboardPage(Properties.getPropertyValue("ADMINURL"));
		// click on project menu and Select "Project Setting" menu
		AdminCreateProjectPage admin_create_page = admin_page
				.clickCreateProjectButtonAndNavigateToAdminCreateProjectPage("Project", "Project Settings");
		// click on delete the project
		admin_create_page.deleteProjectDetails(projectName);
		// accept pop-up
		NewProjectDetailsPanel newProject_DetailsPanel = new NewProjectDetailsPanel(driver);
		newProject_DetailsPanel.acceptPopup();
		// close the browser
		driver.close();
	}

	/**
	 * Help of this method we can get the time difference between if actual date is
	 * there
	 * 
	 * @param exp_Date
	 * @param actualDate
	 * 
	 */
//	public static String getTimeDiff(String expDate, String... actualDate) {
//		LocalDate current_Date = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		String currentDate = current_Date.format(formatter);
//		
//		String timeDiff = "";
//		if (actualDate[0].isBlank()) {
//			LocalDate date1 = parseToLocalDate(currentDate, "dd-MM-yyyy");
//			LocalDate date2 = parseToLocalDate(expDate, "dd-MM-yyyy");
//
//			// Calculate days between date1 and date2
//			long daysBetween = calculateDaysBetween(date1, date2);
//			if (flag) {
//				timeDiff = "-" + daysBetween;
//			} else
//				timeDiff = String.valueOf(daysBetween);
//		} else if (!actualDate[0].isBlank()) {
//			LocalDate date1 = parseToLocalDate(actualDate[0], "dd-MM-yyyy");
//			LocalDate date2 = parseToLocalDate(expDate, "dd-MM-yyyy");
//
//			// Calculate days between date1 and date2
//			long daysBetween = calculateDaysBetween(date1, date2);
//			if (flag) {
//				timeDiff = "-" + daysBetween;
//			} else
//				timeDiff = String.valueOf(daysBetween);
//
//		}
//		return timeDiff;
//
//	}

	/**
	 * Help of this method we can get the time difference between if actual date is
	 * there
	 * 
	 * @param exp_Date
	 * @param actualDate
	 * 
	 */
	public static String getTimeDiff(String expDate, String... actualDate) {
		LocalDate current_Date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String currentDate = current_Date.format(formatter);

		String timeDiff = "";
		LocalDate curr_date = parseToLocalDate(currentDate, "dd-MM-yyyy");
		LocalDate exp_date = parseToLocalDate(expDate, "dd-MM-yyyy");

		if (actualDate[0] != null) {
			LocalDate actual_date = parseToLocalDate(actualDate[0], "dd-MM-yyyy");
			if (exp_date.isBefore(actual_date)) {
				int days = (int) calculateDaysBetween(actual_date, exp_date);
				timeDiff = "-" + days;
			} else if (exp_date.isAfter(actual_date)) {
				int days = (int) calculateDaysBetween(actual_date, exp_date);
				timeDiff = "+" + days;
			}
		} else if (actualDate[0] == null) {
			if (curr_date.isBefore(exp_date)) {
				int days = (int) calculateDaysBetween(curr_date, exp_date);
				timeDiff = "+" + days;

			} else if (curr_date.isAfter(exp_date)) {
				int days = (int) calculateDaysBetween(exp_date, exp_date);
				timeDiff = "-" + days;
			}
		}
		return timeDiff;
	}

	/**
	 * To Set The Date Format
	 * 
	 * @param dateString
	 * @param format
	 * @return { return Date according to Time Format
	 */
	public static LocalDate parseToLocalDate(String dateString, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return LocalDate.parse(dateString, formatter);
	}

	/**
	 * Calculate The Days Between Two Dates
	 * 
	 * @param date1
	 * @param date2
	 * @return " Difference between Two Dates
	 */
	public static long calculateDaysBetween(LocalDate date1, LocalDate date2) {
		// Ensure date1 is before date2
		if (date1.isAfter(date2)) {
			LocalDate temp = date1;
			date1 = date2;
			date2 = temp;
		}
		// Calculate total days between date1 and date2 using ChronoUnit.DAYS
		long daysBetween = ChronoUnit.DAYS.between(date1, date2);

		return daysBetween;
	}

	/**
	 * This is method is used to change the date format
	 * 
	 * @param inputDateString
	 * @param inputFormat
	 * @param outputFormat
	 * @return
	 */
	public static String convertDateFormat(String inputDateString, String inputFormat, String outputFormat) {
		SimpleDateFormat inputSdf = new SimpleDateFormat(inputFormat);
		SimpleDateFormat outputSdf = new SimpleDateFormat(outputFormat);

		try {
			Date date = inputSdf.parse(inputDateString);
			return outputSdf.format(date);
		} catch (ParseException e) {
			System.out.println("Error parsing or formatting date: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Converting String to COlletion
	 * 
	 * @param obj
	 * @return
	 */
	public static Collection<String> convertStringToCollection(String obj) {
		String[] array = obj.split(",");
		List<String> list = new ArrayList<String>();
		for (String arr : array) {
			list.add(arr.trim());
		}
		return list;
	}

}
