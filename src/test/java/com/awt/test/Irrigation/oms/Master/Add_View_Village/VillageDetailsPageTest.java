package com.awt.test.Irrigation.oms.Master.Add_View_Village;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.awt.page.ParentLandingPage;
import com.awt.page.Irrigation.Home.HomePage;
import com.awt.page.Irrigation.Login.LoginPage;
import com.awt.page.Irrigation.oms.OmsAdminDashboardPage;
import com.awt.page.Irrigation.oms.Master.Add_View_Village.NewVillageDetailsPanel;
import com.awt.page.Irrigation.oms.Master.Add_View_Village.VillageDetailsPage;
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

public class VillageDetailsPageTest extends BaseTest {

	private static final String url = PropertiesOperations.getPropertyValueByKey("USERURL");
	private static final String project_name = PropertiesOperations.getPropertyValueByKey("Project_Name");
	private static final String main_porject_name = PropertiesOperations.getPropertyValueByKey("Main_Project_Name");
	private SoftAssertTest asert = null;
	private LoginPage login_page = null;
	private ParentLandingPage parent_landing_page = null;
	private HomePage home_page = null;
	private OmsAdminDashboardPage oms_admin_dashboard_page = null;
	private VillageDetailsPage village_details_page = null;
	private NewVillageDetailsPanel new_village_details_panel = null;
	private String village_name = null;

	/**
	 * Navigate To Login Page
	 */
	public void navigateToLoginPage() {

		// SoftAssert instance
		asert = new SoftAssertTest(DriverFactory.iuiDriver().getDriver());
		// navigate to login page
		parent_landing_page = new ParentLandingPage(DriverFactory.iuiDriver().getDriver());
		// Select the module
		login_page = parent_landing_page.selectProject(main_porject_name, url);

	}

	@Version(number = "V-0.1")
	@Test(groups = { "Log In", "Functional" })
	@Description(description = "Perform the verfication on  Log In Page")
	@Story(story = "Log In ")
	@Owner(name = "Ankit")
	@WorkArea(areaName = "Log in")
	@TestCaseId(id = { "SU-T36", "SU-T37", "SU-T38", "SU-T718", "SU-T719", "SU-T719", "SU-T721", "APMS-T135", "SU-T723",
			"SU-T724", "SU-T725", "SU-T727", "SU-T728", "SU-T729", "SU-T730", "SU-T731", "SU-T732", "SU-T733",
			"SU-T734", "SU-T735", "SU-T736", "SU-T737", "SU-T738", "SU-T742", "SU-T742", "SU-T742", "SU-T743",
			"SU-T743" })
	public void verifyVillageDetailsPage() throws InterruptedException {
		// Logger Instance
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		// -> Navigate To Login page
		navigateToLoginPage();
		// ->Login To The Application and Navigate To The HomePage
		home_page = login_page.loginAndNavigateToHomePage(PropertiesOperations.getPropertyValueByKey("Project_Name"),
				PropertiesOperations.getPropertyValueByKey("User_USERNAME"),
				PropertiesOperations.getPropertyValueByKey("User_PASSWORD"));

		// ->Click on "OMS" module and Navigate To OmsAdminDashboardPage
		oms_admin_dashboard_page = home_page.navigateToOmsAdminDashboardPage();

		// SU-T36 -->To verify that "Add/View Village" option should be visible in the
		// "Master" menu

		// -> Validate the "Add/View Village Options Under The Master Menus
		boolean isAdd_View_VillageOptionVIsible = oms_admin_dashboard_page.isAddViewVillageOptionVisible();
		asert.assertTrue(isAdd_View_VillageOptionVIsible,
				"To verify that 'Add/View Village' option should be visible in the 'Master' menu", "SU-T36");

		// SU-T37-->To verify that after clicking on the "Add/View Village" button user
		// should redirected to the "OMS-getVillageArea" page.

		// Click "Add/View Village" options and redirect to the "OMS-getVillageArea"
		// page
		village_details_page = oms_admin_dashboard_page.navigateToVillageDetailsPage();
		// ->take the current page name
		String current_url = DriverFactory.iuiDriver().getDriver().getCurrentUrl();
		// Validate "OMS-getVillageArea"
		asert.assertTrue(current_url.contains("OMS-getVillageArea"),
				"To verify that after clicking on the 'Add/View Village' button user should redirected to the 'OMS-getVillageArea' page.",
				"SU-T37");

		// SU-T38-->To verify that "New" button should be present in the
		// "OMS-getVillageArea" Page

		// ->Check the "new" button is visible or not
		boolean isNewButtonVisible = village_details_page.isNewButtonIsVisible();
		asert.assertTrue(isNewButtonVisible,
				"To verify that New button should be present in the OMS-getVillageArea Page", "SU-T38");

		// Verify New Village Details Panel
		verifyNewVillageDetailsPanel();

		// Verify village details panel
		verifyVillageDetailsTable();

		// asert all
		asert.assertAll();

	}

	public void verifyNewVillageDetailsPanel() throws InterruptedException {

		// SU-T39-->To verify that after clicking on the "New" button user should
		// redirect to the "New Villages Details" panel

		// ->Click on "New" button
		new_village_details_panel = village_details_page.clickOnNewButtonAndNavigateToNewVillageDetaisPanel();
		// Validate "New Village Details" Panel is visible or not
		String actual_panel_name = new_village_details_panel.getPanelName();
		String exp_panel_name = "New Village Details";
		asert.assertEquals(actual_panel_name, exp_panel_name,
				"To verify that after clicking on the 'New' button user should redirect to the  'New Villages Details'  panel",
				"SU-T39");

		// SU-T40-->To verify that "Command Area" drop down should be visible in the
		// "New Villages Details" panel.

		// ->Validate "Command DropDown" visiblity
		String actualCommandAreaDropDownName = new_village_details_panel.getCommandAreaDropDownName();
		asert.assertEquals(actualCommandAreaDropDownName, "Command Area *",
				"To verify that 'Command Area' drop down should be visible in the 'New Villages Details' panel.",
				"SU-T40");

		// SU-T42-->To verify that user can select the option under the "Command Area"
		// drop down.

		// -->Click on the "command area" drop down and select one command area
		String exp_option_name = "Ujjain";
		new_village_details_panel.clickandSelectOptionFromCommnadAreaDropDown(exp_option_name);
		// get the command area selected options
		String acutal_selected_option = new_village_details_panel.getSelctedOptionFromCommandAreaDropDown();
		// validate the selcted command area is visble
		asert.assertEquals(acutal_selected_option, exp_option_name,
				"To verify that user can select  the option under the 'Command Area' drop down.", "SU-T42");

		// SU-T1080-->To verify that "District" drop down should be visible in the "New
		// Villages Details" panel.

		// -> Check "District" drop down is visible
		String actualDistrictDropDownName = new_village_details_panel.getDistrictDropDownName();
		asert.assertEquals(actualDistrictDropDownName, "District *",
				"To verify that 'District' dropdown should be visible under the 'New Villages Details'  panel. ",
				"SU-T1080");

		// SU-T45-->To verify that "village name" text field should be visible in the
		// "New Villages Details" panel.

		// Validate "Village Name" text field should be visible
		String actualVillageNameTextFieldName = new_village_details_panel.getVillageNameTextFieldName();
		asert.assertEquals(actualVillageNameTextFieldName, "Village Name *",
				"To verify that 'village name' text field should be visible in the 'New Villages Details'  panel.",
				"SU-T45");

		// SU-T46-->To ensure that the "village name" text field accepts only alphabetic
		// characters and no other characters.

		// ->Enter a valid village name like only alphabetes
		String validVillageName = AwtUtilities.genrateRandomAlphaBets(1, 5);
		// ->Enter a valid village name in village name text field
		new_village_details_panel.enterVillageName(validVillageName);
		// -> Take the actual entered value from "village" name text field
		String actualVillageTextFieldlValue = new_village_details_panel.getVillageNameTextFieldValue();
		// Ensure that it's should accept valid values
		asert.assertEquals(actualVillageTextFieldlValue, validVillageName,
				"To ensure that the 'village name' text field accepts only alphabetic characters and no other characters.",
				"SU-T46");
		// -> Enter a Invalid Village name
		String inValidVillageName = AwtUtilities.genrateRandomAlphaBets(1, 5) + AwtUtilities.genrateRandomNumber(3);
		new_village_details_panel.enterVillageName(inValidVillageName);
		// -> Take the acutal value from village name text field
		actualVillageTextFieldlValue = new_village_details_panel.getVillageNameTextFieldValue();
		// Ensure That It's should not accept the "invalid" values
		asert.assertNotEquals(actualVillageTextFieldlValue, inValidVillageName,
				"To ensure that the 'village name' text field accepts only alphabetic characters and no other characters.",
				"SU-T46");

		// SU-T47-->To verify that "village name" text field should not exceed more than
		// 30 characters

		// --> Enter a more than 30 character village name
		inValidVillageName = AwtUtilities.genrateRandomAlphaBets(31);
		new_village_details_panel.enterVillageArea(inValidVillageName);
		// Get the actual value from village are text field
		actualVillageTextFieldlValue = new_village_details_panel.getVillageNameTextFieldValue();
		// It's should not accept more than 30 character
		asert.assertNotEquals(actualVillageTextFieldlValue, inValidVillageName,
				"To verify that 'village name' text field should not exceed more than 30 characters", "SU-T47");

		// SU-T48-->To verify that "village name" text field should accept minimum 2
		// characters

		// --> Enter a 2 character village Name
		validVillageName = AwtUtilities.genrateRandomAlphaBets(2);
		new_village_details_panel.enterVillageName(validVillageName);
		// Vaildate the error message
		asert.assertNotEquals(
				new_village_details_panel.getErrorMessageFromTheField(new_village_details_panel.village_name),
				"Village Name must be at least 2 characters.",
				"To verify that 'village name' text field should accept minimum 2 characters", "SU-T48");

		// SU-T49-->To verify that "village name" text field should not accept less than
		// 2 characters.

		// -> Enter less than 2 character village name
		inValidVillageName = AwtUtilities.genrateRandomAlphaBets(1);
		new_village_details_panel.enterVillageName(inValidVillageName);
		// ->Click on "Add Village" button
		new_village_details_panel.clickOnAddVillageButton();
		// It shoud not accept and error message should be visible
		asert.assertEquals(
				new_village_details_panel.getErrorMessageFromTheField(new_village_details_panel.village_name),
				"Village Name must be at least 2 characters.",
				"To verify that 'village name' text field should not accept less than 2 characters.", "SU-T49");

		// SU-T50-->To verify that "village area" text field should be visible in the
		// "New Villages Details" panel.

		// -> Validate the village area text field is visible or not
		String actualVillageAreaTextFieldName = new_village_details_panel.getVillageAreaTextFieldName();
		asert.assertEquals(actualVillageAreaTextFieldName, "Village Area (Ha) *",
				"To verify that 'village area' text field should be visible in the 'New Villages Details'  panel.",
				"SU-T50");

		// SU-T51-->To verify that "village area" text field should accepts only the
		// integer, decimal and positive values.

		// -> First Enter a Integer Values
		String intValues = AwtUtilities.genrateRandomNumber(2);
		new_village_details_panel.enterVillageArea(intValues);
		// It should accept int values
		asert.assertEquals(new_village_details_panel.getVillageAreaTextFieldValue(), intValues,
				"To verify that 'village area' text field should accepts only the integer, decimal and positive values.",
				"SU-T51");

		// ->Then Enter a Decimal Values
		String decimalValues = AwtUtilities.genrateRandomNumber(2) + 0.2;
		new_village_details_panel.enterVillageArea(decimalValues);
		// It should accept decimal values
		asert.assertEquals(new_village_details_panel.getVillageAreaTextFieldValue(), decimalValues,
				"To verify that 'village area' text field should accepts only the integer, decimal and positive values.",
				"SU-T51");

		// SU-T52-->To verify that "village area" text field should not accept the
		// alphabets and negative numbers.

		// -> Enter a alphabetes only
		String invalid_village_Area = AwtUtilities.genrateRandomAlphaBets(1, 3);
		new_village_details_panel.enterVillageArea(invalid_village_Area);
		// it should not accept alphabets
		asert.assertNotEquals(new_village_details_panel.getVillageAreaTextFieldValue(), invalid_village_Area,
				"To verify that 'village area' text field should not accept the alphabets  numbers.", "SU-T52");

		// SU-T52-->To verify that 'village area' text field should not accept the
		// alphabets and negative numbers.

		// -> Enter a negative numbers
		String negativeNumber = "-" + AwtUtilities.genrateRandomNumber(2);
		new_village_details_panel.enterVillageArea(negativeNumber);
		// it should not accept negativ numbers
		asert.assertNotEquals(new_village_details_panel.getVillageAreaTextFieldValue(), negativeNumber,
				"To verify that 'village area' text field should not accept the alphabets  numbers.", "SU-T52");

		// SU-T53--> To verify that "Contact Person" text field should be visible in the
		// "New Villages Details" panel.

		// ->Check the visiblity of "contact person text field
		String actualContactPersonTextFieldName = new_village_details_panel.getContactPersonTextFieldName();
		// it should be visible
		asert.assertEquals(actualContactPersonTextFieldName, "Contact Person",
				"To verify that 'Contact Person' text field should be visible in the 'New Villages Details'  panel.",
				"SU-T53");

		// SU-T54-->To verify that "Contact Person" text field should accepts alphabets
		// and space.

		// ->Enter a Alphabeted and Space
		String validContactPersonName = AwtUtilities.genrateRandomAlphaBets(1, 4) + " "
				+ AwtUtilities.genrateRandomAlphaBets(1, 4);
		new_village_details_panel.enterContactPersonName(validContactPersonName);
		// it should be accept
		asert.assertEquals(new_village_details_panel.getContactPesronTextFieldValue(), validContactPersonName,
				"To verify that 'Contact Person' text field should accepts  alphabets and space.", "SU-T54");

		// SU-T55-->To verify that "Contact Person" text field should not accepts other
		// than the alphabets and space

		// -> Enter a numeric values
		String num_value = AwtUtilities.genrateRandomNumber(5);
		new_village_details_panel.enterContactPersonName(num_value);
		// it should not accept
		asert.assertNotEquals(new_village_details_panel.getContactPesronTextFieldValue(), num_value,
				"To verify that 'Contact Person' text field should not accepts other than alphabets and space.",
				"SU-T55");

		// SU-T56-->To verify that "Contact Person" text field should not exceed more
		// than 30 characters.

		// Enter a more than 30 character
		String inValidContactPerson = AwtUtilities.genrateRandomAlphaBets(32);
		new_village_details_panel.enterContactPersonName(inValidContactPerson);
		// it should not accept more than 30 character
		asert.assertNotEquals(new_village_details_panel.getContactPesronTextFieldValue(), inValidContactPerson,
				"To verify that 'Contact Person' text field should not exceed more than 30 characters.", "SU-T56");

		// SU-T58-->To verify that "Contact Number" text field should be visible in the
		// "New Villages Details" panel.

		// -> Ensure that contact number text field is visible or not
		String actualContactNumberTextFieldVisible = new_village_details_panel.getContactNumberTextFieldsName();
		asert.assertEquals(actualContactNumberTextFieldVisible, "Contact Number",
				"To verify that 'Contact Number' text field should be visible in the 'New Villages Details'  panel.",
				"SU-T58");

		// SU-T59-->To verify that "Contact Number" text field should accept only the 10
		// digit numbers

		// -> Enter only 10 digit number
		String validContactNumber = AwtUtilities.genrateRandomNumber(10);
		new_village_details_panel.enterContactNumber(validContactNumber);
		// -> it should accept 10 digit number
		asert.assertEquals(new_village_details_panel.getContactNumberTextFieldValue(), validContactNumber,
				"To verify that 'Contact Number' text field should accept only the 10 digit numbers", "SU-T59");

		// SU-T60-->To verify that "Contact Number" text field should not accept the
		// alphabets, special characters and negative numbers.

		// ->Enter alphabets
		String inValidContactNumber = AwtUtilities.genrateRandomAlphaBets(1, 5);
		new_village_details_panel.enterContactNumber(inValidContactNumber);
		// -> it should not accept alphabets
		asert.assertNotEquals(new_village_details_panel.getContactNumberTextFieldValue(), inValidContactNumber,
				"To verify that 'Contact Number' text field should not accept the alphabets.", "SU-T60");

		// -> Enter a special Character
		inValidContactNumber = "$%^**%";
		new_village_details_panel.enterContactNumber(inValidContactNumber);
		// -> it should not accept special character
		asert.assertNotEquals(new_village_details_panel.getContactNumberTextFieldValue(), inValidContactNumber,
				"To verify that 'Contact Number' text field should not accept the special character.", "SU-T60");

		// -> Enter a negative numbers
		inValidContactNumber = "-" + AwtUtilities.genrateRandomNumber(10);
		new_village_details_panel.enterContactNumber(inValidContactNumber);
		// -> it should not accept special character
		asert.assertNotEquals(new_village_details_panel.getContactNumberTextFieldValue(), inValidContactNumber,
				"To verify that 'Contact Number' text field should not accept the negative numbers.", "SU-T60");

		// SU-T61-->To verify that "Add Village" button should be visible in the "New
		// Villages Details" panel.

		// Check the visibility of "Add Village" button
		boolean isAddVillageButtonVisible = new_village_details_panel.isAddVillageButtonVisible();
		asert.assertTrue(isAddVillageButtonVisible,
				"To verify that 'Add Village' button  should be visible in the 'New Villages Details'  panel.",
				"SU-T61");

		// SU-T62-->To verify that "Clear" button should be visible in the "New Villages
		// Details" panel.

		// Check the visiblity of clear button
		boolean isClearButtonVisible = new_village_details_panel.isClearButtonVisible();
		asert.assertTrue(isClearButtonVisible,
				"To verify that 'Clear' button  should be visible in the 'New Villages Details'  panel.", "SU-T62");

		// SU-T63-->To verify the functionality of the "Clear" button

		// Select the command area
		String command_area = "Bhopal";
		new_village_details_panel.clickandSelectOptionFromCommnadAreaDropDown(command_area);
		// click on clear button
		new_village_details_panel.clickOnClearButton();
		// selcted command area should not be visible
		String actual_command_area = new_village_details_panel.getCommandAreaDropDownName();
		asert.assertEquals(actual_command_area, command_area, "To verify the functionality of the  Clear button",
				"SU-T63");

		// SU-T78-->To verify that created villages should be visible in the "Village
		// Details" table

		//-> Enter the village details
		command_area = ExcelOperations.getCellData("Add_View_Village_Details", "Command Area", "SU-T78");
		String district = ExcelOperations.getCellData("Add_View_Village_Details", "District", "SU-T78");
		village_name = ExcelOperations.getCellData("Add_View_Village_Details", "Village Name", "SU-T78");
		String village_area = ExcelOperations.getCellData("Add_View_Village_Details", "Village Area", "SU-T78");
		String contact_person = ExcelOperations.getCellData("Add_View_Village_Details", "Contact Person", "SU-T78");
		String contact_number = ExcelOperations.getCellData("Add_View_Village_Details", "Contact Number", "SU-T78");
		new_village_details_panel.enterAllVillageDetails(command_area, district, village_name, village_area,
				contact_person, contact_number);
		//-> Click on "Add Village" button
		new_village_details_panel.clickOnAddVillageButton();
		//-> Wait
		Thread.sleep(2000);
		//-> Refersh the page
		DriverFactory.iuiDriver().getDriver().navigate().refresh();
		//-> Move to the village details table and ensure the created village details
		// visible
		String actual_village_name = village_details_page.getVillageDetailTableValue("Village Name", village_name);
		asert.assertEquals(actual_village_name, village_name,
				"To verify that created villages should be visible in the 'Village Details' table", "SU-T78");

	}

	/**
	 * This method is used to verify the village details table
	 * @throws InterruptedException 
	 */
	public void verifyVillageDetailsTable() throws InterruptedException {

		// SU-T64-->To verify that columns like "S.NO, Command Area, District, Village
		// Name, Village Area(Ha), Contact Person, Contact Number and Action" should be
		// present in the "Villages Details" table.

		// -> Expected column name
		String[] exp_column_names = { "S.No", "District Name", "Command Area", "Village Name", "Village Area (Ha)",
				"Contact Person", "Contact Number", "Actions" };
		// -> Get the actual column names
		List<String> acutal_coulmn_name = village_details_page.getVillageDetailsTableColumnName();
		// -> Both column name should be match
		asert.assertEquals(acutal_coulmn_name, new ArrayList<String>(Arrays.asList(exp_column_names)),
				"To verify that columns like 'S.NO, Command Area, District, Village Name, Village Area(Ha), Contact Person, Contact Number and Action' should be present in the 'Villages Details' table.",
				"SU-T64");

		// SU-T68-->To verify that "edit" and "delete" button should be visible in the
		// "Action" column

		// -> Check the visiblity of "edit" button
		boolean isEditButtonVisible = village_details_page.isEditButtonIsVisible();
		asert.assertTrue(isEditButtonVisible, "To verify that 'edit' button should be visible in the 'Action' column",
				"SU-T68");
		// -> Check th visibility of "Delete" button
		boolean isDeleteButtonVisible = village_details_page.isDeleteButtonIsVisible();
		asert.assertTrue(isDeleteButtonVisible,
				"To verify that 'delete' button should be visible in the 'Action' column", "SU-T68");

		// SU-T69-->To verify that user can delete the record from the "Village details"
		// table

		// ->Delete the create project
		village_details_page.clickOnDeleteButton(village_name);
		// Vilage name should not be visible in "Village Details" table
		String actual_village_name = village_details_page.getVillageDetailTableValue("Village Name", village_name);
		asert.assertNotEquals(actual_village_name, village_name,
				"To verify that user can delete the record from the 'Village details' table", "SU-T69");

		// SU-T70-->To verify that "Rows per page" drop down button should be visible
		// under the "Village Details" table.

		// ->Check Rows Per Page dropdown is visible or not
		boolean isRowsPerPageButton = village_details_page.isRowsPerPageDropDownIsVisible();
		asert.assertTrue(isRowsPerPageButton,
				"To verify that Rows per page drop down button should be visible under the Role Detailstable.",
				"SU-T70");

		// SU-T71-->To verify that changing the number of rows in the "Rows per page"
		// drop down, updates the table accordingly.
		boolean isTableUpdated = village_details_page.isUpdateTheTable("10");
		asert.assertTrue(isTableUpdated,
				"To verify that changing the numbers of rows per page drop down , updates the table accordingly",
				"SU-T71");

		// SU-T1329-->To verify that 'First', 'Previous' ,'Next" and 'Last' Pagination
		// button should be visible under the "Village Details" table.

		// -> check the first pagination button
		boolean isFirsPaginationButtonVisible = village_details_page.isFirstPaginationButtonIsVisible();
		asert.assertTrue(isFirsPaginationButtonVisible, "To veify First Pagination Button Should Be Visible",
				"SU-T1329");
		// -> check next pagination button is visible
		boolean isNextPaginationButtonVisible = village_details_page.isNextPaginationButtonIsVisible();
		asert.assertTrue(isNextPaginationButtonVisible, "To veify Next Pagination Button Should Be Visible",
				"SU-T1329");
		// -> check previous pagination button is visible
		boolean isPreviousPaginationButtonVisible = village_details_page.isPreviousPaginationButtonIsVisible();
		asert.assertTrue(isPreviousPaginationButtonVisible, "To veify Previous Pagination Button Should Be Visible",
				"SU-T1329");
		// -> check last pagination button is visible
		boolean isLastPaginationButtonVisible = village_details_page.isLastPaginationButtonIsVisible();
		asert.assertTrue(isLastPaginationButtonVisible, "To veify Last Pagination Button Should Be Visible",
				"SU-T1329");

		// SU-T72-->To verify that "Export" drop down should be visible in the "Villages
		// Details" table

		// -> check the visibility of export button
		boolean isExportButtonIsVisible = village_details_page.isExportButtonIsVisible();
		asert.assertTrue(isExportButtonIsVisible,
				"To verify that 'Export' drop down should be visible in the 'Villages Details' table", "SU-T72");

		// SU-T73-->To verify that "pdf" and "excel" button should present in the
		// "Export" drop down

		// -> Click on the "Export" button
		village_details_page.clickOnExportButton();
		// ->Then check the "pdf" button is visible or not
		boolean isPdfButtonIsVisible = village_details_page.isPdfButtonVisible();
		asert.assertTrue(isPdfButtonIsVisible, "To verify that 'pdf' button should present in the Export Drop Down",
				"SU-T73");

		// ->Then check the "pdf" button is visible or not
		boolean isExcelButtonIsVisible = village_details_page.isExcelButtonVisible();
		asert.assertTrue(isExcelButtonIsVisible, "To verify that 'pdf' button should present in the Export Drop Down",
				"SU-T73");

		// SU-T74-->To verify that user should able to download the 'pdf' file
		// -> click on "pdf" button
		village_details_page.selectExportOptions("pdf");
		//wait 
		Thread.sleep(5000);
		// ->Check Pdf File is Downloaded Or Not
		boolean isFileDownloaded = AwtUtilities.isDownloadedFileVisible(
				ExcelOperations.getCellData("Add_View_Village_Details", "Command Area", "SU-T74"));
		asert.assertTrue(isFileDownloaded, "To verify that user should able to download the 'pdf' file", "SU-T74");
		// -> delete the file
		AwtUtilities.deleteFile(ExcelOperations.getCellData("Add_View_Village_Details", "Command Area", "SU-T74"));

	}

}
