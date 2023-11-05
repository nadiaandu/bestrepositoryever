package org.example;

import java.util.List;
import java.util.Scanner;


public class UserInterface {
    public Dealership dealership;

    public void display() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.printf("Welcome to %s, the best place to buy a car", this.dealership.getName());
            System.out.println("Select from the following options:");
            System.out.println("0. Exit Program");
            System.out.println("1. View all Vehicles");
            System.out.println("2. Search for all vehicles by price");
            System.out.println("3. Search for vehicles by make/model");
            System.out.println("5. Search for vehicles by year");
            System.out.println("6. Search for vehicles by color");
            System.out.println("7. Search for vehicles by vehicle type");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove");

            int userInput = scanner.nextInt();

            switch (userInput) {

                case 0:
                    isRunning = false;
                    break;
                case 1:
                    dealership.getAllVehicles();
                    break;
                case 2:
                    dealership.getVehiclesByPrice();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option");
            }
            scanner.close();

            }

        }
    }
}