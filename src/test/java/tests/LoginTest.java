package tests;

import org.testng.annotations.Test;

import Pages.LoginPage;
import basepage.basetest;


public class LoginTest extends basetest{
	
	@Test
	public void testvalidLogin() {
		
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.enterUsername("https://admin-demo.nopcommerce.com/login");
		loginpage.enterpassword("admin");
		loginpage.clickLogin();
		System.out.println("Title of the page is :"+driver.getTitle());
//		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
		
	}
	
	@Test
	public void testinvalidLogin() {
		
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.enterUsername("https://admin-demo.nopcommerce.com/login");
		loginpage.enterpassword("adin");
		loginpage.clickLogin();
		System.out.println("Title of the page is :"+driver.getTitle());
//		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
		
	}

}
