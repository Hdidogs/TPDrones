package drones;

import drones.exception.PathException;

import java.text.ParseException;
import java.util.ArrayList;

public class Path {
    public Path(ArrayList<Position> potitions) {
        this.potitions = potitions;
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
