package WaitExamples;

import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

import org.openqa.selenium.support.ui.FluentWait;


public class FluentWaitApplyTypeParamters {

	public static void main(String[] args) {

		String word = new String("FluentWait");

		// Setting FluentWait for word
		FluentWait<String> wait = new FluentWait<String>(word)
				// Check for condition in every 5 seconds
				.pollingEvery(Duration.ofSeconds(5))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30));

		// Defining conditions to be checked
		wait.until(new Function<String, Boolean>() {
			@Override
			public Boolean apply(String t) {
				System.out.println("Time while checking condition :"+new Date());
				// To Delete first char of string
				t = t.substring(1);
				System.out.println("Current Length of Word is " + t.length());
				return t.length() == 4;

			}
		});

		System.out.println("Condition satisfied.");

	}

}
