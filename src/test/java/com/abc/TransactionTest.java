package com.abc;

import com.abc.models.Transaction;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import org.junit.Before;

public class TransactionTest {
    
    Transaction t;
    
    public TransactionTest() {
        
        
    }
    @Before
    public void setup() {

        t = new Transaction(5000);
        
    }
    
    @After
    public void tearDown() {

    }
    @Test
    public void transactionCreationTest() {
        
        
        assertTrue(t instanceof Transaction);
    }
    
    @Test
    public void dateComparisonTest(){
        
        Date now = Calendar.getInstance().getTime();
        
        assertEquals(now.toString(),t.getTransactionDate().toString());
    }
}
