package WaitExamples;

import java.time.Duration;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;

import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitNonIgnoringException {
	
	static int conditionCheckingCounter = 0; 
	
	public static void main(String[] args) {
		
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Amod");
		list.add("Mukesh");
		list.add("Selenium");
		
		
		// Setting FluentWait for list
		FluentWait<ArrayList<String>> wait = new FluentWait<ArrayList<String>>(list)
				// Check for condition in every 2 seconds
				.pollingEvery(Duration.ofSeconds(2))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30));
		
		// Defining conditions to be checked
		// I want to wait till there are desired number of elements in list
		wait.until(new Function<ArrayList<String>, Boolean>() {
			@Override
			public Boolean apply(ArrayList<String> t) {
				conditionCheckingCounter++;
				System.out.println("List at starting retry no "+conditionCheckingCounter+" : "+t);
				t.add(1, "Java");
				// Purposefully generating IndexOutOfBoundsException by giving non-existing index to add element for one time
				// Sin
				if(conditionCheckingCounter==4)
					t.add(20, "Java");
				// Waiting for 3 seconds
				try {
					System.out.println("Wait for 3 seconds");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("List at end retry no "+conditionCheckingCounter+" : "+t);
				// Return if list size is desirable 
				return t.size()==8;
			}
		});
		
		System.out.println("Condition satisfied.");
		
	}

}
