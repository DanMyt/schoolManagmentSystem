package view;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);
    public String enterChar(String requiredField) {
        System.out.println(
                "************************************\n"
                        + "|Enter your " + requiredField + ": \n"
        );
        return scanner.nextLine();
    }

    public int enterInt(String requiredField) {
        System.out.println(
                "************************************\n"
                        + "|Enter your " + requiredField + ": \n"
        );
        return scanner.nextInt();
    }
}
