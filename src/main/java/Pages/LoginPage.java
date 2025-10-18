package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
private By userNameTextBox= By.id("Email");
private By passwordTextBox= By.id("Password");
private By loginButton= By.xpath("//button[@type='submit']");

public LoginPage(WebDriver driver) {
	this.driver=driver;
	
}

public void enterUsername(String username) {
	driver.findElement(userNameTextBox).clear();
	driver.findElement(userNameTextBox).sendKeys(username);
	
}

public void enterpassword(String password) {
	driver.findElement(passwordTextBox).clear();
	driver.findElement(passwordTextBox).sendKeys(password);
	
}
public void clickLogin() {
	
	driver.findElement(loginButton).click();
}
}
