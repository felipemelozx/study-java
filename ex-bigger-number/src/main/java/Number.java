import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("how many numbers will you enter: ");
        int amount = scan.nextInt();

        double[] number = new double[amount];

        for (int i = 0; i < number.length; i++) {
            System.out.print("Enter a number: ");
            number[i] = scan.nextDouble();
        }
        double bigger = 0.0;
        int index = 0;
        for (int i = 0; i < number.length ; i++) {
            if(number[i] > bigger ){
                bigger = number[i];
                index = i;
            }
        }
        System.out.println("Bigger value = " + bigger);
        System.out.println("position of the largest number =  " + index);

        scan.close();
    }

}
