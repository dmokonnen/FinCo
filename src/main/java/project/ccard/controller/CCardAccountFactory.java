package project.ccard.controller;

import project.ccard.model.Bronze;
import project.ccard.model.Gold;
import project.ccard.model.Silver;
import project.framework.controller.AccountFactory;
import project.framework.model.Customer;
import project.framework.model.IAccount;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public class CCardAccountFactory extends AccountFactory {
    public IAccount createBronzeAccount(Customer customer, String accountNumber) {
        return new Bronze(customer, accountNumber);
    }
    public IAccount createGoldAccount(Customer customer, String accountNumber) {
        return new Gold(customer, accountNumber);
    }
    public IAccount createSilverAccount(Customer customer, String accountNumber) {
        return new Silver(customer, accountNumber);
    }

}
