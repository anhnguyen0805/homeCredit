package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import entities.Account;
import entities.Transaction;
import services.web.SeleniumBot;
import services.web.WebElementFinder;

public class TransactionDetailsPage extends AbstractModel implements IModel {

	private final String DETAILS_MESSAGE = "Transaction details of Deposit for Account ";
	private final String TRANSACTION_ID_LABEL = "Transaction ID";
	private final String ACCOUNT_NO_LABEL = "Account No";
	private final String AMOUNT_CREDIT_LABEL = "Amount Credited";
	private final String TRANSACTION_TYPE_LABEL = "Type of Transaction";
	private final String TRANSACTION_TYPE_VALUE = "Deposit";
	private final String CURRENT_BALANCE_LABEL = "Current Balance";

	public TransactionDetailsPage(WebDriver webDriver, WebElementFinder finder, SeleniumBot bot) {
		super(webDriver, finder, bot);
	}

	public void verifyTransaction(Account account, Transaction transaction, Long amount) {
		WebElement tableContent = finder.findElement(By.xpath("//table[@id='deposit']"));
		WebElement detailsMessTr = finder.findElementInContainer(tableContent,
				By.xpath(".//*[contains(text(), '" + DETAILS_MESSAGE + account.getAccountId() + "')]"));
		Assert.assertNotNull(detailsMessTr);

		List<WebElement> trList = finder.findElementListInContainer(tableContent, By.xpath(".//tr"));
		for (WebElement tr : trList) {
			String trText = tr.getText();

			if (trText.startsWith(TRANSACTION_ID_LABEL)) {
				String transactionId = finder.findElementListInContainer(tr, By.xpath(".//td")).get(1).getText().trim();
				transaction.setTransactionId(transactionId);
			}

			// Verify account id
			if (trText.startsWith(ACCOUNT_NO_LABEL)) {
				Assert.assertTrue(trText.endsWith(account.getAccountId()));
			}
			// Verify Amount Credited
			else if (trText.startsWith(AMOUNT_CREDIT_LABEL)) {
				Assert.assertTrue(trText.endsWith(String.valueOf(account.getCurrentAmount())));
			}
			// Verify transaction type
			else if (trText.startsWith(TRANSACTION_TYPE_LABEL)) {
				Assert.assertTrue(trText.endsWith(TRANSACTION_TYPE_VALUE));
			}
			// Verify current balance
			else if (trText.startsWith(CURRENT_BALANCE_LABEL)) {
				Long current = account.getCurrentAmount() + amount;
				Assert.assertTrue(trText.endsWith(String.valueOf(current)));
			}
		
		}
	}
}
