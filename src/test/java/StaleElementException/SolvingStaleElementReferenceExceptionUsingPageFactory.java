package StaleElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


class LoginPage
{
	@FindBy(id= "email_create")
	protected WebElement emailAddress;
	
	
	LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}


public class SolvingStaleElementReferenceExceptionUsingPageFactory{
	
	@Test
	public void doActions() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		LoginPage loginPage = new LoginPage(driver);
		
		
		// Let's perform same actions multiple times.
		loginPage.emailAddress.sendKeys("Amod@gmail.com");
		loginPage.emailAddress.clear();
		loginPage.emailAddress.sendKeys("Amod1@gmail.com");
		loginPage.emailAddress.clear();
		loginPage.emailAddress.sendKeys("Amod2@gmail.com");
		loginPage.emailAddress.clear();
		
		// Let's refresh the web page
		driver.navigate().refresh();
		
		
		loginPage.emailAddress.sendKeys("Amod4@gmail.com");
		loginPage.emailAddress.clear();
		
		
	}

}
