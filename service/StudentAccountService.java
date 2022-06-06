package service;

import model.Student;

import repository.StudentAccountRepository;

import java.util.List;

/**
 * STUDENT ACCOUNT SERVICE
 */
public class StudentAccountService {

    /**
     * Singleton pattern.
     * Ensures that only one objects of Account service exists.
     */
    private static final StudentAccountService studentService = new StudentAccountService();
    public static StudentAccountService getInstance() {
        return studentService;
    }
    private StudentAccountService() {}
    private final StudentAccountRepository studentAccountRepository = StudentAccountRepository.getInstance();

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

    /**
     *
     * @return copy of list of students.
     */
    public List<Student> getListOfStudents(){
        return this.studentAccountRepository.getListOfStudents();
    }

    /**
     * LOG IN STUDENT CHECK - when student log in it checks if account exists.
     * @param username - username of wanted student.
     * @param password - password of wanted student.
     * @return student account when student with this username and password exists or returns null.
     */
    public Student findStudentByUsernamePassword(String username, String password) {
        return this.studentAccountRepository.findStudentByUsernamePassword(username, password);
    }

    /**
     *
     * @return last ID of student
     */
    public Long getLastId() {
        return this.studentAccountRepository.getLastId();
    }
}
