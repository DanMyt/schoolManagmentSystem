package view.logIn;

import service.SchoolAccountService;
import view.Input;
import view.accountMenu.SchoolAccountMenu;

public class SchoolAdminLogIn {

    /**
     * Singleton pattern.
     * Ensures that only one objects of LogIn exists.
     */
    private static final SchoolAdminLogIn SCHOOL_LOG_IN = new SchoolAdminLogIn();
    public static SchoolAdminLogIn getInstance() {
        return SCHOOL_LOG_IN;
    }
    private SchoolAdminLogIn() {}
    private final SchoolAccountService schoolAccountService = SchoolAccountService.getInstance();
    private final SchoolAccountMenu schoolAccountMenu = SchoolAccountMenu.getInstance();
    private final Input input = new Input();

    /**
     * Function to log in School Administration
     * School Admin. can only be LOG IN, it can not be
     * registered.
     * User must enter correct username and password which are
     * defined in SchoolAccountRepository.
     * If user entered correct Login data, then global variable
     * activeSchool becomes true and is displayed School Menu (function
     * accountMenuSchool).
     */
    public void logInSchoolAdministration() {
        System.out.println("LOG IN AS A SCHOOL ADMINISTRATION");

        final String username = this.input.enterChar("username");
        final String password = this.input.enterChar("password");

        boolean activeSchool = this.schoolAccountService.checkUsernamePassword(username,password);

        if(activeSchool) this.schoolAccountMenu.accountMenuSchool();
        else {
            System.out.println("Incorrect username or password.");
        }
    }
}
