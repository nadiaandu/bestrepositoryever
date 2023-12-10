package org.example;

public class Params {
    public static void main(String[] args) {
        // calling in the main method
        sayHi();

        // say something method requires string inside ()
        // whats inside () is called an argument

        saySomething("why are you stalking me?");
        saySomething("lets go shopping");

        printInfo("Bella", 22);

        System.out.println(add(8, 12));

        // another way to save multiple results
        int result1 = add(8, 12);
        int result2 = add(4, 20);
        int result3 = add(22, 22);

        // printing the results
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Result 3: " + result3);
    }

    // arguments are what changes in method call
    // method needs: keyword at front, name, (), and {}
    // implemented means code inside the curly braces
    // method doesn't need anything in the () and will work just fine

    public static void sayHi() {
        System.out.println("hi");
    }
    // easy way to print thru a method is telling method what to print then passing as a variable
    public static void saySomething(String s) {
        System.out.println(s);
    }
    // passing in multiple parameters of diff types
    // method parameters makes code clean and simple
    public static void printInfo(String name, int age) {
        System.out.println(name + " " + "is" + " " + age + " " + "years old");
    }
    // method that returns something ex (cant use void)
    public static int add(int x, int y) {
        return x + y;

    }
}
