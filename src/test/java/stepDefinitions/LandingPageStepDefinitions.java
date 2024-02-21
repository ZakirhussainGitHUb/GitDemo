package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LandingPage;
import utils.TextContextSetup;

public class LandingPageStepDefinitions {

	public TextContextSetup textContextSetup;
	public LandingPage landingPage;
	public String landingPageProductName;

	public LandingPageStepDefinitions(TextContextSetup textContextSetup) {

		this.textContextSetup = textContextSetup;
		 landingPage = textContextSetup.pageObjectManager.getLandingPage();

	}

	@Given("User is on Landingpage")
	public void user_is_on_landingpage() {
		System.out.println(landingPage.getLandingPageTitle());
	}

	@When("User searched the item {string} and Extracted actual name of product")
	public void user_searched_the_item_and_extracted_actual_name_of_product(String item) {
		landingPage.SearchItem(item);
		textContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println("LandingPage Product Vlue: "+ textContextSetup.landingPageProductName);

	}

	@When("Added {string} items selected product to the cart")
	public void added_items_selected_product_to_the_cart(String add) throws InterruptedException {
		int increment = Integer.parseInt(add);
		landingPage.increment(increment);
		landingPage.addCart();
	}

	@Then("User navigates to the checkoutpage")
	public void user_navigates_to_the_checkoutpage_and_() {
		landingPage.viewCart();
		landingPage.proceedToCheckout();
	}

	

}
