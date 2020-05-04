package StaleElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubLoginPage {
	WebDriver driver;
	@FindBy(id = "login_field")
	public WebElement username;
	@FindBy(id = "password")
	public WebElement password;
	@FindBy(xpath = "//input[@value='Sign in']")
	public WebElement submit;

	public GitHubLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
