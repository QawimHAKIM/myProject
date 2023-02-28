package tek.capstone.bdd.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.bdd.framework.base.BaseSetup;

public class RetailSignInPage extends BaseSetup{

	public RetailSignInPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//h1[text()='Sign in']")
	public WebElement signInPageLogo;
	
	@FindBy(id = "email")
	public WebElement emailField;
	
	@FindBy(id = "password")
	public WebElement passwordField;
	
	@FindBy(xpath = "//button[text()='Login']")
	public WebElement loginPageBtn;
	
	@FindBy(linkText = "Create New Account")
	public WebElement createNewAccountBtn;
	
	@FindBy(id = "newCompanyAccount")
	public WebElement wantToSellSomethingLink;
	
	@FindBy(id = "nameInput")
	public WebElement signUpName;
	
	@FindBy(id = "emailInput")
	public WebElement signUpEmail;
	
	@FindBy(id = "passwordInput")
	public WebElement signUpPassword;
	
	@FindBy(id = "confirmPasswordInput")
	public WebElement signUpConfirmPass;
	
	@FindBy(id = "signupBtn")
	public WebElement signupBtn;
	
	//Errors
	@FindBy(id = "nameError")
	public WebElement signUpNameError;
	
	@FindBy(id = "emailError")
	public WebElement signUpEmailError;
	
	@FindBy(id = "passwordError")
	public WebElement signUpPassError;
	
	@FindBy(id = "confirmPasswordError")
	public WebElement signUpConfirmPassError;
	
	
	
	
	
	
	
	
	
}
