package repository;

import model.Student;
import model.Teacher;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountRepository {

    // Singleton pattern
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
     * Adds a new account to the list of students accounts
     * @param newAccount account of the new student
     */
    public void addStudent(Student newAccount) { this.studentsAccounts.add(newAccount);}

    /**
     * Adds a new account to the list of teachers accounts
     * @param newAccount account of the new teacher
     */
    public void addTeacher(Teacher newAccount) { this.teachersAccounts.add(newAccount);}

    public boolean existsByIdStudent(Long id) {
        return this.studentsAccounts.stream().anyMatch(a -> Objects.equals(a.getId(), id));
    }

    public boolean existsByIdTeacher(Long id) {
        return this.teachersAccounts.stream().anyMatch(a -> Objects.equals(a.getId(), id));
    }

    public Student findStudentByUsernamePassword(String username, String password) {
        for(Student account : this.studentsAccounts) {
            if(Objects.equals(username, account.getName()) &&  Objects.equals(password, account.getPassword())) {
                return account;

            }
        }
        return null;
    }
}