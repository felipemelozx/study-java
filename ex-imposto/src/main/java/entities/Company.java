package entities;

public class Company extends  TaxPay{
    private  int numberOfEmployees;

    public Company(String name, double incomeAnnual, int numberOfEmployees) {
        super(name, incomeAnnual);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double tax() {
        double tax;
        if(numberOfEmployees < 10){
            tax = (getIncomeAnnual() * 0.16);
        }else {
            tax = (getIncomeAnnual() * 0.14);
        }
        return  tax;
    }
}
