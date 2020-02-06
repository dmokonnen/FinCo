package project.bank.model;

import project.framework.model.AccountManager;
import project.framework.model.IAccountCommand;

/**
 * Created by Jonathan on 2/4/2020.
 */

public class BankAccountManager extends AccountManager {
	@Override
	public void executeCommand(IAccountCommand command) {
		super.executeCommand(command);
	}
}
