package view.accountMenu;

import model.Teacher;
import view.Input;

import java.util.Scanner;

public class TeacherAccountMenu {
    private static final TeacherAccountMenu TEACHER_ACCOUNT_MENU = new TeacherAccountMenu();
    public static TeacherAccountMenu getInstance() {
        return TEACHER_ACCOUNT_MENU;
    }
    private TeacherAccountMenu() {}
    private final Scanner scanner = new Scanner(System.in);
    private final Input input = new Input();


    /**
     * Menu of the teachers account.
     * @param teacher - teacher account
     */
    public void accountMenuTeacher(Teacher teacher) {
        System.out.println("*********************************\n" +
                "Enter your choice: \n" +
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
                    //show month salary of the teacher
                    System.out.println(teacher.getSalary());
                    this.accountMenuTeacher(teacher);
                    break;
                case 'B':
                    //show salary earned for the whole working period
                    System.out.println(teacher.getSalaryEarned());
                    this.accountMenuTeacher(teacher);
                    break;

                case 'C':
                    //change password
                    String password = this.input.enterChar("Enter the new password");
                    teacher.setPassword(password);
                    this.accountMenuTeacher(teacher);
                    break;

                case 'D':
                    //show information about teacher
                    System.out.println("Your ID: " +teacher.getId());
                    System.out.println("Your name: " +teacher.getName());
                    System.out.println("Your second name: " +teacher.getSecondName());
                    System.out.println("Your password: " +teacher.getPassword());
                    System.out.println("Your month salary: " +teacher.getSalary());
                    System.out.println("Your salary earned: " +teacher.getSalaryEarned());
                    this.accountMenuTeacher(teacher);
                    break;

                case 'E':
                    //log out
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
