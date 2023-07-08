package tek.capstone.bdd.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.bdd.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {

	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//img[@id='profileImage']")
	public WebElement profileImage;
	
	@FindBy(xpath = "//h1[@class='account__information-username']")
	public WebElement userText;

	@FindBy(xpath = "//h1[@class='account__information-email']")
	public WebElement emailText;

	@FindBy(id = "nameInput")
	public WebElement nameField;

	@FindBy(id = "personalPhoneInput")
	public WebElement phoneField;

	@FindBy(id = "emailInput")
	public WebElement emailField;

	@FindBy(id = "personalUpdateBtn")
	public WebElement updateBtn;

	@FindBy(id = "previousPasswordInput")
	public WebElement previousPasswordField;

	@FindBy(id = "newPasswordInput")
	public WebElement newPasswordField;

	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmPassField;

	@FindBy(id = "credentialsSubmitBtn")
	public WebElement changePasswordBtn;

	@FindBy(xpath = "(//h1[@class='account__title'])[1]")
	public WebElement walletText;

	@FindBy(xpath = "//h1[@class='account__payments-title']")
	public WebElement cardsAndAccountText;

	@FindBy(xpath = "//p[contains(@class, 'text-sm')]")
	public WebElement addPaymentLink;

	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberField;

	@FindBy(id = "nameOnCardInput")
	public WebElement nameOnCardField;

	@FindBy(id = "expirationMonthInput")
	public WebElement expMonth;

	@FindBy(id = "expirationMonthInput")
	public WebElement expirationMonthInput;

	@FindBy(id = "expirationYearInput")
	public WebElement expirationYearInput;

	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeField;

	@FindBy(xpath = "//button[@id='paymentSubmitBtn']")
	public WebElement addYourCardBtn;

	@FindBy(css = "p[class='account__payment-ad-text']")
	public WebElement creaditAndDebitCardsText;

	@FindBy(css = "img[alt='credit cards']")
	public WebElement creditCardsPics;

	@FindBy(xpath = "(//h1[@class = 'account__title'])[2]")
	public WebElement yourAddressesText;
	
	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement personalInfoUpdatedSuccessfullyMessage;
	
	@FindBy(xpath = "//div[text()='Password Updated Successfully']")
	public WebElement passwordUpdateMessage;
	
	@FindBy(xpath = "//div[text()='Payment Method added sucessfully']")
	public WebElement paymentMethodAddedMessage;
	
	@FindBy(xpath = "//div[text()='Payment Method updated Successfully']")
	public WebElement paymentMethodUpdateMessage;
	
	@FindBy(xpath = "//img[@alt='Master Card']")
	public WebElement debitOrCreditCardPicture;
	
	@FindBy(xpath = "//button[@class='text-blue-800 cursor-pointer hover:underline' and text()='Edit']")
	public WebElement editBtnOnCard;
	
	@FindBy(xpath = "//button[text()='remove']")
	public WebElement removeBtnOnCard;
	
	// belongs to add address
	@FindBy(xpath = "//div[@class='account__address-new']")
	public WebElement addAddressBox;
	
	@FindBy(id = "countryDropdown")
	public WebElement countryDropdown;
	
	@FindBy(id = "fullNameInput")
	public WebElement fullNameAddress;
	
	@FindBy(id = "phoneNumberInput")
	public WebElement phoneNumberAddress;
	
	@FindBy(id = "streetInput")
	public WebElement streetAddress;
	
	@FindBy(id = "apartmentInput")
	public WebElement apartmentAddress;
	
	@FindBy(id = "cityInput")
	public WebElement cityAddress;
	
	@FindBy(xpath = "//select[@name='state']")
	public WebElement stateAddress;
	
	@FindBy(id = "zipCodeInput")
	public WebElement zipCodeAddress;
	
	@FindBy(id = "addressBtn")
	public WebElement addAddressBtn;
	
	@FindBy(id = "fullNameError")
	public WebElement fullNameErrorOnAddress;
	
	@FindBy(id = "phoneNumberError")
	public WebElement phoneNumberErrorOnAddress;
	
	@FindBy(id = "streetError")
	public WebElement streetErrorOnAddress;
	
	@FindBy(id = "cityError")
	public WebElement cityErrorOnAddress;
	
	@FindBy(id = "zipCodeError")
	public WebElement zipCodeErrorOnAddress;
	
	@FindBy(xpath = "//button[@class='account__address-btn' and text()='Edit']")
	public WebElement editBtnOnAddress;
	
	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement removeBtnOnAddress;
	
	@FindBy(xpath = "//div[text()='Address Added Successfully']")
	public WebElement addressAddedMessage;
	
	@FindBy(xpath = "//div[text()='Address Updated Successfully']")
	public WebElement addressUpdatedMessage;
	
	//Errors messages
	@FindBy(id = "cardNumberError")
	public WebElement cardNumberError;
	
	@FindBy(id = "nameOnCardError")
	public WebElement nameOnCardError;
	
	@FindBy(id = "securityCodeError")
	public WebElement securityCodeError;
	
	@FindBy(id = "nameError")
	public WebElement nameError;
	
	@FindBy(id = "phoneNumberError")
	public WebElement phoneNumberError;
	
	@FindBy(id = "emailError")
	public WebElement emailError;
	
	@FindBy(id = "previousPasswordError")
	public WebElement previousPasswordError;
	
	@FindBy(id = "newPasswordError")
	public WebElement newPasswordError;
	
	@FindBy(id = "confirmPasswordError")
	public WebElement confirmPasswordError;
	
	@FindBy(xpath = "//div[@class='account__address-single']")
	public WebElement addressBoxes;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
