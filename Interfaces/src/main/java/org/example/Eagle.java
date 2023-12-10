package org.example;

public class Eagle extends Bird implements Fly { // use implement for interfaces
    // any method in the interface MUST be implemented by the class using it
    // interface is a contract - java won't let you compile without it
    @Override
    public void fly() { //interface enforces yo to use the fly method
        System.out.println("Eagle says Murica!");
    }

}
