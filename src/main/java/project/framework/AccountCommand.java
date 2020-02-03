package project.framework;

/**
 * Created by Jonathan on 2/3/2020.
 */

public class AccountCommand implements IAccountCommand {

	private final IAccount account;

	public AccountCommand(IAccount account) {
		this.account = account;
	}

	@Override
	public void execute() {
		System.out.println("Executing Command...");
	}
}
