package tek.capstone.bdd.framework.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.capstone.bdd.framework.utilities.BrowserUtilities;

public class BaseUITest extends BrowserUtilities{

	@Before
	public void setupTest() {
		super.setupBrowser();
	}
	
	@After
	public void closeTest(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenShot = takeScreenshotAsBytes();
			scenario.attach(screenShot, "image/png", scenario.getName() + " scenario failed");
		}
		super.quitBrowser();
	}
}
