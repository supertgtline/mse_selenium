package ThreadLocalUsageInSelenium.RegisterUserParallelRunProblem;

public class RegisterUserTest {

	public static void main(String[] args) throws InterruptedException {
		RegisterUser registerUser = new RegisterUser();
		// Creating two threads and both are using same instance of RegisteredUser class
		Thread thread1 = new Thread(registerUser);
		Thread thread2 = new Thread(registerUser);
		// Starting first thread
		thread1.start();
		// Giving a pause
		Thread.sleep(2000);
		// Starting another thread
		thread2.start();
		
	}
}


 