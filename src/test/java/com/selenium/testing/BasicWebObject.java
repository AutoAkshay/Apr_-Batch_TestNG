package com.selenium.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class BasicWebObject {
	
	WebDriver w;
	
	 @BeforeTest
	  public void OpenBrowser()
	 {
		 System.setProperty("webdriver.chrome.driver",".\\Browser_Driver\\chromedriver.exe");
			
			w= new ChromeDriver();
		  }
	  @Test 
	  public void HandleTextBox() 
	  {
		  w.get("http://demo.automationtesting.in/Register.html");
		  w.findElement(By.cssSelector("input[ng-model='FirstName']")).clear();
		  w.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("Steve");
		  
		  w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
		  w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Jones");
		  
		  
		  w.findElement(By.cssSelector("textarea[ng-model='Adress']")).clear();
		  w.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("Kasturi Homes");
	  }
	 
	  @Test (priority=1, description ="Handle Radio Button")
	  public void HandleRadioButton() 
	  {
		  w.findElement(By.cssSelector("input[value='Male']")).click();
	  }
	  
	  @Test (priority=2, description ="Handle Checkbox")
	  public void HandleCheckBox() 
	  {
		  w.findElement(By.id("checkbox1")).click();
		  w.findElement(By.id("checkbox3")).click();
	  }
	  
	  @Test (priority=3, description ="Handle Drop Down list")
	  public void HandleDropDown() 
	  {
		 WebElement SkillDropDown=w.findElement(By.id("Skills"));
		 Select sl=new Select(SkillDropDown);
		 
//		 sl.selectByIndex(9);
//		 sl.selectByVisibleText("Java");
//		 sl.selectByValue("Data Analytics");
		 
		 System.out.println("\nPrint Value from Drop-Down List : \n");
		 java.util.List<WebElement> valueFromDropDown=sl.getOptions();
		 
		 for (int i=0;i<valueFromDropDown.size();i++)
		 {
			 System.out.println(valueFromDropDown.get(i).getText());
		 }
		 
	     }
	
	@AfterTest
	  public void CloseBrowser() {
	  }

}
