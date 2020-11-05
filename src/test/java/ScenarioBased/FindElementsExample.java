package ScenarioBased;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsExample {

	@Test
	public void findElementsExample() {

		// Browser initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoqa.com/text-box");

		// Locating a element with id
		List<WebElement> fullName = driver.findElements(By.id("userName"));
		System.out.println("Total elements found : "+ fullName.size());
		// Perform typing
		fullName.get(0).sendKeys("Amod");

		driver.quit();
	}

	@Test
	public void findNonPresentElementExample() {

		// Browser initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoqa.com/text-box");

		System.out.println("Start Time: " + new Date());
		List<WebElement> fullName = driver.findElements(By.id("userNameWrong"));
		System.out.println("Total elements found : "+ fullName.size());
		System.out.println("End Time: " + new Date());
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
		List<WebElement> fullName = driver.findElements(By.id("userNameWrong"));
		System.out.println("Total elements found : "+ fullName.size());
		System.out.println("End Time: " + new Date());
		driver.quit();
	}

}
