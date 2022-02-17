package edu.ithaca.dturnbull.bank;

public class BankTeller {
    
    private BankAccount[] accounts;

    public BankTeller(BankAccount[] accountsIn){

        accounts = accountsIn;

    }

    public void openAccount(String accountTypeIn){
        if(accountTypeIn.equals("Savings")){
            SavingsAccount savings = new SavingsAccount(0, 0.06);
        }
        else if (accountTypeIn.equals("Checking")){
            CheckingAccount checking = new CheckingAccount(0);
        }
    }

    
    
}

