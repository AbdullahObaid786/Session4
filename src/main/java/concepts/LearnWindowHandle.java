package concepts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {

	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void scrollTest() throws InterruptedException {
		
		  String title1 = driver.getTitle(); 
		  System.out.println(title1); 
		  String wh1 = driver.getWindowHandle(); 
		  System.out.println(wh1);
		 

		driver.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("selenium");
		driver.findElement(By.xpath("//button[@id='ybar-search']")).click();
		/*
		 * Thread.sleep(2000); 
		 * String title2 = driver.getTitle();
		 * System.out.println(title2); 
		 * String wh2 = driver.getWindowHandle();
		 * System.out.println(wh2);
		 */

		driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();

		Set<String> handles = driver.getWindowHandles();
		//System.out.println(handles);

		for (String i : handles) {
			driver.switchTo().window(i);
		}

		String title3 = driver.getTitle();
		System.out.println(title3);
		
		// how to go back to previous window
		driver.switchTo().window(wh1);
		String title4 = driver.getTitle();
		System.out.println(title4);

	}

}
