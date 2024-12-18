package application;

import models.entities.Account;
import models.exceptions.DomainExceptions;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double amount = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double limit = sc.nextDouble();

        Account acc1 = new Account(number, holder, amount, limit);
        System.out.println(acc1);

        try {
            System.out.println();
            System.out.print("Enter amount to withdraw: ");
            amount = sc.nextDouble();
            acc1.withdraw(amount);

            System.out.print("Updated info - " + acc1);
        }
        catch (DomainExceptions e) {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println("Input error.");
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error, try again.");
        }
        sc.close();

    }
}
