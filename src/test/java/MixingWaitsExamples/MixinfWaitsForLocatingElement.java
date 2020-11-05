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

public class MixinfWaitsForLocatingElement {

	WebDriver driver;

	@Test
	public void mixinfWaitsForLocatingElement() {
		// Setting up browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Setting up implicit wait greater than explicit wait
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		// Load URL
		driver.get("http://www.demoqa.com/");

		// Setting up explicit wait with default polling interval
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.pollingEvery(Duration.ofSeconds(8));
		// Timer starts
		System.out.println("Wait starts at : " + new Date());

		wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				System.out.println("Retrying at : " + new Date());
				
				// Implicit wait will be applicable here
				try {
					System.out.println("1 sec");
					Thread.sleep(1000);
					System.out.println("2 sec");
					Thread.sleep(1000);
					System.out.println("3 sec");
					Thread.sleep(1000);
					System.out.println("4 sec");
					Thread.sleep(1000);
					System.out.println("5 sec");
					Thread.sleep(1000);
					System.out.println("6 sec");
					Thread.sleep(1000);
					System.out.println("7 sec");
					Thread.sleep(1000);
					System.out.println("8 sec");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				return driver.findElement(By.id("sdfds"));
				return null;
			}
		});
	}

	@AfterMethod
	public void printExitTime() {
		System.out.println("Wait ends at : " + new Date());
		driver.quit();
	}
}
