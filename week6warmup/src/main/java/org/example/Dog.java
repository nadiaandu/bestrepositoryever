package org.example;
public class Dog extends Animal {

    private String breed;

    public Dog(String name, String breed){
        // super refers to the parent class; take from parent class constructor
        // super has to be first
        super(name);
        this.breed = breed;
    }

   public void makeSound(){
       super.makeSound();
    }

    public void howl(){
        System.out.println("wooooooooooooo");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}

