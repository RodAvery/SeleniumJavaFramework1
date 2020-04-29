package listeners;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class TestNGListenerDemo {

	@Test
	public void test1() {
		
		System.out.println("I am inside of Test 1");
	}
	
	@Test
	public void test2() {
		
		System.out.println("I am inside of Test 2");
		
		String projectPath = System.getProperty("user.dir");
	  
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver");
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("https://google.com/");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("ABC");;
		driver.findElement(By.xpath("//input[@name='abc']")).sendKeys("sssss");
		
		driver.close();
	
	}

	@Test
	public void test3() {
	
	System.out.println("I am inside of Test 3");
		throw new SkipException("This Test Skipped");
	}
	
}


