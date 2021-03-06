
/*
BankTeller Class

//Developed by: by Jacob with updates by Nick 
Functions : openAccount - closeAccount - newCustomer
*/
package edu.ithaca.dturnbull.bank;
import java.util.ArrayList;

public class BankTeller {

    public ArrayList<Customer> customerAccounts;

    public BankTeller(){

        this.customerAccounts = new ArrayList<Customer>();

    }

    //needs testing 
    public void openAccount(String accountTypeIn, String customerEmail) throws invalidAccountTypeException{
        
        //if  there are accounts in customer accounts search for customers profile then add account to their account
        if(accountTypeIn.equals("Savings")){
            if (customerAccounts.size() > 0){
                SavingsAccount savings = new SavingsAccount(0, 0.06);
                for (int i=0; i < customerAccounts.size(); i++){
                    if (customerAccounts.get(i).email == customerEmail){
                        customerAccounts.get(i).personalAccounts.add(savings);
                    }
                }
            }
        }
        else if (accountTypeIn.equals("Checking")){

            if (customerAccounts.size() > 0){

                if (customerAccounts.size() > 0){
                    CheckingAccount checking = new CheckingAccount(0);
                    for (int i=0; i<= customerAccounts.size(); i++){
                        if (customerAccounts.get(i).email == customerEmail){
                            customerAccounts.get(i).personalAccounts.add(checking);
                        }
                    }
                }

            }
        }else{
            throw new invalidAccountTypeException("Invalid Account Type");
        }
    }
    public void closeAccount(String accountTypeIn, String customerEmail, int accountnum) throws invalidAccountTypeException{
        
        if(accountTypeIn.equals("Savings")){
            if (customerAccounts.size() > 0){
                for (int i=0; i<= customerAccounts.size(); i++){
                    if (customerAccounts.get(i).email == customerEmail){
                        customerAccounts.get(i).personalAccounts.remove(accountnum);
                    }
                }
            }
        }
        else if (accountTypeIn.equals("Checking")){

            if (customerAccounts.size() > 0){

                if (customerAccounts.size() > 0){
                    for (int i=0; i<= customerAccounts.size(); i++){
                        if (customerAccounts.get(i).email == customerEmail){
                            customerAccounts.get(i).personalAccounts.remove(accountnum);
                        }
                    }
                }

            }
            else{
                throw new invalidAccountTypeException("Invalid Account Type");
            }
        }
    }

    public void newCustomer(String name,String email,String password){

        Customer cust = new Customer(name,email,password);//creates new customer based on desired name, email, password
        customerAccounts.add(cust);//add new created customer 
    }

    
    
}

