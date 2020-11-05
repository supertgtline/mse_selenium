package MixingWaitsExamples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.testng.annotations.Test;

public class CompletableFutureExample {
	
	
	@Test
	public void thenApplyAsync() throws InterruptedException, ExecutionException, TimeoutException {  
	    // A function which will be completed in 10 seconds but in get method I have timeout as 5.
		String completableFuture = CompletableFuture.supplyAsync(() -> {
	    		try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		return "Amod";
	    
	    }).get(5, TimeUnit.SECONDS);

	    System.out.println(completableFuture);
		

	}

}
