package edu.ithaca.dturnbull.bank;

public class BankAccount {

    public String email;
    public double balance;
    public String status;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance) {
        if (isEmailValid(email)) {
            this.email = email;
            this.balance = startingBalance;
            this.status = "open";
        } else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
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

    public static boolean isEmailValid(String email) {
        if (email.indexOf('@') == -1) {
            return false;
        } else {
            return true;
        }
    }
}