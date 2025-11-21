package drones.gr2.mission;

import drones.gr2.util.drone.Path;

import drones.exception.PathException;

public class Mission {

    private String name;
    private Path path;

    public Mission(String name, Path path, Drone drone) {
        this.name = name;
        this.path = path;
        this.drone = drone;
    }

    private Drone drone;

    public void  next(){
        if(this.path.getPotitions().size() <= 1)throw new PathException("Plus de position dans le parcours");
        drone.setPosition(path.nextPosition());
    }



}
