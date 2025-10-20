package basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Utility.EmailUtils;
import Utility.ExtentReportManager;
import Utility.Log;


public class basetest {
	
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeSuite
	 public void setupReport() {
		 
		 extent =  ExtentReportManager.getreportInstance();
	
	 }
	 
	@AfterSuite
	 public void teardownreport() {
		  extent.flush();
		  String reportpath=ExtentReportManager.reportpath;
		  EmailUtils.sendTestReport(reportpath);
	 }
	@BeforeMethod
	public void setup() {
		Log.info("starting WebDriver ...");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("Navigating to URL");
		driver.get("https://admin-demo.nopcommerce.com/login");
		
	}
		
		@AfterMethod
//		ITestResult catches failure and holds in result variable
		public void tearDown(ITestResult result) { 
			if(result.getStatus()==ITestResult.FAILURE) {
				String screenshotpath=ExtentReportManager.captureScreenshot(driver, "LoginFailure");
				test.fail("Test Failed.. check Screenshot", 
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
			}
			if(driver !=null) {
				Log.info("Closing Browser");
				driver.quit();
			}
		}
	}


