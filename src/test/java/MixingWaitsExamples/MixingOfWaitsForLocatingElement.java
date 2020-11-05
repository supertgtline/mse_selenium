package MixingWaitsExamples;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MixingOfWaitsForLocatingElement {

	WebDriver driver;
	
	@Test
	public void mixinfWaitsForLocatingElement()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		// Setting up implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Load URL
		driver.get("http://www.demoqa.com/");
		
		// Setting up explicit wait with polling interval as 12 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofSeconds(6));
		
		// Timer starts
		System.out.println("Wait starts at : "+new Date());
		
		wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				System.out.println("Retrying at : "+new Date());
				// Implicit wait will be applicable here
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
