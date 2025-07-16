package allureReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tests {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
	}

	@Test(priority=1)
	public void logopresence() {
		boolean disstatus=driver.findElement(By.xpath("//div[@class=\"header-logo\"]//a//img")).isDisplayed();
		Assert.assertEquals(disstatus, true);
	}
	@Test(priority=2)
	public void login() {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("mrv@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Test@123");
		driver.findElement(By.linkText("Log in")).click();
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store123");
		
	}
	@Test (priority=3)
	public void registration() {
		throw new SkipException("shipping the test");
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
}
