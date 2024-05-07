package application;

import entities.Account;

import java.util.Scanner;

public class Application {
    public static void main(String[] args)  {
        try{
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the account data:");
            System.out.print("Number: ");
            int accountNumber = sc.nextInt();
            System.out.print("Holder: ");
            String holder = sc.next();
            System.out.print("Initial balance: ");
            double initialDeposit = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();
            Account account = new Account(holder, accountNumber, initialDeposit, withdrawLimit);

            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();

            account.withdraw(amount);
            System.out.println("New balance: " + account.getBalance());
            sc.close();
        }catch (Exception err){
            System.out.println("Withdraw err:" + err.getMessage());
        }
    }
}
