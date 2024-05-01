package entities;

public class Employee {

    private double salary;
    private int id;
    private String name;


    public Employee(double wage, String name, int id) {
        this.salary = wage;
        this.name = name;
        this.id = id;
    }


    public void salaryIncrease(double percent){
        double perc = 1 + percent / 100;


        salary *= perc;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
