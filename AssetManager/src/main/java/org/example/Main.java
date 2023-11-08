package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assetCollection = new ArrayList<>();

        House mansion = new House("luxury home", "02/14/2023", 2000000, "Waverly place rd", 3, 11111, 2);
        House highRise = new House("NYC loft", "08/12/199", 300000, "Riggly tin drive", 2, 2000, 3);
        Vehicle lambo = new Vehicle("black exterior red interior", "08/12/1999", 5555555, "lamborghini urus", 1, 100);
        Vehicle porsche = new Vehicle("porsche cayenne", "02/14/2022", 2222222, "porsche cayenne", 2, 200);

        assetCollection.add(mansion);
        assetCollection.add(highRise);
        assetCollection.add(lambo);
        assetCollection.add(porsche);

        for (Asset asset : assetCollection) {
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Acquisition Date: " + asset.getDateAcquired());
            System.out.println("Acquisition Cost: " + asset.getOriginalCost());
            System.out.println("Current Value: " + asset.getValue());

            if (asset instanceof House) {
                House house = (House) asset;
                System.out.println("Address: " + house.getAddress());
            }
            if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Year: " + vehicle.getYear());
                System.out.println("Make/Model: " + vehicle.getMakeModel());
            }

            System.out.println();
        }
    }
}

