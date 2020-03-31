package WebTablesExamples;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadTableDataWithPaginationInListOfMap {

	@Test
	public void readTableDataInListOfMap() throws InterruptedException {
		// Browser initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String fileURL = System.getProperty("user.dir");
		driver.get(fileURL + "/src/test/resources/htmlFiles/WebTablePagination.html");

		// Let's get header first
		String headerLoc = "//table[@id='dtBasicExample']//tr//th";
		List<WebElement> allHeadersEle = driver.findElements(By.xpath(headerLoc));
		List<String> allHeaderNames = new ArrayList<String>();
		for (WebElement header : allHeadersEle) {
			String headerName = header.getText();
			allHeaderNames.add(headerName);
		}

		// Each row will be a key value pair. So we will use LinkedHashMap so that order
		// can be retained.
		// All map will be added to a list.
		List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
		boolean flag = true;

		while (flag) {
			// Get total rows count
			String rowLoc = "//table[@id='dtBasicExample']//tbody/tr";
			List<WebElement> allRowsEle = driver.findElements(By.xpath(rowLoc));
			for (int i = 1; i <= allRowsEle.size(); i++) {
				// Getting specific row with each iteration
				String specificRowLoc = "//table[@id='dtBasicExample']//tbody/tr[" + i + "]";
				// Locating only cells of specific row.
				List<WebElement> allColumnsEle = driver.findElement(By.xpath(specificRowLoc))
						.findElements(By.tagName("td"));
				// Creating a map to store key-value pair data. It will be created for each
				// iteration of row
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
			if ((driver.findElement(By.id("dtBasicExample_next")).getAttribute("class").contains("disabled"))) {
				flag = false;
				break;
			} else {
				driver.findElement(By.id("dtBasicExample_next")).click();
				Thread.sleep(5000);
			}
		}

		System.out.println(allTableData);
		driver.quit();

	}

}
