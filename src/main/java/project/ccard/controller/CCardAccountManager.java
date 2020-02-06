package project.ccard.controller;

import project.framework.model.AccountManager;
import project.framework.model.IAccountCommand;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public class CCardAccountManager extends AccountManager {
    @Override
    public void executeCommand(IAccountCommand command) {
        super.executeCommand(command);
    }
}
