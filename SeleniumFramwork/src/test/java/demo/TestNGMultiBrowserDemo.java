package demo;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class TestNGMultiBrowserDemo {
	
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");

	@Parameters("BrowserName")
	@BeforeTest
	public void setup(String BrowserName) {
		System.out.println("Browser name is : " + BrowserName);
		System.out.println("Thread ID is: " + Thread.currentThread().getId());
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver");
		    driver = new ChromeDriver();	
		} 
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver");
			driver = new FirefoxDriver();
		}
		
	}
	
	@Test
	public void test1() throws InterruptedException {
		driver.get("https://google.com");
		Thread.sleep(4000);
		}
	
	@AfterTest
	public void teardown() {
		driver.close();
		System.out.println("Test completed successfully!");
	}
}
