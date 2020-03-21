package WebTablesExamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

		// Get total rows count
		String rowLoc = "//table[@class='tg']//tr";
		List<String> headers = driver.findElements(By.xpath("//table[@class='tg']//tr//th")).stream().map(v -> v.getText()).collect(Collectors.toList());

		driver.findElements(By.xpath(rowLoc)).stream().skip(1).forEach(row -> {
			List<String> rowData = row.findElements(By.tagName("td")).stream().map(c -> c.getText()).collect(Collectors.toList());
			allTableData.add(IntStream.range(0, headers.size()).boxed().collect(Collectors.toMap(i -> headers.get(i),
					i -> rowData.get(i), (first, second) -> first, LinkedHashMap<String, String>::new)));
		});

		System.out.println(allTableData);

		driver.quit();
	}

}
