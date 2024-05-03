package application;



import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client date:");
        System.out.print("Name: ");
        String name = scan.next();

        System.out.print("Email: ");
        String email = scan.next();

        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthday = sdf.parse(scan.next());

        Client client1 = new Client(name, email, birthday);


        System.out.println("Enter order date");
        System.out.print("Status: ");
        String status = scan.next();
        OrderStatus.valueOf(status);

        System.out.print("How many items to this order? ");
        int manyItems = scan.nextInt();

        Order order1 = new Order(client1);

        System.out.println(order1.getMoment());
        for (int i = 0; i < manyItems ; i++) {
            if(order1.getMoment() == null){
                order1.setMoment(new Date());
        }
            System.out.println("Enter #" + (i + 1) + " item data: ");
            System.out.print("Product name: ");
            String productName = scan.next();
            System.out.print("Enter the price: ");
            Double productPrice = scan.nextDouble();
            System.out.print("Quantity");
            int quantity = scan.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, productName);
            order1.addItem(orderItem);
        }

        System.out.println(order1);
        scan.close();
    }
}
