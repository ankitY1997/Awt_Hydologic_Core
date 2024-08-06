package com.awt.test.Admin.Project.ProjectSettings;

import java.util.ArrayList;
import java.util.Arrays;

import org.bouncycastle.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.awt.constant.Admin.ProjectDashboardPageContants;
import com.awt.constant.Admin.ProjectDashboardPageConstants;
import com.awt.constant.Admin.Project.ProjectSettings.AdminCreateProjectPageConstants;
import com.awt.constant.Admin.Project.ProjectSettings.NewProjectDetailsPanelConstants;
import com.awt.constant.Login.LoginPageConstants;
import com.awt.page.Admin.ProjectDashboardPage;
import com.awt.page.Admin.Project.ProjectSettings.AdminCreateProjectPage;
import com.awt.page.Admin.Project.ProjectSettings.NewProjectDetailsPanel;
import com.awt.page.Login.LoginPage;
import com.awt.testbase.BaseTest;
import com.awt.testbase.DriverFactory;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.AwtUtilities;
import com.awt.utills.reusablecomponents.Description;
import com.awt.utills.reusablecomponents.ExcelOperations;
import com.awt.utills.reusablecomponents.Owner;
import com.awt.utills.reusablecomponents.PropertiesOperations;
import com.awt.utills.reusablecomponents.SoftAssertTest;
import com.awt.utills.reusablecomponents.Story;
import com.awt.utills.reusablecomponents.TestCaseId;
import com.awt.utills.reusablecomponents.Version;
import com.awt.utills.reusablecomponents.WorkArea;

public class AdminCreatePageTest extends BaseTest {

	public static final String url = PropertiesOperations.getPropertyValueByKey("ADMINURL");
	ProjectDashboardPage admin_page = null;
	AdminCreateProjectPage admin_create_page = null;
	SoftAssertTest asert = null;
	NewProjectDetailsPanel newProject_DetailsPanel = null;
	public String projectName = null;;

	/**
	 * 
	 * Navigate To New Project Details Panel
	 * 
	 */
	public void navigateToNewProjectDetailsPanel() {
		// SoftAssert instance
		asert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// log in Page instance
		LoginPage lp = new LoginPage(DriverFactory.iuiDriver().getDriver());
		// Enter the Project Name and login and navigate to the home page
		admin_page = lp.loginAndProjectDashboardPage(url, LoginPageConstants.project_name);
		// verify Home Page Title
		asert.assertEquals(admin_page.getHomePageTitle(), ProjectDashboardPageConstants.expected_home_page_title,
				"verify Home Page Title Should Be Display Correct", "APMS-T0");
		// click on project management drop-down menu and Select "Create Project" menu
		admin_create_page = admin_page.clickCreateProjectButtonAndNavigateToAdminCreateProjectPage(
				ProjectDashboardPageContants.project, ProjectDashboardPageContants.project_setting);
		// verify "Create Project" button is display
		asert.assertEquals(admin_create_page.isCreateProjectButtonDispaly(), true,
				"Verify that the Create Project button is visible", "APMS-T1");
		// * Click on Create Project Button --> Navigate to "New Project Details Panel
		newProject_DetailsPanel = admin_create_page.clickCreateProjectButtonAndNavigateToNewProjectDetailPanel();
	}

	/**
	 * Description: Perform the verification on new Project Details Panels
	 * Fields<br>
	 * TestMethodName: verify_NewProjectDetailsPanel <br>
	 * ManualTestCases: "APMS-T1", "APMS-T2", "APMS-T4", "APMS-T6", "APMS-T7",
	 * "APMS-T8", "APMS-T9", "APMS-T10", "APMS-T13", "APMS-T14", "APMS-T19",
	 * "APMS-T28",
	 * "APMS-T29","APMS-30","APMS-31","APMS-T32","APMS-T33","APMS-T34","APMS-T35","APMS-T37","APMS-T38","APMS-T39","APMS-T45","APMS-46","APMS-T47",APMS-T48",
	 * "APMS-T50"<br>
	 * 
	 * @author ankit
	 */

	@Version(number = "V-0.1")
	@Test(groups = { "Admin", "Functional" })
	@Description(description = "Perform the verfication on  New Project Details Panel")
	@Story(story = "Create Project Details Panel")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestCaseId(id = { "APMS-T1", "APMS-T2", "APMS-T4", "APMS-T6", "APMS-T7", "APMS-T8", "APMS-T9", "APMS-T10",
			"APMS-T13", "APMS-T14", "APMS-T19", "APMS-T28", "APMS-T29", "APMS-30", "APMS-31", "APMS-T32", "APMS-T33",
			"APMS-T34", "APMS-T35", "APMS-T37", "APMS-T38", "APMS-T39", "APMS-T45", "APMS-46", "APMS-T47", "APMS-T48",
			"APMS-T50" })
	public void verify_NewProjectDetailsPanel() {
		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// Navigate To New Project Details Panel
		navigateToNewProjectDetailsPanel();
		// APMS-T2-> Verify That New Project Details Panel Should Be Visible -->
		// Expected Panel Name
		String exp_panel_name = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.panel_Name, "APMS-T2");
		// Verify that new Project Details Panel Should be visible
		asert.assertEquals(newProject_DetailsPanel.getPanelName(), exp_panel_name,
				"Verify That New Project Details Panel Should Be Visible", "APMS-T2");
		// Validate The Text Fields Of New Project Details Panel
		verifyTextField();
		// Verify the panels for adding a new project and ensure that the entered data
		// is correctly displayed in the table
		verifyAddFunctionality();
		// verify Awt Tables
		verifyAwtProjectTable();
		// verify edit button functionality
		verifyEditFunctionality();

		asert.assertAll();

	}

	/**
	 * Validate The Text Fields Of New Project Details Panel
	 */
	public void verifyTextField() {
		// Verify Fields In "New Project Details Panel"
		asert.assertEquals(newProject_DetailsPanel.getNewProjectDetailsPanelFiledsName(),
				NewProjectDetailsPanelConstants.list_field, "Verify Fields In New Project Details Panel", "APMS-T3");
		// AMPS-T4-> Verify that project name text field accept the project name with a
		// hyphen and number-->
		// Enter The Project Name
		String Project_Name = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_project_name, "APMS-T4");
		newProject_DetailsPanel.enterProjectName(Project_Name);
		asert.assertEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.xl_project_name),
				Project_Name, " Verify that project name text field accept the project name with a hyphen and number",
				"APMS-T4");
		// APMS-T6 ->Verify that a "project name" text field should accept only the
		// hyphen, alphabets and numbers-->

		// Enter In Valid Project Name
		String InValid_Project_Name = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_project_name, "APMS-T6");
		newProject_DetailsPanel.enterProjectName(InValid_Project_Name);
		asert.assertNotEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.xl_project_name),
				InValid_Project_Name,
				"Verify that a project name text field  should accept only the  hyphen, alphabets and numbers",
				"APMS-T6");

		// APMS-T7->Verify that project name should not exceed more than100 characters
		// -->
		// Enter the Project Name More Than 100 character
		String project_name = AwtUtilities.genrateRandomAlphaNeumric(101);
		newProject_DetailsPanel.enterProjectName(project_name);
		asert.assertNotEquals(
				newProject_DetailsPanel
						.getNewProjectDetailsPanelsTextFieldValue(NewProjectDetailsPanelConstants.xl_project_name),
				project_name, "Verify that project name should not exceed more than100 characters ", "APMS-T7");

		// APMS- T8 -->Verify that a "Client Name" text field should accept only the
		// alphabets and spaces.
		String valid_clientName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_client_name, "APMS-T8");
		// enter the valid client name-->
		newProject_DetailsPanel.enterClientName(valid_clientName);
		asert.assertEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.xl_client_name),
				valid_clientName, "Verify that a Client Name text field should accept only the alphabets and spaces.",
				"APMS-T8");
		// APMS-T9-->Verify that "client name" text field should not accept any
		// special character except space and any number
		String inValidClientName = AwtUtilities.genrateRandomAlphaNeumric(5) + "#$";
		newProject_DetailsPanel.enterClientName(inValidClientName);
		asert.assertNotEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.xl_client_name),
				inValidClientName,
				"Verify that client name text field should not accept any special character except space and any number",
				"APMS-T9");
		// APMS-T10 --> Verify that "client name" text field should not exceed more than
		// 30 characters.
		String client_name = AwtUtilities.genrateRandomString(35);
		// enter the more than 30 digit client name
		newProject_DetailsPanel.enterClientName(client_name);
		asert.assertNotEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.xl_client_name),
				client_name,
				"Verify that client name text field should not accept any character accept space and any number",
				"APMS-T10");

		// APMS-T11-->To verify that "client logo" button should accept only the JPEG OR
		// PNG formats
		// enter valid file
		String validClientFile = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_client_image_path, "APMS-T11");
		newProject_DetailsPanel.uploadLogo(NewProjectDetailsPanelConstants.panel_client_logo, validClientFile);
		asert.assertFalse(
				newProject_DetailsPanel.isErrorMessageVisible(NewProjectDetailsPanelConstants.panel_client_logo),
				"To verify that client logo button should accept only the JPEG OR PNG", "APMS-T11");

		// APMS-12 ->To verify that "client logo" button should not support other than
		// Jpeg or png format
		// Enter The Invalid File
		String invalidClientFile = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_file_path, "APMS-T12");
		newProject_DetailsPanel.uploadLogo(NewProjectDetailsPanelConstants.panel_client_logo, invalidClientFile);
		asert.assertEquals(newProject_DetailsPanel.getErrorMessage(NewProjectDetailsPanelConstants.panel_client_logo),
				NewProjectDetailsPanelConstants.consultant_logo_error_msg,
				"To verify that client logo button should not support other than Jpeg or png format", "APMS-T12");

		// APMS-T13 --> To Verify that a "consultant name" text field should accept only
		// the alphabets and spaces
		String valid_consultantName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_consultant_name, "APMS-T13");
		// enter the valid consultant Name
		newProject_DetailsPanel.enterConsultantName(valid_consultantName);
		asert.assertEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.xl_consultant_name),
				valid_consultantName,
				"To Verify that a consultant name text field should accept only the alphabets and spaces", "APMS-T13");
		// APMS-T14-->Verify that "consultant name" text field should not accept any
		// special character except space and any number
		String inValidConsultantName = AwtUtilities.genrateRandomAlphaNeumric(5) + "12";
		// enter in valid client name
		newProject_DetailsPanel.enterConsultantName(inValidConsultantName);
		asert.assertNotEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.xl_consultant_name),
				inValidConsultantName,
				"Verify that consultant name text field should not accept any special character except space and any number",
				"APMS-T14");

		// APMS-T19 --> Verify that "Consultant Name" text field should not exceed more
		// than
		// 30 characters.
		String consultant_name = AwtUtilities.genrateRandomString(35);
		// enter the more than 30 digit client name
		newProject_DetailsPanel.enterConsultantName(consultant_name);
		asert.assertNotEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.xl_consultant_name),
				consultant_name, "Verify that Consultant Name text field should not exceed more than 30 character",
				"APMS-T19");

		// APMS-26-->To verify that "consultant logo" button should accepts only the
		// JPEG or PNG formats
		// enter the valid format
		String validConsultantFile = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_consultant_image_path, "APMS-T26");
		newProject_DetailsPanel.uploadLogo(NewProjectDetailsPanelConstants.panel_consltant_logo, validClientFile);
		asert.assertFalse(
				newProject_DetailsPanel.isErrorMessageVisible(NewProjectDetailsPanelConstants.panel_consltant_logo),
				"To verify that consultant logo button should accepts only the JPEG or PNG formats",
				validConsultantFile);

		// APMS-27 ->To verify that consultant logo button should not support other than
		// Jpeg or png format
		// enter invalid format
		String inValidConsultant_format = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_file_path, "APMS-T27");
		newProject_DetailsPanel.uploadLogo(NewProjectDetailsPanelConstants.panel_consltant_logo, invalidClientFile);
		asert.assertEquals(
				newProject_DetailsPanel.getErrorMessage(NewProjectDetailsPanelConstants.panel_consltant_logo),
				NewProjectDetailsPanelConstants.consultant_logo_error_msg,
				"To verify that consultant logo button should not support other than Jpeg or png format", "APMS-T12");

		// APMS-28--> To Verify that "License Key" text field should accept 16
		// characters consisting alphabets and numbers.
		String License_Key = AwtUtilities.genrateRandomAlphaNeumric(14);
		// enter the valid license Key
		newProject_DetailsPanel.enterLicenseKey(License_Key);
		asert.assertEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.Panel_licenses_key),
				License_Key,
				"To Verify that License Key text field should accept 16 characters consisting alphabets and numbers.",
				"APMS-T28");
		// APMS-29--> To Verify that "License Key" text field should not accept more
		// than 16 characters .
		String inValid_License_Key = AwtUtilities.genrateRandomAlphaNeumric(17);
		// enter the invalid license Key
		newProject_DetailsPanel.enterLicenseKey(inValid_License_Key);
		asert.assertNotEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.Panel_licenses_key),
				inValid_License_Key,
				"To Verify that License Key text field should not accept more than 16 characters .", "APMS-T29");
		// APMS-30--> To verify that user should able to select the multiple modules in
		// the "module name" drop down.
		// select the multiple module
		newProject_DetailsPanel.selectModuleName(NewProjectDetailsPanelConstants.module_name);
		boolean isModuleSelected = newProject_DetailsPanel.getAllSelectedModule()
				.containsAll(new ArrayList(Arrays.asList(NewProjectDetailsPanelConstants.module_name)));
		asert.assertTrue(isModuleSelected,
				"To verify that user should able to select the multiple modules in the module name drop down.",
				"APMS-30");
		// APMS-31--> To verify that user is not selected any module in the module name
		// drop down, Error message should be thrown.
		// de-select all the selected module
		newProject_DetailsPanel.deSelectModuleName(NewProjectDetailsPanelConstants.module_name);
		newProject_DetailsPanel.clickAddProject();
		// Validate The Error Message
		asert.assertEquals(newProject_DetailsPanel.getErrorMessage(NewProjectDetailsPanelConstants.Panel_module_name),
				NewProjectDetailsPanelConstants.module_name_error_msg,
				"To verify that user is not selected any module in the modulename dropdown, Error message should be thrown.",
				"APMS-31");

		// APMS-32-->To verify that "User name" text field should accepts alphabets with
		// length of 16 characters.
		String valid_username = AwtUtilities.genrateRandomAlphaBets(16);
		// enter the valid username
		newProject_DetailsPanel.enterUsername(valid_username);
		asert.assertEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.panel_UserName),
				valid_username,
				"To verify that User name text field should accepts alphabets with length of 16 characters.",
				"APMS-T32");
		// Enter More Then 16 character
		String inValid_username = AwtUtilities.genrateRandomAlphaBets(18);
		// enter the in valid username
		newProject_DetailsPanel.enterUsername(inValid_username);
		asert.assertNotEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.panel_UserName),
				inValid_username, "To verify that User name text field should not accepts More Then 16 Alphabets",
				"APMS-T32");

		// APMS-33-->To verify that "user name" text field should not accept any special
		// characters and numbers.
		String SpecialCharacter_username = AwtUtilities.genrateRandomString(12) + "&@";
		// enter the Special Character username
		newProject_DetailsPanel.enterUsername(SpecialCharacter_username);
		asert.assertNotEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.panel_UserName),
				SpecialCharacter_username,
				"To verify that user name text field should not accept any special characters and numbers.",
				"APMS-T33");

		// APMS-34-->To Verify that Password with 3 to 15 characters of any type is
		// accepted in the "Password" text field.
		String validPassword = AwtUtilities.genrateRandomAlphaNeumric(3, 15);
		// enter the valid password
		newProject_DetailsPanel.enterPassword(validPassword);
		asert.assertNotEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.Panel_password),
				validPassword,
				"To Verify that Password with 3 to 15 characters of any type is accepted in the Password text field. ",
				"APMS-T34");
		// Enter Less Then 3 Digit Password
		String lessDigitPassword = AwtUtilities.genrateRandomAlphaNeumric(1, 2);
		// Enter less then 3 character password
		newProject_DetailsPanel.enterPassword(lessDigitPassword);
		asert.assertEquals(newProject_DetailsPanel.getErrorMessage(NewProjectDetailsPanelConstants.Panel_password),
				NewProjectDetailsPanelConstants.less_password_error_msg,
				"To Verify that Password Text Field Should Not Accept Less Then 3 Character. ", "APMS-T34");
		// Enter more then 15 Digit Password
		String bigPassword = AwtUtilities.genrateRandomAlphaNeumric(16);
		// Enter less then 3 character password
		newProject_DetailsPanel.enterPassword(bigPassword);
		asert.assertEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.Panel_password),
				bigPassword, "To Verify that Password Text Field Should Not Accept More Then 15 Character. ",
				"APMS-T34");
		// APMS-T35-->Verify that a "Mobile number" text field should accept only
		// numerical value.
		// numerical value.
		String mobileNumber = AwtUtilities.genrateRandomNumber(8);
		newProject_DetailsPanel.enterMobileNum(mobileNumber);
		asert.assertEquals(
				newProject_DetailsPanel
						.getNewProjectDetailsPanelsTextFieldValue(NewProjectDetailsPanelConstants.mob_num),
				mobileNumber, "Verify that a Mobile number text field should accept only numerical value.", "APMS-T35");
		// APMS-T37-->To verify that "Mobile number" text field should not accept the
		// characters.
		// Enter Character
		String character = AwtUtilities.genrateRandomAlphaBets(8);
		newProject_DetailsPanel.enterMobileNum(character);
		asert.assertNotEquals(
				newProject_DetailsPanel
						.getNewProjectDetailsPanelsTextFieldValue(NewProjectDetailsPanelConstants.mob_num),
				character, "To verify that Mobile number text field should not accept the characters.", "APMS-T37");
		// APMS-T38-->To verify that email ID's text field with valid format are
		// accepted.
		// Enter Valid Email Address
		String valid_email_add = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_email_address, "APMS-T38");
		newProject_DetailsPanel.enterEmailAdd(valid_email_add);
		asert.assertEquals(
				newProject_DetailsPanel
						.getNewProjectDetailsPanelsTextFieldValue(NewProjectDetailsPanelConstants.xl_email_address),
				valid_email_add, "To verify that email ID's  text field with valid format are accepted.", "APMS-T38");

		// APMS-T39-->To verify that email ID's text field with valid format are
		// accepted.
		// Enter Valid Email Address
		String invalid_email_add = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_email_address, "APMS-T39");
		newProject_DetailsPanel.enterEmailAdd(invalid_email_add);
		asert.assertNotEquals(
				newProject_DetailsPanel
						.getNewProjectDetailsPanelsTextFieldValue(NewProjectDetailsPanelConstants.xl_email_address),
				invalid_email_add, "To verify that email ID's  text field with valid format are accepted.", "APMS-T39");

		// APMS-41-->To Verify that the "expected date" is more than the start date.
		// Enter Start Date
		newProject_DetailsPanel.datePicker(NewProjectDetailsPanelConstants.panel_startDate, "29-April-2024");
		// Select Expected Date less Then Start Date
		newProject_DetailsPanel.datePicker(NewProjectDetailsPanelConstants.panel_ExpectedDate, "27-April-2024");
		// click on add project button
		newProject_DetailsPanel.clickAddProject();
		// validate the Expected should not be less then Start Date
		asert.assertEquals(newProject_DetailsPanel.getErrorMessage(NewProjectDetailsPanelConstants.panel_Exp_End_Date),
				NewProjectDetailsPanelConstants.expected_date_error_msg,
				"To Verify that the expected date is more than the start date.", "APMS-41");

		// APMS-43 -->To verify that the "actual completion date" is more than the
		// "start date".
		// Select Actual Completion Date which is less Start Date
		newProject_DetailsPanel.datePicker(NewProjectDetailsPanelConstants.panel_actualCompletionDate, "25-April-2024");
		// click on add project
		newProject_DetailsPanel.clickAddProject();
		asert.assertEquals(
				newProject_DetailsPanel.getErrorMessage(NewProjectDetailsPanelConstants.panel_Act__Comp_Date),
				NewProjectDetailsPanelConstants.actual_completion_date_error_msg,
				"To verify that the actual completion date is more than the start date.", "APMS-43");

		// APMS-T45-->To Verify that "Cancel" button should be visible in the "New
		// Project Details" panel
		asert.assertTrue(newProject_DetailsPanel.isCancelButtonIsVisible(),
				"To Verify that Cancel button should be visible in the New Project Details  panel", "APMS-T45");

		// APMS-46-->To verify that the "Add Project" button is present in the "New
		// Project Details" panel.
		asert.assertTrue(newProject_DetailsPanel.isAddProjectButtonIsVisible(),
				"To verify that the Add Project button is present in the New Project Details panel.", "APMS-46");

		// APMS-T47 -->To verify that functionality of the "Cancel" button
		// click on cancel button
		newProject_DetailsPanel.clickOnCancelProject();
		asert.assertTrue(admin_create_page.isTableNameDisplay(), "To verify that functionality of the Cancel button",
				"APMS-T47");

	}

	/**
	 * Verify the panels for adding a new project and ensure that the entered data
	 * is correctly displayed in the table
	 * 
	 */
	public void verifyAddFunctionality() {
		/*
		 * Click on Create Project Button --> Navigate to "New Project Details Panel
		 * 
		 */
		admin_create_page.clickCreateProjectButtonAndNavigateToNewProjectDetailPanel();
		// ********All Text Field Details ********/
		projectName = AwtUtilities.genrateRandomAlphaNeumric(5, 10);
		String clientName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_client_name, "APMS-T48");
		String clientImagePath = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_client_image_path, "APMS-T48");
		String consultantName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_consultant_name, "APMS-T48");
		String consultantImagePath = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_consultant_image_path, "APMS-T48");
		String licensesKey = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_licenses_key, "APMS-T48");
		String userName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_username, "APMS-T48");
		String password = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_password, "APMS-T48");
		String mobNumber = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_mobile_number, "APMS-T48");
		String emailAddress = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_email_address, "APMS-T48");
		String startDate = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_start_date, "APMS-T48");
		String expectedDate = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_expected_date, "APMS-T48");
		String actualCompletionDate = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.xl_actual_compeltion_date, "APMS-T48");
		String[] moduleName = NewProjectDetailsPanelConstants.module_name;

		/*
		 * Enter Whole Details In New Project Details Panel
		 *
		 * enter the project details (Project Name,Client Name, CLient logo, Consultant
		 * Name, Consultant Logo, Licenses Key, User Name, Password, Mobile Number,
		 * Email Address Start Date, Expected Date, Actual Completion Date,Module Name)
		 * 
		 */
		newProject_DetailsPanel.enterProjectDetails(projectName, clientName, clientImagePath, consultantName,
				consultantImagePath, licensesKey, userName, password, mobNumber, emailAddress, startDate, expectedDate,
				actualCompletionDate, moduleName);

		// --> click on add project button
		newProject_DetailsPanel.clickAddProject();

		// APMS-T49 ->To ensure that no duplicate usernames exist within a specific
		// project.
		// click on created Project
		admin_create_page.clickCreateProjectButtonAndNavigateToNewProjectDetailPanel();
		// First Enter the same project name and user name which you have created
		newProject_DetailsPanel.enterProjectDetails(projectName, clientName, clientImagePath, consultantName,
				consultantImagePath, licensesKey, userName, password, mobNumber, emailAddress, startDate, expectedDate,
				actualCompletionDate, moduleName);
		// click on Add Project Button
		newProject_DetailsPanel.clickAddProject();
		// error message should be visible on Project Name and User Name
		asert.assertEquals(newProject_DetailsPanel.getErrorMessage(NewProjectDetailsPanelConstants.panel_project_name),
				NewProjectDetailsPanelConstants.duplicate_project_name_error_msg,
				"To ensure that no duplicate project name exist .", "APMS-T49");
		asert.assertEquals(newProject_DetailsPanel.getErrorMessage(NewProjectDetailsPanelConstants.panel_UserName),
				NewProjectDetailsPanelConstants.duplicate_username_error_msg,
				"To ensure that no duplicate usernames exist within a specific project.", "APMS-T49");
		// click on cancel project button
		newProject_DetailsPanel.clickOnCancelProject();

		// verify The project name
		asert.assertTrue(admin_create_page.isProjectNameVIsibleInTable(projectName),
				"verify The Created Project Name Should be Visible In Table", "APMS-T48");

		// APMS-T50 -> Verify that the created project details are correctly displayed
		// in the "project details" table.
		// Verify Project Name
		asert.assertEquals(
				admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.xl_project_name),
				projectName, "Verify that the created project name are correctly displayed in the Project Name Column.",
				"APMS-T50");
		// verify Client Name
		asert.assertEquals(
				admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.xl_client_name),
				clientName, "Verify that the created client name are correctly displayed in the Client Name Column.",
				"APMS-T50");
		// verify Consultant Name
		asert.assertEquals(
				admin_create_page.getColumnDataFromProjectDetailsTable(
						NewProjectDetailsPanelConstants.xl_consultant_name),
				consultantName,
				"Verify that the created consultant name are correctly displayed in the Consultant Name Column.",
				"APMS-T50");
		// verify Due Days
		String due_days = AwtUtilities.getTimeDiff(
				AwtUtilities.convertDateFormat(expectedDate, "dd/MMM/yyyy", "dd-MM-yyyy"),
				AwtUtilities.convertDateFormat(actualCompletionDate, "dd/MMM/yyyy", "dd-MM-yyyy"));
		asert.assertEquals(
				admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.due_days),
				due_days, "Verify that the due days display are correctly displayed in the Due Days Column.",
				"APMS-T50");

		// verify Module Name
		asert.assertTrue(
				AwtUtilities
						.convertStringToCollection(admin_create_page
								.getColumnDataFromProjectDetailsTable(AdminCreateProjectPageConstants.module_name))
						.containsAll(new ArrayList<String>(Arrays.asList(NewProjectDetailsPanelConstants.module_name))),
				"Verify that the added module name should be display ", "APMS-50");
		// verify Mobile Number
		asert.assertEquals(
				admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.mob_num),
				mobNumber, "Verify that the created mobile number are correctly displayed in the Mobile Number Column.",
				"APMS-T50");
		// verify Email Id
		asert.assertEquals(
				admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.email_id),
				emailAddress, "Verify that the created email address are correctly displayed in the Email Column.",
				"APMS-T50");
		// verify Start Date
		asert.assertEquals(
				admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.xl_start_date),
				AwtUtilities.convertDateFormat(startDate, "dd/MMM/yyyy", "dd-MM-yyyy"),
				"Verify that the Start Date display are correctly displayed in the Start Date Column.", "APMS-T50");
		// verify Actual Completion Date
		asert.assertEquals(
				admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.actual_end_date),
				AwtUtilities.convertDateFormat(actualCompletionDate, "dd/MMM/yyyy", "dd-MM-yyyy"),
				"Verify that the Actual Completion Date display are correctly displayed in the Actual Completion Column.",
				"APMS-T50");

	}

	public void verifyAwtProjectTable() {
		// APMS-51
		// -->To verify that the "AWT- Projects" Table contains "Project Name, Client
		// Name, Client Logo, Consultant Name, Consultant Logo, Start Date, Actual End
		// Date, Due Days, Module Name, Mobile Number, Email ID, Action "column
		asert.assertEquals(admin_create_page.getAllAwtProjectColumsName(), AdminCreateProjectPageConstants.columnName,
				"To verify that the AWT- Projects Table contains Project Name, Client Name, Client Logo, Consultant Name, Consultant Logo, Start Date, Actual End Date, Due Days, Module Name, Mobile Number, Email ID, Action column",
				"APMS-51");
		// APMS-> 52
		// ->To Verify that the "Edit", "Delete" "Upload Document" and "Device Config"
		// button is present under the "Action" column
		// Verify Edit Button
		asert.assertTrue(admin_create_page.isEditButtonVisible(),
				"To Verify that the Edit button is present under the action column", "APMS-52");
		// verify delete button
		asert.assertTrue(admin_create_page.isDeleteButtonVisible(),
				"To Verify that the delete button is present under the action column", "APMS-52");
		// verify upload button
		asert.assertTrue(admin_create_page.isUploadButtonVisible(),
				"To Verify that the upload button is present under the action column", "APMS-52");
		// verify device config button
		asert.assertTrue(admin_create_page.isDeviceConfigdButtonVisible(),
				"To Verify that the device config button is present under the action column", "APMS-52");

	}

	public void verifyEditFunctionality() {

		// APMS-53
		// -->To verify "Edit" button functionality under the "Action" column.
		// click on edit button
		admin_create_page.editProjectDetails(projectName);
		// Generate mobile number
		String number = AwtUtilities.genrateRandomNumber(10);
		// Edit the updated Mobile Number
		newProject_DetailsPanel.enterMobileNum(number);
		// click on update project button
		admin_create_page.clickOnUpdateProjectButton();
		// get the updated number
		String update_num = admin_create_page.getColumnDataFromProjectDetailsTable(projectName,
				NewProjectDetailsPanelConstants.mob_num);
		asert.assertEquals(update_num, number, "To verify Editbutton functionality under the Action column.",
				"APMS-53");
		// APMS-54
		// -->To verify that clicking the "delete" button allows user to deletion of the
		// project if no command area is associated.
		// click on delete the project
		admin_create_page.deleteProjectDetails(projectName);
		// accept pop-up
		newProject_DetailsPanel.acceptPopup();
		// wait for update the table
		AwtUtilities.waitFor(3000);
		// deleted project name should not be visible on the column
		asert.assertFalse(admin_create_page.isProjectNameVIsibleInTable(projectName),
				" To verify that clicking the delete button allows user to deletion of the project if no command area is associated.",
				"APMS-54");

	}

}
