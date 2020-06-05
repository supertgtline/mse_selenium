package WaitExamples;

import java.time.Clock;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitInstances {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// Creating WebDriverWait instance with timeout and default polling interval 
		WebDriverWait webDriverWaitWithDefaulPolling = new WebDriverWait(driver, Duration.ofSeconds(30));
		// To add polling interval
		webDriverWaitWithDefaulPolling.pollingEvery(Duration.ofSeconds(2));
		// To override timeout duration
		webDriverWaitWithDefaulPolling.withTimeout(Duration.ofSeconds(50));
		// To set a message on failure of condition 
		webDriverWaitWithDefaulPolling.withMessage("Condition Failed");
		// Ignoring more exceptions
		webDriverWaitWithDefaulPolling.ignoring(ArithmeticException.class);
		// Creating WebDriverWait instance with timeout and custom polling interval
		WebDriverWait webDriverWaitWithPollingInterval = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
		
		webDriverWaitWithDefaulPolling.until(ExpectedConditions.alertIsPresent());
		
		// Wait till text is equal to Some value or timeout
		webDriverWaitWithDefaulPolling.until(new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return driver.findElement(By.linkText("some XPATH")).getText().equals("Some value");
			}
			});
		
		
	}

}
