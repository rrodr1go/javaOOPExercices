package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Elemento [" + i + "][" + j +"]:");
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Number to inspect: ");
        int x = sc.nextInt();

        if (!findNeighbors(matrix, x)) {
            System.out.println("Número " + x + " não encontrado na matriz.");
        }

        sc.close();
    }

    public static boolean findNeighbors(int[][] matrix, int x) {
        boolean found = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == x) {
                    found = true;
                    System.out.println("Position " + i + "," + j + ":" );

                    if (j > 0){
                        System.out.println("Left: " + matrix[i][j-1]);
                    }
                    if (j < matrix[i].length-1) {
                        System.out.println("Right: " + matrix[i][(j+1)]);
                    }
                    if (i > 0) {
                        System.out.println("Up: " + matrix[(i-1)][j]);
                    }
                    if (i < matrix.length-1) {
                        System.out.println("Down: " + matrix[(i+1)][(j)]);
                    }
                    System.out.println();
                }
            }
        }
        return found;
    }
}
