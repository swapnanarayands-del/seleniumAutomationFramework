package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicScript1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		 
	    driver.get("https://admin-demo.nopcommerce.com/login");
	    String title =driver.getTitle();
	    System.out.println("Title is :" +title);
	    
	    WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
	   System.out.println("Text Of login button is :"+loginButton.getText());
	   
    WebElement emailBox=driver.findElement(By.id("Email"));
	  emailBox.clear();
	   emailBox.sendKeys("admin@yourstore.com");
//	    driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
	   
	    WebElement Password = driver.findElement(By.id("Password"));
	    Password.clear();
	    Password.sendKeys("admin");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	    driver.close();
	    driver.quit();
	}
}
