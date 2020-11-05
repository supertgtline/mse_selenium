package MixingWaitsExamples;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitExample {

	WebDriver driver;
	@Test
	public void mixinfWaitsForLocatingElement()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// Setting up implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.demoqa.com/");
		// Timer starts
		System.out.println("Wait starts at : "+new Date());
		// Locating wrong element
		driver.findElement(By.id("SomeWrongId"));
	}
	
	@AfterMethod
	public void printExitTime()
	{
		System.out.println("Wait ends at : "+new Date());
		driver.quit();
	}
}
