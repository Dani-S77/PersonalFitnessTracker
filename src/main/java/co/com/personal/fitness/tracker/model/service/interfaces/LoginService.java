package co.com.personal.fitness.tracker.model.service.interfaces;

import co.com.personal.fitness.tracker.model.entity.User;

public interface LoginService {
    User login(String email, String password) throws Exception;
}
