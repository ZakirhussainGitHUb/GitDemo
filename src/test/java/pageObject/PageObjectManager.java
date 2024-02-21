package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectManager {

	public WebDriver driver;
	public LandingPage landingPage;
	public CheckOutPage checkOutPage;

	public PageObjectManager(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public CheckOutPage getCheckOutPage() {

		CheckOutPage checkOutPage = new CheckOutPage(driver);

		return checkOutPage;
	}

	public LandingPage getLandingPage() {

		LandingPage landingPage = new LandingPage(driver);

		return landingPage;
	}

}
