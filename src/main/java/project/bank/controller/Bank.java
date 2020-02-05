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

	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[])
	{
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch (Exception e) {
			}

			//Create a new instance of our application's frame, and make it visible.
			(new BankFrm(getCustomers())).setVisible(true);
		}
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	@Override
	public IAccountManager getAccountManager() {
		return accountManager;
	}
}
