package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome To Basic Calculator");

        System.out.println("Enter the first number");

        Scanner scanner = new Scanner(System.in);
        float firstNumber = scanner.nextFloat();

        System.out.println("Enter the second number:");
        float secondNumber = scanner.nextFloat();

        System.out.println("Possible Calculations");
        System.out.println("(A)dd");
        System.out.println("(S)ubtract");
        System.out.println("(M)ultiply");
        System.out.println("(D)ivide");
        System.out.println("Please select an option");
        String answer = scanner.next();

        if (answer.equalsIgnoreCase(("A") {
        float sum = firstNumber + secondNumber;
        System.out.printf("%.2f  %.2f = %.2f", firstNumber, secondNumber, sum);
    }   if (answer.equalsIgnoreCase(("S") {
        float subtract = firstNumber - secondNumber;
        System.out.printf("%.2f - %.2f = %.2f", firstNumber, secondNumber, subtract);
    }  if (answer.equalsIgnoreCase(("M") {
        float multiply = firstNumber * secondNumber;
        System.out.printf("%.2f * %.2f = %.2f", firstNumber, secondNumber, multiply);
}    if (answer.equalsIgnoreCase(("D"){
        System.out.printf("%.2f / %.2f = %.2f", firstNumber, secondNumber , divide);
} if{
System.out.println("not an option");

        }


}



      }






























