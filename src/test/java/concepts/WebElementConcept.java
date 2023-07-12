package concepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebElementConcept {

	WebDriver driver;
	@Before
	public void init () {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void loginTest() {
		WebElement userNameElement = driver.findElement(By.xpath("//input[@id='username']"));
		userNameElement.sendKeys("demo@techfios.com");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
		passwordElement.sendKeys("abc1235");
		WebElement loginButtonElement = driver.findElement(By.xpath("//button[@name='login']"));
		loginButtonElement.click();
		
		boolean dashboardPageIsDisplayed;
		try {
		WebElement dashboardHeaderElement = driver.findElement(By.xpath("//ul[@id='side-menu']/descendant::span[5]"));
		dashboardPageIsDisplayed = true;
		
		}catch(NoSuchElementException e) {
			dashboardPageIsDisplayed = false;
			e.printStackTrace();
		}
		
		
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.visibilityOf(dashboardHeaderElement));
		
		Assert.assertTrue("DashBoard page not found", dashboardPageIsDisplayed);
		
		
	}
	
	
	
	
}
