package drones.gr2.drone.fleet;

import drones.gr2.drone.Drone;
import drones.gr2.drone.InMemoryAllDrones;
import drones.gr2.mission.InMemoryAllMissions;
import drones.gr2.mission.Mission;
import drones.gr2.util.ActionResult;
import drones.gr2.util.KO;
import drones.gr2.util.OK;
import drones.gr2.util.drone.Path;
import drones.gr2.util.drone.Rejected;
import drones.gr2.util.mission.MissionInProgress;

import java.util.ArrayList;

public class Fleet {
    InMemoryAllDrones allDrones;
    InMemoryAllMissions allMissions;

    public void add(Drone drone) {
        allDrones.add(drone);
    }

    public ActionResult remove(Drone drone) {
        if (!allDrones.all().contains(drone)) return new KO();
        allDrones.all().remove(drone);
        return new OK();
    }

    public ActionResult plan(Path path, String missionName) {
        if (allDrones.all().size() <= allMissions.all().size()) return new KO();

        double bestDistance = allDrones.all().getFirst().getPosition().distanceTo(path.nextPosition());
        Drone bestDrone = allDrones.all().getFirst();

        for (Drone drone : allDrones.all()) {
            double droneDistance = drone.getPosition().distanceTo(path.nextPosition());
            if (droneDistance < bestDistance) {
                bestDistance = droneDistance;
                bestDrone = drone;
            }
        }

        allMissions.all().add(new Mission(missionName, path, bestDrone));

        return new OK();
    }

    public ActionResult move(String missionName) {
        Mission chooseMission = (Mission) allMissions.all().stream().filter(mission -> mission.getName().equals(missionName));

        if (chooseMission == null) return new KO();

        switch (chooseMission.next()) {
            case KO ko -> {
                return ko;
            }
            case OK ok -> {
                chooseMission.setStatut(new MissionInProgress());
                return ok;
            }
            default -> {
                return new KO();
            }
        }
    }

    public void reportMission(){
        for (int i = 0; i < allMissions.all().size(); i++) {
            System.out.println(allMissions.all().get(i).toString());
        }
    };

    public void reportDrones(){
        for (int i = 0; i < allDrones.all().size(); i++) {
            System.out.println(allDrones.all().get(i).toString());
        }
    };
}
