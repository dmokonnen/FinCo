package project.bank.model;

import project.framework.model.IAccount;
import project.framework.model.IAccountCommand;

import java.util.List;

/**
 * Created by Jonathan on 2/4/2020.
 */

public class AddInterestCommand implements IAccountCommand {

	private final List<IAccount> accounts;

	private final Double interestPercentage;

	public AddInterestCommand(List<IAccount> accounts, Double interestPercentage) {
		this.accounts = accounts;
		this.interestPercentage = interestPercentage;
	}

	@Override
	public void execute() {
		accounts.iterator().forEachRemaining(account -> {
			account.setBalance(account.getBalance() + (account.getBalance() * interestPercentage));
		});
	}
}
