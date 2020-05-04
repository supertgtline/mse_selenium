package WaitExamples;

import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverVsFluentWait3 {

	public static void main(String[] args) {

		// Browser initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String fileURL = System.getProperty("user.dir");
		driver.get(fileURL + "/src/test/resources/htmlFiles/DynamicInnterText.html");

		// Setting FluentWait for list
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				// Check for condition in every 2 seconds
				.pollingEvery(Duration.ofSeconds(2))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30))
				.ignoring(NoSuchElementException.class);

		WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				System.out.println("Rechecking at time " + new Date());
				return driver.findElement(By.linkText("Here You Go...."));
			}
		});

		System.out.println("Condition satisfied and text is " + ele.getText());
		driver.quit();
	}
}
