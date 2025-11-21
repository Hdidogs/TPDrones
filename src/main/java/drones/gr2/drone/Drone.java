package drones.gr2.drone;

import drones.gr2.exception.DroneException;
import drones.gr2.mission.Mission;
import drones.gr2.util.drone.MoveResult;
import drones.gr2.util.drone.Moving;
import drones.gr2.util.drone.Position;
import drones.gr2.util.drone.Rejected;

public class Drone {
    private String nom;
    private int altitudeMax;
    private Double vitesse;
    private Position position;
    private Position basePosition;
    private boolean goHome;

    public int getAutonomie() {
        return autonomie;
    }

    public void setAutonomie(int autonomie) {
        this.autonomie = autonomie;
    }

    public boolean isGoHome() {
        return goHome;
    }

    public Position getBasePosition() {
        return basePosition;
    }

    private int autonomie;

    public Boolean getMoving() {
        return isMoving;
    }

    public void setMoving(Boolean moving) {
        isMoving = moving;
    }

    private Boolean isMoving;

    public Drone(String nom, int altitudeMax, Double vitesse, Position position, int autonomie) {
        this.nom = nom;
        this.altitudeMax = altitudeMax;
        this.vitesse = vitesse;
        this.position = position;
        if(position.getZ()>altitudeMax)throw new DroneException("Le drone pas être créé avec une position qu'il ne peut atteindre");
        this.isMoving = false;
        this.autonomie = autonomie;
        this.basePosition = position;
        this.goHome = false;
    }

    public void setGoHome(boolean goHome) {
        this.goHome = goHome;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAltitudeMax() {
        return altitudeMax;
    }

    public void setAltitudeMax(int altitudeMax) {
        this.altitudeMax = altitudeMax;
    }

    public Double getVitesse() {
        return vitesse;
    }

    public void setVitesse(Double vitesse) {
        this.vitesse = vitesse;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public MoveResult goTo(Position positionfinal, Mission mission){
        if(this.position.distanceTo(positionfinal)>this.altitudeMax){
            Rejected rejected = new Rejected();
            return rejected;
        }
        Moving moving = new Moving(positionfinal, this, mission);
        return moving;
    }


}
