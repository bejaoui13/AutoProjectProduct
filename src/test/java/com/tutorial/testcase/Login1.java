package com.tutorial.testcase;

 import java.io.FileNotFoundException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutoriall.base.*;


public class Login1 extends Base{

	WebDriver driver;

	public Login1()
	{
		super();
	}
	
	@AfterMethod
		public void tearDown() {
		driver.quit();
	}
	
	
	@BeforeMethod
	public void setup() throws FileNotFoundException
	{
		
 	    driver= initialiseDriver(prop.getProperty("browser"));
 
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();

		
	}

	@Test(priority = 1)
	public void verifiyLoginWithCorrectCredential() {
 	    driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("valideEmail"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("passwordValid"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	//	String lienVerification = driver.findElement(By.linkText("Edit your account information")).getText();
		//Assert.assertTrue(lienVerification.contains("Edit your account"));
	}

	@Test(priority = 2)
	public void verifiyLoginWithinCorrectCredential() {
		 
		driver.findElement(By.id("input-email")).sendKeys("islemisl" + generateTimeStamp() + "@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys(prop1.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actuelMsgError = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
		Assert.assertTrue(actuelMsgError.contains(prop1.getProperty("emailPasswordWarning")));
	}

	@Test(priority = 3)
	public void verifiyLoginWithinCorrectEmail() {


		driver.findElement(By.id("input-email")).sendKeys("islemisl"+ generateTimeStamp() + "@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actuelMsgError = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
		Assert.assertTrue(actuelMsgError.contains("Warning: No match for E-Mail Address and/or Password."));
	}

	public String generateTimeStamp() {
		Date date = new Date();
		String time = date.toString().replace(":", "_").replace(" ", "_");
		return time;
	}

}
