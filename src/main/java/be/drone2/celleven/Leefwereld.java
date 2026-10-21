package be.drone2.celleven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
public enum Leefwereld {
    RASTER(10);

    private final int lengte;
    private boolean[][] rasterveld;
    private final Set<Observer> observers = new LinkedHashSet<>();
    private final Set<Cel> cellen = new LinkedHashSet<>();

    public void voegCelToe(Cel cel) {
        cellen.add(cel);
        addObserver(cel);
        setLevend(cel.getKoppel(), true);
    }

    public void verwijderCel(Cel cel) {
        cellen.remove(cel);
        removeObserver(cel);
        setLevend(cel.getKoppel(), false);
    }

    public Set<Cel> getCellen() {
        return Collections.unmodifiableSet(cellen);
    }

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
     int aantalCellenAanwezig = cellen.size();
    Set<Observer> kopie = new LinkedHashSet<>(observers);
    kopie.forEach(observer -> observer.update(this, aantalCellenAanwezig));
}

    void volgendeStap() {

        notifyObservers();

        CelCreatie creator = new CelCreatie();

        List<Cel> lijst = new ArrayList<>(cellen);

        for (int i = 0; i < lijst.size(); i++) {
            for (int j = i + 1; j < lijst.size(); j++) {

                Cel cel1 = lijst.get(i);
                Cel cel2 = lijst.get(j);

                if (creator.creatieVoorwaardenCheck(cel1, cel2)) {
                    creator.maakNieuweCel(cel1, cel2);
                    cel1.leeftijdAanpassenNaVoortplanting();
                    cel2.leeftijdAanpassenNaVoortplanting();
                }
            }
        }
    }

}
