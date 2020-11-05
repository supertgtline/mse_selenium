package HeadlessBrowsers;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

public class HeadlessChrome {
	
	public static void main(String[] args) throws IOException {
		
		// Set chrome executable path
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		
		// Set headless chrome
		ChromeOptions option=new ChromeOptions();
		//option.setHeadless(true);
		// OR - No need to add '--'
		option.addArguments("headless");
		// You should set window size for better resolution and screen capture
		option.addArguments("window-size=1200x600");
		
		ChromeDriver browser = new ChromeDriver(option);
		browser.get("https://chromedriver.chromium.org/downloads");
		
		// Capturing screenshot
		File file = browser.getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File(System.getProperty("user.home")+"\\Downloads\\chromedriver_win32 (4)\\ss.png"));
		
		browser.close();
		
		
	}

}
