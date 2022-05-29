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
     * @param name name of student
     */

    public Student(int id, String name,String secondName) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;


    }

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
     *
     * @return name of the student
     */

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    /**
     *
     * @return grade of the student
     */



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

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFeesPaid(int feesPaid) {
        this.feesPaid = feesPaid;
    }

    public void setFeesTotal(int feesTotal) {
        this.feesTotal = feesTotal;
    }








}
