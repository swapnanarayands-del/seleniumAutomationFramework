package Utility;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;
	private static ExtentTest test;
	public static String reportpath;

	public static ExtentReports getreportInstance() {

		if (extent == null) {
			String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date(0));
			reportpath = "reports/ExtentReport_" + timestamp + ".html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
			reporter.config().setDocumentTitle("Automation Test Report");
			reporter.config().setReportName("Test Execution Report");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}

		return extent;

	}

	public static ExtentTest createTest(String testName) {
		test=getreportInstance().createTest(testName);
		return test;	
		
	}

	public static String captureScreenshot(WebDriver driver, String screenshotName) {
	
	
	try {
	File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String path = System.getProperty("user.dir")+"/screenshots/"+screenshotName+".png";
	System.out.println("path for screenshot is :"+path);
	FileUtils.copyFile(src, new File(path));
	return path;
}
	catch(Exception e) {
		e.printStackTrace();
		return null;
	}
	}
	}