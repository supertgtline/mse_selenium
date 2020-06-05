package BasicSeleniumConcepts;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class MyExpectedCondiions {
	
	public static boolean invisibilityOf(WebElement element)
	{
		try {
			return !element.isDisplayed();
		}catch(StaleElementReferenceException | NoSuchElementException e )
		{
			System.out.println("Element is stale or not found whihc means element is invisible.");
			return true;
		}
	}

	public static ExpectedCondition<Boolean> invisibilityOfPageFactoryElement(WebElement element) {
	    return new ExpectedCondition<Boolean>() {

	      @Override
	      public Boolean apply(WebDriver webDriver) {
	        return invisibilityOf(element);
	      }

	      @Override
	      public String toString() {
	        return "invisibility of " + element;
	      }
	    };
	  }
}
