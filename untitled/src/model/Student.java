package model;

import model.School;

/**
 * This class is responsible for keep the
 * track of students
 */

public class Student {

    private int id;
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

    public Student(int id, String name,String secondName) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;


    }

    /**
     * To create a new object without initializing the values.
     */
    public Student() {}


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
     * set Id of the student.
     * @param id
     */
    public void setId(int id) {
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
     * @param name
     */
    public void setName(String name) { this.name = name; }

    /**
     * set the second name of the student
     * @param secondName
     */
    public void setSecondName(String secondName) { this.secondName = secondName; }

    /**
     *
     * @return second name of the student
     */
    public String getSecondName() { return secondName; }


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

    /**
     * set already paid fees when registring
     * @param feesPaid fees which has been already paid.
     */
    public void setFeesPaid(int feesPaid) { this.feesPaid = feesPaid;}

    /**
     * set total fees when registring
     * @param feesTotal total fees for semester
     */
    public void setFeesTotal(int feesTotal) { this.feesTotal = feesTotal; }








}
