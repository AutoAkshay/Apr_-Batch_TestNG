package com.selenium.basictest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Practice_Part_1 {

	
	public static void main(String[] args) throws Exception 
	
	{
		DataFormatter df= new DataFormatter();
		
		FileInputStream fin=new FileInputStream(".\\TestDataaa\\FDCal.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		
		XSSFSheet st=wb.getSheetAt(0);
		
		XSSFRow row=st.getRow(3);
		
		XSSFCell cell=row.getCell(0);
		
		System.out.println(cell);
	}

	
}