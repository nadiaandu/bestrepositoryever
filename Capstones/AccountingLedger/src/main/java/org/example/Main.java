package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;


public class Main {

    // home screen display options
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

                    if (paymentAmount < 0) {
                        System.out.println("Invalid payment amount. Enter a positive amount");
                    } else if (paymentAmount > accountBalance) {
                        System.out.println("Insufficient funds. Your current balance is: $" + accountBalance);
                    } else {
                        accountBalance -= paymentAmount;
                        System.out.println("Payment of $" + paymentAmount + " made. Your new balance is: $" + accountBalance);
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

    // method created to give user ledger options
    private static void displayLedger(List<Transaction> ledger) {
        System.out.println("Your ledger options:");
        System.out.println("A) All - display all entries");
        System.out.println("D) Deposits");
        System.out.println("P) Payments");
        System.out.println("R) Reports");
        System.out.println("H) Return to Home");
        System.out.println("Please select from options given: ");

        Scanner scanner = new Scanner(System.in);
        String selection = scanner.nextLine().toUpperCase();

        switch (selection) {

            case "A":
                System.out.println("All entries:");
                for (Transaction entry : ledger) {
                    System.out.println(entry.getType() + " - Amount: $" + entry.getAmount() + " - Description:" + entry.getDescription());
                }
                break;

            case "D":
                System.out.println("Your Deposits:");
                for (Transaction entry : ledger) {
                    if (entry.getAmount() > 0) {
                        System.out.println(entry.getType() + " - Amount: $" + entry.getAmount() + " - Description:" + entry.getDescription());
                    }
                }
                break;

            case "P":
                System.out.println("Your payments:");
                for (Transaction entry : ledger) {
                    if (entry.getAmount() < 0) {
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

    // method created to give user report options
    private static void runReports(List<Transaction> ledger) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Reports Options:");
            System.out.println("1) Month to date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year to date");
            System.out.println("4) Previous year");
            System.out.println("5) Search by vendor");
            System.out.println("0) Go back to report page");

            System.out.println("Please select from provided options: ");
            String reportChoice = scanner.nextLine();

            switch (reportChoice) {

                case "1":
                    double monthToDate = calculateMonthToDate(ledger);
                    System.out.println("Month to date deposit: $" + monthToDate);
                    break;

                case "2":
                    double previousMonthDeposit = calculatePreviousMonth(ledger);
                    System.out.println("Previous month deposit: $" + previousMonthDeposit);
                    break;

                case "3":
                    double yearToDateDeposit = calculateYearToDate(ledger);
                    System.out.println("Year to date deposit: $" + yearToDateDeposit);
                    break;

                case "4":
                    double previousYearDeposit = calculatePreviousYear(ledger);
                    System.out.println("Previous year deposit: $" + previousYearDeposit);
                    break;

                case "5":
                    searchByVendor(ledger);
                    break;

                case "0":
                    return;

                default:
                    System.out.println("Invalid. Select from options provided.");
                    break;
            }
        }
    }

    // created a method to calculate the "Month to Date" deposit in reports
    private static double calculateMonthToDate(List<Transaction> ledger) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        double monthToDateDeposit = 0.0;

        for (Transaction entry : ledger) {
            Calendar entryDate = Calendar.getInstance();
            entryDate.setTimeInMillis(Long.parseLong(entry.getDate()));

            int entryYear = entryDate.get(Calendar.YEAR);
            int entryMonth = entryDate.get(Calendar.MONTH) + 1;

            if (currentYear == entryYear && currentMonth == entryMonth && entry.getAmount() > 0) {
                monthToDateDeposit += entry.getAmount();
            }
        }

        return monthToDateDeposit;
    }

    // created a method to calculate total deposits made in the previous month in reports
    private static double calculatePreviousMonth(List<Transaction> ledger) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);

        // calculating the month and year of the previous month
        int previousYear = currentYear;

        // minus one because it's the last month
        int previousMonth = currentMonth - 1;

        // if statement to correctly identify december as previous month (11) when starting from january (0)
        if (previousMonth < 0) {
            previousMonth = 11;
            previousYear--;
        }

        double previousMonthDeposit = 0.0;

        for (Transaction entry : ledger) {
            Calendar entryDate = Calendar.getInstance();
            entryDate.setTimeInMillis(Long.parseLong(entry.getDate()));

            int entryYear = entryDate.get(Calendar.YEAR);
            int entryMonth = entryDate.get(Calendar.MONTH);

            // adds transaction to calculation if it is a deposit from the same year and month as the previous month
            if (entryYear == previousYear && entryMonth == previousMonth && entry.getAmount() > 0) {
                previousMonthDeposit += entry.getAmount();

            }

        }
        return previousMonthDeposit;
    }

    // created a method to calculate the total deposits made from beginning of current year to current month in reports
    private static double calculateYearToDate(List<Transaction> ledger) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);

        double yearToDateDeposit = 0.0;

        for (Transaction entry : ledger) {
            Calendar entryDate = Calendar.getInstance();
            entryDate.setTimeInMillis(Long.parseLong(entry.getDate()));

            int entryYear = entryDate.get(Calendar.YEAR);
            int entryMonth = entryDate.get(Calendar.MONTH);

            if (entryYear == currentYear && entryMonth <= currentMonth && entry.getAmount() > 0) {
                yearToDateDeposit += entry.getAmount();
            }
        }
        return yearToDateDeposit;
    }

    // created a method to calculate total deposits made during previous year
    private static double calculatePreviousYear(List<Transaction> ledger) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        double previousYearDeposit = 0.0;

        for (Transaction entry : ledger) {
            Calendar entryDate = Calendar.getInstance();
            entryDate.setTimeInMillis(Long.parseLong(entry.getDate()));

            int entryYear = entryDate.get(Calendar.YEAR);

            // if statement necessary to check if a transaction is a deposit from the previous year
            if (entryYear == currentYear - 1 && entry.getAmount() > 0) {
                previousYearDeposit += entry.getAmount();
            }
        }
        return previousYearDeposit;
    }

    // created a method to search transactions through vendor name
    private static void searchByVendor(List<Transaction> ledger) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the vendor name to search by: ");
        String vendorName = scanner.nextLine();
        boolean found = false;
        System.out.println("Transactions by vendor: " + vendorName);

        for (Transaction entry : ledger) {
            if (entry.getVendor().equalsIgnoreCase(vendorName)) {
                System.out.println("Type: " + entry.getType() + ", Amount: $" + entry.getAmount() + ", Description: " + entry.getDescription());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No transactions found for vendor: " + vendorName);
        }
    }


}