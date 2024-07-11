package com.awt.page.oms_dashboard;



import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.awt.utills.reusablecomponents.ActionEngine;

public class DashboardPage {
	/** web driver instance */
	WebDriver driver;
	/** action Engine Instance variable **/
	ActionEngine action;

	/** constructor */
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		action = new ActionEngine(driver);
		PageFactory.initElements(driver, this);

	}

	/**
	 * this methods return the count of oms details panel
	 *
	 * @param textName
	 * @return count of oms details panel
	 */
	public int getTheCountOfOmsDetailsPanel(String textName) {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		map.put("Total OMS", 1);
		map.put("Total Command Area (Ha)", 2);
		map.put("Total Village", 3);
		map.put("Benefited Farmers", 4);
		map.put("Total Panchayat ", 5);

		String count = driver
				.findElement(
						By.xpath("(//h6[text()='Total OMS']/../following-sibling::div/h6)[" + map.get(textName) + "]"))
				.getText().trim();
		return Integer.parseInt(count);
	}

}
