package org.example;

import java.lang.reflect.Type;
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
            System.out.printf("Welcome to goodcar, the best place to buy a car", this.dealership.getName());
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
            System.out.println("10. Sell/Lease a vehicle");

            int userInput = scanner.nextInt();

            switch (userInput) {

                case 0:
                    System.exit(0);
                    break;
                case 1:
                    listAllVehicles();
                    break;
                case 2:
                    searchByPrice();
                    break;
                case 3:
                    searchByMakeModel();
                    break;
                case 4:
                    searchByYear();
                    break;
                case 5:
                    searchByColor();
                    break;
                case 6:
                    searchByType();
                    break;
                case 7:
                    addVehicle();
                    break;
                case 8:
                    removeVehicle();
                    break;
                default:
                    System.out.println("Please select from options given!");
            }
            scanner.close();

        }
        // methods for user
    }

    private void listAllVehicles() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayFilteredVehicles(allVehicles);
    }

    private void displayFilteredVehicles(List<Vehicle> filteredVehicles) {
    }

    private void addVehicle() {
        System.out.println("Please answer the following to add a vehicle");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();
        System.out.print("Enter the vehicle's year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the vehicle's make: ");
        String make = scanner.nextLine();
        System.out.print("Enter the vehicle's model: ");
        String model = scanner.nextLine();
        System.out.print("Enter the vehicle type (car, truck, SUV, van): ");
        String vehicleType = scanner.nextLine();
        System.out.print("Enter the vehicle's color: ");
        String color = scanner.nextLine();
        System.out.print("Enter the vehicle's odometer: ");
        int odometer = scanner.nextInt();
        System.out.print("Enter the vehicle's price: ");
        double price = scanner.nextDouble();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicle);
        System.out.println("Successfully added!");
    }

    private void removeVehicle() {
        System.out.println("Please enter the VIN of the vehicle you want to remove:");
        Scanner scanner = new Scanner(System.in);
        int vinToRemove = scanner.nextInt();

        List<Vehicle> inventory = dealership.getAllVehicles();
        boolean removed = false;

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vinToRemove) {
                dealership.removeVehicle(vehicle);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Vehicle with VIN " + vinToRemove + " has been removed from the inventory.\n");
        } else {
            System.out.println("No vehicle found with VIN " + vinToRemove + " in the inventory.\n");
        }
    }

    private void searchByPrice() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your min price");
        double minPrice = userInput.nextDouble();
        System.out.println("Enter your max price");
        double maxPrice = userInput.nextDouble();

        List<Vehicle> filteredVehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayFilteredVehicles(filteredVehicles);
    }

    private void searchByMakeModel() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter make");
        String make = userInput.nextLine();
        System.out.println("Enter model");
        String model = userInput.nextLine();

        List<Vehicle> filteredVehicles = dealership.getVehiclesByMakeModel(make, model);
        displayFilteredVehicles(filteredVehicles);
    }

    private void searchByYear() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter min year");
        int minYear = userInput.nextInt();
        System.out.println("Enter max year");
        int maxYear = userInput.nextInt();

        List<Vehicle> filteredVehicles = dealership.getVehiclesByYear(minYear, maxYear);
        displayFilteredVehicles(filteredVehicles);
    }

    private void searchByColor() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter desired vehicle color");
        String color = userInput.nextLine();

        List<Vehicle> filteredVehicles = dealership.getVehiclesByColor(color);
        displayFilteredVehicles(filteredVehicles);
    }

    private void searchByType() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter desired vehicle type");
        String type = userInput.nextLine();


        List<Vehicle> filteredVehicles = dealership.getVehiclesByType(type);
        displayFilteredVehicles(filteredVehicles);
    }

    private void sellOrLeaseVehicle() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Are you selling or leasing?");
       // if () else


    }


}
