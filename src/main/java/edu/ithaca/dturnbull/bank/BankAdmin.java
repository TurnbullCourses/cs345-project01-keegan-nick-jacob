package edu.ithaca.dturnbull.bank;

//Admin Account can Open/Close bankAccount Objects
public class BankAdmin {

    // Init vars
    public String status;
    public String email;

    public BankAdmin(String email) {
        this.email = email;
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
    public String getStatus() {
        return status;
    }

}
