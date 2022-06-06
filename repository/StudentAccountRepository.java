package repository;

import model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * STUDENT ACCOUNT REPOSITORY
 */
public class StudentAccountRepository {

    /**
     * Singleton pattern.
     * Ensures that only one objects of Student account repository exists.
     */
    private static final StudentAccountRepository studentRepository = new StudentAccountRepository();

    public static StudentAccountRepository getInstance() {
        return studentRepository;
    }
    private StudentAccountRepository() {}

    /**
     * List of students of school
     */
    private final List<Student> studentsAccounts = new ArrayList<>() {
        {
            add(new Student(1L,"B", "Danka","Srnka",0, 30000));
            add(new Student(2L,"BP", "Daka","Snka",0, 30000));
        }
    };


    /**
     * Adds a new account to the list of students accounts.
     * Student's account is successfully registered.
     * @param newAccount account of the new student
     */
    public void addStudent(Student newAccount) { this.studentsAccounts.add(newAccount);}

    /**
     * Make copy of list of students.
     * @return copy of list of students.
     */
    public List<Student> getListOfStudents() {
        return new ArrayList<>(this.studentsAccounts);
    }


    public boolean existsByIdStudent(Long id) {
        return this.studentsAccounts.stream().anyMatch(a -> Objects.equals(a.getId(), id));
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
        return this.studentsAccounts.stream()
                .filter(student -> Objects.equals(username, student.getName()) &&  Objects.equals(password, student.getPassword()))
                .findFirst().orElse(null);
    }

    /**
     *
     * @return 0L when list of students is empty or last Id of student.
     */
    public Long getLastId() {
        if(studentsAccounts.isEmpty()) return 0L;
        return studentsAccounts.stream().max(Comparator.comparing(Student::getId)).get().getId();
    }
}
