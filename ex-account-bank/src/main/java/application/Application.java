package application;


import entities.Account;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int accountNumber = scan.nextInt();

        System.out.print("Enter account holder: ");
        String name = scan.next();

        System.out.print("Is there na initial deposit (y/n)? ");
        char initialDeposit = scan.next().charAt(0);

        initialDeposit = Character.toLowerCase(initialDeposit);
        Account account = new Account(name, accountNumber);

        if(initialDeposit == 'y'){
            System.out.print("Enter initial deposit value: ");
            double value = scan.nextDouble();
            account.deposit(value);
        }
            System.out.println("Account data:");
            System.out.println(account);

            System.out.print("Enter a deposit value: ");
            double value = scan.nextDouble();
            account.deposit(value);

            System.out.println("Account data:");
            System.out.println(account);

            System.out.print("Enter a deposit value: ");
            value = scan.nextDouble();
            account.withdraw(value);

            System.out.println("Account data:");
            System.out.println(account);
        scan.close();
    }
}
