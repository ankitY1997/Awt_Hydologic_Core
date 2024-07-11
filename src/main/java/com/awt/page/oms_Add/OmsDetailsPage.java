package com.awt.page.oms_Add;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awt.utills.reusablecomponents.ActionEngine;

public class OmsDetailsPage {

	/** village name dropdown button **/
	@FindBy(xpath = "//select[@class='select']")
	public WebElement village_name_dropdown;

	/** oms add button **/
	@FindBy(xpath = "//button[text()='Add OMS']")
	public WebElement add_oms_button;

	/** ok button for pop-up */
	@FindAll({ @FindBy(xpath = "//button[text()='OK']") })
	private WebElement ok_button;

	/** ActionEngine instance **/
	ActionEngine action = null;

	/** webdriver instance **/
	WebDriver driver = null;

	/** constructor **/
	public OmsDetailsPage(WebDriver driver) {
		this.driver = driver;
		action = new ActionEngine(driver);
		PageFactory.initElements(driver, this);

	}

	/**
	 * this method is used to fill the Oms Details
	 *
	 * @param villageName
	 * @param omsId
	 * @param deviceId
	 * @param omsArea
	 * @param chakLeader
	 * @param chakleaderNumber
	 * @param technicalPerson
	 * @param technicalPersonMobileNumber
	 * @param lattitude
	 * @param longitude
	 * @param maxInletPressure
	 */
	public void fillOmsDetails(String villageName, String omsId, String deviceId, String omsArea, String chakLeader,
			String chakleaderNumber, String technicalPerson, String technicalPersonMobileNumber, String lattitude,
			String longitude, String maxInletPressure) {
		action.selectByVisibleText(village_name_dropdown, villageName);
		action.type(driver.findElement(By.xpath("//label[contains(text(),'Oms Id *')]/following-sibling::input")),
				"oms id", omsId);
		action.type(
				driver.findElement(
						By.xpath("//label[contains(text(),'Device ID (Mac ID) *')]/following-sibling::input")),
				"device id", deviceId);
		action.type(
				driver.findElement(By.xpath("//label[contains(text(),'OMS Area  (Ha) *')]/following-sibling::input")),
				"area hectare", omsArea);
		action.type(driver.findElement(By.xpath("//label[contains(text(),'Chak Leader *')]/following-sibling::input")),
				"Chak Leader ", chakLeader);
		action.type(
				driver.findElement(
						By.xpath("//label[contains(text(),'Chak Leader Contact Details *')]/following-sibling::input")),
				"Chak Leader Contact Details ", chakleaderNumber);
		action.type(
				driver.findElement(By.xpath("//label[contains(text(),'Technical Person *')]/following-sibling::input")),
				"Technical Person *", technicalPerson);
		action.type(
				driver.findElement(By.xpath(
						"//label[contains(text(),'Technical Person Contact Details *')]/following-sibling::input")),
				"Technical Person Contact Details  ", technicalPersonMobileNumber);
		action.type(driver.findElement(By.xpath("//label[contains(text(),'Latitude *')]/following-sibling::input")),
				"Latitude  ", lattitude);
		action.type(driver.findElement(By.xpath("//label[contains(text(),'Longitude *')]/following-sibling::input")),
				"Longitude", longitude);
		action.type(
				driver.findElement(
						By.xpath("//label[contains(text(),'Maximum Inlet Pressure')]/following-sibling::input")),
				"Maximum Inlet Pressure", maxInletPressure);
		action.clickOn(add_oms_button, "add oms");
		action.clickOn(ok_button, "ok");
	}

}
