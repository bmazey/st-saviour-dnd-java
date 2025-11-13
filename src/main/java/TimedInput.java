import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TimedInput {

    public static String getUserInputWithTimeout(long timeoutSeconds) {
        // Create an ExecutorService to manage the input task
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Create a Callable that reads input from the console
        Callable<String> inputCallable = () -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your input within " + timeoutSeconds + " seconds: ");
            return scanner.nextLine();
        };

        // Submit the input task to the executor
        Future<String> future = executor.submit(inputCallable);

        try {
            // Get the result of the input task, with a specified timeout
            return future.get(timeoutSeconds, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("\nTime's up! No input received.");
            return null; // Or throw a custom exception
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error while getting input: " + e.getMessage());
            return null;
        } finally {
            // Shut down the executor service to release resources
            executor.shutdownNow();
        }
    }
}
