package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    @Test
    public void getVehicleValue() {
        // arrange
        Vehicle vehicle = new Vehicle("pink tesla", "02/22/22", 2000, "tesla G6", 1, 2);
        //act
        double expectedValue = 1940;
        var vehicleValue = vehicle.getValue();
        //assert
        assertEquals(expectedValue, vehicleValue);

    }


}