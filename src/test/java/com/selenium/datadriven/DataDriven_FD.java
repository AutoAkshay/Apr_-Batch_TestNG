package com.selenium.datadriven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DataDriven_FD {
 
	  WebDriver w;
	  
	    DataFormatter df;
		FileInputStream fin;
		XSSFWorkbook wb;
		XSSFSheet st;
		XSSFRow row;
		XSSFCell principle,ROI,period,frequencyValue;
	  
	  
	  @BeforeTest
	  public void beforeTest() throws Exception 
	  {
		  WebDriverManager.chromedriver().setup();
		  w=new ChromeDriver();
		 
		    df= new DataFormatter();
			fin= new FileInputStream (".\\TestDataaa\\FDCal.xlsx");
			wb=new XSSFWorkbook(fin);
			st=wb.getSheetAt(0);
	  }
	  
	  @Test
	  public void fd_Drivrn() throws Exception 
	  
	  {
		 int rowCount=st.getLastRowNum(); 
		 for(int i=1;i<=rowCount;i++)
		 {
			 row=st.getRow(i);
			 principle=row.getCell(0);
			 ROI=row.getCell(1);
			 period=row.getCell(2);
			 frequencyValue=row.getCell(3);
			 
			 
		 w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		 
		 w.findElement(By.id("principal")).sendKeys(df.formatCellValue(principle).toString());
		 w.findElement(By.id("interest")).sendKeys(df.formatCellValue(ROI).toString());
		 w.findElement(By.id("tenure")).sendKeys(df.formatCellValue(period).toString());
		 
		 Select sc;
		 
		 WebElement tenurePeriod=w.findElement(By.id("tenurePeriod"));
		 sc=new Select(tenurePeriod);
		 sc.selectByVisibleText("year(s)");
		 
		 WebElement frequency=w.findElement(By.id("frequency"));
		 sc=new Select(frequency);
		 sc.selectByVisibleText(df.formatCellValue(frequencyValue));
		 
		 Thread.sleep(2000);
		 w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();	 
		 Thread.sleep(2000);
		 }
		 
	  }
	
	  @AfterTest
	  public void afterTest() 
	  
	  {
		  w.quit();
	  }
	
	}
