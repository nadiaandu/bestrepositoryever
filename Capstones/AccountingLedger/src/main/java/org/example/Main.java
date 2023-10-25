package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double accountBalance = 100.0;
        List<Transaction> ledger = new ArrayList<>();

        while (true) {
            System.out.println("Home Screen Options:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger Screen");
            System.out.println("X) Exit");
            System.out.print("Please enter your choice: ");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "D":
                    System.out.println("You selected 'Add Deposit'.");
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();

                    if (depositAmount < 0) {
                        System.out.println("Invalid deposit amount. Enter a positive amount.");
                    } else {
                        accountBalance += depositAmount;
                        System.out.println("Deposit of $" + depositAmount + " added. Your new balance is: $" + accountBalance);
                    }
                    break;

                case "P":
                    System.out.println("You selected 'Make Payment (Debit)'.");
                    System.out.println("Enter your payment amount");
                    double paymentAmount = scanner.nextDouble();
                    scanner.nextLine();

                    if(paymentAmount < 0) {
                        System.out.println("Invalid payment amount. Enter a positive amount");
                    }else if (paymentAmount > accountBalance) {
                        System.out.println("Insufficient funds. Your current balance is: $" + accountBalance);
                    }else{
                        accountBalance -= paymentAmount;
                        System.out.println("Payment of $" + paymentAmount + " made. Your new balance is: $" + accountBalance );
                    }

                    break;

                case "L":
                    System.out.println("You selected 'Ledger Screen'.");
                   displayLedger(ledger);

                    break;

                case "X":
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }


private static void displayLedger(List <Transaction> ledger){
    System.out.println("Your ledger options:");
    System.out.println("A) All - display all entries");
    System.out.println("D) Deposits");
    System.out.println("P) Payments");
    System.out.println("R) Reports");
    System.out.println("H) Return to Home");
    System.out.println("Please select from options given: ");

    Scanner scanner = new Scanner(System.in);
    String selection = scanner.nextLine().toUpperCase();

    switch (selection){

        case "A":
            System.out.println("All entries:");
            for(Transaction entry : ledger){
                System.out.println(entry.getType() + " - Amount: $" + entry.getAmount() + " - Description:" + entry.getDescription());
            }
            break;

        case "D":
            System.out.println("Your Deposits:");
            for(Transaction entry : ledger){
                if(entry.getAmount() > 0){
                    System.out.println(entry.getType() + " - Amount: $" + entry.getAmount() + " - Description:" + entry.getDescription());
                }
            }
            break;

        case "P":
            System.out.println("Your payments:");
            for(Transaction entry : ledger){
                if(entry.getAmount() < 0) {
                    System.out.println(entry.getType() + " - Amount: $" + entry.getAmount() + " - Description:" + entry.getDescription());
                }
            }
            break;

        case "R":
            System.out.println("Your reports:");
            runReports(ledger);
            break;

        case "H":
            System.out.println("You are returning to the home screen.");
            break;

        default:
            System.out.println("Invalid choice. Try choosing from options provided.");
            break;





    }

}

private static void runReports(List <Transaction> ledger){
Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Reports Options:");
            System.out.println("1) Month to date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year to date");
            System.out.println("4) Previous year");
            System.out.println("5) Search by vendor");
            System.out.println("0) Go back to report page");

            System.out.println("Please select from provided options: ");
            String reportChoice = scanner.nextLine();

            switch(reportChoice){
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "0":
                    return;
                default:
                    System.out.println("Invalid. Select from options provided.");
                    break;

            }




    }
}




}