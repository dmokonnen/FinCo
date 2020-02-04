package project.framework.model;

import java.util.List;

public interface ICustomer {
    void addAccount(IAccount account);
    void removeAccount(IAccount account);
    List<IAccount> getAccounts();
    void setAddress(String state, String city, String street, String zip);
    Address getAddress();
    void setName(String name);
    String getName();
    void setEmail(String email);
    String getEmail();
    void sendEmail();
}
