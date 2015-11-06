package com.abc.models;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;

public class MaxiSavings extends Account {

    public static final double MAXI_SAVING_FIRST_TIER_AMOUNT = 1000.00;
    public static final double MAXI_SAVING_SECOND_TIER_AMOUNT = 1000.00;

    public static final double MAXI_SAVING_RATE_FOR_FIRST_TIER = 0.02;
    public static final double MAXI_SAVING_RATE_FOR_SECOND_TIER = 0.05;
    public static final double MAXI_SAVING_RATE_FOR_THIRD_TIER = 0.10;

    private String accountType = "Maxi-Savings";

    public MaxiSavings() {
        this.transactions = new ArrayList<Transaction>();
    }

    public String getAccountType() {
        return accountType;
    }

    public double interestEarned() {
        double amount = sumTransactions();

        if (amount <= MAXI_SAVING_FIRST_TIER_AMOUNT) {
            return amount * MAXI_SAVING_RATE_FOR_FIRST_TIER;
        }
        else if (amount <= MAXI_SAVING_FIRST_TIER_AMOUNT + MAXI_SAVING_SECOND_TIER_AMOUNT) {
            return MAXI_SAVING_FIRST_TIER_AMOUNT * MAXI_SAVING_RATE_FOR_FIRST_TIER
                    + (amount - MAXI_SAVING_FIRST_TIER_AMOUNT) * MAXI_SAVING_RATE_FOR_SECOND_TIER;
        }
        else { 
            return MAXI_SAVING_FIRST_TIER_AMOUNT * MAXI_SAVING_RATE_FOR_FIRST_TIER
                + MAXI_SAVING_SECOND_TIER_AMOUNT * MAXI_SAVING_RATE_FOR_SECOND_TIER
                + (amount - MAXI_SAVING_FIRST_TIER_AMOUNT - MAXI_SAVING_SECOND_TIER_AMOUNT)
                * MAXI_SAVING_RATE_FOR_THIRD_TIER;
        }

    }
    
    @Override
    public String getStatement() {
       String statement = this.accountType + " Account\n";
       
       double total = 0.0;
       for (Transaction t : this.transactions) {
            statement += t.getTransactionDetails();
            total += t.amount;
        }
        statement += "Total " + toDollars(total);
        return statement;
        
    }
    
    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
}
