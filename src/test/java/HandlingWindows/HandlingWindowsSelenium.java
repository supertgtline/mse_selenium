package HandlingWindows;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindowsSelenium {

	@Test
	public void handlingWindowsSelenium() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Let's print window handle of current window
		String parentWinHandle = driver.getWindowHandle();
		System.out.println("Window handle of parent window : " + parentWinHandle);
		driver.get("http://www.demoqa.com/");
		driver.findElement(By.xpath("(//div[string()='Alerts, Frame & Windows'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();

		driver.findElement(By.id("tabButton")).click();
		driver.findElement(By.id("windowButton")).click();

		// Asserting total number of windows
		Assert.assertTrue(ExpectedConditions.numberOfWindowsToBe(3).apply(driver).booleanValue(),
				"Windows count is not 3.");
		// Get all window handles
		Set<String> allWinHandles = driver.getWindowHandles();

		// Switching to windows one by one
		allWinHandles.stream().forEach(handle -> {
			// If it is already on parent window no need to switch
			if (!handle.equals(parentWinHandle))
				driver.switchTo().window(handle);
			System.out.println("Title of window : " + driver.getTitle());
			System.out.println("Current URL of window : " + driver.getCurrentUrl());

		});

		// Closing all windows except parent
		allWinHandles.stream().forEach(handle -> {
			// If not parent switch and close
			if (!handle.equals(parentWinHandle))
				driver.switchTo().window(handle).close();
		});
		
		// CLosing parent window
		driver.switchTo().window(parentWinHandle).close();
		driver.getTitle();

	}

}
