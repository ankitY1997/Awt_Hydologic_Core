package com.awt.page.User.AdminConfiguration.Settings.MasterCreation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.awt.page.User.AdminConfiguration.AdminPage;

public class AdminMasterCreationPage extends AdminPage {

	// ******* List Of Radio Button*************/
	@FindAll({ @FindBy(xpath = "//div[contains(@class,'field-radiobutton')]/div"),
			@FindBy(xpath = "//div[contains(@class,'field-radiobutton')]/div[@data-pc-name='radiobutton']"),
			@FindBy(xpath = "//div[@data-pc-name='radiobutton']") })
	public List<WebElement> list_radio_button;

	// ******Select Mode ********/
	@FindAll({ @FindBy(xpath = "//label[text()='Select Mode']/..//button//*[local-name()='svg']") })
	public WebElement select_mode;

	// ******List Of Mode ********/
	@FindAll({ @FindBy(xpath = "//ul[@id='search_list']/li") })
	public List<WebElement> mode_list;

	// ******select mode ellipsis button ********/
	@FindAll({ @FindBy(xpath = "//label[text()='Select Mode']/../div//button[not(@aria-label='Select Mode')]") })
	public WebElement select_mode_ellipsis_button;

	// ***Master Name Auto Suggestive Drop Down**/
	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Master Name')]") })
	public WebElement master_name_auto_sugg_drop_down_button;

	// ***Master Name Auto Suggestive Drop Down Text**/
	@FindAll({ @FindBy(xpath = "//span[@id='masterName']/input") })
	public WebElement master_name_auto_text;

	// ***Current Field Name**/
	@FindAll({ @FindBy(xpath = "//span[@id='masterName']/input") })
	public WebElement master_name_curr_field_name;

	// **Description Text Field**/
	@FindAll({ @FindBy(xpath = "//label[text()='Description']/following-sibling::input") })
	public WebElement description_text_field;

	// **Save Button**/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Save']") })
	public WebElement save_button;

	// ***Constructor***/
	public AdminMasterCreationPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * By This Method We Can Check Master Creation button is visible or not
	 * 
	 * @return if it's visible then its return true and if its not visible then it's
	 *         return false
	 */
	public boolean isMasterCreationOptionVisible() {
		return flag;
	}

	/**
	 * By This Method We Can Check "Select Mode" Drop Down Is Visible
	 * 
	 * @return
	 */
	public boolean isSelectModeDropDownVisible() {
		action.waitForVisibility(select_mode, action.implicit_wait);
		return action.isDisplay(select_mode);
	}

	/**
	 * By This Method We Can Check "Select Mode" ellipsis button Is Visible
	 * 
	 * @return boolean
	 */
	public boolean isSelectEllipsisButtonVisible() {
		action.waitForVisibility(select_mode_ellipsis_button, action.implicit_wait);
		return action.isDisplay(select_mode_ellipsis_button);
	}

	/**
	 * By This Method We Can Check "Master Name" AutoSuggestive drop down Is Visible
	 * 
	 * @return boolean
	 */
	public boolean isMasterNameAutoSuggestiveDropDownVisible() {
		action.waitForVisibility(master_name_auto_sugg_drop_down_button, action.implicit_wait);
		return action.isDisplay(master_name_auto_sugg_drop_down_button);
	}

	/**
	 * By This Method We Can Check "Description" text Field Is Visible
	 * 
	 * @return boolean
	 */
	public boolean isDescriptionTextFieldVisible() {
		action.waitForVisibility(description_text_field, action.implicit_wait);
		return action.isDisplay(description_text_field);
	}

	/**
	 * By This Method We Can Check "Description" text Field Is Visible
	 * 
	 * @return boolean
	 */
	public boolean isSaveButtonVisible() {
		action.waitForVisibility(save_button, action.implicit_wait);
		return action.isDisplay(save_button);
	}

	/**
	 * By This Method We Can Get Current Master Field Name
	 * 
	 * @return
	 */
	public String getCurrentNameOfMasterField() {
		action.waitForVisibility(master_name_curr_field_name, action.implicit_wait);
		return action.getText(master_name_curr_field_name);
	}

	/**
	 * By this method we can enter the Master Name Text Field
	 * 
	 * @param value
	 */
	public void enterMasteName(String value) {
		action.waitForVisibility(master_name_auto_text, action.implicit_wait);
		action.type(master_name_auto_text, getCurrentNameOfMasterField(), value);
	}

	/**
	 * By This Method We Can Get The "Master Name" Text Field Value
	 * 
	 * @return
	 */
	public String getValueOfMasterNameAutoSuggestiveField() {
		action.waitForVisibility(master_name_auto_text, action.implicit_wait);
		return action.getAttributeValue(master_name_auto_text, "value");
	}

	/**
	 * By This Method We Can Enter The Description
	 * 
	 * @param description
	 */
	public void enterDescription(String description) {
		if (isDescriptionTextFieldVisible()) {
			action.type(description_text_field, "Description ", description);
		}
	}

	/**
	 * By This Method We Can Get The "Description" Text Field Value
	 * 
	 * @return
	 */
	public String getValueOfDescriptionTextField() {
		action.waitForVisibility(description_text_field, action.implicit_wait);
		return action.getAttributeValue(description_text_field, "value");
	}

	/**
	 * By This Method User Can Check The Visibility Of Radio Button
	 * 
	 * @param radio_button_name { you need to pass the correct name of radio button
	 *                          as same its written in web page
	 * @return if it's visible then it will return true otherwise it return false
	 */
	public boolean isRadioButtonIsVisible(String radio_button_name) {
		action.waitForVisibility(driver
				.findElement(By.xpath("//div[@data-pc-name='radiobutton']/following-sibling::label[contains(text(),'"
						+ radio_button_name + "')]")),
				action.implicit_wait);
		return action.isDisplay(driver
				.findElement(By.xpath("//div[@data-pc-name='radiobutton']/following-sibling::label[contains(text(),'"
						+ radio_button_name + "')]")));
	}

	/**
	 * By This Method User Can Click On or Select Any Radio Button By Providing Name
	 * Of Radio Button
	 * 
	 * @param radio_button_name {same as it's web page}
	 */
	public void clickOnRadioButton(String radio_button_name) {
		if (isRadioButtonIsVisible(radio_button_name)) {
			action.clickOn(driver.findElement(
					By.xpath("//div[@data-pc-name='radiobutton']/following-sibling::label[contains(text(),'"
							+ radio_button_name + "')]")));
		}
	}

	/**
	 * By This Method We Can Get To Know By Default Any Checkbox Is Checked Or Not
	 * 
	 * @return{ if it's any one radio button is checked it's return ture and if it's
	 * not checked it's return false
	 */
	public boolean isByDefaultAnyRadioButtonIsChecked() {
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
	 * By This Method We Can Click Any Master Creation Panel DropDown
	 * 
	 * @param drop_down_name { drop_down_name should be same as it's in webpage}
	 * 
	 */
	public void clickOnAnyMasterCreationDropDown(String drop_down_name) {
		action.waitForVisibility(
				driver.findElement(
						By.xpath("//label[text()='" + drop_down_name + "']/..//button//*[local-name()='svg']")),
				action.implicit_wait);
		action.clickOn(driver
				.findElement(By.xpath("//label[text()='" + drop_down_name + "']/..//button//*[local-name()='svg']")));
	}

	/**
	 * By This Method We Can Check Passed Mode Name Is Present In Select Mode
	 * DropDown List Or Not
	 * 
	 * @param exp_mode_name {Passed Correct Mode Name}
	 * @return boolean
	 */
	public boolean isModePresent(String exp_mode_name) {
		action.waitForVisibility(mode_list.get(0), action.implicit_wait);
		boolean flag = false;
		String act_mode_name = null;
		for (WebElement element : mode_list) {
			act_mode_name = element.getText().trim();
			if (act_mode_name.equals(exp_mode_name)) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * By This Method We Can Select Mode From Select Mode Name DropDown
	 * 
	 * @param mode_name
	 */
	public void selectMode(String mode_name) {
		action.waitForVisibility(
				driver.findElement(
						By.xpath("//ul[@id='search_list' or @role='listbox']/li[text()='" + mode_name + "']")),
				action.implicit_wait);
		action.performMoveToElement(driver
				.findElement(By.xpath("//ul[@id='search_list' or @role='listbox']/li[text()='" + mode_name + "']")));
		action.clickOn(driver
				.findElement(By.xpath("//ul[@id='search_list' or @role='listbox']/li[text()='" + mode_name + "']")));
	}

	/**
	 * By This Method We Can Get Selected Mode Name
	 * 
	 * @return Selected Mode Name
	 */
	public String getSelectedModeValue() {
		action.waitForVisibility(
				driver.findElement(By.xpath("//label[text()='Select Mode']/following-sibling::div/span/input")),
				action.implicit_wait);
		return action.getAttributeValue(
				driver.findElement(By.xpath("//label[text()='Select Mode']/following-sibling::div/span/input")),
				"value").trim();

	}

	/**
	 * Click On Save Button
	 */
	public void clickOnSaveButton() {
		if (isSaveButtonVisible()) {
			action.clickOn(save_button);
		}
	}

}
