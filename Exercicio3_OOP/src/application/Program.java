package application;

import entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Student student1 = new Student();

        student1.name = sc.nextLine();
        student1.grade1 = sc.nextDouble();
        student1.grade2 = sc.nextDouble();
        student1.grade3 = sc.nextDouble();

        student1.finalGrade();
        student1.missingPoints();

        System.out.println();
        System.out.printf("Final grade: %.2f\n", student1.finalGrade());

        if (student1.finalGrade() < 60.0) {
            System.out.println("FAILED");
            System.out.printf("MISSING %.2f POINTS", student1.missingPoints());
        }
        else {
            System.out.println("PASS");
        }


    }
}
