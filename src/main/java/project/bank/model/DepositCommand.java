package project.bank.model;

import project.framework.model.IAccount;
import project.framework.model.IAccountCommand;
import project.framework.model.Transaction;

import java.util.Date;

/**
 * Created by Jonathan on 2/4/2020.
 */

public class DepositCommand implements IAccountCommand {

	private final IAccount account;
	private final Double amount;

	public DepositCommand(IAccount account, Double amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void execute() {
		account.addTransaction(new Transaction(account.getCustomer().getName(),
				amount,
				new Date()));
		account.setBalance(account.getBalance() + amount);
	}
}
