package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
//import org.testng.annotations.Test;

public class ProductCount {
	protected WebDriver driver;
	
	public ProductCount(WebDriver driver) {
		this.driver=driver;
	}
	
	public void productCountFirst() {
		String ActualProductsCount=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span")).getText();
		String ExpectedProductsCount="2";
		Assert.assertEquals(ActualProductsCount, ExpectedProductsCount);
		System.out.println("Products count found as per expectation after adding two products");
	}
	
	public void productCountSecond() {
		String ActualProductsCount=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span")).getText();
		String ExpectedProductsCount="3";
		Assert.assertEquals(ActualProductsCount, ExpectedProductsCount);
		System.out.println("Products count found as per expectation after adding one more product");
	}
	
	public void productCountThird() {
		String ActualProductsCount=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span")).getText();
		String ExpectedProductsCount="2";
		Assert.assertEquals(ActualProductsCount, ExpectedProductsCount);
		System.out.println("Products count found as per expectation after removing one product");
	}
  
}
