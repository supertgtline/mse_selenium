package EnumUsage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WithoutEnum {

	private WebDriver launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		} else {
			System.out.println("Incorrect browser name passed.");
			return null;
		}
	}
	
	@Test
	public void googleTestChrome()
	{
		WebDriver driver = launchBrowser("Chrome");
		driver.get("https://www.google.com");
		driver.close();
	}
	
	@Test
	public void googleTestFirefox()
	{
		WebDriver driver = launchBrowser("Firefox");
		driver.get("https://www.google.com");
		driver.close();
	}
	

}
