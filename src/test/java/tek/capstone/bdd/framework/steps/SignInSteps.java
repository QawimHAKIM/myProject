package tek.capstone.bdd.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.bdd.framework.pages.POMFactory;
import tek.capstone.bdd.framework.utilities.BrowserUtilities;
import tek.capstone.bdd.framework.utilities.DataGenerator;

public class SignInSteps extends BrowserUtilities {
	
	private POMFactory factory = new POMFactory();

	//1
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String realTitle = "React App";
		Assert.assertEquals(actualTitle, realTitle);
		Assert.assertTrue(isElementDisplayed(factory.homePage().tekSchoolLogo));
		logger.info("user is on retail website");
		logger.info("actual title " + actualTitle + " equals expected title: " + realTitle);
	}
	
	@When("User click on Sign in option")
	public void userClickOnSignIn() {
		click(factory.homePage().signInBtn);
		logger.info("user clicked on sign in button");
	}
	
	@And("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(factory.signInPage().emailField, DataGenerator.getCredentials(email));
		sendText(factory.signInPage().passwordField, DataGenerator.getCredentials(password));
		logger.info("user entered email " + email + " and password " + password);
	}
	
	@And("User click on login button")
	public void userClickOnLoginBtn() {
		click(factory.signInPage().loginPageBtn);
		logger.info("user clicked on login button");
	}
	
	@Then("User should be logged in into Account")
	public void userShouldBeLoggedIn() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().accountBtn));
		logger.info("user has logged in into account");
	}
	
	@And("User click on Create New Account button")
	public void userClickOnNewAccountBtn() {
		click(factory.signInPage().createNewAccountBtn);
	}
	
	//2
	@And("User fill the signUp information with below data")
	public void userFillTheSignUpForm(DataTable dataTable) {
		List<Map<String, String>> signUpInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.signInPage().signUpName, DataGenerator.data(signUpInfo.get(0).get("name")));
		sendText(factory.signInPage().signUpEmail, DataGenerator.data(signUpInfo.get(0).get("email")));
		sendText(factory.signInPage().signUpPassword, signUpInfo.get(0).get("password"));
		sendText(factory.signInPage().signUpConfirmPass, signUpInfo.get(0).get("confirmPassword"));
		logger.info("user filled the signUp information form");
	}
	
	@And("User click on SignUp button")
	public void userClickOnSignUpBtn() {
		click(factory.signInPage().signupBtn);
		logger.info("user has clicked on signUp button");
	}
	
	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccount() {
		Assert.assertTrue(isElementDisplayed(factory.accountPage().userText));
		logger.info("user has logged into account page");
	}
	
}
