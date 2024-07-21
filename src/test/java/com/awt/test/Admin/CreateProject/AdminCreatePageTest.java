package com.awt.test.Admin.CreateProject;

import org.bouncycastle.util.Properties;
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
		/*
		 * Click on Create Project Button --> Navigate to "New Project Details Panel
		 * 
		 */
		NewProjectDetailsPanel project_details = admin_create_page
				.clickCreateProjectButtonAndNavigateToNewProjectDetailPanel();
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
				NewProjectDetailsPanelConstants.project_name, "3");
		String clientName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.client_name, "3");
		String clientImagePath = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.client_image_path, "3");
		String consultantName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.consultant_name, "3");
		String consultantImagePath = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.consultant_image_path, "3");
		String licensesKey = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.licenses_key, "3");
		String userName = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.username, "3");
		String password = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.password, "3");
		String mobNumber = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.mobile_number, "3");
		String emailAddress = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.email_address, "3");
		String startDate = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.start_date, "3");
		String expectedDate = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.expected_date, "3");
		String actualCompletionDate = ExcelOperations.getCellData(NewProjectDetailsPanelConstants.file_name,
				NewProjectDetailsPanelConstants.actual_compeltion_date, "3");
		String[] moduleName = NewProjectDetailsPanelConstants.module_name;
		project_details.enterProjectDetails(projectName, clientName, clientImagePath, consultantName,
				consultantImagePath, licensesKey, userName, password, moduleName, mobNumber, emailAddress, startDate,
				expectedDate, actualCompletionDate);
		// --> click on add project button
		project_details.clickAddProject();
		// verify The Success Pop-up Message
		asert.assertEquals(project_details.getSuccessMessage(), "Project created successfully!",
				"verify The Project successfully created Pop-Up Message", "APMS-T8");
		// Click On Again Create Project Button and Navigate to the New Project Details
		// Panel
//		admin_create_page.clickCreateProjectButtonAndNavigateToNewProjectDetailPanel();
//		//enter the created Project Name
//		project_details.enterProjectName(projectName);
//		// click on Add Project Button 
//		project_details.clickAddProject();
		// Verify the user is not able to create 
		
		// click on the pop-up
		project_details.acceptPopup();

	}
}
