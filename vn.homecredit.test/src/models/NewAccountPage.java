package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import entities.Account;
import entities.Customer;
import services.web.SeleniumBot;
import services.web.WebElementFinder;

public class NewAccountPage extends AbstractModel implements IModel {

	private final Integer DEFAULT_INIT_DEPOSIT = 10000;
	
	public NewAccountPage(WebDriver webDriver, WebElementFinder finder, SeleniumBot bot) {
		super(webDriver, finder, bot);
	}

	public void createNewAccount(Customer customer, Account account) {
		// Fill customer id
		WebElement idText = finder.findElement(By.xpath("//input[@type='text' and (@name='cusid')]"));
		bot.sendKeys(idText, customer.getCustomerId());
		
		// Select Account type
		WebElement type = finder.findElement(By.xpath("//select[@name='selaccount']"));
		bot.selectOptionWithText(type, account.getAccountType());
		
		// Fill init deposit
		WebElement initDeposit = finder.findElement(By.xpath("//input[@type='text' and (@name='inideposit')]"));
		if(account.getCurrentAmount() >= 10000){
			bot.sendKeys(initDeposit, String.valueOf(account.getCurrentAmount()));			
		}else{
			bot.sendKeys(initDeposit, String.valueOf(DEFAULT_INIT_DEPOSIT));
		}
		
		clickSubmitBtn();
	}

}
