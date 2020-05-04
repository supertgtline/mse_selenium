package StaleElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenerateExplictlyStaleElementReferenceException {
	
	@Test
	public void doActions() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().minimize();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		// Locating Email Address field
		WebElement emailAddress = driver.findElement(By.id("email_create"));
		
		// Let's perform same actions multiple times.
		emailAddress.sendKeys("Amod@gmail.com");
		emailAddress.clear();
		emailAddress.sendKeys("Amod1@gmail.com");
		emailAddress.clear();
		emailAddress.sendKeys("Amod2@gmail.com");
		emailAddress.clear();
		
		// Let's refresh the web page
		driver.navigate().refresh();
		
		// Let's perform same actions on already located web element. You get a stale element reference.
		emailAddress.sendKeys("Amod4@gmail.com");
		emailAddress.clear();
		
		
	}

}
