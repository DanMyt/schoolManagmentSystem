package view;

import model.Student;
import model.Teacher;

import java.util.Scanner;

public class Register {
    private Scanner scanner = new Scanner(System.in);
    private final Input input = new Input();
    public void registerStudent() {

        Student newAccount = new Student();

        this.scanner.nextLine();

        newAccount.setName(this.input.enterChar("First Name"));
        newAccount.setId(1);
        newAccount.setSecondName(this.input.enterChar("Second Name"));
        newAccount.setFeesPaid(0);
        newAccount.setFeesTotal(30000);
    }

    public void registerTeacher() {
        Teacher newAccount = new Teacher();

        this.scanner.nextLine();

        newAccount.setName(this.input.enterChar("First Name"));
        newAccount.setId(1);
        newAccount.setSecondName(this.input.enterChar("Second Name"));
        newAccount.setSalary(this.input.enterInt("Enter you salary"));
        newAccount.setSalaryEarned(this.input.enterInt("Enter salary earned"));
    }
}
