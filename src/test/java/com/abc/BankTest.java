package com.abc;

import com.abc.models.Account;
import com.abc.models.Savings;
import com.abc.models.Customer;
import com.abc.models.Bank;
import com.abc.models.Checking;
import com.abc.models.MaxiSavings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    Bank bank;
    Customer john;
    Customer bill;
    Account checkingAccount;
    Account savingsAccount;
    Account maxiSavingsAccount;
    
    
    private static final double DOUBLE_DELTA = 1e-15;
    

    public BankTest() {
    }

    @Before
    public void setup() {
        
        bank = new Bank();
        john = new Customer("John");
        bill = new Customer("Bill");
        checkingAccount = new Checking();
        savingsAccount = new Savings();
        maxiSavingsAccount = new MaxiSavings();
        

    }

    @After
    public void tearDown() {

    }

    @Test
    public void customerSummaryTest() {
        
        john.createAccount(checkingAccount);
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void checkingAccountTest() {
        
        bill.createAccount(checkingAccount);
        bank.addCustomer(bill);

        checkingAccount.deposit(100.0);

        assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void savingsAccountTest() {
        
        bill.createAccount(savingsAccount);
        bank.addCustomer(bill);

        savingsAccount.deposit(1500.0);
        
        double expectedInterestPaid = 2.0;

        assertEquals(expectedInterestPaid, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void maxiSavingsAccountTest() {
        
        bill.createAccount(maxiSavingsAccount);
        bank.addCustomer(bill);

        maxiSavingsAccount.deposit(3000.0);
        
        double expectedInterestPaid = 170.0; 

        assertEquals(expectedInterestPaid, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

}
