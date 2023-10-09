package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class MyAccountPage extends SeleniumWrappers {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	public WebElement usernameField;
	
	@FindBy(id="password")
	public WebElement passwordField;
	
	@FindBy(css ="button[name='login']")
	public WebElement loginButton;
	
	@FindBy(css = "div[class='woocommerce-MyAccount-content']")
	public WebElement usernameGreetings;
	
	@FindBy(css ="a[href*='logout']")
	public WebElement logoutButton;
	
	/*String idDinamic;
	@FindBy(css="div[class='woocommerce-MyAccount-content "+ idDinamic+"']");
	public WebElement testElement; */
	
	
	
	
	public void loginInApp(String user, String pass) {
		
		sendKeys(usernameField, user);
		sendKeys(passwordField, pass);
		click(loginButton);
	}

}
