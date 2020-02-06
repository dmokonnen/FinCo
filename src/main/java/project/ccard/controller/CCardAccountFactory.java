package project.ccard.controller;

import project.ccard.model.Bronze;
import project.ccard.model.Gold;
import project.ccard.model.Silver;
import project.framework.controller.AccountFactory;
import project.framework.model.Customer;
import project.framework.model.IAccount;
import project.framework.model.ICustomer;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public class CCardAccountFactory extends AccountFactory {
    public IAccount createBronzeAccount(ICustomer customer, String accountNumber) {
        return new Bronze(customer, accountNumber);
    }
    public IAccount createGoldAccount(ICustomer customer, String accountNumber) {
        return new Gold(customer, accountNumber);
    }
    public IAccount createSilverAccount(ICustomer customer, String accountNumber) {
        return new Silver(customer, accountNumber);
    }

}
