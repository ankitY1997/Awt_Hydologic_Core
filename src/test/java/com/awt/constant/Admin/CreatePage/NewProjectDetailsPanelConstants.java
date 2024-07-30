package com.awt.constant.Admin.CreatePage;

import java.util.Arrays;
import java.util.List;

public class NewProjectDetailsPanelConstants {

	// ** New Project Details Panel Constants For Excel File*********/

	public static final String xl_project_name = "Project Name";
	public static final String xl_client_name = "Client Name";
	public static final String xl_client_image_path = "Client Image Path";
	public static final String xl_consultant_name = "Consultant Name";
	public static final String xl_consultant_image_path = "Consultant Image Path";
	public static final String xl_licenses_key = "Licenses Key";
	public static final String xl_username = "Username";
	public static final String xl_password = "Password";
	public static final String xl_mobile_number = "Mobile number";
	public static final String xl_email_address = "Email Address";
	public static final String xl_start_date = "Start Date";
	public static final String xl_expected_date = "Expected Date";
	public static final String xl_actual_compeltion_date = "Actual Completion Date";
	public static final String xl_file_path = "File Path";

	/* FOr Dynamic X Path **/
	public static final String panel_project_name = "Project Name";
	public static final String email_id = "Email ID";
	public static final String mob_num = "Mobile Number";
	public static final String panel_UserName = "User Name";
	public static final String Panel_password = "Password";
	public static final String Panel_licenses_key = "License Key";
	public static final String Panel_module_name = "Module Name";
	public static final String panel_client_logo = "Client Logo";
	public static final String panel_consltant_logo = "Consultant Logo";
	public static final String panel_startDate="start_date";
	public static final String panel_ExpectedDate="expected_date";
	public static final String panel_actualCompletionDate="actual_completion_date";
	public static final String actual_end_date = "Actual End Date";
	public static final String file_name = "New_Poject_Details";
	public static final String due_days = "Due Days";
	public static final String[] module_name = { "OMS", "AMS" };
	public static final String panel_Name = "Panel Name";
	public static final String panel_Exp_End_Date = "Expected End Date ";
	public static final String panel_Act__Comp_Date = "Actual Completion Date ";
	
	

	/* Text field Error Message **/
	public static final String module_name_error_msg = "At least one module must be selected.";
	public static final String project_name_error_msg = "Project Name is required.";
	public static final String duplicate_project_name_error_msg = "Project Name must be unique.";
	public static final String client_name_error_msg = "Client Name is required.";
	public static final String upload_error_msg = "Invalid file format. Only PNG and JPG are allowed.";
	public static final String consultant_name_error_msg = "Consultant Name is required.";
	public static final String consultant_logo_error_msg = "Invalid file format. Only PNG and JPG are allowed.";
	public static final String client_Logo_error_msg = "Invalid file format. Only PNG and JPG are allowed.";
	public static final String license_key_error_msg = "License Key is required.";
	public static final String user_name_error_msg = "User Name is required.";
	public static final String duplicate_username_error_msg = "User Name must be unique.";
	public static final String password_error_msg = "Password is required.";
	public static final String less_password_error_msg="Password must be at least 3 characters long.";
	public static final String mobile_number_error_msg = "Mobile Number is required.";
	public static final String email_address_error_msg = "Email Address is required.";
	public static final String start_date_error_msg = "Start Date is required.";
	public static final String expected_date_error_msg = "Expected End Date is required.";
	public static final String actual_completion_date_error_msg = "Actual Completion Date is required.";

	// **List Of New Project Details Panel Fields */
	public static final List<String> list_field = Arrays.asList("Project Name *", "Client Name *", "Client Logo",
			"Consultant Name *", "Consultant Logo", "License Key *", "Module Name *", "User Name *", "Password *",
			"Mobile Number *", "Email Address *", "Start Date *", "Expected End Date *", "Actual Completion Date *");

}
