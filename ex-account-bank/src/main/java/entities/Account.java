package entities;

public class Account {
    private String name;
    private int accountNumber;
    private double balance;
    private final double tax = 5.0;

    public Account(String name, int accountNumber) {
        this.accountNumber = accountNumber;
        this.name = name;
    }
    public Account(String name, int accountNumber, double value) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = value;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposit(double value){
        balance += value;
    }

    public void withdraw(double value){
        balance -= value + tax;
    }


    public String toString(){
        return
                "Account " + this.accountNumber +
                ", Holder: " + this.name +
                "Balance: $ " + this.balance;
    }

}
