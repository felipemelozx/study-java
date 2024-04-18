package Application;

import entities.Retangulo;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Retangulo retangulo = new Retangulo();

        System.out.println("Enter rectangle width and height:");
        retangulo.width = scan.nextDouble();
        retangulo.height = scan.nextDouble();

        retangulo.CalculationArea();
        retangulo.Perimeter();
        retangulo.Diagonal();
        System.out.print(retangulo);
        scan.close();
    }
}
