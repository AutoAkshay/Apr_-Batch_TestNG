package com.selenium.pageobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	WebDriver w;

	public void openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			w = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			w = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			w = new EdgeDriver();
		}

		w.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void closeBrowser() {
		w.close();
	}

	public void openApplicationURL(String url) {

		w.get(url);
	}

	public void handleInputText(WebElement we, String inputText) {

		we.clear();
		we.sendKeys(inputText);

	}

	public void handleClickEvent(WebElement we) {
		we.click();
	}

	public void handleDropDown(WebElement we, String inputText) {

		Select sc = new Select(we);
		sc.selectByVisibleText(inputText);

	}

	public void waitForSec(int sec) throws Exception {

		Thread.sleep(sec * 1000);

	}

	public String ReadDataFromPropertiesFile(String key) throws Exception {

		FileInputStream fi = new FileInputStream(".\\Config\\config.properties");

		Properties prop = new Properties();
		prop.load(fi);
		
		String value=prop.getProperty(key);
		

		fi.close();
		
		return value;

	}

}
