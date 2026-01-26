package co.com.personal.fitness.tracker.view;

import co.com.personal.fitness.tracker.controller.UserController;
import co.com.personal.fitness.tracker.controller.WorkoutController;
import co.com.personal.fitness.tracker.model.entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserView {
    private UserController userController;
    private WorkoutController workoutController;
    private Scanner scanner;

    public UserView(UserController userController,WorkoutController workoutController, Scanner scanner) {

        this.userController = userController;
        this.workoutController=workoutController;
        this.scanner = scanner;
    }

    public void displayDashboard(RegularUser user) {
        while (true) {
            String menu = """
                    
                    ================================================================================
                    Welcome to Your Personal Fitness Tracker!
                    ================================================================================
                    
                    Please select an option:
                    
                    1. Show Workouts
                       - View the list of available workouts and see detailed structures to help
                    
                    2. Log Workout
                       - Select a workout you have performed and enter the time taken for each exercise
                    
                    3. View Logged Workouts
                       - Review your workout history, including details and total time for each session
                    
                    4. Update Profile
                       - Modify your personal information
                    
                    5. Logout
                    
                    ================================================================================
                    """;
            System.out.print(menu);
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> displayWorkouts();
                case "2" -> displayLogWorkoutMenu(user);
                case "3" -> displayHistoryMenu(user);
                case "4" -> displayUpdateProfileMenu(user);
                case "5" -> {
                    System.out.println("\nLogging out... Goodbye!");
                    return;
                }
                default -> System.out.println("\n✗ Invalid option. Please try again.");
            }
        }
    }

    private void displayWorkouts() {
        List<Workout> workouts = workoutController.getAvailableWorkouts();
        System.out.println("\n" + "=".repeat(80));
        System.out.println("AVAILABLE WORKOUTS");
        System.out.println("=".repeat(80));

        if (workouts.isEmpty()) {
            System.out.println("\nNo workouts available.");
            return;
        }

        for (int i = 0; i < workouts.size(); i++) {
            Workout w = workouts.get(i);
            System.out.println("\n" + (i + 1) + ". " + w.getName());
            System.out.println("   Description: " + w.getDescription());
            System.out.println("   Exercises:");
            for (WorkoutExercise we : w.getExercises()) {
                System.out.printf("   - %s: %d sets x %d reps%n",
                        we.getExercise().getName(), we.getSets(), we.getRepetitions());
            }
        }
        System.out.println("\n" + "=".repeat(80));
    }

    private void displayLogWorkoutMenu(RegularUser user) {
        List<Workout> workouts = workoutController.getAvailableWorkouts();

        if (workouts.isEmpty()) {
            System.out.println("\n✗ No workouts available to log.");
            return;
        }

        System.out.println("\n" + "=".repeat(80));
        System.out.println("LOG A WORKOUT");
        System.out.println("=".repeat(80));

        for (int i = 0; i < workouts.size(); i++) {
            System.out.println((i + 1) + ". " + workouts.get(i).getName());
        }

        System.out.print("\nSelect workout number (or 0 to cancel): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) return;
            if (choice < 1 || choice > workouts.size()) {
                System.out.println("\n✗ Invalid workout selection.");
                return;
            }

            Workout selectedWorkout = workouts.get(choice - 1);
            Map<String, Integer> exerciseTimes = new HashMap<>();

            System.out.println("\nEnter time taken (in seconds) for each exercise:");
            for (WorkoutExercise we : selectedWorkout.getExercises()) {
                System.out.printf("%s (%d sets x %d reps): ",
                        we.getExercise().getName(), we.getSets(), we.getRepetitions());
                int time = Integer.parseInt(scanner.nextLine());
                exerciseTimes.put(we.getExercise().getId(), time);
            }

            WorkoutLog log = workoutController.handleLogWorkout(user, selectedWorkout.getId(), exerciseTimes);
            System.out.println("\n✓ Workout logged successfully!");
            System.out.printf("Total time: %d seconds (%.1f minutes)%n",
                    log.getTotalTime(), log.getTotalTime() / 60.0);

        } catch (Exception e) {
            System.out.println("\n✗ Error logging workout: " + e.getMessage());
        }


    }

    private void displayHistoryMenu(RegularUser user) {
        List<WorkoutLog> history = workoutController.getUserHistory(user);

        System.out.println("\n" + "=".repeat(80));
        System.out.println("YOUR WORKOUT HISTORY");
        System.out.println("=".repeat(80));

        if (history.isEmpty()) {
            System.out.println("\nNo workouts logged yet. Start your fitness journey!");
            return;
        }

        for (int i = 0; i < history.size(); i++) {
            WorkoutLog log = history.get(i);
            System.out.printf("%n%d. %s - %s%n", i + 1, log.getWorkout().getName(), log.getDate());
            System.out.printf("   Total Time: %d seconds (%.1f minutes)%n",
                    log.getTotalTime(), log.getTotalTime() / 60.0);
            System.out.println("   Exercise Details:");
            for (ExerciseLog el : log.getExerciseLogs()) {
                System.out.printf("   - %s: %d seconds%n",
                        el.getExercise().getName(), el.getTimetaken());
            }
        }
        System.out.println("\n" + "=".repeat(80));
    }

    private void displayUpdateProfileMenu(RegularUser user) {

    }
}