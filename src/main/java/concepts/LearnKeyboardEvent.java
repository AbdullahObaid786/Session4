package concepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnKeyboardEvent {
	WebDriver driver;

	By usernameField = By.xpath("//input[@id='username']");
	By passwordField = By.xpath("//input[@id='password']");
	By loginField = By.xpath("//button[@name='login']");

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		// driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() {
		driver.findElement(usernameField).sendKeys("demo@techfios.com");
		driver.findElement(passwordField).sendKeys("abc123");
		
		
		  Actions act = new Actions(driver);
		  act.sendKeys(Keys.ENTER).build().perform();
		 

	}

}
