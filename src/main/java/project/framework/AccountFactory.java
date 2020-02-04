package project.framework;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public class AccountFactory {
    public IAccount createAccount(Customer customer,String accountNumber){
        return new Account(customer,accountNumber);
    }
}
