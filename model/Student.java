package model;

import lombok.*;

/**
 * This class is responsible for keep the
 * track of students
 */

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;
    private String password;
    private String name;
    private String secondName;

    private int feesPaid;
    private int feesTotal;


    @Override
    public String toString() {
        return "Student{" +
                "Id = " + id +
                ", Name = '" + name + '\'' +
                ", Second name = '" + secondName + '\'' +
                ", Paid fees = " + feesPaid +
                ", Total fees = " + feesTotal +
                '}';
    }

    /** Pays the selected amount as fees
     * to school.
     * @param fees - fees paid by student.
     */
    public void payFees(int fees) {
        feesPaid += fees;
        School.updateTotalMoneyEarned(feesPaid);
    }

    /**
     *
     * @return the remaining fees
     */
    public int getRemainingFees() {
        return feesTotal - feesPaid;
    }

}
