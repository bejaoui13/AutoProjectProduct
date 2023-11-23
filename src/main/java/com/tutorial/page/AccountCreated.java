package com.tutorial.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreated {

	
	
     public AccountCreated(WebDriver driver) {
	
	super();
	PageFactory.initElements(driver, this);
}
     
     @FindBy(xpath="//div[@class='col-sm-9']/h1") WebElement accountCreated;

     
     public String accountCreatedOK()
     {
    	 String MsgAccountOK = accountCreated.getText();
    	 return MsgAccountOK;
    	 
     }
}
