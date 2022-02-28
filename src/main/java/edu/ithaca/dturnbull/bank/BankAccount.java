package edu.ithaca.dturnbull.bank;

public class BankAccount {

    public int ID;
    public double balance;
    public String status;
    public double interestRate;
    public double int1;
    public double int2;
    public double sum;

    public double addSumNum(double int1, double int2){
        //this function takes in 2 ints and adds them togehter
        sum = int2 + int1;
        return sum;
    }

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(double balance, double interestRate, int ID) {
        
        this.balance = balance;
        this.interestRate = interestRate;
        this.ID = ID;
        this.status = "open";

    }

    public double getBalance() {
        return balance;
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
    public static boolean isAmountValid(double amount) {
        // method takes in a double and checks amount of decimal points
        if (amount < 0) {
            return false;
        }
        if ((amount * 100) % 1 != 0) {
            return false;
        } else {
            return true;
        }
    }

    public void Deposit(double amount) throws InsufficientFundsException {
        // takes double amount and adds it to current balance
        if (isAmountValid(amount)) {
            balance += amount;
        }
        else {
            throw new InsufficientFundsException("Amount Not Valid");
        }
    }

    public void Transfer(BankAccount targetBank, double amount) throws InsufficientFundsException {
        // transfers double amount to another bankAccount obj
        if (isAmountValid(amount)){
            //withdraw(amount);
            targetBank.Deposit(amount);
        }
        else{
            throw new InsufficientFundsException("Amount Not Valid");
        }

    }

}