package drones;

import drones.gr2.drone.Drone;
import drones.gr2.exception.PathException;
import drones.gr2.mission.Mission;
import drones.gr2.util.drone.Path;
import drones.gr2.util.drone.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MissionTest {

    @Test
    void nextPositionWhenPathHaveMostValue(){
        ArrayList<Position> paths = new ArrayList<Position>();
        Position position = new Position(2,3,3);
        Position position1 = new Position(1,3,2);
        Position position2 = new Position(2,3,3);
        paths.add(position);
        paths.add(position1);
        paths.add(position2);
        Path path = new Path(paths);

        var result = path.nextPosition();

        assertEquals(position1,result);
    }

    @Test
    void nextPositionWhenPathHaveMostValueChange(){
        ArrayList<Position> paths = new ArrayList<Position>();
        Position position = new Position(2,3,3);
        Position position1 = new Position(1,3,2);
        Position position2 = new Position(2,3,3);
        Position position3 = new Position(6,3,3);
        paths.add(position);
        paths.add(position1);
        paths.add(position2);
        paths.add(position3);
        Path path = new Path(paths);
        path.nextPosition();
        path.nextPosition();
        var result = path.nextPosition();

        assertEquals(position3,result);
    }

    @Test
    void nextPositionWhenPathIsNull(){
        ArrayList<Position> paths = new ArrayList<Position>();
        Path path = new Path(paths);

        assertThrows(PathException.class,
                ()-> path.nextPosition());
    }

    @Test
    void nextPositionWhenPathHaveOnlyOneValue(){
        ArrayList<Position> paths = new ArrayList<Position>();
        Position position3 = new Position(6,3,3);
        paths.add(position3);
        Path path = new Path(paths);

        assertThrows(PathException.class,
                ()-> path.nextPosition());
    }


    @Test
    void nextWhenPathHaveMostValue(){
        ArrayList<Position> paths = new ArrayList<Position>();
        Position position = new Position(2,3,3);
        Position position1 = new Position(1,3,2);
        Position position2 = new Position(2,3,3);
        Position position3 = new Position(6,3,3);
        paths.add(position);
        paths.add(position1);
        paths.add(position2);
        Drone drone = new Drone("Drone",20,10.5,position3);
        Path path = new Path(paths);
        Mission mission = new Mission("Mission 1 ",path,drone);
        var result = mission.next();

        assertEquals(true,result);
    }

    @Test
    void nextWhenPathHaveNotValue(){
        ArrayList<Position> paths = new ArrayList<Position>();
        Position position3 = new Position(6,3,3);
        Drone drone = new Drone("Drone",20,10.5,position3);
        Path path = new Path(paths);
        Mission mission = new Mission("Mission 1 ",path,drone);
        var result = mission.next();

        assertEquals(false,result);
    }




}
