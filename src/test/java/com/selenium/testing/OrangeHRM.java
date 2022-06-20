package com.selenium.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM {
	WebDriver w;
  
  @BeforeTest
  public void preCoonditionBeforeTestExecution() 
  {
	  System.setProperty("webdriver.chrome.driver",".\\Browser_Driver\\chromedriver.exe");
		
		w= new ChromeDriver();
  }
  
  @Test
  public void LoginAdminUser() throws Exception
  {
	  w.get("https://opensource-demo.orangehrmlive.com/");
		
		//Give the user id
		w.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
		
		//Give the password
		w.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		
		//Press the login key
		w.findElement(By.cssSelector("input.button")).click();
		
		Thread.sleep(3000);

		w.findElement(By.linkText("Welcome 123568")).click(); 
		
		Thread.sleep(3000);
		
		w.findElement(By.linkText("Logout")).click(); 
		
		
  }

  @AfterTest
  public void postCoonditionAfterTestExecution()
  {
	  w.close();
  }

}
