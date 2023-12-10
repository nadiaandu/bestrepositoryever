package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Hello, how many stars would you like?");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();


        for (int row = 1; row <= userInput; row++) { // takes care of rows
            for (int column = 0; column < row; column++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int row = userInput - 1; row > 0; row--) {
            for (int column = 0; column < row; column++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}