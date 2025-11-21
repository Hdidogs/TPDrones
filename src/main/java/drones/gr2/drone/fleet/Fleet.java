package drones.gr2.drone.fleet;

import drones.gr2.drone.Drone;
import drones.gr2.mission.Mission;
import drones.gr2.util.ActionResult;
import drones.gr2.util.KO;
import drones.gr2.util.OK;
import drones.gr2.util.drone.Path;

import java.util.ArrayList;

public class Fleet {
    ArrayList<Drone> allDrones;
    ArrayList<Mission> allMissions;

    public void add(Drone drone) {
        allDrones.add(drone);
    }

    public ActionResult remove(Drone drone) {
        if (!allDrones.contains(drone)) return new KO();
        allDrones.remove(drone);
        return new OK();
    }

    public ActionResult plan(Path path, String missionName) {
        if (allDrones.size() <= allMissions.size()) return new KO();

        double bestDistance = allDrones.getFirst().getPosition().distanceTo(path.nextPosition());
        Drone bestDrone = allDrones.getFirst();

        for (Drone drone : allDrones) {
            double droneDistance = drone.getPosition().distanceTo(path.nextPosition());
            if (droneDistance < bestDistance) {
                bestDistance = droneDistance;
                bestDrone = drone;
            }
        }

        allMissions.add(new Mission(missionName, path, bestDrone));

        return new OK();
    }
}
