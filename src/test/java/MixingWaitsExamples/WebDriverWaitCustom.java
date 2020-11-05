package MixingWaitsExamples;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Throwables;

public class WebDriverWaitCustom extends FluentWait<WebDriver> {
	
	private final WebDriver driver;

	  

	  /**
	   * Wait will ignore instances of NotFoundException that are encountered (thrown) by default in
	   * the 'until' condition, and immediately propagate all others.  You can add more to the ignore
	   * list by calling ignoring(exceptions to add).
	   *
	   * @param driver The WebDriver instance to pass to the expected conditions
	   * @param timeout The timeout when an expectation is called
	   * @see WebDriverWait#ignoring(java.lang.Class)
	   */
	  public WebDriverWaitCustom(WebDriver driver, Duration timeout) {
	    this(
	        driver,
	        timeout,
	        Duration.ofMillis(DEFAULT_SLEEP_TIMEOUT),
	        Clock.systemDefaultZone(),
	        Sleeper.SYSTEM_SLEEPER);
	  }

	 
	  /**
	   * Wait will ignore instances of NotFoundException that are encountered (thrown) by default in
	   * the 'until' condition, and immediately propagate all others.  You can add more to the ignore
	   * list by calling ignoring(exceptions to add).
	   *
	   * @param driver The WebDriver instance to pass to the expected conditions
	   * @param timeout The timeout in seconds when an expectation is called
	   * @param sleep The duration in milliseconds to sleep between polls.
	   * @see WebDriverWait#ignoring(java.lang.Class)
	   */
	  public WebDriverWaitCustom(WebDriver driver, Duration timeout, Duration sleep) {
	    this(driver, timeout, sleep, Clock.systemDefaultZone(), Sleeper.SYSTEM_SLEEPER);
	  }

	 

	  /**
	   * @param driver the WebDriver instance to pass to the expected conditions
	   * @param clock used when measuring the timeout
	   * @param sleeper used to make the current thread go to sleep
	   * @param timeout the timeout when an expectation is called
	   * @param sleep the timeout used whilst sleeping
	   */
	  public WebDriverWaitCustom(
	      WebDriver driver, Duration timeout, Duration sleep, Clock clock, Sleeper sleeper) {
	    super(driver, clock, sleeper);
	    withTimeout(timeout);
	    pollingEvery(sleep);
	    ignoring(NotFoundException.class);
	    this.driver = driver;
	  }

	  @Override
	  protected RuntimeException timeoutException(String message, Throwable lastException) {
	    WebDriver exceptionDriver = driver;
	    TimeoutException ex = new TimeoutException(message, lastException);
	    ex.addInfo(WebDriverException.DRIVER_INFO, exceptionDriver.getClass().getName());
	    while (exceptionDriver instanceof WrapsDriver) {
	      exceptionDriver = ((WrapsDriver) exceptionDriver).getWrappedDriver();
	    }
	    if (exceptionDriver instanceof RemoteWebDriver) {
	      RemoteWebDriver remote = (RemoteWebDriver) exceptionDriver;
	      if (remote.getSessionId() != null) {
	        ex.addInfo(WebDriverException.SESSION_ID, remote.getSessionId().toString());
	      }
	      if (remote.getCapabilities() != null) {
	        ex.addInfo("Capabilities", remote.getCapabilities().toString());
	      }
	    }
	    throw ex;
	  }

	  
	  
	  public Boolean until1(Function<WebDriver,Boolean> isTrue) {
	    try {
	      return CompletableFuture.supplyAsync(checkConditionInLoop(isTrue))
	          .get(deriveSafeTimeout(), TimeUnit.MILLISECONDS);
	    } catch (ExecutionException cause) {
	      if (cause.getCause() instanceof RuntimeException) {
	        throw (RuntimeException) cause.getCause();
	      } else if (cause.getCause() instanceof Error) {
	        throw (Error) cause.getCause();
	      }

	      throw new RuntimeException(cause);
	    } catch (InterruptedException cause) {
	      throw new RuntimeException(cause);
	    } catch (java.util.concurrent.TimeoutException cause) {
	      throw new TimeoutException("Supplied function might have stalled", cause);
	    }
	  }

	  private final java.time.Clock clock;
	  private Duration timeout = Duration.ofSeconds(25);
	  private Duration interval = Duration.ofSeconds(23);
	  private final T input;
	  
	  private Supplier<Boolean> checkConditionInLoop(Function<WebDriver,Boolean> isTrue) {
		    return () -> {
		      Instant end = clock.instant().plus(timeout);

		      Throwable lastException;
		      while (true) {
		        //noinspection ProhibitedExceptionCaught
		        try {
		          V value = isTrue.apply(input);
		          if (value != null && (Boolean.class != value.getClass() || Boolean.TRUE.equals(value))) {
		            return value;
		          }

		          // Clear the last exception; if another retry or timeout exception would
		          // be caused by a false or null value, the last exception is not the
		          // cause of the timeout.
		          lastException = null;
		        } catch (Throwable e) {
		          lastException = propagateIfNotIgnored(e);
		        }

		        // Check the timeout after evaluating the function to ensure conditions
		        // with a zero timeout can succeed.
		        if (end.isBefore(clock.instant())) {
		          String message = messageSupplier != null ? messageSupplier.get() : null;

		          String timeoutMessage = String.format(
		              "Expected condition failed: %s (tried for %d second(s) with %d milliseconds interval)",
		              message == null ? "waiting for " + isTrue : message,
		              timeout.getSeconds(), interval.toMillis());
		          throw timeoutException(timeoutMessage, lastException);
		        }

		        try {
		          sleeper.sleep(interval);
		        } catch (InterruptedException e) {
		          Thread.currentThread().interrupt();
		          throw new WebDriverException(e);
		        }
		      }
		    };
		  }

		  /** This timeout is somewhat arbitrary.  */
		  private long deriveSafeTimeout() {
		    return this.timeout.toMillis() + this.interval.toMillis();
		  }

		  private Throwable propagateIfNotIgnored(Throwable e) {
		    for (Class<? extends Throwable> ignoredException : ignoredExceptions) {
		      if (ignoredException.isInstance(e)) {
		        return e;
		      }
		    }
		    Throwables.throwIfUnchecked(e);
		    throw new RuntimeException(e);
		  }

		  /**
		   * Throws a timeout exception. This method may be overridden to throw an exception that is
		   * idiomatic for a particular test infrastructure, such as an AssertionError in JUnit4.
		   *
		   * @param message       The timeout message.
		   * @param lastException The last exception to be thrown and subsequently suppressed while waiting
		   *                      on a function.
		   * @return Nothing will ever be returned; this return type is only specified as a convenience.
		   */
		  protected RuntimeException timeoutException(String message, Throwable lastException) {
		    throw new TimeoutException(message, lastException);
		  }
	 
}
