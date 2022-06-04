package view;

import java.util.Scanner;

public class AccountMenu {
    private Scanner scanner = new Scanner(System.in);
    public void accountMenuStudent() {
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
                    this.accountMenuStudent();
            }

        } catch (Exception e) {
            scanner.nextLine();
            this.accountMenuStudent();
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
