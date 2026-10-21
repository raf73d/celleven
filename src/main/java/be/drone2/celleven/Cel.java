package be.drone2.celleven;

public class Cel implements Observer{

    private Koppel koppel;
    private double leeftijd;
    
    public Cel(Koppel koppel, double leeftijd) {
        this.koppel = koppel;
        this.leeftijd = leeftijd;
    }

    public Koppel getKoppel() {
        return koppel;
    }

    public void setKoppel(Koppel koppel) {
        this.koppel = koppel;
    }

    public double getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(double leeftijd) {
        this.leeftijd = leeftijd;
    }

    public void jaartjeOuder(){
        double leeftijd = getLeeftijd();
        setLeeftijd(leeftijd + 0.8);
    }

    public void leeftijdAanpassenNaVoortplanting(){
         double leeftijd = getLeeftijd();
         setLeeftijd(leeftijd + 1.7);
    }



    @Override
    public void update(Leefwereld leefwereld, int aantalCellenAanwezig) {
      //  System.out.println(Thread.currentThread().getName());
         jaartjeOuder();
         double correctie =
        aantalCellenAanwezig > 50 ? 4.9 :
        aantalCellenAanwezig > 30 ? 4.8 :
        aantalCellenAanwezig >= 28 ? 4.3 :
        aantalCellenAanwezig > 22 ? 4.2 :
        aantalCellenAanwezig > 20 ? 3.5 :
        aantalCellenAanwezig > 6 ? 1 : 0;

    if (getLeeftijd() >= (6-correctie)) {
        leefwereld.verwijderCel(this);
    }
      
    }

   

    

}
