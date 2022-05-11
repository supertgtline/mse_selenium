package ParallelRunProblemWithStaticWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactoryStatic {

	private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
	
	public static  void setDriver(WebDriver driver) {
		driverThreadLocal.set(driver);

	}

	public static WebDriver getDriver() {
		return driverThreadLocal.get();
	}
	public void intableBrowser(){
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		this.driverThreadLocal.set(driver);
		System.out.println("driver initiate"+driverThreadLocal);

	}
}
