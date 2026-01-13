package co.com.personal.fitness.tracker.exceptions;

public class EmailAlreadyExistsException extends Exception {
    public static final int V1=188903037;

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
