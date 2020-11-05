package SpecialConcepts;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadMultipleFiles {
	
	// This method helps you to fetch path of any file from resource folder
	private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
	
	
	@Test
	public void MultipleFileuploadInChromeUsingNewLineChar() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_multiple");
		String filesPathSeperaedWithNewLineChar = getFileFromResources("images/amazon-fire-tv-stick-4k-4-3h9r-3h9r.jpg").getAbsolutePath()+"\n"+getFileFromResources("images/maxresdefault.jpg").getAbsolutePath();
		driver.switchTo().frame("iframeResult").findElement(By.id("files")).sendKeys(filesPathSeperaedWithNewLineChar);
		driver.close();
	}
	
	@Test
	public void MultipleFileuploadInFirefoxNewLineChar() {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_multiple");
		String filesPathSeperaedWithNewLineChar = getFileFromResources("images/amazon-fire-tv-stick-4k-4-3h9r-3h9r.jpg").getAbsolutePath()+"\n"+getFileFromResources("images/maxresdefault.jpg").getAbsolutePath();
		driver.switchTo().frame("iframeResult").findElement(By.id("files")).sendKeys(filesPathSeperaedWithNewLineChar);
		driver.close();
	}
	
	@Test
	public void MultipleFileuploadInChromeUsingMultipleSendKeysMethod() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_multiple");
		String file1 = getFileFromResources("images/amazon-fire-tv-stick-4k-4-3h9r-3h9r.jpg").getAbsolutePath();
		String file2 = getFileFromResources("images/maxresdefault.jpg").getAbsolutePath();
		driver.switchTo().frame("iframeResult").findElement(By.id("files")).sendKeys(file1);
		driver.findElement(By.id("files")).sendKeys(file2);
		driver.close();
	}
	
	@Test
	public void MultipleFileuploadInFirefoxUsingMultipleSendKeysMethod() throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_multiple");
		String file1 = getFileFromResources("images/amazon-fire-tv-stick-4k-4-3h9r-3h9r.jpg").getAbsolutePath();
		String file2 = getFileFromResources("images/maxresdefault.jpg").getAbsolutePath();
		driver.switchTo().frame("iframeResult").findElement(By.id("files")).sendKeys(file1);
		driver.findElement(By.id("files")).sendKeys(file2);
		driver.close();
	}

}
