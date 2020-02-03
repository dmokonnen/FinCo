package project.framework;

/**
 * Created by Jonathan on 2/3/2020.
 */

public class AccountManager implements IAccountManager {
	@Override
	public void executeCommand(IAccountCommand command) {
		command.execute();
	}
}
