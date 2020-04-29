package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		googleSearchTest();
		
	}
	
	public static void googleSearchTest() {
		
String projectPath = System.getProperty("user.dir");		
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		GoogleSearchPageObjects searchPagObj = new GoogleSearchPageObjects(driver);
		
		driver.get("https://google.com");
		
		searchPagObj.setTextInSearchBox("A B C D");
		 
		searchPagObj.clickSearchButton();
		
		WebDriverWait wait  = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='btnK']"))); 
		
		driver.close();
	}

}
