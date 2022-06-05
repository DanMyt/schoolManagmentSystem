package model;

/**
 * This class is responsible for keeping the track
 * of teacher's name, id, salary
 */

public class Teacher {

    private Long id;
    private String password;
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
    public Teacher(Long id, String name,String secondName, int salary, String password) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.salary = salary;
        this.salaryEarned = 0;
        this.password = password;
    }

    /**
     * To create a new Teacher object without initializing the values.
     */
    public  Teacher() {}

    /**
     *
     * @return return the id of the teacher
     */
    public Long getId() {
        return id;
    }

    /**
     * set id of the teacher
     * @param id - new id of a teacher.
     */
    public void setId(Long id) { this.id = id; }

    /**
     *
     * @return the name of the teacher
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
     * @param name - new name of a teacher.
     */
    public void setName(String name) {this.name = name;}

    /**
     * set second name of the teacher
     * @param secondName - new second name of a teacher.
     */
    public void setSecondName(String secondName) {this.secondName = secondName;}

    /**
     * Function to set a new password.
     * @param password new password
     */
    public void setPassword(String password) { this.password = password; }


    /**
     *
     * @return password
     */
    public String getPassword() {return password; }

    /**
     *
     * @return the salary of the teacher
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Set the month  salary of a teacher.
     * @param salary - new month salary of a teacher.
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Adds to salary earned
     * @param salary - month salary to receive.
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

    /**
     * @return salary earned
     */
    public  int getSalaryEarned() {
        return salaryEarned;
    }


}
