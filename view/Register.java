package view;

import model.School;
import model.Student;
import model.Teacher;
import service.AccountService;

public class Register {

    /**
     * Singleton pattern.
     * Ensures that only one objects of Account service exists.
     */
    private static final Register register = new Register();

    public static Register getInstance() {
        return register;
    }
    private Register() {}
    private final Input input = new Input();
    private final AccountService accountService = AccountService.getInstance();
    private final LogIn logIn = LogIn.getInstance();
    private final School school = School.getInstance();


    public void registerStudent() {

        //new Student model
        Student newAccount = new Student();

        System.out.println("***REGISTRATION***");

        newAccount.setName(this.input.enterChar("First Name"));
        newAccount.setId(10L);
        newAccount.setSecondName(this.input.enterChar("Second Name"));
        newAccount.setPassword(this.input.enterChar("password"));
        newAccount.setFeesPaid(0);
        newAccount.setFeesTotal(30000);

        this.accountService.registerStudent(newAccount);



        this.logIn.logInStudent();


    }

    public void registerTeacher() {

        //new Teacher model
        Teacher newAccount = new Teacher();

        System.out.println("***REGISTRATION***");

        newAccount.setName(this.input.enterChar("First Name"));
        newAccount.setId(1L);
        newAccount.setSecondName(this.input.enterChar("Second Name"));
        newAccount.setPassword(this.input.enterChar("password"));
        newAccount.setSalary(this.input.enterInt("salary"));
        newAccount.setSalaryEarned(this.input.enterInt("salary earned"));

        this.accountService.registerTeacher(newAccount);



        this.logIn.logInTeacher();
    }
}
