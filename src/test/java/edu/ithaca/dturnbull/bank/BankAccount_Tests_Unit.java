package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

class BankAccount_Tests_Unit {

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount(300,0.06,1);
        assertEquals(200, bankAccount.getBalance(), 0.001);
        // check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(100,0.06,1));
    }

    @Test
    void getBalanceTest() throws InsufficientFundsException, ClosedAccountException {
        BankAccount bankAccount = new BankAccount(300.0,0.06,1);
        assertEquals(300, bankAccount.balance , 0.001);//should be valid 
    }

    @Test
    void withdrawTest() throws InsufficientFundsException, ClosedAccountException {
        
        BankAccount bankAccount = new BankAccount(300,0.06,1);
        bankAccount.withdraw(100.0);
        assertEquals(200, bankAccount.balance , 0.001);//should be valid 
        BankAccount bankAccount1 = new BankAccount(400,0.06,1);
        assertThrows(InsufficientFundsException.class, () -> bankAccount1.withdraw(500.0));//should throw exception 
        BankAccount bankAccount2 = new BankAccount(5000,0.06,1);
        bankAccount2.withdraw(800.0); //should be true 
        assertEquals(4200, bankAccount2.balance , 0.001);//should be invlaid 
        
    }

    

}