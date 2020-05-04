package SeleniumFourFeatures;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MinimizeExample {
	
	@Test
	public void doActions() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		// Minimize browser
		driver.manage().window().minimize();
		
		// Locating Email Address field
		WebElement emailAddress = driver.findElement(By.id("email_create"));
		
		// Let's perform same actions multiple times.
		emailAddress.sendKeys("Amod@gmail.com");
		emailAddress.clear();
		emailAddress.sendKeys("Amod1@gmail.com");
		emailAddress.clear();
		emailAddress.sendKeys("Amod2@gmail.com");
		emailAddress.clear();
		
		// Let's refresh the web page
		driver.navigate().refresh();
		
		// Relocating web element
		emailAddress = driver.findElement(By.id("email_create"));
		
		emailAddress.sendKeys("Amod4@gmail.com");
		// Taking screenshot 
		TakesScreenshot ts = (TakesScreenshot)driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		File ds = new File(System.getProperty("user.dir")+"/src/test/resources/screenshot.png");
		Files.copy(ss, ds);
		
		emailAddress.clear();
		
		driver.close();
		driver.quit();
		
		
	}

}
