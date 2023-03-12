package tek.capstone.bdd.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import tek.capstone.bdd.framework.pages.POMFactory;
import tek.capstone.bdd.framework.utilities.BrowserUtilities;

public class RetailOrderSteps extends BrowserUtilities {

	POMFactory factory = new POMFactory();

	// 1
	@And("User click on Orders section")
	public void userClickOnOrdersSection() throws InterruptedException {
		click(factory.homePage().ordersBtn);
		logger.info("user clicked on orders option");
		
	}

	@And("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		waitTillPresence(factory.orderPage().orders.get(0));
		List<WebElement> orders = factory.orderPage().orders;
		for (WebElement e : orders) {
			clickElementWithJs(e);
			break;
		}
		logger.info("user clicked on order");
	}

	@And("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderBtn() {
		waitTillPresence(factory.orderPage().cancelBtn);
		click(factory.orderPage().cancelBtn);
		logger.info("user clicked on Cancel The Order button");
	}

	@And("User select the cancelation Reason {string}")
	public void userSelectTheCancellationReason(String reason) {
		selectByVisibleText(factory.orderPage().reasonInput, reason);
		logger.info("user selected the cancellation reason " + reason);
	}

	@And("User click on Cancel Order button")
	public void userClickOnCancelOrderbutton() {
		click(factory.orderPage().cancelOrReturnOrderFinalBtn);
		logger.info("user clicked on Cancel Order button");
	}

	@Then("a cancelation message should be displayed {string}")
	public void cancellationMessageShouldBeDisplayed(String message) {
		String expectedMessage = message;
		String actualMessage = factory.orderPage().orderCancellationOrReturnSuccessfulMessage.getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		Assert.assertTrue(isElementDisplayed(factory.orderPage().orderCancellationOrReturnSuccessfulMessage));
		logger.info("order cancellation message is displayed");
	}

	// 2
	@And("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		/** for this scenario we need to iterate through the items and find an item which has
		 *   Return option otherwise if we click the first item which is already cancelled in
		 *   previous scenario and it will not have a return option, thus, fails the test case
		 */
		List<WebElement> orders = factory.orderPage().orders;
		for (WebElement e : orders) {
			click(e);
			if(isElementDisplayed(factory.orderPage().returnBtn)) {
				break;
			}
		}
		click(factory.orderPage().returnBtn);
		logger.info("user clicked on return item button");
	}

	@And("User select the Return Reason {string}")
	public void userSelectReturnReason(String reason) {
		selectByVisibleText(factory.orderPage().reasonInput, reason);
		logger.info("user selected the return reason: " + reason);
	}

	@And("User select the drop off service {string}")
	public void userSelectDropOffService(String service) {
		selectByVisibleText(factory.orderPage().dropOff, service);
	}

	@And("User click on Return Order button")
	public void userClickOnReturnOrderBtn() {
		click(factory.orderPage().cancelOrReturnOrderFinalBtn);
		logger.info("user clicked on Return Order button");
	}

	// 3
	@And("User click on Review button")
	public void userClickOnReviewBtn() {
		click(factory.orderPage().reviewBtn);
		logger.info("user clicked on review button");
	}

	@And("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAndText(String headline, String text) {
		sendText(factory.orderPage().headlineInput, headline);
		sendText(factory.orderPage().descriptionInput, text);
		logger.info("user entered headline and description");
	}

	@And("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.orderPage().addYourReviewBtn);
		logger.info("user clicked on add your review button");
	}

	@Then("a review message should be displayed {string}")
	public void reviewMessageShouldBeDisplayed(String review) {
		String actualText = "Your review was added successfully";
		String expectedText = review;
		waitTillPresence(factory.orderPage().reviewAddedMessage);
		Assert.assertEquals(actualText, expectedText);
		Assert.assertTrue(isElementDisplayed(factory.orderPage().reviewAddedMessage));
		logger.info("review added successfully message is displayed");
	}
}
