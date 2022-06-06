package view;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Function is called when user must enter an info about himself.
     * Function is called when user must enter a String.
     * @param requiredField - information about what information is user
     * required to enter (for e. "Enter your password").
     * @return users input.
     */
    public String enterChar(String requiredField) {
        System.out.println(
                "************************************\n"
                        + "|Enter your " + requiredField + ": \n"
        );
        return scanner.nextLine();
    }

    /**
     * Function is called when user must enter an info about himself.
     * Function is called when user must enter an Int.
     * @param requiredField - information about what information is user
     * required to enter (for e. "Enter your month salary").
     * @return users input.
     */
    public int enterInt(String requiredField) {
        System.out.println(
                "************************************\n"
                        + "|Enter your " + requiredField + ": \n"
        );
        return scanner.nextInt();
    }

    /**
     * Function is called when user must enter an info about other user.
     * Function is called when user must enter a String.
     * @param requiredField - information about what information is user
     * required to enter (for e. "Enter users name").
     * @return users input.
     */
    public String enterCharUser(String requiredField) {
        System.out.println(
                "************************************\n"
                        + "|Enter users " + requiredField + ": \n"
        );
        return scanner.nextLine();
    }

    /**
     * Function is called when user must enter an info about other user.
     * Function is called when user must enter an Int.
     * @param requiredField - information about what information is user
     * required to enter (for e. "Enter users salary").
     * @return users input.
     */
    public int enterIntUser(String requiredField) {
        System.out.println(
                "************************************\n"
                        + "|Enter users " + requiredField + ": \n"
        );
        return scanner.nextInt();
    }
}
