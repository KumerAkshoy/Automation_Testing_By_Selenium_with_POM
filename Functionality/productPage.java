package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.annotations.*;

public class productPage {
	protected WebDriver driver;

	// constructor
	public productPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addFirstProduct() throws InterruptedException {
		// add first product
		WebElement addproduct1=driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
		addproduct1.click();
		// Assertion
		String ActualButtonText=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/button")).getAccessibleName();
		String ExpectedButtonText="Remove";
		Assert.assertEquals(ActualButtonText, ExpectedButtonText);
		System.out.println("Assertion for first add product found as expected");
		
		Thread.sleep(2000);
	}

	public void addSecondProduct() throws InterruptedException {
		// add second product after view
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")).click();
		driver.findElement(By.id("add-to-cart")).click();
		// Assertion
		String ActualProductURL=driver.getCurrentUrl();
		String ExpectedProductURL="https://www.saucedemo.com/inventory-item.html?id=4";
		Assert.assertEquals(ActualProductURL, ExpectedProductURL);
		System.out.println("Assertion for 2nd add product found as per expectation");
		
		driver.findElement(By.id("back-to-products")).click();

		Thread.sleep(2000);

	}

	public void addThirdProduct() throws InterruptedException {
		// add third product after view
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		// Assertion
		
		String ActualButtonText3=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[4]/div[2]/div[2]/button")).getAccessibleName();
		String ExpectedButtonText3="Remove";
		Assert.assertEquals(ActualButtonText3, ExpectedButtonText3);
		System.out.println("Assertion for 3rd add product found as per expectation");
		
		Thread.sleep(2000);
	}

	public void removeOneItem() throws InterruptedException {
		//remove one item
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		System.out.println("Removed one item");
		Thread.sleep(2000);
	}
	public void OnCart() throws InterruptedException {
		//Click on the Cart Button
		driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
		Thread.sleep(2000);
		System.out.println("Process done and we are in cart page");
	}

}
