package WaitExamples;

import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverVsFluentWait2 {

	public static void main(String[] args) {

		// Browser initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String fileURL = System.getProperty("user.dir");
		driver.get(fileURL + "/src/test/resources/htmlFiles/DynamicInnterText.html");

		// Setting FluentWait for list
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Check for condition in every 2 seconds and overriding default interval 500 MS
		wait.pollingEvery(Duration.ofSeconds(2));
		
		WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				System.out.println("Rechecking at time "+new Date());
				return driver.findElement(By.linkText("Here You Go...."));
			}
		});
		
		System.out.println("Condition satisfied and text is "+ ele.getText());
		driver.quit();
	}
}
