package BasicSeleniumConcepts;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amomahaj\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.google.com/");
	}

}
