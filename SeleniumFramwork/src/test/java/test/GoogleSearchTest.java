package test;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.GooggleSearchPage;



public class GoogleSearchTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		googleSearch();
		
	}
	
	
	
	/*
	 * 
	 *
	 *
	 * 
	 */
	public static void googleSearch() {
		
		String projectPath = System.getProperty("user.dir");		
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		
		//goto google.com
		driver.get("https://google.com");
		
		//enter text in search textbox
		//driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		
		GooggleSearchPage.textbox_search(driver).sendKeys("Automation Step by Step");
		
		
		//click on search button
		//driver.findElement(By.name("btnK")).click()
		//driver.findElement(By.xpath("//input[@name='btnK']")).click();
		//driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
		GooggleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		WebDriverWait wait  = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='btnK']"))); 
		
		
		//close browser
		driver.close();
		
		
		
	}

}
