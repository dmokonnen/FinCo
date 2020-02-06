package project.ccard.model;

import project.framework.model.Customer;
import project.framework.model.ICustomer;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public class Silver extends CCardAccount {
    public Silver(ICustomer customer, String accountNumber) {
        this.customer = customer;
        this.accountNo = accountNumber;
        setMinimumPayment(0.12);
        setMonthlyInterest(0.08);
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
