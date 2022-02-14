
package edu.ithaca.dturnbull.bank;



public class SavingsAccount extends BankAccount{


    public SavingsAccount(double balance, double interest){

        super(balance, interest);
    }

    public double calculateinterest(){

        double monthlyRate;
        double Interest;

        monthlyRate = interestRate /12;
        Interest = balance * monthlyRate;
        balance = balance + Interest;
        return balance;
    }

}