package drones.gr2.mission;

import java.util.ArrayList;
import java.util.Objects;

public class InMemoryAllMissions implements AllMissions {

    private ArrayList<Mission> allMission = new ArrayList<>();

    @Override
    public void add(Mission missions) {
        allMission.add(missions);
    }

    public ArrayList<Mission> all() {
        return allMission;
    }

    @Override
    public void remove(String name) {
        int index = -1;
        for (int i = 0; i < allMission.size(); i++) {
            if (Objects.equals(allMission.get(i).getName(), name)){
                index=i;
            }
        }
        this.allMission.remove(allMission.get(index));
    }
}
