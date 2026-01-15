 package co.com.personal.fitness.tracker;


 import co.com.personal.fitness.tracker.config.DependencyContainer;
 import co.com.personal.fitness.tracker.model.entity.AdminUser;
 import co.com.personal.fitness.tracker.model.entity.SuperAdminUser;
 import co.com.personal.fitness.tracker.model.entity.User;
 import co.com.personal.fitness.tracker.view.AdminView;
 import co.com.personal.fitness.tracker.view.AuthView;
 import co.com.personal.fitness.tracker.view.SuperAdminView;

 import java.util.Scanner;

 public class Main {
     private AuthView authView;
     private SuperAdminView superAdminView;
     private AdminView adminView;
     private Scanner scanner;

     private User currentUser;
     private boolean running;

     public Main(DependencyContainer container ){
          this.scanner=container.getScanner();
          this.authView=container.getAuthView();
          this.adminView=container.getAdminView();
          this.superAdminView=container.getSuperAdminView();

          this.running=true;
     }


     public void startApp() {
          System.out.println("WELCOME TO FITNESS TRACKER");
         System.out.println("=".repeat(80));

         do{
             displayMainMenu();
         }while(running);
         scanner.close();
     }

     private void displayMainMenu(){
         System.out.println("\n1. Login");
         System.out.println("2. Register");
         System.out.println("3. Exit");
         System.out.println("\nEnter your choice: ");

         String choice= scanner.nextLine();

         switch(choice){
             case "1" -> {
                 System.out.println("\n" + "=".repeat(80));
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
                 running=false;
             }
             default -> System.out.println("\n Invalid option. Please try again");
         }
     }

     private void routerUser(){
         if(currentUser instanceof SuperAdminUser superAdmin){
             superAdminView.displaySuperAdminDashboard(superAdmin);
         }else if(currentUser instanceof AdminUser admin){
             adminView.displayAdminDashboard();
         }
     }




    public static void main(String[] args) {
         DependencyContainer container =new DependencyContainer();
         Main app=new Main(container);
         app.startApp();
     }
}