package co.com.personal.fitness.tracker.model.service.repository;

import co.com.personal.fitness.tracker.datastructures.PersistentHashMap;
import co.com.personal.fitness.tracker.model.entity.User;
import co.com.personal.fitness.tracker.persistance.DataPersistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository implements Repository<User> {
    private PersistentHashMap<String, User> users;

    public UserRepository(DataPersistence dataPersistence) {
        // PersistentHashMap auto-loads and auto-saves!
        this.users = new PersistentHashMap<>("users.dat", dataPersistence);
        System.out.println("  ✓ Loaded " + users.size() + " users from storage");
    }

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
