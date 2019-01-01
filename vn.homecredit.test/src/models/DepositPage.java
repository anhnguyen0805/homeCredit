package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import entities.Account;
import services.web.SeleniumBot;
import services.web.WebElementFinder;

public class DepositPage extends AbstractModel implements IModel {
	
	private final String DESCRIPTION = "Deposit on ";

	public DepositPage(WebDriver webDriver, WebElementFinder finder, SeleniumBot bot) {
		super(webDriver, finder, bot);
	}

	public void deposit(Account account, Long amount) {
		// Fill account id
		WebElement accountNo = finder.findElement(By.xpath("//input[@type='text' and (@name='accountno')]"));
		bot.sendKeys(accountNo, account.getAccountId());
		
		// Fill amount
		WebElement amountText = finder.findElement(By.xpath("//input[@type='text' and (@name='ammount')]"));
		bot.sendKeys(amountText, String.valueOf(amount));
		
		// Fill description
		WebElement desc = finder.findElement(By.xpath("//input[@type='text' and (@name='desc')]"));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dodStr = df.format(Calendar.getInstance().getTime());
		bot.sendKeys(desc, DESCRIPTION + dodStr);
		
		clickSubmitBtn();
		
	}
	
	
}
