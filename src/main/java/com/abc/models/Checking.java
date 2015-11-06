package com.abc.models;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;

public class Checking extends Account {

    public static final double CHECKING_RATE = 0.001;
    

    private String accountType = "Checking";

    public Checking() {
        this.transactions = new ArrayList<Transaction>();
    }

    public String getAccountType() {
        return accountType;
    }

    public double interestEarned() {
        double amount = sumTransactions();

        return amount * CHECKING_RATE;

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
