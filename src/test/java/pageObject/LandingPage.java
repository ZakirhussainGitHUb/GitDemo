package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {

		this.driver = driver;
	}

	By search = By.cssSelector(".search-keyword");
	By productname = By.xpath("//h4[contains(text(),'Carrot - 1 Kg')]");
	By IncrementValue = By.cssSelector(".increment");
	By addToCart = By.xpath("//button[contains(text(),'ADD TO CART')]");
	By viewCart = By.xpath("//img[@alt='Cart']");
	By proceedToCheckout = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");

	public void SearchItem(String productName) {

		driver.findElement(search).sendKeys(productName);
	}

	public String getProductName() {

		String productName = driver.findElement(productname).getText();
		return productName;
	}

	public void increment(int quantity) throws InterruptedException {

		int i = quantity - 1;
		while (i > 0){
			Thread.sleep(2000);
			driver.findElement(IncrementValue).click();;
			i--;
		}
	}

	public void addCart() {

		driver.findElement(addToCart).click();

	}

	public void viewCart() {
		driver.findElement(viewCart).click();
	}

	public void proceedToCheckout() {
		driver.findElement(proceedToCheckout).click();
	}
	
	public String getLandingPageTitle() {
		String title = driver.getCurrentUrl();
		return title;
	}

}
