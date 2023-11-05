package org.example;

public class Main {
    public static void main(String[] args) {

        Dealership dealership = new Dealership("Nadia's Special Dealership","1000 Rainbow Expy","2067778888");

        Vehicle vehicle1 = new Vehicle(1, 2023, "Toyota", "Camry", "Sedan", "Blue", 15000, 25000.0);
        Vehicle vehicle2 = new Vehicle(2, 2022, "Honda", "Civic", "Sedan", "Silver", 12000, 22000.0);
        Vehicle vehicle3 = new Vehicle(3, 2021, "Ford", "Escape", "SUV", "Red", 18000, 28000.0);
        Vehicle vehicle4 = new Vehicle(4, 2023, "Chevrolet", "Malibu", "Sedan", "White", 10000, 23000.0);
        Vehicle vehicle5 = new Vehicle(5, 2022, "Nissan", "Rogue", "SUV", "Black", 16000, 27000.0);

        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);
        dealership.addVehicle(vehicle3);
        dealership.addVehicle(vehicle4);
        dealership.addVehicle(vehicle5);
    }
}