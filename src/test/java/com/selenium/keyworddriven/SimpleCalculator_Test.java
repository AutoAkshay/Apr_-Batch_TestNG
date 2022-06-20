package com.selenium.keyworddriven;

import org.testng.annotations.Test;

import com.selenium.pageobject.SimpleCalculator_PageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SimpleCalculator_Test {

	SimpleCalculator_PageObject calc;

	@BeforeTest
	public void beforeTest() {

		calc = new SimpleCalculator_PageObject();
		calc.openBrowser("edge");
		calc.callPageFactory();
		

	}

	@Test(priority = 0, description = "Addition ")
	public void Add() throws Exception {
		
		calc.openApplicationURL(calc.ReadDataFromPropertiesFile("url_simple_calculator"));
		
		calc.handleInputText(calc.firstNumberTextBox, "10");
		
		calc.handleDropDown(calc.operatorDropDown, "+");
		
		calc.handleInputText(calc.secondNumberTextBox, "8");
		
		calc.handleClickEvent(calc.goBtn);

		calc.waitForSec(3);
		
	}
	
	@Test(priority = 1, description = "Subtraction ")
	public void sub() throws Exception {
		
	calc.openApplicationURL(calc.ReadDataFromPropertiesFile("url_simple_calculator"));
		
		calc.handleInputText(calc.firstNumberTextBox, "8");
		
		calc.handleDropDown(calc.operatorDropDown, "-");
		
		calc.handleInputText(calc.secondNumberTextBox, "2");
		
		calc.handleClickEvent(calc.goBtn);

		calc.waitForSec(3);

	}

	@AfterTest
	public void afterTest() {
		calc.closeBrowser();
	}

}
