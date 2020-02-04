package project.framework.controller;

import project.framework.model.Account;
import project.framework.model.IAccount;
import project.framework.model.ICustomer;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public class AccountFactory {
    public IAccount createAccount(ICustomer customer, String accountNumber){
        return new Account(customer,accountNumber);
    }
}
