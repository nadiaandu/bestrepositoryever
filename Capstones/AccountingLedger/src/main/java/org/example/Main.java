package org.example;

// import statements I used throughout

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Main {

    // starting with my file writer and try + catch
    public static void main(String[] args) throws IOException {

        // try catch matches unhandled exception given by file writer and file input stream
        try {
            // creating a new file
            File file = new File("src/main/resources/transactions.csv");

            boolean fileExists = file.exists();

            // if file does NOT exist it will create a "newTransactionWriter"  and adds header
            if (!fileExists) {
                FileWriter newTransactionWriter = new FileWriter("src/main/resources/transactions.csv");
                newTransactionWriter.write("Date|Time|Description|Vendor|Amount\n");
                newTransactionWriter.close();
            }
        } catch (IOException ex) {
            System.out.println("Could not find that path!");
        }
        try {
            // opens the file to read using fis and scanner then loops through to go line by line
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
            Scanner scanner = new Scanner(fileInputStream);
            boolean input;

            while (scanner.hasNextLine()) {
                input = scanner.hasNextLine();
                String line = scanner.nextLine();
                fileInputStream.close();
            }

        } catch (FileNotFoundException ex) {
            // if file not found it prints:
            System.out.println("Could not find that file.");

        } catch (IOException ex) {
            // if an issue with reading file occurs:
            System.out.println("Error occurred reading the file");
        }

        // displaying home screen options to user
        // created accountBalance to keep track of $ and array list called 'ledger' to store transactions

        Scanner scanner = new Scanner(System.in);
        double accountBalance = 0.0;
        List<Transaction> ledger = new ArrayList<>();

        // loop so options keep coming up until user presses X for exit

        while (true) {
            System.out.println("Home Screen Options:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger Screen");
            System.out.println("X) Exit");
            System.out.print("Please enter your choice: ");

            // converting user's input to uppercase very helpful
            // initializing variable choice to store option user chooses
            String choice = scanner.nextLine().toUpperCase();

            // switch statement to determine course of action based on user choice
            switch (choice) {
                case "D":
                    System.out.println("You selected 'Add Deposit'.");
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();

                    if (depositAmount < 0) {
                        System.out.println("Invalid deposit amount. Enter a positive amount.");
                    } else {
                        // if user enters a positive number, it will store to ledger and ask
                        // the following questions and store that info as well:

                        accountBalance += depositAmount;
                        System.out.println("Deposit of $" + depositAmount + " added. Your new balance is: $" + accountBalance);
                        System.out.print("Enter the date (e.g., 2023-10-25): ");
                        String date = scanner.nextLine();
                        System.out.print("Enter the time (e.g., 14:30): ");
                        String time = scanner.nextLine();
                        System.out.print("Enter the description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter the vendor: ");
                        String vendor = scanner.nextLine();

                        // Create a new Transaction object and add it to the ledger
                        Transaction newTransaction = new Transaction(date, time, description, vendor, depositAmount);
                        ledger.add(newTransaction);

                        // Save the transaction to the transactions csv file
                        saveTransactions(ledger);
                        System.out.println("Deposit successfully added. \n");
                    }
                    break;

                case "P":
                    System.out.println("You selected 'Make Payment (Debit)'.");
                    System.out.println("Enter your payment amount");

                    // created paymentAmount to store amount provided by the user
                    double paymentAmount = scanner.nextDouble();
                    scanner.nextLine();

                    if (paymentAmount < 0) {
                        System.out.println("Invalid payment amount. Enter a positive amount");

                        // my "something interesting" is that if the amount is larger than the account balance,
                        // we let the user know they have insufficient funds

                    } else if (paymentAmount > accountBalance) {
                        System.out.println("Insufficient funds. Your current balance is: $" + accountBalance);
                        // if the amount is NOT larger than the account balance, it will subtract from account balance
                        // then we prompt the user to obtain the additional details
                    } else {
                        accountBalance -= paymentAmount;
                        System.out.println("Payment of $" + paymentAmount + " made. Your new balance is: $" + accountBalance);
                        System.out.print("Enter the date (e.g., 2023-10-25): ");
                        String date = scanner.nextLine();
                        System.out.print("Enter the time (e.g., 14:30): ");
                        String time = scanner.nextLine();
                        System.out.print("Enter the description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter the vendor: ");
                        String vendor = scanner.nextLine();

                        // creating a transaction object and adding to ledger
                        Transaction newTransaction = new Transaction(date, time, description, vendor, -paymentAmount);
                        ledger.add(newTransaction);

                        // saving transactions to the file
                        saveTransactions(ledger);
                        System.out.println("Deposit successfully added. \n");
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

    // method created to give user ledger options when choice "L" is selected
    private static void displayLedger(List<Transaction> ledger) {
        System.out.println("Your ledger options:");
        System.out.println("A) All - display all entries");
        System.out.println("D) Deposits");
        System.out.println("P) Payments");
        System.out.println("R) Reports");
        System.out.println("H) Return to Home");
        System.out.println("Please select from options given: ");

        // taking user input and converting to upper case again
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.nextLine().toUpperCase();

        // switch statement for courses of action for each option
        switch (selection) {

            case "A":
                System.out.println("All entries:");
                for (Transaction entry : ledger) {
                    System.out.println(entry.getTime() + " - Amount: $" + entry.getAmount() + " - Description: " + entry.getDescription() + " - Vendor: " + entry.getVendor() + " - Date: " + entry.getDate());
                }
                break;

            case "D":
                System.out.println("Your Deposits:");
                for (Transaction entry : ledger) {
                    if (entry.getAmount() > 0) {
                        System.out.println(entry.getTime() + " - Amount: $" + entry.getAmount() + " - Description: " + entry.getDescription() + " - Vendor: " + entry.getVendor() + " - Date: " + entry.getDate());
                    }
                }
                break;

            case "P":
                System.out.println("Your payments:");
                for (Transaction entry : ledger) {
                    if (entry.getAmount() < 0) {
                        System.out.println(entry.getTime() + " - Amount: $" + entry.getAmount() + " - Description: " + entry.getDescription() + " - Vendor: " + entry.getVendor() + " - Date: " + entry.getDate());
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
        // loops options to user until they exit
        while (true) {
            System.out.println("Reports Options:");
            System.out.println("1) Month to date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year to date");
            System.out.println("4) Previous year");
            System.out.println("5) Search by vendor");
            System.out.println("0) Go back to report page");

            System.out.println("Please select from provided options: ");

            //stores user entry as "reportChoice"
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

        // using calendar object
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);

        // new variable to keep track of total deposits made in the current month
        double monthToDateDeposit = 0.0;

        // for loop that reads transaction date and converts it
        for (Transaction entry : ledger) {
            Calendar entryDate = Calendar.getInstance();

            // converts date from "entryDate" to long and sets timestamp
            entryDate.setTimeInMillis(Long.parseLong(entry.getDate()));

            // retrieving month and year that user enters
            // add one to the month since january = 0
            int entryYear = entryDate.get(Calendar.YEAR);
            int entryMonth = entryDate.get(Calendar.MONTH) + 1;

            // if the transaction is in the current month and is a deposit, it adds to the total (monthToDateDeposit)
            if (currentYear == entryYear && currentMonth == entryMonth && entry.getAmount() > 0) {
                monthToDateDeposit += entry.getAmount();
            }
        }
        return monthToDateDeposit;
    }

    // created a method to calculate total deposits made in the previous month in reports
    private static double calculatePreviousMonth(List<Transaction> ledger) {
        // using calendar object
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;

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

        // for loop that reads transaction date and converts it
        for (Transaction entry : ledger) {
            Calendar entryDate = Calendar.getInstance();
            entryDate.setTimeInMillis(Long.parseLong(entry.getDate()));

            int entryYear = entryDate.get(Calendar.YEAR);
            int entryMonth = entryDate.get(Calendar.MONTH) + 1;

            // adds transaction to calculation if it is a deposit from the same year and month as the previous month
            if (entryYear == previousYear && entryMonth == previousMonth && entry.getAmount() > 0) {
                previousMonthDeposit += entry.getAmount();

            }

        }
        return previousMonthDeposit;
    }

    // created a method to calculate the total deposits made from beginning of current year to current month in reports
    private static double calculateYearToDate(List<Transaction> ledger) {
        // using calendar object
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);

        // new variable to keep track of total deposits made in the current year
        double yearToDateDeposit = 0.0;

        // for loop that reads transaction date and converts it
        for (Transaction entry : ledger) {
            Calendar entryDate = Calendar.getInstance();
            entryDate.setTimeInMillis(Long.parseLong(entry.getDate()));

            // retrieving month and year that user enters
            // add one to the month since january = 0
            int entryYear = entryDate.get(Calendar.YEAR);
            int entryMonth = entryDate.get(Calendar.MONTH) + 1;

            // if the transaction is in the current year and is a deposit, it adds to the total (yearToDateDeposit)
            if (entryYear == currentYear && entryMonth <= currentMonth && entry.getAmount() > 0) {
                yearToDateDeposit += entry.getAmount();
            }
        }
        return yearToDateDeposit;
    }

    // created a method to calculate total deposits made during previous year
    private static double calculatePreviousYear(List<Transaction> ledger) {
        // calender object
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        // stores total of deposits for previous year
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

        // scanner to take user input for vendor name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the vendor name to search by: ");
        String vendorName = scanner.nextLine();

        // boolean tracks if vendor name was found
        boolean found = false;
        System.out.println("Transactions by vendor: " + vendorName);
        // loops through each transaction to find match
        for (Transaction entry : ledger) {
            if (entry.getVendor().equalsIgnoreCase(vendorName)) {
                // if match is found it will print:
                System.out.println(entry.getTime() + " - Amount: $" + entry.getAmount() + " - Description: " + entry.getDescription() + " - Vendor: " + entry.getVendor() + " - Date: " + entry.getDate());
                found = true;
            }
        }
        // if match not found it will print:
        if (!found) {
            System.out.println("No transactions found for vendor: " + vendorName);
        }
    }

    // method to display transactions
    private static void displayTransactions(List<Transaction> ledger) {
        System.out.println("List of Transactions:");

        if (ledger.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : ledger) {
                System.out.println("Date: " + transaction.getDate());
                System.out.println("Time: " + transaction.getTime());
                System.out.println("Description: " + transaction.getDescription());
                System.out.println("Vendor: " + transaction.getVendor());
                System.out.println("Amount: $" + transaction.getAmount());
                System.out.println(); // Add a newline for separation
            }
        }
    }


    // method to save transactions to file
    private static void saveTransactions(List<Transaction> ledger) throws IOException {
        try {
            File file = new File("src/main/resources/transactions.csv");

            boolean fileExists = file.exists();
            // if file does not exist it creates "newTransactionWriter" and adds header
            if (!fileExists) {
                FileWriter newTransactionWriter = new FileWriter("src/main/resources/transactions.csv");
                newTransactionWriter.write("Date|Time|Description|Vendor|Amount\n");
                newTransactionWriter.close();
            }
            // creating "appendTransactionWriter" in append mode to be able to add data
            FileWriter appendTransactionWriter = new FileWriter("src/main/resources/transactions.csv", true);

            // adds data to file
            for (Transaction transaction : ledger) {
                appendTransactionWriter.write(transaction.getDate() + "|" + transaction.getTime() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount() + "\n");
            }

            appendTransactionWriter.close();

        } catch (IOException ex) {
            System.out.println("Could not find that path!");
        }

    }
}

