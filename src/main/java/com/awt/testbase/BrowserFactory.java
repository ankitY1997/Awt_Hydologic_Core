package com.awt.testbase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.awt.utills.reusablecomponents.PropertiesOperations;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	private WebDriver driver = null;

	public WebDriver createBrowserInstance(String browser_name) {
		switch (browser_name.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			// setting the some configuration at browser level
			ChromeOptions options = new ChromeOptions();
			List<String> config_list = new ArrayList<>();
			// for incongantive session
			// config_list.add("-incognito");
			config_list.add("--remote-allow-origins=*");
			options.addArguments(config_list);
			Map<String, Object> download_prefs = new HashMap<String, Object>();
			download_prefs.put("download.prompt_for_download", false); // Disable Save As prompt
			download_prefs.put("download.directory_upgrade", true);
			download_prefs.put("safebrowsing.enabled", false); // Disable Safe Browsing
			download_prefs.put("safebrowsing.disable_download_protection", true); // Allow all downloads
			download_prefs.put("download.default_directory",
					System.getProperty("user.dir") + PropertiesOperations.getPropertyValueByKey("File_Download_path"));
			options.setExperimentalOption("prefs", download_prefs);
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foptions = new FirefoxOptions();
			foptions.addArguments("-private");
			driver = new FirefoxDriver(foptions);
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions edge_options = new EdgeOptions();
			List<String> edge_config_list = new ArrayList<>();
			// for incongantive session
			edge_config_list.add("-incognito");
			edge_config_list.add("--remote-allow-origins=*");
			edge_options.addArguments(edge_config_list);
			driver = new EdgeDriver();
			break;
		default:
			break;

		}
		return this.driver;

	}

}
