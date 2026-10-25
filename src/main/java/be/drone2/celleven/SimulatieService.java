package be.drone2.celleven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SimulatieService {
    private final List<StatPunt> historiek = new ArrayList<>();
    private final List<Cyclepunt> kolonie = new ArrayList<>();

    public void updatevpc (double vpc){
        Cel.setVerouderingPerCycle(vpc);
    }

    public void updatevpv (double vpv) {
        Cel.setVerouderingPerVoortplanting(vpv);
    }

    public void updatemaxleeftijd (double maxleeftijd) {
        Cel.setMaxLeeftijd(maxleeftijd);
    }

    public List<Cyclepunt> getKolonie() {
        simulatie();
       return kolonie;
    }

    private void simulatie(){
         kolonie.clear();
        historiek.clear();
      //  Leefwereld.RASTER.getCellen().clear();
           Leefwereld.RASTER.reset();
        Koppel koppel1 = new Koppel(4, 4);
        var koppel2 = new Koppel(5, 4);
        var koppel3 = new Koppel(4, 5);
        var koppel4 = new Koppel(5, 5);
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
            historiek.add(new StatPunt(teller, aantalCellen, min, max, gemiddelde));
            Set<Celpositie> celposities = Leefwereld.RASTER.getCellen()
            .stream()
            .map(cel -> new Celpositie(cel.getKoppel().getXPositie(), cel.getKoppel().getYPositie()))
            .collect(Collectors.toSet());
            kolonie.add(new Cyclepunt(teller, new HashSet<>(celposities)));
            if (aantalCellen == 0)
                break;
            Leefwereld.RASTER.volgendeStap();
        }
    

    }

    public List<StatPunt> getHistoriek() {
        
        simulatie();
        return historiek;
    }

}
