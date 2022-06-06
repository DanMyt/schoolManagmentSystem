package model;

import lombok.Setter;


@Setter
public class School {

    /**
     * Singleton pattern.
     * Ensures that only one objects of School exists.
     */
    private static final School school = new School();
    public static School getInstance() {
        return school;
    }
    private School() {}
    private static int totalMoneyEarned;
    private static int totalMoneySpend;

    /**
     * update the total money earned
     * @param MoneyEarned new amount of earned money
     */
    public void updateTotalMoneyEarned(int MoneyEarned) {
        totalMoneyEarned += MoneyEarned;
    }


    /**
     * update the money that is spent by the school which is money
     * given to teachers.
     * @param MoneySpend the money spent by the school.
     */
    public void updateTotalMoneySpend(int MoneySpend) {
        totalMoneyEarned -= MoneySpend;
        totalMoneySpend += MoneySpend;
    }


    /**
     *
     * @return Total money earned by school.
     */
    public int getTotalMoneyEarned() { return totalMoneyEarned;}

    /**
     *
     * @return Total money spent by school.
     */
    public int getTotalMoneySpend() {
        return totalMoneySpend;
    }
}
