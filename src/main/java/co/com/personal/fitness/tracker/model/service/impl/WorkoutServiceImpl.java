package co.com.personal.fitness.tracker.model.service.impl;

import co.com.personal.fitness.tracker.model.entity.*;
import co.com.personal.fitness.tracker.model.service.interfaces.WorkoutService;
import co.com.personal.fitness.tracker.model.service.repository.WorkoutRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class WorkoutServiceImpl implements WorkoutService {
    private WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository){
        this.workoutRepository=workoutRepository;
    }

    @Override
    public WorkoutLog logWorkout(RegularUser user, String workoutId, Map<String, Integer> exerciseTimes) throws Exception{
        Workout workout=workoutRepository.findById(workoutId);
        if(workout==null){
            throw new Exception("Workout not Found");
        }
        int totalTime=0;
        String logId= String.valueOf(System.currentTimeMillis());
        WorkoutLog workoutLog=new WorkoutLog(logId, workout, LocalDate.now(), 0);

        for(WorkoutExercise we: workout.getExercises()){
            Integer time = exerciseTimes.getOrDefault(we.getExercise().getId(), 0);
            totalTime+=time;
            workoutLog.addExerciseLog(new ExerciseLog(we.getExercise(), time));
        }

        workoutLog=new WorkoutLog(logId, workout, LocalDate.now(), totalTime);
        for(WorkoutExercise we: workout.getExercises()){
            Integer time=exerciseTimes.getOrDefault(we.getExercise().getId(), 0);
            workoutLog.addExerciseLog(new ExerciseLog(we.getExercise(), time));
        }
        user.addWorkoutLog(workoutLog);
        return workoutLog;
    }

    @Override
    public List<WorkoutLog> getHistory(RegularUser user){
        return user.getHistory();
    }

    @Override
    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }
}
