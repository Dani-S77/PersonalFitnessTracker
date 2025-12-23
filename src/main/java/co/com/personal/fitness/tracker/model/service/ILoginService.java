package co.com.personal.fitness.tracker.model.service;

import co.com.personal.fitness.tracker.model.entity.User;

public interface ILoginService {
    User login(String email, String password) throws Exception;
}
