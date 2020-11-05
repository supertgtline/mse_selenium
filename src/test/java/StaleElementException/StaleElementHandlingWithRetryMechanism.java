package StaleElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementHandlingWithRetryMechanism {

	private void sendKeysWithRetry(By by, WebDriver driver, String val)
	{
		boolean retryNeeded = false;
		do
		{
			try {
			driver.findElement(by).sendKeys(val);
			}catch(StaleElementReferenceException e)
			{
				System.out.println("StaleElementReferenceException - Retrying");
				retryNeeded = true;
			}
			catch(NoSuchElementException e)
			{
				break;
			}
		}while(retryNeeded);
		
	}
	@Test
	public  void main() throws InterruptedException {
		// Setup browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// Open URL
		driver.get("https://github.com/login");
		// locate and type user name
		sendKeysWithRetry(By.id("login_field"),driver,"amod");
		// locate and type password
		sendKeysWithRetry(By.id("password"),driver,"amod");
		// locate and click on submit
		WebElement sub = driver.findElement(By.xpath("//input[@value='Sign in']"));
		sub.click();
		// again type user name
		sendKeysWithRetry(By.id("login_field"),driver,"amod");
		sendKeysWithRetry(By.id("password"),driver,"amod");
	}
}
