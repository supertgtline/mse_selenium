package SingletonParallelExecutionProblem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactorySingleton {

	private static DriverFactorySingleton driverFactorySingleton = null;
	private static WebDriver driver;

	private DriverFactorySingleton() {
		System.out.println("Intantiated....");
		setDriver();
	}

	public static DriverFactorySingleton getInstance() {
		if (driverFactorySingleton == null) {
			driverFactorySingleton = new DriverFactorySingleton();
		}
		return driverFactorySingleton;
	}

	private static void setDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void closeDriver() {
		getDriver().close();
		driverFactorySingleton = null;
	}
}
