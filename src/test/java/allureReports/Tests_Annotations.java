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
import io.qameta.allure.Description;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class Tests_Annotations extends BaseClass {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		BaseClass bs=new BaseClass();
		bs.initialize_driver();
		driver.get("https://demo.nopcommerce.com/");
		
	}

	@Test(priority=1,description="verify logo presence on Home page")
	@Description("verify logo presence-----")
	@Epic("EP0001")
	@Feature("Feature:logo")
	@Story("Story:Logopresence")
	@Step("Step01")
	@Severity(SeverityLevel.MINOR)
	
	public void logopresence() {
		boolean disstatus=driver.findElement(By.xpath("//div[@class=\"header-logo\"]//a//img")).isDisplayed();
		Assert.assertEquals(disstatus, true);
	}
	@Test(priority=2)
	@Description("verify login-----")
	@Epic("EP0003")
	@Feature("Feature:login")
	@Story("Story:Login to Application")
	@Step("Step03")
	@Severity(SeverityLevel.MINOR)
	public void login() {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("mrv@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Test@123");
		driver.findElement(By.linkText("Log in")).click();
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store123");
		
	}
	@Test (priority=3)
	@Description("verify registration -----")
	@Epic("EP0002")
	@Feature("Feature:registration")
	@Story("Story:registration")
	@Step("Step02")
	@Severity(SeverityLevel.NORMAL)
	public void registration() {
		throw new SkipException("shipping the test");
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
}
