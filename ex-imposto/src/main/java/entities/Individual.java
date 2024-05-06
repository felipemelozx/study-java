package entities;

public class Individual extends TaxPay {
    private Double healthExpenditures;

    public Individual(String name, double incomeAnnual, Double healthExpenditures) {
        super(name, incomeAnnual);
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        Double tax = (double) 0;
        if(getIncomeAnnual() < 20000){
            if(healthExpenditures != 0){
                tax = (getIncomeAnnual() * 0.15) - (healthExpenditures * 0.50);
            }
        }else {
            tax = (getIncomeAnnual() * 0.25) - (healthExpenditures * 0.50);
        }
        return  tax;
    }
}
