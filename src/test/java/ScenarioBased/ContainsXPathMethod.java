package ScenarioBased;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContainsXPathMethod {
	
	public static void main(String[] args) {
		
		// Browser initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String fileURL = System.getProperty("user.dir");
		driver.get(fileURL + "/src/test/resources/htmlFiles/WithDoubleSIngleText.html");
		
		
		String text1= driver.findElement(By.xpath("//p[text()=concat('Hello \"Amod\". How is Rahul',\"'s pet?\")]")).getText();
		System.out.println(text1);
		
//		String text2= driver.findElement(By.xpath("//p[text()=\"Hello \"Amod\". How is Rahul's pet?\"]")).getText();
//		System.out.println(text2);
		
		
	}

}
