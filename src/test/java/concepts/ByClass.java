package concepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ByClass {

	WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void loginTest() {
		By userNameField = By.xpath("//input[@id='username']");
		driver.findElement(userNameField).sendKeys("demo@techfios.com");
		By passwordField = By.xpath("//input[@id='password']");
		driver.findElement(passwordField).sendKeys("abc12356562");
		By loginButtonField = By.xpath("//button[@name='login']");
		driver.findElement(loginButtonField).click();
		
		boolean dashboardIsDisplayed;
		try{
			By dashboardHeaderField = By.xpath("/ul[@id='side-menu']/descendant::span[5]");
			dashboardIsDisplayed = true;
		}catch(Exception e) {
			dashboardIsDisplayed = false;
			e.printStackTrace();
		}
		
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(dashboardHeaderField));
		
		Assert.assertTrue("Page Not Found", dashboardIsDisplayed);
	}
	
	
}
