package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import entities.Customer;
import services.ultilize.Ultilize;
import services.web.SeleniumBot;
import services.web.WebElementFinder;

public class NewCustomerPage extends AbstractModel implements IModel {

	private final String DEFAULT_EMAIL = "a.a@a.com";
	private Ultilize ultilize;

	public NewCustomerPage(WebDriver webDriver, WebElementFinder finder, SeleniumBot bot) {
		super(webDriver, finder, bot);
		ultilize = new Ultilize();
	}

	public void createNewCustomer(Customer customer) {
		// Fill customer name
		WebElement nameText = finder.findElement(By.xpath("//input[@type='text' and (@name='name')]"));
		bot.sendKeys(nameText, customer.getCustomerName());

		// Select gender
		WebElement genderRadioBtn = null;
		String valueGender = "m";
		if (!customer.isMale()) {
			valueGender = "f";
		}
		genderRadioBtn = finder.findElement(By.xpath("//input[@type='radio' and (@value='" + valueGender + "')]"));
		bot.click(genderRadioBtn);

		// Fill date of birth
		WebElement dobText = finder.findElement(By.xpath("//input[@id='dob']"));
		dobText.sendKeys(Keys.TAB);
		Date dateOfBirth = customer.getDateOfBirth();
		fillDateOfBirth(dateOfBirth);

		// Fill address
		WebElement addressTextArea = finder.findElement(By.xpath("//textarea[@name='addr']"));
		bot.sendKeys(addressTextArea, customer.getAddress());

		// Fill city
		WebElement cityText = finder.findElement(By.xpath("//input[@type='text' and (@name='city')]"));
		bot.sendKeys(cityText, customer.getCity());

		// Fill state
		WebElement stateText = finder.findElement(By.xpath("//input[@type='text' and (@name='state')]"));
		bot.sendKeys(stateText, customer.getState());

		// Fill pin
		WebElement pinText = finder.findElement(By.xpath("//input[@type='text' and (@name='pinno')]"));
		bot.sendKeys(pinText, String.valueOf(customer.getPin()));

		// Fill mobile
		WebElement mobileText = finder.findElement(By.xpath("//input[@type='text' and (@name='telephoneno')]"));
		bot.sendKeys(mobileText, String.valueOf(customer.getMobileNum()));

		// Fill email
		WebElement emailText = finder.findElement(By.xpath("//input[@type='text' and (@name='emailid')]"));
		String email = customer.getEmail();
		if(!ultilize.validateEmail(email)){
			email = DEFAULT_EMAIL;
		}
		bot.sendKeys(emailText, email);

		// Fill password
		WebElement passwordText = finder.findElement(By.xpath("//input[@type='password' and (@name='password')]"));
		bot.click(passwordText);
		bot.sendKeys(passwordText, customer.getPassword());

		clickSubmitBtn();
	}

	private void fillDateOfBirth(Date dateOfBirth) {
		Actions action = new Actions(webDriver);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		String dobStr = df.format(dateOfBirth);
		String[] dobArr = dobStr.split("/");
		int monthNum = Integer.parseInt(dobArr[0]);
		int dateNum = Integer.parseInt(dobArr[1]);
		
		String currentDate = df.format(Calendar.getInstance().getTime());
		String[] curDateArr = currentDate.split("/");
		int curMonthNum = Integer.parseInt(curDateArr[0]);
		int curDateNum = Integer.parseInt(curDateArr[1]);
		// Reset month
		for (int i = 0; i <= curMonthNum - 1; i++) {
			action.sendKeys(Keys.ARROW_DOWN).perform();
		}
		// Apply new month
		for (int i = 0; i <= monthNum - 1; i++) {
			action.sendKeys(Keys.ARROW_UP).perform();
		}
		action.sendKeys(Keys.TAB);
		
		// Reset date
		for (int i = 0; i <= curDateNum - 1; i++) {
			action.sendKeys(Keys.ARROW_DOWN).perform();
		}
		// Apply new date
		for (int i = 0; i <= dateNum - 1; i++) {
			action.sendKeys(Keys.ARROW_UP).perform();
		}
		action.sendKeys(Keys.TAB);
		
		// Apply new year
		for(String numStr : dobArr[2].split("")){
			Integer number = Integer.parseInt(numStr);
			Keys key = ultilize.getReflectKey(number);
			action.sendKeys(key).perform();
		}
		
	}

}
