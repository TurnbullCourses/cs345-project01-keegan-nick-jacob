package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

public class Customer {

    String name;
    public String email;
    String password;
    public ArrayList<BankAccount> personalAccounts;

    public Customer(String name, String email, String password){

        this.name = name;
        this.email = email;
        this.password = password;
        this.personalAccounts = new ArrayList<BankAccount>();

    }

    public void login(String email, String password, BankTeller teller) throws LoginFailedException{

        for(int i = 0; i<= teller.customerAccounts.size(); i++){
            if (teller.customerAccounts.get(i).email == email && teller.customerAccounts.get(i).password == password){
                for (int x = 0; x<= teller.customerAccounts.get(i).personalAccounts.size(); x++){
                    teller.customerAccounts.get(i).personalAccounts.get(x).status = "open";
                }
            } else{
                throw new LoginFailedException("No account in system");
            }

        }
    }
}
