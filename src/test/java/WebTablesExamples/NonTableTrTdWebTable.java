package WebTablesExamples;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NonTableTrTdWebTable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/WebTable.html");
		
		// Wait till web table is loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[contains(@class,'ui-grid-viewport')]//div[contains(@class,'grid-row')]"), 1));

		// Let's get header first
		String headerLoc = "//div[contains(@class,'header-cell')]//span[contains(@id,'header-text')]";
		List<WebElement> allHeadersEle = driver.findElements(By.xpath(headerLoc));
		List<String> allHeaderNames = new ArrayList<String>();
		for (WebElement header : allHeadersEle) {
			String headerName = header.getText();
			allHeaderNames.add(headerName);
		}
		System.out.println("Headers are:-");
		System.out.println(allHeaderNames);

		// Each row will be a key value pair. So we will use LinkedHashMap so that order
		// can be retained.
		// All map will be added to a list.
		List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();

		// Get total rows count excluding headers
		String rowLoc = "//div[contains(@class,'ui-grid-viewport')]//div[contains(@class,'grid-row')]";
		List<WebElement> allRowsEle = driver.findElements(By.xpath(rowLoc));
		// Starting from 1 as xpath index starts from 1
		for (int i = 1; i <= allRowsEle.size(); i++) {
			// Getting specific row with each iteration
			String specificRowLoc = "(//div[contains(@class,'ui-grid-viewport')]//div[contains(@class,'grid-row')])["+i+"]";
			// Locating only cells of specific row.
			List<WebElement> allColumnsEle = driver.findElement(By.xpath(specificRowLoc)).findElements(By.xpath(".//div[contains(@class,'grid-cell-contents')]"));
			// Creating a map to store key-value pair data. It will be created for each iteration of row
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			// Iterating each cell
			for (int j = 0; j < allColumnsEle.size(); j++) {
				// Getting cell value
				String cellValue = allColumnsEle.get(j).getText();
				// We will put in to map with header name and value with iteration
				// Get jth index value from allHeaderNames and jth cell value of row
				eachRowData.put(allHeaderNames.get(j), cellValue);
			}
			// After iterating row completely, add in to list.
			allTableData.add(eachRowData);

		}

		System.out.println("Table data are:-");
		System.out.println("=========================================");
		for(LinkedHashMap<String, String> data : allTableData)
		{
			for(String key : data.keySet())
			{
				System.out.println(key + "      : "+ data.get(key));
			}
			System.out.println("=========================================");
		}
		driver.quit();
	}
}
