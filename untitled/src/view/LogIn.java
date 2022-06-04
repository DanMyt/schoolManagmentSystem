package view;

import model.Student;
import model.Teacher;
import service.AccountService;

import java.util.Scanner;

public class LogIn {

    private final Scanner scanner = new Scanner(System.in);
    private final AccountService accountService = AccountService.getInstance();
    private final AccountMenu accountMenu = new AccountMenu();
    private final Input input = new Input();

    private Student activeStudent;
    private Teacher activeTeacher;


    /**
     * Function to log in student.
     * username - first name of the student.
     * password - student sets the password.
     * Function checks if account with this username
     * and password exists and then student is logged in.
     */

    public void logInStudent() {
        System.out.println("***LOG IN***");

        final String username = this.input.enterChar("First name");
        final String password = this.input.enterChar("password");

        this.activeStudent = this.accountService.findStudentByUsernamePassword(username,password);

        if(activeStudent!= null) this.accountMenu.accountMenuStudent(activeStudent);


    }


    /**
     * Function to log in teacher
     */

    public void logInTeacher() {
        System.out.println("***LOG IN***");

    }
}
