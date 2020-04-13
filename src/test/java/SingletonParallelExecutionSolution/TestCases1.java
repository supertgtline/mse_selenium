package SingletonParallelExecutionSolution;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCases1 {

	@BeforeClass
	public void setUp() {
		DriverFactorySingleton.getInstance();
		System.out.println("Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : "
				+ DriverFactorySingleton.getInstance().getDriver());
	}

	@Test
	public void GoogleTest(Method m) throws InterruptedException {
		System.out.println(m.getName() + " of class TestCases1 Executed by Thread " + Thread.currentThread().getId()
				+ " on driver reference " + DriverFactorySingleton.getInstance().getDriver());
		DriverFactorySingleton.getInstance().getDriver().get("https://www.google.com/");
		Thread.sleep(15000);
		System.out.println("Title printed by Thread " + Thread.currentThread().getId() + " - "
				+ DriverFactorySingleton.getInstance().getDriver().getTitle() + " on driver reference "
				+ DriverFactorySingleton.getInstance().getDriver());
		DriverFactorySingleton.getInstance().getDriver().manage().deleteAllCookies();
	}

	@Test
	public void FacebookTest(Method m) throws InterruptedException {
		System.out.println(m.getName() + " of class TestCases1 Executed by Thread " + Thread.currentThread().getId()
				+ " on driver reference " + DriverFactorySingleton.getInstance().getDriver());
		DriverFactorySingleton.getInstance().getDriver().get("https://www.facebook.com/");
		Thread.sleep(15000);
		System.out.println("Title printed by Thread " + Thread.currentThread().getId() + " - "
				+ DriverFactorySingleton.getInstance().getDriver().getTitle() + " on driver reference "
				+ DriverFactorySingleton.getInstance().getDriver());
		DriverFactorySingleton.getInstance().getDriver().manage().deleteAllCookies();

	}

	@AfterClass
	public void tearDown() {
		System.out.println("Browser closed by Thread " + Thread.currentThread().getId()
				+ " and Closing driver reference is :" + DriverFactorySingleton.getInstance().getDriver());
		DriverFactorySingleton.getInstance().removeDriver();
	}

}
