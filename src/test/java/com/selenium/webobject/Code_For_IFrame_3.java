package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Code_For_IFrame_3 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+".\\Browser_Driver\\chromedriver.exe");
		w=new ChromeDriver();
		w.manage().window().maximize();

	}

	@Test
	public void Code_For_IFrame_Test() throws Exception{
		
		w.get("http://demo.automationtesting.in/Frames.html");
		
		WebElement frameInfo =w.findElement(By.id("singleframe"));
		
		w.switchTo().frame(frameInfo);
		
		w.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Selenium");
		
	}

	@AfterTest
	public void afterTest() {
	//	w.quit();
	}

}
