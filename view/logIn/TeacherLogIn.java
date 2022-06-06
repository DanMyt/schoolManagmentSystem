package view.logIn;

import model.Teacher;
import service.TeacherAccountService;
import view.Input;
import view.accountMenu.TeacherAccountMenu;

public class TeacherLogIn {

    /**
     * Singleton pattern.
     * Ensures that only one objects of LogIn exists.
     */
    private static final TeacherLogIn TEACHER_LOG_IN = new TeacherLogIn();
    public static TeacherLogIn getInstance() {
        return TEACHER_LOG_IN;
    }
    private TeacherLogIn() {}
    private final TeacherAccountService teacherAccountService = TeacherAccountService.getInstance();
    private final TeacherAccountMenu teacherAccountMenu = TeacherAccountMenu.getInstance();
    private final Input input = new Input();
    private Teacher activeTeacher;

    /**
     * Function to log in teacher.
     * username - first name of the teacher.
     * password - teacher sets the password.
     * Function checks if account with this username
     * and password exists and then teacher is logged in.
     */
    public void logInTeacher() {
        System.out.println("***LOG IN***");

        final String username = this.input.enterChar("First name");
        final String password = this.input.enterChar("password");

        this.activeTeacher = this.teacherAccountService.findTeacherByUsernamePassword(username,password);
        if(activeTeacher != null) this.teacherAccountMenu.accountMenuTeacher(activeTeacher);
        else {
            System.out.println("Account with this username or password does not exist.");
        }
    }
}
