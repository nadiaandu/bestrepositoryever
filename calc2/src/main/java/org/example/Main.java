package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How much is your initial deposit?");
        double initialDeposit = scanner.nextDouble();

        System.out.print("What is your annual interest rate?");
        double annualInterest = scanner.nextDouble();
        double dailyRate = annualInterest / 365 / 100;
        int compounds = 365;

        System.out.print("How many years would you like to invest for?");
        double investmentYears = scanner.nextDouble();

        //Fv

        double futureValue = initialDeposit * Math.pow(1 + dailyRate / compounds, compounds * investmentYears);
        double totalInterest = futureValue - initialDeposit;

        // result

        System.out.printf("The future value of your compound is $%.2f%n", futureValue);
        System.out.printf("The total interest you have earned is $%.2f%n", totalInterest);

    }}