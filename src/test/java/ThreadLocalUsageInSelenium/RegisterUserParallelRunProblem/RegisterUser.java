package ThreadLocalUsageInSelenium.RegisterUserParallelRunProblem;

import java.util.Random;

/*
 * This class has a method to register user. Implementing this class to run as a Thread.
 */
public class RegisterUser implements Runnable {

	// Using it as a class variable as I need to use same registered user in
	// multiple methods.
	// Registered user in createUser() method and getting the name in
	// getUserWithDelay() methods.
	String registeredUserName = "No Value";

	@Override
	public void run() {
		createUser();
		try {
			getUserWithDelay();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Creating a user and setting value as global variable
	private void createUser() {
		System.out.println(Thread.currentThread().getId()
				+ " - Before starting registration, value of registeredUserName :" + registeredUserName);
		System.out.println(Thread.currentThread().getId() + " - Registering a user.");
		registeredUserName = Thread.currentThread().getId() + " - User" + new Random().nextInt(999);
		System.out.println(Thread.currentThread().getId() + " - After registration, value of registeredUserName :"
				+ registeredUserName);
	}

	// Retrieving registered user name
	private void getUserWithDelay() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println(Thread.currentThread().getId() + " - After some delay , value of registeredUserName :"
				+ registeredUserName);

	}

}
