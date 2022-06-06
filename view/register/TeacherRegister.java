package view.register;

import model.Teacher;
import service.TeacherAccountService;
import view.Input;
import view.logIn.TeacherLogIn;

public class TeacherRegister {

    /**
     * Singleton pattern.
     * Ensures that only one objects of TeacherRegister exists.
     */
    private static final TeacherRegister TEACHER_REGISTER = new TeacherRegister();
    public static TeacherRegister getInstance() {
        return TEACHER_REGISTER;
    }
    private TeacherRegister() {}
    private final Input input = new Input();
    private final TeacherLogIn teacherLogIn = TeacherLogIn.getInstance();
    private final TeacherAccountService teacherAccountService = TeacherAccountService.getInstance();

    /**
     * Function to register new teacher account.
     */
    public void registerTeacher() {

        //new Teacher model
        Teacher newAccount = new Teacher();

        System.out.println("***REGISTRATION***");

        //when registering teacher must enter his First name
        newAccount.setName(this.input.enterChar("First Name"));
        //function will find the largest teacher ID and increase it by 1
        newAccount.setId(this.teacherAccountService.getLastId() + 1);
        //when registering teacher must enter his Second name
        newAccount.setSecondName(this.input.enterChar("Second Name"));
        //when registering teacher must enter his password
        newAccount.setPassword(this.input.enterChar("password"));
        //when registering teacher must enter his month salary
        newAccount.setSalary(this.input.enterInt("salary"));
        //when registering teacher must enter his salary earned for whole working period
        newAccount.setSalaryEarned(this.input.enterInt("salary earned"));

        ///after all required fields are filled, function registerTeacher is called
        this.teacherAccountService.registerTeacher(newAccount);

        //after successfully registration teacher must log in
        this.teacherLogIn.logInTeacher();
    }
}
