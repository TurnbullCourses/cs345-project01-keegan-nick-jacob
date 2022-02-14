package edu.ithaca.dturnbull.bank;

public class BankAccount {

    public String email;
    public double balance;
    public String status;
    public double interestRate;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(double balance, double interestRate) {
        
        this.balance = balance;
        this.interestRate = interestRate;
         
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    /**
     * @throws ClosedAccountException
     * @post reduces the balance by amount if amount is non-negative and smaller
     *       than balance
     */
    public void withdraw(double amount) throws InsufficientFundsException, ClosedAccountException {
        if (this.status == "open") {
            if (amount <= balance) {
                balance -= amount;
            } else {
                throw new InsufficientFundsException("Not enough money");
            }
        } else {
            throw new ClosedAccountException("The Account is Frozen");
        }
    }

}