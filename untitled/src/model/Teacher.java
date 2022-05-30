package model;

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

    /**
     * To create a new Teacher object without initializing the values.
     */
    public  Teacher() {}

    /**
     *
     * @return return the id of the teacher
     */
    public int getId() {
        return id;
    }

    /**
     * set id of the teacher
     * @param id
     */
    public void setId(int id) { this.id = id; }

    /**
     *
     * @returnreturn the name of the teacher
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return return the second name of the teacher
     */
    public String getSecondName() { return secondName; }

    /**
     * set name of the teacher
     * @param name
     */
    public void setName(String name) {this.name = name;}

    /**
     * set second name of the teacher
     * @param secondName
     */
    public void setSecondName(String secondName) {this.secondName = secondName;}

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


    /**
     * set salary earned
     * @param salaryEarned, salary earned for the whole working period
     */
    public  void setSalaryEarned(int salaryEarned) {
        this.salaryEarned = salaryEarned;
    }


}
