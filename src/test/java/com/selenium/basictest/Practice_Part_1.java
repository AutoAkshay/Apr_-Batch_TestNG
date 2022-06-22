package com.selenium.basictest;

import java.awt.Desktop.Action;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Practice_Part_1 {
	
	WebDriver w;
	SoftAssert sft;
	@BeforeTest
	public void beforeTest() 
	
	{
		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w= new ChromeDriver();
		w.manage().window().maximize();
	}

	@Test
	public void Code_For_Alert_Test() throws Exception 
	
	{
		sft=new SoftAssert();
		Actions a=new Actions(w);
		
		w.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		w.navigate().refresh();
		
		String title= w.getTitle();
		sft.assertTrue(title.contains("Online"), "Not Page name doesn't contains online");
		
		
		
		WebElement name= w.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[1]/div/a[1]/img"));
		String label=name.getText();
		sft.assertTrue(label.contains("Flipkart"), "Not Contain");
		
		String login=w.getCurrentUrl();
		sft.assertTrue(login.contains("flipkart"), "Not Page url doesn't contains login");
		
		Thread.sleep(3000);
		
		w.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("78874028590");
		Thread.sleep(3000);
		a.sendKeys(Keys.BACK_SPACE).build().perform();
		a.sendKeys(Keys.TAB).build().perform();
		w.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("Akshay@123");
		w.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")).click();
		
		String projectPath = System.getProperty("user.dir");
		
		Thread.sleep(5000);
		
		String screenshotPath=projectPath +".\\Screenshot\\FlipkartPage.png";
		TakesScreenshot ts=(TakesScreenshot) w;	       
	       File f=ts.getScreenshotAs(OutputType.FILE);       
	       FileUtils.copyFile(f, new File(screenshotPath));
		
		
		sft.assertAll();	
	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}

//	public static void main(String[] args) throws Exception
	
	
	
//	{
//		
//		System.setProperty("webdriver.chrome.driver",".\\Browser_Driver\\chromedriver.exe");
//		WebDriver w=new ChromeDriver();
//		Actions a= new Actions(w);
//		w.get("https://www.flipkart.com/");
//		
//		Thread.sleep(3000);
//		
//		w.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("7887402859");
//		w.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("Akshay@123");
//		w.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")).click();
//		Thread.sleep(3000);
//		WebElement Akshay= w.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div"));
//		
//		Thread.sleep(2000);
//		
//		a.moveToElement(Akshay).build().perform();
//		
//		Thread.sleep(3000);
//		
//		System.out.println("Test is pass");
//		
//		
//
//	}


