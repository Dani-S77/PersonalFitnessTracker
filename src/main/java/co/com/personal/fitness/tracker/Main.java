 package co.com.personal.fitness.tracker;


 import co.com.personal.fitness.tracker.controller.AuthController;
 import co.com.personal.fitness.tracker.model.entity.User;
 import co.com.personal.fitness.tracker.model.service.impl.RegisterServiceImpl;
 import co.com.personal.fitness.tracker.model.service.interfaces.RegisterService;
 import co.com.personal.fitness.tracker.model.service.repository.UserRepository;
 import co.com.personal.fitness.tracker.view.AuthView;

 import java.util.Scanner;

 public class Main {
    public static void main(String[] args) {
     Scanner scanner =new Scanner(System.in);

     UserRepository userRepository=new UserRepository();

     RegisterService registerService =new RegisterServiceImpl(userRepository);

     AuthController authController =new AuthController(null, registerService);

     AuthView authView = new AuthView(authController, scanner);


     System.out.println("\n" + "=".repeat(80));
     System.out.println("WELCOME TO FITNESS TRACKER - REGISTRATION");
     System.out.println("=".repeat(80));

     User newUser = authView.displayRegisterMenu();

     if(newUser != null){
         System.out.println("\n User registered successfully!");
         System.out.println("User ID: " + newUser.getId());
         System.out.println("Name: " + newUser.getFirstName() + " " + newUser.getLastName());
         System.out.println("Email: " + newUser.getEmail());
         System.out.println("Role: " + newUser.getRole());
     }else{
         System.out.println("\n Registration failed.");
     }
     scanner.close();
    }
}