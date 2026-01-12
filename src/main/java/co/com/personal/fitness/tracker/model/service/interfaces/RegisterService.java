package co.com.personal.fitness.tracker.model.service.interfaces;

import co.com.personal.fitness.tracker.exceptions.EmailAlreadyExistsException;
import co.com.personal.fitness.tracker.model.entity.User;

public interface RegisterService {

    User register(String firstName, String lastName, String email, String password, boolean isAdmin) throws EmailAlreadyExistsException;
}
