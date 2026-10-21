package be.drone2.celleven;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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

/*@GetMapping("/statistieken")
public List<StatPunt> statistieken() {
    return MyRunner.getHistoriek();
} */

}
