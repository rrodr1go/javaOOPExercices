package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("How many employees will be registred?");
        int x = sc.nextInt();
        System.out.println();

        for (int i = 1; i <= x; i++) {
            System.out.println("Employee #" + i + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            employees.add(new Employee(id, name, salary));
            System.out.println();
        }

        System.out.println();
        System.out.print("Enter employee ID that will have salary increased: ");
        int id = sc.nextInt();

        Employee emp = employees.stream().filter(a -> a.getId() == id).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("This id does not exist!");
        }
        else {
            System.out.print("Enter the percentage: ");
            double pct = sc.nextDouble();
            emp.increaseSalary(pct);
        }

        System.out.println();
        System.out.println("List of employees:");
        for (Employee z : employees) {
            System.out.println(z);
        }

        sc.close();
    }
}
