package application;

import util.CurrencyCoverter;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the dollar price? ");
        double dollarPrice = sc.nextDouble();

        System.out.print("How many dollars will you be bought? ");
        double dollarsBought = sc.nextDouble();

        System.out.printf("Amount to be paid in reais: %.2f%n",
                CurrencyCoverter.reaisPrice(dollarPrice, dollarsBought));

    }
}
