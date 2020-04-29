import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesiredCapabilities_Demo {
	
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
	    		
		System.setProperty("webdriver.ie.driver", projectPath + "/drivers/chromedriver/chromedriver");
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("https://google.com");
	    
	    driver.findElement(By.className("q")).sendKeys("ABCD");
	    
	    driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
		
		driver.close();
		driver.quit();
	}

}
