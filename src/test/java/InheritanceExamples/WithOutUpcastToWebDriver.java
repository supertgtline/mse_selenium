package InheritanceExamples;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WithOutUpcastToWebDriver {

	// Since user should be able to launch any browser , we need to create reference object of every browser type
	public static ChromeDriver cDriver;
	public static FirefoxDriver fDriver;
	public static InternetExplorerDriver iDriver;
	public static EdgeDriver eDriver;
	public static SafariDriver sDriver;
	
	// We need to keep adding browser driver reference variable
}
