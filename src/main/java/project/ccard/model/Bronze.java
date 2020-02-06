package project.ccard.model;

import project.framework.model.IAccountCommand;
import project.framework.model.ICustomer;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public class Bronze extends CCardAccount {


    public Bronze(ICustomer customer, String accountNumber) {
        this.customer=customer;
        this.accountNo=accountNumber;
        setMinimumPayment(0.14);
        setMonthlyInterest(0.1);

    }

    @Override
    public Double getNewMonthlyBalance() {
        return null;
    }

    @Override
    public Double getNewAmountDue() {
        return null;
    }

    /**
     * @author Demisew Mokonnen
     * @2020
     */
    public static class DepositCommand implements IAccountCommand {
        @Override
        public void execute() {

        }
    }
}
