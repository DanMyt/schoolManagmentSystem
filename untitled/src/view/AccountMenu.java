package view;

import java.util.Scanner;
import model.Student;
import repository.AccountRepository;

public class AccountMenu {

    /**
     * Singleton pattern
     * Ensures that only one objects of Account service exists
     */
    private static final AccountMenu accountMenu = new AccountMenu();
    public static AccountMenu getInstance() {
        return accountMenu;
    }
    private AccountMenu() {}
    private Scanner scanner = new Scanner(System.in);
    private Input input = new Input();
    public void accountMenuStudent(Student student) {
        System.out.println("*********************************\n" +
                "Enter your choice\n" +
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
                    System.out.println(student.getFeesTotal());
                    this.accountMenuStudent(student);
                    break;
                case 'B':
                    System.out.println(student.getFeesPaid());
                    this.accountMenuStudent(student);
                    break;

                case 'C':
                    System.out.println(student.getRemainingFees());
                    this.accountMenuStudent(student);
                    break;

                case 'D':
                    int value = this.input.enterInt("Enter the value to pay");
                    student.payFees(value);
                    this.accountMenuStudent(student);
                    break;

                case 'E':
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

    public void accountMenuTeacher() {
        System.out.println("*********************************\n" +
                "Enter your choice\n" +
                "A| Show my month salary\n" +
                "B| Show my salary earned\n" +
                "C| Change password\n" +
                "D| Show information about my account\n" +
                "E| Exit\n"
        );

        char choice;
        try {

            choice = scanner.next().charAt(0);

            switch (choice) {
                case 'A':
                    //getFeesTotal();
                    break;
                case 'B':
                    break;

                case 'C':
                    break;

                case 'D':
                    break;

                case 'E':
                    System.out.println("You are logged out!");
                    break;

                default:
                    this.accountMenuTeacher();
            }

        } catch (Exception e) {
            scanner.nextLine();
            this.accountMenuTeacher();
        }
    }
}
