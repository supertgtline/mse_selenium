package BasicSeleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoadURLUsingNavigate {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.out.println("Loading URL one by one ........");
		driver.navigate().to("http://facebook.com");
		System.out.println("Current title is : " + driver.getTitle());
		driver.navigate().to("http://google.com");
		System.out.println("Current title is : " + driver.getTitle());
		driver.navigate().to("http://flipkart.com");
		System.out.println("Current title is : " + driver.getTitle());
		System.out.println("Going back....");
		driver.navigate().back();
		System.out.println("Current title is : " + driver.getTitle());
		driver.navigate().back();
		System.out.println("Current title is : " + driver.getTitle());
		System.out.println("Going forward......");
		driver.navigate().forward();
		System.out.println("Current title is : " + driver.getTitle());
		driver.navigate().forward();
		System.out.println("Current title is : " + driver.getTitle());
		

	}
}
