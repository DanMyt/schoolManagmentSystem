package view;

import view.logIn.SchoolAdminLogIn;
import view.logIn.StudentLogIn;
import view.logIn.TeacherLogIn;
import view.register.StudentRegister;
import view.register.TeacherRegister;

import java.util.Scanner;

public class View {

    private final Scanner scanner = new Scanner(System.in);
    private final StudentRegister studentRegisterAccount = StudentRegister.getInstance();
    private final TeacherRegister teacherRegisterAccount = TeacherRegister.getInstance();
    private final StudentLogIn studentLogInAccount = StudentLogIn.getInstance();
    private final SchoolAdminLogIn schoolLogInAccount = SchoolAdminLogIn.getInstance();
    private final TeacherLogIn teacherLogInAccount = TeacherLogIn.getInstance();

    public void run() {
        while (true) {
            this.loginScreen();
        }
    }

    /**
     * Initial screen where the user chooses whether he is a
     * student(choice A) or a teacher(choice B).
     * The user's choice is a parameter to registerOrLogIn
     * function.
     */
    public void loginScreen() {
        System.out.println("*********************************\n" +
                "Enter your choice: \n" +
                "A| Student\n" +
                "B| Teacher\n" +
                "C| School administration\n"
        );

        char choice;
        try {
            choice = scanner.next().charAt(0);
            if(choice == 'A') this.registerOrLogIn(choice);
            else if (choice == 'C') {this.schoolLogInAccount.logInSchoolAdministration();}
            else if(choice == 'B') this.registerOrLogIn(choice);
            else {
                System.out.println("Non valid input.");
                this.loginScreen();
            }

        } catch (Exception e) {
            System.out.println("Please enter only valid options.");
            scanner.nextLine();
            this.loginScreen();
        }
    }

    /**
     * Void function where user can choose between registration and login.
     * @param teacherOrStudent login or register as a teacher or as a student.
     */
   public void registerOrLogIn(char teacherOrStudent) {
       this.scanner.nextLine();
        System.out.println("*********************************\n" +
                "Enter your choice: \n" +
                "A| Log in\n" +
                "B| Register\n"
        );

        char choice;
        try {
            choice = scanner.next().charAt(0);
            if (choice == 'A' && teacherOrStudent == 'A') this.studentLogInAccount.logInStudent();
            else if(choice == 'A' && teacherOrStudent == 'B') this.teacherLogInAccount.logInTeacher();
            else if (choice == 'B' && teacherOrStudent == 'A') this.studentRegisterAccount.registerStudent();
            else if (choice == 'B' && teacherOrStudent == 'B') this.teacherRegisterAccount.registerTeacher();
            else {
                System.out.println("Non valid input.");
                this.registerOrLogIn(teacherOrStudent);
            }
        } catch (Exception e) {
            System.out.println("Please enter only valid options.");
            scanner.nextLine();
            this.registerOrLogIn(teacherOrStudent);
        }
    }
}
