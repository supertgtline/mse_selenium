package HandlingDropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectOpionInDropDownWithoutIteration {

	@Test
	public void iterateOverOptions() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		// Select Day
		WebElement day = driver.findElement(By.id("day"));
		day.click();
		selectOptionUsingCustomLoc(driver, "3");

		// Select Month
		WebElement month = driver.findElement(By.id("month"));
		month.click();
		selectOptionUsingCustomLoc(driver, "Aug");

		// Select year
		WebElement year = driver.findElement(By.id("year"));
		year.click();
		selectOptionUsingCustomLoc(driver, "1990");

	}

	private void selectOptionUsingCustomLoc(WebDriver driver, String valueToBeSelected) {
		String customLoc = "//option[text()='" + valueToBeSelected + "']";
		driver.findElement(By.xpath(customLoc)).click();
	}

}
