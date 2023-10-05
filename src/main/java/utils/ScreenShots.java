package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShots {

	
	public static void screenshot(WebDriver driver) {
		
		TakesScreenshot poza = (TakesScreenshot) driver;
		File picture = poza.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		try {
			Files.copy(picture, new File("poze/" +timestamp+ ".png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
