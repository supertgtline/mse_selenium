package BasicSeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IllegalArgumentExceptionExample {

	@Test
	public void googleSearch1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		// Typing null search keyword
		String inputString = null;
		driver.findElement(By.name("q")).sendKeys(inputString);
	}
	
	@Test
	public void googleSearch2() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		// no passing any value in sendKeys
		driver.findElement(By.name("q")).sendKeys();
	}
	
	@Test
	public void googleSearch3() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		// no passing any value in sendKeys
		driver.findElement(By.name("q")).sendKeys("");
	}
}
