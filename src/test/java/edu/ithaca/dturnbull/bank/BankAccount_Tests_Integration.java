package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BankAccount_Tests_Integration {


    
    /*
    test: addAccounts();
    create customer and add accounts be sure to check both BankTeller class along 
    with Customer class to make sure they work together
    */
    @Test
    void addCustomers(){

        BankTeller newTeller = new BankTeller();//cretaes new bank 
        newTeller.newCustomer("nick", "nicholas@gmail.com", "goodday");
        newTeller.newCustomer("keegan", "keegan@gmail.com", "goodday");
        newTeller.newCustomer("jacob", "jacob@gmail.com", "goodday");

        assertEquals("nicholas@gmail.com", newTeller.customerAccounts.get(0).email);
        assertEquals("keegan@gmail.com", newTeller.customerAccounts.get(1).email);
        assertEquals("jacob@gmail.com", newTeller.customerAccounts.get(2).email);
        assertEquals(3, newTeller.customerAccounts.size());


    }

    @Test
    void addCustomerAccounts(){

        Customer nick = new Customer("nick", "nicholasisaacs4@gmail.com", "goodday");
        assertEquals("nick", nick.name); 
        assertEquals("nicholasisaacs4@gmail.com", nick.email);
        assertEquals("goodday", nick.password);

    }

    @Test
    void checkStatusTest() throws ClosedAccountException, InsufficientFundsException {
        BankAccount bankAccount = new BankAccount(300,0.06,1);
        BankAdmin admin = new BankAdmin();
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
    void LoginTest() throws LoginFailedException{

        BankTeller newTeller = new BankTeller();//cretaes new bank 
        newTeller.newCustomer("nick", "nicholas@gmail.com", "goodday");
        newTeller.openAccount("Savings","nicholas@gmail.com");
        newTeller.openAccount("Checkings","nicholas@gmail.com");
        assertEquals("nicholas@gmail.com", newTeller.customerAccounts.get(0).email);
        assertThrows(LoginFailedException.class, () ->  newTeller.customerAccounts.get(0).login("nicholasiaacs4@gmail.com","goodday",newTeller));
        assertThrows(LoginFailedException.class, () ->  newTeller.customerAccounts.get(0).login("nicholasiaacs4@gmail.com","goday",newTeller));
        assertThrows(LoginFailedException.class, () ->  newTeller.customerAccounts.get(0).login("nicsmail.com","goodday",newTeller));
        assertThrows(LoginFailedException.class, () ->  newTeller.customerAccounts.get(0).login("a","b",newTeller));
        assertEquals("closed", newTeller.customerAccounts.get(0).personalAccounts.get(0).status);

    }
}s
