package BasicSeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendEeysExample {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.demoqa.com/text-box");
		//Typing full name
		WebElement fullName = driver.findElement(By.id("userName"));
		fullName.sendKeys("Amod Mahajan");
		fullName.sendKeys("Animesh Prashant");
		System.out.println("Full name : "+fullName.getAttribute("value"));
		// Typing email address
		WebElement userEmail = driver.findElement(By.id("userEmail"));
		userEmail.sendKeys("amod@gmail.com");
		userEmail.sendKeys("animesh@gmail.com");
		System.out.println("Email address :"+ userEmail.getAttribute("value"));
		// Typing current address
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("Bengaluru");
		System.out.println("Current address : "+ currentAddress.getAttribute("value"));
		// Typing permanent address
		WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
		permanentAddress.sendKeys("Bihar");
		System.out.println("Permanent address : "+ permanentAddress.getAttribute("value"));
		driver.close();
	}
}
