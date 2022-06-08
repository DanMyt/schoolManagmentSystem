package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

/**
 * SCHOOL ADMINISTRATION ACCOUNT REPOSITORY
 */
public class SchoolAccountRepository {

    private Connection connection;

    /**
     * Singleton pattern.
     * Ensures that only one objects of School account repository exists.
     */
    private static final SchoolAccountRepository schoolRepository = new SchoolAccountRepository();

    public static SchoolAccountRepository getInstance() {
        return schoolRepository;
    }
    private SchoolAccountRepository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    //Correct username for school administration account.
    private final String schoolUsername = "school";

    //Correct password for school administration account.
    private final String schoolPassword = "admin";

    /**
     * SCHOOL ADMINISTRATION LOG IN CHECK
     * function checks if user entered valid username and password.
     * @param username entered username from user.
     * Correct username is same as global variable SchoolUsername.
     * @param password entered password from user.
     * Correct password is same as global variable SchoolPassword.
     * @return true if username and password are correct.
     */
    public boolean checkUsernamePassword(String username, String password) {
        return Objects.equals(username, schoolUsername) && Objects.equals(password, schoolPassword);
    }
}
