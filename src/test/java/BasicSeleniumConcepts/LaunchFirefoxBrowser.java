package BasicSeleniumConcepts;

import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefoxBrowser {
	
	public static void main(String[] args) {
		
		// Set the path of geckodriver with extension for windows
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\amomahaj\\Downloads\\geckodriver-v0.26.0-win64 (1)\\geckodriver.exe");
		FirefoxDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.get("https://www.google.com/");
	}

}
