package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("How old are you?");
        Scanner scanner = new Scanner(System.in);

        // try catch ex

        try {
            int userInput = scanner.nextInt();
            System.out.println("You are " + userInput + " years old.");

        }
        catch(Exception ex){
            System.out.println("That is not an integer try again.");
    }

        System.out.println("See you later!");

    }}