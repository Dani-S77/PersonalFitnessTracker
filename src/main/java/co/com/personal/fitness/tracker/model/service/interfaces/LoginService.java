package co.com.personal.fitness.tracker.model.service.interfaces;

import co.com.personal.fitness.tracker.exceptions.InvalidCredentialsException;
import co.com.personal.fitness.tracker.exceptions.UserNotFoundException;
import co.com.personal.fitness.tracker.model.entity.User;

public interface LoginService {
    User login(String email, String password) throws UserNotFoundException, InvalidCredentialsException;
}
