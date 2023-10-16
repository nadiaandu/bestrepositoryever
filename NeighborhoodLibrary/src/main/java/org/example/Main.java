package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Book[] bookArray = new Book[20];

        bookArray[0] = new Book(1, "12345", "Whispers of the past", false, "");
        bookArray[1] = new Book(2, "12346", "The lost city chronicles", false, "");
        bookArray[2] = new Book(3, "12347", "Eternal echoes", false, "");
        bookArray[3] = new Book(4, "12348", "Mystery at midnight manor", false, "");
        bookArray[4] = new Book(5, "12349", "Chronicles of the enchanted forest", false, "");
        bookArray[5] = new Book(6, "12356", "Forgotten Realms", false, "");
        bookArray[6] = new Book(7, "12357", "Revenge of the cybernetic queen", false, "");
        bookArray[7] = new Book(8, "12348", "The time traveler's dilemma", false, "");
        bookArray[8] = new Book(9, "98765", "Secrets of the alchemist's journal", false, "");
        bookArray[9] = new Book(10, "98764", "The haunting of blackwood house", false, "");
        bookArray[10] = new Book(11, "98732", "The quantum paradox", false, "");
        bookArray[11] = new Book(12, "98712", "Quest for the dragon's heart", false, "");
        bookArray[12] = new Book(13, "98745", "Curse of the crimson amulet", false, "");
        bookArray[13] = new Book(14, "98763", "Whispers in the wind", false, "");
        bookArray[14] = new Book(15, "98762", "The enigma of parallel worlds", false, "");
        bookArray[15] = new Book(16, "98761", "Sorcery and steel: a tale", false, "");
        bookArray[16] = new Book(17, "98722", "The lost heir of eldoria", false, "");
        bookArray[17] = new Book(18, "98733", "Darkness beyond the stars", false, "");
        bookArray[18] = new Book(19, "98744", "The labyrinth of dreams", false, "");
        bookArray[19] = new Book(20, "98756", "Legends of the crystal key", false, "");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose option 1,2,3: ");
        System.out.println("1- Show available books");
        System.out.println("2- Show checked out books");
        System.out.println("3- Exit");


        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1 - show available books");
            System.out.println("2 - show checked out books");
            System.out.println("3 - Exit closes out the application");
            System.out.println("Enter a command number: ");

            int command = scanner.nextInt();
            scanner.nextLine();



        switch (command) {


            case 1:
                showAvailableBooks();
                System.out.println("What do you want to do?");
                System.out.println(" 1 - Select a book to check out");
                System.out.println(" 2 - Exit - goes back to home screen");
                System.out.println("Enter a command number");
                break;

            case 2:
                showCheckedOutBooks();
                break;

            case 3:
                return;

            default:
                System.out.println("Enter a number from 1-3");

        }
        }


    }

    public static void showAvailableBooks() {
        Scanner scanner = new Scanner(System.in);
        boolean isCheckedOut = false;

    }

    public static void showCheckedOutBooks() {
        Scanner scanner = new Scanner(System.in);
        boolean





    }
}
