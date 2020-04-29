package test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestNG_Demo2 {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setUPTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver");
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void googleSearch2() {
		
		//goto google.com
		driver.get("https://google.com");
		
		//enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		
		//click on search button
		//driver.findElement(By.name("btnK")).click()
		//driver.findElement(By.xpath("//input[@name='btnK']")).click();
		driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
		//WebDriverWait wait  = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='btnK']"))); 	
	}
	
	@Test
	public void googleSearch3() {
		
		//goto google.com
		driver.get("https://google.com");
		
		//enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		
		//click on search button
		//driver.findElement(By.name("btnK")).click()
		//driver.findElement(By.xpath("//input[@name='btnK']")).click();
		driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
		//WebDriverWait wait  = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='btnK']"))); 	
	}
	
	
	@AfterTest
	public void tearDownTest() {
		
		//close browser
		driver.close();
		driver.quit();
				
		System.out.println("Test Completed Successfully!");
		
	}

}
