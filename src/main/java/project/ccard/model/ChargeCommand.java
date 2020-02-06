package project.ccard.model;

import project.framework.model.IAccount;
import project.framework.model.IAccountCommand;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public class ChargeCommand implements IAccountCommand {
    private final IAccount account;
    private final Double amount;
    public ChargeCommand(IAccount account, Double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.setBalance(account.getBalance()-amount);
        if(account.getBalance()<0) {
            account.getCustomer().sendEmail();
        }
    }
}
