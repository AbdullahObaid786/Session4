package concepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearningMouseHover {

	WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		driver.get("https://www.dell.com/en-us");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@Test
	public void MouseHoverTest() {
		By computersField = By.xpath("//span[contains(text(),'Computers & Accessories')]");
		driver.findElement(computersField);
		By monitorsField = By.xpath("//button[text()='Monitors']");
		By viewAllMonitorsField = By.xpath("//a[text()='View All Monitors']");
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(computersField)).build().perform();
		act.moveToElement(driver.findElement(monitorsField)).build().perform();
		driver.findElement(viewAllMonitorsField).click();
		
		
	}
	
	
	
	
	
}
