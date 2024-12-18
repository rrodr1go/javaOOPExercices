package application;

import entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serão digitadas? ");
        int n = sc.nextInt();

        Person[] vect = new Person[n];

        for (int i = 0; i < vect.length; i++) {
            System.out.println("Dados da " + (i+1) + "a pessoa:");
            sc.nextLine();
            System.out.print("Nome: ");
            String name = sc.nextLine();
            System.out.print("Idade: ");
            int age = sc.nextInt();
            System.out.print("Altura: ");
            double height = sc.nextDouble();

            vect[i] = new Person(name, age, height);
        }
        double sum = 0.0;

        for (int i = 0; i < vect.length; i++) {
            sum += vect[i].getHeight();
        }

        double avg = sum / vect.length;

        System.out.println();
        System.out.printf("Altura média: %.2f%n", avg);


        int under16 = 0;
        for (int i = 0; i < vect.length; i++) {
            if (vect[i].getAge() < 16)
                under16++;
        }
        double pctUnder16 = (double) under16 / vect.length * 100.0;
        System.out.printf("Pessoas com menos de 16 anos: %%%.2f%n", pctUnder16);
        for (int i = 0; i < vect.length; i++) {
            if (vect[i].getAge() < 16)
                System.out.println(vect[i].getPerson());
        }
    }
}
