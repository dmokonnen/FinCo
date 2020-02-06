package project.ccard.model;

import project.framework.model.AbstractAccount;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public abstract class CCardAccount extends AbstractAccount {
    private Double monthlyInterest;
    private Double minimumPayment;
    public Double getCurrentBalance(){
        //to be implemented
        return null;
    }

   public Double getLastMonthBalance(){
        //to be implemented
        return null;
   }
   public Double getTotalMonthlyCredits(){
        //to be implemented
        return null;
   }
   public Double getTotalMonthlyCharges(){
        //to be implemented
        return null;
   }

    public Double getMonthlyInterest() {
        return monthlyInterest;
    }

    public void setMonthlyInterest(Double monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }

    public Double getMinimumPayment() {
        return minimumPayment;
    }

    public void setMinimumPayment(Double minimumPayment) {
        this.minimumPayment = minimumPayment;
    }

    public abstract Double getNewMonthlyBalance();
   public abstract Double getNewAmountDue();
}
