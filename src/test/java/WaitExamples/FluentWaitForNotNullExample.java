package WaitExamples;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitForNotNullExample {
	
	
	public static void main(String[] args) {
		Random r = new Random();
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		// Setting FluentWait for Random r
		FluentWait<Random> wait = new FluentWait<Random>(r)
				// Check for condition in every 2 seconds
				.pollingEvery(Duration.ofSeconds(2))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30));

		// Defining conditions to be checked
		String word = wait.until(new Function<Random, String>() {
			@Override
			public String apply(Random r) {
				System.out.println("Time while checking condition :"+new Date());
				// It will pick a random index between 0 and size of number
				int current = r.nextInt(numbers.size());
				if(numbers.get(current) == 4)
				{
					// Return not null value
					return "Assigned Some Value "+ current;
				}
				// return null so that checking for condition will be continued
				return null;	
			}
		});

		System.out.println("Condition satisfied and value for word is : "+word);

	}

}
