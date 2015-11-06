package com.abc.models;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Customer {
    
    //private Integer customerId;
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public Customer createAccount(Account account) {
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public double totalInterestEarned() {
        double total = 0;
        for (Account a : accounts)
            total += a.interestEarned();
        return total;
    }

    public void transferMoney(double amount, Account transferFrom, Account transferTo) {
        transferFrom.withdraw(amount);
        transferTo.deposit(amount);
        
    }
    
    
    public String getStatement() {
        String statement = "Statement for " + name + "\n";
        
        double total = 0.0;
        for (Account a : accounts) {
            statement += "\n" + a.getStatement() + "\n";
            total += a.sumTransactions();
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }

    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
}
