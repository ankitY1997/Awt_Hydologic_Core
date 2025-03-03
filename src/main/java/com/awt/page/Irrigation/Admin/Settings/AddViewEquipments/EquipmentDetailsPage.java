package com.awt.page.Irrigation.Admin.Settings.AddViewEquipments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awt.page.Irrigation.Admin.AdminDashboardPage;

public class EquipmentDetailsPage extends AdminDashboardPage {

	// ***Xpath for new button***/
	@FindBy(xpath = "//button[@aria-label='New']")
	public WebElement new_button;

	// ***Custom Consturctor***//
	public EquipmentDetailsPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * With help of this method we can check the visibility of "Add/View Equipment"
	 * option
	 * 
	 * @return {if it's visible it will return "true" otherwise it will return
	 *         "false"}
	 */
	public boolean isAddViewEquipmentOptionVisible() {
		return AdminDashboardPage.flag;
	}

	/**
	 * By this method we can get current page url
	 * 
	 * @return {url of equipment details page}
	 */
	public String getEquipementDetailsPageName() {
		return action.getUrl(driver).trim();
	}

	/**
	 * By this method we can get to know the visibility of "new" button
	 * 
	 * @return {if new button is visible then it's return true otherwise it's return
	 *         false}
	 */
	public boolean isNewButtonVisible() {
		action.waitForVisibility(new_button, action.implicit_wait);
		return action.isDisplay(new_button);
	}

	
	/**
	 * By this method we can click on "New" button
	 */
	public void clickOnNewButton() {
		action.waitForVisibility(new_button, action.implicit_wait);
		action.clickOn(new_button, "New");
	}
	
	/**
	 * By this method we can navigate to the "NewEquipmentDetailsPanel"
	 *  
	 * @return {instance of NewEquipmentsDetailsPanel}
	 */
	public NewEquipmentsDetailsPanel clickOnNewButtonAndNavigateToNewEquipmentDetailsPanel() {
		// wait for new button
		action.waitForVisibility(new_button, action.implicit_wait);
		// click on "new" button
		action.clickOn(new_button, "New");
		return new NewEquipmentsDetailsPanel(driver);
	}
	
	
	

}
