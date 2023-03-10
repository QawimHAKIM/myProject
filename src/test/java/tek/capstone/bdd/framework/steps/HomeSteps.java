package tek.capstone.bdd.framework.steps;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.bdd.framework.pages.POMFactory;
import tek.capstone.bdd.framework.utilities.BrowserUtilities;

public class HomeSteps extends BrowserUtilities {

	POMFactory factory = new POMFactory();

	// 1
	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().hamburgerBtn);
		logger.info("user clicked on all section button");
	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsShouldBePresent(DataTable dataTable) {
		List<List<String>> expectedSidebarOptions = dataTable.asLists(String.class);
		List<WebElement> actualSidebarOptions = factory.homePage().sidebarElements;
		for (int i = 0; i < expectedSidebarOptions.get(0).size(); i++) {
			Assert.assertEquals(actualSidebarOptions.get(i).getText(), expectedSidebarOptions.get(0).get(i));
			logger.info(actualSidebarOptions.get(i).getText() + " equals " + expectedSidebarOptions.get(0).get(i));
			// break;
		}
	}

	// 2
	@And("User on {string}")
	public void userOnDepartment(String department) {
		List<WebElement> sidebarOptions = factory.homePage().sidebarElements;
		for (WebElement options : sidebarOptions) {
			logger.info(options.getText() + " is present");
			if (options.getText().equals(department)) {
				click(options);
				break;
			}
		}
	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> expectedSidebarChilds = dataTable.asLists(String.class);
		List<WebElement> actualSidebarChilds = factory.homePage().sidebarElementsChilds;
		for (int i = 0; i < expectedSidebarChilds.get(0).size(); i++) {
			for (WebElement options : actualSidebarChilds) {
				if (options.getText().equals(expectedSidebarChilds.get(0).get(i))) {
					Assert.assertTrue(isElementDisplayed(options));
					logger.info(actualSidebarChilds.get(i).getText() + " is present");
				}

			}

		}
	}
	
	//3
	@And("User change the category to {string}")
	public void userChangeCategory(String category){
		pageLoad();
		List<WebElement> categories = factory.homePage().homePagecategories;
		for(WebElement element : categories) {
			if(element.getAttribute("alt").equals(category)) {
				element.click();
				logger.info("user clicked on " + element + " category");
				break;
			}
		}
		
	}
	
	@And("User search for an item {string}")
	public void userSearchForAnItem(String item){
		sendText(factory.homePage().searchBar, item);
		logger.info("user entered the item name");
	}
	
	@And("User click on Search icon")
	public void userClickOnSearchIcon() {
		waitTillClickable(factory.homePage().searchButton);
		click(factory.homePage().searchButton);
		logger.info("user clicked on search icon");
	}
	
	@And("User click on item")
	public void userClickOnItem() {
		waitTillPresence(factory.homePage().products);
		click(factory.homePage().products);
		logger.info("user clicked on product");
	}
	
	@And("User select quantity {string}")
	public void userSelectQuantity(String quantity) {
		selectByVisibleText(factory.homePage().productSelectQuantity, quantity);
		logger.info("user selected the quantity to " + quantity);
	}
	
	@And("User click add to Cart button")
	public void userClickOnAddToCartBtn() {
		click(factory.homePage().addToCartBtn);
		logger.info("user clicked on add to cart button");
	}
	
	@Then("the cart icon quantity should change to {string}")
	public void theCartIconShouldChange(String cartIcon){
		// In here I need to change the cartQuantity number to two otherwise
		// for the next scenario the product will quantity will be 4 which will fail
		// the test case.
		click(factory.homePage().cartBtn);
		if(!(factory.homePage().cartQuantityImg.getText().equals("5"))) {
		sendAndRemove(factory.homePage().qty);
		getWait();
		waitTillTextChange(factory.homePage().cartQuantityImg);
		}
		Assert.assertEquals(factory.homePage().cartQuantityImg.getText(), cartIcon);
		logger.info("cart icon has been updated to " + cartIcon);
	}
	
	//4
	@And("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.homePage().cartBtn);
		logger.info("user clicked on cart button");
	}
	
	@And("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutBtn() {
		click(factory.homePage().proceedBtn);
		logger.info("user clicked on Proceed to Checkout button");
	}
	
	@And("User click Add a new address link for shipping address")
	public void userClickOnAddANewAddressLink() {
		click(factory.homePage().addANewAddressLink);
		logger.info("user clicked on add a new address link");
	}
	
	
	@And("User click Add a credit card or Debit Card for Payment method")
	public void userClickAddACreditOrDebitCardLink() {
		click(factory.homePage().addACreditOrDebitCardLink);
		logger.info("user clicked on add a credit or debit card link");
	}
	
	@And("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.homePage().placeOrderBtn);
		logger.info("user clicked on place your order button");
	}
	
	@Then("a message should be displayed ‘Order Placed, Thanks’")
	public void orderPlacedMessageShouldBeDisplayed() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().orderPlacedMessage));
		logger.info("Order placed message is displayed");
	}
	
	//5
	// Scenario 4 automatically covers scenario 5
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
