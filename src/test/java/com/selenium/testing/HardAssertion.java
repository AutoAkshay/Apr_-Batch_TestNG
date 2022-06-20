package com.selenium.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class HardAssertion {
	
	WebDriver w;

	@BeforeTest
	public void openBrowser() 
	{

		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();
	}

	@Test(priority = 0, description = "Verify Login Page Functionality")
	public void verifyLoginPage() throws Exception {

		w.get("http://demo.testfire.net/login.jsp");

		String loginPageTitle = w.getTitle();
		Assert.assertEquals(loginPageTitle, "Altoro Mutual");

		String loginPageURL = w.getCurrentUrl();
		Assert.assertTrue(loginPageURL.contains("login"), "Login Page url doesn't contains login");

		WebElement loginPageLabel = w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
		String loginPageLabelText = loginPageLabel.getText();
		Assert.assertTrue(loginPageLabelText.contains("Login"), "Login Label is different");

		WebElement loginButton = w.findElement(By.name("btnSubmit"));
		Assert.assertTrue(loginButton.isDisplayed(), "Login Button not present ");

		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.name("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();

	}

	@Test(priority = 1, description = "Verify Home Page Functionality", dependsOnMethods = "verifyLoginPage")
	public void verifyHomePage() throws Exception 
	{

		String homePageTitle = w.getTitle();
		Assert.assertEquals(homePageTitle, "Altoro Mutual");

		WebElement homePageLabel = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
		String homePageLabelText = homePageLabel.getText();
		Assert.assertTrue(homePageLabelText.contains("Admin"), "home page Label is different");

		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
	}

	@AfterTest
	public void closeBrowser() 
	{

		w.close();
	}

}

