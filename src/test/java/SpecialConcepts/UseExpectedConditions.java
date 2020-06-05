package SpecialConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UseExpectedConditions {


	@Test
	public void checkPresenceOfElement() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		ExpectedConditions.presenceOfElementLocated(By.name("q")).apply(driver);
		driver.quit();
	}
	
	@Test
	public void checkPresenceOfTextBoxThenType() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		ExpectedConditions.presenceOfElementLocated(By.name("q")).apply(driver).sendKeys("Make Selenium Easy");
		driver.quit();
	}

	@Test
	public void assertTitle() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		ExpectedConditions.titleIs("Google").apply(driver);
		driver.quit();
	}
	

	@Test
	public void verifyPresenceOfAlertThenAccept() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		// Switch and accept
		ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")).apply(driver).findElement(By.xpath("//button[text()='Try it']")).click();
		ExpectedConditions.alertIsPresent().apply(driver).accept();
		driver.switchTo().defaultContent();
		// Switch , get alert text then accept
		ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")).apply(driver).findElement(By.xpath("//button[text()='Try it']")).click();
		String alertText = ExpectedConditions.alertIsPresent().apply(driver).getText();
		System.out.println("Alert text is : "+alertText);
		ExpectedConditions.alertIsPresent().apply(driver).accept();
		driver.quit();
	}
}
