package application;

import entities.CorporateEntity;
import entities.NaturalPerson;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();
            if (ch == 'i') {
                System.out.print("Health expenses: ");
                double healthExpenses = sc.nextDouble();

                taxPayers.add(new NaturalPerson(name, annualIncome, healthExpenses));
            } else {
                System.out.print("Number of employees: ");
                int employeesNo = sc.nextInt();

                taxPayers.add(new CorporateEntity(name, annualIncome, employeesNo));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        for (TaxPayer payer : taxPayers) {
            System.out.println(payer.getName() + ": $" + String.format("%.2f", payer.annualTax()));
        }

        System.out.println();
        double sum = 0;
        for (TaxPayer payer : taxPayers) {
            sum += payer.annualTax();
        }
        System.out.println("TOTAL TAXES: " + String.format("%.2f", sum));

        sc.close();
    }
}
