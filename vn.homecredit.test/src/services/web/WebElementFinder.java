package services.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementFinder {
	private static WebElementFinder instance;
	private WebDriver webDriver;
    private WebElementFinder(WebDriver webDriver) {
    	this.webDriver = webDriver;
    }

    public static WebElementFinder getInstance(WebDriver webDriver) {
        if (instance == null) {
            instance = new WebElementFinder(webDriver);
        }
        return instance;
    }
    
    public WebElement findElement(By by){
    	try {
    		return webDriver.findElement(by);	
		} catch (Exception e) {
			return null;
		}   	
    }
    
    public List<WebElement> findElementList(By by){
    	return webDriver.findElements(by);
    }
    
    public WebElement findElementInContainer(WebElement container, By by){
    	try {
			return container.findElement(by);
		} catch (Exception e) {
			return null;
		}
    }
    
    public List<WebElement> findElementListInContainer(WebElement container, By by){
    	return container.findElements(by);
    }
}

