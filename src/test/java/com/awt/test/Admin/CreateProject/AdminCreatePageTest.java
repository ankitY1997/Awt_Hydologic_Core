package com.awt.test.Admin.CreateProject;

import java.util.ArrayList;
import java.util.Arrays;

import org.bouncycastle.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.awt.constant.Admin.AdminPageContants;
import com.awt.constant.Admin.CreatePage.AdminPageConstants;
import com.awt.constant.Admin.CreatePage.NewProjectDetailsPanelConstants;
import com.awt.constant.Login.LoginPageConstants;
import com.awt.page.Admin.CreateProject.AdminCreateProjectPage;
import com.awt.page.Admin.CreateProject.AdminPage;
import com.awt.page.Admin.CreateProject.NewProjectDetailsPanel;
import com.awt.page.Login.LoginPage;
import com.awt.testbase.BaseTest;
import com.awt.testbase.DriverFactory;
import com.awt.testbase.MyLogger;
import com.awt.utills.reusablecomponents.AwtUtilities;
import com.awt.utills.reusablecomponents.Description;
import com.awt.utills.reusablecomponents.ExcelOperations;
import com.awt.utills.reusablecomponents.Owner;
import com.awt.utills.reusablecomponents.SoftAssertTest;
import com.awt.utills.reusablecomponents.Story;
import com.awt.utills.reusablecomponents.TestCaseId;
import com.awt.utills.reusablecomponents.Version;
import com.awt.utills.reusablecomponents.WorkArea;

public class AdminCreatePageTest extends BaseTest {

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
			"APMS-T34", "APMS-T35", "APMS-T37", "APMS-T38", "APMS-T39","APMS-T45","APMS-46","APMS-T47", "APMS-T48", "APMS-T50" })
	public void verify_NewProjectDetailsPanel() {
		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// SoftAssert instance
		SoftAssertTest asert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// log in Page instance
		LoginPage lp = new LoginPage(DriverFactory.iuiDriver().getDriver());
		// Enter the Project Name and login and navigate to the home page
		AdminPage admin_page = lp.loginAndnavigateToAdminPage(LoginPageConstants.project_name);
		// verify Home Page Title
		asert.assertEquals(admin_page.getHomePageTitle(), AdminPageConstants.expected_home_page_title,
				"verify Home Page Title Should Be Display Correct", "APMS-T0");
		// click on project management drop-down menu and Select "Create Project" menu
		AdminCreateProjectPage admin_create_page = admin_page
				.clickCreateProjectButtonAndNavigateToAdminCreateProjectPage(AdminPageContants.project,
						AdminPageContants.project_setting);
		// verify "Create Project" button is display
		asert.assertEquals(admin_create_page.isCreateProjectButtonDispaly(), true,
				"Verify that the Create Project button is visible", "APMS-T1");
		// * Click on Create Project Button --> Navigate to "New Project Details Panel
		NewProjectDetailsPanel newProject_DetailsPanel = admin_create_page
				.clickCreateProjectButtonAndNavigateToNewProjectDetailPanel();

		// APMS-T2-> Verify That New Project Details Panel Should Be Visible -->
		// Expected Panel Name
		String exp_panel_name = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.panel_Name, "APMS-T2");
		// Verify that new Project Details Panel Should be visible
		asert.assertEquals(newProject_DetailsPanel.getPanelName(), exp_panel_name,
				"Verify That New Project Details Panel Should Be Visible", "APMS-T2");
		// Verify Fields In "New Project Details Panel"
		asert.assertEquals(newProject_DetailsPanel.getNewProjectDetailsPanelFiledsName(),
				NewProjectDetailsPanelConstants.list_field, "Verify Fields In New Project Details Panel", "APMS-T3");

		// AMPS-T4-> Verify that project name text field accept the project name with a
		// hyphen and number-->
		// Enter The Project Name
		String Project_Name = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.project_name, "APMS-T4");
		newProject_DetailsPanel.enterProjectName(Project_Name);
		asert.assertEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.project_name),
				Project_Name, " Verify that project name text field accept the project name with a hyphen and number",
				"APMS-T4");
		// APMS-T6 ->Verify that a "project name" text field should accept only the
		// hyphen, alphabets and numbers-->

		// Enter In Valid Project Name
		String InValid_Project_Name = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.project_name, "APMS-T6");
		newProject_DetailsPanel.enterProjectName(InValid_Project_Name);
		asert.assertNotEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.project_name),
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
						.getNewProjectDetailsPanelsTextFieldValue(NewProjectDetailsPanelConstants.project_name),
				project_name, "Verify that project name should not exceed more than100 characters ", "APMS-T7");

		// APMS- T8 -->Verify that a "Client Name" text field should accept only the
		// alphabets and spaces.
		String valid_clientName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.client_name, "APMS-T8");
		// enter the valid client name-->
		newProject_DetailsPanel.enterClientName(valid_clientName);
		asert.assertNotEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.client_name),
				valid_clientName, "Verify that a Client Name text field should accept only the alphabets and spaces.",
				"APMS-T8");
		// APMS-T9-->Verify that "client name" text field should not accept any
		// special character except space and any number
		String inValidClientName = AwtUtilities.genrateRandomAlphaNeumric(5) + "#$";
		newProject_DetailsPanel.enterClientName(inValidClientName);
		asert.assertNotEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.client_name),
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
						NewProjectDetailsPanelConstants.client_name),
				client_name,
				"Verify that client name text field should not accept any character accept space and any number",
				"APMS-T10");
		// APMS-T13 --> To Verify that a "consultant name" text field should accept only
		// the alphabets and spaces
		String valid_consultantName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.consultant_name, "APMS-T13");
		// enter the valid consultant Name
		newProject_DetailsPanel.enterConsultantName(valid_consultantName);
		asert.assertEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.consultant_name),
				valid_consultantName,
				"To Verify that a consultant name text field should accept only the alphabets and spaces", "APMS-T13");
		// APMS-T14-->Verify that "consultant name" text field should not accept any
		// special character except space and any number
		String inValidConsultantName = AwtUtilities.genrateRandomAlphaNeumric(5) + "12";
		// enter in valid client name
		newProject_DetailsPanel.enterConsultantName(inValidConsultantName);
		asert.assertNotEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.consultant_name),
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
						NewProjectDetailsPanelConstants.consultant_name),
				consultant_name, "Verify that Consultant Name text field should not exceed more than 30 character",
				"APMS-T19");

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
		asert.assertEquals(newProject_DetailsPanel.getErrorMessage(), NewProjectDetailsPanelConstants.error_message,
				"To verify that user is not selected any module in the modulename dropdown, Error message should be thrown.",
				"APMS-31");
		// accept the pop-up
		newProject_DetailsPanel.acceptPopup();

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
		asert.assertEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.Panel_password),
				validPassword,
				"To Verify that Password with 3 to 15 characters of any type is accepted in the Password text field. ",
				"APMS-T34");
		// Enter Less Then 3 Digit Password
		String lessDigitPassword = AwtUtilities.genrateRandomAlphaNeumric(1, 2);
		// Enter less then 3 character password
		newProject_DetailsPanel.enterPassword(lessDigitPassword);
		asert.assertNotEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.Panel_password),
				lessDigitPassword, "To Verify that Password Text Field Should Not Accept Less Then 3 Character. ",
				"APMS-T34");
		// Enter more then 15 Digit Password
		String bigPassword = AwtUtilities.genrateRandomAlphaNeumric(16);
		// Enter less then 3 character password
		newProject_DetailsPanel.enterPassword(bigPassword);
		asert.assertNotEquals(
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
				NewProjectDetailsPanelConstants.email_address, "APMS-T38");
		newProject_DetailsPanel.enterEmailAdd(valid_email_add);
		asert.assertEquals(
				newProject_DetailsPanel
						.getNewProjectDetailsPanelsTextFieldValue(NewProjectDetailsPanelConstants.email_address),
				valid_email_add, "To verify that email ID's  text field with valid format are accepted.", "APMS-T38");

		// APMS-T39-->To verify that email ID's text field with valid format are
		// accepted.
		// Enter Valid Email Address
		String invalid_email_add = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.email_address, "APMS-T39");
		newProject_DetailsPanel.enterEmailAdd(invalid_email_add);
		asert.assertNotEquals(
				newProject_DetailsPanel
						.getNewProjectDetailsPanelsTextFieldValue(NewProjectDetailsPanelConstants.email_address),
				invalid_email_add, "To verify that email ID's  text field with valid format are accepted.", "APMS-T39");

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

		/*
		 * Click on Create Project Button --> Navigate to "New Project Details Panel
		 * 
		 */
		admin_create_page.clickCreateProjectButtonAndNavigateToNewProjectDetailPanel();
		// ********All Text Field Details ********/
		String projectName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.project_name, "APMS-T48");
		String clientName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.client_name, "APMS-T48");
		String clientImagePath = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.client_image_path, "APMS-T48");
		String consultantName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.consultant_name, "APMS-T48");
		String consultantImagePath = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.consultant_image_path, "APMS-T48");
		String licensesKey = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.licenses_key, "APMS-T48");
		String userName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.username, "APMS-T48");
		String password = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.password, "APMS-T48");
		String mobNumber = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.mobile_number, "APMS-T48");
		String emailAddress = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.email_address, "APMS-T48");
		String startDate = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.start_date, "APMS-T48");
		String expectedDate = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.expected_date, "APMS-T48");
		String actualCompletionDate = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.actual_compeltion_date, "APMS-T48");
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

		// verify The Success Pop-up Message
		asert.assertEquals(newProject_DetailsPanel.getSuccessMessage(), "Project created successfully!",
				"verify The Project successfully created Pop-Up Message", "APMS-T48");
		// click on the pop-up
		newProject_DetailsPanel.acceptPopup();

		try {
			// APMS-T50 -> Verify that the created project details are correctly displayed
			// in the "project details" table.
			// Verify Project Name
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(
							NewProjectDetailsPanelConstants.project_name),
					projectName,
					"Verify that the created project name are correctly displayed in the Project Name Column.",
					"APMS-T50");
			// verify Client Name
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.client_name),
					clientName,
					"Verify that the created client name are correctly displayed in the Client Name Column.",
					"APMS-T50");
			// verify Consultant Name
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(
							NewProjectDetailsPanelConstants.consultant_name),
					consultantName,
					"Verify that the created consultant name are correctly displayed in the Consultant Name Column.",
					"APMS-T50");
			// verify Mobile Number
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.mob_num),
					mobNumber,
					"Verify that the created mobile number are correctly displayed in the Mobile Number Column.",
					"APMS-T50");
			// verify Email Id
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.email_id),
					emailAddress, "Verify that the created email address are correctly displayed in the Email Column.",
					"APMS-T50");
			// verify Username
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.username),
					userName, "Verify that the created user name are correctly displayed in the username Column.",
					"APMS-T50");
			// verify Password
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.password),
					password, "Verify that the created password are correctly displayed in the Password Column.",
					"APMS-T50");
			// verify Due Days
			String due_days = AwtUtilities.getTimeDiff(expectedDate, actualCompletionDate);
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.due_days),
					due_days, "Verify that the due days display are correctly displayed in the Due Days Column.",
					"APMS-T50");
			// verify Start Date
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.start_date),
					startDate, "Verify that the Start Date display are correctly displayed in the Start Date Column.",
					"APMS-T50");
			// verify Expected Date
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(
							NewProjectDetailsPanelConstants.expected_date),
					expectedDate,
					"Verify that the Start Date display are correctly displayed in the Start Date Column.", "APMS-T50");
			// verify Actual Completion Date
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(
							NewProjectDetailsPanelConstants.actual_compeltion_date),
					actualCompletionDate,
					"Verify that the Actual Completion Date display are correctly displayed in the Actual Completion Column.",
					"APMS-T50");
		} catch (Exception e) {

		}
		// delete the Project
		admin_create_page.deleteProjectDetails(projectName);
		// accept pop-up
		newProject_DetailsPanel.acceptPopup();
		// accept pop-up
		newProject_DetailsPanel.acceptPopup();

		asert.assertAll();

	}

	/**
	 * Description: Perform the verification Awt-Project Table Column<br>
	 * TestMethodName: verify_NewProjectDetailsPanel <br>
	 * ManualTestCases: "APMS-T48", "APMS-T49"<br>
	 * 
	 * @author ankit
	 */

	@Version(number = "V-0.1")
	@Test(groups = { "Admin", "Functional" })
	@Description(description = "Perform the verfication To Create A New Project And Validate The Details Of Project Under The Details Table")
	@Story(story = "Create Project Details Panel")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestCaseId(id = { "APMS-T48", "APMS-T49" })
	public void verifyAddProjectDetails() {
		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// SoftAssert instance
		SoftAssertTest asert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// log in Page instance
		LoginPage lp = new LoginPage(DriverFactory.iuiDriver().getDriver());
		// Enter the Project Name and login and navigate to the admin page
		AdminPage admin_page = lp.loginAndnavigateToAdminPage(LoginPageConstants.project_name);
		// click on project management drop-down menu and Select "Create Project" menu
		AdminCreateProjectPage admin_create_page = admin_page
				.clickCreateProjectButtonAndNavigateToAdminCreateProjectPage(AdminPageContants.project,
						AdminPageContants.project_setting);
		/*
		 * Click on Create Project Button --> Navigate to "New Project Details Panel
		 * 
		 */
		NewProjectDetailsPanel newProjectDetailsPanel = admin_create_page
				.clickCreateProjectButtonAndNavigateToNewProjectDetailPanel();
		/*
		 * enter the project details (Project Name,Client Name, CLient logo, Consultant
		 * Name, Consultant Logo, Licenses Key, Module Name, User Name, Password, Mobile
		 * Number, Email Address Start Date, Expected Date, Actual Completion Date)
		 * 
		 */
		String projectName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.project_name, "APMS-T48");
		String clientName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.client_name, "APMS-T48");
		String clientImagePath = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.client_image_path, "APMS-T48");
		String consultantName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.consultant_name, "APMS-T48");
		String consultantImagePath = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.consultant_image_path, "APMS-T48");
		String licensesKey = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.licenses_key, "APMS-T48");
		String userName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.username, "APMS-T48");
		String password = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.password, "APMS-T48");
		String mobNumber = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.mobile_number, "APMS-T48");
		String emailAddress = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.email_address, "APMS-T48");
		String startDate = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.start_date, "APMS-T48");
		String expectedDate = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.expected_date, "APMS-T48");
		String actualCompletionDate = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.actual_compeltion_date, "APMS-T48");
		String[] moduleName = NewProjectDetailsPanelConstants.module_name;
		newProjectDetailsPanel.enterProjectDetails(projectName, clientName, clientImagePath, consultantName,
				consultantImagePath, licensesKey, userName, password, mobNumber, emailAddress, startDate, expectedDate,
				actualCompletionDate, moduleName);
		// --> click on add project button
		newProjectDetailsPanel.clickAddProject();
		// verify The Success Pop-up Message
		asert.assertEquals(newProjectDetailsPanel.getSuccessMessage(), "Project created successfully!",
				"verify The Project successfully created Pop-Up Message", "APMS-T48");
		// click on the pop-up
		newProjectDetailsPanel.acceptPopup();

		try {
			// APMS-T49 -> Verify that the created project details are correctly displayed
			// in the "project details" table.
			// Verify Project Name
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(
							NewProjectDetailsPanelConstants.project_name),
					projectName,
					"Verify that the created project name are correctly displayed in the Project Name Column.",
					"APMS-T49");
			// verify Client Name
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.client_name),
					clientName,
					"Verify that the created client name are correctly displayed in the Client Name Column.",
					"APMS-T49");
			// verify Consultant Name
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(
							NewProjectDetailsPanelConstants.consultant_name),
					consultantName,
					"Verify that the created consultant name are correctly displayed in the Consultant Name Column.",
					"APMS-T49");
			// verify Mobile Number
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.mob_num),
					mobNumber,
					"Verify that the created mobile number are correctly displayed in the Mobile Number Column.",
					"APMS-T49");
			// verify Email Id
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.email_id),
					emailAddress, "Verify that the created email address are correctly displayed in the Email Column.",
					"APMS-T49");
			// verify Username
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.username),
					userName, "Verify that the created user name are correctly displayed in the username Column.",
					"APMS-T49");
			// verify Password
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.password),
					password, "Verify that the created password are correctly displayed in the Password Column.",
					"APMS-T49");
			// verify Due Days
			String due_days = AwtUtilities.getTimeDiff(expectedDate, actualCompletionDate);
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.due_days),
					due_days, "Verify that the due days display are correctly displayed in the Due Days Column.",
					"APMS-T49");
			// verify Start Date
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.start_date),
					startDate, "Verify that the Start Date display are correctly displayed in the Start Date Column.",
					"APMS-T49");
			// verify Expected Date
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(
							NewProjectDetailsPanelConstants.expected_date),
					expectedDate,
					"Verify that the Start Date display are correctly displayed in the Start Date Column.", "APMS-T49");
			// verify Actual Completion Date
			asert.assertEquals(
					admin_create_page.getColumnDataFromProjectDetailsTable(
							NewProjectDetailsPanelConstants.actual_compeltion_date),
					actualCompletionDate,
					"Verify that the Actual Completion Date display are correctly displayed in the Actual Completion Column.",
					"APMS-T49");
		} catch (Exception e) {

		}
		// delete the Project
		admin_create_page.deleteProjectDetails(projectName);
		// accept pop-up
		newProjectDetailsPanel.acceptPopup();
		// accept pop-up
		newProjectDetailsPanel.acceptPopup();

		asert.assertAll();

	}
}
