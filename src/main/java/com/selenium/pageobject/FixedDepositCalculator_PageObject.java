package com.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FixedDepositCalculator_PageObject extends TestBase {	
	

	@FindBy(id="principal")
	public WebElement Principal_TextBox;	
	
	@FindBy(name="interest")
	public WebElement interest_TextBox;
	
	@FindBy(id="tenure")
	public WebElement tenure_TextBox;
	
	@FindBy(css="select#tenurePeriod")
	public WebElement tenurePeriod_DropDown;
	
	@FindBy(name="frequency")
	public WebElement frequency_DropDown;	
	
	@FindBy(xpath="//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")
	public WebElement calculator_Btn;
	
	public void callPageFactory() {
		
		PageFactory.initElements(w, this);
		
	}
	
}
