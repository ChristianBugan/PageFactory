package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FindBrokenLinks extends BaseTest {

	static List<String> brokenLinks = new ArrayList<String>();
	
	
	@Test
	public void testBrokenLinks() throws IOException {
		
		List<WebElement> links = driver.findElements(By.cssSelector("a[href*='http']"));
		
		System.out.println(links.size());
		
		System.out.println("----------------------");
		checkLinks("https://keyfood.ro/product-category/breads-bakery/packaged-breads/");
		System.out.println("----------------------");
		
		System.out.println("--------Bad URL--------");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('href', 'https://keyfood.ro/product-category/breads-bake/')", 
				links.get(2));
		System.out.println("----------------- ");
		
		
		for(int i = 0; i < links.size(); i++) {
			
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			
			if(url == null) {
				continue;
			}
			checkLinks(url);
		}
		
		assertTrue(brokenLinks.size() ==0);
		
	}
	
	
	public static void checkLinks(String linkUrl) throws IOException {
		
		try {
			
			@SuppressWarnings("deprecation")
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(2000);
			httpUrlConnection.connect();
			
			if(httpUrlConnection.getResponseCode() == 200 ) {
				
				System.out.println(linkUrl + " - " + httpUrlConnection.getResponseCode());
			}
			
			if(httpUrlConnection.getResponseCode() == 404) {
				
				System.out.println(linkUrl + " - " + httpUrlConnection.getResponseCode());
				brokenLinks.add(linkUrl);
				
			}
			
		}catch(MalformedURLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
