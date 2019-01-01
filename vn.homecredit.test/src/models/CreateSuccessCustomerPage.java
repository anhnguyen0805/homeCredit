package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import entities.Customer;
import services.web.SeleniumBot;
import services.web.WebElementFinder;

public class CreateSuccessCustomerPage extends AbstractModel implements IModel {

	private final String SUCCESSFUL_MESSAGE = "Customer Registered Successfully!!!";
	private final String CUSTOMER_ID_LABEL = "Customer ID";
	private final String CUSTOMER_NAME_LABEL = "Customer Name";
	private final String GENDER_LABEL = "Gender";
	private final String GENDER_MALE_VALUE = "male";
	private final String GENDER_FEMALE_VALUE = "female";
	private final String BIRTHDAY_LABEL = "Birthdate";
	private final String ADDRESS_LABEL = "Address";
	private final String CITY_LABEL = "City";
	private final String STATE_LABEL = "State";
	private final String PIN_LABEL = "Pin";
	private final String MOBILE_LABEL = "Mobile No.";
	private final String EMAIL_LABEL = "Email";

	public CreateSuccessCustomerPage(WebDriver webDriver, WebElementFinder finder, SeleniumBot bot) {
		super(webDriver, finder, bot);
	}

	public void verifyCreatedCustomer(Customer customer) {
		WebElement tableContent = finder.findElement(By.xpath("//table[@id='customer']"));
		WebElement successMessTr = finder.findElementInContainer(tableContent,
				By.xpath(".//*[contains(text(), '" + SUCCESSFUL_MESSAGE + "')]"));
		Assert.assertNotNull(successMessTr);

		List<WebElement> trList = finder.findElementListInContainer(tableContent, By.xpath(".//tr"));
		for (WebElement tr : trList) {
			String trText = tr.getText();

			if (trText.startsWith(CUSTOMER_ID_LABEL)) {
				String customerId = finder.findElementListInContainer(tr, By.xpath(".//td")).get(1).getText().trim();
				customer.setCustomerId(customerId);
			}

			// Verify customer name
			if (trText.startsWith(CUSTOMER_NAME_LABEL)) {
				Assert.assertTrue(trText.endsWith(customer.getCustomerName()));
			}
			// Verify gender
			else if (trText.startsWith(GENDER_LABEL)) {
				if (customer.isMale()) {
					Assert.assertTrue(trText.endsWith(GENDER_MALE_VALUE));
				} else {
					Assert.assertTrue(trText.endsWith(GENDER_FEMALE_VALUE));
				}
			}
			// Verify birthday
			else if (trText.startsWith(BIRTHDAY_LABEL)) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String dobStr = df.format(customer.getDateOfBirth());
				Assert.assertTrue(trText.endsWith(dobStr));
			}
			// Verify address
			else if (trText.startsWith(ADDRESS_LABEL)) {
				Assert.assertTrue(trText.endsWith(customer.getAddress()));
			}
			// Verify city
			else if (trText.startsWith(CITY_LABEL)) {
				Assert.assertTrue(trText.endsWith(customer.getCity()));
			}
			// Verify state
			else if (trText.startsWith(STATE_LABEL)) {
				Assert.assertTrue(trText.endsWith(customer.getState()));
			}
			// Verify pin
			else if (trText.startsWith(PIN_LABEL)) {
				Assert.assertTrue(trText.endsWith(String.valueOf(customer.getPin())));
			}
			// Verify mobile
			else if (trText.startsWith(MOBILE_LABEL)) {
				Assert.assertTrue(trText.endsWith(String.valueOf(customer.getMobileNum())));
			}
			// Verify email
			else if (trText.startsWith(EMAIL_LABEL)) {
				Assert.assertTrue(trText.endsWith(customer.getEmail()));
			}
		}
	}
}
