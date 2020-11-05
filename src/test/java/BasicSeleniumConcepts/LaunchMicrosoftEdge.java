package BasicSeleniumConcepts;

import org.openqa.selenium.edge.EdgeDriver;

public class LaunchMicrosoftEdge {
	
	public static void main(String[] args) {
		
		// Set the path of edgeDriver with extension for windows
		System.setProperty("webdriver.edge.driver", "C:\\Users\\amomahaj\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
		EdgeDriver edgeDriver = new EdgeDriver();
		edgeDriver.get("https://www.google.com/");
	}

}
