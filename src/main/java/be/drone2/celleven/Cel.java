package be.drone2.celleven;

public class Cel {

    private Koppel koppel;
    private int leeftijd;
    
    public Cel(Koppel koppel, int leeftijd) {
        this.koppel = koppel;
        this.leeftijd = leeftijd;
    }

    public Koppel getKoppel() {
        return koppel;
    }

    public void setKoppel(Koppel koppel) {
        this.koppel = koppel;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    

}
