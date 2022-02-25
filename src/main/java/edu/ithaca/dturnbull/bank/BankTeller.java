package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

public class BankTeller {

    private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    public BankTeller(ArrayList<BankAccount> accountsIn){
        accounts = accountsIn;
    }

    public void openAccount(String accountTypeIn){
        if(accountTypeIn.equals("Savings")){
            SavingsAccount savings = new SavingsAccount(0, 0.06);
            savings.ID = accounts.size()+1;
            accounts.add(savings);
        }
        else if (accountTypeIn.equals("Checking")){
            CheckingAccount checking = new CheckingAccount(0);
            checking.ID = accounts.size()+1;
            accounts.add(checking);
        }
    }

    public void closeAccount(int accountTypeIn){
        for (int x = 0; x <= accounts.size(); x++){
            if (accounts.get(x).ID == accountTypeIn){
                accounts.remove(x);
            }
        }
    }

    
    
}

