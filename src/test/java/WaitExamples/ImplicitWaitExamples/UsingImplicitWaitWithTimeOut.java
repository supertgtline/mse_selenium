package WaitExamples.ImplicitWaitExamples;

import java.util.Date;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingImplicitWaitWithTimeOut {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		// Opening a browser
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		// setting implicit time step by step
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Loading a URL
		driver.get("https://www.redbus.in/");
	
		// Locating and typing in From text box. 
		WebElement fromTextBox= driver.findElement(By.id("src"));
		fromTextBox.sendKeys("Ban");
		
		System.out.println("Wait starts at :"+new Date());
		// Passing wrong locators and catching exception to show waiting time
		try {
		driver.findElement(By.xpath("//li[@select-id='results[30]']")).click();
		}catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		System.out.println("Wait ends at:"+new Date());
		//Closing browser
		driver.quit();
		
	}

}
