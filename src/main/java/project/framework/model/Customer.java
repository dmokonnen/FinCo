package project.framework.model;

import java.util.ArrayList;
import java.util.List;

abstract public class Customer implements ICustomer {
    private String name;
    private String email;
    private final List<IAccount> accounts;
    private Address address;

    public Customer(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
        accounts = new ArrayList<>();
    }

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
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void sendEmail() {
        System.out.println("Sending an email to customer");
    }
}
