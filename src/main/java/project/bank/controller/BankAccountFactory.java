package project.bank.controller;

import project.bank.model.CheckingAccount;
import project.bank.model.SavingAccount;
import project.framework.controller.AccountFactory;
import project.framework.model.IAccount;
import project.framework.model.ICustomer;

/**
 * Created by Jonathan on 2/4/2020.
 */

public class BankAccountFactory extends AccountFactory {
	public IAccount createSavingAccount(ICustomer customer, String accountNumber) {
		return new SavingAccount(customer, accountNumber);
	}

	public IAccount createCheckingAccount(ICustomer customer, String accountNumber) {
		return new CheckingAccount(customer, accountNumber);
	}
}
