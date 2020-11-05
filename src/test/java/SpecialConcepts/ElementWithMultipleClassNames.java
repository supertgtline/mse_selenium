package SpecialConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementWithMultipleClassNames {

	@Test
	public void multipleClassnameWithClassNameLocator()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.yatra.com/");
		driver.findElement(By.className("required_field cityPadRight ac_input origin_ac")).sendKeys("DELHI");
	
	}
	
	@Test
	public void multipleClassnameWithXPathLocator()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.yatra.com/");
		driver.findElement(By.xpath("//input[@class='required_field cityPadRight ac_input origin_ac']")).sendKeys("DELHI");
	
	}
	
	@Test
	public void multipleClassnameWithCssSelectorLocator()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.yatra.com/");
		driver.findElement(By.cssSelector("input[class='required_field cityPadRight ac_input origin_ac']")).sendKeys("DELHI");
	
	}
	
	@Test
	public void multipleClassnameWithCssSelectorLocatorCombiningClassWithNode()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.yatra.com/");
		// Combine all class names with dot and append tag name i.e. tagName.classname1.classname2.classname3
		driver.findElement(By.cssSelector("input.required_field.cityPadRight.ac_input.origin_ac']")).sendKeys("DELHI");
	
	}
	
	@Test
	public void multipleClassnameWithCssSelectorLocatorCombiningClassWithoutNode()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.yatra.com/");
		// Combine all class names with dot and append a dot at starting i.e. .classname1.classname2.classname3
		driver.findElement(By.cssSelector(".required_field.cityPadRight.ac_input.origin_ac']")).sendKeys("DELHI");
	
	}
}
