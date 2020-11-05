package ScenariosForPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CoronaReport {

	@Test
	public void verifyCoronaCount() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.ndtv.com/coronavirus/india-covid-19-tracker");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		List<Map<String, Long>> coronaData = new ArrayList<>();
		List<String> fieldNames = new ArrayList<String>(
				Arrays.asList("totalCases", "totalNewCasesToday", "totatActive", "totalNewActiveToday", "TotalRcovered",
						"TodatRecoveredToday", "totalDeath", "TotalDealthToday").stream().collect(Collectors.toList()));

		driver.switchTo().frame(driver.findElement(By.id("t5")));
		int totalDataRow = driver.findElements(By.xpath("//tbody//tr")).size();
		System.out.println(totalDataRow);

		for (int i = 1; i <= totalDataRow; i++) {
			Map<String, Long> stateWiseCoronaData = new LinkedHashMap<>();
			String customLoc = "//tbody//tr[" + i + "]/td";
			int fieldCounter = 0;
			for (int j = 2; j <= 5; j++) {

				List<WebElement> totalCases = driver.findElements(By.xpath(customLoc + "[" + j + "]/p"));
				if (totalCases.size() == 1) {
					stateWiseCoronaData.put(fieldNames.get(fieldCounter),
							Long.valueOf(
									driver.findElement(By.xpath(customLoc + "[" + j + "]/p")).getText().split("\\n")[0]
											.replace(",", "")));
				}

				fieldCounter++;

				List<WebElement> todaysNewCases = driver.findElements(By.xpath(customLoc + "[" + j + "]//span"));
				if (todaysNewCases.size() == 1) {
					if (fieldNames.get(fieldCounter).equals("totalNewActiveToday")) {
						if (todaysNewCases.get(0).getAttribute("class").equalsIgnoreCase("data-up"))
							stateWiseCoronaData.put(fieldNames.get(fieldCounter),
									Long.valueOf("-" + todaysNewCases.get(0).getText().replace(",", "")));

						else
							stateWiseCoronaData.put(fieldNames.get(fieldCounter),
									Long.valueOf(todaysNewCases.get(0).getText().replace(",", "")));
					} else
						stateWiseCoronaData.put(fieldNames.get(fieldCounter),
								Long.valueOf(todaysNewCases.get(0).getText().replace(",", "")));

				}
				fieldCounter++;

			}
			System.out.println(stateWiseCoronaData);

			coronaData.add(stateWiseCoronaData);

		}

		System.out.println(coronaData);

//		List<String> totalCases = new ArrayList<>();
//		List<String> totalTodaysNewCases = new ArrayList<>();
//		List<String> totalActiveCases = new ArrayList<>();
//		List<String> totalTodaysActiveCases = new ArrayList<>();
//		List<String> totalRecoveredCases = new ArrayList<>();
//		List<String> totalTodaysRecoveredCases = new ArrayList<>();
//		List<String> totalDeathCases = new ArrayList<>();
//		List<String> totalTodaysDeathCases = new ArrayList<>();
//
//		driver.switchTo().frame(driver.findElement(By.id("t5")));
//		int totalDataRow = driver.findElements(By.xpath("//tbody//tr")).size();
//		System.out.println(totalDataRow);
//
//		for (int i = 1; i <= totalDataRow - 1; i++) {
//			String customLoc = "//tbody//tr[" + i + "]/td";
//			for (int j = 2; j <= 4; j++) {
//				if
//				totalCases.add(driver.findElement(By.xpath(customLoc + "[" + j + "]/p")).getText().split("\\n")[0]);
//
//				WebElement todaysNewCases = driver.findElement(By.xpath(customLoc + "[" + j + "]//span"));
//				if (todaysNewCases.getAttribute("class").equalsIgnoreCase("data-up"))
//					totalTodaysNewCases.add("-" + todaysNewCases.getText());
//				else
//					totalTodaysNewCases.add(todaysNewCases.getText());
//			}
//
//		}
//
//		System.out.println(totalCases);
//		System.out.println(totalTodaysNewCases);
//
//		long totalCasesCount = 0;
//		long totalTodaysNewCasesCount = 0;
//		long totalActiveCasesCount = 0;
//		long totalTodaysActiveCasesCount = 0;
//		long totalRecoveredCasesCount = 0;
//		long totalTodaysRecoveredCasesCount = 0;
//		long totalDeathCasesCount = 0;
//		long totalTodaysDeathCasesCount = 0;
//
//		for (String s : totalCases) {
//			totalCasesCount = totalCasesCount + Long.valueOf(s.replace(",", ""));
//
//		}
//
//		for (String s : totalTodaysNewCases) {
//
//			totalTodaysNewCasesCount = totalTodaysNewCasesCount + Long.valueOf(s.replace(",", ""));
//		}
//
//		for (String s : totalActiveCases) {
//
//			totalActiveCasesCount = totalActiveCasesCount + Long.valueOf(s.replace(",", ""));
//		}
//
//		for (String s : totalTodaysActiveCases) {
//
//			totalTodaysActiveCasesCount = totalTodaysActiveCasesCount + Long.valueOf(s.replace(",", ""));
//		}
//
//		for (String s : totalRecoveredCases) {
//
//			totalRecoveredCasesCount = totalRecoveredCasesCount + Long.valueOf(s.replace(",", ""));
//		}
//
//		for (String s : totalTodaysRecoveredCases) {
//
//			totalTodaysRecoveredCasesCount = totalTodaysRecoveredCasesCount + Long.valueOf(s.replace(",", ""));
//		}
//
//		for (String s : totalDeathCases) {
//
//			totalDeathCasesCount = totalDeathCasesCount + Long.valueOf(s.replace(",", ""));
//		}
//
//		for (String s : totalTodaysDeathCases) {
//
//			totalTodaysDeathCasesCount = totalTodaysDeathCasesCount + Long.valueOf(s.replace(",", ""));
//		}
//
//		System.out.println(totalCasesCount);
//		System.out.println(totalTodaysNewCasesCount);
//		System.out.println(totalActiveCasesCount);
//		System.out.println(totalActiveCasesCount);
//		System.out.println(totalRecoveredCasesCount);
//		System.out.println(totalTodaysRecoveredCasesCount);
//		System.out.println(totalDeathCasesCount);
//		System.out.println(totalTodaysDeathCasesCount);

	}
}
