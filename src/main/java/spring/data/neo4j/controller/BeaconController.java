package spring.data.neo4j.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.data.neo4j.model.Adjacent;
import spring.data.neo4j.model.Beacon;
import spring.data.neo4j.services.AdjacentService;
import spring.data.neo4j.services.BeaconService;

import java.util.List;

@RestController
@RequestMapping("/")
public class BeaconController {

    private final BeaconService beaconService;
    private final AdjacentService adjacentService;

    public BeaconController(BeaconService beaconService, AdjacentService adjacentService) {
        this.beaconService = beaconService;
        this.adjacentService = adjacentService;
    }

//    @GetMapping("/test")
//    public UserQueryResult getB(){
//        return beaconService.findBeacon();
//    }

    @GetMapping("/test2")
    public List<Beacon> getBB(){
        return beaconService.findS();
    }

    @GetMapping("/test3")
    public List<Adjacent> getR(){
        return beaconService.findAdj();
    }

    @GetMapping("/test4")
    public Adjacent getRR(){
        return adjacentService.findAdjj();
    }
}
