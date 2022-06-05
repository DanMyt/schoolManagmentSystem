package model;

import java.util.List;

/**
 * Many teachers, many students.
 * Implements teachers and students using an ArrayList
 */
public class School {

    /**
     * Singleton pattern.
     * Ensures that only one objects of School exists.
     */
    private static final School school = new School();
    public static School getInstance() {
        return school;
    }
    private School() {}
    private List<Teacher> teachers;
    private List<Student> students;
    private static int totalMoneyEarned;
    private static int totalMoneySpend;

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
     *
     * @return return the list of students in the school.
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
    public static int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }


    /**
     * update the total money earned
     * @param MoneyEarned new amount of earned money
     */
    public static void updateTotalMoneyEarned(int MoneyEarned) {
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
    public static void updateTotalMoneySpend(int MoneySpend) {
        totalMoneyEarned -= MoneySpend;
    }
}
