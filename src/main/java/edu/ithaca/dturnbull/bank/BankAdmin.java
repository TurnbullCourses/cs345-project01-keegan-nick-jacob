package edu.ithaca.dturnbull.bank;

/*
Admin Class

Written by: Keegan with updates by Nick 
Functions : Freeze/Unfreeze - CheckAllBalance - CheckAccountType
*/

//Admin Account can Open/Close bankAccount Objects
public class BankAdmin {

    // Init vars
    public String status;

    public BankAdmin() {
    }

    // Method will Open a Closed Account
    public void openAccount(BankAccount bankAccount) {
        bankAccount.status = "open";
    }

    // Method will Freeze a Open Account
    public void freezeAccount(BankAccount bankAccount) {
        bankAccount.status = "closed";
    }

    // Method will getStatus
    public String getStatus(BankAccount bankAccount) {
        return bankAccount.status;
    }

}
