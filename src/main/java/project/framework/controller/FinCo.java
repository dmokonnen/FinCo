package project.framework.controller;

import project.framework.model.IAccount;
import project.framework.model.IAccountManager;
import project.framework.model.ICustomer;
import project.framework.view.MainWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FinCo {

    private static IAccountManager accountManager;
    private static final List<ICustomer> customers = new ArrayList<>();
    private static final List<IAccount> accounts = new ArrayList<>();
    private static ICustomer currentCustomer;

    public static void main(String[] args) {

        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) {
            }
            (new MainWindow(customers)).setVisible(true);
        }
        catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }

    }

    public IAccountManager getAccountManager() {
        return accountManager;
    }

    public static List<ICustomer> getCustomers() {
        return customers;
    }

    public static ICustomer getCurrentCustomer() {
        return currentCustomer;
    }

    public static void setCurrentCustomer(ICustomer currentCustomer) {
        FinCo.currentCustomer = currentCustomer;
    }
}
