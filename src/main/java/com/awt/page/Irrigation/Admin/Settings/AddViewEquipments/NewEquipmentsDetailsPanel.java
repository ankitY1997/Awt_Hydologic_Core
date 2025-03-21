package com.awt.page.Irrigation.Admin.Settings.AddViewEquipments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.graphbuilder.struc.LinkedList;

public class NewEquipmentsDetailsPanel extends EquipmentDetailsPage {

	/**** constants Of New Details Panel ***/

	// *******For Details Tab***********/
	public static final String details_tab = "Details";
	// *******For Properties Tab***********/
	public static final String properties_tab = "Properties";
	// *******For Notification Parameter Tab***********/
	public static final String notification_Parameter_tab = "Properties";
	// ***********Device profile Drop_down**************//
	public static final String device_profile_drop_down_name = "Device Profile";
	// *************** Map Coordinates Text Field Name*******/
	public static final String map_coordinates = "Map Coordinates";
	// *************** Gateway Name text Field Name*******/
	public static final String gateway_name = "Gateway Name";
	// *************** Gateway id text Field Name*******/
	public static final String gateway_id = "Gateway ID";
	// *************** Gateway Name text Field Name*******/
	public static final String equipment_type = "Equipments Type";
	// *************** Gateway id text Field Name*******/
	public static final String device_profile = "Device Profile";

	/********* X Path ****************/

	// *** X path for Panel Name**/
	@FindBy(xpath = "//div[@data-pc-section='headertitle']")
	public WebElement panel_name;

	// *** X path for Equipments Type dropdown**/
	@FindBy(xpath = "//label[text()='Equipments Type']")
	public WebElement equipment_type_drop_down;

	// *** X path for Device profile dropdown**/
	@FindBy(xpath = "//label[text()='Device Profile']")
	public WebElement device_profile_drop_down;

	// *** X path for Name text filed**/
	@FindBy(xpath = "//label[contains(text(),'Name')]")
	public WebElement name_text_field;

	// *** X path for ID text filed**/
	@FindBy(xpath = "//label[contains(text(),'ID')]")
	public WebElement id_text_field;

	// *** X path for list of options from any drop down**/
	@FindBy(xpath = "//ul[@role='listbox']/li")
	public List<WebElement> options_list;

	// *** X path for Map coodinates text field**/
	@FindBy(xpath = "//input[@id='coordinates']")
	public WebElement map_coordinates_text_field;

	// *** X path for clear button text field**/
	@FindBy(xpath = "//span[text()='Clear']/..")
	public WebElement clear_button;

	// *** X path for Add Equipment button text field**/
	@FindBy(xpath = "//button[@aria-label='Add Equipment']")
	public WebElement add_equipment_button;

	// *** X path for details tab madatory field name**/
	@FindBy(xpath = "//label")
	public List<WebElement> detail_tab_field_name_list;

	// *** X path for cross svg button **/
	@FindBy(xpath = "//button[@aria-label='Close']/*[local-name()='svg']")
	public WebElement cross_svg_button;

	// **Custom Constructor**/
	public NewEquipmentsDetailsPanel(WebDriver driver) {
		super(driver);
	}

	/**
	 * By this method we can get the "Equipement Details" panel name
	 * 
	 * @return {Equipment Detail Panel Name}
	 */
	public String getEquipmentDetailPanelName() {
		action.waitForVisibility(panel_name, action.implicit_wait);
		return action.getText(panel_name).trim();
	}

	/**
	 * By this method we can check the visibility of details tab
	 * 
	 * @return {if it's present then it's return true otherwise it's return false
	 */
	public boolean isDetailsTabIsVisible() {
		return checkVisibilityOfTab(details_tab);
	}

	/**
	 * By this method we can check the visibility of properties tab
	 * 
	 * @return {if it's present then it's return true otherwise it's return false
	 */
	public boolean isPropertiesTabIsVisible() {
		return checkVisibilityOfTab(properties_tab);
	}

	/**
	 * By this method we can check the visibility of properties tab
	 * 
	 * @return {if it's present then it's return true otherwise it's return false}
	 */
	public boolean isNotificationParameterTabIsVisible() {
		return checkVisibilityOfTab(notification_Parameter_tab);
	}

	/**
	 * By this method we can get "equipment type " drop down is visible o
	 * 
	 * @return {if it's visible then it's return true otherwise it's return false}
	 */
	public boolean isEquipmentTypeDropDownIsVisible() {
		action.waitForVisibility(equipment_type_drop_down, action.implicit_wait);
		return action.isDisplay(equipment_type_drop_down);
	}

	/**
	 * By this method we can get "Device Profile " drop down is visible
	 * 
	 * @return {if it's visible then it's return true otherwise it's return false}
	 */
	public boolean isDeviceProfileDropDownIsVisible() {
		action.waitForVisibility(device_profile_drop_down, action.implicit_wait);
		return action.isDisplay(device_profile_drop_down);
	}

	/**
	 * By this method we can get "Name" text field is visible
	 * 
	 * @return {if it's visible then it's return true otherwise it's return false}
	 */
	public boolean isNameTextFieldIsVisible() {
		action.waitForVisibility(name_text_field, action.implicit_wait);
		return action.isDisplay(name_text_field);
	}

	/**
	 * By this method we can get "Map Coordinates" text field is visible
	 * 
	 * @return {if it's visible then it's return true otherwise it's return false}
	 */
	public boolean isMapCoordinatedTextFieldIsVisible() {
		action.waitForVisibility(map_coordinates_text_field, action.implicit_wait);
		return action.isDisplay(map_coordinates_text_field);
	}

	/**
	 * By this method we can get "Id" text field is visible
	 * 
	 * @return {if it's visible then it's return true otherwise it's return false}
	 */
	public boolean isIdTextFieldIsVisible() {
		action.waitForVisibility(id_text_field, action.implicit_wait);
		return action.isDisplay(id_text_field);
	}

	/**
	 * By this method we can get "Clear" button is visible
	 * 
	 * @return {if it's visible then it's return true otherwise it's return false}
	 */
	public boolean isClearButtonVisible() {
		action.waitForVisibility(clear_button, action.implicit_wait);
		return action.isDisplay(clear_button);
	}

	/**
	 * By this method we can click on "clear" button
	 */
	public void clickOnClearButton() {
		action.clickOn(clear_button, "Clear");
	}

	/**
	 * By this method we can get "add_equipment_button" button is visible
	 * 
	 * @return {if it's visible then it's return true otherwise it's return false}
	 */
	public boolean isAddEquipmentButtonVisible() {
		action.waitForVisibility(add_equipment_button, action.implicit_wait);
		return action.isDisplay(add_equipment_button);
	}

	/**
	 * By this method we can click on "Add Equipment" button
	 */
	public void clickOnAddEquipmentButton() {
		action.clickOn(add_equipment_button, " Add Equipment");
	}

	/**
	 * By this method we can get "Close Svg" button is visible
	 * 
	 * @return {if it's visible then it's return true otherwise it's return false}
	 */
	public boolean isCrossSvgButtonVisible() {
		action.waitForVisibility(cross_svg_button, action.implicit_wait);
		return action.isDisplay(cross_svg_button);
	}

	/**
	 * By this method we can click on "Close Svg" button
	 */
	public void clickOnCloseSvgButton() {
		action.clickOn(cross_svg_button, " Close Svg ");
	}

	/**
	 * By this method we can enter the map coordinates in "Map Coordinates" text
	 * field
	 * 
	 * @param coordinates
	 */
	public void enterMapCordinates(String coordinates) {
		enterText(map_coordinates, coordinates);
	}

	/**
	 * With help of this method we can fetch the entered value of "map coordinates"
	 * text field
	 * 
	 * @return {Map Coordinates Text Field Value}
	 */
	public String getTheCurrentCoordinatesFromMapCoordinatesTextFieldValue() {
		String value = "";

		if (action.getAttributeValue(driver.findElement(By.xpath("//input[@id='coordinates']")), "value") != null) {
			return action.getAttributeValue(driver.findElement(By.xpath("//input[@id='coordinates']")), "value");
		} else
			return value;
	}

	/**
	 * With help of this method we can enter the gateway name in "gateway name text
	 * field
	 * 
	 * @param gateway_name
	 */
	public void enterGatewayName(String name) {
		enterText(gateway_name, name);
	}

	/**
	 * By this method we can get the current "name" of "Name*" text field
	 * 
	 * @return { current name of "Name*" text field}
	 */
	public String getCurrentNameOfNameTextField() {
		String current_name = "";
		if (isNameTextFieldIsVisible()) {
			current_name = action.getText(name_text_field);
		}
		return current_name;
	}

	/**
	 * By this method we can get the current name of "Id *" text field
	 * 
	 * @return { current name of "Name*" text field}
	 */
	public String getCurrentNameOfIdTextField() {
		String current_name = "";
		if (isNameTextFieldIsVisible()) {
			current_name = action.getText(id_text_field);
		}
		return current_name;
	}

	/**
	 * By this method we can get the current entered value inside "Name*" text field
	 * 
	 * @return { current name of "Name*" text field}
	 */
	public String getCurrentValueOfNameTextField() {
		String current_name = "";
		if (isNameTextFieldIsVisible()) {
			current_name = action.getAttributeValue(
					driver.findElement(By.xpath("//label[contains(text(),'Name')]/following-sibling::input")), "value");
		}
		return current_name;
	}

	/**
	 * With help of this method we can enter the gateway id in gateway id text field
	 * 
	 * @param gateway_id
	 */
	public void enterGatewayId(String id) {
		enterText(gateway_id, id);
	}

	/**
	 * By help of this method we can fill all the properties which is avaiable under
	 * the "Details" tab
	 * 
	 * @param equipmentType
	 * @param deviceProfile
	 * @param name
	 * @param id
	 * @param map_coordinates
	 */
	public void fillAllDetailsTabProperties(String equipmentType, String deviceProfile, String name, String id,
			String map_coordinates) {

		// select the equipment type
		selectDropdownOptionFromDetailsTab(equipment_type, equipmentType);
		// select the device profile
		selectDropdownOptionFromDetailsTab(device_profile, deviceProfile);
		// ente the name
		enterText("Name", name);
		// enter the id
		enterText("ID", id);
		// enter the Map Coordinates
		enterMapCordinates(map_coordinates);

	}

	/**
	 * By this method we can get the current entered id inside "ID*" text field
	 * 
	 * @return { current name of "ID*" text field}
	 */
	public String getCurrentValueOfIdTextField() {
		String current_name = "";
		if (isNameTextFieldIsVisible()) {
			current_name = action.getAttributeValue(
					driver.findElement(By.xpath("//label[contains(text(),'ID')]/following-sibling::input")), "value");
		}
		return current_name;
	}

	/**
	 * By this method we can get the options list from "Device profile" drop down
	 * button
	 * 
	 * @return {List of Options which is present under the "Device Profile" drop
	 *         down}
	 */
	public ArrayList<String> getTheListOfOptionsFromDeviceProfileDropDown() {

		java.util.LinkedList<String> list = new java.util.LinkedList<String>();
		// select a drop down
		clickOnDropDown(details_tab, device_profile_drop_down_name);
		// wait for the element
		action.waitForVisibility(options_list.get(0), action.implicit_wait);
		for (WebElement ele : options_list) {
			list.add(action.getText(ele).trim());
		}
		return new ArrayList<String>(list);
	}

	/**
	 * 
	 * By this method we can get all the mandatory field name which is present under
	 * the "Details" tab
	 * 
	 * @return {Mandatory field of details tab}
	 */
	public List<String> getMandatoryFieldNameFromDetailsTab() {
		java.util.LinkedList<String> list = new java.util.LinkedList<String>();
		action.waitForVisibility(detail_tab_field_name_list.get(0), action.implicit_wait);
		for (WebElement ele : detail_tab_field_name_list) {
			list.add(ele.getText().trim());

		}
		return new ArrayList<String>(list);
	}

	/**
	 * By this method we can get the selected option from the drop down
	 * 
	 * @param drop_down_name {which drop down selected option you want to fetech
	 * @return selcted option
	 */
	public String getSelectedOptionFromDropDown(String drop_down_name) {
		action.waitForVisibility(driver.findElement(By.xpath(
				"//label[text()='" + drop_down_name + "']/following-sibling::div//span[@data-pc-section='input']")),
				action.implicit_wait);
		return action.getText(driver.findElement(By.xpath(
				"//label[text()='" + drop_down_name + "']/following-sibling::div//span[@data-pc-section='input']")))
				.trim();
	}

	/**
	 * With help of this method we can select any options of drop down which is
	 * present in the details tab
	 * 
	 * @param drop_down_name
	 * @param option_name
	 */
	public void selectDropdownOptionFromDetailsTab(String drop_down_name, String option_name) {
		// Select drop down from details tab
		clickOnDropDown(details_tab, drop_down_name);
		// select options
		action.waitForVisibility(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + option_name + "']")),
				action.implicit_wait);
		action.clickOn(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + option_name + "']")),
				option_name);

	}

	/**
	 * By this method we can check user is able to see the drop down options is
	 * visible down
	 * 
	 * @param drop_down_name
	 * @param option_name
	 * @return
	 */
	public boolean isOptionsIsVisble(String option_name) {
		boolean isVisible = false;
		try {
			// select options
			action.waitForVisibility(
					driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + option_name + "']")),
					action.implicit_wait);
			isVisible = true;
		} catch (Exception e) {
		}
		return isVisible;
	}

	/**
	 * By this method we can click on drop down which is present under the "New
	 * EquipementDetailsPanel"
	 * 
	 * @param tab_name          {we need to pass the tab name which tab you wanna
	 *                          go}
	 * @param drop_down_name{we need to pass the drop down which you want click}
	 * 
	 */
	public void clickOnDropDown(String tab_name, String drop_down_name) {

		// Select the tab
		selectTabFromNewEquipementDetailsPanel(tab_name);
		// Click on drop down
		action.waitForVisibility(
				driver.findElement(
						By.xpath("//label[text()='Equipments Type']/following-sibling::div/div[@role='button']")),
				action.implicit_wait);
		action.clickOn(
				driver.findElement(By
						.xpath("//label[text()='" + drop_down_name + "']/following-sibling::div/div[@role='button']")),
				drop_down_name);

	}

	/**
	 * By this method we can check the visibility of "tabs" which is present under
	 * the "New Equipment Details" panel
	 * 
	 * @param tab_name { we need to pass which tab visibility of you want to check}
	 * 
	 * @return {if tab is present then it's return true other wise it return false}
	 */
	public boolean checkVisibilityOfTab(String tab_name) {
		action.waitForVisibility(
				driver.findElement(By.xpath("//a[@role='tab']/span[contains(text(),'" + tab_name + "')]")),
				action.implicit_wait);
		return action
				.isDisplay(driver.findElement(By.xpath("//a[@role='tab']/span[contains(text(),'" + tab_name + "')]")));

	}

	/**
	 * By this method we can click on any tab which is present
	 * "NewEquipementDetailsTab"
	 * 
	 * @param tab_name
	 */
	public void selectTabFromNewEquipementDetailsPanel(String tab_name) {
		if (checkVisibilityOfTab(tab_name)) {
			action.clickOn(driver.findElement(By.xpath("//a[@role='tab']/span[contains(text(),'" + tab_name + "')]")),
					tab_name);
		}
	}

	/**
	 * With help of this method we can enter a text at any field from details tab
	 * 
	 * @param field_name {you have to pass the correct field name same as ui
	 * @param value      { what you value you want to enter inside the text field}
	 */
	public void enterText(String field_name, String value) {
		action.implicitWait(
				driver.findElement(By.xpath("//label[contains(text(),'" + field_name + "')]/following-sibling::input")),
				action.implicit_wait);
		action.type(
				driver.findElement(By.xpath("//label[contains(text(),'" + field_name + "')]/following-sibling::input")),
				field_name, value);
	}
	
	
	public List<String> getAllTH

}
