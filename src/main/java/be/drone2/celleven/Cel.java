package be.drone2.celleven;

public class Cel implements Observer{

    private Koppel koppel;
    private double leeftijd;
    private static double verouderingPerCycle;
    private static double verouderingPerVoortplanting;
    private static double maxLeeftijd;
    
    public Cel(Koppel koppel, double leeftijd) {
        this.koppel = koppel;
        this.leeftijd = leeftijd;
    }

    

    public static double getVerouderingPerCycle() {
        return verouderingPerCycle;
    }



    public static void setVerouderingPerCycle(double verouderingPerCycle) {
        Cel.verouderingPerCycle = verouderingPerCycle;
    }



    public static double getVerouderingPerVoortplanting() {
        return verouderingPerVoortplanting;
    }



    public static void setVerouderingPerVoortplanting(double verouderingPerVoortplanting) {
        Cel.verouderingPerVoortplanting = verouderingPerVoortplanting;
    }



    public static double getMaxLeeftijd() {
        return maxLeeftijd;
    }



    public  static void setMaxLeeftijd(double maxLeeftijd) {
        Cel.maxLeeftijd = maxLeeftijd;
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
        setLeeftijd(leeftijd + getVerouderingPerCycle());
    }

    public void leeftijdAanpassenNaVoortplanting(){
         double leeftijd = getLeeftijd();
         setLeeftijd(leeftijd + getVerouderingPerVoortplanting());
    }



    @Override
    public void update(Leefwereld leefwereld, int aantalCellenAanwezig) {
      //  System.out.println(Thread.currentThread().getName());
         jaartjeOuder();
         double correctie =
        aantalCellenAanwezig > 90 ? 4.9 :
        aantalCellenAanwezig > 85 ? 4.8 :
        aantalCellenAanwezig >= 80 ? 4.3 :
        aantalCellenAanwezig > 70 ? 4.2 :
        aantalCellenAanwezig > 60 ? 3.5 :
         aantalCellenAanwezig > 50 ? 3.0 :
        aantalCellenAanwezig > 40 ? 2.5 :
        aantalCellenAanwezig >= 30 ? 2.0 :
        aantalCellenAanwezig > 20 ? 1.6 :
        aantalCellenAanwezig > 10 ? 1.5 :
        aantalCellenAanwezig > 6 ? 1 : 0;

    if (getLeeftijd() >= (getMaxLeeftijd()-correctie)) {
        leefwereld.verwijderCel(this);
    }
      
    }

   

    

}
