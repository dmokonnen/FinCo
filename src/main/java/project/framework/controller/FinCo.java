package project.framework.controller;

import project.framework.model.AccountManager;
import project.framework.model.IAccount;
import project.framework.model.IAccountManager;
import project.framework.model.ICustomer;
import project.framework.view.MainWindow;

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

        (new MainWindow()).setVisible(true);

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
