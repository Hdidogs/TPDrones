package drones.gr2.drone;

import drones.gr2.util.ActionResult;

import java.util.ArrayList;

public interface AllDrones {
    void remove(String name);

    void add(Drone drone);

    ArrayList<Drone> all();

    ActionResult findBy(String name);
}
