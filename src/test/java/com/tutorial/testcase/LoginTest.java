package com.tutorial.testcase;

import java.io.FileNotFoundException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.tutorial.page.*;
import com.tutoriall.base.*;


public class LoginTest extends Base {

	HomePage homepage;
	LoginPage loginpage;
	AccountPage accountpage;
	public WebDriver driver;
     
    
	public LoginTest() {
		super();
	}
	
	@AfterMethod
	public void down() {
	driver.quit();

}

	@BeforeMethod
	public void setup() throws FileNotFoundException {

		driver = initialiseDriver(prop.getProperty("browser"));
		homepage = new HomePage(driver);
 	    loginpage = homepage.navigatetoLoginPage();

	}

	@Test(priority = 0)
	public void verifiyLoginWithCorrectCredential() {
		loginpage.enterEmailAdresse(prop.getProperty("valideEmail"));
		loginpage.enterPassword(prop.getProperty("passwordValid"));
		loginpage.clickLogin();

		accountpage = new AccountPage(driver);
		System.out.println(accountpage.getDispalyedEditAccountPage());
		Assert.assertTrue(accountpage.getDispalyedEditAccountPage());
	}

	@Test(priority = 1)
	public void verifiyLoginWithinCorrectCredential() {

 		loginpage.enterPassword(com.tutorialProj.Utilities.generateemailwithTime());
		loginpage.enterPassword(prop.getProperty("passwordValid"));
		loginpage.clickLogin();
		System.out.println(loginpage.msgerreurInvalidEmailLogin());

		Assert.assertTrue(loginpage.msgerreurInvalidEmailLogin().contains(prop1.getProperty("emailPasswordWarning")));
	}

	@Test(priority = 2)
 	public void verifiyLoginWithinCorrectEmail() {

		driver.findElement(By.id("input-email")).sendKeys("islemisl" + generateTimeStamp() + "@gmail.com");
		loginpage.enterPassword(prop.getProperty("passwordValid"));
		loginpage.clickLogin();
		String actuelMsgError = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
		Assert.assertTrue(actuelMsgError.contains("Warning: No match for"));
	}

	public String generateTimeStamp() {
		Date date = new Date();
		String time = date.toString().replace(":", "_").replace(" ", "_");
		return time;
	}

}
