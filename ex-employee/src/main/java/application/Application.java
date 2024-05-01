package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        List<Employee> employees = new ArrayList <>();

        System.out.print("How many employees will be registered? ");
        int employee = scan.nextInt();

        for (int i = 0; i <  employee; i++) {
            System.out.println("Employee #" + (i+1) + ":");

            System.out.print("id: ");
            int id = scan.nextInt();

            System.out.print("name: ");
            String name = scan.next();

            System.out.print("Salary: ");
            double salary = scan.nextDouble();

            boolean idJaExiste = false;
            for (Employee employ : employees) {
                if (employ.getId() == id) {
                    idJaExiste = true;
                    System.out.println("ID já existe!!");
                    break;
                }
            }
            if(!idJaExiste){
                employees.add(new Employee(salary, name , id));
            }
        }

        System.out.print("Enter the employee id that will have salary increase : ");
        int idSearch = scan.nextInt();
        System.out.print("Enter the percentage: ");
        double percent = scan.nextDouble();


        System.out.println("List of Employee: ");

        for(Employee employ: employees){
            if(employ.getId() == idSearch){
                employ.salaryIncrease(percent);
                break;
            }
        }
        for (Employee employ : employees){
            System.out.print(employ.getId() + ", " + employ.getName() + ", " + employ.getSalary());
            System.out.println();
        }

    scan.close();
    }
}
