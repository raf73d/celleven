package be.drone2.celleven;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component 
public class MyRunner implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        int i = 0;
        System.out.println("test voor het project celleven");
        Koppel koppel1 = new Koppel(1, 1);
        var koppel2 = new Koppel(2,1);
        Cel cel1 = new Cel(koppel1, 0);
        var cel2 = new Cel(koppel2,0);
        var celCreatie = new CelCreatie();
        cel2.leeftijdAanpassenNaVoortplanting();
        System.out.println("leeftijd cel1 bij geboorte: " + cel1.getLeeftijd());
        var leefwereld = Leefwereld.RASTER;
        leefwereld.addObserver(cel1);
        leefwereld.addObserver(cel2);
         for (i = 0; i < 10; i++) {
        leefwereld.volgendeStap();

        System.out.println("leeftijd cel1 na gebeurtenis: " + cel1.getLeeftijd());
        System.out.println("status leefwereld cel1: " + Leefwereld.RASTER.isLevend(koppel1));
        System.out.println("status leefwereld cel2: " + Leefwereld.RASTER.isLevend(koppel2));
    
         }
         System.out.println("zijn cel1 en cel2 buren: " + celCreatie.creatieVoorwaardenCheck(cel1,cel2));
    }

}
