package co.com.personal.fitness.tracker.model.service.impl;

import co.com.personal.fitness.tracker.exceptions.EmailAlreadyExistsException;
import co.com.personal.fitness.tracker.model.entity.AdminUser;
import co.com.personal.fitness.tracker.model.entity.RegularUser;
import co.com.personal.fitness.tracker.model.entity.User;
import co.com.personal.fitness.tracker.model.service.interfaces.RegisterService;
import co.com.personal.fitness.tracker.model.service.repository.UserRepository;

import java.util.Objects;

public class RegisterServiceImpl implements RegisterService {
    private UserRepository userRepository;

    public RegisterServiceImpl(UserRepository userRepository) {
        this.userRepository = new UserRepository();
    }

    @Override
    public User register(String firstName, String lastName, String email, String password, boolean isAdmin) throws EmailAlreadyExistsException {
        if (!Objects.isNull(userRepository.findByEmail(email))) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        String id = String.valueOf(System.currentTimeMillis());
        User user;
        if (isAdmin) {
            user = new AdminUser(id, firstName, lastName, email, password);
        } else {
            user = new RegularUser(id, firstName, lastName, email, password);
        }
        return userRepository.save(user);
    }
}