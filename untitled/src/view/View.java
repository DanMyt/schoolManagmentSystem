package view;

import model.Student;
import model.Teacher;

import java.util.Scanner;


public class View {

    private final Scanner scanner = new Scanner(System.in);
    private final Register registerAccount = new Register();
    private final LogIn logInAccount = new LogIn();

    public void run() {
        while (true) {
            this.loginScreen();
        }
    }

    public void loginScreen() {
        System.out.println("*********************************\n" +
                "Enter your choice\n" +
                "A| Student\n" +
                "B| Teacher\n"
        );

        char choice;
        try {
            choice = scanner.next().charAt(0);
            if(choice == 'A') this.registerOrLogIn(choice);
            else if(choice == 'B') this.registerOrLogIn(choice);
            else {
                System.out.println("Non valid input");
                this.loginScreen();
            }

        } catch (Exception e) {
            System.out.println("Please enter only valid options");
            scanner.nextLine();
            this.loginScreen();
        }
    }

   public void registerOrLogIn(char teacherOrStudent) {
       this.scanner.nextLine();
        System.out.println("*********************************\n" +
                "Enter your choice\n" +
                "A| Log in\n" +
                "B| Register\n"
        );

        char choice;
        try {
            choice = scanner.next().charAt(0);
            if (choice == 'A' && teacherOrStudent == 'A') this.logInAccount.logInStudent();
            else if(choice == 'A' && teacherOrStudent == 'B') this.logInAccount.logInTeacher();
            else if (choice == 'B' && teacherOrStudent == 'A') this.registerAccount.registerStudent();
            else if (choice == 'B' && teacherOrStudent == 'B') this.registerAccount.registerTeacher();
            else {
                System.out.println("Non valid input");
                this.registerOrLogIn(teacherOrStudent);
            }
        } catch (Exception e) {
            System.out.println("Please enter only valid options");
            scanner.nextLine();
            this.registerOrLogIn(teacherOrStudent);
        }

    }


}
