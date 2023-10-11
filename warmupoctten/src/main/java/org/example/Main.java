package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your numerical score: ");
        int numScore = scanner.nextInt();

        if (numScore < 0 || numScore > 100) {
            System.out.println("Enter a number between 0-100");
        } else if (numScore >= 90 && numScore <= 100) {
            System.out.println("You got an A");
        } else if (numScore >= 80 && numScore <= 89) {
            System.out.println("You got a B");
        } else if (numScore >= 70 && numScore <= 79) {
            System.out.println("You got a C");
        } else if (numScore >= 60 && numScore <= 69) {
            System.out.println("You got a D");
        } else {
            System.out.println("You got an F");
        }
        scanner.close();
    }
}

