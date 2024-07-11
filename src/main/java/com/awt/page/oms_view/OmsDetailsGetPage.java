package com.awt.page.oms_view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awt.utills.reusablecomponents.ActionEngine;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class OmsDetailsGetPage {

	/** delete popup button **/
	@FindBy(xpath = "//*[local-name()='svg' and @data-testid='DeleteIcon']")
	private WebElement delete_button;

	/** search_button **/
	@FindBy(xpath = "//input[@placeholder='Search something...']")
	public WebElement search_button;

	/** pop-up message */
	@FindAll({ @FindBy(xpath = "//button[text()='OK']"),
			@FindBy(xpath = "//button[contains(@class,'confirm swal-button--danger') and text()='OK']") })
	private WebElement ok_button;

	/** ActionEngine instance **/
	ActionEngine action = null;

	/** webdriver instance **/
	WebDriver driver = null;

	/** constructor **/
	public OmsDetailsGetPage(WebDriver driver) {
		this.driver = driver;
		action = new ActionEngine(driver);
		PageFactory.initElements(driver, this);

	}

	/**
	 * its used to check the details of the oms view table according to passed
	 * column name if data is present so it will return true or it will return false
	 *
	 * @param column->        which column you want to find expected data
	 * @param expectedData--> which oms data you want to search in the table
	 * @return boolean
	 */
	public boolean isOmsDetailPresent(String columnName, String expectedData) {
		boolean flag = false;
		try {
			String actualData = AwtUtilities.getTableData(driver, columnName).get(0);
			if (actualData.equals(expectedData)) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}

		return flag;
	}

	/**
	 * this method is used click on oms view table delete button
	 *
	 * @author AWT Tester
	 */
	public void deletOmsId() {

		action.clickOn(delete_button, "delete");
		action.clickOn(ok_button, "ok");
		action.clickOn(ok_button, "ok");

	}

	public void SearchValue(String value) {
		action.clickOn(search_button, "search button");
		action.type(search_button, " search button ", value);
	}

}
