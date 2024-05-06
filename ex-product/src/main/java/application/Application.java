package application;

import entities.ImportProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();

        System.out.print("Enter the number of product: ");
        int numberProduct = sc.nextInt();

        for (int i = 1; i <= numberProduct ; i++) {
            System.out.println("Product #" + i + " data: ");
            System.out.print("Common, used or imported (c/u/i)");
            char ch = sc.next().charAt(0);

            switch (ch){
                case 'c':
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Price: ");
                    Double price = sc.nextDouble();
                    productList.add(new Product(name, price));
                    break;
                case 'i':
                    System.out.print("Name: ");
                    String nameImport = sc.next();
                    System.out.print("Price: ");
                    Double priceImport = sc.nextDouble();
                    System.out.print("Customs fee: ");
                    Double customsFee = sc.nextDouble();
                    productList.add(new ImportProduct(
                            nameImport,
                            priceImport,
                            customsFee));
                    break;
                case 'u':
                    System.out.print("Name: ");
                    String nameUsed = sc.next();
                    System.out.print("Price: ");
                    Double priceUsed = sc.nextDouble();
                    System.out.print("manufacture date (DD/MM/YYYY): ");
                    Date manufactureDate = sdf.parse(sc.next());
                    productList.add(new UsedProduct(
                            nameUsed,
                            priceUsed,
                            manufactureDate
                            ));
                    break;
            }
        }
        System.out.println("PRICE TAGS: ");
        for (Product prod: productList){
            System.out.println(prod.priceTag());
        }
        sc.close();
    }
}
