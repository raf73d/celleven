package be.drone2.celleven;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import be.StatPunt;

@Service
public class SimulatieService {
    private final List<StatPunt> historiek = new ArrayList<>();

    public List<StatPunt> getHistoriek() {
        Koppel koppel1 = new Koppel(0, 0);
        var koppel2 = new Koppel(1, 0);
        var koppel3 = new Koppel(0, 1);
        var koppel4 = new Koppel(1, 1);
        Cel cel1 = new Cel(koppel1, 1);
        var cel2 = new Cel(koppel2, 1);
        var cel3 = new Cel(koppel3, 1);
        var cel4 = new Cel(koppel4, 1);
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
            if (teller != 0) {
                gemiddelde = (double) somAantalCellen / teller;
            }
            if (aantalCellen < min)
                min = aantalCellen;
            if (aantalCellen > max)
                max = aantalCellen;
            System.out.println("cycle: " + teller + " aantal: " + aantalCellen + " min: " + min + " max: " + max
                    + " gemiddelde: " + gemiddelde);
            historiek.add(new StatPunt(teller, aantalCellen, min, max, gemiddelde));
            if (aantalCellen == 0)
                break;
            Leefwereld.RASTER.volgendeStap();
        }
        return historiek;
    }

}
