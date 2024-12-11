package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int number = sc.nextInt();
        System.out.print("Enter account holder: ");
        sc.nextLine();
        String holder = sc.nextLine();

        Account account1 = new Account(number, holder);

        System.out.print("Is there an initial deposit value (y/n)? ");
        char answer = sc.next().charAt(0);

        double depositeValue = 0;
        if (answer == 'y') {
            System.out.print("Enter initial deposite value: ");
            depositeValue = sc.nextDouble();
            account1.deposit(depositeValue);
        }

        System.out.println();
        System.out.println("Account data: ");
        System.out.println(account1.toString());

        System.out.println();
        System.out.print("Enter a deposite value: ");
        depositeValue = sc.nextDouble();
        account1.deposit(depositeValue);
        System.out.println("Updated data: ");
        System.out.println(account1.toString());

        System.out.println();
        System.out.print("Enter a withdraw value: ");
        double withdrawValue = sc.nextDouble();
        account1.withdraw(withdrawValue);
        System.out.println("Updated data: ");
        System.out.println(account1.toString());
    }
}
