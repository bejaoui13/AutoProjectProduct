package com.tutorial.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialProj.Utilities;
import com.tutoriall.base.Base;

public class Register1 extends Base {

	WebDriver driver;

	public Register1()
	{
		super();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@BeforeMethod
	public void setup() {

		
		
		driver = initialiseDriver(prop.getProperty("browser"));
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();

	}

	@Test
	public void resgisterwithMondotaryField() {

		driver.findElement(By.id("input-firstname")).sendKeys(prop1.getProperty("username"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop1.getProperty("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateemailwithTime());
		driver.findElement(By.id("input-telephone")).sendKeys(prop1.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys("12345556");
		driver.findElement(By.id("input-confirm")).sendKeys("12345556");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualH1 = driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
		String excpectedmsgRegisterOK= prop1.getProperty("regiterMsgOK");
		Assert.assertEquals(actualH1,excpectedmsgRegisterOK);
	}

	@Test
	public void resgisterwithEmailExiste() {

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys(prop1.getProperty("username"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop1.getProperty("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(prop1.getProperty("existeemail"));

		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateemailwithTime());
		driver.findElement(By.id("input-telephone")).sendKeys(prop1.getProperty("existeemail"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("passwordValid"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("passwordValid"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String msgAgreepolicy = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(msgAgreepolicy);
		Assert.assertTrue(msgAgreepolicy.contains(prop1.getProperty("msgexistemail"))," Duplicate email ***************");
	}

	@Test
	public void resgisterwitoutAnyDetail() {

		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String msgAgreepolicy = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(msgAgreepolicy.contains("Warning: You must agree to the Privacy Policy!"),
				" Duplicate email ***************");

		String erreurUsername = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div"))
				.getText();
		Assert.assertEquals(erreurUsername, "First Name must be between 1 and 32 characters!");

		String erreurlastname = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div"))
				.getText();
		Assert.assertEquals(erreurlastname, "Last Name must be between 1 and 32 characters!");

		String erreuremail = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div"))
				.getText();
		Assert.assertEquals(erreuremail, "E-Mail Address does not appear to be valid!");

		String erreurtelp = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div"))
				.getText();
		Assert.assertEquals(erreurtelp, "Telephone must be between 3 and 32 characters!");

	}
}
