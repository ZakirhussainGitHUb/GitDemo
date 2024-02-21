package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObject.CheckOutPage;
import pageObject.LandingPage;
import utils.TextContextSetup;

public class CheckOutPageStepDefinitions {
	
	public TextContextSetup textContextSetup;
	public CheckOutPage checkOutPage;
	public String checkoutPageProductName;
	public String landingPageProductName;
	
	public CheckOutPageStepDefinitions(TextContextSetup textContextSetup) {

		this.textContextSetup = textContextSetup;
		checkOutPage = textContextSetup.pageObjectManager.getCheckOutPage();

	}
	
	@Then("validate items in checkout page")
	public void validate_items_in_checkout_page() {
	 checkoutPageProductName = checkOutPage.getCheckoutPageProductName().split("-")[0].trim();
	 System.out.println("Checkoutpage product value: " + checkoutPageProductName);
	 Assert.assertEquals(checkoutPageProductName, textContextSetup.landingPageProductName);
	}

	@Then("User is able to add promotion code and place order")
	public void user_is_able_to_add_promotion_code_and_place_order() {
		checkOutPage.applyPromoCode();
		checkOutPage.placeOrder();
	}

}
