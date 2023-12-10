package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        String[] fortunes = {" A beautiful, smart, and loving person will be coming into your life",
                "A dubious friend may be an enemy in camouflage", "A faithful friend is a strong defense",
                "A fresh start will put you on your way", "A friend asks only for your time not your money",
                "A golden egg of opportunity falls into your lap this month", "A pleasant surprise is waiting for you"};

        Random random = new Random();
        int r = random.nextInt(fortunes.length);
        System.out.println(fortunes[r]);
    }
}