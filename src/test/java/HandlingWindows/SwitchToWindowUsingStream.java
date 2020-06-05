package HandlingWindows;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToWindowUsingStream {

	public static void main(String[] args) {
		
		// Browser initialization
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				String fileURL = System.getProperty("user.dir");
				//driver.get(fileURL + "/src/test/resources/htmlFiles/DynamicInnterText.html");
				driver.get("file:///C:/Users/amomahaj/Desktop/MultipleWindows.html");
				
				driver.findElement(By.id("google")).click();
				//System.out.println(driver.getWindowHandles());
				driver.findElement(By.id("facebook")).click();
				//System.out.println(driver.getWindowHandles());
				driver.findElement(By.id("flipkart")).click();
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfWindowsToBe(4));
				Set<String> allHandles = driver.getWindowHandles();
				System.out.println(allHandles);
				for(String s : allHandles)
				{
					driver.switchTo().window(s);
					System.out.println("Title is : "+ driver.getTitle());
				}
//				// Switch to Google
//				System.out.println(allHandles.stream().skip(1).findFirst().get());
//				driver.switchTo().window(allHandles.stream().skip(1).findFirst().get());
//				System.out.println("Title is : "+ driver.getTitle());
//				// Switch to Google
//				System.out.println(allHandles.stream().skip(2).findFirst().get());
//				driver.switchTo().window(allHandles.stream().skip(2).findFirst().get());
//				System.out.println("Title is : "+ driver.getTitle());
//				// Switch to Google
//				System.out.println(allHandles.stream().skip(3).findFirst().get());
//				driver.switchTo().window(allHandles.stream().skip(3).findFirst().get());
//				System.out.println("Title is : "+ driver.getTitle());
				
				
//				driver.findElement(By.id("multi")).click();
//				System.out.println(driver.getWindowHandles());
//				driver.switchTo().window(driver.getWindowHandles().stream().skip(1).findFirst().get());
//				System.out.println("Title is : "+ driver.getTitle()+driver.getWindowHandle());
//				driver.switchTo().window(driver.getWindowHandles().stream().skip(2).findFirst().get());
//				System.out.println("Title is : "+ driver.getTitle()+driver.getWindowHandle());
		
}
}
