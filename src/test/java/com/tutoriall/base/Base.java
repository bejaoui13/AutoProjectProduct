package com.tutoriall.base;


import com.google.common.base.Optional;

import java.io.File;
import java.io.FileInputStream;
 import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;

 

public class Base {

	  WebDriver driver;
	public Properties prop;
	public Properties prop1;
	
	public Base() {
		
		String path1 = System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorial\\config\\qa\\testdata.properties";
		File file1 = new File(path1);
		
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorial\\config\\qa\\config.properties";
		File file = new File(path);

		  prop = new Properties();
		  prop1= new Properties();
		  
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fils1 = new FileInputStream(file1);
			prop1.load(fils1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public WebDriver initialiseDriver(String browserName) {

		if (browserName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "./derv/chromedriver.exe");
			driver = new ChromeDriver();
          ChromeOptions options =new ChromeOptions();
          options.addArguments("--headless");
		}

		else if (browserName.equals("opera")) {
			driver = new OperaDriver();
			System.setProperty("webdriver.chrome.driver", "./driver/chromdriver.exe");

		}

		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));

		return driver;

	}

	public void tearDown() {
		driver.quit();
	}

}
