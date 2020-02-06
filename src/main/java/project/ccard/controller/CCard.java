package project.ccard.controller;

import project.bank.model.BankAccountManager;
import project.ccard.view.CardFrm;
import project.framework.controller.FinCo;
import project.framework.model.IAccountManager;

import javax.swing.*;

/**
 * @author Demisew Mokonnen
 * @2020
 */
/*****************************************************
 * The entry point for this application.
 * Sets the Look and Feel to the System Look and Feel.
 * Creates a new JFrame1 and makes it visible.
 *****************************************************/
public class CCard extends FinCo {
    private static IAccountManager accountManager = new BankAccountManager();

    static public void main(String args[])
    {
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) {
            }
            (new CardFrm(getCustomers(), accountManager)).setVisible(true);
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
