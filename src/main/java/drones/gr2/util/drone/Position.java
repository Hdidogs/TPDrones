package drones.gr2.util.drone;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Position {
    private int x;
    private int y;
    private int z;

    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Double distanceTo(Position destination){
        return sqrt((destination.getX()-getX())*(destination.getX()-getX())+
                (destination.getY()-getY())*(destination.getY()-getY())+
                (destination.getZ()-getZ())*(destination.getZ()-getZ()));
    }
}
