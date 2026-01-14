 package co.com.personal.fitness.tracker;


 import co.com.personal.fitness.tracker.config.DependencyContainer;
 import co.com.personal.fitness.tracker.model.entity.User;
 import co.com.personal.fitness.tracker.view.AuthView;

 import java.util.Scanner;

 public class Main {
     private AuthView authView;
     private User currentUser;
     private Scanner scanner;

     public Main(DependencyContainer container ){
          this.scanner=container.getScanner();
          this.authView=container.getAuthView();
     }


     public void startApp() {
         System.out.println("\n" + "=".repeat(80));
         System.out.println("WELCOME TO FITNESS TRACKER");
         System.out.println("=".repeat(80));

         while(true){
             if(currentUser ==null){
                 displayMainMenu();
             }
         }
     }

     private void displayMainMenu(){
         System.out.println("\n1. Login");
         System.out.println("2. Register");
         System.out.println("3. Exit");
         System.out.println("\nEnter your choice: ");

         String choice= scanner.nextLine();

         switch(choice){
             case "1" -> {
                 currentUser=authView.displayLoginMenu();
                 if(currentUser != null){
                     routerUser();
                 }
             }
             case "2" -> {
                 currentUser=authView.displayRegisterMenu();
                 if(currentUser != null){
                     routerUser();
                 }
             }
             case "3" -> {
                 System.out.println("\nThank you for using Fitness Tracker. Goodbye!");
                 scanner.close();
                 System.exit(0);
             }
             default -> System.out.println("\n Invalid option. Please try again");
         }
     }

     private void routerUser(){

     }




    public static void main(String[] args) {
         DependencyContainer container =new DependencyContainer();
         Main app=new Main(container);
         app.startApp();
     }
}