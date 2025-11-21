package drones.gr2.util.drone;

import drones.gr2.drone.Drone;

public class Moving extends MoveResult implements Runnable {
    private Position destination;
    private int arriveAt;

    public Moving(Position destination, int arriveAt) {
        this.destination = destination;
        this.arriveAt = arriveAt;
    }


    @Override
    public void run() {
        int seconde=0;
        while(seconde==arriveAt){
            seconde++;
            try {Thread.sleep(1000);}
            catch (InterruptedException e) {}
        }
    }
}
