package org.example;

import java.sql.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a grade");
        int userInput = scanner.nextInt();
        System.out.println(userInput);

        if (userInput >= 90 && userInput <= 100) {
            System.out.println("A");
        } else if (userInput >= 80 && userInput <= 90) {
            System.out.println("B");
        } else if (userInput >= 70 && userInput <= 80) {
            System.out.println("B");
        } else if (userInput >= 65 && userInput <= 70) {
            System.out.println("B");
        } else {
            System.out.println("You failed!");
        }

    }
 }







