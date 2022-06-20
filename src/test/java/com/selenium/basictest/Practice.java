package com.selenium.basictest;

import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practice {
	
	WebDriver w;

	@BeforeTest
	public void beforeTest() 
	
	{
		@SuppressWarnings("unused")
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w=new ChromeDriver();
		w.manage().window().maximize();
	}

	@Test
	public void Code_For_Alert_Test() throws Exception 
	
	{
		Actions a= new Actions(w);
		w.get("https://www.ebay.com/");
		
		WebElement electronics= w.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]"));
		
		a.moveToElement(electronics).build().perform();
		
		Thread.sleep(2000);
		
		w.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a")).click();
		
        
	}

	@AfterTest
	public void afterTest() {

		//w.quit();
	}

}
