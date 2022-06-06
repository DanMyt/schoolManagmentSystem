package view.register;

import model.Student;
import service.StudentAccountService;
import view.Input;
import view.logIn.StudentLogIn;

public class StudentRegister {

    /**
     * Singleton pattern.
     * Ensures that only one objects of StudentRegister exists.
     */
    private static final StudentRegister STUDENT_REGISTER = new StudentRegister();

    public static StudentRegister getInstance() {
        return STUDENT_REGISTER;
    }
    private StudentRegister() {}
    private final Input input = new Input();
    private final StudentAccountService studentAccountService = StudentAccountService.getInstance();

    private final StudentLogIn studentLogIn = StudentLogIn.getInstance();

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
        this.studentLogIn.logInStudent();
    }
}
