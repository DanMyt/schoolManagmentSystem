package model;

/**
 * This class is responsible for keep the
 * track of students
 */

public class Student {

    private Long id;
    private String password;
    private String name;
    private String secondName;

    private int feesPaid;
    private int feesTotal;

    /**
     * To create a new object by initializing the values:
     * Fees for every student is $30,000
     * Fees paid initially is 0
     * @param id id for student: unique value
     * @param name name of the student
     * @param secondName second name of the student
     */

    public Student(Long id, String name,String secondName, String password) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.password = password;
    }

    /**
     * To create a new object without initializing the values.
     */
    public Student() {}

    /**
     *
     * @return id of the student
     */
    public Long getId() {
        return id;
    }

    /**
     * set Id of the student.
     * @param id - new ID of a student.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * set the first name of the student
     * @param name - new name of a student.
     */
    public void setName(String name) { this.name = name; }

    /**
     * set the second name of the student
     * @param secondName - new second name of a student.
     */
    public void setSecondName(String secondName) { this.secondName = secondName; }

    /**
     *
     * @return second name of the student
     */
    public String getSecondName() { return secondName; }


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

    /**
     * set already paid fees when registering
     * @param feesPaid fees which has been already paid.
     */
    public void setFeesPaid(int feesPaid) { this.feesPaid = feesPaid;}

    /**
     * set total fees when registering
     * @param feesTotal total fees for semester
     */
    public void setFeesTotal(int feesTotal) { this.feesTotal = feesTotal; }

}
