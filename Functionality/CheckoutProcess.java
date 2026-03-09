package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;
import org.testng.Assert;

public class CheckoutProcess {
	protected WebDriver driver;

	public CheckoutProcess(WebDriver driver) {
		this.driver = driver;
	}

	public void CheckoutCart() {
		// Assertion for Checkout page
		//Assertion 1 via URL
		String ActualCartURL = driver.getCurrentUrl();
		String ExpectedCartURL = "https://www.saucedemo.com/cart.html";
		Assert.assertEquals(ActualCartURL, ExpectedCartURL);
		System.out.println("Assertion for cart page get as expected");
		
		//Assertion 2 
		String ActualTitle=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span")).getText();
		String ExpectedTitle="Your Cart";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Assertion of checkout page title found as per expectation");
		
		//click on the checkout button
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[2]")).click();
	}
	public void CheckoutInfo() {
		//Assertion for Checkout Information page
		String ActualURL=driver.getCurrentUrl();
		String ExpectedURL="https://www.saucedemo.com/checkout-step-one.html";
		Assert.assertEquals(ActualURL, ExpectedURL);
		System.out.println("Assertion of Chekcout Information page.");
		
		//Filling the checkout information: First name,Last name and postal code
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys("Altaf");
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input")).sendKeys("Parvej");
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input")).sendKeys("5050");
		
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input")).click();
	}
	public void CheckoutOverview() {
		//Assertion for Checkout Overview page
		String ActualURL=driver.getCurrentUrl();
		String ExpectedURL="https://www.saucedemo.com/checkout-step-two.html";
		Assert.assertEquals(ActualURL, ExpectedURL);
		System.out.println("Assertion for Checkout Overview page found expected");
		
		//Click on the finish button to complete the Chekout process
		
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[9]/button[2]")).click();
		
		//Assertion for Checkout completion
		String ActualconfirmationURl=driver.getCurrentUrl();
		String ExpectedconfirmationURL="https://www.saucedemo.com/checkout-complete.html";
		Assert.assertEquals(ActualconfirmationURl, ExpectedconfirmationURL);
		System.out.println("Checkout completed");
	}
}
