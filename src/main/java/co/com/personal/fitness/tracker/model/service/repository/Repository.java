package co.com.personal.fitness.tracker.model.service.repository;

import java.util.List;

public interface Repository<T> {
    T save(T entity);
    T findById(String id);
    List<T> findAll();
}
