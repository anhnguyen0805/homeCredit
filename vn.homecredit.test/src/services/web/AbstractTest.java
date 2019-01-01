package services.web;

import org.openqa.selenium.WebDriver;

import configuration.Configuration;
import services.web.WebDriverBuilder.WebDriverType;

public abstract class AbstractTest {
	protected WebDriver webDriver;
	protected WebElementFinder finder;
	protected SeleniumBot bot;
	
	protected final String NEW_ACCOUNT_ENTRY_NAME = "New Account";
	protected final String NEW_CUSTOMER_ENTRY_NAME = "New Customer";
	
	public AbstractTest() {
		Configuration.loadProjectProperties();
		webDriver = WebDriverBuilder.createWebDriver(WebDriverType.FIREFOX);
		finder = WebElementFinder.getInstance(webDriver);
		bot = new SeleniumBot();
	}

}
