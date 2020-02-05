package project.bank.model;

import project.framework.model.AbstractAccount;
import project.framework.model.ICustomer;

/**
 * Created by Jonathan on 2/4/2020.
 */

public class SavingAccount extends AbstractAccount {

	public SavingAccount(ICustomer customer, String accountNumber) {
		this.customer = customer;
		this.accountNo = accountNumber;
	}
}
