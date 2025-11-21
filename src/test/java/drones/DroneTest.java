package drones;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DroneTest {
    @Test
    void test1() {
        Position position = new Position(3,5,6);
        Position position2 = new Position(6,5,6);
        Double d = position.distanceTo(position2);
        assertEquals(1,d);
    }
}
