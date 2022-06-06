package view.logIn;

import model.Student;

import service.StudentAccountService;
import view.Input;
import view.accountMenu.StudentAccountMenu;

public class StudentLogIn {

    /**
     * Singleton pattern.
     * Ensures that only one objects of LogIn exists.
     */
    private static final StudentLogIn STUDENT_LOG_IN = new StudentLogIn();
    public static StudentLogIn getInstance() {
        return STUDENT_LOG_IN;
    }
    private StudentLogIn() {}
    private final StudentAccountService studentAccountService = StudentAccountService.getInstance();

    private final StudentAccountMenu studentAccountMenu = StudentAccountMenu.getInstance();

    private final Input input = new Input();
    private Student activeStudent;

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

        this.activeStudent = this.studentAccountService.findStudentByUsernamePassword(username,password);

        if(activeStudent!= null) this.studentAccountMenu.accountMenuStudent(activeStudent);
        else {
            System.out.println("Account with this username or password does not exist.");
        }
    }
}
