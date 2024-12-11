package application;

import entities.Rent;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Rent[] rooms = new Rent[10];

        System.out.print("How many rooms will be rented? ");
        int n = sc.nextInt();


        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println("Rent #" + (i +1));
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Room: ");
            int room = sc.nextInt();
            rooms[room] = new Rent(name, email, room);
            System.out.println();
        }

        System.out.println();
        System.out.println("Busy rooms:");
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] != null) {
                System.out.println(rooms[i]);
            }
        }



    }
}
