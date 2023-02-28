package tek.capstone.bdd.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.bdd.framework.base.BaseSetup;

public class RetailOrderPage extends BaseSetup{

	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//h1[@class='orders__title']")
	public WebElement yourOrdersText;
	
	@FindBy(xpath = "//p[contains(text(), 'Placed')]")
	public WebElement numOrdersPlaced;
	
	@FindBy(xpath = "//p[text()='Show Details']")
	public List<WebElement> orders;
	
	@FindBy(id = "cancelBtn")
	public WebElement cancelBtn;
	
	@FindBy(id = "returnBtn")
	public WebElement returnBtn;
	
	@FindBy(id = "buyAgainBtn")
	public WebElement buyAgainBtn;
	
	@FindBy(id = "reasonInput")
	public WebElement reasonInput;
	
	@FindBy(id = "orderSubmitBtn")
	public WebElement cancelOrReturnOrderFinalBtn;
	
	@FindBy(xpath = "//p[text()='Return was successfull' or text()='Your Order Has Been Cancelled']")
	public WebElement orderCancellationOrReturnSuccessfulMessage;
	
	@FindBy(id = "dropOffInput")
	public WebElement dropOff;
	
	@FindBy(id = "reviewBtn")
	public WebElement reviewBtn;
	
	@FindBy(id = "headlineInput")
	public WebElement headlineInput;
	
	@FindBy(id = "descriptionInput")
	public WebElement descriptionInput;
	
	@FindBy(id = "reviewSubmitBtn")
	public WebElement addYourReviewBtn;
	
	@FindBy(xpath = "//div[text()='Your review was added successfully']")
	public WebElement reviewAddedMessage;
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
