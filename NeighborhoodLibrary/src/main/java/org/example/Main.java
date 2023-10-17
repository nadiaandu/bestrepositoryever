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

        while (true) {
            System.out.println("Welcome to The Neighborhood Library Home Screen!");
            System.out.println("Please select an option:");
            System.out.println("1- Show available books.");
            System.out.println("2- Show checked out books.");
            System.out.println("3- Exit");
            int userSelection = scanner.nextInt();

            switch (userSelection) {
                case 1:
                    displayAvailableBooks(bookArray); // Pass the bookArray to the method
                    break;
                case 2:
                    displayCheckedOutBooks(bookArray); // Pass the bookArray to the method
                    break;
                case 3:
                    System.out.println("Thank you, have a great day!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("I'm sorry, that is not a valid response. Please choose either 1, 2, or 3.");
                    break;
            }
        }
    }

    public static void displayAvailableBooks(Book[] books) { // Pass the bookArray as a parameter
        Scanner scanner = new Scanner(System.in);

        while (true) {
            boolean availBooks = false;

            for (Book book : books) { // Iterate over the bookArray
                if (book != null && !book.isCheckedOut()) { // Check for null and availability
                    System.out.println("ID: " + book.getBookId() + ", Title: " + book.getBookTitle());
                    availBooks = true;
                }
            }

            if (!availBooks) {
                System.out.println("Sorry, no books are available at the moment.");
                break;
            }

            System.out.println("Please make your selection by typing the title of the book desired: ");
            System.out.println("Or enter 0 to go back to The Neighborhood Library Home Screen.");
            String titleOfBook = scanner.nextLine();

            if (titleOfBook.equals("0")) {
                break;
            }

            boolean bookFound = false;
            for (Book book : books) {
                if (book != null && book.getBookTitle().equalsIgnoreCase(titleOfBook) && !book.isCheckedOut()) {
                    System.out.println("If you would like to check out this book, please enter your name:");
                    String readersName = scanner.nextLine();

                    book.checkOut(readersName);
                    System.out.println("Thank you " + readersName + ", you have checked out your book.");
                    bookFound = true;
                    break;
                }
            }

            if (!bookFound) {
                System.out.println("Book not found.");
            }
        }
    }

    public static void displayCheckedOutBooks(Book[] books) { // Pass the bookArray as a parameter
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            boolean checkedOutBooks = false;

            for (Book book : books) { // Iterate over the bookArray
                if (book != null && book.isCheckedOut()) { // Check for null and checked out status
                    System.out.println("ID: " + book.getBookId() + ", Title: " + book.getBookTitle() + ", is checked out by: " + book.getCheckedOutTo());
                    checkedOutBooks = true;
                }
            }

            if (!checkedOutBooks) {
                System.out.println("No books have been checked out.");
                break;
            }

            System.out.println("If you'd like to check in a book, please enter the book ID. Or enter 0 to return back to The Neighborhood Library Home Screen");
            int bookID = scanner.nextInt();
            scanner.nextLine();

            if (bookID == 0) {
                exit = true;
            } else {
                boolean bookFound = false;
                for (Book book : books) {
                    if (book != null && book.getBookId() == bookID && book.isCheckedOut()) { // Check for null and checked out status
                        book.checkIn();
                        System.out.println("Thank you, book has been checked in.");
                        bookFound = true;
                        break;
                    }
                }

                if (!bookFound) {
                    System.out.println("No book found.");
                }
            }
        }
    }
}