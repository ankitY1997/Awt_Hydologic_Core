package com.awt.test.Admin.CreateProject;

import org.bouncycastle.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.awt.constant.Admin.AdminPageContants;
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
	 * ManualTestCases: APMS-T1,APMS-T2,APMS-T3,APMS-T4<br>
	 * 
	 * @author ankit
	 */

	@Version(number = "V-0.1")
	@Test(groups = { "Admin", "Functional" })
	@Description(description = "Perform the verfication on  New Project Details Panel")
	@Story(story = "Create Project Details Panel")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestCaseId(id = { "APMS-T1", "APMS-T2", "APMS-T3", "APMS-T4" })
	public void verify_NewProjectDetailsPanel() {
		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// SoftAssert instance
		SoftAssertTest asert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// log in Page instance
		LoginPage lp = new LoginPage(DriverFactory.iuiDriver().getDriver());
		// Enter the Project Name and login and navigate to the admin page
		AdminPage admin_page = lp.loginAndnavigateToAdminPage(LoginPageConstants.project_name);
		// verify Project Management Button Is Present
		asert.assertEquals(admin_page.isProjectManagmentButtonPresent(), true,
				"verify Project Managment button Is Display", "APMS-T0");
		// click on project management drop-down menu and Select "Create Project" menu
		AdminCreateProjectPage admin_create_page = admin_page
				.clickCreateProjectButtonAndNavigateToAdminCreateProjectPage();
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
		String inValidClientName = AwtUtilities.genrateRandomAlphaNeumric(5) + "12";
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
						NewProjectDetailsPanelConstants.licenses_key),
				License_Key,
				"To Verify that License Key text field should accept 16 characters consisting alphabets and numbers.",
				"APMS-T28");
		// APMS-29--> To Verify that "License Key" text field should not accept more
		// than 16 characters .
		String inValid_License_Key = AwtUtilities.genrateRandomAlphaNeumric(17);
		// enter the in valid license Key
		newProject_DetailsPanel.enterLicenseKey(inValid_License_Key);
		asert.assertEquals(
				newProject_DetailsPanel.getNewProjectDetailsPanelsTextFieldValue(
						NewProjectDetailsPanelConstants.licenses_key),
				inValid_License_Key,
				"To Verify that License Key text field should not accept more than 16 characters .", "APMS-T29");

		asert.assertAll();

	}

	/**
	 * Description: Perform the verfication on new Project Details Panel<br>
	 * TestMethodName: verify_NewProjectDetailsPanel <br>
	 * ManualTestCases: APMS-T1,APMS-T2,APMS-T3,APMS-T4<br>
	 * 
	 * @author ankit
	 */

	@Version(number = "V-0.1")
	@Test(groups = { "Admin", "Functional" })
	@Description(description = "Perform the verfication To Create A New Project And Validate The Details Of Project Under The Details Table")
	@Story(story = "Create Project Details Panel")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestCaseId(id = { "APMS-T7", "APMS-T2", "APMS-T3", "APMS-T4" })
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
				.clickCreateProjectButtonAndNavigateToAdminCreateProjectPage();
		/*
		 * Click on Create Project Button --> Navigate to "New Project Details Panel
		 * 
		 */
		NewProjectDetailsPanel project_details = admin_create_page
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
		project_details.enterProjectDetails(projectName, clientName, clientImagePath, consultantName,
				consultantImagePath, licensesKey, userName, password, moduleName, mobNumber, emailAddress, startDate,
				expectedDate, actualCompletionDate);
		// --> click on add project button
		project_details.clickAddProject();
		// verify The Success Pop-up Message
		asert.assertEquals(project_details.getSuccessMessage(), "Project created successfully!",
				"verify The Project successfully created Pop-Up Message", "APMS-T48");
//		 Click On Again Create Project Button and Navigate to the New Project Details
//		 Panel
//		admin_create_page.clickCreateProjectButtonAndNavigateToNewProjectDetailPanel();
//		//enter the created Project Name
//		project_details.enterProjectName(projectName);
//		// click on Add Project Button 
//		project_details.clickAddProject();
//		 Verify the user is not able to create 

		// click on the pop-up
		project_details.acceptPopup();
		asert.assertEquals(
				admin_create_page.getColumnDataFromProjectDetailsTable(NewProjectDetailsPanelConstants.project_name,projectName),
				projectName, "verify", "APMS-T48");
		AwtUtilities.waitFor(5000);
		asert.assertAll();

	}
}
