package co.com.personal.fitness.tracker.model.service.interfaces;

import co.com.personal.fitness.tracker.exceptions.UserNotFoundException;
import co.com.personal.fitness.tracker.model.entity.User;

public interface UserService {
    User updateUser(User user) throws UserNotFoundException;
    User getUserById(String id);
}
