package org.example;

import java.util.List;
import java.util.Scanner;


public class UserInterface {
    public Dealership dealership;
    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

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
            System.out.println("4. Search for vehicles by year");
            System.out.println("5. Search for vehicles by color");
            System.out.println("6. Search for vehicles by vehicle type");
            System.out.println("7. Add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("0 Quit application");

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
                    dealership.getVehiclesByMakeModel();
                    break;
                case 4:
                    dealership.getVehiclesByYear();
                    break;
                case 5:
                    dealership.getVehiclesByColor();
                    break;
                case 6:
                    dealership.getVehiclesByType();
                    break;
                case 7:
                    dealership.addVehicle();
                    break;

                case 8:
                    dealership.removeVehicle();
                    break;
                default:
                    System.out.println();
            }
            scanner.close();

        }
        // methods for user





    }
}
