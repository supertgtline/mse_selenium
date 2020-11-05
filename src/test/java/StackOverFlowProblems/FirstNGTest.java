package StackOverFlowProblems;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstNGTest {
    WebDriver driver;
    DesiredCapabilities caps;
    WebElement element;
    ChromeOptions chromeOptions;

    @Test
    
    public void testOnChromeWithBrowserStackSignUp() throws MalformedURLException, InterruptedException
    {
        //String chromeDriverPath = "resources/chromedriver.exe";
      // make driver, add options/arguments
        //System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    	WebDriverManager.chromedriver().setup();
        chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        Thread.sleep(10000);
        driver.manage().window().maximize();
        
    }
    
    @Test
    public void f() throws MalformedURLException, InterruptedException
    {
        
       // String chromeDriverPath = "resources/chromedriver.exe";
        //System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        //chromeOptions = new ChromeOptions();
    	WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.browserstack.com/");
        Thread.sleep(20000);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void close()
    {
    driver.quit();
    }
}