package school.managment.system;

import java.util.List;

/**
 * Many teachers, many students.
 * Implements teachers and students using an ArrayList
 */
public class School {

    private List<Teacher> teachers;
    private List<Student> students;
    private int totalMoneyEarned;
    private int totalMoneySpend;

    /**
     * new school object is created
     * @param teachers list of teachers in the school
     * @param students list of students in the school
     */
    School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned = 0;
        totalMoneySpend = 0;
    }

    /**
     *
     * @return the list of teacher in the school.
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Adds a teacher to the school.
     * @param teacher the teacher to be added
     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);

    }

    /**
     * return the list of students in the school.
     * @return
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Adds a student to the school.
     * @param student the student to be added
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     *
     * @return the total money earned by the school
     */
    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }


    /**
     * update the total money earned
     * @param MoneyEarned
     */
    public void updateTotalMoneyEarned(int MoneyEarned) {
        totalMoneyEarned += MoneyEarned;
    }

    /**
     *
     * @return the total money spent by the school
     */
    public int getTotalMoneySpend() {
        return totalMoneySpend;
    }

    /**
     * update the money that is spent by the school which is money
     * given to teachers.
     * @param MoneySpend the money spent by the school
     */
    public void updateTotalMoneySpend(int MoneySpend) {
        totalMoneyEarned -= MoneySpend;
    }
}
