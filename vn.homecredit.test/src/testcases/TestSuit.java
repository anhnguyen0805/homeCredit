package testcases;

import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import configuration.Configuration;
import entities.Account;
import entities.Customer;
import entities.Transaction;
import models.CreateSuccessAccountPage;
import models.CreateSuccessCustomerPage;
import models.DepositPage;
import models.HomePage;
import models.LoginPage;
import models.NewAccountPage;
import models.NewCustomerPage;
import models.TransactionDetailsPage;
import services.web.AbstractTest;
import services.web.SeleniumBot;
import services.web.WebDriverBuilder;
import services.web.WebElementFinder;
import services.web.WebDriverBuilder.WebDriverType;

public class TestSuit {
	
	
	protected static WebDriver webDriver;
	protected static WebElementFinder finder;
	protected static SeleniumBot bot;
	
	protected final String NEW_ACCOUNT_ENTRY_NAME = "New Account";
	protected final String NEW_CUSTOMER_ENTRY_NAME = "New Customer";
	protected final String DEPOSIT_ENTRY_NAME = "Deposit";
	
	private LoginPage loginPage;
	private HomePage homePage;
	private NewCustomerPage newCustomerPage;
	private CreateSuccessCustomerPage createSuccessCustomerPage;
	private NewAccountPage newAccountPage;
	private CreateSuccessAccountPage createSuccessAccountPage;
	private DepositPage depositPage;
	private TransactionDetailsPage transactionDetailsPage;
	
	private static Customer customer;
	private static Account account;
	private static Transaction transaction;
	private static Long amount;
	
	
	@BeforeClass
	public static void initTestCase(){
		
		Configuration.loadProjectProperties();
		webDriver = WebDriverBuilder.createWebDriver(WebDriverType.FIREFOX);
		finder = WebElementFinder.getInstance(webDriver);
		bot = new SeleniumBot();
		
		customer = new Customer(null, "CustomerU", true, Calendar.getInstance().getTime(), "address", "city", "state", 123456,
				0123456, "a.u@a.com", "password");
		account = new Account(null, "Savings" , Calendar.getInstance().getTime(), 10000);
		transaction = new Transaction();
		amount = (long) 10000;
		
	}
	@Before
	public void login(){
		loginPage = new LoginPage(webDriver, finder, bot);
		homePage = new HomePage(webDriver, finder, bot);
	}

	@Test
	public void createNewCustomerAndVerifyIt(){
		loginPage.login();
		newCustomerPage = new NewCustomerPage(webDriver, finder, bot);
		createSuccessCustomerPage = new CreateSuccessCustomerPage(webDriver, finder, bot);
		homePage.selectEntry(NEW_CUSTOMER_ENTRY_NAME);
		
		// Create new customer
		newCustomerPage.createNewCustomer(customer);
		
		// Verify new created customer is correct.
		createSuccessCustomerPage.verifyCreatedCustomer(customer);
	}
	
	@Test
	public void createNewAccountAndVerifyIt(){
		newAccountPage = new NewAccountPage(webDriver, finder, bot);
		homePage.selectEntry(NEW_ACCOUNT_ENTRY_NAME);
		newAccountPage.createNewAccount(customer, account);
		
		createSuccessAccountPage = new CreateSuccessAccountPage(webDriver, finder, bot);
		createSuccessAccountPage.verifyCreatedAccount(customer, account);
	}
	
	@Test
	public void verifyDepositFunction(){
		depositPage = new DepositPage(webDriver, finder, bot);
		homePage.selectEntry(DEPOSIT_ENTRY_NAME);
		depositPage.deposit(account, amount);
		
		transactionDetailsPage = new TransactionDetailsPage(webDriver, finder, bot);
		transactionDetailsPage.verifyTransaction(account, transaction, amount);
	}
	
	@AfterClass
    public static void teardown() {
      bot.closeWebBrowser(webDriver);
    }
}
