package drones.gr2.util.drone;

import drones.exception.PathException;

import java.util.ArrayList;

public class Path {
    public Path(ArrayList<Position> potitions) {
        this.potitions = potitions;
    }

    private ArrayList<Position> potitions = new ArrayList<>();

    public Position nextPosition(){
        if(potitions.size()<=1) throw new PathException("Plus de position dans le parcours");
        potitions.remove(0);
        return potitions.get(0);
    }
}
