package school.managment.system;

/**
 * This class is responsible for keep the
 * track of students
 */

public class Student {

    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;

    /**
     * To create a new object by initializing the values:
     * Fees for every student is $30,000
     * Fees paid initially is 0
     * @param id id for student: unique value
     * @param name name of student
     * @param grade grade of the student
     */

    public Student(int id, String name, int grade) {
        this.feesPaid = 0;
        this.feesTotal = 30000;
        this.id = id;
        this.name = name;
        this.grade = grade;

    }

    /**
     * Used to update the student's grade
     * @param grade new grade of the student
     */

    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * Add the fees to the fees paid
     * The school is going to receive the funds
     * @param fees the fees that the student pays
     */

    public void updateFeesPaid(int fees) {
        feesPaid += fees;
    }


    /**
     *
     * @return id of the student
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return name of the student
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return grade of the student
     */
    public int getGrade() {
        return grade;
    }


    /**
     *
     * @return paid fees of the student
     */
    public int getFeesPaid() {
        return feesPaid;
    }


    /**
     *
     * @return the total fees of the student
     */
    public  int getFeesTotal() {
        return feesTotal;
    }


    /** Pays the selected amount as fees
     * to school.
     * @param fees
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
