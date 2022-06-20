package com.selenium.testing;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import org.apache.hc.core5.reactor.Command.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SoftAssertion_practice {
	
	WebDriver w;
	SoftAssert sft;
 
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");	 
	  w=new ChromeDriver();
  }
  
  @Test (priority=0,description="Verify Login page Lvel functionality")
  public void VerifyLogin() {
	  
	  sft=new SoftAssert();
	  
	  w.get("http://demo.testfire.net/login.jsp");
		
	  String url=w.getCurrentUrl();
	  sft.assertTrue(url.contains("login"),"Different lable");
	  
	  String title=w.getTitle();
	  sft.assertEquals(title, "Altoro Mutual");
	  
	  WebElement OnlineBankingLogin=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
	  sft.assertTrue(OnlineBankingLogin.isDisplayed(), "Not shown");
	
	  String Loginbuttontext= w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).getText();
	  
	   WebElement Loginbutton=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
	   String validate=Loginbutton.getText();
	   sft.assertTrue(validate.contains("Online Banking Login"), "Not displayed");
	  
	   String loginPageTitle = w.getTitle();
	   sft.assertEquals(loginPageTitle,"Altoro Mutual");


		w.findElement(By.id("uid")).sendKeys("admin");
		
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		
		sft.assertAll();
  }
  
  @Test(priority=1,description="Verify Main page Lvel functionality")
  public void VerifyMainPage() throws Exception {

		Thread.sleep(3000);
		
		String title=w.getTitle();
		sft.assertEquals(title, "Altoro Mutual");
		
		WebElement hello= w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
		sft.assertTrue(hello.isDisplayed(), "Not Displayes");
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();	
		
		sft.assertAll();
		
  }
  
  @AfterTest
  public void afterTest() {
	  w.close();
  }

}
