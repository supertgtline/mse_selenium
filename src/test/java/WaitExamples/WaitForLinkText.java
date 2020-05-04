package WaitExamples;

import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForLinkText {

	public static void main(String[] args) {

		// Browser initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String fileURL = System.getProperty("user.dir");
		driver.get(fileURL + "/src/test/resources/htmlFiles/DynamicInnterText.html");
		WebElement linkText = driver.findElement(By.id("dynamicLink"));

		// Setting FluentWait for list
		FluentWait<WebElement> wait = new FluentWait<WebElement>(linkText)
				// Check for condition in every 2 seconds
				.pollingEvery(Duration.ofSeconds(2)).ignoring(IndexOutOfBoundsException.class)
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30));
		
		wait.until(new Function<WebElement, Boolean>() {
			@Override
			public Boolean apply(WebElement ele) {
				System.out.println("Rechecking at time "+new Date());
				return ele.getText().equals("Here You Go....");
			}
		});
		
		System.out.println("Condition satisfied.");
		driver.quit();
	}

}
