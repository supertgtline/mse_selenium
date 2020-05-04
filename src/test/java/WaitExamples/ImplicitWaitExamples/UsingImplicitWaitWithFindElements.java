package WaitExamples.ImplicitWaitExamples;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingImplicitWaitWithFindElements {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		// Opening a browser
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		// setting implicit time step by step
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Loading a URL
		String fileURL = System.getProperty("user.dir");
		driver.get(fileURL + "/src/test/resources/htmlFiles/ElementsWithDelay.html");
		
		// Locating and typing in From text box. 
		System.out.println("Wait starts at :"+new Date());
		List<WebElement> allButtons = driver.findElements(By.xpath("//button[@style != 'display: none;']"));
		System.out.println("Wait ends at:"+new Date());
		System.out.println("Size of found buttons : "+allButtons.size());
		//Closing browser
		driver.quit();
		
	}

}
