package tek.capstone.bdd.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import tek.capstone.bdd.framework.pages.POMFactory;
import tek.capstone.bdd.framework.utilities.BrowserUtilities;
import tek.capstone.bdd.framework.utilities.DataGenerator;

public class ChangePasswordSteps extends BrowserUtilities {

	POMFactory factory = new POMFactory();

	@And("User enter below information")
	public void userEnterBelowInfo(DataTable dataTable) {
		List<Map<String, String>> accountInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().previousPasswordField,
				DataGenerator.getCredentials(accountInfo.get(0).get("previousPassword")));
		sendText(factory.accountPage().newPasswordField,
				DataGenerator.getCredentials(accountInfo.get(0).get("newPassword")));
		sendText(factory.accountPage().confirmPassField,
				DataGenerator.getCredentials(accountInfo.get(0).get("confirmPassword")));
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
}
