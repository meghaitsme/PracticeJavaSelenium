package com.mk.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentUtil {
	private static ExtentReports extent;
	private static ExtentTest test;
	private static WebDriver driver;

	public static void initReport(WebDriver webDriver) throws IOException {
		driver = webDriver;
		extent = new ExtentReports();
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String reportPath = System.getProperty("user.dir") + "/Reports/ExtentReport_" + timeStamp + ".html";
	
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		final File CONF = new File("D:\\MySimpleFramework\\src\\test\\resources\\extentconfig.json");
		sparkReporter.loadJSONConfig(CONF);
/*		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Automation Report");
		sparkReporter.config().setDocumentTitle("Test Results"); */
     	extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public static void createTest(String testName) {
		test = extent.createTest(testName).assignAuthor("Megha").assignCategory("Regression").assignCategory("smoke").assignDevice("Chrome");
		test = extent.createTest(testName).assignAuthor("Megha and Me").assignCategory("Regression").assignCategory("smoke").assignDevice("Chrome");

	}

	public static void logPass(String message) {
		String base64Screenshot = getBase64Screenshot();
		  // Create a MediaEntity from the base64 screenshot string
        Media media = MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build();
        test.pass("Success", media);// // Log the pass message with screenshot
		
		//test.pass(message, test.addScreenCaptureFromBase64String(base64Screenshot));
	}

	public static void logFail(String message) {
		String base64Screenshot = getBase64Screenshot();
        Media media = MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build();
		test.fail("failure ", media);
	}
	
	public static void logSkip(String message) {
		String base64Screenshot = getBase64Screenshot();
        Media media = MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build();
		test.skip("Skipped ", media);
	}
	
	public static void logInfo(String message) {
		String base64Screenshot = getBase64Screenshot();
        Media media = MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build();
		test.info("Login url started successfully  ", media);
		test.info("url is loaded  ", media);
		test.info("values entered  ", media);
		test.info("homepage test passed  ", media);
	}

	private static String getBase64Screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

	public static void endReport() {
		if (extent != null) {
			extent.flush();
			
			//Automatically opens the report after execution
		//	Desktop.getDesktop().browse(new File("/Reports/ExtentReport_" + timeStamp + ".html"));
			
		}
	}
}
