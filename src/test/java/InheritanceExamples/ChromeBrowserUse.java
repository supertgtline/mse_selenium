package InheritanceExamples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowserUse extends WithOutUpcastToWebDriver
{

	public static void main(String[] args) throws IOException {
		
		// Since you need to launch chrome browser , you need to use ChromeBrowser reference variable as below
		WebDriverManager.chromedriver().setup();
		cDriver= new ChromeDriver();
		cDriver.get("http://makeseleniumeasy.com/");
		
		// Taking screenshot
		// To take screenshot no need to downcast to TakesScreenshot interface
		File screenshotSRC= cDriver.getScreenshotAs(OutputType.FILE);
		// Defining path and extension of image
		String path=System.getProperty("user.dir")+"/ScreenCapturesPNG/"+System.currentTimeMillis()+".png";
		// copying file from temp folder to desired location
		File screenshotDest= new File(path);
		FileUtils.copyFile(screenshotSRC, screenshotDest);
		
		// Running javascript command
		// No need to downcast to JavascriptExecutor 
		cDriver.executeScript("window.scrollBy(0,250)");
					
		// Closing browser			
		cDriver.quit();
		
	}
}

