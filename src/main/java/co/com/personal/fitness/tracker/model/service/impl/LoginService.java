package co.com.personal.fitness.tracker.model.service.impl;

import co.com.personal.fitness.tracker.model.entity.User;
import co.com.personal.fitness.tracker.model.service.ILoginService;
import co.com.personal.fitness.tracker.repository.UserRepository;

public class LoginService implements ILoginService {
    private UserRepository userRepository;

    @Override
    public User login(String email, String password) throws Exception {
        return null;
    }
}
