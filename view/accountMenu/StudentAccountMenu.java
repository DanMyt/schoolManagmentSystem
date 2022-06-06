package view.accountMenu;

import java.util.Objects;
import java.util.Scanner;

import model.Student;
import view.Input;

public class StudentAccountMenu {

    /**
     * Singleton pattern.
     * Ensures that only one objects of Account menu exists.
     */
    private static final StudentAccountMenu STUDENT_ACCOUNT_MENU = new StudentAccountMenu();
    public static StudentAccountMenu getInstance() {
        return STUDENT_ACCOUNT_MENU;
    }
    private StudentAccountMenu() {}
    private final Scanner scanner = new Scanner(System.in);
    private final Input input = new Input();

    /**
     * Menu of the Student's account .
     * @param student - student account
     */
    public void accountMenuStudent(Student student) {
        System.out.println("*********************************\n" +
                "Enter your choice: \n" +
                "A| Show fees total\n" +
                "B| Show paid fees\n" +
                "C| Show remaining fees\n" +
                "D| Pay fees\n" +
                "E| Exit\n"
        );

        char choice;
        try {

            choice = scanner.next().charAt(0);

            switch (choice) {
                case 'A':
                    //show total fees which student must pay in one school year
                    System.out.println(student.getFeesTotal());
                    this.accountMenuStudent(student);
                    break;
                case 'B':
                    //show fees that are already paid
                    System.out.println(student.getFeesPaid());
                    this.accountMenuStudent(student);
                    break;

                case 'C':
                    //show remaining fees
                    System.out.println(student.getRemainingFees());
                    this.accountMenuStudent(student);
                    break;

                case 'D':
                    //pay fees
                    int value = this.input.enterInt("Enter the value to pay");
                    student.payFees(value);
                    this.accountMenuStudent(student);
                    break;

                case 'E':
                    //log out
                    System.out.println("You are logged out!");
                    break;

                default:
                    this.accountMenuStudent(student);
            }

        } catch (Exception e) {
            scanner.nextLine();
            this.accountMenuStudent(student);
        }
    }
}
