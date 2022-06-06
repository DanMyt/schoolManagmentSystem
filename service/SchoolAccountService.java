package service;

import repository.SchoolAccountRepository;

/**
 * SCHOOL ADMINISTRATION ACCOUNT SERVICE
 */
public class SchoolAccountService {

    /**
     * Singleton pattern.
     * Ensures that only one objects of Account service exists.
     */
    private static final SchoolAccountService schoolService = new SchoolAccountService();
    public static SchoolAccountService getInstance() {
        return schoolService;
    }
    private SchoolAccountService() {}
    private final SchoolAccountRepository schoolAccountRepository = SchoolAccountRepository.getInstance();

    /**
     * SCHOOL ADMINISTRATION ACCOUNT LOG IN CHECK
     * @param username - username entered from user.
     * @param password - username entered from user.
     * @returns true if username and password from user are correct.
     */
    public boolean checkUsernamePassword(String username, String password) {
        return this.schoolAccountRepository.checkUsernamePassword(username,password);
    }
}
