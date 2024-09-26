// File: SingletonPattern.java

/**
 * A singleton class that provides a global logger instance.
 */
class Logger {
    // Private static field to store the singleton instance
    private static Logger instance;

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private Logger() {
    }

    /**
     * Get the singleton instance of the logger.
     * @return the logger instance
     */
    public static Logger getInstance() {
        // Check if the instance is null and create it if necessary
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    /**
     * Log a message to the console.
     * @param message the message to log
     */
    public void log(String message) {
        // Print the log message to the console
        System.out.println("Log: " + message);
    }
}

/**
 * Main class to demonstrate the use of the singleton pattern.
 */
public class SingletonPatternMain {
    public static void main(String[] args) {
        // Get the singleton instance of the logger
        Logger logger = Logger.getInstance();
        // Log a message using the logger
        logger.log("First log message.");  // Output: Log: First log message.

        // Get the singleton instance of the logger again
        Logger anotherLogger = Logger.getInstance();
        // Log another message using the logger
        anotherLogger.log("Second log message.");  // Output: Log: Second log message.
    }
}