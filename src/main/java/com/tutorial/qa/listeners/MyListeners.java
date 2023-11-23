/*package com.tutorial.qa.listeners;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import tn.tutorialProj.ExtentReporter;

public class MyListeners implements ITestListener {
	ExtentReports extentReporter;
	ExtentTest extentest;

	@Override
	public void onStart(ITestContext context) {

		try {
			extentReporter = ExtentReporter.generatExtentReporter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(" Execution Of Project Stareted ");

	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();

		extentest = extentReporter.createTest(testName);
		extentest.log(Status.INFO, testName + " : Execution of Test Started ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentest.log(Status.PASS, testName + "Get Successuful Execution ");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		System.out.println("Screenshot Taken");
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String Screenshotpath = System.getProperty("user.dir") + "//screenshot" + testName;
		try {
			org.openqa.selenium.io.FileHandler.copy(screenshot, new File(Screenshotpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		extentest.addScreenCaptureFromPath(Screenshotpath);
		extentest.log(Status.INFO, result.getThrowable());
		extentest.log(Status.FAIL, testName + "Got failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();

		extentest.log(Status.INFO, result.getThrowable());
		extentest.log(Status.SKIP, testName + "Got Skipped");

	}

	@Override
	public void onFinish(ITestContext context) {

		extentReporter.flush();
	}

} */
