package StaleElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementHandling2 {
	public static void main(String[] args) throws InterruptedException {
		// Setup browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/login");
		// Creating object of page class which will initialize web elements
		GitHubLoginPage lp = new GitHubLoginPage(driver);

		lp.username.sendKeys("amod");
		lp.password.sendKeys("dsds");
		lp.submit.click();
		Thread.sleep(5000);
		// Same element
		lp.username.sendKeys("amod");
		lp.password.sendKeys("dsds");
		lp.submit.click();
	}
}
