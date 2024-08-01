package com.awt.page.Admin.Project.ProjectSettings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awt.page.Admin.ProjectDashboardPageConstants;
import com.awt.testbase.ExtentFactory;
import com.awt.utills.exceptions.Date_Format_Exception;
import com.awt.utills.reusablecomponents.ActionEngine;
import com.awt.utills.reusablecomponents.AwtUtilities;

import jdk.internal.org.jline.utils.Log;

public class NewProjectDetailsPanel {

	// **New Project Details Panel xpath**/
	@FindAll({ @FindBy(xpath = "//div[text()='New Project Details']") })
	private WebElement new_project_details;

	// **New Project Details Panel xpath**/
	@FindAll({ @FindBy(xpath = "//ul[@role='listbox']/li/div/following-sibling::span/div/span") })
	private List<WebElement> module_name_list;

	// **Project Name text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='project_name']") })
	private WebElement project_name_txt;

	// **client Name text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='client_name']") })
	private WebElement client_name_txt;

	// **client Logo File Upload Xpath**/
	@FindAll({ @FindBy(xpath = "//input[@type='file' and @name='client_logo']") })
	private WebElement client_logo;
	// **consultant logo File Upload Xpath**/
	@FindAll({ @FindBy(xpath = "//input[contains(@id,'consultant_logo')]") })
	private WebElement consultant_logo;

	// **consultant Name text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='consultant_name']") })
	private WebElement consultant_name_txt;

	// **license key text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='license_key']") })
	private WebElement license_key_txt;

	// **username text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='user_name']") })
	private WebElement username_txt;

	// **password text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='password']") })
	private WebElement password_txt;

	// **To Get Selected Module Name**/
	@FindAll({ @FindBy(xpath = "//div[@data-pc-section='labelcontainer']/div/div/span") })
	private List<WebElement> getSelectedModuleName;

	// **mobile number text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='mobile_number']") })
	private WebElement mobile_number_txt;

	// **email address text field xpath**/
	@FindAll({ @FindBy(xpath = "//input[@id='email_address']") })
	private WebElement email_add_txt;

	// **Module Name Button xpath**/
	@FindAll({ @FindBy(xpath = "//div[text()='Select Modules']") })
	private WebElement module_name;

	// **In calendar month title xpath**/
	@FindAll({ @FindBy(xpath = "//button[@data-pc-section='monthtitle']") })
	private WebElement month_title;

	// **In calendar year title xpath**/
	@FindAll({ @FindBy(xpath = "//button[@data-pc-section='yeartitle']") })
	private WebElement year_title;

	// **In calendar next button xpath**/
	@FindAll({ @FindBy(xpath = "//button[@data-pc-section='nextbutton']") })
	private WebElement next_button;

	// **In calendar previous button xpath**/
	@FindAll({ @FindBy(xpath = "//button[@data-pc-section='previousbutton']") })
	private WebElement previous_button;

	// **Add Project button xpath**/
	@FindAll({ @FindBy(xpath = "//span[text()='Add Project']") })
	private WebElement add_project_button;

	// **Close Project button xpath**/
	@FindAll({ @FindBy(xpath = "//span[text()='Cancel']") })
	private WebElement cancel_project_button;

	// **Get Error Message xpath**/
	@FindAll({ @FindBy(xpath = "//div[text()='Warning']/following-sibling::div") })
	private WebElement error_message;

	/** xpath of Project Created Sucessfully pop-up *****/
	@FindAll({ @FindBy(xpath = "//button[@aria-label='Yes']") })
	private WebElement accept_popup;

	// **New Project Details Panel xpath**/
	@FindAll({
			@FindBy(xpath = "//div[@role='dialog']/child::div/following-sibling::div[text()='Success']/following-sibling::div") })
	private List<WebElement> success_message;

	// ** xpath of all fields which are available new Projected details Panel**/
	@FindAll({ @FindBy(xpath = "//div[contains(@class,'formgrid')]/div/label") })
	private List<WebElement> newProjectDetais_fields;

	// ** Panel Name X Path *****//
	@FindAll({ @FindBy(xpath = "//div[@data-pc-section='headertitle']") })
	private WebElement panel_name;
	// ** Action Engine instance variable **//
	private ActionEngine action;

	// **WebDriver instance variable **//
	private WebDriver driver;

	/**
	 * constructor for initializing page objects
	 * 
	 * @author Ankit Yadav
	 */
	public NewProjectDetailsPanel(WebDriver driver) {
		this.driver = driver;
		// ActionEngine class objects
		action = new ActionEngine(driver);
		// PageFactory Methods to initialize the Page Web Element
		PageFactory.initElements(driver, this);
	}

	/**
	 * Enter the Project Name
	 * 
	 * @param projectName
	 */

	public void enterProjectName(String projectName) {
		action.implicitWait(project_name_txt, action.implicit_wait);
		// enter the project name
		action.type(project_name_txt, "Project Name", projectName);

	}

	/**
	 * To enter the client name
	 * 
	 * @param clientName
	 */
	public void enterClientName(String clientName) {
		action.implicitWait(client_name_txt, action.implicit_wait);
		// enter the client name
		action.type(client_name_txt, "Client Name", clientName);
	}

	/**
	 * To enter the consultant name
	 * 
	 * @param consultantName
	 */
	public void enterConsultantName(String consultantName) {
		action.implicitWait(consultant_name_txt, action.implicit_wait);
		// enter the consultant name
		action.type(consultant_name_txt, "Consultant Name", consultantName);
	}

	/**
	 * To enter the license key
	 * 
	 * @param licKey
	 */
	public void enterLicenseKey(String licKey) {
		action.implicitWait(license_key_txt, action.implicit_wait);
		// enter the Licenses Key
		action.type(license_key_txt, "License Key", licKey);
	}

	/**
	 * To enter the username
	 * 
	 * @param username
	 */
	public void enterUsername(String username) {
		action.implicitWait(username_txt, action.implicit_wait);
		// enter the User Name
		action.type(username_txt, "Username", username);
	}

	/**
	 * To enter the password
	 * 
	 * @param password
	 */
	public void enterPassword(String password) {
		action.implicitWait(password_txt, action.implicit_wait);
		// enter the Password
		action.type(password_txt, "Password", password);
	}

	/**
	 * To enter the mobile number
	 * 
	 * @param mob
	 */
	public void enterMobileNum(String mob) {
		action.implicitWait(mobile_number_txt, action.implicit_wait);
		/// enter the mobile number
		action.type(mobile_number_txt, "Mobile Number", mob);

	}

	/**
	 * To enter the email address
	 * 
	 * @param emailAdd
	 */
	public void enterEmailAdd(String emailAdd) {
		action.implicitWait(email_add_txt, action.implicit_wait);
		/// enter the mobile number
		action.type(email_add_txt, "Email", emailAdd);
	}

	/**
	 * To upload the logo
	 * 
	 * @param logoName
	 */
	public void uploadLogo(String logoName, String imagePath) {
		switch (logoName) {
		case "Client Logo":
			client_logo.sendKeys(System.getProperty("user.dir") + imagePath);
			break;
		case "Consultant Logo":
			consultant_logo.sendKeys(System.getProperty("user.dir") + imagePath);
			break;
		default:
			System.out.println("Please Enter The Correct Logo Name You Have Entered Wrong Logo :" + logoName);
			break;

		}
	}

	/**
	 * By help of this method we can enter the project details while creating a
	 * project details
	 * 
	 * @param project_name
	 * @param client_name
	 * @param consultant_name
	 * @param license_key
	 * @param username
	 * @param password
	 * @param module_name
	 * @param mob_num
	 * @param email_add
	 * @param start_date
	 * @param expected_date
	 * @param actual_completion_date
	 * @author Ankit Yadav
	 * 
	 */
	public void enterProjectDetails(String project_name, String client_name, String client_image_path,
			String consultant_name, String consultant_image_path, String license_key, String username, String password,
			String mob_num, String email_add, String start_date, String expected_date, String actual_completion_date,
			String[]... module_name) {
		// wait for loading new project details panel
		waitForLoadingNewProjectDetails();
		enterProjectName(project_name);
		enterClientName(client_name);
		uploadLogo(ProjectDashboardPageConstants.clientLogo, client_image_path);
		enterConsultantName(consultant_name);
		uploadLogo(ProjectDashboardPageConstants.consultantLogo, consultant_image_path);
		enterLicenseKey(license_key);
		if (module_name.length == 0) {
			// do nothing
		} else {
			selectModuleName(module_name[0]);
		}
		enterUsername(username);
		enterPassword(password);
		enterMobileNum(mob_num);
		enterEmailAdd(email_add);
		datePicker(ProjectDashboardPageConstants.startDate, start_date);
		datePicker(ProjectDashboardPageConstants.ExpectedDate, expected_date);
		datePicker(ProjectDashboardPageConstants.actualCompletionDate, actual_completion_date);

	}

	/**
	 * This Method Is Specially Design to Select Date From Any Calendar
	 * 
	 * @param exp_date {Syntax : "dd-Mmm-YYYY"}
	 * @exception Date_Format_Exception { Providing a Wrong Syntax }
	 * @author Ankit yadav
	 */
	public void datePicker(String dateType, String req_date) {
		boolean flag = false;
		try {
			// Select date type
			selectDateType(dateType);
			String exp_date = req_date.replaceAll("/", "-");
			if (exp_date.contains("-")) {
				String[] date = exp_date.split("-");
				// *************Expected Date ************/
				String exp_day = date[0].replace("0", " ").trim();
				String exp_month = date[1].substring(0, 3);
				String exp_year = date[2];

				// *************Acutal Date In Calendar***********//
				String act_month = action.getText(month_title).trim();
				String act_year = action.getText(year_title).trim();

				boolean isSameYear = false;
				boolean isSameMonth = false;

				// if expected year greater than actual year
				if (Integer.parseInt(exp_year) > Integer.parseInt(act_year)) {
					// click on forward for reach a correct year
					while (true) {
						action.implicitWait(next_button, 5);
						act_year = year_title.getText().trim();
						next_button.click();
						if (Integer.parseInt(exp_year) == Integer.parseInt(act_year)) {
							isSameYear = true;
							break;
						}
					}
					// after getting a same year we have to select month
					if (isSameYear) {
						// if the expected month is same as by default visible month then we can
						// directly select the date
						act_month = month_title.getText().trim();
						if (act_month.contains(exp_month)) {

							action.clickOn(driver.findElement(By.xpath("//td[@data-pc-section='day']/span[text()='"
									+ exp_day + "' and not(@class='p-disabled')]")));
						}
						// if the expected month is not same as by default visible month then we have to
						// select expected month
						// then we have to select the date
						else if (!act_month.contains(exp_month)) {
							action.clickOn(month_title);
							action.clickOn(driver.findElement(By
									.xpath("//div[@data-pc-section='monthpicker']/span[text()='" + exp_month + "']")));
							action.clickOn(driver.findElement(By.xpath("//td[@data-pc-section='day']/span[text()='"
									+ exp_day + "' and not(@class='p-disabled')]")));
						}
					}

					// if expected year less than actual year
				} else if (Integer.parseInt(exp_year) < Integer.parseInt(act_year)) {
					// click on backward button untill you will reach In correct year
					while (true) {
						action.implicitWait(previous_button, 5);
						previous_button.click();
						act_year = year_title.getText().trim();
						if (Integer.parseInt(exp_year) == Integer.parseInt(act_year)) {
							isSameYear = true;
							break;
						}
					}
					// after getting a same year we have to select month
					if (isSameYear) {
						// if the expected month is same in calendar by defult visible month then we can
						// directly select the date
						act_month = month_title.getText().trim();
						if (act_month.contains(exp_month)) {
							action.clickOn(driver.findElement(By.xpath("//td[@data-pc-section='day']/span[text()='"
									+ exp_day + "' and not(@class='p-disabled')]")));
						}
						// if the expected month is not same in calendar by default month then we have
						// to select expected month
						// then we have to select the date
						else if (!act_month.contains(exp_month)) {
							action.clickOn(month_title);
							action.clickOn(driver.findElement(By
									.xpath("//div[@data-pc-section='monthpicker']/span[text()='" + exp_month + "']")));
							action.clickOn(driver.findElement(By.xpath("//td[@data-pc-section='day']/span[text()='"
									+ exp_day + "' and not(@class='p-disabled')]")));
						}
					}
					// if the expected year is equal to by default visible year in the calendar then
					// we can directly select a month
				} else if (Integer.parseInt(exp_year) == Integer.parseInt(act_year)) {
					// if the expected month is equal to by default visible month so we can directly
					// chose the date
					act_month = month_title.getText().trim();
					if (act_month.contains(exp_month)) {
						action.clickOn(driver.findElement(By.xpath("//td[@data-pc-section='day']/span[text()='"
								+ exp_day + "' and not(@class='p-disabled')]")));
					}
					// it it expected month is not equal to the by default month in calendar so
					// first we have to click on the correct month then after we have to select date
					else if (!act_month.contains(exp_month)) {
						action.clickOn(month_title);
						action.clickOn(driver.findElement(
								By.xpath("//div[@data-pc-section='monthpicker']/span[text()='" + exp_month + "']")));
						action.clickOn(driver.findElement(By.xpath("//td[@data-pc-section='day']/span[text()='"
								+ exp_day + "' and not(@class='p-disabled')]")));
					}
				}
			} else {
				throw new Date_Format_Exception("Please Pass The Correct Date Format Correct Syntax Is : DD-Mmm-YYYY ");
			}
		} catch (Exception e) {
			ExtentFactory.extentObject().getExtent().info("Failed To Select The Date");
		}

	}

	/**
	 * Method is Used to Select A Module if you pass "All" so it should all modules
	 * 
	 * @param module_name
	 */
	public void selectModuleName(String[] module_name) {
		// wait for some time
		action.implictWait(action.implicit_wait);
		action.clickOn(driver.findElement(By.xpath("//div[@data-pc-section='label']")));
		String moduleName = null;
		for (String Module_name : module_name) {
			if (!Module_name.equalsIgnoreCase("All")) {
				for (int i = 0; i < module_name_list.size(); i++) {
					action.waitForVisibility(module_name_list.get(i), action.implicit_wait);
					moduleName = module_name_list.get(i).getText().trim();
					if (Module_name.equalsIgnoreCase(moduleName)) {
						action.waitForVisibility(
								driver.findElement(By.xpath(
										"//span[text()='" + moduleName + "']/parent::div/../preceding-sibling::div")),
								action.implicit_wait);
						driver.findElement(
								By.xpath("//span[text()='" + moduleName + "']/parent::div/../preceding-sibling::div"))
								.click();

					}
				}
			} else if (Module_name.equalsIgnoreCase("All")) {
				// clear the Module Name Search Box
				driver.findElement(By.xpath("//input[@role='textbox' and @data-pc-name='inputtext']")).clear();
				// Select All Module Name
				action.clickOn(driver.findElement(
						By.xpath("//input[@type='checkbox']/../following-sibling::div[@data-pc-section='input']")));
			}
		}

	}

	/**
	 * Method is Used to de-select the module and if you pass "All" so it should
	 * de-select all selected modules
	 * 
	 * @param module_name {OMS,AMS}
	 */

	public void deSelectModuleName(String[] module_name) {
		// wait for some time
		action.implictWait(action.implicit_wait);
		action.clickOn(username_txt);
		String moduleName = null;
		if (!module_name[0].equalsIgnoreCase("All")) {
			for (String ModuleName : module_name) {
				action.clickOn(driver.findElement(By.xpath("//div[@data-pc-section='label']/div/span[text()='"
						+ ModuleName + "']/..//*[local-name()='svg']")));
				AwtUtilities.waitFor(1000);

			}
		} else if (module_name[0].equalsIgnoreCase("All")) {
			action.implictWait(action.implicit_wait);
			List<WebElement> selected_module = driver
					.findElements(By.xpath("//div[@data-pc-section='label']/div//*[local-name()='svg']"));
			action.waitForVisibility(selected_module.get(selected_module.size() - 1), action.implicit_wait);
			for (WebElement element : selected_module) {
				action.clickOn(element);
				AwtUtilities.waitFor(1000);
			}
		}

	}

	/**
	 * TO get the name of selected module in Module Name Drop-Down Button
	 * 
	 */
	public List<String> getAllSelectedModule() {
		List<String> selectedModule = new ArrayList<String>();
		for (WebElement element : getSelectedModuleName) {
			action.waitForVisibility(element, action.implicit_wait);
			selectedModule.add(element.getText().trim());
		}
		return selectedModule;

	}

	/**
	 * Help to Select Date Type Like Start Date, Expected Date, Actual Completion
	 * Date
	 * 
	 * @param dateType {Start Date ,Expected Date , Actual Completion Date }
	 */
	public void selectDateType(String dateType) {
		action.implicitWait(driver.findElement(By.xpath("//span[@id='" + dateType.trim() + "']/button")),
				action.implicit_wait);
		action.performMoveToElement(driver.findElement(By.xpath("//span[@id='" + dateType.trim() + "']/button")));
		action.clickOn(driver.findElement(By.xpath("//span[@id='" + dateType.trim() + "']/button")));
	}

	/**
	 * To click on AddProject button
	 */
	public void clickAddProject() {
		action.implicitWait(add_project_button, action.implicit_wait);
		action.clickOn(add_project_button, "Add Project");

	}

	/**
	 * To click on Close Project Button
	 */

	public void clickOnCancelProject() {
		action.implicitWait(cancel_project_button, action.implicit_wait);
		action.clickOn(cancel_project_button, "Close Project");
	}

	/**
	 * Wait For loading New Project Details Panel
	 */
	public void waitForLoadingNewProjectDetails() {
		action.waitForVisibility(new_project_details, action.implicit_wait);
	}

	/**
	 * To accept pop up
	 */
	public void acceptPopup() {
		action.waitForVisibility(accept_popup, action.implicit_wait);
		action.clickOn(accept_popup);
	}

	/**
	 * This methods return all the text field which are available in the "new
	 * project Details Panel"
	 * 
	 * @return List<String> { name of all the text fields}
	 */
	public List<String> getNewProjectDetailsPanelFiledsName() {
		action.implicitWait(newProjectDetais_fields.get(newProjectDetais_fields.size() - 1), action.implicit_wait);
		List<String> text_field_name = new ArrayList<String>();
		for (WebElement field_name : newProjectDetais_fields) {
			text_field_name.add(field_name.getText().trim());
		}
		return text_field_name;
	}

	/**
	 * This method helps we can get the panel name
	 * 
	 * @return { panel name}
	 */
	public String getPanelName() {
		action.implicitWait(panel_name, action.implicit_wait);
		return action.getText(panel_name);
	}

	/**
	 * By Help of this method we can get all text field value which are present
	 * under the new project details panel
	 * 
	 * @param field_name
	 * @return
	 */
	public String getNewProjectDetailsPanelsTextFieldValue(String field_name) {

		switch (field_name.trim()) {
		case "Project Name":
			return action.getAttributeValue(project_name_txt, "value").trim();
		case "Client Name":
			return action.getAttributeValue(client_name_txt, "value").trim();
		case "Consultant Name":
			return action.getAttributeValue(consultant_name_txt, "value").trim();
		case "License Key":
			return action.getAttributeValue(license_key_txt, "value").trim();
		case "User Name":
			return action.getAttributeValue(username_txt, "value").trim();
		case "Password":
			return action.getAttributeValue(password_txt, "value").trim();
		case "Mobile Number":
			return action.getAttributeValue(mobile_number_txt, "value").trim();
		case "Email Address":
			return action.getAttributeValue(email_add_txt, "value").trim();
		default:
			return null;

		}
	}

	/**
	 * To check cancel button visibility
	 * 
	 * @return boolean
	 */
	public boolean isCancelButtonIsVisible() {
		action.waitForVisibility(cancel_project_button, action.implicit_wait);
		return action.isDisplay(cancel_project_button);

	}

	/**
	 * To cehck the add Project Button visibility
	 * 
	 * @return
	 */
	public boolean isAddProjectButtonIsVisible() {
		action.waitForVisibility(add_project_button, action.implicit_wait);
		return action.isDisplay(add_project_button);
	}

	/**
	 * By Help Of The Method We Can Get Any Text Field Error Message
	 */
	public String getErrorMessage(String text_field_name) {

		action.performMoveToElement(driver.findElement(
				By.xpath("//label[contains(text(),'" + text_field_name + "')]/./following-sibling::small")));
		return action.getText(driver.findElement(
				By.xpath("//label[contains(text(),'" + text_field_name + "')]/./following-sibling::small")));

	}

	/**
	 * By This Method Accrording To Field We Can Check Error Message if it's visible
	 * it should be return true other wise false
	 * 
	 * @param text_field_name
	 * @return
	 */

	public boolean isErrorMessageVisible(String text_field_name) {
		boolean flag = false;
		try {
			getErrorMessage(text_field_name);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
