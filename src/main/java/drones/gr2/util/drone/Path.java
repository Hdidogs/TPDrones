package drones.gr2.util.drone;

import drones.gr2.exception.PathException;

import java.util.ArrayList;

public class Path {
    private ArrayList<Position> potitions;

    public Path(ArrayList<Position> potitions) {
        this.potitions = potitions;
    }

    public ArrayList<Position> getPotitions() {
        return potitions;
    }

    public Position nextPosition(){
        if(potitions.size()<=1) throw new PathException("Plus de position dans le parcours");

        return potitions.getFirst();
    }
}
