package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter your question if you dare...");
        Scanner userInput = new Scanner(System.in); // system in another name for what is in console
        userInput.nextLine(); // gets next word from console window
        userInput.close();

        Random rand = new Random();
        int random = rand.nextInt(5); // brings in a random number generator. # in parentheses is 0-5 as the range
        System.out.println(random);

        if (random == 0){
            System.out.println("no way in hell!");
        } else if(random == 1){
            System.out.println("yes but you knew that..");
        } else if(random == 2){
            System.out.println("hazy.. try again!");
        }else if(random == 3){
            System.out.println("why yes of course..");
        }

    }
}