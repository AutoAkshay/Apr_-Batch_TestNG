package com.selenium.datadriven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DataDriver {
  
	WebDriver w;
	
  @DataProvider
  public Object[][] dp() 
  
  {
    return new Object[][] {
      new Object[] { "100000", "8","3","Simple Interest" },
      new Object[]  { "400000", "4","8","Simple Interest" },
      new Object[]  { "600000", "8.5","4","Simple Interest" },
      new Object[]  { "1000000", "7.5","2","Simple Interest" },
   };
    
    
  }
  @BeforeTest
  public void beforeTest() 
  {
	  WebDriverManager.chromedriver().setup();
	  w=new ChromeDriver();
  }

  @Test(dataProvider = "dp")
  public void f(String principle, String roi,String tenure,String frequency) throws Exception 
  {
	     w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		 
		 w.findElement(By.id("principal")).sendKeys(principle);
		 w.findElement(By.id("interest")).sendKeys(roi);
		 w.findElement(By.id("tenure")).sendKeys(tenure);
		 
		 Select sc;
		 
		 WebElement tenurePeriod=w.findElement(By.id("tenurePeriod"));
		 sc=new Select(tenurePeriod);
		 sc.selectByVisibleText("year(s)");
		 
		 WebElement frequencyDropDown=w.findElement(By.id("frequency"));
		 sc=new Select(frequencyDropDown);
		 sc.selectByVisibleText(frequency);
		 
		 Thread.sleep(2000);
		 w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();	 
		 Thread.sleep(2000);
  }
  
  
  @AfterTest
  public void afterTest()
  {
  w.quit();
  }

}
