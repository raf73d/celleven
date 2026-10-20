package be.drone2.celleven;

import java.util.HashSet;
import java.util.Set;

public enum Leefwereld {
    RASTER(10);

    private final int lengte;
    private boolean[][] rasterveld;
    private final Set<Observer> observers = new HashSet<>();

    private Leefwereld(int lengte) {
        this.lengte = lengte;
        this.rasterveld = new boolean[lengte][lengte];

    }

    public int getLengte() {
        return lengte;
    }

    public boolean[][] getRasterveld() {
        return rasterveld;
    }

    public boolean isLevend(Koppel koppel) {
        return rasterveld[koppel.getxPositie()][koppel.getyPositie()];
    }

    public void setLevend(Koppel koppel, boolean status) {
        rasterveld[koppel.getxPositie()][koppel.getyPositie()] = status;
    }

    void addObserver(Observer observer) {
        observers.add(observer);
    }

    void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }

    void volgendeStap () {
        System.out.println("hier is een cycle geeindigd!");
        notifyObservers();
    }

}
