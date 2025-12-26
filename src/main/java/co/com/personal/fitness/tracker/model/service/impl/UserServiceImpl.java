package co.com.personal.fitness.tracker.model.service.impl;

import co.com.personal.fitness.tracker.model.entity.User;
import co.com.personal.fitness.tracker.model.service.interfaces.UserService;
import co.com.personal.fitness.tracker.model.service.repository.UserRepository;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User updateUser(User user) throws Exception{
        User existingUser=userRepository.findById(user.getId());
        if(existingUser==null){
            throw new Exception("User Not Found");
        }
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String id){
        return userRepository.findById(id);
    }
}
