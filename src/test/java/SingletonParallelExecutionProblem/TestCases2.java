package SingletonParallelExecutionProblem;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCases2 {

	/*
	 * We can store DriverFactorySingleton.getInstance() in a WebDriver reference
	 * and can use it instead of using repeated line of code. Just to exhibit
	 * singleton pattern, I am calling getInstance multiple times.
	 */

	@BeforeClass
	public void setUp() {
		// To initialize driver
		DriverFactorySingleton.getInstance();
		System.out.println("Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : "
				+ DriverFactorySingleton.getInstance().getDriver());
	}

	@Test
	public void MyntraTest(Method m) throws InterruptedException {
		System.out.println(m.getName() + " of class TestCases2 Executed by Thread " + Thread.currentThread().getId()
				+ " on DriverFactorySingleton.getInstance().getDriver() reference "
				+ DriverFactorySingleton.getInstance().getDriver());
		DriverFactorySingleton.getInstance().getDriver().get("https://www.myntra.com/");
		Thread.sleep(15000);
		System.out.println("Title printed by Thread " + Thread.currentThread().getId() + " - "
				+ DriverFactorySingleton.getInstance().getDriver().getTitle()
				+ " on DriverFactorySingleton.getInstance().getDriver() reference "
				+ DriverFactorySingleton.getInstance().getDriver());
		DriverFactorySingleton.getInstance().getDriver().manage().deleteAllCookies();
	}

	@Test
	public void FlipkartTest(Method m) throws InterruptedException {
		System.out.println(m.getName() + " of class TestCases2 Executed by Thread " + Thread.currentThread().getId()
				+ " on DriverFactorySingleton.getInstance().getDriver() reference "
				+ DriverFactorySingleton.getInstance().getDriver());
		DriverFactorySingleton.getInstance().getDriver().get("https://www.flipkart.com/");
		Thread.sleep(15000);
		System.out.println("Title printed by Thread " + Thread.currentThread().getId() + " - "
				+ DriverFactorySingleton.getInstance().getDriver().getTitle()
				+ " on DriverFactorySingleton.getInstance().getDriver() reference "
				+ DriverFactorySingleton.getInstance().getDriver());
		DriverFactorySingleton.getInstance().getDriver().manage().deleteAllCookies();

	}

	@AfterClass
	public void tearDown() {
		System.out.println("Browser closed by Thread " + Thread.currentThread().getId()
				+ " and Closing DriverFactorySingleton.getInstance().getDriver() reference is :"
				+ DriverFactorySingleton.getInstance().getDriver());
		DriverFactorySingleton.getInstance().closeDriver();
	}

}
