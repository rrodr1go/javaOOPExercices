package application;

import models.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file path: "); //C:\Users\rodri\IdeaProjects\javaExercices\Exercice17_OOP_Files\FileReaderExercice\input.csv
        String sourceFileStr = sc.nextLine();

        List<Product> productList = new ArrayList<>();

        File file = new File(sourceFileStr);
        String sourceFolderStr = file.getParent();

        boolean success = new File(sourceFolderStr + "\\out").mkdir();
        System.out.println("Folder created: " + success);
        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";


        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                String[] attributes = line.split(",");
                String name = attributes[0];
                double price = Double.parseDouble(attributes[1]);
                int quantity = Integer.parseInt(attributes[2]);

                productList.add(new Product(name, price, quantity));

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        System.out.println("---------------------------");
        System.out.println("Product list on system: ");
        for (Product p : productList) {
            System.out.println(p);
        }

        System.out.println("---------------------------");
        System.out.println("Criando o arquivo summary.csv");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){
            for (Product p : productList) {
                bw.write(p.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error creating summary.csv: " + e.getMessage());
        }
    }
}
