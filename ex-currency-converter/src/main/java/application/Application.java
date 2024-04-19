package application;

import util.CurrencyConverter;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("What is the dollar price?");
        double dollarValue = scan.nextDouble();

        System.out.print("How many dollars will be bought?");
        double amountValue = scan.nextDouble();
        double amount = CurrencyConverter.converterDollarToReal(dollarValue, amountValue);
        System.out.printf("Amount to be paid in reais = %.2f", amount);
    }
}
