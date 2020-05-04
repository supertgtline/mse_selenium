package WaitExamples;

import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

import org.openqa.selenium.support.ui.FluentWait;


public class FluentWaitForStringLengthExample {

	public static void main(String[] args) {

		StringBuilder word = new StringBuilder("FluentWait");

		// Setting FluentWait for word
		FluentWait<StringBuilder> wait = new FluentWait<StringBuilder>(word)
				// Check for condition in every 2 seconds
				.pollingEvery(Duration.ofSeconds(2))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30));

		// Defining conditions to be checked
		wait.until(new Function<StringBuilder, Boolean>() {
			@Override
			public Boolean apply(StringBuilder t) {
				System.out.println("Time while checking condition :"+new Date());
				// Delete first char of string
				t.deleteCharAt(0);
				System.out.println("Current Length of Word is " + t.length());
				return t.length() == 4;

			}
		});

		System.out.println("Condition satisfied.");

	}

}
