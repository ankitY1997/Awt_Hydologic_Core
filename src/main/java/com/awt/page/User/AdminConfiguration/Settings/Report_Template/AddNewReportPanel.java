package com.awt.page.User.AdminConfiguration.Settings.Report_Template;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class AddNewReportPanel extends AdminReportTemplatePage {

	// *******Panel Name*************/
	@FindAll({ @FindBy(xpath = "//div[@data-pc-section='headertitle']") })
	public WebElement panel_name;

	// ******* Device Profile drop-down*************/
	@FindAll({ @FindBy(xpath = "//h6[text()='Device Profile*']/../following-sibling::div") })
	public WebElement device_profile_drop_down;

	// ******* Device Parameter drop-down*************/
	@FindAll({ @FindBy(xpath = "//h6[text()='Device Parameter*']/../following-sibling::div") })
	public WebElement device_parameter_drop_down;

	// ******* Menu Level drop-down*************/
	@FindAll({ @FindBy(xpath = "//h6[text()='Menu Level*']/../following-sibling::div") })
	public WebElement menu_level_drop_down;

	// ******* Template Name Text Field*************/
	@FindAll({ @FindBy(xpath = "//input[@placeholder='Enter Template Name']") })
	public WebElement template_name_text_field;

	// ******* Template Name Text Field Error Message *************/
	@FindAll({ @FindBy(xpath = "//input[@placeholder='Enter Template Name']/following-sibling::small") })
	public WebElement template_name_text_field_error_message;

	// ******* Show Serial Number Checkbox*************/
	@FindAll({ @FindBy(xpath = "//label[text()='Show Serial Number']/preceding-sibling::div") })
	public WebElement show_sr_no_checkbox;

	// ******* Show Set Value Checkbox*************/
	@FindAll({ @FindBy(xpath = "//label[text()='Show Set Value']/preceding-sibling::div") })
	public WebElement show_set_value_checkbox;

	// ******* Filter Data Drop Down*************/
	@FindAll({ @FindBy(xpath = "//h6[text()='Filter Data']/../following-sibling::div//*[local-name()='svg']") })
	public WebElement filter_data_drop_down;

	// ******* Report Field Drop Down*************/
	@FindAll({ @FindBy(xpath = "//label[text()='Report Field*']") })
	public WebElement report_field_drop_down;

	// *** Submit Button*******/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Submit']") })
	public WebElement submit_button;

	// ******Close Button****/
	@FindAll({ @FindBy(xpath = "//*[local-name()='svg' and @data-pc-section='closebuttonicon']") })
	public WebElement close_button;

	/* Constructor */
	public AddNewReportPanel(WebDriver driver) {
		super(driver);
	}

	/**
	 * To Get The Panel Name
	 * 
	 * @return panel name
	 */
	public String getPanelName() {
		action.waitForVisibility(panel_name, action.implicit_wait);
		return action.getText(panel_name).trim();
	}

	/**
	 * Check The Presence of device profile drop-down
	 * 
	 * @return if its is visible its return true otherwise it's return false
	 */
	public boolean isDeviceProfileDropDownIsVisible() {
		action.implicitWait(device_parameter_drop_down, action.implicit_wait);
		return action.isDisplay(device_parameter_drop_down);

	}

	/**
	 * Check The Presence of device Parameter drop-down
	 * 
	 * @return if its is visible its return true otherwise it's return false
	 */
	public boolean isDeviceParameterDropDownIsVisible() {
		action.implicitWait(template_name_text_field, action.implicit_wait);
		return action.isDisplay(template_name_text_field);

	}

	/**
	 * Check The Presence of Template Name Text Field
	 * 
	 * @return if its is visible its return true otherwise it's return false
	 */
	public boolean isTemplateNameTextFieldVisible() {
		action.implicitWait(template_name_text_field, action.implicit_wait);
		return action.isDisplay(template_name_text_field);
	}

	/**
	 * Check The Presence of menu level drop down
	 * 
	 * @return if its is visible its return true otherwise it's return false
	 */
	public boolean isMenuLevelDropDownIsVisible() {
		action.implicitWait(menu_level_drop_down, action.implicit_wait);
		return action.isDisplay(menu_level_drop_down);

	}

	/**
	 * Check The Presence of Report Field drop down
	 * 
	 * @return if its is visible its return true otherwise it's return false
	 */
	public boolean isReportFieldDropDownIsVisible() {
		action.implicitWait(report_field_drop_down, action.implicit_wait);
		return action.isDisplay(report_field_drop_down);

	}

	/**
	 * Check The Presence of Show Serial Number Check box
	 * 
	 * @return if its is visible its return true otherwise it's return false
	 */
	public boolean isShowSerialNumberCheckBoxVisible() {
		action.implicitWait(show_sr_no_checkbox, action.implicit_wait);
		return action.isDisplay(show_sr_no_checkbox);

	}

	/**
	 * Check The Presence of Show Set Value Check box
	 * 
	 * @return if its is visible its return true otherwise it's return false
	 */
	public boolean isShowSetValueCheckBoxVisible() {
		action.implicitWait(show_set_value_checkbox, action.implicit_wait);
		return action.isDisplay(show_set_value_checkbox);

	}

	/**
	 * By this method we can check "filter data" drop down visibility
	 * 
	 * @return boolean
	 */
	public boolean isFilterDataDropDownPresent() {
		action.implicitWait(filter_data_drop_down, action.implicit_wait);
		return action.isDisplay(filter_data_drop_down);

	}

	/**
	 * By this method we can check the visibility of submit button
	 * 
	 * @return boolean
	 */
	public boolean isSubmitButtonVisible() {
		action.implicitWait(submit_button, action.implicit_wait);
		return action.isDisplay(submit_button);

	}

	/**
	 * By This Method We Can Fetch The Default Value From Template Name Text Field
	 * Value
	 * 
	 * @return string
	 */
	public String getDefaultValueFromTemplateNameTextField() {
		action.implicitWait(template_name_text_field, action.implicit_wait);
		return action.getAttributeValue(template_name_text_field, "value").trim();
	}

	/**
	 * By this method we get template name text field error message
	 * 
	 * @return if there is error we can get error message otherwise it will return
	 *         empty string
	 */
	public String getTemplateNameTextErrorMessage() {
		String error_message = "";
		try {
			action.waitForVisibility(template_name_text_field_error_message, action.implicit_wait);
			error_message = action.getText(template_name_text_field_error_message);
		} catch (Exception e) {
			error_message = " ";
		}
		return error_message;
	}

	/**
	 * By This Method We Can Enter A Template Name
	 * 
	 * @param temp_name
	 */
	public void enterTemplateName(String temp_name) {
		action.waitForVisibility(template_name_text_field, action.implicit_wait);
		action.type(template_name_text_field, "Template Name", temp_name);
	}

	/**
	 * This Method Is Used To Select Any drop down Options Which Is Present in "Add
	 * new Report" panel.
	 * 
	 * @param drop_down_name
	 * @param option_name
	 * @implNote -> Please Pass The Drop Down Name, Option Same, as it is web page
	 */
	public void selectDropDown(String drop_down_name, String option_name) {

		action.waitForVisibility(
				driver.findElement(By.xpath("//h6[text()='" + drop_down_name + "']/../following-sibling::div")), 0);
		action.clickOn(driver.findElement(By.xpath("//h6[text()='" + drop_down_name + "']/../following-sibling::div")));
		action.waitForVisibility(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + option_name + "']")),
				action.implicit_wait);
		action.clickOn(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + option_name + "']")));

	}

	/**
	 * With Help Of This Method We Can Know Which Option Is Currently Selected In
	 * Particular drop down
	 *
	 * @return {If Option Is Selected It's return the name of option otherwise it's
	 *         return empty
	 * @param drop_down
	 * @implNote Please Pass The drop-down name very carefully it should be same as
	 *           web page
	 */
	public String getSelectedOptionName(String drop_down) {
		action.waitForVisibility(driver.findElement(By.xpath("//h6[contains(text(),'" + drop_down
				+ "')]/../following-sibling::div//span[@data-pc-section='input']")), action.implicit_wait);
		return action.getText(driver.findElement(By.xpath("//h6[contains(text(),'" + drop_down
				+ "')]/../following-sibling::div//span[@data-pc-section='input']")));

	}

	/**
	 * With Help Of This Method We Can Get All The CheckBox names Which Is present
	 * Parameter Status Drop Down
	 */
	public List<String> getNameOfParameterStatusCheckBox() {

		List<WebElement> parameter_check_box_list = driver
				.findElements(By.xpath("//label[text()='Parameter Status*']/..//div/following-sibling::label"));
		List<String> checkbox_name = new ArrayList<String>();
		for (WebElement element : parameter_check_box_list) {
			action.waitForVisibility(element, action.implicit_wait);
			checkbox_name.add(action.getText(element).trim());
		}
		return checkbox_name;

	}

	/**
	 * This method allows us to verify whether the specified checkbox is located
	 * under the parameter status checkbox.
	 * 
	 * @param checkbox
	 * @return if its present its throw yes and if its not its throw no
	 */
	public boolean isCheckboxPresentUnderParameterStatus(String checkbox) {
		boolean flag = false;
		for (String checkbox_name : getNameOfParameterStatusCheckBox()) {
			if (checkbox_name.contains(checkbox)) {
				flag = true;
			}
		}
		return flag;

	}

	/**
	 * By This Method We Can Select any Check in Parameter Status
	 * 
	 * @param parameter_checkbox
	 * @implNote always pass the correct name of the checkbox
	 */
	public void selectParameterStatusCheckBox(String option) {

		action.waitForVisibility(driver
				.findElement(By.xpath("//label[text()='Parameter Status*']/..//div/following-sibling::label[text()='"
						+ option + "']/preceding-sibling::div")),
				action.implicit_wait);
		action.clickOn(driver
				.findElement(By.xpath("//label[text()='Parameter Status*']/..//div/following-sibling::label[text()='"
						+ option + "']/preceding-sibling::div")));
	}

	/**
	 * Get To know In about "Parameter List" check boxes status is checked or
	 * unchecked selected then it's return true and if its not return false
	 * 
	 * @param option
	 */
	public boolean isParameterStatusCheckBoxSelected(String option) {

		action.waitForVisibility(driver.findElement(By.xpath(
				"//label[contains(text(),'Parameter Status*')]/..//div/following-sibling::label[contains(text(),'"
						+ option + "')]/preceding-sibling::div")),
				action.implicit_wait);
		String value = action.getAttributeValue(driver.findElement(By.xpath(
				"//label[contains(text(),'Parameter Status*')]/..//div/following-sibling::label[contains(text(),'"
						+ option + "')]/preceding-sibling::div")),
				"class");
		return value.contains("checked");

	}

	/**
	 * With Help Of This Method We Can Get All The CheckBox names Which Is present
	 * Report Field list
	 */
	public List<String> getNameOfReportFieldCheckBox() {

		List<WebElement> parameter_check_box_list = driver
				.findElements(By.xpath("//label[contains(text(),'Report Field')]/..//div/following-sibling::label"));
		List<String> checkbox_name = new ArrayList<String>();
		for (WebElement element : parameter_check_box_list) {
			action.waitForVisibility(element, action.implicit_wait);
			checkbox_name.add(action.getText(element).trim());
		}
		return checkbox_name;

	}

	/**
	 * This method allows us to verify whether the specified checkbox is located
	 * under the report field list
	 * 
	 * @param checkbox
	 * @return if its present its throw yes and if its not its throw no
	 */
	public boolean isCheckboxPresentUnderReportField(String checkbox) {
		boolean flag = false;
		for (String checkbox_name : getNameOfParameterStatusCheckBox()) {
			if (checkbox_name.contains(checkbox)) {
				flag = true;
			}
		}
		return flag;

	}

	/**
	 * By This Method We Can Select any Check box in report field
	 * 
	 * @param report field_checkbox name
	 * @implNote always pass the correct name of the check box
	 */
	public void selectReportFieldCheckBox(String option) {

		action.waitForVisibility(driver.findElement(
				By.xpath("//label[contains(text(),'Report Field*')]/..//div/following-sibling::label[contains(text(),'"
						+ option + "')]/preceding-sibling::div")),
				action.implicit_wait);
		action.clickOn(driver.findElement(
				By.xpath("//label[contains(text(),'Report Field*')]/..//div/following-sibling::label[contains(text(),'"
						+ option + "')]/preceding-sibling::div")));
	}

	/**
	 * Get To know In Report Field List Which are check boxes are selected if it's
	 * selected then it's return true and if its not return false
	 * 
	 * @param option
	 */
	public boolean isReportFieldCheckBoxSelected(String option) {

		action.waitForVisibility(driver.findElement(
				By.xpath("//label[contains(text(),'Report Field*')]/..//div/following-sibling::label[contains(text(),'"
						+ option + "')]/preceding-sibling::div")),
				action.implicit_wait);
		String value = action.getAttributeValue(driver.findElement(
				By.xpath("//label[contains(text(),'Report Field*')]/..//div/following-sibling::label[contains(text(),'"
						+ option + "')]/preceding-sibling::div")),
				"class");
		return value.contains("checked");

	}

	/**
	 * By this method we can select the "show serial number checkbox"
	 */
	public void selectShowSerialNumberCheckBox() {
		action.waitForVisibility(show_sr_no_checkbox, action.implicit_wait);
		action.clickOn(show_sr_no_checkbox);
	}

	/**
	 * By This Method We Can Get Know "Show Serial Number" Check Boxes status Is
	 * checked or unchecked and if it's selected then its return true otherwise its
	 * return false
	 * 
	 * @return boolean
	 */
	public boolean isShowSerialNumberCheckBoxSelected() {
		action.waitForVisibility(show_sr_no_checkbox, action.implicit_wait);
		String value = action.getAttributeValue(show_sr_no_checkbox, "class");
		return value.contains("checked");
	}

	/**
	 * By this method we can select the "show set value " check box
	 */
	public void selectShowSetValueCheckBox() {
		action.waitForVisibility(show_set_value_checkbox, action.implicit_wait);
		action.clickOn(show_set_value_checkbox);
	}

	/**
	 * By This Method We Can Get Know "Show Set Value" check or un-check status and
	 * if it's selected then its return true otherwise its return false
	 * 
	 * @return boolean
	 */
	public boolean isShowSetValueCheckBoxSelected() {
		action.waitForVisibility(show_set_value_checkbox, action.implicit_wait);
		String value = action.getAttributeValue(show_set_value_checkbox, "class");
		return value.contains("checked");
	}

	/**
	 * @implNote this method we can select only filter data check boxes
	 * @param option
	 */
	public void selectFilterDataCheckBox(String option) {
		action.waitForVisibility(filter_data_drop_down, action.implicit_wait);
		action.performMoveToElement(filter_data_drop_down);
		action.clickOn(filter_data_drop_down);
		action.clickOn(driver.findElement(
				By.xpath("//ul[@role='listbox']/li/span[text()='" + option + "']/preceding-sibling::div")));

	}

	/**
	 * By this method we can get to know about the checked and unchecked status of
	 * filter data check boxes.
	 * 
	 * @return boolean {it's checked it's return true and if it's unchecked it's
	 *         return false}
	 */
	public boolean isFilterDataCheckBoxSelected(String check_box_name) {
		List<WebElement> selected_checkbox_list = driver.findElements(
				By.xpath("//h6[text()='Filter Data']/../following-sibling::div//span[@data-pc-section='tokenlabel']"));
		String name = null;
		boolean flag = false;
		for (WebElement check_box_list : selected_checkbox_list) {
			action.waitForVisibility(check_box_list, action.implicit_wait);
			name = action.getText(check_box_list).trim();
			if (name.equals(check_box_name.trim())) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * By This Method We Can Click On Submit Button
	 */
	public void clickOnSubmitButton() {
		action.waitForVisibility(submit_button, action.implicit_wait);
		action.clickOn(submit_button);
	}

	/**
	 * With help of This method We can close panel
	 */
	public void closePanel() {
		action.waitForVisibility(close_button, action.implicit_wait);
		action.clickOn(close_button);

	}

}