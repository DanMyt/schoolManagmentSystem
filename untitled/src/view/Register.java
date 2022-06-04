package view;

import model.Student;
import model.Teacher;
import service.AccountService;

import java.util.Scanner;

public class Register {

    private Scanner scanner = new Scanner(System.in);
    private final Input input = new Input();
    private final AccountService accountService = AccountService.getInstance();
    private final LogIn logIn = new LogIn();



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
        newAccount.setSalary(this.input.enterInt("Enter you salary"));
        newAccount.setSalaryEarned(this.input.enterInt("Enter salary earned"));
    }
}
