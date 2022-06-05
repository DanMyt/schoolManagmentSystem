package repository;

import model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeacherAccountRepository {

    /**
     * Singleton pattern.
     * Ensures that only one objects of Teacher account repository exists.
     */
    private static final TeacherAccountRepository teacherRepository = new TeacherAccountRepository();

    public static TeacherAccountRepository getInstance() {
        return teacherRepository;
    }
    private TeacherAccountRepository() {}

    /**
     * List of the teachers
     */
    private final List<Teacher> teachersAccounts = new ArrayList<>() {
        {
            add(new Teacher(1L, "B","Daniel","Skvrnity",500,5000));
            add(new Teacher(2L, "BP","Daniela","Skvrnita",400,6000));
        }
    };

    /**
     * Adds a new account to the list of teachers accounts.
     * Teacher's account is successfully registered.
     * @param newAccount account of the new teacher
     */
    public void addTeacher(Teacher newAccount) { this.teachersAccounts.add(newAccount);}

    /**
     * Make copy of list of teachers.
     * @return copy of list of teachers.
     */
    public List<Teacher> getListOfTeachers() { return new ArrayList<>(this.teachersAccounts);}

    public boolean existsByIdTeacher(Long id) {
        return this.teachersAccounts.stream().anyMatch(a -> Objects.equals(a.getId(), id));
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

        return this.teachersAccounts.stream()
                .filter(teacher -> Objects.equals(username, teacher.getName()) &&  Objects.equals(password, teacher.getPassword()))
                .findFirst().orElse(null);

        //Alternative
        /**for(Teacher account : this.teachersAccounts) {
         if(Objects.equals(username, account.getName()) &&  Objects.equals(password, account.getPassword())) {
         return account;
         }
         }
         return null;**/
    }
}
