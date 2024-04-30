package application;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Quantas pessoas: ");
        int people = scan.nextInt();


        String[] names = new String[people];
        int[] years = new int[people];
        double[] heights = new double[people];

        for(int i = 0; i <  people; i++ ){
            System.out.println("Dados da " +(i+1) + "a pessoa");

            System.out.print("Name: ");
            names[i] = scan.next();

            System.out.print("Year: ");
            years[i] = scan.nextInt();

            System.out.print("Height: ");
            heights[i] = scan.nextDouble();

        }
        double soma = 0;
        for (int i = 0; i < people; i++) {
            soma += heights[i];
        }
        double average = soma / people;
        System.out.printf("Average height: %.2f", average);
        System.out.println();

        double percentForOne = 100.0 / people;
        double percent = 0.0;

        for (int i = 0; i < people; i++) {
            if(years[i] < 16){
                percent += percentForOne;
            }
        }

        System.out.printf("People under 16: %.2f%%\n", percent);
        for (int i = 0; i < people; i++) {
            if(years[i] < 16){
                System.out.println(names[i]);
            }
        }

        scan.close();
    }
}
