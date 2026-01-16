package co.com.personal.fitness.tracker.view;

import co.com.personal.fitness.tracker.controller.UserController;
import co.com.personal.fitness.tracker.model.entity.RegularUser;

import java.util.Scanner;

public class UserView {
    private UserController userController;
    private Scanner scanner;

    public UserView(UserController userController, Scanner scanner) {

        this.userController = userController;
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

    }

    private void displayLogWorkoutMenu(RegularUser user) {

    }

    private void displayHistoryMenu(RegularUser user) {

    }

    private void displayUpdateProfileMenu(RegularUser user) {

    }
}