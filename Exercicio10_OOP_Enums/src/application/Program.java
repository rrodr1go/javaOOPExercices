package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String department = sc.nextLine();
        System.out.println("Enter Worker data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        String level = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker1 = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Departament(department));

        System.out.print("How many contracts for this worker? ");
        int xx = sc.nextInt();

        for (int i = 1; i <= xx; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Data (DD/MM/YYYY): ");
            sc.nextLine();
            String data1 = sc.nextLine();
            LocalDate contractDate = LocalDate.parse(data1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("Value per hour: ");
            double value = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int duration = sc.nextInt();
            HourContract contract = new HourContract(contractDate, value, duration);
            worker1.addContract(contract);
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        sc.nextLine();
        String data2 = sc.nextLine();

        int year = Integer.parseInt(data2.substring(0, 2));
        int month = Integer.parseInt(data2.substring(3));

        System.out.println("Name: " + worker1.getName());
        System.out.println("Departament: " + worker1.getDepartment().getName());
        System.out.println("Income for " + data2 + ": " + String.format("%.2f", worker1.income(year, month)));


        sc.close();
    }
}
