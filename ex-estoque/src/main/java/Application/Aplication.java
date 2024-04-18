package Application;

import entities.Products;

import java.util.Locale;
import java.util.Scanner;

public class Aplication {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        Products product = new Products();

        System.out.println("Enter the product name.");
        product.name = sc.next();

        System.out.println("Enter the price of the products.");
        product.price = sc.nextDouble();

        System.out.println("Enter the quantity of the product.");
        product.quantity = sc.nextInt();

        System.out.print("Product data: " + product);
        System.out.println();

        System.out.print("enter the number of products to be added in stock: ");
        int quantity = sc.nextInt();
        product.addProducts(quantity);

        System.out.print("");

        System.out.print("Product data: " + product);
        System.out.println();

        System.out.print("enter the number of products to be remove in stock: ");
        quantity = sc.nextInt();
        product.removeProducts(quantity);

        System.out.print("Product data: " + product);
        System.out.println();

        sc.close();
    }
}
