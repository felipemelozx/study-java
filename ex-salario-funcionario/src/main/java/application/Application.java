package application;

import entities.Employee;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Employee employee = new Employee();

        System.out.print("Name: ");
        employee.name = scan.next();

        System.out.print("Gross salary: ");
        employee.grossSalary = scan.nextDouble();

        System.out.print("Tax: ");
        employee.tax = scan.nextDouble();

        System.out.println("Employee: " + employee.name + ", $ " + employee.netSalary());

        System.out.print("Which percentage to increase salary?");
        double percentage = scan.nextDouble();
        employee.increaseSalary(percentage);

        System.out.println("Updated data: " + employee.name + ", $ " + employee.grossSalary);

        scan.close();
    }
}
