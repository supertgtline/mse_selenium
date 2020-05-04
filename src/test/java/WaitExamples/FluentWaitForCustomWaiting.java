package WaitExamples;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitForCustomWaiting {

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
				// Delete first char of string
				t.deleteCharAt(0);
				// Wait for 3 seconds
				try {
					System.out.println("Consition is not satisfied so Waiting for 2 seconds.....");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Current Length of Word is " + t.length());
				return t.length() == 0;

			}
		});

		System.out.println("Condition satisfied.");

	}

}
