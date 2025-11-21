package drones.gr2.drone;

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
        this.drones.add(drones.get(index));
    }

    @Override
    public void add(Drone drone) {
        this.drones.add(drone);
    }

    @Override
    public void all() {
        for (int i = 0; i < drones.size(); i++) {
            System.out.println("name :"+ drones.get(i).getNom()+
                    " Vitesse :"+drones.get(i).getVitesse()+
                    "Position :"+ drones.get(i).getPosition().getX()+", "+
                    drones.get(i).getPosition().getY()+", "+
                    drones.get(i).getPosition().getZ());
        }
    }

    @Override
    public void findBy(String name) {
        int index = -1;
        for (int i = 0; i < drones.size(); i++) {
            if(drones.get(i).getNom()==name){
                index=i;
            }
        }

    }

}
