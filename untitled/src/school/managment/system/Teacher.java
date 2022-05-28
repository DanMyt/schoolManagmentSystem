package school.managment.system;

/**
 * This class is responsible for keeping the track
 * of teacher's name, id, salary
 */

public class Teacher {

    private int id;
    private String name;
    private int salary;
    private int salaryEarned;

    /**
     * Creates a new Teacher object
     * @param id id for teacher
     * @param name name of the teacher
     * @param salary salary of the teacher
     */
    public Teacher(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.salaryEarned = 0;
    }

    /**
     * return the id of the teacher
     * @return
     */
    public int getId() {
        return id;
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


}
