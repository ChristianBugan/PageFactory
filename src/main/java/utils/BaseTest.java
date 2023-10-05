package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pages.BasePage;

public class BaseTest {

	public BasePage app;
	public static WebDriver driver;
	
	@Parameters({"appURL"})
	@BeforeMethod(alwaysRun = true)
	public void setup(String url) {
		
		driver = new ChromeDriver();
		
		//driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();//face maximize la browser.
		
		driver.get(url);
		
		app = new BasePage();
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(4000); // BAD PRACTICE - aduci timpi morti
		//driver.close(); // inchide tabul curent
		driver.quit(); // inchide browserul indiferent de cate taburi are deschise.
	}
	
}
