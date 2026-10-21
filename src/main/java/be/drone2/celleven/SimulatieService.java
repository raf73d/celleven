package be.drone2.celleven;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import be.StatPunt;

@Service
public class SimulatieService {
    private final List<StatPunt> historiek = new ArrayList<>();
    public  List<StatPunt> getHistoriek (){
        return historiek;
    }

}
