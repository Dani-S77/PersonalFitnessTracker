package co.com.personal.fitness.tracker.exceptions;

public class UserNotFoundException extends Exception{
    public static final int V1=188903037;

    public UserNotFoundException(String message){
        super(message);
    }

}
