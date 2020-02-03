package project.framework;

import java.util.ArrayList;
import java.util.List;

abstract public class Customer implements ICustomer {
    private final List<IAccount> accounts = new ArrayList<>();
    private Address address;

    @Override
    public void addAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void removeAccount(IAccount account) {
        accounts.remove(account);
    }

    @Override
    public List<IAccount> getAccounts() {
        return accounts;
    }

    @Override
    public void setAddress(String state, String city, String street, String zip) {
        address = new Address(state, city, street, zip);
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public void sendEmail() {
        System.out.println("Sending an email to customer");
    }
}
