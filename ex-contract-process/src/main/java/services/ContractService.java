package services;

import entities.Contract;
import entities.Installment;
import interfaces.OnlinePaymentService;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;


    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }


    public void processContract(Contract contract, Integer months){
        Double parc = contract.getTotalValue() / months;
        Double tax = 0.0;

        for (int i = 1; i <= months; i++) {
            Double interest =  onlinePaymentService.interest(parc, i);
            Double fee = onlinePaymentService.paymentFee(parc + interest);

            Double soma = parc + interest + fee;

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(contract.getDate());
            calendar.add(Calendar.DAY_OF_MONTH, (30 * i));
            contract.getInstallments().add(new Installment(calendar.getTime(), soma));
        }
    }
}
