package com.selenium.keyworddriven;

import org.testng.annotations.Test;

import com.selenium.pageobject.FixedDepositCalculator_PageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FixedDeposit_Test {
  
	FixedDepositCalculator_PageObject fd;
	
  @BeforeTest
  public void preCondition() {
	  
	  fd=new FixedDepositCalculator_PageObject();	  
	  fd.openBrowser("chrome");
	  fd.callPageFactory();
	  
  }
  
  
  @Test(priority = 0,description = "validate fixed deposit for 1 lakh")
  public void fd_1lakh() throws Exception {
	  
	  fd.openApplicationURL("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
	  fd.handleInputText(fd.Principal_TextBox, "100000");
	  fd.handleInputText(fd.interest_TextBox, "10.5");
	  fd.handleInputText(fd.tenure_TextBox, "3");
	  
	  fd.handleDropDown(fd.tenurePeriod_DropDown, "year(s)");
	  fd.handleDropDown(fd.frequency_DropDown, "Simple Interest");
	  
	  fd.handleClickEvent(fd.calculator_Btn);
	  
	  fd.waitForSec(3);
  }
  
  
  @Test(priority = 1,description = "validate fixed deposit for 4 lakh")
  public void fd_4lakh() throws Exception {
	  
	  fd.openApplicationURL("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
	  fd.handleInputText(fd.Principal_TextBox, "400000");
	  fd.handleInputText(fd.interest_TextBox, "8");
	  fd.handleInputText(fd.tenure_TextBox, "2");
	  
	  fd.handleDropDown(fd.tenurePeriod_DropDown, "year(s)");
	  fd.handleDropDown(fd.frequency_DropDown, "Simple Interest");
	  
	  fd.handleClickEvent(fd.calculator_Btn);
	  
	  fd.waitForSec(3);
  }


  @AfterTest
  public void postCondition() {
	  
	  fd.closeBrowser();
  }

}
