package drones.gr2.drone;

import drones.gr2.util.ActionResult;
import drones.gr2.util.Found;
import drones.gr2.util.NotFound;

import java.util.ArrayList;
import java.util.Objects;

public class InMemoryAllDrones implements AllDrones {
    private ArrayList<Drone> drones = new ArrayList<>();
    @Override
    public void remove(String name) {
        int index = -1;
        for (int i = 0; i < drones.size(); i++) {
            if (Objects.equals(drones.get(i).getNom(), name)){
                index=i;
            }
        }
        this.drones.remove(drones.get(index));
    }

    @Override
    public void add(Drone drone) {
        this.drones.add(drone);
    }

    @Override
    public ArrayList<Drone> all() {
        return drones;
    }

    @Override
    public ActionResult findBy(String name) {
        int index = -1;
        for (int i = 0; i < drones.size(); i++) {
            if(drones.get(i).getNom()==name){
                index=i;
            }
        }
        if(index == -1){
            return new NotFound();
        }else {
            return new Found();
        }
    }

}
