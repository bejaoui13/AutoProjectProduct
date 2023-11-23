package com.tutorial.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="input-email") WebElement inputemail;
	@FindBy(id="input-password") WebElement inputpassword;
	@FindBy(xpath="//input[@value='Login']") WebElement btnLogin;
	@FindBy(xpath="//div[contains(@class,'alert-danger')]") WebElement msgerreuremailerror;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public void enterEmailAdresse(String emailin)
	{
		inputemail.sendKeys(emailin);
	}
	
	public void enterPassword(String passwordin)
	{
		inputpassword.sendKeys(passwordin);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public String msgerreurInvalidEmailLogin()
	{
	String emailinvalideerreur= msgerreuremailerror.getText();
	return emailinvalideerreur;
	}
}
