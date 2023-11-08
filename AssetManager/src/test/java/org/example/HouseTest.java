package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {
    @Test
    //given a house that is 1000 sq ft and has a lot size
    // of 1000 w a quality of 1 expectation is 180250
    public void getHouseValue() {

        //arrange
        House house = new House("Vacation home", "11/11/11", 22222, "10001 wizard way", 1, 1000, 1000);
        //act
        double expectedValue = 1000 * 180 + (.25 * 1000);
        double houseValue = house.getValue();

        //assert
        assertEquals(expectedValue, houseValue);

    }

}

