package HandlingWindows;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingOfWindowHandles {

	public static void main(String[] args) {

		// Browser initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String fileURL = System.getProperty("user.home");
		driver.get(fileURL+ "/Desktop/MultipleWindows.html");
		// Clicking on Google
		driver.findElement(By.id("google")).click();
		// Clicking on Facebook
		driver.findElement(By.id("facebook")).click();
		// Clicking on Flipkart
		driver.findElement(By.id("flipkart")).click();
		// Wait till we have total 4 windows
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfWindowsToBe(4));
		// Get all window handles
		Set<String> allHandles = driver.getWindowHandles();
		for (String s : allHandles) {
			driver.switchTo().window(s);
			System.out.println("Title is : " + driver.getTitle());
		}
	}
}
