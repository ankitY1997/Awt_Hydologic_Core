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
import com.awt.utills.reusablecomponents.TestId;
import com.awt.utills.reusablecomponents.WorkArea;

public class AdminCreatePageTest extends BaseTest {

	/**
	 * Description: Perform the verification on Contract Folder details page<br>
	 * TestMethodName: verify_AddProjectDetails <br>
	 * ManualTestCases: 01,02,03 <br>
	 * 
	 * @author ankit
	 */

	@Test(groups = { "Admin", "Functional" })
	@Description(description = "Perform the verfication on  new Project Detais Panel")
	@Story(story = "Contracts ExistingContracts Tab Contract Folder Details Page")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Admin")
	@TestId(id = { 01, 02, 03 })
	public void verify_AddedProjectDetails() {
		// logger instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// SoftAssert instance
		SoftAssertTest asert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// log in Page instance
		LoginPage lp = new LoginPage(DriverFactory.iuiDriver().getDriver());
		// Enter the project name
		lp.enterProjectName(LoginPageConstants.project_name);
		// login and navigate to the admin page
		AdminPage admin_page = lp.loginAndnavigateToAdminPage();
		// verify Project Management Button Is Present
		asert.assertEquals(admin_page.isProjectManagmentButtonPresent(), true,
				"verify Project Managment button Is Display", 01);
		// click on project management drop-down menu and Select "Create Project" menu
		AdminCreateProjectPage admin_create_page = admin_page
				.clickCreateProjectButtonAndNavigateToAdminCreateProjectPage();
		// verify "Create Project" button is display
		asert.assertEquals(admin_create_page.isCreateProjectButtonDispaly(), true,
				"verify Create Project button Is Display", 02);
		// now click on the "Create project button" --> Navigate to "New Project Details
		// Panel
		NewProjectDetailsPanel project_details = admin_create_page
				.clickCreateProjectButtonAndNavigateToNewProjectDetailPanel();
		// enter the project details
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
				"verify The Success Pop-up Message", 3);
		// click on the pop-up
		project_details.acceptPopup();

		asert.assertAll();

	}

}
