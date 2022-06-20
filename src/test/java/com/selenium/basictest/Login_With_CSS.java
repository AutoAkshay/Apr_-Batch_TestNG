package com.selenium.basictest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_With_CSS 

{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver",".\\Browser_Driver\\chromedriver.exe");
		
		WebDriver w= new ChromeDriver();
		
	
//		
		//Open the URL
		w.get("https://opensource-demo.orangehrmlive.com/");
		
		//Give the user id
		w.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
		
		//Give the password
		w.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		
		//Press the login key
		w.findElement(By.cssSelector("input.button")).click();
		
		Thread.sleep(3000);

		w.findElement(By.id("welcome")).click(); 
		
		Thread.sleep(3000);
		
		w.findElement(By.linkText("Logout")).click(); 
		
		w.close();
		
		System.out.println("Test is successful");
	}
}
