package org.example;

import java.util.Scanner;

public class Main {

    public static void listAllVehicles(){
        System.out.println("List of all vehicles: ");

        String[] vehicleArray;
        for (String vehicle : vehicleArray){
            System.out.println(vehicle);

        }
        public static void findVehiclesByPrice(){
            System.out.println("Find Vehicle By Price");


        }
    }

    public static void main(String[] args) {

 Vehicle [] vehicleArray = new Vehicle[20];

    vehicleArray[0] = new Vehicle(101121, "Ford Explorer","Red",45000,13500);
    vehicleArray[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
    vehicleArray[2] = new Vehicle(101123,"Chevrolet Malibu","Black", 50000, 9700);
    vehicleArray[3] = new Vehicle(101124,"Honda Civic", "White",70000,7500);
    vehicleArray[4] = new Vehicle(101125,"Subaru Outback", "Green",55000,14500);
    vehicleArray[5] = new Vehicle(101126,"Jeep Wrangler","Yellow",30000,16000);

    Scanner scanner = new Scanner(System.in);

    boolean isOnline = true;
    while(isOnline == true);{

            System.out.println("What do you want to do?");
            System.out.println("1 - List all vehicles");
            System.out.println("2 - Search by make/model");
            System.out.println("3 - Search by price range");
            System.out.println("4 - Search by color");
            System.out.println("5 - Add a vehicle");
            System.out.println("6 - Quit");
            System.out.println("Enter your command: ");

            int command = scanner.nextInt();
            switch(command){
                case 1:
                    listAllVehicles();
                    break;

                case 2:
                    findVehiclesByPrice();
                    break;

                case 3:





            }
        }


        System.out.println("What do you want to do?");
        System.out.println("1 - List all vehicles");
        System.out.println("2 - Search by make/model");
        System.out.println("3 - Search by price range");
        System.out.println("4 - Search by color");
        System.out.println("5 - Add a vehicle");
        System.out.println("6 - Quit");
        System.out.println("Enter your command: ");


    }
}