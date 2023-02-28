package tek.capstone.bdd.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.bdd.framework.pages.POMFactory;
import tek.capstone.bdd.framework.utilities.BrowserUtilities;

public class RetailAccountSteps extends BrowserUtilities{

	private POMFactory factory = new POMFactory();
	
	//1
	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.homePage().accountBtn);
		logger.info("user clicked on account option");
	}
	
	@And("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phone){
		clearTextUsingSendKeys(factory.accountPage().nameField);
		clearTextUsingSendKeys(factory.accountPage().phoneField);
		sendText(factory.accountPage().nameField, name);
		sendText(factory.accountPage().phoneField, phone);
		logger.info("user updated name and phone");
	}
	
	@And("User click on Update button")
	public void userClickOnUpdateBtn() {
		click(factory.accountPage().updateBtn);
		logger.info("user clicked on udpate button");
	}
	
	@Then("user profile information should be updated")
	public void userProfileShouldBeUpdated() {
		waitTillPresence(factory.accountPage().personalInfoUpdatedSuccessfullyMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInfoUpdatedSuccessfullyMessage));
		logger.info("user profile information has been updated");
	}
	
	//2
	@And("User enter below information")
	public void userEnterBelowInfo(DataTable dataTable) {
		List<Map<String, String>> accountInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().previousPasswordField, accountInfo.get(0).get("previousPassword"));
		sendText(factory.accountPage().newPasswordField, accountInfo.get(0).get("newPassword"));
		sendText(factory.accountPage().confirmPassField, accountInfo.get(0).get("confirmPassword"));
		logger.info("user entered previous and new passwords");
	}
	
	@And("User click on Change Password button")
	public void userClickOnChangePassBtn() {
		click(factory.accountPage().changePasswordBtn);
		logger.info("user clicked on change password button");
	}
	
	@Then("a message should be displayed ‘Password Updated Successfully’")
	public void passwordUpdateMessage() {
		waitTillPresence(factory.accountPage().passwordUpdateMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().passwordUpdateMessage));
		logger.info("Password Updated Successfully");
	}
	
	//3
	@And("User click on Add a payment method link")
	public void userClickOnAddPaymentLink() {
		click(factory.accountPage().addPaymentLink);
		logger.info("user clicked on Add a payment method link");
	}
	
	@And("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInfo(DataTable dataTable) {
		List<Map<String, String>> cardsInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().cardNumberField, cardsInfo.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCardField, cardsInfo.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationMonthInput, cardsInfo.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountPage().expirationYearInput, cardsInfo.get(0).get("expirationYear"));
		sendText(factory.accountPage().securityCodeField, cardsInfo.get(0).get("securityCode"));
		logger.info("user filled debit or credit cards information");
	}
	
	@And("User click on Add your card button")
	public void userClickOnAddYourCardBtn() {
		click(factory.accountPage().addYourCardBtn);
		logger.info("user clicked on Add Your card button");
	}
	
	@Then("a message should be displayed ‘Payment Method added successfully’")
	public void paymentAddedMessageShouldBeDisplayed() {
		waitTillPresence(factory.accountPage().paymentMethodAddedMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().paymentMethodAddedMessage));
		logger.info("Payment Method added successfully message is displayed");
	}
	
	//4
	@And("User click on Edit option of card section")
	public void userClickOnEditOptionOfCard() {
		click(factory.accountPage().debitOrCreditCardPicture);
		click(factory.accountPage().editBtnOnCard);
		logger.info("user clicked on edit option of card");
	}
	
	@And("user edit information with below data")
	public void userEditInfo(DataTable dataTable) {
		List<Map<String, String>> editCardsInfo = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(factory.accountPage().cardNumberField);
		sendText(factory.accountPage().cardNumberField, editCardsInfo.get(0).get("cardNumber"));
		clearTextUsingSendKeys(factory.accountPage().nameOnCardField);
		sendText(factory.accountPage().nameOnCardField, editCardsInfo.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationMonthInput, editCardsInfo.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountPage().expirationYearInput, editCardsInfo.get(0).get("expirationYear"));
		clearTextUsingSendKeys(factory.accountPage().securityCodeField);
		sendText(factory.accountPage().securityCodeField, editCardsInfo.get(0).get("securityCode"));
		logger.info("user edited debit or credit cards information");
	}
	
	@And("user click on Update Your Card button")
	public void userClickOnUpdateYourCardBtn() {
		click(factory.accountPage().addYourCardBtn);
		logger.info("user clicked on Update Your Card button");
	}
	
	@Then("a message should be displayed ‘Payment Method updated Successfully’")
	public void paymendUpdatedMessageShouldBeDisplayed() {
		waitTillPresence(factory.accountPage().paymentMethodUpdateMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().paymentMethodUpdateMessage));
		logger.info("Payment Method updated Successfully message is displayed");
	}
	
	//5
	@And("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCard() {
		click(factory.accountPage().debitOrCreditCardPicture);
		click(factory.accountPage().removeBtnOnCard);
		logger.info("user clicked on remove card option on card");
	}
	
	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		Assert.assertTrue(isElementDisplayed(factory.accountPage().debitOrCreditCardPicture));
		logger.info("payment details has been removed");
	}
	
	//6
	@And("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.accountPage().addAddressBox);
		logger.info("user clicked on Add Address option");
	}
	
	@And("User fill new address form with below information")
	public void userFillAddressInfo(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.accountPage().countryDropdown, addressInfo.get(0).get("country"));
		clearTextUsingSendKeys(factory.accountPage().fullNameAddress);
		sendText(factory.accountPage().fullNameAddress, addressInfo.get(0).get("fullName"));
		clearTextUsingSendKeys(factory.accountPage().phoneNumberAddress);
		sendText(factory.accountPage().phoneNumberAddress, addressInfo.get(0).get("phoneNumber"));
		clearTextUsingSendKeys(factory.accountPage().streetAddress);
		sendText(factory.accountPage().streetAddress, addressInfo.get(0).get("streetAddress"));
		clearTextUsingSendKeys(factory.accountPage().apartmentAddress);
		sendText(factory.accountPage().apartmentAddress, addressInfo.get(0).get("apt"));
		clearTextUsingSendKeys(factory.accountPage().cityAddress);
		sendText(factory.accountPage().cityAddress, addressInfo.get(0).get("city"));
		selectByVisibleText(factory.accountPage().stateAddress, addressInfo.get(0).get("state"));
		clearTextUsingSendKeys(factory.accountPage().zipCodeAddress);
		sendText(factory.accountPage().zipCodeAddress, addressInfo.get(0).get("zipCode"));
		logger.info("user added the address information");
	}
	
	@And("User click Add Your Address button")
	public void userClickAddYourAddressBtn() {
		click(factory.accountPage().addAddressBtn);
		logger.info("user clicked on Add Your Address button");
	}
	
	@Then("a message should be displayed ‘Address Added Successfully’")
	public void addressAddedMessage() {
		waitTillPresence(factory.accountPage().addressAddedMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().addressAddedMessage));
		logger.info("Address Added Successfully message is displayed");
	}
	
	//7
	@And("User click on edit address option")
	public void userClickEditOnAddress() {
		click(factory.accountPage().editBtnOnAddress);
		logger.info("user clicked on edit option on address");
	}
	
	@And("User click update Your Address button")
	public void userClickOnUpdateYourAddressBtn() {
		click(factory.accountPage().addAddressBtn);
		logger.info("user clicked on Update Your Address button");
	}
	
	@Then("a message should be displayed ‘Address Updated Successfully’")
	public void addressUpdatedMessageShouldBeDisplayed() {
		waitTillPresence(factory.accountPage().addressUpdatedMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().addressUpdatedMessage));
		logger.info("Address Updated Successfully message is displayed");
	}
	
	//8
	@And("User click on remove option of Address section")
	public void userClickRemoveOnAddress() {
		click(factory.accountPage().removeBtnOnAddress);
		logger.info("user clicked on remove button on address");
		
	}
	
	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		Assert.assertFalse(!isElementDisplayed(factory.accountPage().addressBoxes));
		logger.info("address details has been removed");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
