package com.awt.page.Irrigation.Admin.User.CreateUser;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class AddUserPanel extends AdminAddUserPage {

	// *******Panel Name*************/
		@FindAll({ @FindBy(xpath = "//div[@data-pc-section='headertitle']") })
		public WebElement panel_name;

		// ********Role Details Table Columns Name**********/
		@FindAll({ @FindBy(xpath = "//h6") })
		public List<WebElement> add_user_panel_fields;

		// *******User Name text Field*********/
		@FindAll({ @FindBy(xpath = "//input[@id='username']") })
		public WebElement username_text;

		// *******Password text Field*********/
		@FindAll({ @FindBy(xpath = "//input[@name='password']") })
		public WebElement password_text;

		// *******EMail text Field*********/
		@FindAll({ @FindBy(xpath = "//input[@id='email']") })
		public WebElement email_text;

		// *** First Name text Field******/
		@FindAll({ @FindBy(xpath = "//input[@name='first_name']") })
		public WebElement first_name_text;

		// *** First Name text Field******/
		@FindAll({ @FindBy(xpath = "//input[@name='last_name']") })
		public WebElement last_name_text;

		// *** Role Drop-Drop down button******/
		@FindAll({ @FindBy(xpath = "//div[@id='role_id']") })
		public WebElement role_button;

		// ******To Know Selected Role Name***/
		@FindAll({ @FindBy(xpath = "//div[@id='role_id']/span") })
		public WebElement role_name;

		// *** Role Drop-Drop down button******/
		@FindAll({ @FindBy(xpath = "//button[@aria-label='Create']") })
		public WebElement create_button;

		// *** Cancel button******/
		@FindAll({ @FindBy(xpath = "//button[@data-pc-section='closebutton']") })
		public WebElement cancel_button;

		/** ROle Name Lists ***/
		@FindAll({ @FindBy(xpath = "//ul[@role='listbox']/li") })
		public List<WebElement> role_lists;

		// *** Duplicate User Name Error Message******/
		@FindAll({ @FindBy(xpath = "//form//P") })
		public WebElement dup_error_msg;

		/**
		 * Constructor
		 * 
		 * @param driver
		 */
		public AddUserPanel(WebDriver driver) {
			super(driver);

		}

		/**
		 * Click On Create button
		 */
		public void clickOnCreateButton() {
			action.waitForVisibility(create_button, action.implicit_wait);
			action.clickOn(create_button);
		}

		/**
		 * Click On Cancel button
		 */
		public void clickOnCancelButton() {
			action.waitForVisibility(cancel_button, action.implicit_wait);
			action.clickOn(cancel_button);
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
		 * Get List Of Add User Panel Text Fields
		 * 
		 * @return
		 */
		public List<String> listOfAddUserPanelFields() {
			action.waitForVisibility(add_user_panel_fields.get(0), action.implicit_wait);
			List<String> fields_name = new ArrayList<String>();
			for (WebElement element : add_user_panel_fields) {

				fields_name.add(element.getText().trim());
			}
			return fields_name;

		}

		/**
		 * Get Duplicate User Name Error Message
		 * 
		 * @return
		 */
		public String getDuplicateErrorMessage() {
			return action.getText(dup_error_msg);
		}

		/**
		 * By This Method We Can Enter UserName
		 */
		public void enterUserName(String username) {
			action.waitForVisibility(username_text, action.implicit_wait);
			action.type(username_text, "USER NAME", username);
		}

		/**
		 * Get The User Name text field Value
		 * 
		 * @return
		 */
		public String getUserNameFieldValue() {
			return action.getAttributeValue(username_text, "value");
		}

		/**
		 * BY This Method We Can Enter Password
		 * 
		 * @param password
		 */
		public void enterPassword(String password) {
			action.waitForVisibility(password_text, action.implicit_wait);
			action.type(password_text, "PASSWORD", password);
		}

		/**
		 * Get The Password Text Field Value
		 * 
		 * @return
		 */
		public String getPasswordTextFieldValue() {
			return action.getAttributeValue(password_text, "value");
		}

		/**
		 * Get The first name Text Field Value
		 * 
		 * @return
		 */
		public String getFirstTextFieldValue() {
			return action.getAttributeValue(first_name_text, "value");
		}

		/**
		 * Get The last name Text Field Value
		 * 
		 * @return
		 */
		public String getLastNameTextFieldValue() {
			return action.getAttributeValue(last_name_text, "value");
		}

		/**
		 * BY This Method We Can Enter Email
		 * 
		 * @param email
		 */
		public void enterEmail(String email) {
			action.waitForVisibility(email_text, action.implicit_wait);
			action.type(email_text, "Email", email);
		}

		/**
		 * BY This Method We Can Enter First Name
		 * 
		 * @param First Name
		 */
		public void enterFirstName(String first_name) {
			action.waitForVisibility(first_name_text, action.implicit_wait);
			action.type(first_name_text, "First Name", first_name);
		}

		/**
		 * BY This Method We Can Enter Last Name
		 * 
		 * @param Last Name
		 */
		public void enterLastName(String first_name) {
			action.waitForVisibility(last_name_text, action.implicit_wait);
			action.type(last_name_text, "First Name", first_name);
		}

		/**
		 * Help of This Method We Can Select Role Name
		 * 
		 * @param roleName
		 */
		public void selectRole(String roleName) {
			action.waitForVisibility(role_button, action.implicit_wait);
			action.clickOn(role_button);
			String value = null;
			for (int i = 0; i < role_lists.size(); i++) {
				try {
					value = action.getText(role_lists.get(i)).trim();
					action.performMoveToElement(role_lists.get(i));
					if (value.equals(roleName)) {
						action.clickOn(role_lists.get(i));
						break;
					}
				} catch (Exception e) {
      
				}
			}
		}

		/**
		 * Get Selected Role Name
		 * 
		 * @return
		 */
		public String getSelectedRoleName() {
			action.waitForVisibility(role_name, action.implicit_wait);
			return action.getText(role_name).trim();

		}

		/**
		 * Check Visibility Of Roles
		 * 
		 * @param role
		 * @return flag{if Role is Visible then its return True other wiser it returns
		 *         false
		 */
		public boolean isRoleVisible(String role) {
			action.waitForVisibility(role_button, action.implicit_wait);
			action.clickOn(role_button);
			boolean flag = false;
			for (WebElement element : role_lists) {
				if (element.getText().trim().equalsIgnoreCase(role)) {
					action.performMoveToElement(element);
					flag = true;
					break;
				}

			}
			return flag;
		}

		/**
		 * Help Of This Method We Can Check Create Button is visible pr not
		 * 
		 */
		public boolean isCreateButtonVisible() {
			action.waitForVisibility(create_button, action.implicit_wait);
			return action.isDisplay(create_button);
		}

		/**
		 * To Fill All The Fields Under The Add Users Panel
		 * 
		 * @param username
		 * @param password
		 * @param email
		 * @param role
		 * @param firstName
		 * @param lastName
		 */
		public void enterMandatoryFields(String username, String password, String email, String role, String... firstName) {
			try {
				enterUserName(username);
				enterPassword(password);
				enterEmail(email);
				selectRole(role);
				enterFirstName(firstName[0]);
			} catch (Exception e) {
				// do nothing
			}

		}

		/**
		 * Get Error Message from All Fields
		 * 
		 * @param field_name
		 * @return
		 */
		public String getErroMessage(String field_name) {
			try {
				action.waitForVisibility(driver.findElement(By.xpath("//h6[contains(text(),'" + field_name + "')]/../p")),
						action.implicit_wait);
				return action.getText(driver.findElement(By.xpath("//h6[contains(text(),'" + field_name + "')]/../p")))
						.trim();
			} catch (Exception e) {
				return " ".trim();
			}
		}
}
