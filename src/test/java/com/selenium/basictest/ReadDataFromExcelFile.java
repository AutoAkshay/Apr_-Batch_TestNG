package com.selenium.basictest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws Exception 
	
	{
		//File Excel->WorkBook->Sheet->Rows->Cells->Data 
		
		DataFormatter df= new DataFormatter();
		
		FileInputStream fin= new FileInputStream (".\\TestDataaa\\FDCal.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		
		XSSFSheet st=wb.getSheetAt(0);
		
		XSSFRow row=st.getRow(2);
		
		XSSFCell cell=row.getCell(0);
		
		System.out.println(df.formatCellValue(cell));
		
		int rowCount=st.getLastRowNum();
		
		System.out.println(rowCount);
		

	}


}
