package com.awt.page.User.AdminConfiguration.Settings.Page_Permission;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.awt.page.User.AdminConfiguration.AdminPage;

public class AdminMenuPermissionPage extends AdminPage {

	// ******Role Drop Down ********/
	@FindAll({ @FindBy(xpath = "//div[@id='role']//*[local-name()='svg']") })
	public WebElement role_dropdown;

	// ******Module Drop Down ********/
	@FindAll({ @FindBy(xpath = "//div[@id='module']//*[local-name()='svg']") })
	public WebElement module_dropdown;

	// ******List Of Role Name ********/
	@FindAll({ @FindBy(xpath = "//ul[@role='listbox']/li") })
	public List<WebElement> role_name_list;

	// ******List Of Module Name ********/
	@FindAll({ @FindBy(xpath = "//ul[@role='listbox']/li") })
	public List<WebElement> module_name_list;

	// ******Find Button ********/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Find']") })
	public WebElement find_button;

	// ******List Of Main Menus ********/
	@FindAll({ @FindBy(xpath = "//table[@role='table']//tbody/tr/td/following-sibling::td") })
	public List<WebElement> main_menus_list;

	// ******Find Button ********/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Save']") })
	public WebElement save_button;

	// ** Constructor**/
	public AdminMenuPermissionPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * By This Method We Can Check Page Permission button is visible or not
	 * 
	 * @return if it's visible then its return true and if its not visible then it's
	 *         return false
	 */
	public boolean isPagePermissionButtonVisible() {
		return flag;
	}

	/**
	 * By This Method We Can Check "Select Role" Drop Down Is Visible
	 * 
	 * @return
	 */
	public boolean isSelectRoleDropDownVisible() {
		action.waitForVisibility(role_dropdown, action.implicit_wait);
		return action.isDisplay(role_dropdown);
	}

	/**
	 * By This Method We Can Check "Select Module" Drop Down Is Visible
	 * 
	 * @return
	 */
	public boolean isSelectModuleDropDownVisible() {
		action.waitForVisibility(module_dropdown, action.implicit_wait);
		return action.isDisplay(module_dropdown);
	}

	/**
	 * By This Method We Can Check "Save" button is visible
	 * 
	 * @return
	 */
	public boolean isSaveButtonVisible() {
		action.waitForVisibility(save_button, action.implicit_wait);
		return action.isDisplay(save_button);
	}

	/**
	 * With Help Of This Method We Can Get The Selected Role Name From Role Drop
	 * Down
	 * 
	 * @return role name; {if Any Selected Role Name Is Present Then It's Return
	 *         True OtherWise It Return Empty String
	 */
	public String getSelectedRole() {
		String role_name = "";
		try {
			action.waitForVisibility(driver.findElement(By.xpath("//div[@id='role']//span")), action.implicit_wait);
			role_name = action.getText(driver.findElement(By.xpath("//div[@id='role']//span")));
		} catch (Exception e) {
			role_name = "";
		}
		return role_name;
	}

	/**
	 * With Help Of This Method We Can Get The Selected Module Name From Module Drop
	 * Down
	 * 
	 * @return role name; {if Any Selected Module Name Is Present Then It's Return
	 *         True OtherWise It Return Empty String
	 */
	public String getSelectedModule() {
		String role_name = "";
		try {
			action.waitForVisibility(driver.findElement(By.xpath("//div[@id='module']//span")), action.implicit_wait);
			role_name = action.getText(driver.findElement(By.xpath("//div[@id='module']//span")));
		} catch (Exception e) {
			role_name = "";
		}
		return role_name;
	}

	/**
	 * By This Method We Can Check Under The Role Drop Down Passed Role Name is
	 * Visible or not
	 * 
	 * @param role_name
	 * @return if Passed role name is present then it's return true otherwise it
	 *         will return false
	 */
	public boolean isRolePresent(String role_name) {
		boolean flag = false;
		for (int i = 0; i < role_name_list.size(); i++) {
			action.waitForVisibility(role_name_list.get(i), action.implicit_wait);
			if (role_name_list.get(i).getText().trim().equals(role_name)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * By This Method We Can Check Under The Module Drop Down Passed module Name is
	 * Visible or not
	 * 
	 * @param role_name
	 * @return if passed module name is present then it's return true otherwise it
	 *         will return false
	 */
	public boolean isModuleNamePresent(String[] module_name) {
		boolean flag = false;
		int expCount = module_name.length;
		int actCount = 0;
		for (int j = 0; j < module_name.length; j++) {
			for (int i = 0; i < module_name_list.size(); i++) {
				action.waitForVisibility(module_name_list.get(i), action.implicit_wait);
				if (module_name_list.get(i).getText().trim().equals(module_name[j])) {
					actCount++;
					break;
				}
			}
		}
		if (expCount == actCount) {
			flag = true;
		}
		return flag;
	}

	/**
	 * By this method we can check the main menus
	 * 
	 * @param expMainMenus {Passed The Correct Main Menus Name
	 * @return{if expected menus is present then it's return true otherwise it
	 *            returns false}
	 */
	public boolean isMainMenuPresent(String expMainMenus) {

		boolean flag = false;
		for (int i = 0; i < main_menus_list.size(); i++) {
			if (main_menus_list.get(i).getText().trim().equals(expMainMenus)) {
				flag = true;
				break;
			}
		}
		return flag;

	}

	/**
	 * By This Method We Can Click On Find Button
	 */
	public void clickOnFindButton() {
		action.waitForVisibility(find_button, action.implicit_wait);
		action.clickOn(find_button);
	}

	/**
	 * By This Method We Can Click On Save Button
	 */
	public void clickOnSaveButton() {
		action.waitForVisibility(save_button, action.implicit_wait);
		action.clickOn(save_button);
	}

	/**
	 * By this method we can click on any permission page drop down
	 * 
	 * @param dropdown_name
	 * @implNote Please Pass The Exact Drop Down Name Which Is Written Id Tag
	 */
	public void clickAnyMenuPermissionPageDropDown(String dropdown_name) {

		action.waitForVisibility(
				driver.findElement(By.xpath("//div[@id='" + dropdown_name + "']//*[local-name()='svg']")),
				action.implicit_wait);
		action.clickOn(driver.findElement(By.xpath("//div[@id='" + dropdown_name + "']//*[local-name()='svg']")));
	}

	/**
	 * With help of this method we can select a role
	 * 
	 * @param role_name please passed the correct role name
	 * 
	 */
	public void selectRole(String role_name) {
		action.waitForVisibility(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + role_name + "']")),
				action.implicit_wait);
		action.performMoveToElement(
				driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + role_name + "']")));
		action.clickOn(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + role_name + "']")));
	}

	/**
	 * With help of this method we can select module name
	 * 
	 * @param module_name please passed the correct module name
	 */
	public void selectModule(String module_name) {
		action.waitForVisibility(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + module_name + "']")),
				action.implicit_wait);
		action.performMoveToElement(
				driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + module_name + "']")));
		action.clickOn(driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + module_name + "']")));
	}

	/**
	 * With help of this method we can click on any check box in "Menu Permission"
	 * page
	 * 
	 * @param main_menu_name { Main Menu Name should be match to Web Page main menu
	 *                       name}
	 * @param sub_menu_name  {sub menu name should be match to Web Page sub menu
	 *                       name }
	 * @param check_box_name {check box name should be match to Web Page check box
	 *                       name }
	 */

	public void selectAnyCheckBox(String main_menu_name, String sub_menu_name, String check_box_name) {
		try {
			action.waitForVisibility(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='"
					+ main_menu_name + "']/preceding-sibling::td/button//*[local-name()='svg']")),
					action.implicit_wait);
			action.clickOn(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='" + main_menu_name
					+ "']/preceding-sibling::td/button//*[local-name()='svg']")));
			action.waitForVisibility(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='"
					+ main_menu_name + "']/../following-sibling::tr[1]/td//table//td[text()='" + sub_menu_name
					+ "']/following-sibling::td[1]//div[@data-pc-section='input']")), action.implicit_wait);
			if (!action.getAttributeValue(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='"
					+ main_menu_name + "']/../following-sibling::tr[1]/td//table//td[text()='" + sub_menu_name
					+ "']/following-sibling::td[" + getCheckBoxIndexNumber(check_box_name)
					+ "]//div[@data-pc-name='checkbox']")), "class").trim().contains("checked")) {
				action.clickOn(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='" + main_menu_name
						+ "']/../following-sibling::tr[1]/td//table//td[text()='" + sub_menu_name
						+ "']/following-sibling::td[" + getCheckBoxIndexNumber(check_box_name)
						+ "]//div[@data-pc-section='input']")));
			}
		} catch (Exception e) {
			action.waitForVisibility(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='"
					+ main_menu_name + "']/preceding-sibling::td/button//*[local-name()='svg']")),
					action.implicit_wait);
			action.clickOn(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='" + main_menu_name
					+ "']/preceding-sibling::td/button//*[local-name()='svg']")));
			action.waitForVisibility(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='"
					+ main_menu_name + "']/../following-sibling::tr[1]/td//table//td[text()='" + sub_menu_name
					+ "']/following-sibling::td[1]//div[@data-pc-section='input']")), action.implicit_wait);
			if (!action.getAttributeValue(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='"
					+ main_menu_name + "']/../following-sibling::tr[1]/td//table//td[text()='" + sub_menu_name
					+ "']/following-sibling::td[" + getCheckBoxIndexNumber(check_box_name)
					+ "]//div[@data-pc-name='checkbox']")), "class").trim().contains("checked")) {
				action.clickOn(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='" + main_menu_name
						+ "']/../following-sibling::tr[1]/td//table//td[text()='" + sub_menu_name
						+ "']/following-sibling::td[" + getCheckBoxIndexNumber(check_box_name)
						+ "]//div[@data-pc-section='input']")));
			}
		}
	}

	/**
	 * By this method we can deselect the sub menu check box
	 * 
	 * @param main_menu_name
	 * @param sub_menu_name
	 * @param check_box_name
	 */
	public void deSelectAnyCheckBox(String main_menu_name, String sub_menu_name, String check_box_name) {
		if (action.getAttributeValue(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='"
				+ main_menu_name + "']/../following-sibling::tr[1]/td//table//td[text()='" + sub_menu_name
				+ "']/following-sibling::td[" + getCheckBoxIndexNumber(check_box_name)
				+ "]//div[@data-pc-name='checkbox']")), "class").trim().contains("checked")) {
			action.clickOn(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='" + main_menu_name
					+ "']/../following-sibling::tr[1]/td//table//td[text()='" + sub_menu_name
					+ "']/following-sibling::td[" + getCheckBoxIndexNumber(check_box_name)
					+ "]//div[@data-pc-section='input']")));
		}
	}

	/**
	 * With Help Of This Method We Can Get Check box index number
	 * 
	 * @param check_box_name {Passed Correct Check Box Name"
	 * @return check box index number
	 */
	public Integer getCheckBoxIndexNumber(String check_box_name) {
		LinkedHashMap<String, Integer> checkBoxIndexNum = new LinkedHashMap<String, Integer>();
		checkBoxIndexNum.put("View Data", 1);
		checkBoxIndexNum.put("Alter Data", 2);
		checkBoxIndexNum.put("Delete Data", 3);

		return checkBoxIndexNum.get(check_box_name);
	}

	/**
	 * Help Of This Method We Can Check Check Box Is Selected In Menu Permission
	 * 
	 * @param main_menu_name
	 * @param sub_menu_name
	 * @param checkbox_name
	 * @return {if it's checked then it return true otherwise it returns false
	 */
	public boolean isSubMenuCheckBoxSelected(String main_menu_name, String sub_menu_name, String checkbox_name) {
		boolean flag = false;
		action.waitForVisibility(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='"
				+ main_menu_name + "']/preceding-sibling::td/button//*[local-name()='svg']")), action.implicit_wait);
		action.clickOn(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='" + main_menu_name
				+ "']/preceding-sibling::td/button//*[local-name()='svg']")));
		action.waitForVisibility(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='"
				+ main_menu_name + "']/../following-sibling::tr[1]/td//table//td[text()='" + sub_menu_name
				+ "']/following-sibling::td[1]//div[@data-pc-section='input']")), action.implicit_wait);
		return action.getAttributeValue(driver.findElement(By.xpath("//table[@role='table']/tbody//td[text()='"
				+ main_menu_name + "']/../following-sibling::tr[1]/td//table//td[text()='" + sub_menu_name
				+ "']/following-sibling::td[" + getCheckBoxIndexNumber(checkbox_name)
				+ "]//div[@data-pc-name='checkbox']")), "class").trim().contains("checked");
	}
}
