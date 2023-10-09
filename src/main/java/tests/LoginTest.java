package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.ScreenShots;

public class LoginTest extends BaseTest {

	@Parameters({"user", "pass"})
	@Test(priority=1)
	public void loginTest(String username, String password) {
		
		app.click(app.menu.myAccountLink);
		app.myAccount.loginInApp(username, password);
		
		assertTrue(app.checkElementIsDisplayed(app.myAccount.usernameGreetings));
		//sau:
		//assertTrue(app.myAccount.usernameGreetings.isDisplayed());
		
		ScreenShots.screenshot(driver);
		assertTrue(app.myAccount.usernameGreetings.isDisplayed());
		
		app.click(app.myAccount.logoutButton);
		
	}
	
	@Parameters({"user2", "pass"})
	@Test(priority=2)
	public void loginTestInvalid(String username, String password) {
		
		app.click(app.menu.myAccountLink);
		app.myAccount.loginInApp(username, password);
		
		assertTrue(app.checkElementIsDisplayed(app.myAccount.usernameGreetings));
		ScreenShots.screenshot(driver);
		
		assertTrue(app.myAccount.usernameGreetings.isDisplayed());
		
	}
	
	
	
}
