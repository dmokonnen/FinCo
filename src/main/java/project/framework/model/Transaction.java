package project.framework.model;

import java.util.Date;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public class Transaction implements ITransaction {
    private String name;
    private Double amount;
    private Date date;


    //===setters and getters =========


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
