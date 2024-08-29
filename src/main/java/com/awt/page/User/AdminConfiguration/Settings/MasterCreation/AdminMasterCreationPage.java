package com.awt.page.User.AdminConfiguration.Settings.MasterCreation;

import java.util.ArrayList;
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

	// ******List Of Master Name ********/
	@FindAll({ @FindBy(xpath = "//ul[@id='masterName_list']/li") })
	public List<WebElement> master_name_list;

	// ******List Of External Parent Name ********/
	@FindAll({ @FindBy(xpath = "//ul[@role='listbox']/li") })
	public List<WebElement> external_parent__list;

	// ******select mode ellipsis button ********/
	@FindAll({ @FindBy(xpath = "//label[text()='Select Mode']/../div//button[not(@aria-label='Select Mode')]") })
	public WebElement ellipsis_button;

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

	// **Cancel Button**/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Cancel']") })
	public WebElement cancel_button;

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
	public boolean isSelectModeEllipsisButtonVisible() {
		action.waitForVisibility(ellipsis_button, action.implicit_wait);
		return action.isDisplay(ellipsis_button);
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
	 * By This Method We Can Check "Save" button Is Visible
	 * 
	 * @return boolean
	 */
	public boolean isSaveButtonVisible() {
		action.waitForVisibility(save_button, action.implicit_wait);
		return action.isDisplay(save_button);
	}

	/**
	 * By This Method We Can Check "Cancel" button Is Visible
	 * 
	 * @return boolean
	 */
	public boolean isCancelButtonVisible() {
		action.waitForVisibility(cancel_button, action.implicit_wait);
		return action.isDisplay(cancel_button);
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
				break;
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
		try {
			if (drop_down_name.equalsIgnoreCase("Select Mode")) {
				action.waitForVisibility(
						driver.findElement(
								By.xpath("//label[text()='" + drop_down_name + "']/..//button//*[local-name()='svg']")),
						action.implicit_wait);
				action.clickOn(driver.findElement(
						By.xpath("//label[text()='" + drop_down_name + "']/..//button//*[local-name()='svg']")));
			} else if (drop_down_name.equalsIgnoreCase("Master Name")) {
				action.waitForVisibility(
						driver.findElement(By.xpath("//span[@id='masterName']//*[local-name()='svg']")),
						action.implicit_wait);
				action.clickOn(driver.findElement(By.xpath("//span[@id='masterName']//*[local-name()='svg']")));
			}
		} catch (Exception e) {
			action.waitForVisibility(
					driver.findElement(By.xpath("//label[text()='" + drop_down_name + "']/..//*[local-name()='svg']")),
					action.implicit_wait);
			action.clickOn(
					driver.findElement(By.xpath("//label[text()='" + drop_down_name + "']/..//*[local-name()='svg']")));
		}
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
			action.performMoveToElement(element);
			act_mode_name = element.getText().trim();
			if (act_mode_name.equals(exp_mode_name)) {
				flag = true;
				break;
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
	 * By This Method We Can Check Passed Master Name Is Present In Master Name
	 * DropDown List Or Not
	 * 
	 * @param exp_master_name
	 * @implNote Correct Master Name
	 * @return boolean
	 */
	public boolean isMasterNamePresent(String exp_master_name) {
		action.waitForVisibility(master_name_list.get(0), action.implicit_wait);
		boolean flag = false;
		String act_mode_name = null;
		for (WebElement element : master_name_list) {
			action.performMoveToElement(element);
			act_mode_name = element.getText().trim();
			if (act_mode_name.equals(exp_master_name)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * By This Method We Can Select Master Name From Select Master Name DropDown
	 * 
	 * @param master_name
	 */
	public void selectMasterName(String master_name) {
		action.waitForVisibility(
				driver.findElement(
						By.xpath("//ul[@id='masterName_list' or @role='listbox']/li[text()='" + master_name + "']")),
				action.implicit_wait);
		action.performMoveToElement(driver.findElement(
				By.xpath("//ul[@id='masterName_list' or @role='listbox']/li[text()='" + master_name + "']")));
		action.clickOn(driver.findElement(
				By.xpath("//ul[@id='masterName_list' or @role='listbox']/li[text()='" + master_name + "']")));
	}

	/**
	 * Click On Save Button
	 */
	public void clickOnSaveButton() {
		if (isSaveButtonVisible()) {
			action.clickOn(save_button);
		}
	}

	/**
	 * Click On Cancel Button
	 */
	public void clickOnCancelButton() {
		if (isCancelButtonVisible()) {
			action.clickOn(cancel_button);
		}
	}

	/**
	 * By This Method We Can Navigate System Moder Master pnael
	 * 
	 * @return object of SystemModeMasterPanel
	 */
	public SystemModeMasterPanel clickOnElipsisButtonNavigateToSystemModeMasterPanel() {
		clickOnRadioButton("System Master");
		if (isSelectModeEllipsisButtonVisible()) {
			action.clickOn(ellipsis_button);
		}
		return new SystemModeMasterPanel(driver);
	}
	// ****User Defined Radio Button Related Methods*********/

	/**
	 * By this method we can get all fields name which present when we are selecting
	 * "User Defined" radio button
	 * 
	 * @return all fields name
	 */
	public List<String> getAllUserDefinedFieldName() {

		List<WebElement> fields_name = driver.findElements(By.xpath("//div[@class='field']/label"));
		List<String> actual_fields_name = new ArrayList<String>();
		for (WebElement element : fields_name) {
			actual_fields_name.add(element.getText());
		}
		return actual_fields_name;
	}

	/**
	 * By This Method We Can Navigate User Defined Mode Master panel
	 * 
	 * @return object of UserDefinedModeMasterPanel
	 */
	public UserDefinedModeMasterPanel clickOnElipsisButtonNavigateToUserDefinedMasterPanel() {
		clickOnRadioButton("User Defined");
		if (isSelectModeEllipsisButtonVisible()) {
			action.clickOn(ellipsis_button);
		}
		new SystemModeMasterPanel(driver).clickOnModeMasterRadioButton("User Defined");
		return new UserDefinedModeMasterPanel(driver);
	}

	// *****External Radio Button Related Methods*****//

	/**
	 * By This Method We Can Navigate User Defined Mode Master panel
	 * 
	 * @return object of UserDefinedModeMasterPanel
	 */
	public ExternalModeMasterPanel clickOnElipsisButtonNavigateToExternalModeMasterPanel() {
		clickOnRadioButton("External");
		if (isSelectModeEllipsisButtonVisible()) {
			action.clickOn(ellipsis_button);
		}
		new SystemModeMasterPanel(driver).clickOnModeMasterRadioButton("External");
		return new ExternalModeMasterPanel(driver);
	}

	/**
	 * By this method we can get all fields name which present when we are selecting
	 * "User Defined" radio button
	 * 
	 * @return all fields name
	 */
	public List<String> getAllExternalFieldName() {

		List<WebElement> fields_name = driver.findElements(By.xpath("//div[@class='field']/label"));
		List<String> actual_fields_name = new ArrayList<String>();
		for (WebElement element : fields_name) {
			actual_fields_name.add(element.getText());
		}
		return actual_fields_name;
	}

	/**
	 * By This Method We Can Check Passed Master Name Is Present In Master Name
	 * DropDown List Or Not
	 * 
	 * @param exp_Parent_name
	 * @implNote Pass the correct Parent Name
	 * @return boolean
	 */
	public boolean isExternalParentPresent(String exp_parent_name) {
		action.waitForVisibility(external_parent__list.get(0), action.implicit_wait);
		boolean flag = false;
		String act_mode_name = null;
		for (WebElement element : master_name_list) {
			action.performMoveToElement(element);
			act_mode_name = element.getText().trim();
			if (act_mode_name.equals(exp_parent_name)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * By this method we can select option which is present under the external
	 * parent drop down
	 * 
	 * @param parent_name
	 */
	public void selectExtrnalParent(String parent_name) {
		action.waitForVisibility(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + parent_name + "']")),
				action.implicit_wait);
		action.clickOn(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + parent_name + "']")));
	}
}
