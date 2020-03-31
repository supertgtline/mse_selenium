package WebTablesExamples;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadTableDataInListOfMapUsingStreamAPI {

	@Test
	public void readTableDataInListOfMap() {
		// Browser initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String fileURL = System.getProperty("user.dir");
		driver.get(fileURL + "/src/test/resources/htmlFiles/WebTable.html");

		// Each row will be a key value pair. So we will use LinkedHashMap so that order can be retained.
		// All map will be added to a list.
		List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();

		// Get total headers of table using stream apis,
		String rowLoc = "//table[@class='tg']//tr";
		List<String> headers = driver.findElements(By.xpath("//table[@class='tg']//tr//th")).stream().map(headerEle -> headerEle.getText()).collect(Collectors.toList());

		// Getting each row then getting each column of row
		// skip(1) to skip first row as first row is header row
		driver.findElements(By.xpath(rowLoc)).stream().skip(1).forEach(row -> {
			// each cell data of row
			List<String> rowData = row.findElements(By.tagName("td")).stream().map(columnEle -> columnEle.getText()).collect(Collectors.toList());
			// Now iterating both header list and rowData list and putting in to a LinkedHashMap
			// toMap() has overloaded version.Third argument is to combine duplicate key values. 
			allTableData.add(IntStream.range(0, headers.size()).boxed().collect(Collectors.toMap(i -> headers.get(i),
					i -> rowData.get(i), (first, second) -> first, LinkedHashMap<String, String>::new)));
		});

		System.out.println(allTableData);

		driver.quit();
	}

}
