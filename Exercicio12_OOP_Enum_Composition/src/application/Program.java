package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (dd/MM/yyyy): ");
        String stringBirth = sc.nextLine();
        LocalDate birthDate = LocalDate.parse(stringBirth, frmt);

        Client client1 = new Client(name, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.nextLine();

        Order order1 = new Order(LocalDateTime.now(), OrderStatus.valueOf(status), client1);

        System.out.print("How many items to this order?");
        int x = sc.nextInt();

        for (int i = 1; i <= x; i++) {
            System.out.println("Enter item #" + i + " data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(productName, price);
            OrderItem orderItem = new OrderItem(quantity, price, product);
            order1.addItem(orderItem);
        }

        System.out.println();
        System.out.println(order1);

        sc.close();
    }
}
