package ScenarioBased;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementExample {

	@Test
	public void findElementExample() {

		// Browser initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoqa.com/text-box");

		// Locating a element with id
		WebElement fullName = driver.findElement(By.id("userName"));
		// Perform typing
		fullName.sendKeys("Amod");

		driver.quit();
	}

	@Test
	public void findNonPresentElementExample() {

		// Browser initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoqa.com/text-box");

		System.out.println("Start Time: " + new Date());
		WebElement fullName = null;
		
		try {
			// Locating a element with id
			fullName = driver.findElement(By.id("userNameWrong"));
			// Perform typing
			fullName.sendKeys("Amod");
		} catch (NoSuchElementException e) {
			System.out.println("End Time: " + new Date());
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Test
	public void findNonPresentElementExampleWihImplicitWait() {

		// Browser initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoqa.com/text-box");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Start Time: " + new Date());
		WebElement fullName = null;
		
		try {
			// Locating a element with id
			fullName = driver.findElement(By.id("userNameWrong"));
			// Perform typing
			fullName.sendKeys("Amod");
		} catch (NoSuchElementException e) {
			System.out.println("End Time: " + new Date());
			e.printStackTrace();
		}
		driver.quit();
	}

}
