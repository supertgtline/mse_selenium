package HandlingSVGElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingSVGGraph {
	
	@Test
	public void getAllCircleText() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/svg/graph.htm");
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/svg/src/graph.html']")));
		List<WebElement> allCircles = driver.findElements(By.xpath("//div[@id='div1']//*[name()='svg']//*[name()='circle']/../*[name()='text']"));
		for(WebElement ele : allCircles)
		{
			System.out.println(ele.getText());
		}
		driver.close();
	}
	
	@Test
	public void getBarChart() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rgraph.net/svg/bar.html#example");
		Thread.sleep(10000);
		List<WebElement> allBar = driver.findElements(By.xpath("(//*[name()='svg'])[1]//*[name()='g' and @class='all-elements']//*[name()='rect']"));
		for(WebElement a : allBar)
		{
			a.click();
			List<WebElement> allText = driver.findElements(By.xpath("//div[@class='RGraph_tooltip']//tr/td[2]"));
			for(WebElement e : allText)
				System.out.println(e.getText());
			driver.findElement(By.xpath("//h2[text()='Example']")).click();
		}
	}
	
	

}
