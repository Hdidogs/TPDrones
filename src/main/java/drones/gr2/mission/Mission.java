package drones.gr2.mission;

import drones.gr2.drone.Drone;
import drones.gr2.exception.PathException;
import drones.gr2.util.ActionResult;
import drones.gr2.util.KO;
import drones.gr2.util.OK;
import drones.gr2.util.drone.Path;

public class Mission {
    private String name;
    private Path path;
    private Drone drone;

    public Mission(String name, Path path, Drone drone) {
        this.name = name;
        this.path = path;
        this.drone = drone;
    }

    public ActionResult next() {
        if(path.getPotitions().size()<=1) return new KO();
        path.getPotitions().removeFirst();
        return new OK();
    }
}
