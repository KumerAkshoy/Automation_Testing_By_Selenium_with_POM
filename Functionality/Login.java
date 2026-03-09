package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.annotations.Test;

public class Login {
	protected WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public void LoginProcess() {
		//Assertion1 for verify the Login URL
		String Actual_URL=driver.getCurrentUrl();
		String Expected_URL="https://www.saucedemo.com/";
		Assert.assertEquals(Actual_URL, Expected_URL);
		System.out.println("Login page URL found as per expectation");
		
		//Assertion2 for Verify button text of Login Page
		String Actual_buttonText=driver.findElement(By.id("login-button")).getAccessibleName();
		String Expected_buttonText="Login";
		Assert.assertEquals(Actual_buttonText, Expected_buttonText);
		System.out.println("Login Button text found as per expectation");
		
		//Fill the username field
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		// filled-up password
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		// click login button
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login completed");
		
		
		//Assertion after login
		//Assertion 1 for verify the landing page after login 
		String Actual_landing_URL=driver.getCurrentUrl();
		String Expected_landing_URL="https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(Actual_landing_URL, Expected_landing_URL);
		System.out.println("Assertion for landing page after login through URL completed");
		
		//Assertion 2 for verify the landing page after login
		WebElement page_text=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
		String Actual_page_text=page_text.getText();
		String Expected_page_text="Products";
		Assert.assertEquals(Actual_page_text, Expected_page_text);
		System.out.println("Assertion for landing page after login via page text completed");
	}
	public void LoginNegativeTesting() {
		driver.findElement(By.id("user-name")).sendKeys("standard");
		// filled-up password
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		// click login button
		driver.findElement(By.id("login-button")).click();
		
		//Assertion for negative testing of Login
		String ActuraErrorMessage=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
		String ExpectedErrorMessage="Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(ActuraErrorMessage, ExpectedErrorMessage);
		System.out.println("Assertion of Negative testing for login page through error message.");
	}
}
