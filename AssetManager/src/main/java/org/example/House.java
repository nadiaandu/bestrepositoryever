package org.example;

import org.w3c.dom.ls.LSOutput;

public class House extends Asset {

    public String address;
    public int condition;
    public int squareFoot;
    public int lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        if (condition < 1 || condition > 4) {
            throw new IllegalArgumentException("1-4 please");
        }
        this.condition = condition;
    }


    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
@Override
    public double getValue() {
        switch (condition) {
            case 1: {
                return (180 * this.squareFoot) + (0.25 * squareFoot);
            }
            case 2: {
                return( 130 * this.squareFoot) + (0.25 * squareFoot);
            }
            case 3: {
                return (90 * this.squareFoot )+ (0.25 * squareFoot);
            }
            case 4: {
                return( 80 * this.squareFoot )+ (0.25 * squareFoot);
            }
            default: {
                throw new IllegalArgumentException("Condition must be 1-4");
            }

        }
    }
}