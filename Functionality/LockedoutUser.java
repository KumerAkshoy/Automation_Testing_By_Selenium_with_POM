package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
//import org.testng.annotations.Test;

public class LockedoutUser {
	protected WebDriver driver;

	public LockedoutUser(WebDriver driver) {
		this.driver = driver;
	}

	public void LockedOutUserLogin() {
		// fill the data for Username and password field
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		// click login button
		driver.findElement(By.id("login-button")).click();
		
		//Assertion for locked out user login
		String ActualErrorMessage=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
		String ExpectedErrorMessage="Epic sadface: Sorry, this user has been locked out.";
		Assert.assertEquals(ActualErrorMessage, ExpectedErrorMessage);
		System.out.println("Error message for locked out user found as per expectation");
	}
}
