package com.abc.models;

import static java.lang.Math.abs;
import java.util.Calendar;
import java.util.Date;

public class Transaction {
    public final double amount;

    private Date transactionDate;

    public Transaction(double amount) {
        this.amount = amount;
        this.transactionDate = DateProvider.currentTransactionDate();
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }
    
    
    
    
    public String getTransactionDetails() {
       return "\t" + (this.amount < 0 ? "withdrawal" : "deposit") + " " 
               + toDollars(this.amount) + "\n"; 
    }
    
    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }

    
}
