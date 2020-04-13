package ThreadLocalUsageInSelenium.WebDriverParallelRunProblem;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {

	/*
	 * When we run this particular class methods in parallel, each method may
	 * execute by a different thread based on thread count. So here class variable
	 * "webDriverFactory" which is used in both tests will be shared by all threads
	 * and you will see unexpected execution.
	 * 
	 * I have given sleep just to observe execution. You will see two browsers
	 * (because thread count is 2 in xml) are launched but execution will not be as
	 * expected. Our expectation is that it should launch two browsers in parallel
	 * and execute test 1 in one and test 2 in another and close respective browser
	 * on completion of test. But because of sharing of class variable
	 * "webDriverfactory" between threads, execution will not be as expected.
	 * Different run may give you different output.
	 * 
	 * At last you will see both threads pointing to same browser instance and other
	 * will be left unattended.
	 */
	WebDriverFactory webDriverFactory;

	@BeforeMethod
	public void setUpBrowser() {
		webDriverFactory = new WebDriverFactory();
		webDriverFactory.setDriver();
	}

	@Test
	public void test1() throws InterruptedException {

		webDriverFactory.getDriver().get("https://www.google.com/");
		Thread.sleep(5000);
		System.out.println(
				"Title printed by " + Thread.currentThread().getId() + " - " + webDriverFactory.getDriver().getTitle());
		webDriverFactory.getDriver().close();
	}

	@Test
	public void test2() throws InterruptedException {
		webDriverFactory.getDriver().get("https://www.facebook.com/");
		Thread.sleep(5000);
		System.out.println(
				"Title printed by " + Thread.currentThread().getId() + " - " + webDriverFactory.getDriver().getTitle());
		webDriverFactory.getDriver().close();
	}

	@AfterMethod
	public void tearDown() {
		webDriverFactory.getDriver().close();
	}
}
