package drones.gr2.util.drone;

import drones.gr2.exception.PathException;

import java.util.ArrayList;

public class Path {
    private ArrayList<Position> potitions;

    public Path(ArrayList<Position> potitions) {
        this.potitions = potitions;
        if(potitions.size()< 2 )throw new PathException("Votre parcour ne peut pas être inferieur à 2 étapes");
    }

    public ArrayList<Position> getPotitions() {
        return potitions;
    }

    public Position nextPosition(){
        if(potitions.size()<=1) throw new PathException("Plus de position dans le parcours");

        return potitions.getFirst();
    }

    public Double distance(){
        double distance = 0.0;
        for(int i = 0; i< potitions.size() - 1 ; i++){
            distance += potitions.get(i).distanceTo(potitions.get(i+1));
        }

        return distance;
    }
}
