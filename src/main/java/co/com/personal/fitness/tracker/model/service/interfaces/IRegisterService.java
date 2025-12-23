package co.com.personal.fitness.tracker.model.service.interfaces;

import co.com.personal.fitness.tracker.model.entity.User;

public interface IRegisterService {
    User register(String firstName, String lastName, String email, String password, boolean isAdmin) throws Exception;
}
