package BasicSeleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoadURLUsingGet {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.out.println("Loading URL one by one ........");
		driver.get("http://facebook.com");
		System.out.println("Current title is : " + driver.getTitle());
		driver.get("http://google.com");
		System.out.println("Current title is : " + driver.getTitle());
		driver.get("http://flipkart.com");
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
