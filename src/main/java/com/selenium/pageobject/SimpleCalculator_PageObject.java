package com.selenium.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleCalculator_PageObject extends TestBase{

	
	@FindBy(css="input[ng-model='first']")
	public WebElement firstNumberTextBox;
	
	@FindBy(css="input[ng-model='second']")
	public WebElement secondNumberTextBox;

	@FindBy(css="select[ng-model='operator']")
	public WebElement operatorDropDown;

	@FindBy(id="gobutton")
	public WebElement goBtn;

	
	public void callPageFactory() {
		
		PageFactory.initElements(w, this);
	}
}
