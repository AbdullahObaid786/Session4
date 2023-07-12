package concepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearningDropDown {
	WebDriver driver;

	By usernameField = By.xpath("//input[@id='username']");
	By passwordField = By.xpath("//input[@id='password']");
	By loginField = By.xpath("//button[@name='login']");
	By dashboardField = By.xpath("//span[text()='Dashboard']");
	By customerField = By.xpath("//span[text()='Customers']");
	By addCustomerField = By.xpath("//ul[@id='side-menu']/li[3]/ul/li[1]/a");
	By addCustomerHeader = By.xpath("//div[@class='ibox float-e-margins']/div[1]/h5");
	By addFullName = By.xpath("//input[@id='account']");
	By companyDropDownField = By.xpath("//select[@id='cid']");
	By addEmailField = By.xpath("//input[@id='email']");
	By addPhoneField = By.xpath("//input[@id='phone']");
	By addAddressField = By.xpath("//input[@id='address']");
	By addCityField = By.xpath("//input[@id='city']");
	By addStateField = By.xpath("//input[@id='state']");
	By addZipField = By.xpath("//input[@id='zip']");
	By countryDropDownField = By.xpath("//select[@id='country']");
	By tagDropDownField = By.xpath("//select[@id='tags']");
	By currencyDropDown = By.xpath("//select[@id='currency']");
	By groupDropDown = By.xpath("//select[@id='group']");
	By passField = By.xpath("//input[@id='password']");
	By confirmPassField = By.xpath("//input[@id='cpassword']");

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() throws InterruptedException {

		driver.findElement(usernameField).sendKeys("demo@techfios.com");
		driver.findElement(passwordField).sendKeys("abc123");
		driver.findElement(loginField).click();

		String dashboardHeaderText = driver.findElement(dashboardField).getText();
		System.out.println("=================" + dashboardHeaderText);
		Assert.assertEquals("Dashboard page not found!!", "Dashboard", dashboardHeaderText);

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(customerField));

		driver.findElement(customerField).click();
		driver.findElement(addCustomerField).click();
		/*
		 * Assert.assertEquals("Add Customer page not found", "Add Contact",
		 * driver.findElement(addCustomerHeader).getText());
		 */
		driver.findElement(addFullName).sendKeys("Abdullah Obaid");

		Select selCompany = new Select(driver.findElement(companyDropDownField));
		selCompany.selectByVisibleText("Bank Of America");
		
		driver.findElement(addEmailField).sendKeys("abc@gmail.com");
		driver.findElement(addPhoneField).sendKeys("123456");
		driver.findElement(addAddressField).sendKeys("456 Murray Farm");
		driver.findElement(addCityField).sendKeys("Hayward");
		driver.findElement(addStateField).sendKeys("GA");
		driver.findElement(addZipField).sendKeys("78963");
		
		Select selCountry = new Select(driver.findElement(countryDropDownField));
		selCountry.selectByVisibleText("United States");
		
		Select selTag = new Select(driver.findElement(tagDropDownField));
		selTag.selectByVisibleText("Enrico");
		
		Select selCurrency = new Select(driver.findElement(currencyDropDown));
		selCurrency.selectByVisibleText("USD");
		
		Select selGroup = new Select(driver.findElement(groupDropDown));
		selGroup.selectByVisibleText("Java");
		
		driver.findElement(passField).sendKeys("dallas123");
		driver.findElement(confirmPassField).sendKeys("dallas123");
		
		

	}

	// @After
	public void tearDown() {
		driver.close();
	}

}
