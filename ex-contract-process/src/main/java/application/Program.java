package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            System.out.println("Enter the contract date:");
            System.out.print("Number: ");
            Integer number = sc.nextInt();
            System.out.print("Data (dd/MM/yyy): ");
            Date date = sdf.parse(sc.next());
            System.out.print("Contract value: ");
            Double amount = sc.nextDouble();
            System.out.print("enter the number of installments ");
            Integer numberParc = sc.nextInt();

            Contract contract = new Contract(number, date, amount);
            ContractService service = new ContractService(new PaypalService());
            service.processContract(contract,numberParc);

            for (Installment instal: contract.getInstallments()){
                System.out.println(sdf.format(instal.getDouDate()));
                System.out.println( instal.getAmount());
            }
        } catch (Exception e) {
            System.out.println("Something went wrong" + e);
        }
    }
}
