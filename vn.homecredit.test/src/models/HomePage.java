package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import services.web.SeleniumBot;
import services.web.WebElementFinder;

public class HomePage extends AbstractModel implements IModel {
	public HomePage(WebDriver webDriver, WebElementFinder finder, SeleniumBot bot) {
		super(webDriver, finder, bot);
	}

	public void selectEntry(String entryName) {
		WebElement entry = finder.findElement(By.xpath("//a[contains(text(), '" + entryName + "')]"));
		bot.click(entry);
	}
}
