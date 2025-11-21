package drones.gr2.mission;

import drones.gr2.drone.Drone;
import drones.gr2.exception.PathException;
import drones.gr2.util.drone.Path;
import drones.gr2.util.drone.Position;


public class Mission {

    private String name;
    private Path path;

    public Mission(String name, Path path, Drone drone) {
        this.name = name;
        this.path = path;
        this.drone = drone;
    }

    private Drone drone;

    public Boolean next(){
        if(this.path.getPotitions().size() <= 1)return MissionResult.KO.isValue();
        drone.setPosition(path.nextPosition());
        return  MissionResult.OK.isValue();
    }



}
