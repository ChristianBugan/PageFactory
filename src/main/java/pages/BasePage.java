package pages;

import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class BasePage extends SeleniumWrappers {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	
	public MenuPage menu = new MenuPage(driver);
	
	public MyAccountPage myAccount = new MyAccountPage(driver);
	
	
	
	
}
