package com.awt.utills.reusablecomponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.awt.testbase.ExtentFactory;
import com.awt.testbase.MyLogger;

/**
 * @author Ankit Yadav
 */
public class ActionEngine {

	WebDriver driver = null;
	// implicit wait
	public static final int implicit_wait = 10;
	// Explicit time
	public static final int explicit_wait = 10;
	/** xpath of Project Created Sucessfully pop-up *****/
	@FindAll({ @FindBy(xpath = "//button[text()='OK']"), @FindBy(xpath = "//div[@role='dialog']//*[text()='OK']") })
	private WebElement accept_popup;

	// constructor
	public ActionEngine(WebDriver driver) {
		this.driver = driver;
	}

	// **************************WebDriver methods ***************************/

	/**
	 * this method is used to enter the value in any text field
	 *
	 * @param element
	 * @param field_name
	 * @param valueToBeSend
	 * @author AWT Tester
	 */
	public void type(WebElement element, String field_name, String valueToBeSend) {
		try {
			// move to Element
			performMoveToElement(element);
			// wait for element
			implicitWait(element, implicit_wait);
			element.click();
			element.clear();
			AwtUtilities.clearTextUsingJs(driver, element);
			element.sendKeys(valueToBeSend);
			ExtentFactory.extentObject().getExtent().log(Status.PASS,
					field_name.toUpperCase() + " Entered Value as :" + valueToBeSend);
			// MyLogger.info("Successfully Entered Value :" + valueToBeSend + "In This Field
			// " + field_name);
		} catch (Exception e) {
			ExtentFactory.extentObject().getExtent().log(Status.FAIL,
					" Value Entered In Field  :" + field_name.toUpperCase() + " Is Failed Due To Exception" + e);
			// MyLogger.info("Failed To Enter The Value :" + valueToBeSend + " In THis Field
			// " + field_name);
		}

	}

	/**
	 * this method is used for clicking operation
	 *
	 * @param element
	 * @author AWT Tester
	 */
	public void clickOn(WebElement element, String button_name) {
		// wait for page loading it will wait until dom structure will not be ready
		AwtUtilities.waitFor(2000);
		AwtUtilities.waitForPageLoading(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicit_wait));
		int i = 0;
		while (i <= 3) {
			try {
				wait.until(ExpectedConditions.visibilityOf(element));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				logPass("sucessfully click on the " + "'" + button_name + "'" + " button");

				break;
			} catch (StaleElementReferenceException e) {
				if (i > 2) {
					logFail("Unable TO Click On The Element :" + button_name + " Due To THis Exception ", e);
					// MyLogger.info("Failed To Click On The Element :" + value);
				}
			} catch (ElementClickInterceptedException e) {
				AwtUtilities.javascriptClick(driver, element);
				break;
			} catch (Exception e) {
				AwtUtilities.javascriptClick(driver, element);
			}
			i++;
		}
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicit_wait));
	}

	/**
	 * Implicit Wait
	 * 
	 * @param driver
	 * @param time
	 * @return
	 */
	public Timeouts implictWait(int time) {
		return driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	/**
	 * this method is used to get the text
	 *
	 * @param element
	 * @author AWT Tester
	 */
	public String getText(WebElement element) {
		// wait for visibility
		String text = null;
		try {
			waitForVisibility(element, implicit_wait);
			text = element.getText();
		} catch (Exception e) {
			logFail("Unable To Get A Text Due To This Exception :", e);
		}
		return text;
	}

	/**
	 * By this method we can get current url
	 *
	 * @param driver
	 * @return url
	 */
	public String getUrl(WebDriver driver) {
		String url = driver.getCurrentUrl();
		return url;
	}

	/**
	 * this method is used for clicking operation
	 *
	 * @param element
	 * @author AWT Tester
	 */
	public void clickOn(WebElement element) {
		// wait for page loading it will wait until dom structure will not be ready
		AwtUtilities.waitFor(2000);
		AwtUtilities.waitForPageLoading(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicit_wait));
		int i = 0;
		try {
			while (i <= 3) {
				try {
					wait.until(ExpectedConditions.visibilityOf(element));
					wait.until(ExpectedConditions.elementToBeClickable(element));
					performMoveToElement(element);
					element.click();

					break;
				} catch (StaleElementReferenceException e) {

				} catch (ElementClickInterceptedException e) {
					AwtUtilities.javascriptClick(driver, element);
					break;
				} catch (Exception e) {
					AwtUtilities.javascriptClick(driver, element);
				}
				i++;
			}
		} catch (Exception e) {
			logFail("Unable To Get click On Due To This Exception :", e);
		}
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicit_wait));
	}

	/**
	 * By this method we can get current page source
	 *
	 * @param driver
	 * @return pagesource
	 */
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	/**
	 * By this method we can get the title of current page
	 *
	 * @param driver
	 * @return title
	 */
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	/**
	 * By this method we can get tool tip value of element
	 *
	 * @param element-> address of web element
	 * @return-> string
	 */
	public String getToolTipText(WebElement element) {
		String value = null;
		for (int i = 0; i <= 2; i++) {

			try {
				waitForVisibility(element, explicit_wait);
				value = element.getAttribute("title");
				break;
			} catch (Exception e) {
				implicitWait(element, implicit_wait);
				if (i == 2) {
					return null;
				}
			}
		}
		return value;
	}

	/**
	 * By this method we can get attribute value we need to pass an attribute name
	 *
	 * @param element
	 * @param value
	 * @return attributeName
	 */
	public String getAttributeValue(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	/**
	 * implicit wait
	 *
	 * @param element
	 * @param time
	 */
	public void implicitWait(WebElement element, int time) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	/**
	 * this is explicit wait it used to wait until element is not visible whenever
	 * it gets visible then it
	 *
	 * @param element
	 * @param time
	 */
	public void waitForVisibility(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		int i = 0;
		while (i <= 3) {
			try {
				wait.until(ExpectedConditions.visibilityOf(element));
				break;
			} catch (Exception e) {
			} finally {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicit_wait));
			}
			i++;
		}
	}

	/**
	 * this method is used to check element is click able or not
	 *
	 * @param element
	 * @param time
	 */
	public void ElementToBeClickable(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		int i = 0;
		while (i <= 3) {
			try {
				waitForVisibility(element, time);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				break;
			} catch (Exception e) {

			} finally {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicit_wait));
			}
			i++;
		}
	}

	/**
	 * By this method we can clear the text present inside the text field
	 *
	 * @param element-> address of textfield
	 */
	public void clearText(WebElement element) {
		for (int i = 0; i <= 2; i++) {
			try {
				waitForVisibility(element, explicit_wait);
				element.clear();
				break;
			} catch (Exception e) {
				implicitWait(element, implicit_wait);
				if (i == 2) {
					System.out.println("Unable To Clear Text" + e.getMessage());
				}
			}
		}
	}

	/**
	 * To Accept Java Script Pop-up
	 */
	public void acceptJavaScriptPopup() {
		AwtUtilities.waitFor(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/**
	 * Dismiss Java Script Pop-up
	 */
	public void dismissJavaScriptPopup() {
		AwtUtilities.waitFor(2000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * By this method we can check radio or check box it's selected or not
	 *
	 * @param element
	 * @return boolean-> if it is selected then it will return true otherwise it
	 *         will return false
	 */
	public boolean isSelected(WebElement element) {
		return element.isSelected();
	}

	/**
	 * By this method we can check button is enabled or not
	 *
	 * @param element
	 * @return boolean-> if it button is enabled then it will return true otherwise
	 *         it will return false
	 */
	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	/**
	 * By this method we can check element is display or not
	 *
	 * @param element
	 * @return boolean-> if it is element is visible then it will return true
	 *         otherwise it will return false
	 */
	public boolean isDisplay(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * By this method we can get the location of element
	 *
	 * @param element->address of location
	 * @return Point-> location
	 */
	public Point getLocation(WebElement element) {
		return element.getLocation();
	}

	/**
	 * By this method we can get x direction location of element
	 *
	 * @param element
	 * @return
	 */
	public int getXLocation(WebElement element) {
		return getLocation(element).getX();
	}

	/**
	 * By this method we can get y direction location of element
	 *
	 * @param element
	 * @return
	 */
	public int getYLocation(WebElement element) {
		return getLocation(element).getY();
	}

	// ****************************Select Class Method ****************************/

	/**
	 * By this method we can select select node dropdown by using value
	 *
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebElement element, String value) {
		try {
			waitForVisibility(element, implicit_wait);
			Select select = new Select(element);
			select.selectByValue(value);
			logPass("Selected :" + value + " Drop-down");
		} catch (Exception e) {
			MyLogger.info("Unable To Select :" + value + " By Value");
			logFail("Unable To Select :" + value + "Drop-down", e);
			System.out.println(e.getMessage().toString());
		}
	}

	/**
	 * By this method we can select a drop-down by using Index Number
	 *
	 * @param element
	 * @param indexNumber
	 */
	public void selectByIndexNumber(WebElement element, int indexNumber) {
		try {
			waitForVisibility(element, implicit_wait);
			Select select = new Select(element);
			select.selectByIndex(indexNumber);
			logPass("Selected :" + indexNumber + " Drop-down");
		} catch (Exception e) {
			MyLogger.info("Unable To Select This Index Number :" + indexNumber + "");
			logFail("Unable To Select :" + indexNumber + "Drop-down", e);
			System.out.println(e.getMessage().toString());
		}
	}

	/**
	 * this is method is used for select node dropdowns by this method we can select
	 * a options by visible text
	 *
	 * @param element
	 * @param name
	 */
	public void selectByVisibleText(WebElement element, String name) {
		try {
			waitForVisibility(element, implicit_wait);
			Select select = new Select(element);
			select.selectByVisibleText(name);
			logPass("Selected :" + name + " Drop-down");
		} catch (Exception e) {
			MyLogger.info("Unable To Select :" + name + " By Visible Text");
			logFail("Unable To Select :" + name + "Drop-down", e);
			System.out.println(e.getMessage().toString());
		}
	}

	/**
	 * By this method we can check the drop-down its multi-selected drop-down
	 *
	 * @param WebElement-> element you want to check
	 * @author Ankit Yadav
	 */
	public boolean isMultiSelectedDropDown(WebElement element) {
		boolean flag = false;
		try {
			waitForVisibility(element, implicit_wait);
			Select select = new Select(element);
			flag = select.isMultiple();
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
		return flag;
	}

	/**
	 * By this method we can find-out all the drop-down available inside the select
	 * node
	 *
	 * @param element-> address of select class node
	 * @return list of all drop-down present in side the drop-down
	 */
	public List<WebElement> getAllDropDown(WebElement element) {
		List<WebElement> list = null;
		try {
			waitForVisibility(element, implicit_wait);
			Select select = new Select(element);
			list = select.getOptions();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * By this method we can find all the selected drop-down
	 *
	 * @param element
	 * @return List-> list of selected drop-down
	 */
	public List<WebElement> getAllSelectedDropDown(WebElement element) {
		List<WebElement> list = null;
		try {
			waitForVisibility(element, implicit_wait);
			Select select = new Select(element);
			list = select.getAllSelectedOptions();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * By this method we can get first selected drop-down
	 *
	 * @param element-> address of select node
	 * @return WebElement-> return first selected drop-down
	 */
	public WebElement firstSlectedDropDown(WebElement element) {
		WebElement firstSelectOption = null;
		try {
			waitForVisibility(element, implicit_wait);
			Select select = new Select(element);
			firstSelectOption = select.getFirstSelectedOption();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return firstSelectOption;
	}

	/**
	 * By this method we can get last selected drop-down
	 *
	 * @param element-> address of select node
	 * @return WebElement-> return last selected drop-down
	 */
	public WebElement lastSlectedDropDown(WebElement element) {
		WebElement lastSelectOption = null;
		try {
			waitForVisibility(element, implicit_wait);
			Select select = new Select(element);
			lastSelectOption = select.getWrappedElement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastSelectOption;
	}

	/**
	 * By this method we can get Tag name by passing the element
	 *
	 * @param element
	 * @return tag name-> tag name
	 */
	public String geTagName(WebElement element) {
		return element.getTagName();
	}

	// ***************** Select Class De-select Methods***********/

	/**
	 * By this method we can de-select all selected drop-down
	 *
	 * @param element-> address of drop-down
	 * @return boolean->if all selected drop-down is de-selected then it will return
	 *         true;
	 */
	public boolean deselectAllDropDown(WebElement element) {
		boolean flag = false;
		try {
			waitForVisibility(element, implicit_wait);
			Select select = new Select(element);
			select.deselectAll();
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * By this method we can de-select drop-down with help of index if its already
	 * selected
	 *
	 * @param element
	 * @param indexNumber
	 * @return boolean-> if its de-select so it will return true
	 */
	public boolean deselectByIndex(WebElement element, int indexNumber) {
		boolean flag = false;
		try {
			waitForVisibility(element, implicit_wait);
			Select select = new Select(element);
			select.deselectByIndex(indexNumber);

			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * By this method we can de-select drop-down with help of value of drop-down if
	 * its already selected
	 *
	 * @param element -> address of select node
	 * @param value-> value of select drop-down
	 * @return boolean-> if its de-select so it will return true
	 */
	public boolean deselectByValue(WebElement element, String value) {
		boolean flag = false;
		try {
			waitForVisibility(element, implicit_wait);
			Select select = new Select(element);
			select.deselectByValue(value);
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * By this method we can de-select drop-down with help of visible text of
	 * drop-down if its already selected
	 *
	 * @param element -> address of select node
	 * @param value-> value of select drop-down
	 * @return boolean-> if its de-select so it will return true
	 */
	public boolean deselectByVisibleText(WebElement element, String text) {
		boolean flag = false;
		try {
			waitForVisibility(element, implicit_wait);
			Select select = new Select(element);
			select.deselectByVisibleText(text);
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

//************************************Action Class************************************//

	/**
	 * Perform a hover action on the given WebElement.
	 *
	 * @param webElement The WebElement to hover over.
	 */
	public void performHover(WebElement webElement) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(webElement).perform();
			logPass("Successfully performed hover action.");
		} catch (Exception e) {
			logFail("Failed to perform hover action.", e);
		}
	}

	/**
	 * Perform a click action on the given WebElement.
	 *
	 * @param webElement The WebElement to click.
	 */
	public void performClick(WebElement webElement) {
		try {
			Actions actions = new Actions(driver);
			actions.click(webElement).perform();
			logPass("Successfully performed click action.");
		} catch (Exception e) {
			logFail("Failed to perform click action.", e);
		}
	}

	/**
	 * Perform a double click action on the given WebElement.
	 *
	 * @param webElement The WebElement to double click.
	 */
	public void performDoubleClick(WebElement webElement) {
		try {
			Actions actions = new Actions(driver);
			actions.doubleClick(webElement).perform();
			logPass("Successfully performed double click action.");
		} catch (Exception e) {
			logFail("Failed to perform double click action.", e);
		}
	}

	/**
	 * perform a right click operation
	 *
	 * @param WebElement the WebElement to right click
	 */
	public void performRightClick(WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.contextClick(element).perform();
			logPass("Successfully performed right  click action.");
		} catch (Exception e) {
			logFail("Failed to perform Right click action.", e);

		}
	}

	/**
	 * Perform a click-and-hold action on the given WebElement.
	 *
	 * @param webElement The WebElement to click and hold.
	 */
	public void performClickAndHold(WebElement webElement) {
		try {
			Actions actions = new Actions(driver);
			actions.clickAndHold(webElement).perform();
			logPass("Successfully performed click and hold action.");
		} catch (Exception e) {
			logFail("Failed to perform click and hold action.", e);
		}
	}

	/**
	 * Perform a release action on the given WebElement.
	 *
	 * @param webElement The WebElement to Release.
	 */
	public void performReleased(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.release(element).perform();
			logPass("Successfully performed release  action.");

		} catch (Exception e) {
			logFail("Failed to perform release action.", e);
		}
	}

	/**
	 * Perform a scroll action by the specified offsets.
	 *
	 * @param xOffset The horizontal offset for scrolling.
	 * @param yOffset The vertical offset for scrolling.
	 */
	public void performScroll(int xOffset, int yOffset) {
		try {
			Actions actions = new Actions(driver);
			actions.moveByOffset(xOffset, yOffset).perform();
			logPass("Successfully performed scroll action.");
		} catch (Exception e) {
			logFail("Failed to perform scroll action.", e);
		}
	}

	/**
	 * Perform a scroll action by the specified offsets.
	 *
	 * @param xOffset The horizontal offset for scrolling.
	 * @param yOffset The vertical offset for scrolling.
	 */
	public void performScroll(WebElement element1, WebElement element2) {
		try {
			Actions actions = new Actions(driver);
			actions.moveByOffset(element1.getLocation().getX(), element2.getLocation().getY()).perform();
			logPass("Successfully performed scroll action.");
		} catch (Exception e) {
			logFail("Failed to perform scroll action.", e);
		}
	}

	/**
	 * Perform a scroll action by the specified offsets and click.
	 *
	 * @param xOffset The horizontal offset for scrolling.
	 * @param yOffset The vertical offset for scrolling.
	 */
	public void performScrollAndClick(int xOffset, int yOffset) {
		try {
			Actions actions = new Actions(driver);
			actions.moveByOffset(xOffset, yOffset).click().perform();
			logPass("Successfully able to performed scroll and click action.");
		} catch (Exception e) {
			logFail("Failed to perform scroll and click action.", e);
		}
	}

	/**
	 * Move to the center of the given WebElement.
	 *
	 * @param webElement The WebElement to move to.
	 */
	public void performMoveToElement(WebElement webElement) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(webElement).perform();
			// logPass("Successfully moved to the element.");
		} catch (Exception e) {
			//logFail("Failed to move to the element.", e);
		}
	}

	/**
	 * Perform a key press on the given WebElement.
	 *
	 * @param webElement The WebElement to press the key on.
	 * @param key        The key to press (e.g., Keys.ENTER).
	 */
	public void performPressKey(WebElement webElement, String key) {
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(webElement, key).perform();
			logPass("Successfully pressed key: " + key);
		} catch (Exception e) {
			logFail("Failed to press key.", e);
		}
	}

	/**
	 * Perform a sequence of key presses.
	 *
	 * @param keys The keys to press (e.g., Keys.CONTROL, "a", Keys.DELETE).
	 */
	public void performPressKeys(String keys) {
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(keys).perform();
			logPass("Successfully pressed keys: " + keys);
		} catch (Exception e) {
			logFail("Failed to press keys.", e);
		}
	}

	/**
	 * Pause execution for the specified duration.
	 *
	 * @param milliseconds The duration to pause in milliseconds.
	 */
	public void performPause(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
			logPass("Successfully Paused for " + milliseconds + " milliseconds.");
		} catch (InterruptedException e) {
			logFail("Failed to pause.", e);
		}
	}

	/**
	 * Send keys to the given WebElement.
	 *
	 * @param webElement The WebElement to send keys to.
	 * @param keys       The keys to send (e.g., "Hello").
	 */
	public void performSendKeys(WebElement webElement, String keys) {
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(webElement, keys).perform();
			logPass("Successfully sent keys: " + keys);
		} catch (Exception e) {
			logFail("Failed to send keys.", e);
		}
	}

	/**
	 * Perform a Page Up action.
	 */
	public void performPageUp() {
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.PAGE_UP).perform();
			logPass("Successfully performed Page Up action.");
		} catch (Exception e) {
			logFail("Failed to perform Page Up action.", e);
		}
	}

	/**
	 * Perform a Page Down action.
	 */
	public void performPageDown() {
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.PAGE_DOWN).perform();
			logPass("Successfully performed Page Down action.");
		} catch (Exception e) {
			logFail("Failed to perform Page Down action.", e);
		}
	}

	/**
	 * this is the logger methods used to do logging action
	 *
	 * @param message
	 */
	public void logPass(String message) {
		ExtentFactory.extentObject().getExtent().log(Status.PASS, message);
	}

	public void logFail(String message, Exception e) {
		ExtentFactory.extentObject().getExtent().log(Status.FAIL, message + " Error: " + e.getMessage());
	}

	// ************Common Method'S Related To The Project ***********/

}
