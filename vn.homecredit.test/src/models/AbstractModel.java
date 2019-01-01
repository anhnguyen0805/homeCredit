package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import services.web.SeleniumBot;
import services.web.WebElementFinder;

public abstract class AbstractModel {
	protected WebDriver webDriver;
	protected WebElementFinder finder;
	protected SeleniumBot bot;
	public AbstractModel(WebDriver webDriver, WebElementFinder finder, SeleniumBot bot) {
		super();
		this.webDriver = webDriver;
		this.finder = finder;
		this.bot = bot;
	}
	
	
	protected void clickSubmitBtn(){
		WebElement submitBtn = finder.findElement(By.xpath("//input[@type='submit']"));
		bot.click(submitBtn);
		bot.sleepInMiliSeconds(2000);
	}
}
