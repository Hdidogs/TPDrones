package drones.gr2.util.drone;

import drones.gr2.drone.Drone;
import drones.gr2.mission.Mission;

public class Moving extends MoveResult implements Runnable {
    private Position destination;
    private int arriveAt;
    private Drone drone;
    private Mission mission;

    public Moving(Position destination, Drone drone, Mission mission) {
        this.mission = mission;
        this.destination = destination;
        this.arriveAt = (int) (destination.distanceTo(drone.getPosition()) * drone.getVitesse());
        this.drone = drone;
    }


    @Override
    public void run() {
        int second=0;
        while(second==arriveAt){
            if (drone.isGoHome()) {
                this.destination = drone.getBasePosition();
                this.arriveAt = (int) (this.destination.distanceTo(drone.getPosition()) * drone.getVitesse());
                second = 0;
            }

            second++;
            try {Thread.sleep(1000);}
            catch (InterruptedException e) {}
        }

        drone.setPosition(destination);
        drone.setMoving(false);
        this.mission.next();
    }
}
