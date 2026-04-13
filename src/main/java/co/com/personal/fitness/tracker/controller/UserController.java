package co.com.personal.fitness.tracker.controller;

import co.com.personal.fitness.tracker.exceptions.UserNotFoundException;
import co.com.personal.fitness.tracker.model.entity.User;
import co.com.personal.fitness.tracker.model.service.interfaces.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User handleUpdateProfile(User user) throws UserNotFoundException {
        return userService.updateUser(user);
    }

    public User handleGetUser(String userId) {
        return userService.getUserById(userId);
    }
}
