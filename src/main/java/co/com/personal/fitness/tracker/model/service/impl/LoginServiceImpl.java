package co.com.personal.fitness.tracker.model.service.impl;

import co.com.personal.fitness.tracker.exceptions.InvalidCredentialsException;
import co.com.personal.fitness.tracker.exceptions.UserNotFoundException;
import co.com.personal.fitness.tracker.model.entity.User;
import co.com.personal.fitness.tracker.model.service.interfaces.LoginService;
import co.com.personal.fitness.tracker.model.service.repository.UserRepository;

import java.util.Objects;

public class LoginServiceImpl implements LoginService {
    private UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User login(String email, String password) throws UserNotFoundException, InvalidCredentialsException {
        User user=userRepository.findByEmail(email);
        if(Objects.isNull(user)){
            throw new UserNotFoundException("User Not Found");
        }
        if(!user.getPassword().equals(password)){
            throw new InvalidCredentialsException("Invalid Password");
        }
        return user;
    }
}