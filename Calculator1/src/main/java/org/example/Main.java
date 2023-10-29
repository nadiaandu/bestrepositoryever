package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // accept the principal, interest rate, and loan length form user as input

        Scanner scanner = new Scanner(System.in);

        System.out.println("What's your desired principal (P)?");

        double principalRate = scanner.nextDouble();

        System.out.println("What is your desired annual interest rate (r)?");

        double annualInterestRate = scanner.nextDouble();

        System.out.println("What is your desired loan length in years (n)?");

        double loanLength = scanner.nextDouble();

        scanner.close();

        // calculate monthly interest rate as a decimal

        double monthlyInterestRate = (annualInterestRate / 12) /100;

        //calculating number of monthly payments

        double numberOfPayments = loanLength * 12;

        // use formula P[r(1+r)^n] / [1(1+r)^n-1)
        // P = principalRate
        // r = monthlyInterestRate
        // a = annualInterestRate
        // n = loanLength
        // math.pow is used to raise a number to a specific power
        // math.pow(1 + monthlyInterestRate, numberOfPayments) calculates (1+r)^n
        // which shows the effect of interest compounding over the loan's duration\
        // uses math.pow to raise the sum of 1 and the monthly interest rate to
        // the power of the number of monthly payments


        double monthlyPayments = principalRate*(monthlyInterestRate * Math.pow(1 + monthlyInterestRate,numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments)- 1);

        // monthlyInterestRate * math.pow(1 + monthlyInterestRate , numberOfPayments)
        // calculates the interest component of the monthly payment by * monthly
        // interest rate by the compounding factor

        // use formula: Total Interest = (M * n) - P
        double totalInterest = (monthlyPayments * numberOfPayments) - principalRate;


        //%2f is a format specifier used to indicate that it should be printed with 2 dec places
        // %n is a line separator used to move onto the next line after displaying the output

        System.out.printf("Monthly Payment is $%.2f%n", monthlyPayments);
        System.out.printf("Total interest paid: $%.2f%n", totalInterest);



    }
}