package project.bank.controller;

import project.bank.model.BankAccountManager;
import project.bank.view.BankFrm;
import project.framework.controller.FinCo;
import project.framework.model.IAccountManager;

import javax.swing.*;

/**
 * Created by Jonathan on 2/4/2020.
 */

public class Bank extends FinCo {

	private static IAccountManager accountManager = new BankAccountManager();

	static public void main(String args[])
	{
		try {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch (Exception e) {
			}
			(new BankFrm(getCustomers())).setVisible(true);
		}
		catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public IAccountManager getAccountManager() {
		return accountManager;
	}
}
