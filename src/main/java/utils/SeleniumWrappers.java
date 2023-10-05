package utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers extends BaseTest {
	
	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	
	public void click(WebElement element) {
		
		try {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		//WebElement element = driver.findElement(locator);	
		element.click();
		
		}catch(Exception e) {
			
		}	
	}


	public void scrollByPixels(int x, int y) {
		
		Actions action = new Actions(driver);
		action.scrollByAmount(x, y).perform();
		
	}
	
	
	public void scrollVertically(int y) {
		
		Actions action = new Actions(driver);
		action.scrollByAmount(0, y).perform();
		
	}
	
public void scrollHorizontally(int x) {
		
		Actions action = new Actions(driver);
		action.scrollByAmount(x, 0).perform();
		
		
	}
	
	public WebElement returnElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public void sendKeys(WebElement element, String text) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		element.clear();
		element.sendKeys(text);
	}
	
	
	public boolean checkElementIsDisplayed(WebElement element) {
		
		return element.isDisplayed();
	}
	
	

	public String getElementText(By locator) {
		
		return driver.findElement(locator).getText();	
		
	}
	
	

	public Boolean verifyIsDisplayed(By locator) {
		
		return driver.findElement(locator).isDisplayed();	
		
	}
	
	public void draggingAndDropppingSlider(By locator, int x,int y) {
		
		WebElement element = driver.findElement(locator);
		
		Actions action = new Actions(driver);
		//action.dragAndDropBy(element, 0, 0);
		action.moveToElement(element).clickAndHold(element).moveByOffset(x,y).release().perform();
		
	}
	
	
}
