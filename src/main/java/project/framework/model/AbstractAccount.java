package project.framework.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public abstract class AbstractAccount implements IAccount{
    private Double balance;
    protected String accountNo;
    protected ICustomer customer;
    private List<ITransaction> transactions=new ArrayList<>();

    public void addTransaction(ITransaction transaction){
        this.transactions.add(transaction);
    }

    //====Getters and Setters ======

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public ICustomer getCustomer() {
        return customer;
    }

    public void setCustomer(ICustomer customer) {
        this.customer = customer;
    }

    public List<ITransaction> getTransactions() {
        return transactions;
    }
}
