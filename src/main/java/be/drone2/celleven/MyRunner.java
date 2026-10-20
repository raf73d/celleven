package be.drone2.celleven;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component 
public class MyRunner implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        System.out.println("test voor het project celleven");
        Koppel koppel1 = new Koppel(0, 0);
        Cel cel1 = new Cel(koppel1, 0);
        System.out.println("leeftijd cel1 bij geboorte: " + cel1.getLeeftijd());
        var leefwereld = Leefwereld.RASTER;
        leefwereld.addObserver(cel1);
        leefwereld.volgendeStap();
        
        System.out.println("leeftijd cel1 na gebeurtenis: " + cel1.getLeeftijd());
    
    }

}
