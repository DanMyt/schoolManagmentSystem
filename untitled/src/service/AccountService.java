package service;

import model.Student;

import model.Teacher;
import repository.AccountRepository;

public class AccountService {

    private final AccountRepository accountRepository = new AccountRepository();

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


}
