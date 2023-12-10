package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Eagle eagle = new Eagle();
        Pigeon pigeon = new Pigeon();
        Helicopter helicopter = new Helicopter();

        // they are inheriting from bird class the fly method
        // polymorphism:
        ArrayList<Fly> flyingObjects = new ArrayList<>();
        flyingObjects.add(eagle);
        flyingObjects.add(pigeon);
        flyingObjects.add(helicopter);

        for (Fly flyingThing : flyingObjects){
            flyingThing.fly();
        }



    }
}