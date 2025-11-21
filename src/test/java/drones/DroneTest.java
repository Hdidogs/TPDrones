package drones;

import drones.gr2.util.drone.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DroneTest {
    @Test
    void test1() {
        Position position = new Position(3,5,6);
        Position position2 = new Position(6,5,6);
        Double d = position.distanceTo(position2);
        assertEquals(3,d);
    }
    @Test
    void test() {
        Position position = new Position(6,5,6);
        Position position2 = new Position(6,5,6);
        Double d = position.distanceTo(position2);
        assertEquals(0,d);
    }
}
