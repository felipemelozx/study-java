package application;

import entities.Company;
import entities.Individual;
import entities.TaxPay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<TaxPay> taxPayList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int numberPayers = sc.nextInt();

        for (int i = 1; i <= numberPayers; i++) {
            System.out.print("Tax payer #" + i + " data:");

            System.out.print("Individual or company (c/i)? ");
            char ch = sc.next().charAt(0);
            if(ch == 'i'){
                System.out.print("Name: ");
                String name = sc.next();

                System.out.print("Annual income: ");
                double annualIncome = sc.nextDouble();

                System.out.print("health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                taxPayList.add(new Individual(name, annualIncome, healthExpenditures));
            } else if (ch == 'c') {
                System.out.print("Name: ");
                String name = sc.next();

                System.out.print("Annual income: ");
                double annualIncome = sc.nextDouble();

                System.out.print("Number of employees: ");
                int numberEmployees = sc.nextInt();

                taxPayList.add(new Company(name,annualIncome, numberEmployees));
            }
        }
        System.out.println("TOTAL PAID:");
        double soma = 0.0;
        for (TaxPay pay: taxPayList){
            System.out.println(pay.getName() + ":  $ " + String.format("%.2f",pay.tax()));
            soma += pay.tax();
        }
        System.out.println("TOTAL TAXES: $ " + soma);
    }
}
