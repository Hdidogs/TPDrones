package drones.gr2.drone;

public interface AllDrones {
    void remove(String name);

    void add(Drone drone);

    void all();

    void findBy(String name);
}
