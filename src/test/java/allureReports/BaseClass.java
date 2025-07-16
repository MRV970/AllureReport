package allureReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners({Allure_Listeners.class})
public class BaseClass {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver= new ThreadLocal<WebDriver>();
	
	public WebDriver initialize_driver() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		tdriver.set(driver);
		return getDriver();
	}
	public static  WebDriver getDriver() {
		return tdriver.get();
	}
	
	}
