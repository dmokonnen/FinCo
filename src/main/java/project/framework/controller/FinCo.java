package project.framework.controller;

import project.bank.BankFrm;
import project.framework.model.AccountManager;
import project.framework.model.IAccount;
import project.framework.model.IAccountManager;
import project.framework.model.ICustomer;
import project.framework.view.MainWindow;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

public class FinCo {

    private static IAccountManager accountManager;
    private static List<ICustomer> customers = new ArrayList<>();
    private static ICustomer currentCustomer;

    public static void main(String[] args) {

        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            (new MainWindow()).setVisible(true);
        }
        catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }

    }

    public IAccountManager getAccountManager() {
        return accountManager;
    }

    public static List<ICustomer> getCustomers() {
        return customers;
    }

    public static void setCustomers(List<ICustomer> customers) {
        FinCo.customers = customers;
    }

    public static ICustomer getCurrentCustomer() {
        return currentCustomer;
    }

    public static void setCurrentCustomer(ICustomer currentCustomer) {
        FinCo.currentCustomer = currentCustomer;
    }
}
