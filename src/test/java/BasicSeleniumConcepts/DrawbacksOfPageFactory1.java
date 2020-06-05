package BasicSeleniumConcepts;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

class GoogleHomePage {

	@FindBy(xpath = "(//input[@name='btnK'])[2]")
	WebElement ele;

	GoogleHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

public class DrawbacksOfPageFactory1 {

	@Test
	public void plainPattern() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("facebook");
		WebElement ele = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
		ele.sendKeys(Keys.ENTER);
		boolean isVisible = ExpectedConditions.invisibilityOf(ele).apply(driver).booleanValue();
		if (isVisible)
			System.out.println("Element is invisible");
	}

	@Test
	public void withPageFactory() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		GoogleHomePage homePage = new GoogleHomePage(driver);
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("facebook");
		homePage.ele.sendKeys(Keys.ENTER);
		boolean isVisible = ExpectedConditions.invisibilityOf(homePage.ele).apply(driver).booleanValue();
		if (isVisible)
			System.out.println("Element is invisible");
	}
	
	@Test
	public void plainPatternWithWebDriverWait() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("facebook");
		WebElement ele = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
		ele.sendKeys(Keys.ENTER);
		System.out.println("Start time : "+new Date());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean isVisible = wait.until(ExpectedConditions.invisibilityOf(ele));
		if (isVisible)
			System.out.println("Element is invisible");
		System.out.println("Start time : "+new Date());
	}

	@Test
	public void withPageFactoryWithWebDriverWait() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		GoogleHomePage homePage = new GoogleHomePage(driver);
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("facebook");
		homePage.ele.sendKeys(Keys.ENTER);
		System.out.println("Start time : "+new Date());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean isVisible = wait.until(ExpectedConditions.invisibilityOf(homePage.ele));
		if (isVisible)
			System.out.println("Element is invisible");
		System.out.println("Start time : "+new Date());
	}
}
