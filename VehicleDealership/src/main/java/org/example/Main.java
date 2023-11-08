package org.example;

//You have a good chunk of the program in, you just need to hook stuff up to your
//user interface where there's a switch case. My biggest piece of advice is to strictly
//follow the UML diagram. If it says to make a method with a certain name, do so. That's
//the point of the diagram. I think you're beginning to understand how classes work together
//but it'll take some more practice. Keep at it!
public class Main {
    public static void main(String[] args) {
        Dealership dealership = DealershipFileManager.getDealership();
        UserInterface userInterface = new UserInterface(dealership);
        userInterface.display();
    }
}