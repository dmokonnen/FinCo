package project.framework;

import java.util.List;

public interface IAccount {
    Double getBalance();
    String getAccountNo();
    ICustomer getCustomer();
    List<ITransaction> getTransactions();
}
