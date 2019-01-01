package services.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import configuration.Configuration;

public class WebDriverBuilder {
	public static enum WebDriverType {
		IE, FIREFOX, CHROME
	};

	private WebDriverBuilder() {

	}

	@SuppressWarnings("deprecation")
	public static WebDriver createWebDriver(WebDriverType driverType) {
		Configuration.loadProjectProperties();
		switch (driverType) {
		case IE:
			System.setProperty("webdriver.ie.driver", Configuration.IE_DRIVER_PATH);
			DesiredCapabilities ieCap = DesiredCapabilities.internetExplorer();
			ieCap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			ieCap.setCapability("acceptSslCerts", true);
			ieCap.setCapability("ignoreZoomSetting", true);
			ieCap.setCapability("requireWindowFocus", true);
			return new InternetExplorerDriver(ieCap);
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", Configuration.FIREFOX_DRIVER_PATH);
			DesiredCapabilities firefoxCap = DesiredCapabilities.firefox();
			// firefoxCap.setCapability("marionette", true);
			firefoxCap.setCapability("acceptSslCerts", true);
			return new FirefoxDriver(firefoxCap);
		default:
			break;
		}

		return null;
	}
}
