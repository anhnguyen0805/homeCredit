package services.web;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumBot {
	public void click(WebElement webElement) {
		if (webElement.isDisplayed()) {
			webElement.click();
		}
	}

	public void sendKeys(WebElement webElement, String content) {
		webElement.sendKeys(content);
	}

	public void selectOptionWithText(WebElement dropdownElement, String text) {
		Select select = new Select(dropdownElement);
		select.selectByVisibleText(text);
	}

	public void closeWebBrowser(WebDriver webDriver) {
		if(webDriver != null){
			webDriver.quit();
			killGeckodriverProcess();
		}
		
	}

	private static void killGeckodriverProcess() {
		boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString()
				.indexOf("-agentlib:jdwp") > 0;
		try {
			if (isDebug)
				Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sleepInMiliSeconds(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
