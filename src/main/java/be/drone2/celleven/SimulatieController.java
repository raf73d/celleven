package be.drone2.celleven;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.StatPunt;

@RestController
@RequestMapping("/simulatie")
public class SimulatieController {
    private final SimulatieService simulatieService;
    
 
 
public SimulatieController(SimulatieService simulatieService) {
        this.simulatieService = simulatieService;
    }

   @GetMapping("/statistieken")
public List<StatPunt> statistieken() {
    return simulatieService.getHistoriek();
} 

@PutMapping ("/verouderingpercycle")
void updatevpc (@RequestBody double vpc){
    simulatieService.updatevpc (vpc);
}
@PutMapping ("/verouderingpervoortplanting")
void updatevpv (@RequestBody double vpv){
    simulatieService.updatevpv (vpv);
}

@PutMapping ("/maxleeftijd")
void updatemaxleeftijd (@RequestBody double maxleeftijd){
    simulatieService.updatemaxleeftijd (maxleeftijd);
}

@GetMapping("/verouderingpervoortplanting")
public double getVpcv() {
    return Cel.getVerouderingPerVoortplanting();
}

@GetMapping("/verouderingpercycle")
public double getVpc() {
    return Cel.getVerouderingPerCycle();
}
/*@GetMapping("/statistieken")
public List<StatPunt> statistieken() {
    return MyRunner.getHistoriek();
} */

}
