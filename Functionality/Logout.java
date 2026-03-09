package Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

//import org.testng.annotations.Test;

public class Logout {
	protected WebDriver driver;
	
	public Logout(WebDriver driver) {
		this.driver=driver;
	}
  
  public void BackToHomePage() {
	  //clicking to back to the home page
	  driver.findElement(By.xpath("/html/body/div/div/div/div[2]/button")).click();
	  
	  //Assertion for Home/product page: 
	  String ActualHomeURL=driver.getCurrentUrl();
	  String ExpectedHomeURL="https://www.saucedemo.com/inventory.html";
	  Assert.assertEquals(ActualHomeURL, ExpectedHomeURL);
	  System.out.println("Successfully back to the Home page.");  
  }
  
  public void OpneMenubar() {
	  //clicking on menu option
	  driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[1]/div/button")).click();
	  
	  //Assertion for menu bar option
	  String ActualMenuText1=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[1]")).getText();
	  String ExpectedMenuText1="All Items";
	  Assert.assertEquals(ActualMenuText1, ExpectedMenuText1);
	  System.out.println("Assertion of Menu bar completed.");
  }
  
  public void loggingOut() {
	  //clicking on Logout option
	  driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[3]")).click();
	  
	  //Assertion for Logout page
	  String ActualLogoutURL=driver.getCurrentUrl();
	  String ExpectedLogoutURL="https://www.saucedemo.com/";
	  Assert.assertEquals(ActualLogoutURL, ExpectedLogoutURL);
	  System.out.println("Assertion for Log out page completed.");
  }
}
