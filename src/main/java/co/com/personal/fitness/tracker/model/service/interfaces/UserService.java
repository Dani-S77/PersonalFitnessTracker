package co.com.personal.fitness.tracker.model.service.interfaces;

import co.com.personal.fitness.tracker.model.entity.User;

public interface UserService {
    User updateUser(User user) throws Exception;
    User getUserById(String id);
}
