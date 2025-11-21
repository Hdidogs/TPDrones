package drones.gr2.mission;

import drones.gr2.drone.Drone;
import drones.gr2.exception.PathException;
import drones.gr2.util.ActionResult;
import drones.gr2.util.KO;
import drones.gr2.util.OK;
import drones.gr2.util.drone.Path;
import drones.gr2.util.drone.Position;
import drones.gr2.util.mission.MissionNotStart;
import drones.gr2.util.mission.MissionStatut;


public class Mission {

    private String name;
    private Path path;
    private Drone drone;
    private MissionStatut statut;

    public Mission(String name, Path path) {
        this.name = name;
        this.path = path;
    }

    public ActionResult next() {
        try {
            drone.goTo(path.nextPosition());
        } catch (PathException e) {
            return new KO();
        }


        path.getPotitions().removeFirst();
        return new OK();
    }

    @Override
    public String toString() {
        return "Mission " + name + " statut : " + statut;
    }

    public String getName() {
        return name;
    }

}
