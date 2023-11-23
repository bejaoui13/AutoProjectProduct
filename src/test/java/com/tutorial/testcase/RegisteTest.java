package com.tutorial.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorial.page.AccountCreated;
import com.tutorial.page.HomePage;
import com.tutorial.page.RegisterPage;
import com.tutorialProj.Utilities;
import com.tutoriall.base.Base;

public class RegisteTest extends Base{

	
		public WebDriver driver;

		HomePage homepage;
		RegisterPage registerpage;
		AccountCreated accountcreated;
		
		public RegisteTest() {
			super();
		}

		@AfterMethod
			public void down() {
			driver.quit();
		
		}
		
		@BeforeMethod
		public void setup() {

			driver = initialiseDriver(prop.getProperty("browser"));
			homepage = new HomePage(driver);
 			registerpage = homepage.registerUserLink();
		}

		@Test(priority=0)
		public void resgisterwithMondotaryField() {
			accountcreated= registerpage.registersucces(prop1.getProperty("username"),prop1.getProperty("lastname"),Utilities.generateemailwithTime(), prop1.getProperty("telephone"),prop1.getProperty("password"),prop1.getProperty("password"));
   			Assert.assertEquals(accountcreated.accountCreatedOK(), prop1.getProperty("regiterMsgOK"));
			}

		
		@Test(priority = 1)
		public void resgisterwithEmailExiste() 
		{
			accountcreated= registerpage.resgisterwithEmailExiste(prop1.getProperty("username"),prop1.getProperty("lastname"),prop1.getProperty("existeemail"), prop1.getProperty("telephone"),prop1.getProperty("password"),prop1.getProperty("password"));
 	        String mailexisteerror = registerpage.msgregisterError();
	        Assert.assertEquals(mailexisteerror, prop1.getProperty("msgexistemail"));
	 	}

		
		@Test(priority=2)
		public void resgisterwitoutAnyDetail() {

			
 			registerpage.clickbtnregister();
 			Boolean status = registerpage.displayErrorInputVide(prop1.getProperty("erroragreeplicy"), prop1.getProperty("Msgvidefirstname"), prop1.getProperty("Msgvidelastname"), prop1.getProperty("Msgvideemail"), prop1.getProperty("Msgvidetelephone"),  prop1.getProperty("Msgvidepassword"));
 			Assert.assertTrue(status, "Please check the information");

		}
	
	
	
}
