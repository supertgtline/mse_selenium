package BasicSeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getTextExamples {

	@Test
	public void exampleInnerText1()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		String fileURL = System.getProperty("user.dir");
		driver.get(fileURL + "/src/test/resources/htmlFiles/innerText.html");
		
		System.out.println("Output of Node Button 1 = " + driver.findElement(By.id("btn1")).getText());
		System.out.println("Output of Node Button 2 = " + driver.findElement(By.id("btn2")).getText());
		System.out.println("Output of Node P = " + driver.findElement(By.id("p1")).getText());
		
		driver.quit();
		System.out.println("********************************************************************");
	}
	
	@Test
	public void exampleInnerText2()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		String fileURL = System.getProperty("user.dir");
		driver.get(fileURL + "/src/test/resources/htmlFiles/innerTextEx2.html");
		
		// Nothing will be returned by style tag as it ignored by getText
		System.out.println("Output of Node Style = " + driver.findElement(By.tagName("style")).getText());
		// Nothing will be returned by script tag as it ignored by getText
		System.out.println("Output of Node Script = " + driver.findElement(By.tagName("script")).getText());
		// Nothing will be returned by span tag as it is hidden
		System.out.println("Output of Span = " + driver.findElement(By.tagName("span")).getText());
		// Combine all rendered text of children nodes
		System.out.println("Output of P = " + driver.findElement(By.id("p1")).getText());
		
		driver.quit();
	}
	
	@Test
	public void exampleInnerText3()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		String fileURL = System.getProperty("user.dir");
		driver.get(fileURL + "/src/test/resources/htmlFiles/EmptyAndWhiteSpace.html");
		
		String textReceived = driver.findElement(By.id("p1")).getText();
		System.out.println("Output of Node P 1 = " + textReceived );
		System.out.println("Length of text received for P 1 = "+ textReceived.length());
		
		System.out.println("Output of Node P 2 = " + driver.findElement(By.id("p2")).getText());
		System.out.println("Output of Node P 3 = " + driver.findElement(By.id("p3")).getText());
		System.out.println("Output of Node P 4 = " + driver.findElement(By.id("p4")).getText());
		driver.quit();
	}
}
