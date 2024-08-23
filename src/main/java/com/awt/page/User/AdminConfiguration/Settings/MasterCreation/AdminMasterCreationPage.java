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
	public boolean isSelectModeVisible() {
		action.waitForVisibility(select_mode, action.implicit_wait);
		return action.isDisplay(select_mode);
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
			value = action.getAttributeValue(element, "value");
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
	public void clickOnMasterCreationDropDown(String drop_down_name) {
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
}
