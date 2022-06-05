package service;

import model.Student;

import model.Teacher;
import repository.AccountRepository;

public class AccountService {

    /**
     * Singleton pattern.
     * Ensures that only one objects of Account service exists.
     */
    private static final AccountService service = new AccountService();
    public static AccountService getInstance() {
        return service;
    }
    private AccountService() {}
    private final AccountRepository accountRepository = AccountRepository.getInstance();

    /**
     * When registering If newAccount != null and ID != null and there is no account
     * with same ID, function addStudent is called.
     * @param newAccount, New account of student.
     */
    public void registerStudent(Student newAccount) {
        if (newAccount == null || newAccount.getId() == null) return;
        // can not insert new account with id that already exists
        if (this.accountRepository.existsByIdStudent(newAccount.getId())) return;

        this.accountRepository.addStudent(newAccount);
    }

    public void registerTeacher(Teacher newAccount) {
        if (newAccount == null || newAccount.getId() == null) return;
        // can not insert new account with id that already exists
        if (this.accountRepository.existsByIdTeacher(newAccount.getId())) return;

        this.accountRepository.addTeacher(newAccount);
    }

    public Student findStudentByUsernamePassword(String username, String password) {
        return this.accountRepository.findStudentByUsernamePassword(username, password);

    }

    public Teacher findTeacherByUsernamePassword(String username, String password) {
        return this.accountRepository.findTeacherByUsernamePassword(username, password);

    }


}
