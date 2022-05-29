package model;

import model.School;

/**
 * This class is responsible for keeping the track
 * of teacher's name, id, salary
 */

public class Teacher {

    private int id;
    private String name;
    private String secondName;
    private int salary;
    private int salaryEarned;

    /**
     * Creates a new Teacher object
     * @param id id for teacher
     * @param name name of the teacher
     * @param salary salary of the teacher
     */
    public Teacher(int id, String name,String secondName, int salary) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.salary = salary;
        this.salaryEarned = 0;
    }

    public  Teacher() {}

    /**
     * return the id of the teacher
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * return the name of the teacher
     * @return
     */

    public String getName() {
        return name;
    }

    /**
     *
     * @return the salary of the teacher
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Set the salary
     * @param salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Adds to salary earn
     * @param salary
     */
    public void receiveSalary(int salary) {
        salaryEarned += salary;
        School.updateTotalMoneySpend(salaryEarned);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public  void setSalaryEarned(int salaryEarned) {
        this.salaryEarned = salaryEarned;
    }


}
