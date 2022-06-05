package repository;

import model.Student;
import model.Teacher;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountRepository {

    //Username for school administration account.
    private final String SchoolUsername = "school";

    //Password for school administration account.
    private final String SchoolPassword = "admin";

    /**
     * Singleton pattern.
     * Ensures that only one objects of Account repository exists.
     */
    private static final AccountRepository repository = new AccountRepository();

    public static AccountRepository getInstance() {
        return repository;
    }
    private AccountRepository() {}

    /**
     * List of students of school
     */
    private final List<Student> studentsAccounts = new ArrayList<>();

    /**
     * List of the teachers
     */
    private final List<Teacher> teachersAccounts = new ArrayList<>();

    /**
     * Adds a new account to the list of students accounts.
     * Student's account is successfully registered.
     * @param newAccount account of the new student
     */
    public void addStudent(Student newAccount) { this.studentsAccounts.add(newAccount);}

    /**
     * Adds a new account to the list of teachers accounts.
     * Teacher's account is successfully registered.
     * @param newAccount account of the new teacher
     */
    public void addTeacher(Teacher newAccount) { this.teachersAccounts.add(newAccount);}

    public boolean existsByIdStudent(Long id) {
        return this.studentsAccounts.stream().anyMatch(a -> Objects.equals(a.getId(), id));
    }

    public boolean existsByIdTeacher(Long id) {
        return this.teachersAccounts.stream().anyMatch(a -> Objects.equals(a.getId(), id));
    }

    /**
     * LOG IN STUDENT
     * Function iterate trough list of school students and return account when
     * finds required account.
     * Else it returns null.
     * @param username - username entered from user.
     * @param password - password entered from user.
     * @return account or null.
     */
    public Student findStudentByUsernamePassword(String username, String password) {
        for(Student account : this.studentsAccounts) {
            if(Objects.equals(username, account.getName()) &&  Objects.equals(password, account.getPassword())) {
                return account;

            }
        }
        return null;
    }

    /**
     * LOG IN TEACHER
     * Function iterate trough list of school teachers and return account when
     * finds required account.
     * Else it returns null.
     * @param username - username entered from user.
     * @param password - password entered from user.
     * @return account or null.
     */
    public Teacher findTeacherByUsernamePassword(String username, String password) {
        for(Teacher account : this.teachersAccounts) {
            if(Objects.equals(username, account.getName()) &&  Objects.equals(password, account.getPassword())) {
                return account;
            }
        }
        return null;
    }


    /**
     * SCHOOL ADMINISTRATION LOG IN
     * function checks if user entered valid username and password.
     * @param username entered username from user.
     * Correct username is same as global variable SchoolUsername.
     * @param password entered password from user.
     * Correct password is same as global variable SchoolPassword.
     * @return true if username and password are correct.
     */
    public boolean checkUsernamePassword(String username, String password) {
        return Objects.equals(username, SchoolUsername) && Objects.equals(password, SchoolPassword);
    }
}
