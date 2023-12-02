package com.tutorial.qa.listeners;

import java.io.File;
import java.io.IOException;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.tutorialProj.ExtentReporter;

public class MyListeners implements ITestListener {
	ExtentReports extentReport ;
	ExtentTest extentest;

	
	
	
	@Override
	public void onTestStart(ITestResult tr) 
	{
		String result = tr.getName();
		extentest=extentReport.createTest(result);
		extentest.log(Status.INFO, result + "Test Started");
	}

	
	@Override
	public void onTestSuccess(ITestResult tr) 
	{
		String result = tr.getName();
		extentest.log(Status.PASS, result + "Test Passed");
	}
	
	
	@Override
	public void onTestFailure(ITestResult tr) 
	{
		String result = tr.getName();
		WebDriver driver = null;
		try {
			driver = (WebDriver)tr.getTestClass().getRealClass().getDeclaredField("driver").get(tr.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		String destscreenshot = System.getProperty("user.dir") + "\\screenshot\\"+ result + ".jpeg";
        try {
			FileHandler.copy(srcScreenshot, new File(destscreenshot));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        extentest.addScreenCaptureFromPath(destscreenshot);
        extentest.log(Status.INFO, tr.getThrowable());
        extentest.log(Status.FAIL, result + "Test failed");

	}
	
	@Override
	public void onTestSkipped(ITestResult tr) 
	{
		String result = tr.getName();
        extentest.log(Status.INFO, tr.getThrowable());
        extentest.log(Status.SKIP, result + "Test skiped");
 

     }

	
	@Override
	public void onStart(ITestContext context) {

      try {
		extentReport=ExtentReporter.generatExtentReporter();
	} catch (IOException e) {
 		e.printStackTrace();
	}
	}

	  @Override public void onFinish(ITestContext context) {
		  extentReport.flush(); 
	  }
	 
} 
