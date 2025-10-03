package isp.lab3.exercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void testToString() {
        //        return model +"("  + type +  ") speed "+ String.valueOf(speed)  + "fuel Type"+ fuelType;
            Vehicle newVeh = new Vehicle("Dacia","Logan",150, 'B');
            assertEquals("Dacia (Logan) speed 150 fuel Type B", newVeh.toString());
    }
}