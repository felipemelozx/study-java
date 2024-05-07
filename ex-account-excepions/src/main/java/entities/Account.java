package entities;

import exceptions.BusinessException;

public class Account {
    private String hold;
    private int accountNumber;
    private double balance;
    private double withdrawLimit;

    public Account(){
    }
    public Account(String hold, int accountNumber, double balance, double withdrawLimit) {
        this.hold = hold;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount) throws Exception {
        validateWithdraw(amount);
        balance -= amount;
    }
    private void validateWithdraw(double amount) {
        if (amount > getWithdrawLimit()) {
            throw new BusinessException("Withdrawal error: Amount exceeds withdrawal limit");
        }
        if (amount > getBalance()) {
            throw new BusinessException("withdrawal error: insufficient balance");
        }
    }
    public void setHold(String hold) {
        this.hold = hold;
    }

    public String getHold() {
        return hold;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }
    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
}
