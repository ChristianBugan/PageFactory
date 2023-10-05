package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import pages.BasePage;

public class BaseTest {

	public BasePage app;
	public static WebDriver driver;
	
	@Parameters({"appURL"})
	@BeforeClass(alwaysRun = true)
	public void setup(String url) {
		
		driver = new ChromeDriver();
		
		//driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();//face maximize la browser.
		
		driver.get(url);
		
		app = new BasePage(driver);
		
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(4000); // BAD PRACTICE - aduci timpi morti
		//driver.close(); // inchide tabul curent
		driver.quit(); // inchide browserul indiferent de cate taburi are deschise.
	}
	
	
	@AfterMethod
	public void recordFailure(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus() ) {
			
			
			TakesScreenshot poza = (TakesScreenshot) driver;
			File picture = poza.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			try {
				Files.copy(picture, new File("poze/"+result.getName()+"  -  " +timestamp+ ".png"));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
