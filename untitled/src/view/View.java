package view;

import model.Student;
import model.Teacher;

import java.util.Scanner;


public class View {

    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            this.loginScreen();
        }
    }

    public void loginScreen() {
        System.out.println("*********************************\n" +
                "Enter your choice\n" +
                "A| Student\n" +
                "B| Teacher\n" +
                "*********************************\n"
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
        System.out.println("*********************************\n" +
                "Enter your choice\n" +
                "A| Log in\n" +
                "B| Register\n" +
                "*********************************\n");

        char choice;
        try {
            choice = scanner.next().charAt(0);
            if (choice == 'A' && teacherOrStudent == 'A') logInStudent();
            else if(choice == 'A' && teacherOrStudent == 'B') logInTeacher();
            else if (choice == 'B' && teacherOrStudent == 'A') registerStudent();
            else if (choice == 'B' && teacherOrStudent == 'B') registerTeacher();
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

    public void  logInStudent() {

    }

    public void logInTeacher() {

    }


    public void registerStudent() {

        Student newAccount = new Student();

        this.scanner.nextLine();

        newAccount.setName(this.enterChar("First Name"));
        newAccount.setId(1);
        newAccount.setSecondName(this.enterChar("Second Name"));
        newAccount.setFeesPaid(0);
        newAccount.setFeesTotal(30000);
    }

    public void registerTeacher() {
        Teacher newAccount = new Teacher();

        this.scanner.nextLine();

        newAccount.setName(this.enterChar("First Name"));
        newAccount.setId(1);
        newAccount.setSecondName(this.enterChar("Second Name"));
        newAccount.setSalary(this.enterInt("Enter you salary"));
        newAccount.setSalaryEarned(this.enterInt("Enter salary earned"));
    }

    private String enterChar(String requiredField) {
        System.out.println(
                "************************************\n"
                        + "|Enter your " + requiredField + ": \n"
        );
        return scanner.nextLine();
    }

    private int enterInt(String requiredField) {
        System.out.println(
                "************************************\n"
                        + "|Enter your " + requiredField + ": \n"
        );
        return scanner.nextInt();
    }
}
