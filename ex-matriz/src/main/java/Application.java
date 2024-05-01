import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.print("Enter the number line and columns");
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[][] matriz = new int[n][m];

        for (int i = 0; i <matriz.length; i++) {
            for (int j = 0; j <matriz[i].length; j++) {
                matriz[i][j] = scan.nextInt();
            }
        }
        System.out.print("Enter the number: ");
        int number = scan.nextInt();

        for (int i = 0; i <matriz.length; i++) {
            for (int j = 0; j <matriz[i].length; j++) {
                if(matriz[i][j] == number ){
                    System.out.println("Position " + i  +", " + j + ":");

                    if(matriz[i][(j-1)] != -1){
                        System.out.println("Left: " + matriz[i][(j-1)]);
                    }
                    if (!(j <= m)) {
                        System.out.println("Right: " + matriz[i][(j+1)]);
                    }
                    if (matriz[i+1][(j)] != -1) {
                        System.out.println("Down: " + matriz[i+1][(j)]);
                    }
                    if (i > 0) {
                        System.out.println("up: " + matriz[i-1][(j)]);
                    }
                    System.out.println();

                }
            }
        }
        scan.close();
    }
}




