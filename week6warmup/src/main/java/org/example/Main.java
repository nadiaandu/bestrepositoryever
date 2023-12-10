package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animalList = new ArrayList<>();
        ArrayList<Dog> dogList = new ArrayList<>();
        ArrayList<Cat> catList = new ArrayList<>();

        Dog dog = new Dog("Rori", "Golden retriever");
        Cat cat = new Cat("Binky");

        //able to switch child class out with each-other as long as they inherit from the parent class
        animalList.add(cat);
        animalList.add(dog);

        Animal newAnimal = new Dog("fluffy", "shih tzu");
        newAnimal.makeSound();
        // only stuff in animal class will be available as methods

        // how to differentiate if it's a cat or dog
        // looping thru each animal in the list, using casting to see if it's a cat or dog
        // instance of tells you if its of that class
        // unless you cast java won't make the assumption
        // each variable has multiple shapes/faces

        animalList.add(newAnimal);
        for (Animal animal : animalList) {
            if (animal instanceof Dog) {
                //casting: using a dog only method
                // telling to treat it like its form the dog class
                ((Dog) animal).howl();
            }
            else{
                ((Cat)animal).makeSound();
            }

        }
    }
}