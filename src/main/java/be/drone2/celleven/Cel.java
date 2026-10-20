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

    public void leeftijdAanpassenNaVoortplanting(){
         int leeftijd = getLeeftijd();
         setLeeftijd(leeftijd + 1);
    }



    @Override
    public void update(Leefwereld leefwereld) {
         jaartjeOuder();
         int correctie =0;
         if (Leefwereld.RASTER.getCellen().size() > 15) {
            correctie = 1;
         } 
          if (Leefwereld.RASTER.getCellen().size() > 16) {
            correctie = 2;
         } 
         if (Leefwereld.RASTER.getCellen().size() > 17) {
            correctie = 3;
         } 
         if (Leefwereld.RASTER.getCellen().size() > 19) {
            correctie = 5;
         } 
         if (Leefwereld.RASTER.getCellen().size() > 18) {
            correctie = 4;
         } 
          if (Leefwereld.RASTER.getCellen().size() <= 15) {
            correctie = 0;
         } 

    if (getLeeftijd() >= (6-correctie)) {
        leefwereld.verwijderCel(this);
    }
      
    }

    

}
