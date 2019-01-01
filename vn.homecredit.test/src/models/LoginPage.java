package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import configuration.Configuration;
import services.web.SeleniumBot;
import services.web.WebElementFinder;

public class LoginPage extends AbstractModel implements IModel {

	private final String URL ="http://demo.guru99.com/v4/";
	
	public LoginPage(WebDriver webDriver, WebElementFinder finder, SeleniumBot bot) {
		super(webDriver, finder, bot);
	}
	
	public void login() {
		webDriver.get(URL);
		webDriver.manage().window().maximize();
		WebElement userText = finder.findElement(By.xpath("//input[@type='text' and (@name='uid')]"));
		bot.sendKeys(userText, Configuration.USER_NAME);
		WebElement passwordText = finder.findElement(By.xpath("//input[@type='password' and (@name='password')]"));
		bot.sendKeys(passwordText, Configuration.PASSWORD);
		WebElement loginBtn = finder.findElement(By.xpath("//input[@type='submit' and (@name='btnLogin')]"));
		bot.click(loginBtn);
		bot.sleepInMiliSeconds(2000);
	}
}
