package ScenarioBased;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyCopyPasteDisabledTextBox {

	@Test
	public void verifyCopyPasteDisabledTextBox() {
		
		// Browser initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String fileURL = System.getProperty("user.dir");
		driver.get(fileURL + "/src/test/resources/htmlFiles/PasteDisabled.html");
		
		// Verify input box is copy disabled
		WebElement txtBoxAccountNumber = driver.findElement(By.name("ReceiveNo"));
		String onCopyVal = txtBoxAccountNumber.getAttribute("oncopy");
		System.out.println("On copy value = "+onCopyVal);
		Assert.assertTrue(onCopyVal.contains("false"));
		// Verify input box is paste disabled
		String onPasteVal = txtBoxAccountNumber.getAttribute("onpaste");
		System.out.println("On paste value = "+onPasteVal);
		Assert.assertTrue(onPasteVal.contains("false"));
		driver.quit();
	}

}
