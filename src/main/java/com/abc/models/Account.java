/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.models;

import java.util.List;

/**
 *
 * @author Chris Myung
 */
public abstract class Account {
    
    public List<Transaction> transactions;
    
    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
       
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(-amount));
        }
        
    }

    public abstract double interestEarned();
    
    public double sumTransactions() {
        double amount = 0.0;

        if (!transactionsExist()) {

            for (Transaction t : transactions) {
                amount += t.amount;
            }
        }
        return amount;
    }

    private boolean transactionsExist() {

        return this.transactions.isEmpty();
    }
    
    public abstract String getStatement();
}
