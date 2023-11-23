package com.tutorial.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//span[text()='My Account']") 	WebElement MyAccountDropMenu;
	@FindBy(linkText = "Login") 	WebElement logiIn;
	@FindBy(linkText = "Register") 	WebElement registerUser;
	@FindBy(xpath = "//input[@name='search']")  	WebElement inputsearch;
	@FindBy(xpath = "//button[contains(@class,'btn btn-default')]") 	WebElement btnsearch;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	 
	public RegisterPage registerUserLink() {
		MyAccountDropMenu.click();
        registerUser.click();
		return new RegisterPage(driver);
	}

	
	public LoginPage navigatetoLoginPage()
	{
		MyAccountDropMenu.click();
		logiIn.click();
		return new LoginPage(driver);
		
	}
	
	
	public void nameProductSearch(String product) {
		inputsearch.sendKeys(product);
	}

	public SearchPage clickButton() {
		btnsearch.click();
		return new SearchPage(driver);
	}

}
