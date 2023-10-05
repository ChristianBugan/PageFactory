package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.ScreenShots;

public class LoginTest extends BaseTest {

	@Parameters({"user", "pass"})
	@Test
	public void loginTest(String username, String password) {
		
		app.click(app.menu.myAccountLink);
		app.myAccount.loginInApp(username, password);
		
		assertTrue(app.checkElementIsDisplayed(app.myAccount.usernameGreetings));
		//sau:
		//assertTrue(app.myAccount.usernameGreetings.isDisplayed());
		
		ScreenShots.screenshot(driver);
		
	}
	
	
	
}
