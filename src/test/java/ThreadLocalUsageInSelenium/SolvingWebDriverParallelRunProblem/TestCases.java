package ThreadLocalUsageInSelenium.SolvingWebDriverParallelRunProblem;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCases {
	
/*	I am not using static ThreadLocal variable here bcz I have kept it in test class where it is being used.
	If we keep it in another class, you can use it as static with static setter & getter methods.
	
	Since class variables are shared among thread so I made class variable as a ThreadLocal. So each threads will separate instance of class
	variable.
	
	 When we run test methods of this class in parallel with thread count as 2, it will launch two browsers in parallel
	 and execution will go smoothly without interfering each other's execution.
	 
*/
	private ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();
	
	@BeforeMethod
	public void setUpBrowser()
	{
		WebDriverFactory webDriverFactory = new WebDriverFactory();
		webDriverFactory.setDriver();
		webdriver.set(webDriverFactory.getDriver());
	}

	@Test
	public void test1()
	{
		
		webdriver.get().get("https://www.google.com/");
		System.out.println("Title printed by "+Thread.currentThread().getName()+webdriver.get().getTitle());
		webdriver.get().close();
	}
	
	@Test
	public void test2()
	{
		webdriver.get().get("https://www.facebook.com/");
		System.out.println("Title printed by "+Thread.currentThread().getName()+webdriver.get().getTitle());
		webdriver.get().close();
	}
}
