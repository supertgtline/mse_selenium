package MixingWaitsExamples;

import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GameOfPollingIntervalWithLongerDelay {

	WebDriver driver;

	@Test
	public void pollingIntervalExample() {
		
		// Launching browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		// Loading URL
		driver.get("http://www.demoqa.com/");
		
		// Setting up explicit wait polling interval as 15 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofSeconds(15));
		// Timer starts
		System.out.println("Wait starts at : " + new Date());
		
		// Explicitly failing condition with 5 seconds delay
		wait.until(new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				System.out.println("Retrying at : " + new Date());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
		});
	}

	@AfterMethod
	public void printExitTime() {
		System.out.println("Wait ends at : " + new Date());
		driver.quit();
	}
}
