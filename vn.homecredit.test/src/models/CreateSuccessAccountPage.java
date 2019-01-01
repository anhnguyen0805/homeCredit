package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import entities.Account;
import entities.Customer;
import services.web.SeleniumBot;
import services.web.WebElementFinder;

public class CreateSuccessAccountPage extends AbstractModel implements IModel {

	private final String SUCCESSFUL_MESSAGE = "Account Generated Successfully!!!";
	private final String ACCOUNT_ID_LABEL = "Account ID";
	private final String CUSTOMER_ID_LABEL = "Customer ID";
	private final String CUSTOMER_NAME_LABEL = "Customer Name";
	private final String EMAIL_LABEL = "Email";
	private final String ACCOUNT_TYPE_LABEL = "Account Type";
	private final String DATE_OF_OPENING_LABEL = "Date of Opening";
	private final String CURRENT_AMOUNT_LABEL = "Current Amount";

	public CreateSuccessAccountPage(WebDriver webDriver, WebElementFinder finder, SeleniumBot bot) {
		super(webDriver, finder, bot);
	}

	public void verifyCreatedAccount(Customer customer, Account account) {
		WebElement tableContent = finder.findElement(By.xpath("//table[@id='account']"));
		WebElement successMessTr = finder.findElementInContainer(tableContent,
				By.xpath(".//*[contains(text(), '" + SUCCESSFUL_MESSAGE + "')]"));
		Assert.assertNotNull(successMessTr);

		List<WebElement> trList = finder.findElementListInContainer(tableContent, By.xpath(".//tr"));
		for (WebElement tr : trList) {
			String trText = tr.getText();

			if (trText.startsWith(ACCOUNT_ID_LABEL)) {
				String accountId = finder.findElementListInContainer(tr, By.xpath(".//td")).get(1).getText().trim();
				account.setAccountId(accountId);
			}

			// Verify customer id
			if (trText.startsWith(CUSTOMER_ID_LABEL)) {
				Assert.assertTrue(trText.endsWith(customer.getCustomerId()));
			}
			// Verify customer name
			else if (trText.startsWith(CUSTOMER_NAME_LABEL)) {
				Assert.assertTrue(trText.endsWith(customer.getCustomerName()));
			}
			// Verify email
			else if (trText.startsWith(EMAIL_LABEL)) {
				Assert.assertTrue(trText.endsWith(customer.getEmail()));
			}
			// Verify account type
			else if (trText.startsWith(ACCOUNT_TYPE_LABEL)) {
				Assert.assertTrue(trText.endsWith(account.getAccountType()));
			}
			// Verify Date of opening
			else if (trText.startsWith(DATE_OF_OPENING_LABEL)) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String doOStr = df.format(account.getDateOfOpening());
				Assert.assertTrue(trText.endsWith(doOStr));
			}
			// Verify current amount
			else if (trText.startsWith(CURRENT_AMOUNT_LABEL)) {
				Assert.assertTrue(trText.endsWith(String.valueOf(account.getCurrentAmount())));
			}
		}
	}

}
