package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Log;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(id="Email")
	WebElement userNameTextBox;
	
	@FindBy(id="Password")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;
	
//private By userNameTextBox= By.id("Email");
//private By passwordTextBox= By.id("Password");
//private By loginButton= By.xpath("//button[@type='submit']");

public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

public void enterUsername(String username) {
	
	userNameTextBox.clear();
	userNameTextBox.sendKeys(username);
	
//	driver.findElement(userNameTextBox).clear();
//	driver.findElement(userNameTextBox).sendKeys(username);
	
}

public void enterpassword(String password) {
	
	passwordTextBox.clear();
	passwordTextBox.sendKeys(password);
	
//	driver.findElement(passwordTextBox).clear();
//	driver.findElement(passwordTextBox).sendKeys(password);
	
}
public void clickLogin() {
	
	Log.info("Clicking login button...");
	
	loginButton.click();
//	driver.findElement(loginButton).click();
}
}
