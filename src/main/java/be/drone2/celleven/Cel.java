package be.drone2.celleven;

public class Cel implements Observer{

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

    public void jaartjeOuder(){
        int leeftijd = getLeeftijd();
        setLeeftijd(leeftijd +1);
    }



    @Override
    public void update(Leefwereld leefwereld) {
        jaartjeOuder();
    }

    

}
