package com.selenium.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginMutualFund {
	
	WebDriver w;
 
  @BeforeTest
  public void preCoonditionBeforeTestExecution() {
	  
	  System.setProperty("webdriver.chrome.driver",".\\Browser_Driver\\chromedriver.exe");
		
	  w= new ChromeDriver();
	  
  }
  
  @Test (priority=1, description ="Test case to verify login functionality using admin user")
  public void logiinAdminUser()  throws Exception {
	  
	  w.get("http://demo.testfire.net/login.jsp");
		
		w.findElement(By.id("uid")).sendKeys("admin");
		
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
  }
  
  @Test (priority=0, description ="Test case to verify login functionality using test user",dependsOnMethods="logiinAdminUser",groups="Login",invocationCount=3,enabled=false)
  public void logiinTestUser()  throws Exception {
	  
	  w.get("http://demo.testfire.net/login.jsp");
		
		w.findElement(By.id("uid")).sendKeys("tuser");
		
		w.findElement(By.id("passw")).sendKeys("tuser");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
  }

  @Test (priority=2, description ="Test case to verify login functionality using JSmith user",dependsOnMethods="logiinAdminUser",groups="Login")
  public void logiinJSmithUser()  throws Exception {
	  
	  w.get("http://demo.testfire.net/login.jsp");
		
		w.findElement(By.id("uid")).sendKeys("Jsmith");
		
		w.findElement(By.id("passw")).sendKeys("Demo1234");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
  }
  @AfterTest
  public void postCoonditionAfterTestExecution() 
  
  {
	  
	  w.close();
	  
  }

}
