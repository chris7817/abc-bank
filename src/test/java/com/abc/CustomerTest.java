package com.abc;

import com.abc.models.Account;
import com.abc.models.Checking;
import com.abc.models.Savings;
import com.abc.models.Customer;
import com.abc.models.MaxiSavings;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class CustomerTest {

    Customer henry;
    Customer oscar;
    Account checkingAccount;
    Account savingsAccount;
    Account maxiSavingsAccount;

    public CustomerTest() {

    }

    @Before
    public void setup() {

        henry = new Customer("Henry");
        oscar = new Customer("Oscar");
        checkingAccount = new Checking();
        savingsAccount = new Savings();
        maxiSavingsAccount = new MaxiSavings();
        
    }

    @After
    public void tearDown() {

    }

    @Test //Test customer statement generation
    public void testApp() {

        henry.createAccount(checkingAccount);
        henry.createAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);

        assertEquals("Statement for Henry\n"
                + "\n"
                + "Checking Account\n"
                + "\tdeposit $100.00\n"
                + "Total $100.00\n"
                + "\n"
                + "Savings Account\n"
                + "\tdeposit $4,000.00\n"
                + "\twithdrawal $200.00\n"
                + "Total $3,800.00\n"
                + "\n"
                + "Total In All Accounts $3,900.00", henry.getStatement());
    }

    @Test
    public void testOneAccount() {
        oscar.createAccount(savingsAccount);
        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test
    public void testTwoAccount() {
        oscar.createAccount(savingsAccount);
        oscar.createAccount(checkingAccount);
        assertEquals(2, oscar.getNumberOfAccounts());
    }

    @Ignore
    public void testThreeAcounts() {
        oscar.createAccount(savingsAccount);
        oscar.createAccount(checkingAccount);
        oscar.createAccount(maxiSavingsAccount);
        assertEquals(3, oscar.getNumberOfAccounts());
    }
}
