package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class is responsible for keeping the track
 * of teacher's name, id, salary
 */

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private Long id;
    private String password;
    private String name;
    private String secondName;
    private int salary;
    private int salaryEarned;
    private final School school = School.getInstance();


    @Override
    public String toString() {
        return "Teacher{" +
                "ID = " + id +
                ", Name = '" + name + '\'' +
                ", Second name = '" + secondName + '\'' +
                ", salary = " + salary +
                ", Salary earned = " + salaryEarned +
                '}';
    }

    /**
     * Adds to salary earned
     * @param salary - month salary to receive.
     */
    public void receiveSalary(int salary) {
        salaryEarned += salary;
        this.school.updateTotalMoneySpend(salaryEarned);
    }
}
