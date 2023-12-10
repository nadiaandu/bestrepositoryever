package org.example;

public class Main {
    public static void main(String[] args) {
        Dog fido = new Dog();
        fido.eat();
        fido.setName("Fido");
        fido.setNumberOfLegs(4);
        fido.setExteriorType(ExteriorType.FUR);

        Cat fluffy = new Cat();
        fluffy.eat();
        fluffy.setName("Fluffy");
        fluffy.setNumberOfLegs(3);
        fluffy.setExteriorType(ExteriorType.FUR);
        fluffy.meow();

    }
}