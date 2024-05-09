package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Contract {
    private Integer number;
    private Date date;
    private Double totalValue;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public Contract(Integer number, Date date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    private List<Installment> installments = new ArrayList<>();

    public Integer getNumber() {
        return number;
    }

    public Date getDate() {
        return date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void addInstallment(Installment installment) {
        installments.add(installment);
    }

    public List<Installment> getInstallments() {
        return installments;
    }
}