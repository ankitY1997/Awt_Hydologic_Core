package com.awt.page.User.AdminConfiguration.Settings.MasterCreation;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class UserDefinedModeMasterPanel extends SystemModeMasterPanel {

	// **Constructor**/
	public UserDefinedModeMasterPanel(WebDriver driver) {
		super(driver);
	}

	/**
	 * By this method we can get panel name
	 * 
	 * @return
	 */
	public String getUserDefinedMasterPanelName() {
		action.isDisplay(panel_name);
		return action.getText(panel_name);
	}

}
