package TestExecution;

import org.testng.annotations.*;

import Environment.SetProject;
import Functionality.CheckoutProcess;
import Functionality.LockedoutUser;
import Functionality.Login;
import Functionality.Logout;
import Functionality.ProductCount;
import Functionality.SortingItems;
import Functionality.productPage;

public class ExecutionTest extends SetProject {
	private Login login;
	private productPage product;
	private CheckoutProcess checkout;
	private Logout logout;
	private LockedoutUser lockedoutuser;
	private SortingItems sortItems;
	private ProductCount productcount;
	
	@BeforeMethod
	public void setuptest() {
		setup();
		login = new Login(getDriver());
		product = new productPage(getDriver());
		checkout=new CheckoutProcess(getDriver());
		logout=new Logout(getDriver());
		lockedoutuser=new LockedoutUser(getDriver());
		sortItems=new SortingItems(getDriver());
		productcount =new ProductCount(getDriver());
	}
	
	@Test (priority=1)
	public void login() throws InterruptedException {
		login.LoginProcess();
	}
	
	@Test(priority=2)
	public void NegativeTestingLogin() {
		login.LoginNegativeTesting();
	}
	
	@Test(priority=3)
	public void cart() throws InterruptedException {
		login.LoginProcess();
		product.addFirstProduct();
		product.addSecondProduct();
		product.addThirdProduct();
		product.removeOneItem();
		product.OnCart();
	}
	
	@Test(priority=4)
	public void Checkoutprocess() throws InterruptedException {
		login.LoginProcess();
		product.addFirstProduct();
		product.addSecondProduct();
		product.addThirdProduct();
		product.removeOneItem();
		product.OnCart();
		checkout.CheckoutCart();
		checkout.CheckoutInfo();
		checkout.CheckoutOverview();
	}
	
	@Test(priority=5)
	public void LogoutProcess() throws InterruptedException {
		login.LoginProcess();
		product.addFirstProduct();
		product.addSecondProduct();
		product.addThirdProduct();
		product.removeOneItem();
		product.OnCart();
		checkout.CheckoutCart();
		checkout.CheckoutInfo();
		checkout.CheckoutOverview();
		logout.BackToHomePage();
		logout.OpneMenubar();
		logout.loggingOut();
	}
	
	@Test(priority=6)
	public void LockedOutUserloginProcess() {
		lockedoutuser.LockedOutUserLogin();
	}
	
	@Test(priority=7)
	public void SortingItems() throws InterruptedException {
		login.LoginProcess();
		sortItems.sortingItemsHightoLow();
		sortItems.sortingItemsLowtoHigh();
		sortItems.sortItemsZtoA();
		sortItems.sortbyNameAtoZ();
	}
	
	@Test(priority=8)
	public void CartProductsCount() throws InterruptedException {
		login.LoginProcess();
		product.addFirstProduct();
		product.addSecondProduct();
		productcount.productCountFirst();
		product.addThirdProduct();
		productcount.productCountSecond();
		product.removeOneItem();
		productcount.productCountThird();
	}
	@AfterMethod
	public void closeAll() {
		CloseDown();
	}
	
}
