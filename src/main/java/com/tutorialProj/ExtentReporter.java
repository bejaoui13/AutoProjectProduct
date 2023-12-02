package com.tutorialProj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	ExtentTest extentTest;

	public ExtentReporter() {
		super();

	}

	public static ExtentReports generatExtentReporter() throws IOException {

		ExtentReports extentreport = new ExtentReports();

		File extentReportfile = new File(
				System.getProperty("user.dir") + "\\test-output\\ExtentReport\\extentreporter.html");

		ExtentSparkReporter SparkReporter = new ExtentSparkReporter(extentReportfile);

		SparkReporter.config().setTheme(Theme.DARK);
		SparkReporter.config().setReportName("Test automation Tuto");
		SparkReporter.config().setDocumentTitle("TN Automation report0");
		SparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

		extentreport.attachReporter(SparkReporter);

		Properties configProp = new Properties();

		File fileconfigProp = new File(
				 System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorial\\config\\qa\\testdata.properties");

		try {
			FileInputStream fis = new FileInputStream(fileconfigProp);
			configProp.load(fis);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}

		extentreport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentreport.setSystemInfo("Browser Name", configProp.getProperty("browser"));
		extentreport.setSystemInfo("Email Name", configProp.getProperty("valideEmail"));
		extentreport.setSystemInfo("User Name", configProp.getProperty("name"));
		extentreport.setSystemInfo(" Operation System", System.getProperty("os.name"));
		extentreport.setSystemInfo(" Java version", System.getProperty("java.version"));
		return extentreport;

	}

}
