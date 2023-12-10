package org.example;

public class Pigeon extends Bird implements Fly{

    @Override
    public void fly() {
        System.out.println("Pigeon goes zoommm");
    }
}

