package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utility.ExcelUtils;
import Utility.ExtentReportManager;
import Utility.Log;
import basepage.basetest;

public class LoginTest extends basetest {

	@DataProvider(name="LoginData")
	public Object[][]getLoginData() throws IOException{
		String filepath =System.getProperty("user.dir")+"/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filepath, "Sheet1");
		int rowCount= ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][2];
		
		for(int i=1;i<rowCount;i++) {
			
			data[i-1][0]=ExcelUtils.getcellData(i, 0); //username
			data[i-1][1]=ExcelUtils.getcellData(i, 1);//password
		}
		ExcelUtils.closeExcel();
		return data;
	}
	
	@DataProvider(name="LoginData2")
	public Object[][] getData(){
		
		return new Object[][] {
			{"user1","pass1"},
			{"user2","pass2"},
			{"user3","pass3"}
		};
	}
	
	
//	@Test(dataProvider = "LoginData2")
//	@Test
//	@Parameters({"username","password"})
	@Test
	public void testvalidLogin() {

		Log.info("Starting login test ...");
		test = ExtentReportManager.createTest("Login Test -");

		test.info("Navigate to URL");
		LoginPage loginpage = new LoginPage(driver);

		Log.info("Adding credentials");
		test.info("Adding credentials");
		
		loginpage.enterUsername("admin@yourstore.com");
		loginpage.enterpassword("admin");
//		loginpage.enterUsername(username);
//		loginpage.enterpassword(password);
		test.info("Clicking on Login button");
		loginpage.clickLogin();

		System.out.println("Title of the page is :" + driver.getTitle());
		Log.info("Verifying Page title");
		test.info("verifying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		test.pass("Login successful");

	}

//	@Test
//	public void testinvalidLogin() {
//
//		Log.info("Starting login test ...");
//		test = ExtentReportManager.createTest("Login Test with invalid credentials");
//
//		test.info("Navigate to URL");
//		LoginPage loginpage = new LoginPage(driver);
//
//		Log.info("Adding credentials");
//		test.info("Adding credentials");
//		loginpage.enterUsername("admin@yourstore.com");
//		loginpage.enterpassword("admin");
//		test.info("Clicking on Login button");
//		loginpage.clickLogin();
//
//		System.out.println("Title of the page is :" + driver.getTitle());
//		Log.info("Verifying Page title");
//		test.info("verifying page title");
//		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store 56");
//		test.pass("Login successful");
//
//	}

}
