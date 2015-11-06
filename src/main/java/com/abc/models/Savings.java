package com.abc.models;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;

public class Savings extends Account {

    public static final double SAVING_FIRST_TIER_AMOUNT = 1000.00;

    public static final double SAVING_RATE_FOR_FIRST_TIER = 0.001;
    public static final double SAVING_RATE_FOR_REMAINDER = 0.002;

    private String accountType = "Savings";

    public Savings() {
        this.transactions = new ArrayList<Transaction>();
    }

    public String getAccountType() {
        return accountType;
    }

    @Override
    public double interestEarned() {
        double amount = sumTransactions();

        if (amount <= SAVING_FIRST_TIER_AMOUNT) {
            return amount * SAVING_RATE_FOR_FIRST_TIER;
        } else {
            return SAVING_FIRST_TIER_AMOUNT * SAVING_RATE_FOR_FIRST_TIER
                    + (amount - SAVING_FIRST_TIER_AMOUNT)
                    * SAVING_RATE_FOR_REMAINDER;
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


