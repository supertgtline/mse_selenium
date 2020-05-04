package StaleElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementHandling {

	@Test
	public  void main() throws InterruptedException {
		// Setup browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// Open URL
		driver.get("https://github.com/login");
		// locate and type user name
		WebElement username = driver.findElement(By.id("login_field"));
		username.sendKeys("amod");
		// locate and type password
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("amod");
		// locate and click on submit
		WebElement sub = driver.findElement(By.xpath("//input[@value='Sign in']"));
		sub.click();
		Thread.sleep(10000);
		// again type user name
		username.sendKeys("amod");
	}
}
