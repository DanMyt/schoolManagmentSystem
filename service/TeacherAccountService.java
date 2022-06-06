package service;

import model.Teacher;
import repository.TeacherAccountRepository;

import java.util.List;

/**
 * TEACHER ACCOUNT SERVICE
 */
public class TeacherAccountService {

    /**
     * Singleton pattern.
     * Ensures that only one objects of Account service exists.
     */
    private static final TeacherAccountService teacherService = new TeacherAccountService();
    public static TeacherAccountService getInstance() {
        return teacherService;
    }
    private TeacherAccountService() {}
    private final TeacherAccountRepository teacherAccountRepository = TeacherAccountRepository.getInstance();

    /**
     * When registering If newAccount != null and ID != null and there is no account
     * with same ID, function addTeacher is called.
     * @param newAccount, New account of teacher.
     */
    public void registerTeacher(Teacher newAccount) {
        if (newAccount == null || newAccount.getId() == null) return;
        // can not insert new account with id that already exists
        if (this.teacherAccountRepository.existsByIdTeacher(newAccount.getId())) return;

        this.teacherAccountRepository.addTeacher(newAccount);
    }

    /**
     *
     * @returns copy of list of teachers.
     */
    public List<Teacher> getListOfTeachers() { return this.teacherAccountRepository.getListOfTeachers();}

    /**
     * LOG IN TEACHER CHECK - when teacher log in it checks if account exists.
     * @param username - username of wanted teacher.
     * @param password - password of wanted teacher.
     * @returns teacher account when teacher with this username and password exists or returns null.
     */
    public Teacher findTeacherByUsernamePassword(String username, String password) {
        return this.teacherAccountRepository.findTeacherByUsernamePassword(username, password);
    }

    /**
     * Find exact teacher account, when school is paying salary to teacher.
     * @param name - name of the wanted teacher.
     * @param secondName - second name of the wanted teacher.
     * @return teacher account.
     */
    public Teacher findTeacherByNameSecondName(String name, String secondName) {
        return this.teacherAccountRepository.findTeacherByNameSecondName(name,secondName);
    }

    /**
     *
     * @return last ID of teacher
     */
    public Long getLastId() {
        return this.teacherAccountRepository.getLastId();
    }
}
