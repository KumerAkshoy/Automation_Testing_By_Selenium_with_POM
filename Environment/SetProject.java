package Environment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.*;

public class SetProject {
	  protected WebDriver driver;
		// Write the env setup codes
		public void setup() {
			// driver = new ChromeDriver();
			driver = new FirefoxDriver();
			// can implement other browsers.
			// maximize browser
			driver.manage().window().maximize();
			// Set implicit waiting time
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// set the given url to the browser and click enter
			driver.get("https://www.saucedemo.com/");
		}
		// driver quite/close
		public void CloseDown() {
			if (driver != null)
				driver.quit();
		}
		// return the driver
		public WebDriver getDriver() {
			return driver;
		}
}
