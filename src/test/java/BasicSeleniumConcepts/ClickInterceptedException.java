package BasicSeleniumConcepts;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickInterceptedException {

	@Test
	public void googleSearch() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		// Typing search keyword
		driver.findElement(By.name("q")).sendKeys("facebook");
		// Locating first suggestion button and click on it. Why first suggestion bcz whatever we type hat will come always at first
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//ul[@role='listbox']/li)[1]")));
		ele.click();
		Assert.assertTrue(ExpectedConditions.titleContains("facebook").apply(driver).booleanValue());
		
	}
}
