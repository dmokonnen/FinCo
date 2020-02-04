package project.framework.model;

import java.util.List;

public interface IAccount {

    void addTransaction(ITransaction transaction);

    Double getBalance();

    void setBalance(Double balance);

    String getAccountNo();

    void setAccountNo(String accountNo);

    ICustomer getCustomer();

    void setCustomer(ICustomer customer);

    List<ITransaction> getTransactions();
}
