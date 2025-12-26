package co.com.personal.fitness.tracker.model.service.interfaces;

import co.com.personal.fitness.tracker.model.entity.RegularUser;
import co.com.personal.fitness.tracker.model.entity.Workout;
import co.com.personal.fitness.tracker.model.entity.WorkoutLog;

import java.util.List;
import java.util.Map;

public interface WorkoutService {
    WorkoutLog logWorkout(RegularUser user, String workoutId, Map<String,Integer> exerciseTimes) throws Exception;
    List<WorkoutLog> getHistory(RegularUser user);
    List<Workout> getAllWorkouts();
}
