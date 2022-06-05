package view;

import java.util.Scanner;
import model.Student;
import model.Teacher;

public class AccountMenu {

    /**
     * Singleton pattern.
     * Ensures that only one objects of Account service exists.
     */
    private static final AccountMenu accountMenu = new AccountMenu();
    public static AccountMenu getInstance() {
        return accountMenu;
    }
    private AccountMenu() {}
    private final Scanner scanner = new Scanner(System.in);
    private final Input input = new Input();
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

    public void accountMenuTeacher(Teacher teacher) {
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
                    System.out.println(teacher.getSalary());
                    this.accountMenuTeacher(teacher);
                    break;
                case 'B':
                    System.out.println(teacher.getSalaryEarned());
                    this.accountMenuTeacher(teacher);
                    break;

                case 'C':
                    String password = this.input.enterChar("Enter the new password");
                    teacher.setPassword(password);
                    this.accountMenuTeacher(teacher);
                    break;

                case 'D':
                    System.out.println("Your ID: " +teacher.getId());
                    System.out.println("Your name: " +teacher.getName());
                    System.out.println("Your second name: " +teacher.getSecondName());
                    System.out.println("Your password: " +teacher.getPassword());
                    System.out.println("Your month salary: " +teacher.getSalary());
                    System.out.println("Your salary earned: " +teacher.getSalaryEarned());
                    this.accountMenuTeacher(teacher);
                    break;

                case 'E':
                    System.out.println("You are logged out!");
                    break;

                default:
                    this.accountMenuTeacher(teacher);
            }

        } catch (Exception e) {
            scanner.nextLine();
            this.accountMenuTeacher(teacher);
        }
    }
}
