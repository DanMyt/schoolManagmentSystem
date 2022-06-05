package service;

import model.Student;
import model.Teacher;

import repository.StudentAccountRepository;
import repository.SchoolAccountRepository;
import repository.TeacherAccountRepository;

import java.util.List;

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
    private final StudentAccountRepository studentAccountRepository = StudentAccountRepository.getInstance();

    private final SchoolAccountRepository schoolAccountRepository = SchoolAccountRepository.getInstance();
    private final TeacherAccountRepository teacherAccountRepository = TeacherAccountRepository.getInstance();

    /**
     * When registering If newAccount != null and ID != null and there is no account
     * with same ID, function addStudent is called.
     * @param newAccount, New account of student.
     */
    public void registerStudent(Student newAccount) {
        if (newAccount == null || newAccount.getId() == null) return;
        // can not insert new account with id that already exists
        if (this.studentAccountRepository.existsByIdStudent(newAccount.getId())) return;

        this.studentAccountRepository.addStudent(newAccount);
    }

    public void registerTeacher(Teacher newAccount) {
        if (newAccount == null || newAccount.getId() == null) return;
        // can not insert new account with id that already exists
        if (this.teacherAccountRepository.existsByIdTeacher(newAccount.getId())) return;

        this.teacherAccountRepository.addTeacher(newAccount);
    }

    public List<Student> getListOfStudents(){
        return this.studentAccountRepository.getListOfStudents();
    }

    public List<Teacher> getListOfTeachers() { return this.teacherAccountRepository.getListOfTeachers();}

    public Student findStudentByUsernamePassword(String username, String password) {
        return this.studentAccountRepository.findStudentByUsernamePassword(username, password);

    }

    public Teacher findTeacherByUsernamePassword(String username, String password) {
        return this.teacherAccountRepository.findTeacherByUsernamePassword(username, password);

    }

    public boolean checkUsernamePassword(String username, String password) {
        return this.schoolAccountRepository.checkUsernamePassword(username,password);
    }
}
