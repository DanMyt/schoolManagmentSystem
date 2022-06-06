package view;

import model.Student;
import model.Teacher;

import service.StudentAccountService;
import service.TeacherAccountService;
import service.SchoolAccountService;

public class LogIn {

    /**
     * Singleton pattern.
     * Ensures that only one objects of LogIn exists.
     */
    private static final LogIn logIn = new LogIn();

    public static LogIn getInstance() {
        return logIn;
    }
    private LogIn() {}
    private final StudentAccountService studentAccountService = StudentAccountService.getInstance();
    private final TeacherAccountService teacherAccountService = TeacherAccountService.getInstance();
    private final SchoolAccountService schoolAccountService = SchoolAccountService.getInstance();
    private final AccountMenu accountMenu = AccountMenu.getInstance();
    private final Input input = new Input();

    private Student activeStudent;
    private Teacher activeTeacher;
    private boolean activeSchool;


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

        if(activeStudent!= null) this.accountMenu.accountMenuStudent(activeStudent);
        else {
            System.out.println("Account with this username or password does not exist.");
        }
    }


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
        if(activeTeacher != null) this.accountMenu.accountMenuTeacher(activeTeacher);
        else {
            System.out.println("Account with this username or password does not exist.");
        }
    }

    public void logInSchoolAdministration() {
        System.out.println("LOG IN AS A SCHOOL ADMINISTRATION");

        final String username = this.input.enterChar("username");
        final String password = this.input.enterChar("password");

        this.activeSchool = this.schoolAccountService.checkUsernamePassword(username,password);

        if(activeSchool) this.accountMenu.accountMenuSchool();
        else {
            System.out.println("Incorrect username or password.");
        }
    }
}
