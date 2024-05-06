package entities;

public abstract  class TaxPay {
    private String name;
    private double incomeAnnual;

    public TaxPay(String name, double incomeAnnual) {
        this.name = name;
        this.incomeAnnual = incomeAnnual;
    }

    public double getIncomeAnnual() {
        return incomeAnnual;
    }

    public void setIncomeAnnual(double incomeAnnual) {
        this.incomeAnnual = incomeAnnual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

public abstract Double tax();

}
