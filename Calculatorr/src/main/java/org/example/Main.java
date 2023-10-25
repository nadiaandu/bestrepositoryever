package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // when
    public static void main(String[] args) {
        System.out.println("What is the first number?");
        Scanner scanner = new Scanner(System.in);

        try{
            double userInput1 = scanner.nextDouble();
            System.out.println("What is the second number?");
            double userInput2 = scanner.nextDouble();
            double quotient = userInput1/userInput2;
            System.out.println("The result is " + quotient);

        }
        catch(ArithmeticException ex){
            System.out.println("Hey can't divide by zero");
        }
        catch (InputMismatchException ex){
            System.out.println("I need a number!");
        }
        System.out.println("Thanks for using my calculator!");

    }
}