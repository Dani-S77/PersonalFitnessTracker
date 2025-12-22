package co.com.personal.fitness.tracker.repository;

import java.util.List;

public interface IRepository<T> {
    T save(T entity);
    T findById(String id);
    List<T> findAll();
}
