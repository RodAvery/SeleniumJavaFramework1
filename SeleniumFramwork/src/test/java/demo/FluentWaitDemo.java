package demo;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;


public class FluentWaitDemo {
	
	public static void main(String[] args) throws InterruptedException {
		test();
		
	}
	
	public static void test() throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir");
	
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https:google.com");
		
		driver.findElement(By.name("q")).sendKeys("Abcd");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		driver.findElement(By.linkText("https://en.wikipedia.org/wiki/ABCD")).click();
		
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		   @SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(30, TimeUnit.SECONDS)
		       .pollingEvery(5, TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class);

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.id("foo"));
		     }
		   });
		
		
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		
	}

}
