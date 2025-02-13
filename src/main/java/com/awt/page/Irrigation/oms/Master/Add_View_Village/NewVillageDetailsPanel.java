package com.awt.page.Irrigation.oms.Master.Add_View_Village;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * @author Ankit Yadav
 */
public class NewVillageDetailsPanel extends VillageDetailsPage {
	
	
	//*****************Constants************/
	public static final String command_area="Command Area";
	public static final String district="District";
	public static final String village_name="Village Name";
	public static final String village_area="Village Area (Ha)";
	public static final String contact_person="Contact Person";
	public static final String contact_number="Contact Number";
	
	// *************xpath*************/

	/** Xpath for new button */
	@FindBy(xpath = "//div[@data-pc-section='headertitle']")
	public WebElement panel_name;

	@FindAll({ @FindBy(xpath = "//div[@data-pc-section='headertitle']/../following-sibling::div/div//label"),
			@FindBy(xpath = "//label") })
	public List<WebElement> field_name;

	/** Xpath for clear button */
	@FindBy(xpath = "//button[@aria-label='Clear']")
	public WebElement clear_button;
	
	//**Xpath for add button**/
	@FindBy(xpath = "//button[@aria-label='Add Village']")
	public WebElement add_village_button;

	// **Custom Constructor**/
	public NewVillageDetailsPanel(WebDriver driver) {
		super(driver);
	}

	
	
	
	
	
	/**
	 * With help of this method we can get the panel name
	 * 
	 * @return {panel name}
	 */
	public String getPanelName() {
		action.waitForVisibility(panel_name, action.implicit_wait);
		return action.getText(panel_name).trim();

	}

	
	/**
	 * With help of this method we can get to know the clear button is visible or
	 * not
	 * 
	 * @return {if clear button is visible then it's return true otherwise it
	 *         returns false
	 */
	public boolean isClearButtonVisible() {
		return action.isDisplay(clear_button);

	}

	/**
	 * With help of this method we can get to know the add village button is visible or
	 * not
	 * 
	 * @return {if add village button is visible then it's return true otherwise it
	 *         returns false
	 */
	public boolean isAddVillageButtonVisible() {
		return action.isDisplay(add_village_button);
	}
	
	/**
	 * With help of this method we can enter the village name
	 * @param name
	 */
	public void enterVillagename(String name) {
		enterValueOfTextField(village_name,name);
	}
	
	/**
	 * With help of this method we can enter the village area
	 * @param name
	 */
	public void enterVillageArea(String area) {
		enterValueOfTextField(village_area,area);
	}
	
	
	/**
	 * By this method we can get all the field name which is present uder the "New
	 * Village Details Panel"
	 * 
	 * @return {all field name}
	 */
	public List<String> getAllFieldName() {
		// Wait for loading all field
		action.waitForVisibility(field_name.get(0), action.implicit_wait);
		List<String> ele_name = new ArrayList<String>();
		for (WebElement element : field_name) {
			ele_name.add(element.getText().trim());
		}
		return ele_name;
	}

	
	
	
	/**
	 * By this method we can enter the value of any text field which is present
	 * under the "New Village Details Panel"
	 * 
	 * @param text_field_name {Enter the Text Field Name available on the web page
	 * @param value           {what value you need to be pass)
	 * @implNote textfield name should be similar as it's on webpage
	 */
	public void enterValueOfTextField(String text_field_name, String value) {
		action.waitForVisibility(
				driver.findElement(
						By.xpath("//label[contains(text(),'" + text_field_name + "')]/following-sibling::input")),
				action.implicit_wait);

		action.clickOn(driver
				.findElement(By.xpath("//label[contains(text(),'" + text_field_name + "')]/following-sibling::input")));
		action.type(
				driver.findElement(
						By.xpath("//label[contains(text(),'" + text_field_name + "')]/following-sibling::input")),
				text_field_name, value);
	}

	/**
	 * By help of this method we can select any option which is present under any
	 * dropdown of the village details panel
	 * 
	 * @param drop_down_name {from which drop down you want to select the option}
	 * @param option_name    {which option you want to select}
	 * @implNote drop down name,Option Name should be similar as it's avail on
	 *           webpage
	 */
	public void selectOptionFromDropDown(String drop_down_name, String option_name) {
		// click on enter drop down name
		clikOnVillageDetailsPanelDropDown(drop_down_name);
		// For seleting option
		action.clickOn(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + option_name + "']")),
				option_name);

	}

	/**
	 * By help of this method we can click on any drop down only we need to pass the
	 * drop down name
	 * 
	 * @param drop_down_name
	 * @implNote drop down name should be similar as it's avail on webpage
	 */
	public void clikOnVillageDetailsPanelDropDown(String drop_down_name) {

		// click on drop down
		action.clickOn(driver.findElement(By.xpath(
				"//label[contains(text(),'" + drop_down_name + "')]/following-sibling::div//*[local-name()='svg']")),
				drop_down_name);
	}

	/**
	 * By this method we can get the selected value of any dropdown which is avail
	 * on "New Village Details panel" , only you need to pass the drop down name
	 * 
	 * @param drop_down_name { Need to pass the drop down name }
	 * @return {Selected Value of drop down}
	 * @implNote drop_down name should be the same as it's avail on the web page
	 * 
	 */
	public String getSelectedValueFromDropDown(String drop_down_name) {

		action.waitForVisibility(driver.findElement(By.xpath("//label[contains(text(),'" + drop_down_name
				+ "')]/following-sibling::div//span[@data-pc-section='input']")), action.implicit_wait);

		return action.getText(driver.findElement(By.xpath("//label[contains(text(),'" + drop_down_name
				+ "')]/following-sibling::div//span[@data-pc-section='input']"))).trim();

	}

	/**
	 * By help of this method we can get the entered value from text field which
	 * avail on the "Village Details Panel"
	 * 
	 * @param text_field_name {Which text field value you want to scrap
	 * @return "value of the text field"
	 * @implNote Text field name should be same as visible on the web page
	 */
	public String getValueFromTextFieldValue(String text_field_name) {
		action.waitForVisibility(
				driver.findElement(By.xpath("//label[contains(text(),'Village Name ')]/following-sibling::input")),
				action.implicit_wait);
		return action.getAttributeValue(
				driver.findElement(By.xpath("//label[contains(text(),'Village Name ')]/following-sibling::input")),
				"value").trim();
	}

}
