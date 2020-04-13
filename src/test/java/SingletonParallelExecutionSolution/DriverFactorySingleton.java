package SingletonParallelExecutionSolution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactorySingleton {
	
	private static ThreadLocal<DriverFactorySingleton> driverFactorySingleton = new ThreadLocal<DriverFactorySingleton>();
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	private DriverFactorySingleton() {
		System.out.println("Intantiated singleton class....");
	}
	
	public static DriverFactorySingleton getInstance()
	{
		if(driverFactorySingleton.get()==null)
		{
			driverFactorySingleton.set(new DriverFactorySingleton());
			setDriver();
		}
		return driverFactorySingleton.get();
	}
	
	private static void setDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		System.out.println("Driver intialzed by "+Thread.currentThread().getId()+" with reference as "+driver.get());
	}
	
	public WebDriver getDriver()
	{
		return driver.get();
	}
	
	public void removeDriver()
	{
		driver.get().close();
		driverFactorySingleton.remove();
		driver.remove();
	}
	
}
