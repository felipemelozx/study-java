package application;

import entities.People;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.print("How many rooms will be rented? ");
        int amount = scan.nextInt();
        People[] rooms = new People[amount];

        for (int i = 0; i <rooms.length ; i++) {
            System.out.println("Rent #" + (i + 1) + ": ");
            System.out.print("Name: ");
            String name = scan.next();

            System.out.print("Email: ");
            String email = scan.next();

            System.out.print("Room: ");
            int numeberRoom = scan.nextInt();

            rooms[numeberRoom] = new People(name, email, numeberRoom);
        }
        for (int i = 0; i < rooms.length ; i++) {
            if(rooms[i] != null){
                System.out.println(
                        rooms[i].getNumberRoom() + ": "
                        + rooms[i].getName() + ", "
                        + rooms[i].getEmail()
                );
            }
        }
    }
}
