package drones.gr2.util.drone;

import drones.gr2.exception.PathException;

import java.util.ArrayList;

public class Path {
    public Path(ArrayList<Position> potitions) {
        this.potitions = potitions;
        if(potitions.size()< 2 )throw new PathException("Votre parcour ne peut pas être inferieur à 2 étapes");
    }

    public ArrayList<Position> getPotitions() {
        return potitions;
    }

    public void setPotitions(ArrayList<Position> potitions) {
        this.potitions = potitions;
    }

    private ArrayList<Position> potitions = new ArrayList<>();

    public Position nextPosition(){
        if(potitions.size()<=1) throw new PathException("Plus de position dans le parcours");
        potitions.remove(0);
        return potitions.get(0);
    }
}
