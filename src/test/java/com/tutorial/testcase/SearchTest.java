package com.tutorial.testcase;

import java.util.concurrent.TimeUnit;





import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorial.page.HomePage;
import com.tutorial.page.SearchPage;
import com.tutoriall.base.Base;


//TEST SEARCH  


public class SearchTest extends Base {
	
	public WebDriver driver;
	HomePage homepage ;

	
	SearchPage searchpage;
	
	public SearchTest()
	{
		super();
	}
	
	@AfterMethod
	public void closedriver()
	{
		 driver.quit();
		
	}

	
	@BeforeMethod
	public void setup()
	{
 	    driver= initialiseDriver(prop.getProperty("browser"));
		homepage = new HomePage(driver);

	}
	
	
	@Test
	public void searchProductValide()
	{
 		homepage.nameProductSearch(prop1.getProperty("validProduct"));
 		searchpage = homepage.clickButton();
		String productname= searchpage.valideProduct();
		Assert.assertTrue(productname.contains(prop1.getProperty("validProduct")));
 		//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='caption']")).isDisplayed());
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}

	@Test(priority = 1, dependsOnMethods = {"searchProductValide"})
	public void searchProductinValide()
	{
 		homepage.nameProductSearch(prop1.getProperty("invalidProduct"));
		searchpage = homepage.clickButton();
		String productinvalide = searchpage.invalideProduct();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

 		Assert.assertTrue(productinvalide.contains(prop1.getProperty("msgsearchproductNOK")),"");
 		System.out.println("TEST okkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");

	}
	
	
	  
	
	
}
