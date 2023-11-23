package com.tutorial.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(id="input-firstname") private WebElement inputfirstname;
	@FindBy(id="input-lastname") private WebElement inputlastname;
	@FindBy(id="input-email") private WebElement inputemail;
	@FindBy(id="input-telephone") private WebElement inputtelephone;
	@FindBy(id="input-password") private WebElement inputpassword;
	@FindBy(id="input-confirm") private WebElement inputconfirmpwd;
	@FindBy(name="newsletter") private WebElement yestnewslettre;
	@FindBy(name="agree") private WebElement inputagree;
	@FindBy(xpath="//input[@value='Continue']") private WebElement btnConntinue;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") WebElement erroregister;
    @FindBy(xpath="//input[@id='input-firstname']/following-sibling::div") WebElement videfirstname;
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div") WebElement videlastname;
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div") WebElement videemail;
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div") WebElement videtelephone;
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div") WebElement videpassword;


	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	
	public AccountCreated registersucces(String frstrname, String lstname, String email, String telephone,String password , String  cnfpassword)
	{
		inputfirstname.sendKeys(frstrname);
		inputlastname.sendKeys(lstname);
		inputemail.sendKeys(email);
	 	inputtelephone.sendKeys(telephone);
	 	inputpassword.sendKeys(password);
		inputconfirmpwd.sendKeys(cnfpassword);
	 	yestnewslettre.click();
	 	inputagree.click();
		btnConntinue.click();
		return new AccountCreated(driver);
	}
	
	
	public AccountCreated resgisterwithEmailExiste(String frstrname, String lstname, String existeemail, String telephone,String password , String  cnfpassword)
	{
		inputfirstname.sendKeys(frstrname);
		inputlastname.sendKeys(lstname);
		inputemail.sendKeys(existeemail);
	 	inputtelephone.sendKeys(telephone);
	 	inputpassword.sendKeys(password);
		inputconfirmpwd.sendKeys(cnfpassword);
	 	yestnewslettre.click();
	 	inputagree.click();
		btnConntinue.click();
		return new AccountCreated(driver);
	}
	
	public String msgregisterError()
	{
		String registerError = erroregister.getText();
		return registerError;
	}
	
	public String errorvidefirstname()
	{
		String nameError = videfirstname.getText();
		return nameError;
	}
	
	public String errorvidelastname()
	{
		String lastnameerror = videlastname.getText();
		return lastnameerror;
	}
	
	public String errorvideEmail()
	{
		String emailError = videemail.getText();
		return emailError;
	}
	
	public String errorvideteleph()
	{
		String telphoneError = videtelephone.getText();
		return telphoneError;
	}
	
	public String errorvidepassword()
	{
		String passwordError = videpassword.getText();
		return passwordError;
	}
	
	public void clickbtnregister()
	{
		btnConntinue.click();
	}
	 
	 
	public boolean displayErrorInputVide(String expectedAgreePolicy, String expectedErrorvidefirstname, String expectedErrorvidelastname, String expectedErrorvideemail, String expectedErrorvidetelephone, String expectedErrorvidepassword )
	{

 		Boolean boolAgreePolicy = erroregister.getText().contains(expectedAgreePolicy);
 	    Boolean boolvidefirstname = videfirstname.getText().contains(expectedErrorvidefirstname);
	    Boolean	boolErrorvidelastname = videlastname.getText().contains(expectedErrorvidelastname);
	    Boolean	boolErrorvideemail = videemail.getText().contains(expectedErrorvideemail);
	    Boolean  boolErrorVidetelephone =  videtelephone.getText().contains(expectedErrorvidetelephone);
	    Boolean  boolErrorVidepassword =  videpassword.getText().contains(expectedErrorvidepassword);
	    return boolAgreePolicy && boolvidefirstname && boolErrorvidelastname && boolErrorVidetelephone && boolErrorvideemail && boolErrorVidepassword ;
	   
  
	}
}
 