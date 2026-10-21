package be.drone2.celleven;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("test voor het project celleven");
        Koppel koppel1 = new Koppel(0, 0);
        var koppel2 = new Koppel(1, 0);
       var koppel3 = new Koppel(0,1);
        var koppel4 = new Koppel(1, 1);
        Cel cel1 = new Cel(koppel1, 1);
        var cel2 = new Cel(koppel2, 1);
        var cel3 = new Cel(koppel3, 1);
        var cel4 = new Cel(koppel4,1);
        Leefwereld.RASTER.voegCelToe(cel1);
        Leefwereld.RASTER.voegCelToe(cel2);
        Leefwereld.RASTER.voegCelToe(cel3);
        Leefwereld.RASTER.voegCelToe(cel4);
         var min = Integer.MAX_VALUE;
          var max = Integer.MIN_VALUE;
           double gemiddelde = 0.00;
           int somAantalCellen = 0;
        for (int teller = 0; teller < 2000; teller++) {
          System.out.println();
          var aantalCellen = Leefwereld.RASTER.getCellen().size();
          somAantalCellen += aantalCellen;
          var vorigGetal = aantalCellen;
          if (teller != 0) {
            gemiddelde = (double)somAantalCellen/teller;
          }
         // int dummy = aantalCellen;   // doet absoluut niets
          if (aantalCellen < min) min = aantalCellen;
          if (aantalCellen > max) max =aantalCellen;
          if (vorigGetal != aantalCellen) {System.out.println("alarm, aantal cellen is aangepast");}
          System.out.println("cycle: " + teller + " aantal: " + aantalCellen + " min: " + min + " max: " + max + " gemiddelde: " + gemiddelde);
        //   System.out.println(Thread.currentThread().getName());
          if (aantalCellen == 0)  break;
    
            for (int j = 0; j < Leefwereld.RASTER.getLengte(); j++) {
                for (int i = 0; i < Leefwereld.RASTER.getLengte(); i++) {
                    System.out.print(Leefwereld.RASTER.getRasterveld()[i][j] == false ? " " : "O");
                }
                System.out.println();
            }
           Thread.sleep(100);
            System.out.println();
            Leefwereld.RASTER.volgendeStap();
        }
    }

}
