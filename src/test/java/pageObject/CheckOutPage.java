package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	
	public WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	By CheckoutPageProductName = By.xpath("//p[contains(text(),'Carrot - 1 Kg')]");
	By promoCodeTextBox = By.cssSelector(".promoCode");
	By promoButtonApply = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[contains(.,'Place Order')]");
	
	public String getCheckoutPageProductName() {
		
		String CheckoutPageProductNameValue = driver.findElement(CheckoutPageProductName).getText();
		return CheckoutPageProductNameValue;
	}
	
public void applyPromoCode() {
		
		driver.findElement(promoCodeTextBox).sendKeys("rahulshettyacademy");
		driver.findElement(promoButtonApply).click();
		
	}

public void placeOrder() {
	
	
	driver.findElement(placeOrder).click();
	
}


	
	
	
	
	
	
}
