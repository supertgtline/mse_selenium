package HandlingWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.*;
import java.util.Map.Entry;

public class TrialError {

    public static WebDriver driver;
    public static ArrayList<HashMap<String,Object>> lstOfMap;

    //Browser Operation
    public void getSite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
    }

    public void getPageDataAsIs() {
        lstOfMap = new ArrayList<>();


        for (int val = 1; val < 4; val++) {
        	HashMap<String, Object> tableData = new HashMap<String, Object>();
            List<WebElement> userName = driver.findElements(By.xpath("//tbody/tr[" + val + "]/td[1]"));
            List<WebElement> userAge = driver.findElements(By.xpath("//tbody/tr[" + val + "]/td[4]"));
            List<WebElement> userSalary = driver.findElements(By.xpath("//tbody/tr[" + val + "]/td[6]"));

            for (int i = 0, j = 0, k = 0; i < userName.size() && j < userSalary.size() &&
                    k < userSalary.size(); i++, j++, k++) {

                tableData.put("Name", userName.get(i).getText());
                tableData.put("Age", Integer.parseInt(userAge.get(j).getText()));
                tableData.put("Salary", Integer.parseInt(userSalary.get(k).getText().replaceAll("\\D+", "")));
            }

            System.out.println();
            lstOfMap.add(tableData);
        }

        System.out.println(lstOfMap);
    }
    
    
    public static void sortMap(String key) {
    	
    	Collections.sort(lstOfMap, new Comparator<HashMap<String, Object>>() {
            public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
            	if(o1.get(key) instanceof String)
                return ((String)o1.get(key)).compareTo((String)o2.get(key));
            	if(o1.get(key) instanceof Integer)
                    return ((Integer)o1.get(key)).compareTo((Integer)o2.get(key));
				return 0;
            }

			
        });
    	
    	System.out.println(lstOfMap);
    	
    	

        
    }

    public static void main(String[] args) {
        TrialError te = new TrialError();
        te.getSite();
        te.getPageDataAsIs();
        te.sortMap("Name");
        te.sortMap("Age");
        te.sortMap("Salary");
    }
}

