package WaitExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsageOfSleep {

	public static void main(String[] args) throws InterruptedException {

		// Setting up browser executable using WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Opening a browser and maximizing
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Loading a URL
		driver.get("https://www.redbus.in/");
		// Locating and typing in From text box.
		WebElement fromTextBox = driver.findElement(By.id("src"));
		fromTextBox.sendKeys("Ban");
		// Put a sleep wait
		Thread.sleep(5000);
		// Clicking on first search result
		driver.findElement(By.xpath("//li[@select-id='results[0]']")).click();
		// Let's print the select value
		String selectedCity = driver.findElement(By.id("src")).getAttribute("value");
		System.out.println("Selected city in From is :"+selectedCity);
		// Closing browser
		driver.quit();
	}

}
