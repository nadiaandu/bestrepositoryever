package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        // big decimal as a class
        // put value as a string for big decimal
        BigDecimal bd1 = new BigDecimal("100.5");
        BigDecimal bd2 = new BigDecimal("10.25");

        // functions
        BigDecimal sum = bd1.add(bd2);
        BigDecimal difference = bd1.subtract(bd2);
        BigDecimal product = bd1.multiply(bd2);

        BigDecimal quotient = bd1.divide(bd2, 2, BigDecimal.ROUND_HALF_UP);
        // scale = how many decimal places you want to see
        // when dealing w money you use BigDecimal
        // when not dealing w money double and float are fine
        // if working w doubles or floats avoid using the constructor
        // when it comes to money/ using doubles or floats use value of



        BigDecimal money1 = BigDecimal.valueOf(.3);
        BigDecimal money2 = BigDecimal.valueOf(.2);
        BigDecimal money3 = money1.subtract(money2);
        System.out.println(money3);

        // no more comparison operators(><) use "compare"
        // compare result gives 3 possible values back,
        // 1 - first num is bigger than the 2nd
        // -1 means the 1st num is less than the 2nd
        //  0 means they are equal

        int compareResult = bd1.compareTo(bd2);
        int compareResult2 = bd2.compareTo(bd1);
        System.out.println(compareResult);
        System.out.println(compareResult2);

        // rounding using BigDecimal

        BigDecimal weirdNumber = new BigDecimal("10.78659675675");

        BigDecimal roundedValue = weirdNumber.setScale(2, RoundingMode.HALF_UP);
        System.out.println(roundedValue);


//        // floating point number
//        float d1 = 0.3f;
//        float d2 = 0.2f;
//
//        float d3 = d1 - d2;
//        System.out.println(d3);


    }
}