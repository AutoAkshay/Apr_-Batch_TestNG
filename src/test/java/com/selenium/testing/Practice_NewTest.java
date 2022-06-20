package com.selenium.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Practice_NewTest  {
  
	 WebDriver w;
	 
  @BeforeClass
  public void preCoonditionBeforeTestExecution() 
  {
	 System.setProperty("webdriver.chrome.driver",".\\Browser_Driver\\chromedriver.exe");
	w= new ChromeDriver();
		
  }
  
  @Test (priority=0, description ="Test case to verify login functionality using test user")
  public void LoginAdminUser () throws Exception
  
  {
	  w.get("http://demo.testfire.net/login.jsp");
	  w.findElement(By.cssSelector("input#uid")).sendKeys("admin");
	  w.findElement(By.cssSelector("input[type='password']")).sendKeys("admin");
	  w.findElement(By.cssSelector("input[name='btnSubmit']")).click();
	  w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
	  
	  
  }
  
  @Test (priority=1, description ="2nd Test case to verify login functionality using tuser",dependsOnMethods="LoginAdminUser")
  public void Logintuser () throws Exception
  
  {
	  w.get("http://demo.testfire.net/login.jsp");
	  w.findElement(By.cssSelector("input#uid")).sendKeys("tuser");
	  w.findElement(By.cssSelector("input[type='password']")).sendKeys("tuser");
	  w.findElement(By.cssSelector("input[name='btnSubmit']")).click();
	  w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();  
  }
  
  @Test (priority=2, description ="3rd Test case to verify login functionality using Jsmith",dependsOnMethods="Logintuser",invocationCount=4)
  public void LoginJsmith () throws Exception
  
  {
	  w.get("http://demo.testfire.net/login.jsp");
	  w.findElement(By.cssSelector("input#uid")).sendKeys("Jsmith");
	  w.findElement(By.cssSelector("input[type='password']")).sendKeys("Demo1234");
	  w.findElement(By.cssSelector("input[name='btnSubmit']")).click();
	  w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();  
  }

  @AfterClass
  public void afterClass() 
  {
	  w.quit();
	  
	  System.out.println("Test is pass");
  }

}
