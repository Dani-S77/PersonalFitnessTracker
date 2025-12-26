package co.com.personal.fitness.tracker.model.service.impl;

import co.com.personal.fitness.tracker.model.entity.User;
import co.com.personal.fitness.tracker.model.service.interfaces.LoginService;
import co.com.personal.fitness.tracker.model.service.repository.UserRepository;

public class LoginServiceImpl implements LoginService {
    private UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User login(String email, String password) throws Exception {
        User user=userRepository.findByEmail(email);
        if(user==null){
            throw new Exception("User Not Found");
        }
        if(!user.getPassword().equals(password)){
            throw new Exception("Invalid Password");
        }
        return user;
    }
}