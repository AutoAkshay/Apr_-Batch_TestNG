package com.selenium.basictest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver",".\\Browser_Driver\\chromedriver.exe");
		
		WebDriver w= new ChromeDriver();
		
		w.get("http://demo.testfire.net/login.jsp");
		
		w.findElement(By.id("uid")).sendKeys("admin");
		
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
		
		w.close();
		
		System.out.println("Admin logged in and logged out successfully");

	}

}
