package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What's your desired principal?");

        double principalRate = scanner.nextDouble();

        System.out.println("What is your desired interest rate?");

        double interestRate = scanner.nextDouble();

        System.out.println("What is your desired loan length?");

        double loanLength = scanner.nextDouble();

        System.out.println("Enter Annual interest rate");

        double annualInterestRate = scanner.nextDouble();

        // next part

        double monthlyInterestRate = (annualInterestRate / 12) /100;

        //

        double numberOfPayments = loanLength * 12;

        //

        double monthlyPayments = principalRate*(interestRate * Math.pow(1 + interestRate,numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments)- 1);
        double totalInterest = (monthlyPayments + numberOfPayments) * principalRate;


        //

        System.out.printf("Monthly Payment is %.2f%n", monthlyPayments);
        System.out.printf("Total interest paid: %.2f%n", totalInterest);



    }
}