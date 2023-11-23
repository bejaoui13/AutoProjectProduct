package com.tutorialProj;
/* package tn.tutorialProj;
 

import java.io.File;
import java.io.FileInputStream;
 import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
 import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generatExtentReporter() throws IOException {
		ExtentReports extentreporter = new ExtentReports();

		File extentfile = new File(
				System.getProperty("user.dir") + "\\test-output\\ExtentReporter\\extentreporter.html");

		ExtentSparkReporter SparkReporter = new ExtentSparkReporter(extentfile);  
		SparkReporter.config().setTheme(Theme.DARK);
		SparkReporter.config().setReportName("Test automation Tuto");
		SparkReporter.config().setDocumentTitle("TN Automation report0");
		SparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

		extentreporter.attachReporter(SparkReporter);

		Properties configProp = new Properties();

		File fileconfigProp = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorial\\config\\qa\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(fileconfigProp);
			configProp.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		extentreporter.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentreporter.setSystemInfo("Browser Name", configProp.getProperty("browser"));
		extentreporter.setSystemInfo("Email Name", configProp.getProperty("valideEmail"));
		extentreporter.setSystemInfo("User Name", configProp.getProperty("name"));
		extentreporter.setSystemInfo(" Operation System", configProp.getProperty("os.name"));
		extentreporter.setSystemInfo(" Java version", configProp.getProperty("java.version"));
return extentreporter;

	}

	 
}
		*/