package ThreadLocalUsageInSelenium.WebDriverParallelRunProblem;

import org.testng.annotations.Test;

import ThreadLocalUsageInSelenium.SolvingWebDriverParallelRunProblem.WebDriverFactory;


public class WebDriverTestWithoutClassVariable {
	

	@Test
	public void test1()
	{
		WebDriverFactory webDriverFactory = new WebDriverFactory();	
		webDriverFactory.setDriver();
		webDriverFactory.getDriver().get("https://www.google.com/");
		System.out.println("Title printed by "+Thread.currentThread().getId()+" - "+webDriverFactory.getDriver().getTitle());
		webDriverFactory.getDriver().close();
	}
	
	@Test
	public void test2()
	{
		WebDriverFactory webDriverFactory = new WebDriverFactory();	
		webDriverFactory.setDriver();
		webDriverFactory.getDriver().get("https://www.facebook.com/");
		System.out.println("Title printed by "+Thread.currentThread().getId()+" - "+webDriverFactory.getDriver().getTitle());
		webDriverFactory.getDriver().close();
	}
}
