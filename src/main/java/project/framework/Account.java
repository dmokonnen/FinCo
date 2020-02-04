package project.framework;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public class Account extends AbstractAccount {

    public Account(ICustomer customer, String accountNumber) {
        this.customer = customer;
        this.accountNo=accountNumber;
    }
}
