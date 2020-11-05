package MixingWaitsExamples;

import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitWithDivisibleIntervalExample {

	WebDriver driver;
	@Test
	public void mixinfWaitsForLocatingElement()
	{
		// Initializing browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		// Loading URL
		driver.get("http://www.demoqa.com/");
		
		// Setting up explicit wait with custom polling interval
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(2));
		
		// Timer starts
		System.out.println("Wait starts at : "+new Date());
		// Locating wrong element
		wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				System.out.println("Retrying at : "+new Date());
				return driver.findElement(By.id("sdfds"));
			}
		});
	}
	
	@AfterMethod
	public void printExitTime()
	{
		System.out.println("Wait ends at : "+new Date());
		driver.quit();
	}
}
