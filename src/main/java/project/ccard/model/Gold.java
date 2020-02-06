package project.ccard.model;

import project.framework.model.Customer;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public class Gold extends CCardAccount {
    public Gold(Customer customer, String accountNumber) {
        this.customer = customer;
        this.accountNo = accountNumber;
        setMinimumPayment(0.1);
        setMonthlyInterest(0.06);
    }

    @Override
    public Double getNewMonthlyBalance() {
        return null;
    }

    @Override
    public Double getNewAmountDue() {
        return null;
    }
}
