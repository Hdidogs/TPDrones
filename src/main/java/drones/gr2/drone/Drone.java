package drones.gr2.drone;

import drones.gr2.util.drone.Position;

public class Drone {
    private String nom;
    private int altitudeMax;
    private Double vitesse;
    private Position position;

    public Drone(String nom, int altitudeMax, Double vitesse, Position position) {
        this.nom = nom;
        this.altitudeMax = altitudeMax;
        this.vitesse = vitesse;
        this.position = position;
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


}
