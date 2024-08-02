package com.awt.page.User.AdminConfiguration.User.CreateRole;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.AwtUtilities;

public class AddNewRolePanel extends AdminAddRolePage {

	// ******Panel heading****/
	@FindAll({ @FindBy(xpath = "//div[contains(@id,'header')]") })
	public WebElement panel_heading;

	// ** Add New Role Panel Text Fields Name****/
	@FindAll({ @FindBy(xpath = "//h6") })
	public List<WebElement> newRolePanelTextFields;

	// *** Create button****/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Create'and @type='submit']") })
	public WebElement create_button;

	// *** role name text field****/
	@FindAll({ @FindBy(xpath = "//input[@id='role_name']") })
	public WebElement role_name_text_feid;

	// ***Role Descritpitons Text Field*******/
	@FindAll({ @FindBy(xpath = "//textarea[@id='role_description']") })
	public WebElement role_descriptions_text_feid;

	// **********Cancel Add New Role Panel*****/
	@FindAll({ @FindBy(xpath = "//div[@data-pc-section='headericons']/button") })
	public WebElement cancel_button;

	// **********Duplicate Error Message*****/
	@FindAll({ @FindBy(xpath = "//input[@id='role_name']/..//following-sibling::p") })
	public WebElement duplicate_error;

	// **Constructor**/

	public AddNewRolePanel(WebDriver driver) {
		super(driver);
	}

	/**
	 * With help Of This Method We Can Get Panel Name
	 * 
	 * @return name of Panel
	 */
	public String getNameOfThePanel() {
		action.waitForVisibility(panel_heading, action.implicit_wait);
		return action.getText(panel_heading);
	}

	/**
	 * By This Method We Can Get All The Text Fields Name Inside the Add New Role
	 * Panel
	 * 
	 * @return text_fields_name
	 */
	public List<String> getPanelTextFieldsName() {
		List<String> text_field_names = new ArrayList<String>();
		action.waitForVisibility(newRolePanelTextFields.get(0), action.implicit_wait);

		for (WebElement element : newRolePanelTextFields) {
			text_field_names.add(action.getText(element).trim());
		}
		return text_field_names;
	}

	/**
	 * We Can Check Create Button Visibility
	 * 
	 * @return {if its is visible it will return true otherwise false
	 */
	public boolean isCreateButtonIsVisible() {
		action.waitForVisibility(create_button, action.implicit_wait);
		return action.isDisplay(create_button);
	}

	/**
	 * We Can Check Cancel Button Visibility
	 * 
	 * @return {if its is visible it will return true otherwise false
	 */
	public boolean isCancelButtonIsVisible() {
		action.waitForVisibility(cancel_button, action.implicit_wait);
		return action.isDisplay(cancel_button);
	}
	

	/**
	 * By This Text Method We Can Get Any Text Fields Value
	 * 
	 * @param text_field_name
	 * @return text field value
	 */
	public String getAddNewRolePanelFieldsValue(String text_field_name) {
		String value = null;
		if (text_field_name.contains("Role Name")) {
			value = action.getAttributeValue(role_name_text_feid, "value").trim();
		} else if (text_field_name.contains("Role Descriptions")) {
			value = action.getAttributeValue(role_descriptions_text_feid, "value").trim();
		}
		return value;
	}

	/**
	 * To Get Error Message Of Add New Role Panel Text Fields
	 * 
	 * @param text_field_name
	 * @return
	 */
	public String getAddNewRolePanelErrorMessage(String text_field_name) {
		String error_message = null;
		try {
			if (text_field_name.contains("Role Name")) {
				error_message = action
						.getText(driver.findElement(By.xpath("//h6[text()='Role Name:']/following-sibling::small")))
						.trim();
			} else if (text_field_name.contains("Role Descriptions")) {
				error_message = action.getText(role_name_text_feid.findElement(By.xpath("//small"))).trim();
			}
			return error_message;
		} catch (Exception e) {
			return error_message = "";
		}
	}

	/**
	 * To Enter Role Name
	 * 
	 * @param role_name
	 */
	public void enterRoleName(String role_name) {
		action.waitForVisibility(role_name_text_feid, action.implicit_wait);
		// enter the value
		action.type(role_name_text_feid, "Role Name", role_name);
	}

	/**
	 * To Enter The Role Description
	 * 
	 * @param description
	 */
	public void enterRoleDescription(String description) {
		action.waitForVisibility(role_descriptions_text_feid, action.implicit_wait);
		// enter the value
		action.type(role_descriptions_text_feid, "Role Description", description);
	}

	/**
	 * Click On Create Button
	 */
	public void clickOnCreateButton() {
		action.clickOn(create_button);
	}

	/**
	 * Accept The Pop-up
	 */
	public void acceptPopup() {
		action.acceptJavaScriptPopup();
	}

	/**
	 * Cancel The Add New Role Panel
	 */
	public void cancelAddNewRolePanel() {
		action.waitForVisibility(cancel_button, action.implicit_wait);
		action.clickOn(cancel_button);

	}

	/**
	 * Get Duplicate Error Message
	 * 
	 * @return
	 */
	public String getDuplicateErrorMessage() {
		AwtUtilities.waitFor(1000);
		return action.getText(duplicate_error);
	}
}
