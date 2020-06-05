package BasicSeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementNotInteractableExceptionExample {

	@Test
	public void googleSearch() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		// Typing search keyword
		driver.findElement(By.name("q")).sendKeys("facebook");
		// Locating first suggestion button and click on it. Why first suggestion bcz whatever we type hat will come always at first
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@role='option']//span)[1]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@role='option']//span)[1]")));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ele.click();
		Assert.assertTrue(ExpectedConditions.titleContains("facebook").apply(driver).booleanValue());
	}
}
