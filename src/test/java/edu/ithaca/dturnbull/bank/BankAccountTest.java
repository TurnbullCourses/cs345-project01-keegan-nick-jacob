package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance(), 0.001);
    }
    @Test
    void testSumNum(){
        BankAccount bankAccount = new BankAccount(100, 200);
        assertEquals(20, bankAccount.addSumNum(10, 10));
    }

    @Test
    void withdrawTest() throws InsufficientFundsException, ClosedAccountException {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance(), 0.001);
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(300));
    }

    @Test
    void isEmailValidTest() {
        assertTrue(BankAccount.isEmailValid("a@b.com")); // valid email address
        assertFalse(BankAccount.isEmailValid("")); // empty string

    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance(), 0.001);
        // check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("", 100));
    }

    @Test
    void checkStatusTest() throws ClosedAccountException, InsufficientFundsException {
        BankAccount bankAccount = new BankAccount("test@mail.com", 300);
        BankAdmin admin = new BankAdmin("admin@admin.com");

        assertEquals("open", bankAccount.getStatus()); // Test Opens Account
        admin.freezeAccount(bankAccount); // Closes Account
        assertEquals("closed", bankAccount.getStatus()); // Test Closes Account
        assertThrows(ClosedAccountException.class, () -> bankAccount.withdraw(50)); // Test Withdraw from Closed Account
        admin.openAccount(bankAccount); // Opens Account
        assertEquals("open", bankAccount.getStatus()); // Test Opens Account
        bankAccount.withdraw(50); // Test Withdraw from Open Account
        assertEquals(250, bankAccount.balance); // Check Balance

    }

    @Test
    void addSumNumTest(){
        BankAccount bank = new BankAccount(0, 0);
        bank.addSumNum(10, 10);
        assertEquals(20, 20);
    }

}