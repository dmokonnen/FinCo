package project.ccard.model;

import project.framework.model.AbstractAccount;

/**
 * @author Demisew Mokonnen
 * @2020
 */
public abstract class CCardAccount extends AbstractAccount {
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
   public abstract Double getNewMonthlyBalance();
   public abstract Double getNewAmountDue();
}
