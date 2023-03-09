package tek.capstone.bdd.framework.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import tek.capstone.bdd.framework.config.Browser;
import tek.capstone.bdd.framework.config.ChromeBrowser;
import tek.capstone.bdd.framework.config.ChromeHeadless;
import tek.capstone.bdd.framework.config.EdgeBrowser;
import tek.capstone.bdd.framework.config.FireFoxBrowser;
import tek.capstone.bdd.framework.utilities.ReadYamlFiles;

public class BaseSetup {

	private final ReadYamlFiles envVariables;
	private static WebDriver webDriver;
	public static Logger logger;

	public BaseSetup() {
		String filePath = System.getProperty("user.dir") + "/src/main/resources/env_config2.yml";
		String log4jPath = System.getProperty("user.dir") + "/src/main/resources/log4j.properties";

		try {
			envVariables = ReadYamlFiles.getInstance(filePath);
		} catch (FileNotFoundException e) {
			System.out.println("Failed to load the yml file");
			e.printStackTrace();
			throw new RuntimeException("Failed to load environment context with message " + e.getMessage());
		}
		logger = logger.getLogger("logger_file");
		PropertyConfigurator.configure(log4jPath);
	}

	public WebDriver getDriver() {
		return webDriver;
	}

	public void setupBrowser() {
		HashMap uiProperty = envVariables.getYamlProperty("ui");
		String url = uiProperty.get("url").toString();
		Browser browser;
		switch (uiProperty.get("browser").toString().toLowerCase()) {
		case "chrome":
			if ((boolean) uiProperty.get("headless")) {
				browser = new ChromeHeadless();
			} else {
				browser = new ChromeBrowser();
			}
			webDriver = browser.openBrowser(url);
			break;
		case "firefox":
			browser = new FireFoxBrowser();
			webDriver = browser.openBrowser(url);
			break;
		case "edge": 
			browser = new EdgeBrowser();
			webDriver = browser.openBrowser(url);
			break;
		default: 
			throw new RuntimeException("Unknown browser check yaml file");
		}
		
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().pageLoadTimeout(Duration.of(20, ChronoUnit.SECONDS));
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void quitBrowser() {
		if(webDriver != null) {
			webDriver.quit();
		}
	}

}
