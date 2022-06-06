package view;

import model.Student;
import model.Teacher;
import service.StudentAccountService;
import service.TeacherAccountService;

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
    private final StudentAccountService studentAccountService = StudentAccountService.getInstance();
    private final TeacherAccountService teacherAccountService = TeacherAccountService.getInstance();
    private final LogIn logIn = LogIn.getInstance();


    /**
     * Function to register new student account.
     */
    public void registerStudent() {

        //new Student model
        Student newAccount = new Student();

        System.out.println("***REGISTRATION***");

        //when registering student must enter his First name
        newAccount.setName(this.input.enterChar("First Name"));
        //function will find the largest student ID and increase it by 1
        newAccount.setId(this.studentAccountService.getLastId() + 1);
        //when registering student must enter his Second name
        newAccount.setSecondName(this.input.enterChar("Second Name"));
        //when registering student must enter his password
        newAccount.setPassword(this.input.enterChar("password"));
        //when newAccount is set, Fees Paid automatically set to 0
        newAccount.setFeesPaid(0);
        //when newAccount is set, Fees Total for new student is automatically set to 30 000
        newAccount.setFeesTotal(30000);

        //after all required fields are filled, function registerStudent is called
        this.studentAccountService.registerStudent(newAccount);

        //after successfully registration student must log in
        this.logIn.logInStudent();


    }

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
        this.logIn.logInTeacher();
    }
}
