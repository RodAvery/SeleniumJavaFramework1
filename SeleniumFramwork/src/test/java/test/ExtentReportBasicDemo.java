package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportBasicDemo {
		private static WebDriver driver = null;

	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");

		
		// Create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		// creates a toggle for the given tests, adds all log events under it
		ExtentTest test1 = extent.createTest("Google Search Test One","This is a test to Validate google search funtionality");
	
		String projectPath = System.getProperty("user.dir");		
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// info details
		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://google.com");
		test1.pass("Navigated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Entered Text in Searchbox");
		
		driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
		test1.pass("Pressed Keyboard enter Key"); 
		
		driver.close();
		driver.quit();
		test1.fail("Closed the browser");
		
		test1.info("Test Completed");
		
		// Calling flush writes everything to the log
		extent.flush();
	
	}

}
