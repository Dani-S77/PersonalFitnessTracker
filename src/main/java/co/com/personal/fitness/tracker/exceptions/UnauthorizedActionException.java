package co.com.personal.fitness.tracker.exceptions;

public class UnauthorizedActionException extends Exception{
    public static final int V1= 188903037;

    public UnauthorizedActionException(String message) {
        super(message);
    }
}
