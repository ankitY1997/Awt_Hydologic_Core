package com.awt.page.User.AdminConfiguration.Settings.MasterCreation;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class SystemModeMasterPanel extends AdminMasterCreationPage {

	// ******Mode Master Panel ********/
	@FindAll({ @FindBy(xpath = "//div[@data-pc-section='headertitle']") })
	public WebElement panel_name;

	// *****List of Radio buttons In Mode Master Panel***/
	@FindAll({
			@FindBy(xpath = "//div[text()='Mode Master']/../following-sibling::div//div[@data-pc-name='radiobutton']/following-sibling::label") })
	public List<WebElement> radio_button_names;

	// ***Mode Name text field***/
	@FindAll({ @FindBy(xpath = "//input[@id='modeName']") })
	public WebElement mode_name_text_field;

	// ***Parent Mode drop down***/
	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Parent Mode ')]/../div//*[local-name()='svg']") })
	public WebElement parent_mode_drop_down;

	public SystemModeMasterPanel(WebDriver driver) {
		super(driver);
	}

	/**
	 * By this method we can get panel name
	 * 
	 * @return
	 */
	public String getSytemMasterPanelName() {
		action.isDisplay(panel_name);
		return action.getText(panel_name);
	}

	/**
	 * By This Method We Can Check "Mode Name" text field visible
	 * 
	 * @return boolean
	 */
	public boolean isModeNameTextFieldVisible() {
		action.waitForVisibility(ellipsis_button, action.implicit_wait);
		return action.isDisplay(ellipsis_button);
	}

	/**
	 * By This Method We Can Check "Parent Mode" drop down is visible
	 * 
	 * @return boolean
	 */
	public boolean isParentModeDropDownVisible() {
		action.waitForVisibility(parent_mode_drop_down, action.implicit_wait);
		return action.isDisplay(parent_mode_drop_down);
	}

	/**
	 * By this method we can click on parent mode drop down
	 */
	public void clickOnParentModeDropDown() {
		if (isParentModeDropDownVisible()) {
			action.clickOn(parent_mode_drop_down);
		}
	}

	/**
	 * By this method we can get mode master panel radio buttons name
	 * 
	 * @return
	 */
	public List<String> getModeMasterRadioButtonNames() {
		action.waitForVisibility(radio_button_names.get(0), action.implicit_wait);
		List<String> button_names = new LinkedList<String>();
		for (WebElement element : radio_button_names) {
			action.waitForVisibility(element, action.implicit_wait);
			button_names.add(element.getText().trim());
		}
		return button_names;
	}

	/**
	 * By This Method We Can Get To Know By Default Any Checkbox Is Checked Or Not
	 * 
	 * @return{ if it's any one radio button is checked it's return ture and if it's
	 * not checked it's return false
	 */
	public boolean isByDefaultModeMasterPanelAnyRadioButtonIsChecked() {
		List<WebElement> list_radio_button = driver.findElements(
				By.xpath("//div[text()='Mode Master']/../following-sibling::div//div[@data-pc-name='radiobutton']"));
		action.waitForVisibility(list_radio_button.get(0), action.implicit_wait);
		String value = null;
		boolean flag = false;
		for (WebElement element : list_radio_button) {
			value = action.getAttributeValue(element, "class");
			if (value.trim().contains("checked")) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * By this method we can enter mode name
	 * 
	 * @param mode_name
	 */
	public void enterModeName(String mode_name) {
		action.waitForVisibility(mode_name_text_field, action.implicit_wait);
		action.type(mode_name_text_field, "Mode Name", mode_name);
	}

	/**
	 * By this method we can get the value of "Mode Name" text field
	 * 
	 * @return
	 */
	public String getModeNameTextFieldValue() {
		action.waitForVisibility(mode_name_text_field, action.implicit_wait);
		return action.getAttributeValue(mode_name_text_field, "value").trim();
	}

}
