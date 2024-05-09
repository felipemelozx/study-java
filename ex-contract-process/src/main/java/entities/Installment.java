package entities;

import java.util.Date;

public class Installment {
    private Date douDate;
    private Double amount;

    public Installment(Date douDate, Double amount) {
        this.douDate = douDate;
        this.amount = amount;
    }

    public Date getDouDate() {
        return douDate;
    }

    public Double getAmount() {
        return amount;
    }
}
