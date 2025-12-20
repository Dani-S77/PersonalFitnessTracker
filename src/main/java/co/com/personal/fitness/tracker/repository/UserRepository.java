package co.com.personal.fitness.tracker.repository;

import co.com.personal.fitness.tracker.model.entity.User;
import co.com.personal.fitness.tracker.model.entity.Workout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository implements IRepository<User>{
    private Map<String, User> users=new HashMap<>();

    @Override
    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User findByEmail(String email){
        return users.values().stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}
