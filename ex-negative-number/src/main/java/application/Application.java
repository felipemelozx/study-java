package application;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("How many numbers will you enter? ");
        int rep = scan.nextInt();

        if(rep > 10 || rep < 0){
            System.out.println("Number invalid.");
            System.out.print("How many numbers will you enter? ");
            rep = scan.nextInt();
        }
        int[] numbers = new int[rep];
        for(int i = 0; i < numbers.length; i++){
            System.out.print("Enter a number ");
            numbers[i] = scan.nextInt();
        }
        System.out.println("Negative: ");
        for(int i = 0; i < numbers.length; i++ ){
            if(numbers[i] < 0){
                System.out.println(numbers[i]);
            }
        }
    scan.close();
    }
}
